package hs.service.impl;

import hs.dao.SysLogDao;
import hs.domain.SysLog;
import hs.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/13 9:51
 * @Version 1.0
 */
@Service("sysLogService")
public class SysLogServiceimpl implements SysLogService {
    //注入dao
    @Autowired
    private SysLogDao dao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        dao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return dao.findAll();
    }
}
