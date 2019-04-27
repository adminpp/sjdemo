package com.itqf.entity;

import java.util.Date;

public class ProductCategory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.category_id
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    private Integer categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.category_name
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    private String categoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.category_type
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    private Integer categoryType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.create_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.update_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.category_id
     *
     * @return the value of product_category.category_id
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.category_id
     *
     * @param categoryId the value for product_category.category_id
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.category_name
     *
     * @return the value of product_category.category_name
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.category_name
     *
     * @param categoryName the value for product_category.category_name
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.category_type
     *
     * @return the value of product_category.category_type
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public Integer getCategoryType() {
        return categoryType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.category_type
     *
     * @param categoryType the value for product_category.category_type
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.create_time
     *
     * @return the value of product_category.create_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.create_time
     *
     * @param createTime the value for product_category.create_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.update_time
     *
     * @return the value of product_category.update_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.update_time
     *
     * @param updateTime the value for product_category.update_time
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}