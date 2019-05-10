package hs.service;

import hs.domain.Product;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/10 17:16
 * @Version 1.0
 */
public interface ProductService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;
}
