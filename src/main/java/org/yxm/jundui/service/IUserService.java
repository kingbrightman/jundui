package org.yxm.jundui.service;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
public interface IUserService {

    void add(User department);

    void delete(int id);

    User load(int id);

    void update(User department);

    List<User> list();

    Pager<User> find();

}