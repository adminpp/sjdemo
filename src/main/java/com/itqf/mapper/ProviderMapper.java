package com.itqf.mapper;

import com.itqf.entity.Provider;
import com.itqf.entity.ProviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProviderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int countByExample(ProviderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int deleteByExample(ProviderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int insert(Provider record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int insertSelective(Provider record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    List<Provider> selectByExample(ProviderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    Provider selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByExampleSelective(@Param("record") Provider record, @Param("example") ProviderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByExample(@Param("record") Provider record, @Param("example") ProviderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByPrimaryKeySelective(Provider record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbggenerated Tue Apr 23 14:52:38 CST 2019
     */
    int updateByPrimaryKey(Provider record);
}