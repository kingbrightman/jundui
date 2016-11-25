package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class SubjectDao extends BaseDao<Subject> implements ISubjectDao {
    @Override
    public List<Subject> list() {
        return this.list("from Subject");
    }

    @Override
    public Pager<Subject> find() {
        return this.find("from Subject");
    }

    @Override
    public List<Subject> list(Integer[] ids) {
        String hql = "from Subject s where s.id in (:ids)";
        return this.getSession().createQuery(hql)
                .setParameterList("ids", ids).list();
    }
}
