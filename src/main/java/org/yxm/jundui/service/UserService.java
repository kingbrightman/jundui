package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.IGroupDao;
import org.yxm.jundui.dao.IRoleDao;
import org.yxm.jundui.dao.IUserDao;
import org.yxm.jundui.dao.UserDao;
import org.yxm.jundui.model.User;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

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
    public void add(User user, Integer[] roleIds, Integer[] groupIds) {
        user.setCreateDate(new Date());
        userDao.add(user);

        for (Integer rid : roleIds) {
            this.addUserRole(user.getId(), rid);
        }

        for (Integer gid : groupIds) {
            this.addUserGroup(user.getId(), gid);
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


}
