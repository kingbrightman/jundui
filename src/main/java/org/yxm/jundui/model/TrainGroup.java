package org.yxm.jundui.model;

import javax.persistence.*;

/**
 * Created by yxm on 2016.11.24.
 */
@Entity
@Table(name = "t_train_group")
public class TrainGroup {

    private int id;
    private Train train;
    private Group group;

    public TrainGroup() {
    }

    public TrainGroup(Train train, Group group) {
        this.train = train;
        this.group = group;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "train_id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
