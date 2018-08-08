package com.bootdo.configureManager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.configureManager.domain.TypeDO;

/**
 * 字典类型表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 11:34:37
 */
@Mapper
public interface TypeDao {

	TypeDO get(String typeId);
	
	List<TypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TypeDO type);
	
	int update(TypeDO type);
	
	int remove(String type_id);
	
	int batchRemove(String[] typeIds);
}
