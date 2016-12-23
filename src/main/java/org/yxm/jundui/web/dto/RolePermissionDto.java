package org.yxm.jundui.web.dto;

import org.yxm.jundui.model.PermissionUrl;
import org.yxm.jundui.model.Role;

import java.util.List;

/**
 * Created by yxm on 2016.12.20.
 */
public class RolePermissionDto {

    private Role role;
    private Integer[] permissionIds;

    public RolePermissionDto() {
    }

    public RolePermissionDto(Role role, Integer[] permissionIds) {
        this.role = role;
        this.permissionIds = permissionIds;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer[] getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Integer[] permissionIds) {
        this.permissionIds = permissionIds;
    }
}
