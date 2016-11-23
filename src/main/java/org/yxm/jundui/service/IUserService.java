package org.yxm.jundui.service;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
public interface IUserService {

    void add(User user);

    void delete(int id);

    User load(int id);

    void update(User user);

    List<User> list();

    Pager<User> find();

    void add(User user, Integer[] roleIds);

    void addUserRole(int uid, int rid);

    void addUserGroup(int uid, int gid);

    void update(User user, Integer[] roleIds);

    void deleteUserRole(int uid, Integer rid);

    List<Integer> listUserRoleIds(int uid);
}