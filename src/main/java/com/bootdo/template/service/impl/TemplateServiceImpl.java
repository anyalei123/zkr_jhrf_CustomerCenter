package com.bootdo.template.service.impl;

import com.bootdo.common.utils.GenerateSequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.template.dao.TemplateDao;
import com.bootdo.template.domain.TemplateDO;
import com.bootdo.template.service.TemplateService;


/**
 * 模板管理
 *
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDao templateDao;

	/**
	 * 根据模板id查询模板
	 * @param templateId
	 * @return
	 */
	@Override
	public TemplateDO get(String templateId){
		return templateDao.get(templateId);
	}

	/**
	 * 查询模板列表
	 * @param map
	 * @return
	 */
	@Override
	public List<TemplateDO> list(Map<String, Object> map){
		return templateDao.list(map);
	}

	/**
	 * 查询模板列表数据总条数
	 * @param map
	 * @return
	 */
	@Override
	public int count(Map<String, Object> map){
		return templateDao.count(map);
	}

	/**
	 * 保存模板信息
	 * @param template
	 * @return
	 */
	@Override
	public int save(TemplateDO template){
		//工具类生成主键
		String templateId = GenerateSequenceUtil.generateSequenceNo();
		//设置主键
		template.setTemplateId(templateId);
		//获取当前时间
		Date date = new Date();
		//设置创建时间为当前时间
		template.setCreateTime(date);
		//设置修改时间为当前时间
		template.setUpdateTime(date);
		return templateDao.save(template);
	}

	/**
	 * 修改模板信息
	 * @param template
	 * @return
	 */
	@Override
	public int update(TemplateDO template){
		//获取当前时间
		Date date = new Date();
		//设置修改时间为当前时间
		template.setUpdateTime(date);
		return templateDao.update(template);
	}

	/**
	 * 根据id删除模板
	 * @param templateId
	 * @return
	 */
	@Override
	public int remove(String templateId){
		return templateDao.remove(templateId);
	}

	/**
	 * 批量删除模板
	 * @param templateIds
	 * @return
	 */
	@Override
	public int batchRemove(String[] templateIds){
		return templateDao.batchRemove(templateIds);
	}
	
}
