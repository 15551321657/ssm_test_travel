package hs.dao;

import hs.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 16:16
 * @Version 1.0
 */
@Repository()
public interface UserDao {

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
}
