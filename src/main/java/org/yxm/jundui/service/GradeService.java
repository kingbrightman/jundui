package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.GradeDao;
import org.yxm.jundui.model.Grade;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2016.11.28.
 */
@Service
public class GradeService {

    @Autowired
    GradeDao gradeDao;

    public List<Grade> initAndListUsersGrade(Train train, Subject subject, List<User> users) {
        List<Grade> grades = new ArrayList<>();
        for (User user : users) {
            Grade grade = gradeDao.load(train.getId(), subject.getId(), user.getId());
            if (grade != null) {
                grades.add(grade);
            } else {
                grade = new Grade(train, subject, user);
                gradeDao.add(grade);
                grades.add(grade);
            }
        }
        return grades;
    }

    public Grade load(int tid, int sid, int uid) {
        return gradeDao.load(tid, sid, uid);
    }

    public void update(Grade grade) {
        gradeDao.update(grade);
    }
}
