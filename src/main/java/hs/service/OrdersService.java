package hs.service;

import hs.domain.Orders;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 9:29
 * @Version 1.0
 */
public interface OrdersService {
    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAll() throws Exception;
    List<Orders> findByPage(Integer page,Integer pageSize) throws Exception;

    /**
     * 根据id cha查询订单详情
     * @param id 订单id
     * @return
     */
    Orders findById(String id);
}
