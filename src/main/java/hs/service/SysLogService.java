package hs.service;

import hs.domain.SysLog;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/13 9:50
 * @Version 1.0
 */
public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
