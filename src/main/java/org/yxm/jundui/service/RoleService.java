package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.PermissionUrlDao;
import org.yxm.jundui.dao.RoleDao;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.PermissionUrl;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;
import org.yxm.jundui.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionUrlDao permissionUrlDao;

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

    public List<PermissionUrl> listRolePermissions(int rid) {
        return roleDao.listRolePermissions(rid);
    }

    public void updatePermissions(int rid, Integer[] permissionIds) {
        List<Integer> oldUrlIds = roleDao.listRolePermissionIds(rid);
        List<Integer> newUrlIds = Arrays.asList(permissionIds);

        for (Integer id : oldUrlIds) {
            if (!newUrlIds.contains(id)) {
                this.deleteRolePermission(rid, id);
            }
        }

        for (Integer id : newUrlIds) {
            if (!oldUrlIds.contains(id)) {
                this.addRolePermission(rid, id);
            }
        }
    }

    private void addRolePermission(int rid, Integer pid) {
        roleDao.addRolePermission(roleDao.load(rid), permissionUrlDao.load(pid));
    }

    private void deleteRolePermission(int rid, Integer pid) {
        roleDao.deleteRolePermission(rid, pid);
    }

    public Integer[] listRolePermissionIds(int rid) {
        return ArrayUtils.list2Array(roleDao.listRolePermissionIds(rid));
    }

    public List<PermissionUrl> listRolesPermissions(List<Integer> rids) {
        List<Integer> permissionIds = new ArrayList<>();
        for (Integer rid : rids) {
            List<Integer> ptempIds = roleDao.listRolePermissionIds(rid);
            for (Integer pid : ptempIds) {
                if (!permissionIds.contains(pid)) permissionIds.add(pid);
            }
        }
        return permissionUrlDao.listPermissions(ArrayUtils.list2Array(permissionIds));
    }
}
