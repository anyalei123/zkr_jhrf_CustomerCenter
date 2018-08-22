package com.bootdo.config.service;

import com.bootdo.config.domain.DictionaryTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
public interface DictionaryTypeService {
	
	
	/**
	 * 通过字典类型名称查询对象
	 * @param
	 * @return
	 * @author ayl
	 * @create 2018-08-21 18:42:27
	 */
	DictionaryTypeDO getByTypeName(DictionaryTypeDO dictionaryType);
	
	
	DictionaryTypeDO get(String typeId);
	
	List<DictionaryTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictionaryTypeDO dictionaryType);
	
	int update(DictionaryTypeDO dictionaryType);
	
	int remove(String typeId);
	
	int batchRemove(String[] typeIds);
	
}
