package com.bootdo.msgpush.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.msgpush.dao.MessagepushTypeDao;
import com.bootdo.msgpush.domain.MessagepushTypeDO;
import com.bootdo.msgpush.service.MessagepushTypeService;



@Service
public class MessagepushTypeServiceImpl implements MessagepushTypeService {
	@Autowired
	private MessagepushTypeDao messagepushTypeDao;
	
	@Override
	public MessagepushTypeDO get(String msgTypeId){
		return messagepushTypeDao.get(msgTypeId);
	}
	
	@Override
	public List<MessagepushTypeDO> list(Map<String, Object> map){
		return messagepushTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return messagepushTypeDao.count(map);
	}
	
	@Override
	public int save(MessagepushTypeDO messagepushType){
		return messagepushTypeDao.save(messagepushType);
	}
	
	@Override
	public int update(MessagepushTypeDO messagepushType){
		return messagepushTypeDao.update(messagepushType);
	}
	
	@Override
	public int remove(String msgTypeId){
		return messagepushTypeDao.remove(msgTypeId);
	}
	
	@Override
	public int batchRemove(String[] msgTypeIds){
		return messagepushTypeDao.batchRemove(msgTypeIds);
	}
	
}
