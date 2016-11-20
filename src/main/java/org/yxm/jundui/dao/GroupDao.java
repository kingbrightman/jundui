package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Repository
public class GroupDao extends BaseDao<Group> implements IGroupDao {
    @Override
    public List<Group> list() {
        return this.list("from Group");
    }

    @Override
    public Pager<Group> find() {
        return this.find("from Group");
    }

    @Override
    public void deleteGroupUsers(int id) {
        String hql = "delete UserGroup ug where ug.group.id = " + id;
        this.updateByHql(hql);
    }

    @Override
    public List<User> listGroupUsers(int gid) {
        String hql = "select ug.user from UserGroup ug where ug.group.id = " + gid;
        return this.getSession().createQuery(hql).list();
    }
}
