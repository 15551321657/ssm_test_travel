package hs.service.impl;

import hs.dao.RoleDao;
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
}
