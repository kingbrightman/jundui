package org.yxm.jundui.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.*;
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

    private SubjectType type;

    public Subject() {
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }
}
