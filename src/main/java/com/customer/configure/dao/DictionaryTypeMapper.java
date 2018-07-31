package com.customer.configure.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.customer.configure.domain.DictionaryType;

public interface DictionaryTypeMapper {


    int deleteByPrimaryKey(String type_id);

    int insert(DictionaryType record);

    int insertSelective(DictionaryType record);

    DictionaryType selectByPrimaryKey(String type_id);

    int updateByPrimaryKeySelective(DictionaryType record);

    int updateByPrimaryKey(DictionaryType record);
}