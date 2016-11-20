package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.IUserDao;
import org.yxm.jundui.dao.UserDao;
import org.yxm.jundui.model.User;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void load(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public Pager<User> find() {
        return null;
    }
}
