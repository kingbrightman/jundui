package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.Train;

import java.util.Collections;
import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class SubjectDao extends BaseDao<Subject> {
    public List<Subject> list() {
        return this.list("from Subject");
    }

    public Pager<Subject> find() {
        return this.find("from Subject");
    }

    public List<Subject> list(Integer[] ids) {
        if (ids == null || ids.length < 1) return Collections.emptyList();
        String hql = "from Subject s where s.id in (:ids)";
        return this.getSession().createQuery(hql)
                .setParameterList("ids", ids).list();
    }

    public List<Train> listSujectTrains(int sid) {
        String hql = "select ts.train from TrainSubject ts where ts.subject.id = ?";
        return this.getSession().createQuery(hql)
                .setParameter(0, sid).list();
    }
}
