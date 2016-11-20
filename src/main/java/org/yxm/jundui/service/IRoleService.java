package org.yxm.jundui.service;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
public interface IRoleService {

    void add(Role role);

    void delete(int id);

    Role load(int id);

    void update(Role role);

    List<Role> list();

    Pager<Role> find();

}
