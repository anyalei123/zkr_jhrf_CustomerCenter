package com.bootdo.msgpush.dao;

import com.bootdo.msgpush.domain.MsgpushRecordDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 消息推送记录表
 * @author anyalei
 * @email anyalei163i@163.com.cn
 * @date 2018-08-17 15:52:27
 */
@Mapper
public interface MsgpushRecordDao {

	MsgpushRecordDO get(String messageId);
	
	List<MsgpushRecordDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MsgpushRecordDO msgpushRecord);
	
	int update(MsgpushRecordDO msgpushRecord);
	
	int remove(String message_id);
	
	int batchRemove(String[] messageIds);
}
