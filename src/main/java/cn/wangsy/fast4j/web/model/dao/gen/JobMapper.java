/*
 * JobMapper.java
 * Copyright(C) 2011-2016
 * All rights reserved.
 * --------------------------------
 * 20160803
 */
package cn.wangsy.fast4j.web.model.dao.gen;

import cn.wangsy.fast4j.web.model.entity.gen.Job;
import cn.wangsy.fast4j.web.model.entity.gen.JobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int countByExample(JobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int deleteByExample(JobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int insert(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int insertSelective(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    List<Job> selectByExample(JobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    Job selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table job
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Job record);
}