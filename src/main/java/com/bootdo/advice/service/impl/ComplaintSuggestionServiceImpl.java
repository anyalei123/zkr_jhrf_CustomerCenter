package com.bootdo.advice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.advice.dao.ComplaintSuggestionDao;
import com.bootdo.advice.domain.ComplaintSuggestionDO;
import com.bootdo.advice.service.ComplaintSuggestionService;



@Service
public class ComplaintSuggestionServiceImpl implements ComplaintSuggestionService {
	@Autowired
	private ComplaintSuggestionDao complaintSuggestionDao;
	
	@Override
	public ComplaintSuggestionDO get(String messageNumber){
		return complaintSuggestionDao.get(messageNumber);
	}
	
	@Override
	public List<ComplaintSuggestionDO> list(Map<String, Object> map){
		return complaintSuggestionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return complaintSuggestionDao.count(map);
	}
	
	@Override
	public int save(ComplaintSuggestionDO complaintSuggestion){
		return complaintSuggestionDao.save(complaintSuggestion);
	}
	
	@Override
	public int update(ComplaintSuggestionDO complaintSuggestion){
		return complaintSuggestionDao.update(complaintSuggestion);
	}
	
	@Override
	public int remove(String messageNumber){
		return complaintSuggestionDao.remove(messageNumber);
	}
	
	@Override
	public int batchRemove(String[] messageNumbers){
		return complaintSuggestionDao.batchRemove(messageNumbers);
	}
	
}
