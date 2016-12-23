package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.*;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class TrainDao extends BaseDao<Train> {
    public List<Train> list() {
        return this.list("from Train");
    }

    public Pager<Train> find() {
        return this.find("from Train");
    }

    public List<Integer> getSubjectIds(int id) {
        String hql = "select ts.subject.id from TrainSubject ts where ts.train.id = ?";
        return this.getSession().createQuery(hql)
                .setParameter(0, id).list();
    }

    public void addTrainSubject(Train train, Subject subject) {
        TrainSubject ts = this.loadTrainSubject(train, subject);
        if (ts != null) return;

        ts = new TrainSubject(train, subject);
        this.getSession().save(ts);
    }

    public void deleteTrainSubject(Train train, Subject subject) {
        String hql = "delete from TrainSubject ts where ts.train.id = ? and ts.subject.id = ?";
        this.getSession().createQuery(hql)
                .setParameter(0, train.getId())
                .setParameter(1, subject.getId())
                .executeUpdate();
    }

    public TrainSubject loadTrainSubject(Train train, Subject subject) {
        String hql = "select ts from TrainSubject ts where ts.train.id = ? and ts.subject.id = ?";
        return (TrainSubject) this.getSession().createQuery(hql)
                .setParameter(0, train.getId())
                .setParameter(1, subject.getId())
                .uniqueResult();
    }

    public List<Integer> listTrainSubjectIds(int id) {
        String hql = "select ts.subject.id from TrainSubject ts where ts.train.id = " + id;
        return this.getSession().createQuery(hql).list();
    }

    public List<Subject> listTrainSubjects(int tid) {
        String hql = "select ts.subject from TrainSubject ts where ts.train.id = " + tid;
        return this.getSession().createQuery(hql).list();
    }

    public void addTrainGroup(Train train, Group group) {
        TrainGroup tg = this.loadTrainGroup(train, group);
        if (tg != null) return;

        tg = new TrainGroup(train, group);
        this.getSession().save(tg);
    }

    public void deleteTrainGroup(Train train, Group group) {
        String hql = "delete from TrainGroup tg where tg.train.id=? and tg.group.id=?";
        this.getSession().createQuery(hql)
                .setParameter(0, train.getId())
                .setParameter(1, group.getId())
                .executeUpdate();
    }

    public TrainGroup loadTrainGroup(Train train, Group group) {
        String hql = "select tg from TrainGroup tg where tg.train.id=? and tg.group.id=?";

        return (TrainGroup) this.getSession().createQuery(hql)
                .setParameter(0, train.getId())
                .setParameter(1, group.getId())
                .uniqueResult();
    }

    public List<Integer> listTrainGroupIds(int id) {
        String hql = "select tg.group.id from TrainGroup tg where tg.train.id = " + id;
        return this.getSession().createQuery(hql).list();
    }

}
