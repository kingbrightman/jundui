package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.GroupDao;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class GroupService {

    @Autowired
    GroupDao groupDao;

    public void add(Group group) {
        groupDao.add(group);
    }

    public void delete(int id) {
        List<User> users = groupDao.listGroupUsers(id);
        if (users != null && users.size() > 0) throw new CmsException("要删除的部门中还有用户，不能删除");
        groupDao.delete(id);
    }

    public Group load(int id) {
        return groupDao.load(id);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public List<Group> list() {
        return groupDao.list();
    }

    public Pager<Group> find() {
        return groupDao.find();
    }

    public void deleteGroupUsers(int id) {
        groupDao.deleteGroupUsers(id);
    }

    public List<User> listGroupUsers(int gid) {
        return groupDao.listGroupUsers(gid);
    }

    public List<Integer> listChildrenIds(int gid) {
        return groupDao.listChildrenIds(gid);
    }

    public List<Group> listChildren(int gid) {
        return groupDao.listChildren(gid);
    }

    public List<Integer> listGroupsChildrenIds(List<Integer> groupIds) {
        List<Integer> allGroupIds = new ArrayList<>(groupIds);
        for (int i = 0; i < groupIds.size(); i++) {
            List<Integer> tempGroupIds = groupDao.listChildrenIds(groupIds.get(i));
            for (int j = 0; j < tempGroupIds.size(); j++) {
                if (!groupIds.contains(tempGroupIds.get(j))) {
                    allGroupIds.add(tempGroupIds.get(j));
                }
            }
        }
        return allGroupIds;
    }


}
