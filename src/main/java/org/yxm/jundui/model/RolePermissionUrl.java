package org.yxm.jundui.model;

import javax.persistence.*;

/**
 * Created by yxm on 2016.12.20.
 */
@Entity
@Table(name = "t_role_permission_url")
public class RolePermissionUrl {

    private int id;
    private Role role;
    private PermissionUrl url;

    public RolePermissionUrl() {
    }

    public RolePermissionUrl(Role role, PermissionUrl url) {
        this.role = role;
        this.url = url;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "url_id")
    public PermissionUrl getUrl() {
        return url;
    }

    public void setUrl(PermissionUrl url) {
        this.url = url;
    }
}
