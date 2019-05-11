package hs.dao;

import hs.domain.Member;
import hs.domain.Orders;
import hs.domain.Product;
import org.apache.ibatis.annotations.*;
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
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "hs.dao.ProductDao.findById"))

    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据订单id 查询订单  这里需要根据订单id 查询出产品信息   还有 会员信息  以及旅客信息
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "hs.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "hs.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType =java.util.List.class,many =@Many(select="hs.dao.TravellersDao.findByOrdersId"))

    })
    Orders findById(String id);
}
