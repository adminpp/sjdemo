package com.itqf.service.impl;

import com.itqf.entity.ProductCategory;
import com.itqf.mapper.ProductCategoryMapper;
import com.itqf.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2019/4/21 19:54
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(null);
        return productCategories;
    }

    @Override
    public ProductCategory findById(Integer id) {
        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(id);
        return productCategory;
    }
}
