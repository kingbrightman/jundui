package org.yxm.jundui.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_grade")
public class Grade {

    private int id;
    @NotNull
    private User user;
    @NotNull
    private Train train;
    @NotNull
    private Subject subject;

    private String content;
    private String score;

    public Grade() {
    }

    public Grade(Train train, Subject subject, User user) {
        this.train = train;
        this.subject = subject;
        this.user = user;
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

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
