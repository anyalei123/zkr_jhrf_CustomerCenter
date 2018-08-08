package com.bootdo.advice.service;

import com.bootdo.advice.domain.ComplaintSuggestionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chl
 * @email 18510022401@163.com
 * @date 2018-08-02 23:15:55
 */
public interface ComplaintSuggestionService {
	
	ComplaintSuggestionDO get(String messageNumber);
	
	List<ComplaintSuggestionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ComplaintSuggestionDO complaintSuggestion);
	
	int update(ComplaintSuggestionDO complaintSuggestion);
	
	int remove(String messageNumber);
	
	int batchRemove(String[] messageNumbers);
}
