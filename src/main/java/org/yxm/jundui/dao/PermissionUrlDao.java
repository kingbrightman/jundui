package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.PermissionUrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yxm on 2016.12.20.
 */
@Repository
public class PermissionUrlDao extends BaseDao<PermissionUrl> {

    public List<PermissionUrl> listPermissions(Integer[] permissionIds) {
        String hql = "from PermissionUrl p where p.id in (:ids)";
        Map<String, Object> alias = new HashMap<>();
        alias.put("ids", permissionIds);
        return this.listByAlias(hql, alias);
    }
}
