package com.bootdo.msgpush.dao;

import com.bootdo.msgpush.domain.MessagepushTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 消息推送类型表
 * @author anyalei
 * @email anyalei@sinosoft.com.cn
 * @date 2018-08-14 15:53:21
 */
@Mapper
public interface MessagepushTypeDao {

	MessagepushTypeDO get(String msgTypeId);
	
	List<MessagepushTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MessagepushTypeDO messagepushType);
	
	int update(MessagepushTypeDO messagepushType);
	
	int remove(String msg_type_id);
	
	int batchRemove(String[] msgTypeIds);
}
