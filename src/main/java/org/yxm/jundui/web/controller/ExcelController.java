package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.GradeService;
import org.yxm.jundui.service.GroupService;
import org.yxm.jundui.service.TrainService;
import org.yxm.jundui.service.UserService;
import org.yxm.jundui.util.ArrayUtils;
import org.yxm.jundui.util.ExcelUtil;
import org.yxm.jundui.web.dto.TrainSubjectGradesDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2016.12.21.
 */
@Controller
@RequestMapping(value = "/admin/excel")
public class ExcelController {

    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private GradeService gradeService;


    @RequestMapping(value = "/train/{tid}")
    public String exportTrainExcel(@PathVariable int tid, Model model, HttpServletResponse response) {
        List<Subject> subjects = trainService.listTrainSubjects(tid);
        List<Integer> groupIds = trainService.listTrainGroupIds(tid);
        List<User> users = userService.listGroupsUsers(ArrayUtils.list2Array(groupIds));
        Train train = trainService.load(tid);

        List<TrainSubjectGradesDto> grades = new ArrayList<>();
        for (Subject s : subjects) {
            TrainSubjectGradesDto temp = new TrainSubjectGradesDto();
            temp.train = train;
            temp.subject = s;
            temp.grades = gradeService.initAndListUsersGrade(train.getId(), s.getId(), users);
            grades.add(temp);
        }

        try {
            ExcelUtil.exportTrainExcel(grades, response);
        } catch (IOException e) {
            e.printStackTrace();
            return "excel/error";
        }
        return "excel/success";
    }
}
