package org.yxm.jundui.service;

import org.yxm.jundui.model.Grade;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.28.
 */
public interface IGradeService {
    List<Grade> initAndListUsersGrade(Train train, Subject subject, List<User> users);

    Grade load(int tid, int sid, int uid);

    void update(Grade grade);
}
