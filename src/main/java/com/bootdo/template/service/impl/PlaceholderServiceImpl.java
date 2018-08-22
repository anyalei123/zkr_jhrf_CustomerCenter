package com.bootdo.template.service.impl;

import com.bootdo.common.utils.GenerateSequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.template.dao.PlaceholderDao;
import com.bootdo.template.domain.PlaceholderDO;
import com.bootdo.template.service.PlaceholderService;


/**
 * 占位符管理
 *
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Service
public class PlaceholderServiceImpl implements PlaceholderService {

	@Autowired
	private PlaceholderDao placeholderDao;

	/**
	 * 根据占位符id查询占位符
	 * @param placeholderId
	 * @return
	 */
	@Override
	public PlaceholderDO get(String placeholderId){
		return placeholderDao.get(placeholderId);
	}

	/**
	 * 查询占位符列表
	 * @param map
	 * @return
	 */
	@Override
	public List<PlaceholderDO> list(Map<String, Object> map){
		return placeholderDao.list(map);
	}

	/**
	 * 查询占位符列表数据总条数
	 * @param map
	 * @return
	 */
	@Override
	public int count(Map<String, Object> map){
		return placeholderDao.count(map);
	}

	/**
	 * 保存占位符信息
	 * @param placeholder
	 * @return
	 */
	@Override
	public int save(PlaceholderDO placeholder){
		//设置主键
		placeholder.setPlaceholderId(GenerateSequenceUtil.generateSequenceNo());
        //设置创建时间和修改时间为当前时间
		placeholder.setCreateTime(new Date());
		placeholder.setUpdateTime(new Date());
		return placeholderDao.save(placeholder);
	}

	/**
	 *修改占位符信息
	 * @param placeholder
	 * @return
	 */
	@Override
	public int update(PlaceholderDO placeholder){
		//设置修改时间为当前时间
		placeholder.setUpdateTime(new Date());
		return placeholderDao.update(placeholder);
	}

	/**
	 * 根据id删除占位符
	 * @param placeholderId
	 * @return
	 */
	@Override
	public int remove(String placeholderId){
		return placeholderDao.remove(placeholderId);
	}

	/**
	 * 批量删除占位符
	 * @param placeholderIds
	 * @return
	 */
	@Override
	public int batchRemove(String[] placeholderIds){
		return placeholderDao.batchRemove(placeholderIds);
	}
	
}
