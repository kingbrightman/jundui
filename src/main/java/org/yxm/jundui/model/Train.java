package org.yxm.jundui.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_train")
public class Train {

    private int id;
    private String name;
    private String description;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
