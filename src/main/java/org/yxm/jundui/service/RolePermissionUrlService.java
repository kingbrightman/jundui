package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.RolePermissionUrlDao;

/**
 * Created by yxm on 2016.12.20.
 */
@Service
public class RolePermissionUrlService {

    @Autowired
    private RolePermissionUrlDao rolePermissionUrlDao;
}
