package org.yxm.jundui.model;

/**
 * Created by yxm on 2016.11.24.
 */
public enum TrainLevel {

    L1("普通训练"), L2("记录成绩"), L3("考核成绩");

    private String name;

    TrainLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
