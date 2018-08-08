package com.bootdo.advice.dao;

import com.bootdo.advice.domain.ComplaintSuggestionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chl
 * @email 1992lcg@163.com
 * @date 2018-08-02 23:15:55
 */
@Mapper
public interface ComplaintSuggestionDao {

	ComplaintSuggestionDO get(String messageNumber);
	
	List<ComplaintSuggestionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ComplaintSuggestionDO complaintSuggestion);
	
	int update(ComplaintSuggestionDO complaintSuggestion);
	
	int remove(String message_number);
	
	int batchRemove(String[] messageNumbers);
}
