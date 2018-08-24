package com.bootdo.config.service;

import com.bootdo.config.domain.DictionaryDO;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
public interface DictionaryService {

	/**
	 * 通过字典名称查询字典对象
	 * @param dictionaryDO
	 * @return
	 */
	DictionaryDO getByDictName(DictionaryDO dictionaryDO);
	
	DictionaryDO get(String dictId);
	
	List<DictionaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictionaryDO dictionary);
	
	int update(DictionaryDO dictionary);
	
	int remove(String dictId);
	
	int batchRemove(String[] dictIds);
}
