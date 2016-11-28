package org.yxm.jundui.service;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
public interface IGroupService {

    void add(Group group);

    void delete(int id);

    Group load(int id);

    void update(Group group);

    List<Group> list();

    Pager<Group> find();

    void deleteGroupUsers(int id);

    List<User> listGroupUsers(int gid);

    List<Integer> listChildrenIds(int gid);

    List<Group> listChildren(int gid);

    List<Integer> listGroupsChildrenIds(List<Integer> groupIds);

}
