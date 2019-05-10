package hs.service.impl;

import hs.dao.ProductDao;
import hs.domain.Product;
import hs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: huangshun
 * @Date: 2019/5/10 17:18
 * @Version 1.0
 */
@Transactional
@Service("productService")
public class ProductServiceimpl implements ProductService {
    //注入dao
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
