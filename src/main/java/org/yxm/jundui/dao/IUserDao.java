package org.yxm.jundui.dao;

import org.yxm.jundui.model.*;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface IUserDao extends IBaseDao<User> {

    UserRole loadUserRole(int uid, int rid);

    void addUserRole(User user, Role role);

    UserTrain loadUserTrain(int uid, int tid);

    void addUserTrain(User user, Train train);

    List<Train> listUserTrain(int uid);

    UserTrainSubject loadUserTrainSubject(int uid, int tid, int sid);

    void addUserTrainSubject(User user, Train train, Subject subject);

    List<UserTrainSubject> listUserTrainSubject(int uid);

    UserDepartment loadUserDepartment(int uid, int departmentid);

    void addUserDepartment(User user, Department department);
}
