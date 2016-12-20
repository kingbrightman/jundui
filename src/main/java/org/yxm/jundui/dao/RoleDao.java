package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.*;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class RoleDao extends BaseDao<Role> {

    public List<Role> list() {
        return this.list("from Role");
    }

    public Pager<Role> find() {
        return this.find("from Role");
    }

    public List<User> listRoleUsers(int id) {
        String hql = "select ur.user from UserRole ur where ur.role.id = ?";

        return this.getSession().createQuery(hql)
                .setParameter(0, id).list();
    }

    public void deleteRoleUsers(int id) {
        String hql = "deleteTrainSubject UserRole ur where ur.role.id = ?";
        this.updateByHql(hql, id);
    }

    public List<PermissionUrl> listRolePermissions(int rid) {
        String hql = "select rp.url from RolePermissionUrl rp where rp.role.id = ?";

        return this.getSession().createQuery(hql)
                .setParameter(0, rid).list();
    }

    public List<Integer> listRolePermissionIds(int rid) {
        String hql = "select rp.url.id from RolePermissionUrl rp where rp.role.id = ?";
        return this.getSession().createQuery(hql)
                .setParameter(0, rid).list();
    }

    public void deleteRolePermission(int rid, Integer pid) {
        String hql = "delete from RolePermissionUrl rp where rp.role.id=? and rp.url.id=?";
        this.updateByHql(hql, new Integer[]{rid, pid});
    }

    public void addRolePermission(Role role, PermissionUrl permissionUrl) {
        RolePermissionUrl rp = this.loadRolePermissionUrl(role.getId(), permissionUrl.getId());
        if (rp != null) {
            return;
        }
        rp = new RolePermissionUrl(role, permissionUrl);
        this.getSession().save(rp);
    }

    private RolePermissionUrl loadRolePermissionUrl(Integer rid, Integer pid) {
        String hql = "from RolePermissionUrl rp where rp.role.id = ? and rp.url.id = ?";
        return (RolePermissionUrl) this.queryObject(hql, new Object[]{rid, pid});
    }
}
