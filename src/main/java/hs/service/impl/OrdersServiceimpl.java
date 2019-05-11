package hs.service.impl;

import hs.dao.OrdersDao;
import hs.domain.Orders;
import hs.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 9:30
 * @Version 1.0
 */
@Transactional
@Service("ordersService")
public class OrdersServiceimpl implements OrdersService {
    //注入到
    @Autowired
    private OrdersDao ordersDao;


    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
