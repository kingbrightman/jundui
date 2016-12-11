package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.GradeLevelDao;
import org.yxm.jundui.model.GradeLevel;

/**
 * Created by yxm on 2016.12.07.
 */
@Service
public class GradeLevelService {
    @Autowired
    private GradeLevelDao gradeLevelDao;

    public GradeLevel load(int sid) {
        return gradeLevelDao.load(sid);
    }
}
