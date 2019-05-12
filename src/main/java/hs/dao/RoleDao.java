package hs.dao;

import hs.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 18:17
 * @Version 1.0
 */
@Repository("roleDao")
public interface RoleDao {
    /**
     * 根据用户id 查询用户所拥有的角色 根据角色信息查询到权限信息
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="hs.dao.PermissionDao.findPermissionByRoleId"))
    })


    public List<Role> findRoleByUserId(String userId);
}
