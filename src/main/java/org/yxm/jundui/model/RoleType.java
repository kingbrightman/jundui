package org.yxm.jundui.model;

/**
 * Created by yxm on 2016.11.21.
 */
public enum RoleType {
    ROLE_ADMIN("超级管理员"), ROLE_AUDIT("内容编辑"), ROLE_LOOK("内容查看"), ROLE_NORMAL("普通用户");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
