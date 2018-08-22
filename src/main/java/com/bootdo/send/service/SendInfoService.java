package com.bootdo.send.service;

import com.bootdo.send.domain.SendInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 寄送管理
 * 
 * @author zhaolijuan
 * @date 2018-08-09 14:25:26
 */
public interface SendInfoService {

	/**
	 *根据id查询寄送信息
	 * @param sendId
	 * @return
	 */
	SendInfoDO get(String sendId);

	/**
	 * 根据寄送单号查询寄送信息
	 * @param sendOrderno
	 * @return
	 */
	SendInfoDO getByOrderno(String sendOrderno);

	/**
	 * 查询寄送信息列表
	 * @param map
	 * @return
	 */
	List<SendInfoDO> list(Map<String, Object> map);

	/**
	 * 查询寄送信息列表数据总条数
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);

	/**
	 *保存寄送信息
	 * @param sendInfo
	 * @return
	 */
	int save(SendInfoDO sendInfo);

	/**
	 * 修改寄送信息
	 * @param sendInfo
	 * @return
	 */
	int update(SendInfoDO sendInfo);

	/**
	 * 根据id删除寄送信息
	 * @param sendId
	 * @return
	 */
	int remove(String sendId);

	/**
	 * 批量删除寄送信息
	 * @param sendIds
	 * @return
	 */
	int batchRemove(String[] sendIds);
}
