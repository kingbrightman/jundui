package org.yxm.jundui.dao;

import org.yxm.jundui.model.*;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface IUserDao extends IBaseDao<User> {

    // user role
    UserRole loadUserRole(int uid, int rid);

    void addUserRole(User user, Role role);

    void deleteUserRole(int uid, Integer rid);

    List<Integer> listUserRoleIds(int userId);

    List<Role> listUserRoles(int id);

    List<Train> listUserTrain(int uid);

    Grade loadUserTrainSubject(int uid, int tid, int sid);

    void addUserTrainSubject(User user, Train train, Subject subject);

    List<Grade> listUserTrainSubject(int uid);


    // user group

    List<User> list();

    Pager<User> find();

    List<User> listGroupUsers(int gid);
}
