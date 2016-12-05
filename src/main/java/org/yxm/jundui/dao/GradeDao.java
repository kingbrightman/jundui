package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Grade;

/**
 * Created by yxm on 2016.11.28.
 */
@Repository
public class GradeDao extends BaseDao<Grade> {
    public Grade load(int trainId, int subjectId, int userId) {
        String hql = "from Grade g where g.train.id=? and g.subject.id=? and g.user.id=?";
        return (Grade) this.getSession().createQuery(hql)
                .setParameter(0, trainId)
                .setParameter(1, subjectId)
                .setParameter(2, userId)
                .uniqueResult();
    }
}
