package org.yxm.jundui.service;

import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.Train;

import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
public interface ITrainService {

    List<Train> list();

    Pager<Train> find();

    void add(Train train);

    void delete(int id);

    Train load(int id);

    void update(Train train);

    void updateTrainSubjects(Train train, Integer[] subjects);

    void updateTrainGroups(Train train, Integer[] groups);

    List<Integer> loadTrainSubjects(Train train);

    List<Integer> loadTrainGroups(Train train);
}
