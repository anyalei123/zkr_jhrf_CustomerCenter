package com.bootdo.msgpush.service;

import com.bootdo.msgpush.domain.MessagepushTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 消息推送类型表
 * 
 * @author anyalei
 * @email anyalei@sinosoft.com.cn
 * @date 2018-08-14 15:53:21
 */
public interface MessagepushTypeService {
	
	MessagepushTypeDO get(String msgTypeId);
	
	List<MessagepushTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MessagepushTypeDO messagepushType);
	
	int update(MessagepushTypeDO messagepushType);
	
	int remove(String msgTypeId);
	
	int batchRemove(String[] msgTypeIds);
}
