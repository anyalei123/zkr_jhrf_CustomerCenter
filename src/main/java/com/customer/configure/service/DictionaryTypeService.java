package com.customer.configure.service;

import com.customer.configure.domain.DictionaryType;

public interface DictionaryTypeService {

	     int deleteByPrimaryKey(String type_id);

	    int insert(DictionaryType record);

	    int insertSelective(DictionaryType record);

	    DictionaryType selectByPrimaryKey(String type_id);

	    int updateByPrimaryKeySelective(DictionaryType record);

	    int updateByPrimaryKey(DictionaryType record);
}
