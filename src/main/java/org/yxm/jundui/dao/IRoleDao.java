package org.yxm.jundui.dao;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface IRoleDao extends IBaseDao<Role> {

    List<Role> list();

    Pager<Role> find();

    List<User> listRoleUsers(int id);

    void deleteRoleUsers(int id);

}
