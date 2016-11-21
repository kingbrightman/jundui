package org.yxm.jundui.model;

/**
 * Created by yxm on 2016.11.21.
 */
public enum RoleType {
    ROLE_ADMIN("超级管理员"), ROLE_PUBLISH("信息发布"), ROLE_AUDIT("信息编辑");

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
