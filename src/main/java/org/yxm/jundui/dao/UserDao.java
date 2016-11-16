package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.*;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

    @Override
    public UserRole loadUserRole(int uid, int rid) {
        String hql = "select ur from UserRole ur left join fetch ur.user u " +
                " left join fetch ur.role r where u.id=? and r.id=?";
        return (UserRole) this.getSession().createQuery(hql)
                .setParameter(0, uid).setParameter(1, rid).uniqueResult();
    }

    @Override
    public void addUserRole(User user, Role role) {
        UserRole ur = this.loadUserRole(user.getId(), role.getId());
        if (null != ur) return;

        ur = new UserRole(user, role);
        this.getSession().save(ur);
    }

    @Override
    public List<Train> listUserTrain(int uid) {
        String hql = "select ut.train from UserTrain ut where ut.user.id=?";
        return this.getSession().createQuery(hql)
                .setParameter(0, uid).list();
    }

    @Override
    public UserTrain loadUserTrain(int uid, int tid) {
        String hql = "select ut from UserTrain ut left join fetch ut.user u " +
                " left join fetch ut.train t where u.id=? and t.id=?";
        return (UserTrain) this.getSession().createQuery(hql)
                .setParameter(0, uid).setParameter(1, tid).uniqueResult();
    }

    @Override
    public void addUserTrain(User user, Train train) {
        UserTrain ut = this.loadUserTrain(user.getId(), train.getId());
        if (null != ut) return;

        ut = new UserTrain(user, train);
        this.getSession().save(ut);
    }

    @Override
    public UserTrainSubject loadUserTrainSubject(int uid, int tid, int sid) {
        String hql = "select uts from UserTrainSubject uts left join fetch uts.user u " +
                " left join fetch uts.train t left join fetch  uts.subject s where u.id=? and t.id=? and s.id=?";
        return (UserTrainSubject) this.getSession().createQuery(hql)
                .setParameter(0, uid).setParameter(1, tid).setParameter(2, sid).uniqueResult();
    }

    @Override
    public void addUserTrainSubject(User user, Train train, Subject subject) {
        UserTrainSubject uts = this.loadUserTrainSubject(user.getId(), train.getId(), subject.getId());
        if (null != uts) return;

        uts = new UserTrainSubject();
        uts.setUser(user);
        uts.setTrain(train);
        uts.setSubject(subject);
        this.getSession().save(uts);
    }

    @Override
    public List<UserTrainSubject> listUserTrainSubject(int uid) {
        String hql = "select uts from UserTrainSubject uts where uts.user.id = ?";

        return this.getSession().createQuery(hql)
                .setParameter(0, uid).list();
    }

    @Override
    public void addUserDepartment(User user, Department department) {
        UserDepartment ud = this.loadUserDepartment(user.getId(), department.getId());
        if (null != ud) return;

        ud = new UserDepartment();
        ud.setUser(user);
        ud.setDepartment(department);
        this.getSession().save(ud);
    }

    @Override
    public UserDepartment loadUserDepartment(int uid, int departmentid) {
        String hql = "select ud from UserDepartment ud left join fetch ud.user u" +
                " left join fetch ud.department d where u.id=? and d.id=?";
        return (UserDepartment) getSession().createQuery(hql)
                .setParameter(0, uid).setParameter(1, departmentid).uniqueResult();
    }


}