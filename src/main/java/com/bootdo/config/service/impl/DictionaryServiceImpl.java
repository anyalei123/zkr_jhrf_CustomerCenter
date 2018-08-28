package com.bootdo.config.service.impl;

import com.bootdo.config.dao.self.ConfigSelfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.config.dao.DictionaryDao;
import com.bootdo.config.domain.DictionaryDO;
import com.bootdo.config.service.DictionaryService;


/**
 * 字典管理
 *
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	@Autowired
	private ConfigSelfDao configSelfDao;
	
	@Override
	public DictionaryDO get(String dictId){
		return dictionaryDao.get(dictId);
	}
	
	@Override
	public List<DictionaryDO> list(Map<String, Object> map){
		return dictionaryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dictionaryDao.count(map);
	}
	
	@Override
	public int save(DictionaryDO dictionary){
		return dictionaryDao.save(dictionary);
	}
	
	@Override
	public int update(DictionaryDO dictionary){
		return dictionaryDao.update(dictionary);
	}
	
	@Override
	public int remove(String dictId){
		return dictionaryDao.remove(dictId);
	}
	
	@Override
	public int batchRemove(String[] dictIds){
		return dictionaryDao.batchRemove(dictIds);
	}

	/**
	 * 通过字典名称查询字典对象
	 * @param dictionaryDO
	 * @return
	 */
	@Override
	public DictionaryDO getByDictName(DictionaryDO dictionaryDO){
		return configSelfDao.getByDictName(dictionaryDO);
	}

	/**
	 * 根据字典类型名称查询字典数据
	 * @param typeName
	 * @return
	 */
	@Override
	public List<DictionaryDO> getByType(String typeName){
		return configSelfDao.getByType(typeName);
	}

	/**
	 * 根据字典数据值查询字典对象
	 * @param dictValue
	 * @return
	 */
	@Override
	public List<DictionaryDO> getByValue(String dictValue){
		return configSelfDao.getByValue(dictValue);
	}
	
}
