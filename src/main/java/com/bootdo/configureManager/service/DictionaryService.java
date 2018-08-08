package com.bootdo.configureManager.service;

import com.bootdo.common.domain.PageDO;
import com.bootdo.configureManager.domain.DictionaryDO;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 11:34:31
 */
public interface DictionaryService {
	
	DictionaryDO get(String dictId);
	
	List<DictionaryDO> list1(); 
	
	List<DictionaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictionaryDO dictionary);
	
	int update(DictionaryDO dictionary);
	
	int remove(String dictId);
	
	int batchRemove(String[] dictIds);
}
