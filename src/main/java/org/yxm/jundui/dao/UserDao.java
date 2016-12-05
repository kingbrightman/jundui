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
    public List<User> list() {
        return this.list("from User");
    }

    @Override
    public Pager<User> find() {
        return this.find("from User");
    }

    @Override
    public List<User> listGroupUsers(int gid) {
        return this.list("from User u where u.group.id = ?", gid);
    }

    @Override
    public User loadByUserName(String username) {
        String hql = "from User u where u.username=?";
        return (User) this.getSession().createQuery(hql).
                setParameter(0, username).uniqueResult();
    }

    @Override
    public List<Role> listUserRoles(int id) {
        String hql = "select ur.role from UserRole ur where ur.user.id = " + id;
        return this.getSession().createQuery(hql).list();
    }

    @Override
    public List<Integer> listUserRoleIds(int userId) {
        String hql = "select ur.role.id from UserRole ur where ur.user.id=?";
        return this.getSession().createQuery(hql).setParameter(0, userId).list();
    }

    @Override
    public void deleteUserRole(int uid, Integer rid) {
        String hql = "delete from UserRole ur where ur.user.id = ? and ur.role.id = ?";
        this.updateByHql(hql, new Integer[]{uid, rid});
    }


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
    public Grade loadUserTrainSubject(int uid, int tid, int sid) {
        String hql = "select uts from UserTrainSubject uts left join fetch uts.user u " +
                " left join fetch uts.train t left join fetch  uts.subject s where u.id=? and t.id=? and s.id=?";
        return (Grade) this.getSession().createQuery(hql)
                .setParameter(0, uid).setParameter(1, tid).setParameter(2, sid).uniqueResult();
    }

    @Override
    public void addUserTrainSubject(User user, Train train, Subject subject) {
        Grade uts = this.loadUserTrainSubject(user.getId(), train.getId(), subject.getId());
        if (null != uts) return;

        uts = new Grade();
        uts.setUser(user);
        uts.setTrain(train);
        uts.setSubject(subject);
        this.getSession().save(uts);
    }

    @Override
    public List<Grade> listUserTrainSubject(int uid) {
        String hql = "select uts from UserTrainSubject uts where uts.user.id = ?";

        return this.getSession().createQuery(hql)
                .setParameter(0, uid).list();
    }


}
