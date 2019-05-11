package hs.dao;

import hs.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 14:26
 * @Version 1.0
 */
@Repository("travellersDao'")
public interface TravellersDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String orderId)  throws Exception;
}
