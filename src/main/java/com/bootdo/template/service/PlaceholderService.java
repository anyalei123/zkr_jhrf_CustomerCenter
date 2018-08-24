package com.bootdo.template.service;

import com.bootdo.template.domain.PlaceholderDO;

import java.util.List;
import java.util.Map;

/**
 * 占位符管理
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
public interface PlaceholderService {

	/**
	 * 根据占位符id查询占位符
	 * @param placeholderId
	 * @return
	 */
	PlaceholderDO get(String placeholderId);

	/**
	 * 查询占位符列表
	 * @param map
	 * @return
	 */
	List<PlaceholderDO> list(Map<String, Object> map);

	/**
	 * 查询占位符列表数据总条数
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);

	/**
	 * 保存占位符信息
	 * @param placeholder
	 * @return
	 */
	int save(PlaceholderDO placeholder);

	/**
	 *修改占位符信息
	 * @param placeholder
	 * @return
	 */
	int update(PlaceholderDO placeholder);

	/**
	 * 根据id删除占位符
	 * @param placeholderId
	 * @return
	 */
	int remove(String placeholderId);

	/**
	 * 批量删除占位符
	 * @param placeholderIds
	 * @return
	 */
	int batchRemove(String[] placeholderIds);
}
