package org.yxm.jundui.dao;

import org.yxm.jundui.model.*;

import java.util.List;

/**
 * Created by yxm on 2016.11.15.
 */
public interface ITrainDao extends IBaseDao<Train> {
    List<Train> list();

    Pager<Train> find();

    // train subject
    void deleteTrainSubject(Train train, Subject subject);

    List<Integer> getSubjectIds(int id);

    void addTrainSubject(Train train, Subject subject);

    TrainSubject loadTrainSubject(Train train, Subject subject);

    List<Integer> loadTrainSubjectIds(int id);

    // train group
    List<Integer> getGroupIds(int tid);

    void addTrainGroup(Train train, Group group);

    void deleteTrainGroup(Train train, Group group);

    TrainGroup loadTrainGroup(Train train, Group group);

    List<Integer> loadTrainGroupIds(int id);
}
