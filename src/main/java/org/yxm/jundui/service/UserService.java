package org.yxm.jundui.service;

import com.sun.tools.javac.util.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.IGroupDao;
import org.yxm.jundui.dao.IRoleDao;
import org.yxm.jundui.dao.IUserDao;
import org.yxm.jundui.dao.UserDao;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private IGroupDao groupDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public Pager<User> find() {
        return userDao.find();
    }

    @Override
    public void add(User user, Integer[] roleIds) {
        user.setCreateDate(new Date());
        userDao.add(user);

        for (Integer rid : roleIds) {
            this.addUserRole(user.getId(), rid);
        }
    }

    @Override
    public void addUserRole(int uid, int rid) {
        userDao.addUserRole(userDao.load(uid), roleDao.load(rid));
    }

    @Override
    public void addUserGroup(int uid, int gid) {
        userDao.addUserGroup(userDao.load(uid), groupDao.load(gid));
    }

    @Override
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

    @Override
    public void deleteUserRole(int uid, Integer rid) {
        userDao.deleteUserRole(uid, rid);
    }

    @Override
    public List<Integer> listUserRoleIds(int uid) {
        return userDao.listUserRoleIds(uid);
    }
}