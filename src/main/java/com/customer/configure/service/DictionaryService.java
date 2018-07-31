package com.customer.configure.service;

import com.customer.configure.domain.Dictionary;

public interface DictionaryService {
	    int deleteByPrimaryKey(String dict_id);

	    int insert(Dictionary record);

	    int insertSelective(Dictionary record);

	    Dictionary selectByPrimaryKey(String dict_id);

	    int updateByPrimaryKeySelective(Dictionary record);

	    int updateByPrimaryKey(Dictionary record);
}
