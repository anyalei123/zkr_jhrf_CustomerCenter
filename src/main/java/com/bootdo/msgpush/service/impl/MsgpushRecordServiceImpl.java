package com.bootdo.msgpush.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.msgpush.dao.MsgpushRecordDao;
import com.bootdo.msgpush.domain.MsgpushRecordDO;
import com.bootdo.msgpush.service.MsgpushRecordService;



@Service
public class MsgpushRecordServiceImpl implements MsgpushRecordService {
	@Autowired
	private MsgpushRecordDao msgpushRecordDao;
	
	@Override
	public MsgpushRecordDO get(String messageId){
		return msgpushRecordDao.get(messageId);
	}
	
	@Override
	public List<MsgpushRecordDO> list(Map<String, Object> map){
		return msgpushRecordDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return msgpushRecordDao.count(map);
	}
	
	@Override
	public int save(MsgpushRecordDO msgpushRecord){
		return msgpushRecordDao.save(msgpushRecord);
	}
	
	@Override
	public int update(MsgpushRecordDO msgpushRecord){
		return msgpushRecordDao.update(msgpushRecord);
	}
	
	@Override
	public int remove(String messageId){
		return msgpushRecordDao.remove(messageId);
	}
	
	@Override
	public int batchRemove(String[] messageIds){
		return msgpushRecordDao.batchRemove(messageIds);
	}
	
}
