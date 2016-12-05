package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Repository
public class GroupDao extends BaseDao<Group> {
    public List<Group> list() {
        return this.list("from Group");
    }

    public Pager<Group> find() {
        return this.find("from Group");
    }

    public void deleteGroupUsers(int id) {
        String hql = "deleteTrainSubject UserGroup ug where ug.group.id = " + id;
        this.updateByHql(hql);
    }

    public List<User> listGroupUsers(int gid) {
        String hql = "select ug.user from UserGroup ug where ug.group.id = " + gid;
        return this.getSession().createQuery(hql).list();
    }

    public List<Integer> listChildrenIds(int gid) {
        List<Integer> ids = new ArrayList<>();
        ids.add(gid);

        String hql = "select g.id from Group g where g.parent.id = ?";
        for (int i = 0; i < ids.size(); i++) {
            int pid = ids.get(i);
            List<Integer> tempIds = this.getSession().createQuery(hql)
                    .setParameter(0, pid).list();

            for (Integer tempId : tempIds) {
                if (!ids.contains(tempId)) {
                    ids.add(tempId);
                }
            }
        }

        return ids;
    }

    public List<Group> listChildren(int gid) {
        List<Integer> ids = listChildrenIds(gid);

        String hql = "select g from Group g where g.id in (:ids)";
        return this.getSession().createQuery(hql).setParameterList("ids", ids).list();
    }
}
