package hs.dao;

import hs.domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 9:31
 * @Version 1.0
 */
@Repository("ordersDao")
public interface OrdersDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "hs.dao.ProductDao.findById"))

    })
    List<Orders> findAll() throws Exception;
}
