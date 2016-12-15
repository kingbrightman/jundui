package org.yxm.jundui.web.dto;

/**
 * Created by yxm on 2016.12.14.
 */
public class GradeSelectDto {
    Integer[] tids;
    Integer[] sids;
    Integer[] uids;
    Integer[] gids;
    String orderByGrade;

    public GradeSelectDto() {
    }

    public Integer[] getTids() {
        return tids;
    }

    public void setTids(Integer[] tids) {
        this.tids = tids;
    }

    public Integer[] getSids() {
        return sids;
    }

    public void setSids(Integer[] sids) {
        this.sids = sids;
    }

    public Integer[] getUids() {
        return uids;
    }

    public void setUids(Integer[] uids) {
        this.uids = uids;
    }

    public Integer[] getGids() {
        return gids;
    }

    public void setGids(Integer[] gids) {
        this.gids = gids;
    }

    public String getOrderByGrade() {
        return orderByGrade;
    }

    public void setOrderByGrade(String orderByGrade) {
        this.orderByGrade = orderByGrade;
    }
}
