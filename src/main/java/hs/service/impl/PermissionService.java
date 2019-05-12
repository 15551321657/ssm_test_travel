package hs.service.impl;

import hs.domain.Permission;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/12 14:40
 * @Version 1.0
 */
public interface PermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
