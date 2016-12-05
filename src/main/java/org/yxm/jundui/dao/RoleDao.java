package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.User;

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
}
