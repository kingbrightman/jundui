package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Department;
import org.yxm.jundui.model.User;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class DepartmentDao extends BaseDao<Department> implements IDepartmentDao {


    @Override
    public List<User> listDepartmentUsers(int departmentId) {
        String hql = "select ud.user from UserDepartment ud where ud.department.id = ?";

        return this.getSession().createQuery(hql)
                .setParameter(0, departmentId).list();
    }
}
