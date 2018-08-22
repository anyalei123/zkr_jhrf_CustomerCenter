package com.bootdo.template.service.impl;

import com.bootdo.common.utils.GenerateSequenceUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.template.dao.TemplateTypeDao;
import com.bootdo.template.domain.TemplateTypeDO;
import com.bootdo.template.service.TemplateTypeService;


/**
 * 模板类型管理
 *
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Service
public class TemplateTypeServiceImpl implements TemplateTypeService {

	@Autowired
	private TemplateTypeDao templateTypeDao;

	/**
	 * 根据id查询模板类型
	 * @param typeId
	 * @return
	 */
	@Override
	public TemplateTypeDO get(String typeId){
		return templateTypeDao.get(typeId);
	}

	/**
	 * 查询模板类型列表
	 * @param map
	 * @return
	 */
	@Override
	public List<TemplateTypeDO> list(Map<String, Object> map){
		return templateTypeDao.list(map);
	}

	/**
	 * 查询模板类型列表数据
	 * 将模板类型名称展示到模板添加页面的模板类型下拉选项中
	 * @return
	 */
	@Override
	public List<TemplateTypeDO> listJson(){
		return templateTypeDao.listJson();
	}

	/**
	 * 查询模板类型列表数据总条数
	 * @param map
	 * @return
	 */
	@Override
	public int count(Map<String, Object> map){
		return templateTypeDao.count(map);
	}

	/**
	 * 保存模板类型
	 * @param templateType
	 * @return
	 */
	@Override
	public int save(TemplateTypeDO templateType){
		//设置主键
		templateType.setTypeId(GenerateSequenceUtil.generateSequenceNo());
		//设置创建时间和修改时间为当前时间
		templateType.setCreateTime(new Date());
		templateType.setUpdateTime(new Date());
		return templateTypeDao.save(templateType);
	}

	/**
	 * 修改模板类型
	 * @param templateType
	 * @return
	 */
	@Override
	public int update(TemplateTypeDO templateType){
		//设置修改时间为当前时间
		templateType.setUpdateTime(new Date());
		return templateTypeDao.update(templateType);
	}

	/**
	 * 根据id删除模板类型
	 * @param typeId
	 * @return
	 */
	@Override
	public int remove(String typeId){
		return templateTypeDao.remove(typeId);
	}

	/**
	 * 批量删除模板类型
	 * @param typeIds
	 * @return
	 */
	@Override
	public int batchRemove(String[] typeIds){
		return templateTypeDao.batchRemove(typeIds);
	}
	
}
