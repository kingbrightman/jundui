package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.TrainLevel;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.GroupService;
import org.yxm.jundui.service.SubjectService;
import org.yxm.jundui.service.TrainService;
import org.yxm.jundui.service.UserService;
import org.yxm.jundui.util.ArrayUtils;
import org.yxm.jundui.util.EnumUtils;
import org.yxm.jundui.web.dto.TrainDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
@Controller
@RequestMapping("/admin/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    GroupService groupService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datas", trainService.find());
        return "train/list";
    }

    private void initAdd(Model model, int gid) {
        model.addAttribute("subjects", subjectService.list());
        model.addAttribute("groups", groupService.listChildren(gid));
        model.addAttribute("levels", EnumUtils.enumProp2NameMap(TrainLevel.class, "name"));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        User loginUser = getLoginUser(request);
        TrainDto trainDto = new TrainDto();

        model.addAttribute("trainDto", trainDto);
        initAdd(model, loginUser.getGroup().getId());

        return "train/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid TrainDto trainDto, BindingResult br, Model model, HttpServletRequest request) {
        if (br.hasErrors()) {
            return "train/edit";
        }

        User loginUser = getLoginUser(request);

        Train train = trainDto.getTrain();
        train.setCreateDate(new Date());
        train.setCreateUser(loginUser);
        trainService.add(train);

        trainService.updateTrainSubjects(train, trainDto.getSubjects());
        //TODO: 在UI上做这个逻辑控制，选择了父节点，则选择所有子节点
        List<Integer> groupAndChildIds = groupService.listGroupsChildrenIds(Arrays.asList(trainDto.getGroups()));
        trainService.updateTrainGroups(train, ArrayUtils.list2Array(groupAndChildIds));

        return "redirect:/admin/train/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
        Train train = trainService.load(id);

        User loginUser = getLoginUser(request);
        if (loginUser == null) {
            return "redirect:/login";
        }

        if (train.getCreateUser().getId() != loginUser.getId()) {
            model.addAttribute("datas", trainService.find());
            request.setAttribute(Constants.ERROR_INFO, "该训练不是由你创建，不能删除");
            return "redirect:/admin/train/list";
        }

        //TODO:提示删除train，那么train的所有项目成绩都会删除
        trainService.delete(id);
        return "redirect:/admin/train/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model, HttpServletRequest request) {
        Train train = trainService.load(id);

        User loginUser = getLoginUser(request);

        // 如果创建用户和当前用户不一样，不能更改
        if (train.getCreateUser().getId() != loginUser.getId()) {
            model.addAttribute("datas", trainService.find());
            request.setAttribute(Constants.ERROR_INFO, "该训练不是由你创建，不能修改");
            return "redirect:/admin/train/list";
        }

        List<Integer> subjects = trainService.listTrainSubjectIds(id);
        List<Integer> groups = trainService.listTrainGroupIds(id);
        TrainDto trainDto = new TrainDto(train, subjects, groups);

        initAdd(model, loginUser.getGroup().getId());

        model.addAttribute("trainDto", trainDto);
        return "train/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid TrainDto trainDto, BindingResult br, Model model,
                         HttpServletRequest request) {
        User loginUser = getLoginUser(request);
        if (loginUser == null) {
            return "redirect:/login";
        }

        if (br.hasErrors()) {
            initAdd(model, loginUser.getGroup().getId());
            return "train/edit";
        }

        Train oldTrain = trainService.load(id);
        oldTrain.setName(trainDto.getName());
        oldTrain.setDescription(trainDto.getDescription());
        oldTrain.setLevel(trainDto.getLevel());

        trainService.update(oldTrain);
        trainService.updateTrainSubjects(oldTrain, trainDto.getSubjects());

        //TODO: 在UI上做这个逻辑控制，选择了父节点，则选择所有子节点
        List<Integer> groupAndChildIds = groupService.listGroupsChildrenIds(Arrays.asList(trainDto.getGroups()));
        trainService.updateTrainGroups(oldTrain, ArrayUtils.list2Array(groupAndChildIds));

        return "redirect:/admin/train/list";
    }


    private void initShow(Model model, int tid) {
        // train所参加的部门，包含子部门
        List<Integer> groupIds = trainService.listTrainGroupIds(tid);
        groupIds = groupService.listGroupsChildrenIds(groupIds);
        Collections.sort(groupIds); // 让结果按group分好
        List<Integer> subjectIds = trainService.listTrainSubjectIds(tid);

        List<User> users = userService.listGroupsUsers(ArrayUtils.list2Array(groupIds));
        List<Subject> subjects = subjectService.list(ArrayUtils.list2Array(subjectIds));

        model.addAttribute("train", trainService.load(tid));
        model.addAttribute("users", users);
        model.addAttribute("subjects", subjects);
    }

    @RequestMapping(value = "/show/{id}")
    public String show(@PathVariable int id, Model model) {
        initShow(model, id);
        return "train/show";
    }

    private User getLoginUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(Constants.LOGIN_USER);
    }

}
