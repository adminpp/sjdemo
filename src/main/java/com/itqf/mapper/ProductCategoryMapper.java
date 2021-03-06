package com.itqf.mapper;

import com.itqf.entity.ProductCategory;
import com.itqf.entity.ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int countByExample(ProductCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int deleteByExample(ProductCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int insert(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int insertSelective(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    List<ProductCategory> selectByExample(ProductCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    ProductCategory selectByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByPrimaryKeySelective(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByPrimaryKey(ProductCategory record);
}