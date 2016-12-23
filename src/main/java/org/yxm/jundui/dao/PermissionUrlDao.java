package org.yxm.jundui.dao;

import org.springframework.stereotype.Repository;
import org.yxm.jundui.model.PermissionUrl;

import java.util.*;

/**
 * Created by yxm on 2016.12.20.
 */
@Repository
public class PermissionUrlDao extends BaseDao<PermissionUrl> {

    public List<PermissionUrl> listPermissions(Integer[] permissionIds) {
        if (permissionIds == null || permissionIds.length < 1) return Collections.emptyList();

        String hql = "from PermissionUrl p where p.id in (:ids)";
        return this.getSession().createQuery(hql)
                .setParameterList("ids", permissionIds).list();
    }
}
