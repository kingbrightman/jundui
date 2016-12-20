package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.GroupDao;
import org.yxm.jundui.dao.RoleDao;
import org.yxm.jundui.dao.UserDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private GroupDao groupDao;


    public void add(User user) {
        userDao.add(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public User load(int id) {
        return userDao.load(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> list() {
        return userDao.list();
    }

    public Pager<User> find() {
        return userDao.find();
    }

    public void add(User user, Integer[] roleIds) {
        user.setCreateDate(new Date());
        userDao.add(user);

        for (Integer rid : roleIds) {
            this.addUserRole(user.getId(), rid);
        }
    }

    public void addUserRole(int uid, int rid) {
        userDao.addUserRole(userDao.load(uid), roleDao.load(rid));
    }

    public void update(User user, Integer[] roleIds) {
        List<Integer> oldRoleIds = userDao.listUserRoleIds(user.getId());

        //添加没有的
        for (Integer rid : roleIds) {
            if (!oldRoleIds.contains(rid)) {
                this.addUserRole(user.getId(), rid);
            }
        }

        List<Integer> newRoleIds = Arrays.asList(roleIds);
        //删除多余的
        for (Integer oid : oldRoleIds) {
            if (!newRoleIds.contains(oid)) {
                this.deleteUserRole(user.getId(), oid);
            }
        }
    }

    public void deleteUserRole(int uid, Integer rid) {
        userDao.deleteUserRole(uid, rid);
    }

    public List<Integer> listUserRoleIds(int uid) {
        return userDao.listUserRoleIds(uid);
    }

    public List<Role> listUserRoles(int uid) {
        return userDao.listUserRoles(uid);
    }


    public List<User> listGroupsUsers(Integer[] groupIds) {
        List<User> users = new ArrayList<>();
        for (Integer gid : groupIds) {
            List<User> temp = this.listGroupUsers(gid);

            for (User u : temp) {
                if (!users.contains(u)) {
                    users.add(u);
                }
            }
        }
        return users;
    }

    public List<User> listGroupUsers(int gid) {
        return userDao.listGroupUsers(gid);
    }

    public User loadByUserName(String username) {
        return userDao.loadByUserName(username);
    }

    public List<Train> listUserTrains(int uid) {
        return userDao.listUserCreatedTrain(uid);
    }


}
