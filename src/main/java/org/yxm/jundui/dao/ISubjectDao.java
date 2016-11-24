package org.yxm.jundui.dao;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Subject;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface ISubjectDao extends IBaseDao<Subject> {

    List<Subject> list();

    Pager<Subject> find();
}
