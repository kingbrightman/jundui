package org.yxm.jundui.model;

import javax.persistence.*;

/**
 * Created by yxm on 2016.12.20.
 */
@Entity
@Table(name = "t_permission_url")
public class PermissionUrl {

    private int id;
    private String url;
    private String description;

    public PermissionUrl() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
