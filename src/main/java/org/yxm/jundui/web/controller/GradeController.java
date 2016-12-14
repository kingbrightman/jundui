package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yxm.jundui.dao.GradeLevelDao;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.*;
import org.yxm.jundui.service.*;
import org.yxm.jundui.util.ArrayUtils;
import org.yxm.jundui.util.GradeLevelUtil;
import org.yxm.jundui.web.dto.GradeSelectDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
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
    public String list(Model model, HttpServletRequest request, GradeSelectDto gradeSelectDto) {
        //保存上一次的查询数据
        request.getSession().setAttribute("gradeSelectDto", gradeSelectDto);

        Integer[] tids = gradeSelectDto.getTids();
        Integer[] sids = gradeSelectDto.getSids();
        Integer[] uids = gradeSelectDto.getUids();

        Pager<Grade> datas = gradeService.findGradeByContent(tids, sids, uids);
        model.addAttribute("datas", datas);

        List<User> users = userService.list();
        model.addAttribute("users", users);

        List<Train> trains = trainService.list();
        model.addAttribute("trains", trains);

        List<Subject> subjects = subjectService.list();
        model.addAttribute("subjects", subjects);

        return "grade/list";
    }

    /**
     * 将分页和部分也的分开，因为 gradeSelectDto 会冲突
     */
    @RequestMapping(value = "/list_page")
    public String list(Model model, HttpServletRequest request) {
        GradeSelectDto gradeSelectDto = (GradeSelectDto) request.getSession().getAttribute("gradeSelectDto");
        model.addAttribute("gradeSelectDto", gradeSelectDto);

        Integer[] tids = gradeSelectDto.getTids();
        Integer[] sids = gradeSelectDto.getSids();
        Integer[] uids = gradeSelectDto.getUids();

        Pager<Grade> datas = gradeService.findGradeByContent(tids, sids, uids);
        model.addAttribute("datas", datas);

        List<User> users = userService.list();
        model.addAttribute("users", users);

        List<Train> trains = trainService.list();
        model.addAttribute("trains", trains);

        List<Subject> subjects = subjectService.list();
        model.addAttribute("subjects", subjects);

        return "grade/list";
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
        if (content.equals("-1")) {
            return "未参加";
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
