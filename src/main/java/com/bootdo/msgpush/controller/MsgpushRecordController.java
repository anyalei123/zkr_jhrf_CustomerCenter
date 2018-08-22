package com.bootdo.msgpush.controller;

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

import com.bootdo.msgpush.domain.MsgpushRecordDO;
import com.bootdo.msgpush.service.MsgpushRecordService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 消息推送记录表
 * 
 * @author anyalei
 * @email anyalei163i@163.com.cn
 * @date 2018-08-17 15:52:27
 */
 
@Controller
@RequestMapping("/msgpush/msgpushRecord")
public class MsgpushRecordController {
	@Autowired
	private MsgpushRecordService msgpushRecordService;
	
	@GetMapping()
	@RequiresPermissions("msgpush:msgpushRecord:msgpushRecord")
	String MsgpushRecord(){
	    return "msgpush/msgpushRecord/msgpushRecord";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("msgpush:msgpushRecord:msgpushRecord")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MsgpushRecordDO> msgpushRecordList = msgpushRecordService.list(query);
		int total = msgpushRecordService.count(query);
		PageUtils pageUtils = new PageUtils(msgpushRecordList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("msgpush:msgpushRecord:add")
	String add(){
	    return "msgpush/msgpushRecord/add";
	}

	@GetMapping("/edit/{messageId}")
	@RequiresPermissions("msgpush:msgpushRecord:edit")
	String edit(@PathVariable("messageId") String messageId,Model model){
		MsgpushRecordDO msgpushRecord = msgpushRecordService.get(messageId);
		model.addAttribute("msgpushRecord", msgpushRecord);
	    return "msgpush/msgpushRecord/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("msgpush:msgpushRecord:add")
	public R save( MsgpushRecordDO msgpushRecord){
		if(msgpushRecordService.save(msgpushRecord)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("msgpush:msgpushRecord:edit")
	public R update( MsgpushRecordDO msgpushRecord){
		msgpushRecordService.update(msgpushRecord);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("msgpush:msgpushRecord:remove")
	public R remove( String messageId){
		if(msgpushRecordService.remove(messageId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("msgpush:msgpushRecord:batchRemove")
	public R remove(@RequestParam("ids[]") String[] messageIds){
		msgpushRecordService.batchRemove(messageIds);
		return R.ok();
	}
	
}
