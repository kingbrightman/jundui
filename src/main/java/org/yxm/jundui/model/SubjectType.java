package org.yxm.jundui.model;

/**
 * Created by yxm on 2016.11.23.
 */
public enum SubjectType {

    INT("整数"), FLOAT("小数"), TIME("分'秒"), MESC("秒''毫秒");

    private String name;

    SubjectType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
