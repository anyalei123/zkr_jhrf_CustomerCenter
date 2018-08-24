package com.bootdo.config.dao.self;

import com.bootdo.config.domain.DictionaryDO;
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

	/**
	 * 通过字典名称查询字典对象
	 * @param dictionaryDO
	 * @return
	 */
	DictionaryDO getByDictName(DictionaryDO dictionaryDO);

    /**
     * 查询字典类型下拉选项
     * @return
     */
	List<DictionaryTypeDO> listType();

	/**
	 * 根据id删除字典类型，若该类型下有数据，类型不能删除
	 * @param typeId
	 * @return
	 */
	int removeById(String typeId);

	/**
	 * 批量删除字典类型，若该类型有数据，类型不能删除
	 * @param typeIds
	 * @return
	 */
	int batchRemove1(String[] typeIds);
	
	
}
