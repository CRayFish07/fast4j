/*
 * DictionaryTypeMapper.java
 * Copyright(C) 2011-2016
 * All rights reserved.
 * --------------------------------
 */
package cn.wangsy.fast4j.web.model.dao.gen;

import cn.wangsy.fast4j.web.model.entity.gen.DictionaryType;
import cn.wangsy.fast4j.web.model.entity.gen.DictionaryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int countByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int deleteByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int insert(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int insertSelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    List<DictionaryType> selectByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    DictionaryType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DictionaryType record, @Param("example") DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DictionaryType record, @Param("example") DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DictionaryType record);
}