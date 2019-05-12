package hs.dao;

import hs.domain.Role;
import hs.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 16:16
 * @Version 1.0
 */
@Repository()
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    // 同时也要查询出 用户所拥有的角色
    @Select("select * from users where username= #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "hs.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUserName(String username) throws Exception;

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询用户详细信息 包含用户所包含的角色以及权限信息
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "hs.dao.RoleDao.findRoleByUserId")) })
    UserInfo findById(String id) throws Exception;

    /**
     * 根据用户id 查询出该用户所没有的角色信息
     * @param id
     * @return
     */
    @Select("select * from role where id not in( select roleId from users_role where userId=#{id})")
    List<Role> findOthersRolesByUid(String id);
}
