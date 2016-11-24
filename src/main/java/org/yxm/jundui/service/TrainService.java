package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.ITrainDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
@Service
public class TrainService implements ITrainService {

    @Autowired
    ITrainDao trainDao;


    @Override
    public List<Train> list() {
        return trainDao.list();
    }

    @Override
    public Pager<Train> find() {
        return trainDao.find();
    }

    @Override
    public void add(Train train) {
        trainDao.add(train);
    }

    @Override
    public void delete(int id) {
        trainDao.delete(id);
    }

    @Override
    public Train load(int id) {
        return trainDao.load(id);
    }

    @Override
    public void update(Train train) {
        trainDao.update(train);
    }
}
