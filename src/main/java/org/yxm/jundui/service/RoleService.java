package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.RoleDao;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public void add(Role role) {
        roleDao.add(role);
    }

    public void delete(int id) {
        List<User> users = roleDao.listRoleUsers(id);
        if (users != null && users.size() > 0) throw new CmsException("角色组还有成员，不能删除");
        roleDao.delete(id);
    }

    public Role load(int id) {
        return roleDao.load(id);
    }

    public void update(Role role) {
        roleDao.update(role);
    }

    public List<Role> list() {
        return roleDao.list();
    }

    public Pager<Role> find() {
        return roleDao.find();
    }

}
