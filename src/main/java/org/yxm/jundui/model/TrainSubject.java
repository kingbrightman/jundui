package org.yxm.jundui.model;

import javax.persistence.*;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_train_subject")
public class TrainSubject {

    private int id;
    private Train train;
    private Subject subject;

    public TrainSubject() {
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
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
