package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.GradeLevel;

/**
 * Created by yxm on 2016.12.07.
 */
@Repository
public class GradeLevelDao extends BaseDao<GradeLevel> {

    public GradeLevel load(int sid) {
        String hql = "from GradeLevel gl where gl.subject.id = ?";
        return (GradeLevel) this.getSession().createQuery(hql)
                .setParameter(0, sid).uniqueResult();
    }
}
