package hs.service;

import hs.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 16:13
 * @Version 1.0
 */
public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 添加一个用户信息
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;
}
