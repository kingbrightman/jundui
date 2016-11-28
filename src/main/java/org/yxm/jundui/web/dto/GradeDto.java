package org.yxm.jundui.web.dto;

/**
 * Created by yxm on 2016.11.28.
 */
public class GradeDto {
    private int uid;
    private String content;

    public GradeDto() {
    }

    public GradeDto(int uid, String content) {
        this.uid = uid;
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
