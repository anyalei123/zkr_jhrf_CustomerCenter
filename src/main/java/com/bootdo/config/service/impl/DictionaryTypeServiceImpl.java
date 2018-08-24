package com.bootdo.config.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.config.dao.DictionaryTypeDao;
import com.bootdo.config.dao.self.ConfigSelfDao;
import com.bootdo.config.domain.DictionaryTypeDO;
import com.bootdo.config.service.DictionaryTypeService;



@Service
public class DictionaryTypeServiceImpl implements DictionaryTypeService {

	@Autowired
	private DictionaryTypeDao dictionaryTypeDao;
	
	@Autowired
	private ConfigSelfDao  configSelfDao;
	
	@Override
	public DictionaryTypeDO get(String typeId){
		return dictionaryTypeDao.get(typeId);
	}
	
	@Override
	public List<DictionaryTypeDO> list(Map<String, Object> map){
		return dictionaryTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dictionaryTypeDao.count(map);
	}
	
	@Override
	public int save(DictionaryTypeDO dictionaryType){
		return dictionaryTypeDao.save(dictionaryType);
	}
	
	@Override
	public int update(DictionaryTypeDO dictionaryType){
		return dictionaryTypeDao.update(dictionaryType);
	}
	
	@Override
	public int remove(String typeId){
		return dictionaryTypeDao.remove(typeId);
	}
	
	@Override
	public int batchRemove(String[] typeIds){
		return dictionaryTypeDao.batchRemove(typeIds);
	}

	/**
	 * 通过字典类型名称查询对象
	 * @param
	 * @return
	 * @author ayl
	 * @create 2018-08-21 18:42:27
	 */
	@Override
	public DictionaryTypeDO getByTypeName(DictionaryTypeDO dictionaryType) {
		return configSelfDao.getByTypeName(dictionaryType);
	}

	/**
	 * 查询字典类型下拉选项
	 * @return
	 */
	@Override
	public List<DictionaryTypeDO> listType(){
        return configSelfDao.listType();
	}

	/**
	 * 根据id删除字典类型，若该类型下有数据，类型不能删除
	 * @param typeId
	 * @return
	 */
	@Override
	public int removeById(String typeId){
		return configSelfDao.removeById(typeId);
	}

	/**
	 * 批量删除字典类型，若该类型有数据，类型不能删除
	 * @param typeIds
	 * @return
	 */
	@Override
	public int batchRemove1(String[] typeIds){
		return configSelfDao.batchRemove1(typeIds);
	}
	
}
