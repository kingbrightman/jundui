package org.yxm.jundui.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Grade;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.util.ArrayUtils;

import java.util.*;

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

    public Pager<Grade> findByContent(Integer tid, Integer sid, Integer uid) {
        String hql = "from Grade where 1=1 ";
        List<Object> args = new ArrayList<>();

        if (tid != null) {
            hql += " and train.id=?";
            args.add(tid);
        }
        if (sid != null) {
            hql += " and subject.id=?";
            args.add(sid);
        }
        if (uid != null) {
            hql += " and user.id=?";
            args.add(uid);
        }

        return this.find(hql, args.toArray());
    }

    public Pager<Grade> findByContent(Integer[] tids, Integer[] sids, Integer[] uids) {
        String hql = "from Grade where 1=1 ";
        Map<String, Object> alias = new HashMap<>();


        if (tids != null && tids.length > 0) {
            hql += " and train.id in (:tids)";
            alias.put("tids", Arrays.asList(tids));
        }

        if (sids != null && sids.length > 0) {
            hql += " and subject.id in (:sids)";
            alias.put("sids", Arrays.asList(sids));
        }

        if (uids != null && uids.length > 0) {
            hql += " and user.id in (:uids)";
            alias.put("uids", Arrays.asList(uids));
        }


        return this.findByAlias(hql, alias);
    }
}
