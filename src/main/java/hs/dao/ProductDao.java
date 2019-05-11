package hs.dao;

import hs.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/10 17:15
 * @Version 1.0
 */
@Repository("productDao")
public interface ProductDao {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 保存一条产品信息
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);


    @Select("select * from  product where id=#{id}")
    Product findById(String id) throws Exception;





}
