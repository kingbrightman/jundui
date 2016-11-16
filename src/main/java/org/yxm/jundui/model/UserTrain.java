package org.yxm.jundui.model;

import javax.persistence.*;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_user_train")
public class UserTrain {

    private int id;
    private User user;
    private Train train;

    public UserTrain() {
    }

    public UserTrain(User user, Train train) {
        this.user = user;
        this.train = train;
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
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "train_id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
