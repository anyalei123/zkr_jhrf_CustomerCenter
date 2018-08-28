package com.bootdo.config.dao;

import com.bootdo.config.domain.DictionaryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典管理
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
@Mapper
public interface DictionaryDao {

	DictionaryDO get(String dictId);
	
	List<DictionaryDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DictionaryDO dictionary);
	
	int update(DictionaryDO dictionary);
	
	int remove(String dict_id);
	
	int batchRemove(String[] dictIds);
}
