package hs.service.impl;

import hs.dao.RoleDao;
import hs.domain.Permission;
import hs.domain.Role;
import hs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/12 14:08
 * @Version 1.0
 */
@Service("roleService")
public class RoleServiceimpl implements RoleService {
    // 注入到
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }


    /**
     * 根据角色id 查询角色信息
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findRoleById(String roleId) throws Exception {
        return roleDao.findRoleById(roleId);
    }


    /**
     * 根据角色id 查询该角色没有的权限信息
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOthersPermission(String roleId) throws Exception {
        return roleDao.findOthersPermission(roleId);
    }


    /**
     * 给角色添加权限信息
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionId) throws Exception {
        for (String s : permissionId) {
            roleDao.addPermissionToRole(roleId,s);
        }
    }


}
