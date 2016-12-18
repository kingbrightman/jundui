package org.yxm.jundui.web.controller;

import com.sun.xml.internal.messaging.saaj.soap.GifDataContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.*;
import org.yxm.jundui.service.*;
import org.yxm.jundui.util.ArrayUtils;
import org.yxm.jundui.util.GradeLevelUtil;
import org.yxm.jundui.web.dto.GradeSelectDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yxm on 2016.11.28.
 */
@Controller
@RequestMapping("/admin/grade")
public class GradeController {

    @Autowired
    TrainService trainService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    UserService userService;
    @Autowired
    GradeService gradeService;
    @Autowired
    GroupService groupService;
    @Autowired
    GradeLevelService gradeLevelService;

    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request) {
        GradeSelectDto gradeSelectDto = (GradeSelectDto) request.getSession().getAttribute(Constants.GRADE_SELECT);

        initSortAndOrder(request);

        if (gradeSelectDto == null) {
            gradeSelectDto = new GradeSelectDto();
        }
        model.addAttribute(Constants.GRADE_SELECT, gradeSelectDto);

        initListDatas(gradeSelectDto, model);

        return "grade/list";
    }

    //TODO:sort 单独处理
    @RequestMapping(value = "/list_sort")
    public String list_sort(Model model, HttpServletRequest request) {
        GradeSelectDto gradeSelectDto = (GradeSelectDto) request.getSession().getAttribute(Constants.GRADE_SELECT);

        // 添加sort和order，到分页查询依然有效
        String sort = SystemContext.getSort();
        String order = SystemContext.getOrder();
        request.getSession().setAttribute(Constants.GRADE_SORT, sort);
        request.getSession().setAttribute(Constants.GRADE_ORDER, order);


        if (gradeSelectDto == null) {
            gradeSelectDto = new GradeSelectDto();
        }
        model.addAttribute(Constants.GRADE_SELECT, gradeSelectDto);

        initListDatas(gradeSelectDto, model);

        return "grade/list";
    }

    /**
     * form提交上来需要改变参数的请求
     */
    @RequestMapping(value = "/list_select")
    public String list_select(Model model, HttpServletRequest request, GradeSelectDto gradeSelectDto) {
        Integer[] gids = gradeSelectDto.getGids();
        // 添加子团体
        if (gids != null && gids.length > 0) {
            gids = ArrayUtils.list2Array(groupService.listGroupsChildrenIds(Arrays.asList(gids)));
            gradeSelectDto.setGids(gids);
        }

        //保存上一次的查询数据，分页查询依然有效
        request.getSession().setAttribute(Constants.GRADE_SELECT, gradeSelectDto);

        initListDatas(gradeSelectDto, model);

        return "grade/list";
    }

    // 装配sort和order
    private void initSortAndOrder(HttpServletRequest request) {
        // 如果session中又sort,则直接装配道systemcontext中
        String sort = (String) request.getSession().getAttribute(Constants.GRADE_SORT);
        String order = (String) request.getSession().getAttribute(Constants.GRADE_ORDER);
        SystemContext.setSort(sort);
        SystemContext.setOrder(order);
    }

    // 生成list所需要的数据
    private void initListDatas(GradeSelectDto gradeSelectDto, Model model) {
        Integer[] tids = gradeSelectDto.getTids();
        Integer[] sids = gradeSelectDto.getSids();
        Integer[] uids = gradeSelectDto.getUids();
        Integer[] gids = gradeSelectDto.getGids();

        Pager<Grade> datas = gradeService.findGradeByContents(tids, sids, uids, gids);
        // 重新填入数据
        model.addAttribute("datas", datas);
        // 避免一次请求，多次查询都使用排序关键字
        SystemContext.removeOrder();
        SystemContext.removeSort();

        List<Group> groups = groupService.list();
        model.addAttribute("groups", groups);

        List<User> users = userService.list();
        model.addAttribute("users", users);

        List<Train> trains = trainService.list();
        model.addAttribute("trains", trains);

        List<Subject> subjects = subjectService.list();
        model.addAttribute("subjects", subjects);
    }

    @RequestMapping(value = "/update/{tid}/{sid}")
    public String update(@PathVariable int tid, @PathVariable int sid, Model model) {
        Train train = trainService.load(tid);
        model.addAttribute(train);
        Subject subject = subjectService.load(sid);
        model.addAttribute(subject);

        initGradesContrainsNull(tid, sid, model);
        return "grade/update";
    }

    @RequestMapping(value = "/update/{tid}/{sid}", method = RequestMethod.POST)
    public String update(@PathVariable int tid, @PathVariable int sid, Model model,
                         @RequestParam("uid") List<Integer> ids,
                         @RequestParam("content") List<String> contents) {
        GradeLevel level = gradeLevelService.load(sid);
        if (level == null) {
            throw new CmsException("提交成绩时会自动计算成绩等级，请先训练科目中填写成绩计算方式");
        }
        Subject subject = subjectService.load(sid);

        for (int i = 0; i < ids.size(); i++) {
            User user = userService.load(ids.get(i));
            Grade grade = gradeService.load(tid, sid, user.getId());


            if (grade != null) {
                grade.setContent(contents.get(i));
                grade.setScore(caculateScore(subject.getType(), contents.get(i), level));
            } else {
                throw new CmsException("计算成绩出错！");
            }
            gradeService.update(grade);
        }
        return "redirect:/admin/train/show/" + tid;
    }

    @RequestMapping(value = "/update_grade/{gid}", method = RequestMethod.GET)
    public String updateGrade(@PathVariable int gid, Model model) {
        Grade grade = gradeService.load(gid);
        model.addAttribute("grade", grade);
        return "grade/edit";
    }

    @RequestMapping(value = "/update_grade/{gid}", method = RequestMethod.POST)
    public String updateGrade(Grade grade, @PathVariable int gid, Model model) {
        System.out.println("grade:" + grade);
        if (grade.getContent() == null) {
            return "grade/edit";
        }
        Grade oldGrade = gradeService.load(gid);

        Subject subject = oldGrade.getSubject();
        String score = caculateScore(subject.getType(), grade.getContent(), gradeLevelService.load(subject.getId()));

        oldGrade.setContent(grade.getContent());
        oldGrade.setScore(score);
        gradeService.update(oldGrade);
        return "redirect:/admin/grade/list";
    }

    @RequestMapping(value = "/delete/{gid}")
    public String delete(@PathVariable int gid) {
        gradeService.delete(gid);
        return "redirect:/admin/grade/list";
    }

    @RequestMapping(value = "/show_subject_train_grades/{tid}/{sid}")
    public String showSubjectTrainGrades(@PathVariable int tid, @PathVariable int sid, Model model) {
        Train train = trainService.load(tid);
        model.addAttribute(train);
        Subject subject = subjectService.load(sid);
        model.addAttribute(subject);

        initGradesContrainsNull(tid, sid, model);
        return "grade/show_subject_train_grades";
    }

    @RequestMapping(value = "/show_user_train_grades/{tid}/{uid}")
    public String showUserTrainGrades(@PathVariable int tid, @PathVariable int uid, Model model) {
        Train train = trainService.load(tid);
        model.addAttribute(train);
        User user = userService.load(uid);
        model.addAttribute(user);

        Pager<Grade> datas = gradeService.findGradeByContent(tid, null, uid);
        model.addAttribute("datas", datas);

        return "grade/show_user_train_grades";
    }

    //获得所有参加训练该项目的所有成员的成绩，包括空
    private void initGradesContrainsNull(int tid, int sid, Model model) {
        List<Integer> groupIds = trainService.listTrainGroupIds(tid);
        groupIds = groupService.listGroupsChildrenIds(groupIds);
        Collections.sort(groupIds);
        List<User> users = userService.listGroupsUsers(ArrayUtils.list2Array(groupIds));

        List<Grade> grades = gradeService.initAndListUsersGrade(tid, sid, users);
        model.addAttribute("grades", grades);
    }

    private String caculateScore(SubjectType type, String content, GradeLevel level) {
        if (GradeLevelUtil.isNullOrEmpty(content)) {
            return "无成绩";
        }
        if (type == SubjectType.INT) {
            return GradeLevelUtil.calculateINT(content, level);
        } else if (type == SubjectType.FLOAT) {
            return GradeLevelUtil.calculateFLOAT(content, level);
        } else if (type == SubjectType.TIME) {
            return GradeLevelUtil.calculateTIME(content, level);
        } else if (type == SubjectType.MESC) {
            return GradeLevelUtil.calculateMSEC(content, level);
        }
        return "成绩类型错误";
    }

}
