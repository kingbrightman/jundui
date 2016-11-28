package org.yxm.jundui.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2016.11.22.
 */
public class UserDto {
    private int id;
    private String username;
    private String password;

    @NotEmpty(message = "名字不能为空")
    private String name;
    private String sex;
    private Date createDate;

    private Group group;

    private Integer[] roleIds;

    public UserDto() {
    }

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

    public Integer[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Integer[] roleIds) {
        this.roleIds = roleIds;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        User u = new User();
        u.setId(this.id);
        u.setName(this.name);
        u.setUsername(this.getUsername());
        u.setPassword(this.password);
        u.setCreateDate(this.getCreateDate());
        u.setSex(this.sex);
        u.setGroup(this.getGroup());
        return u;
    }

    public UserDto(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setSex(user.getSex());
        this.setCreateDate(user.getCreateDate());
        this.setGroup(user.getGroup());
    }

    public UserDto(User user, Integer[] roleIds) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setSex(user.getSex());
        this.setCreateDate(user.getCreateDate());
        this.setRoleIds(roleIds);
        this.setGroup(user.getGroup());
    }

    public UserDto(User user, List<Integer> roleIds) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setSex(user.getSex());
        this.setCreateDate(user.getCreateDate());
        this.setRoleIds(list2Array(roleIds));
        this.setGroup(user.getGroup());
    }

    private Integer[] list2Array(List<Integer> datas) {
        Integer[] nums = new Integer[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            nums[i] = datas.get((int) i);
        }
        return nums;
    }


}
