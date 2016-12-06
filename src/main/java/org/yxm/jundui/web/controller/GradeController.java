package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yxm.jundui.model.Grade;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.*;
import org.yxm.jundui.util.ArrayUtils;

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

    private void initGrades(Train train, Subject subject, Model model) {
        List<Integer> groupIds = trainService.listTrainGroupIds(train);
        groupIds = groupService.listGroupsChildrenIds(groupIds);
        Collections.sort(groupIds);
        List<User> users = userService.listGroupsUsers(ArrayUtils.list2Array(groupIds));

        List<Grade> grades = gradeService.initAndListUsersGrade(train, subject, users);
        model.addAttribute("grades", grades);
    }

    @RequestMapping(value = "/update/{tid}/{sid}")
    public String update(@PathVariable int tid, @PathVariable int sid, Model model) {
        Train train = trainService.load(tid);
        model.addAttribute(train);
        Subject subject = subjectService.load(sid);
        model.addAttribute(subject);

        initGrades(train, subject, model);
        return "grade/update";
    }

    @RequestMapping(value = "/update/{tid}/{sid}", method = RequestMethod.POST)
    public String update(@PathVariable int tid, @PathVariable int sid, Model model,
                         @RequestParam("uid") List<Integer> ids,
                         @RequestParam("content") List<String> contents) {
        for (int i = 0; i < ids.size(); i++) {
            User user = userService.load(ids.get(i));
            Grade grade = gradeService.load(tid, sid, user.getId());
            if (grade != null) {
                grade.setContent(contents.get(i));
            } else {
                System.out.println("出错了");
            }
            gradeService.update(grade);
        }
        return "redirect:/admin/train/show/" + tid;
    }

    @RequestMapping(value = "/show/{tid}/{sid}")
    public String show(@PathVariable int tid, @PathVariable int sid, Model model) {
        Train train = trainService.load(tid);
        model.addAttribute(train);
        Subject subject = subjectService.load(sid);
        model.addAttribute(subject);

        initGrades(train, subject, model);
        return "grade/show";
    }
}
