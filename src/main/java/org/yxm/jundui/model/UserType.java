package org.yxm.jundui.model;

/**
 * Created by yxm on 2016.12.06.
 */
public enum UserType {
    TUAN_ZHANG("团长"), YING_ZHANG("营长"), LIAN_ZHANG("连长"), XIN_BING("新兵");

    private String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
