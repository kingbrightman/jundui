package org.yxm.jundui.dao;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface ITrainDao extends IBaseDao<Train> {
    List<Train> list();

    Pager<Train> find();
}
