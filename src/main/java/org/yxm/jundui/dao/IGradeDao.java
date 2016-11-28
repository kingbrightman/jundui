package org.yxm.jundui.dao;

import org.yxm.jundui.model.Grade;

/**
 * Created by yxm on 2016.11.28.
 */
public interface IGradeDao extends IBaseDao<Grade> {
    Grade load(int trainId, int subjectId, int userId);
}
