package hs.service.impl;

import hs.dao.PermissionDao;
import hs.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/12 14:40
 * @Version 1.0
 */
@Service("permissionService")
public class PermissionServiceimpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    /**
     * 查询所有权限信息
     * @return
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
