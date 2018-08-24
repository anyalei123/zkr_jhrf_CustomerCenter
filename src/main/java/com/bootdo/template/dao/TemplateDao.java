package com.bootdo.template.dao;

import com.bootdo.template.domain.TemplateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 模板管理
 *
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Mapper
public interface TemplateDao {

	/**
	 * 根据模板id查询模板
	 * @param templateId
	 * @return
	 */
	TemplateDO get(String templateId);

	/**
	 * 查询模板列表
	 * @param map
	 * @return
	 */
	List<TemplateDO> list(Map<String, Object> map);

	/**
	 * 查询模板列表数据总条数
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);

	/**
	 * 保存模板信息
	 * @param template
	 * @return
	 */
	int save(TemplateDO template);

	/**
	 * 修改模板信息
	 * @param template
	 * @return
	 */
	int update(TemplateDO template);

	/**
	 * 根据id删除模板
	 * @param templateId
	 * @return
	 */
	int remove(String templateId);

	/**
	 * 批量删除模板
	 * @param templateIds
	 * @return
	 */
	int batchRemove(String[] templateIds);
}
