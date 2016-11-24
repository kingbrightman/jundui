package org.yxm.jundui.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.TrainLevel;
import org.yxm.jundui.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.24.
 */
public class TrainDto {
    private int id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    private String description;

    private TrainLevel level;

    private User createUser;

    private Date createDate;

    private Integer[] subjects;
    private Integer[] groups;

    public TrainDto() {
    }

    public TrainDto(Train train, List<Integer> subjects, List<Integer> groups) {
        this.setName(train.getName());
        this.setDescription(train.getDescription());
        this.setCreateDate(train.getCreateDate());
        this.setCreateUser(train.getCreateUser());
        this.setLevel(train.getLevel());

        this.setSubjects(list2Array(subjects));
        this.setGroups(list2Array(groups));
    }

    private Integer[] list2Array(List<Integer> datas) {
        Integer[] nums = new Integer[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            nums[i] = datas.get((int) i);
        }
        return nums;
    }

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

    public TrainLevel getLevel() {
        return level;
    }

    public void setLevel(TrainLevel level) {
        this.level = level;
    }

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

    public Integer[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Integer[] subjects) {
        this.subjects = subjects;
    }

    public Integer[] getGroups() {
        return groups;
    }

    public void setGroups(Integer[] groups) {
        this.groups = groups;
    }


    public Train getTrain() {
        Train train = new Train();
        train.setName(this.getName());
        train.setDescription(this.getDescription());
        train.setCreateDate(this.getCreateDate());
        train.setCreateUser(this.getCreateUser());
        train.setLevel(this.getLevel());

        return train;
    }
}
