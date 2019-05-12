package hs.service;

import hs.domain.Role;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/12 14:06
 * @Version 1.0
 */
public interface RoleService {
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     * @param role
     */
    void save(Role role) throws Exception;
}
