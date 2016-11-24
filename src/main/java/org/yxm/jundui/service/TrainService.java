package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.IGroupDao;
import org.yxm.jundui.dao.ISubjectDao;
import org.yxm.jundui.dao.ITrainDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
@Service
public class TrainService implements ITrainService {

    @Autowired
    ITrainDao trainDao;

    @Autowired
    ISubjectDao subjectDao;

    @Autowired
    IGroupDao groupDao;


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

    @Override
    public void updateTrainSubjects(Train train, Integer[] subjects) {
        List<Integer> oldSubjectIds = trainDao.getSubjectIds(train.getId());

        // 添加没有的
        for (Integer id : subjects) {
            if (!oldSubjectIds.contains(id)) {
                trainDao.addTrainSubject(train, subjectDao.load(id));
            }
        }

        // 删除取消的
        List<Integer> newSubjectIds = Arrays.asList(subjects);
        for (Integer id : oldSubjectIds) {
            if (!newSubjectIds.contains(id)) {
                trainDao.deleteTrainSubject(train, subjectDao.load(id));
            }
        }
    }

    @Override
    public void updateTrainGroups(Train train, Integer[] groups) {
        List<Integer> oldGroupIds = trainDao.getGroupIds(train.getId());

        for(Integer id: groups){
            if( !oldGroupIds.contains(id)){
                trainDao.addTrainGroup(train, groupDao.load(id));
            }
        }

        List<Integer> newGroupIds = Arrays.asList(groups);
        for(Integer id: oldGroupIds){
            if( !newGroupIds.contains(id) ){
                trainDao.deleteTrainGroup(train, groupDao.load(id));
            }
        }
    }

    @Override
    public List<Integer> loadTrainSubjects(Train train) {
        return trainDao.loadTrainSubjectIds(train.getId());
    }

    @Override
    public List<Integer> loadTrainGroups(Train train) {
        return trainDao.loadTrainGroupIds(train.getId());
    }
}
