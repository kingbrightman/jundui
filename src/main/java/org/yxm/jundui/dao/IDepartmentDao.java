package org.yxm.jundui.dao;

import org.yxm.jundui.model.Department;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface IDepartmentDao extends IBaseDao<Department> {

    List<User> listDepartmentUsers(int departmentId);
}
