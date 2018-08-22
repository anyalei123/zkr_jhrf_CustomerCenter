package com.bootdo.config.dao.self;

import com.bootdo.config.domain.DictionaryTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典类型表
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
@Mapper
public interface ConfigSelfDao {

	/**
	 * 通过字典类型名称查询对象
	 * @param
	 * @return
	 * @author ayl
	 * @create 2018-08-21 18:42:27
	 */
	DictionaryTypeDO getByTypeName(DictionaryTypeDO dictionaryTypeDO);
	
	
}
