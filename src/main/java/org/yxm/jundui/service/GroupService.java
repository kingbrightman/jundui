package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.IGroupDao;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Service
public class GroupService implements IGroupService {

    @Autowired
    IGroupDao groupDao;

    @Override
    public void add(Group group) {
        groupDao.add(group);
    }

    @Override
    public void delete(int id) {
        List<User> users = groupDao.listGroupUsers(id);
        if (users != null && users.size() > 0) throw new CmsException("要删除的部门中还有用户，不能删除");
        groupDao.delete(id);
    }

    @Override
    public Group load(int id) {
        return groupDao.load(id);
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public List<Group> list() {
        return groupDao.list();
    }

    @Override
    public Pager<Group> find() {
        return groupDao.find();
    }

    @Override
    public void deleteGroupUsers(int id) {
        groupDao.deleteGroupUsers(id);
    }

    @Override
    public List<User> listGroupUsers(int gid) {
        return groupDao.listGroupUsers(gid);
    }
}
