package com.bootdo.template.dao;

import com.bootdo.template.domain.TemplateTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 模板类型管理
 *
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Mapper
public interface TemplateTypeDao {

	/**
	 * 根据id查询模板类型
	 * @param typeId
	 * @return
	 */
	TemplateTypeDO get(String typeId);

	/**
	 * 查询模板类型列表
	 * @param map
	 * @return
	 */
	List<TemplateTypeDO> list(Map<String, Object> map);

	/**
	 * 查询模板类型列表数据
	 * 将模板类型名称展示到模板添加页面的模板类型下拉选项中
	 * @return
	 */
	List<TemplateTypeDO> listJson();

	/**
	 * 查询模板类型列表数据总条数
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);

	/**
	 * 保存模板类型
	 * @param templateType
	 * @return
	 */
	int save(TemplateTypeDO templateType);

	/**
	 * 修改模板类型
	 * @param templateType
	 * @return
	 */
	int update(TemplateTypeDO templateType);

	/**
	 * 根据id删除模板类型
	 * @param typeId
	 * @return
	 */
	int remove(String typeId);

	/**
	 * 批量删除模板类型
	 * @param typeIds
	 * @return
	 */
	int batchRemove(String[] typeIds);
}
