package com.bootdo.advice.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.advice.domain.ComplaintSuggestionDO;
import com.bootdo.advice.service.ComplaintSuggestionService;
import com.bootdo.common.utils.GenerateSequenceUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chl
 * @email 1992lcg@163.com
 * @date 2018-08-02 23:15:55
 */
 
@Controller
@RequestMapping("/advice/complaintSuggestion")
public class ComplaintSuggestionController {
	@Autowired
	private ComplaintSuggestionService complaintSuggestionService;
	
	@GetMapping()
	@RequiresPermissions("advice:complaintSuggestion:complaintSuggestion")
	String ComplaintSuggestion(){
	    return "advice/complaintSuggestion/complaintSuggestion";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("advice:complaintSuggestion:complaintSuggestion")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ComplaintSuggestionDO> complaintSuggestionList = complaintSuggestionService.list(query);
		int total = complaintSuggestionService.count(query);
		PageUtils pageUtils = new PageUtils(complaintSuggestionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("advice:complaintSuggestion:add")
	String add(){
	    return "advice/complaintSuggestion/add";
	}

	@GetMapping("/edit/{messageNumber}")
	@RequiresPermissions("advice:complaintSuggestion:edit")
	String edit(@PathVariable("messageNumber") String messageNumber,Model model){
		ComplaintSuggestionDO complaintSuggestion = complaintSuggestionService.get(messageNumber);
		model.addAttribute("complaintSuggestion", complaintSuggestion);
	    return "advice/complaintSuggestion/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("advice:complaintSuggestion:add")
	public R save( ComplaintSuggestionDO complaintSuggestion){
		complaintSuggestion.setMessageNumber(GenerateSequenceUtil.generateSequenceNo());
		if(complaintSuggestionService.save(complaintSuggestion)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("advice:complaintSuggestion:edit")
	public R update( ComplaintSuggestionDO complaintSuggestion){
		complaintSuggestionService.update(complaintSuggestion);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("advice:complaintSuggestion:remove")
	public R remove( String messageNumber){
		if(complaintSuggestionService.remove(messageNumber)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("advice:complaintSuggestion:batchRemove")
	public R remove(@RequestParam("ids[]") String[] messageNumbers){
		complaintSuggestionService.batchRemove(messageNumbers);
		return R.ok();
	}
	
}
