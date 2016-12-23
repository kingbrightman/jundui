package org.yxm.jundui.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_train")
public class Train {

    private int id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    private String description;

    private TrainLevel level;

    private User createUser;

    private Date createDate;


    public Train() {
    }

    public Train(String name, String description, Date createDate) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne
    @JoinColumn(name = "create_user")
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    public TrainLevel getLevel() {
        return level;
    }

    public void setLevel(TrainLevel level) {
        this.level = level;
    }
}
