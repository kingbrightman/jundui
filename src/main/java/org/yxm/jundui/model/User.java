package org.yxm.jundui.model;

import org.apache.tools.ant.filters.LineContains;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_user")
public class User {

    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;

    private Date createDate;

    private Group group;

    public User() {
    }

    public User(String username, String password, String name, Date createDate) {
        this.username = username;
        this.password = password;
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @ManyToOne
    @JoinColumn(name = "gid")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;

        if (obj instanceof User) {
            User tempUser = (User) obj;
            if (tempUser.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }
}
