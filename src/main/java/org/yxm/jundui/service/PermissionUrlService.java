package org.yxm.jundui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yxm.jundui.dao.PermissionUrlDao;
import org.yxm.jundui.model.Pager;
import org.yxm.jundui.model.PermissionUrl;

/**
 * Created by yxm on 2016.12.20.
 */
@Service
public class PermissionUrlService {
    @Autowired
    PermissionUrlDao permissionUrlDao;

    public Pager<PermissionUrl> find() {
        return permissionUrlDao.findAll();
    }

    public void add(PermissionUrl permissionUrl) {
        permissionUrlDao.add(permissionUrl);
    }

    public PermissionUrl load(int id) {
        return permissionUrlDao.load(id);
    }

    public void update(PermissionUrl permissionUrl) {
        permissionUrlDao.update(permissionUrl);
    }

    public void delete(int id) {
        permissionUrlDao.delete(id);
    }
}
