package hs.dao;

import hs.domain.Permission;
import hs.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 18:17
 * @Version 1.0
 */
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

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加角色信息
     * @param role
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     *根据角色id 查询角色信息
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    Role findRoleById(String roleId);

    /**
     * 根据角色id 查询该角色没有的权限信息
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOthersPermission(String roleId);

    /**
     * 给角色添加权限信息
     * @param roleId
     * @param s
     */
    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String s) throws Exception;
}
