package com.bootdo.configureManager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.configureManager.domain.DictionaryDO;

/**
 * 字典表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 11:34:31
 */
@Mapper
public interface DictionaryDao {

	//根据ID查询
	DictionaryDO get(String dictId);
	
	//根据参数个数查询
	List<DictionaryDO> list(Map<String,Object> map);
	
	//下拉列表赋值
	List<DictionaryDO> list1();
	//计数
	int count(Map<String,Object> map);
	
	//添加
	int save(DictionaryDO dictionary);
	//修改
	int update(DictionaryDO dictionary);
	//删除
	int remove(String dict_id);
	//删除多项
	int batchRemove(String[] dictIds);
}
