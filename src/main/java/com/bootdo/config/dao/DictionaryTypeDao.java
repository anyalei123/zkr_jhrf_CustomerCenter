package com.bootdo.config.dao;

import com.bootdo.config.domain.DictionaryTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典类型管理
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
@Mapper
public interface DictionaryTypeDao {

	DictionaryTypeDO get(String typeId);
	
	List<DictionaryTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DictionaryTypeDO dictionaryType);
	
	int update(DictionaryTypeDO dictionaryType);
	
	int remove(String type_id);
	
	int batchRemove(String[] typeIds);
}
