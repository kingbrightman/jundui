package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
@Repository
public class TrainDao extends BaseDao<Train> implements ITrainDao {
    @Override
    public List<Train> list() {
        return this.list("from Train");
    }

    @Override
    public Pager<Train> find() {
        return this.find("from Train");
    }
}
