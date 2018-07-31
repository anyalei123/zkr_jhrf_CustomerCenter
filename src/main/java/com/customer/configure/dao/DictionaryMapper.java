package com.customer.configure.dao;



import com.customer.configure.domain.Dictionary;

public interface DictionaryMapper {
 
	//根据主键删除信息
    int deleteByPrimaryKey(String dict_id);

    //添加一条信息
    int insert(Dictionary record);

    int insertSelective(Dictionary record);
     //根据主键查询
    Dictionary selectByPrimaryKey(String dict_id);
   
    
    int updateByPrimaryKeySelective(Dictionary record);

    //根据对象修改
    int updateByPrimaryKey(Dictionary record);
}