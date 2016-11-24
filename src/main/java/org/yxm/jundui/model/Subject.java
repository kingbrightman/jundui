package org.yxm.jundui.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yxm on 2016.11.15.
 */
@Entity
@Table(name = "t_subject")
public class Subject {

    private int id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    private String description;

    @NotEmpty(message = "类型不能为空")
    private String type;

    public Subject() {
    }

    public Subject(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
