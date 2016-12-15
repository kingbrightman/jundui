package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.GradeDao;
import org.yxm.jundui.dao.SubjectDao;
import org.yxm.jundui.dao.TrainDao;
import org.yxm.jundui.model.*;

import java.util.*;

/**
 * Created by yxm on 2016.11.28.
 */
@Service
public class GradeService {

    @Autowired
    private GradeDao gradeDao;
    @Autowired
    TrainDao trainDao;
    @Autowired
    SubjectDao subjectDao;

    public List<Grade> initAndListUsersGrade(int tid, int sid, List<User> users) {
        List<Grade> grades = new ArrayList<>();
        for (User user : users) {
            Grade grade = gradeDao.load(tid, sid, user.getId());
            if (grade != null) {
                grades.add(grade);
            } else {
                grade = new Grade(trainDao.load(tid), subjectDao.load(sid), user);
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

    public Pager<Grade> find() {
        return gradeDao.findAll();
    }

    public Pager<Grade> findGradeByContent(Integer tid, Integer sid, Integer uid) {
        return gradeDao.findByContent(tid, sid, uid);
    }

    public Pager<Grade> findGradeByContents(Integer[] tids, Integer[] sids, Integer[] uids, Integer[] gids) {
        return gradeDao.findGradeByContents(tids, sids, uids, gids);
    }
}
