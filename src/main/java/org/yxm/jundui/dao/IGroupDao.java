package org.yxm.jundui.dao;

import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface IGroupDao extends IBaseDao<Group> {

    List<Group> list();

    Pager<Group> find();

    void deleteGroupUsers(int id);

    List<User> listGroupUsers(int gid);

    List<Integer> listChildrenIds(int gid);

    List<Group> listChildren(int gid);
}
