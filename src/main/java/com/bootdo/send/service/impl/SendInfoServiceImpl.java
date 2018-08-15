package com.bootdo.send.service.impl;

import com.bootdo.common.utils.GenerateSequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.send.dao.SendInfoDao;
import com.bootdo.send.domain.SendInfoDO;
import com.bootdo.send.service.SendInfoService;


/**
 * 寄送管理
 *
 * @author zhaolijuan
 * @date 2018-08-09 14:25:26
 */
@Service
public class SendInfoServiceImpl implements SendInfoService {

	@Autowired
	private SendInfoDao sendInfoDao;

	/**
	 *根据id查询寄送信息
	 * @param sendId
	 * @return
	 */
	@Override
	public SendInfoDO get(String sendId){
		return sendInfoDao.get(sendId);
	}

	/**
	 * 查询寄送信息列表
	 * @param map
	 * @return
	 */
	@Override
	public List<SendInfoDO> list(Map<String, Object> map){
		return sendInfoDao.list(map);
	}

	/**
	 * 查询寄送信息列表数据总条数
	 * @param map
	 * @return
	 */
	@Override
	public int count(Map<String, Object> map){
		return sendInfoDao.count(map);
	}

	/**
	 * 保存寄送信息
	 * @param sendInfo
	 * @return
	 */
	@Override
	public int save(SendInfoDO sendInfo){
		//设置主键
		sendInfo.setSendId(GenerateSequenceUtil.generateSequenceNo());
		//设置创建时间为当前时间
		sendInfo.setCreateTime(new Date());
		//设置修改时间为当前时间
		sendInfo.setUpdateTime(new Date());
		return sendInfoDao.save(sendInfo);
	}

	/**
	 * 修改寄送信息
	 * @param sendInfo
	 * @return
	 */
	@Override
	public int update(SendInfoDO sendInfo){
		//设置修改时间为当前时间
		sendInfo.setUpdateTime(new Date());
		return sendInfoDao.update(sendInfo);
	}

	/**
	 * 根据id删除寄送信息
	 * @param sendId
	 * @return
	 */
	@Override
	public int remove(String sendId){
		return sendInfoDao.remove(sendId);
	}

	/**
	 * 批量删除寄送信息
	 * @param sendIds
	 * @return
	 */
	@Override
	public int batchRemove(String[] sendIds){
		return sendInfoDao.batchRemove(sendIds);
	}
	
}
