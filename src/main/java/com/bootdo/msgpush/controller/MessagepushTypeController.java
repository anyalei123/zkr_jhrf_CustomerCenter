package com.bootdo.msgpush.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.GenerateSequenceUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.msgpush.domain.MessagepushTypeDO;
import com.bootdo.msgpush.service.MessagepushTypeService;

/**
 * 消息推送类型表
 * 
 * @author anyalei
 * @email anyalei@sinosoft.com.cn
 * @date 2018-08-14 15:53:21
 */
 
@Controller
@RequestMapping("/msgpush/messagepushType")
public class MessagepushTypeController extends BaseController{
	@Autowired
	private MessagepushTypeService messagepushTypeService;
	
	@GetMapping()
	@RequiresPermissions("msgpush:messagepushType:messagepushType")
	String MessagepushType(){
	    return "msgpush/messagepushType/messagepushType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("msgpush:messagepushType:messagepushType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MessagepushTypeDO> messagepushTypeList = messagepushTypeService.list(query);
		int total = messagepushTypeService.count(query);
		PageUtils pageUtils = new PageUtils(messagepushTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("msgpush:messagepushType:add")
	String add(){
	    return "msgpush/messagepushType/add";
	}

	/*
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{msgTypeId}")
	@RequiresPermissions("msgpush:messagepushType:edit")
	String edit(@PathVariable("msgTypeId") String msgTypeId,Model model){
		//根据id查询出消息推送类型
		MessagepushTypeDO messagepushType = messagepushTypeService.get(msgTypeId);
		
		//数据回显
		model.addAttribute("messagepushType", messagepushType);
	    return "msgpush/messagepushType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("msgpush:messagepushType:add")
	public R save( MessagepushTypeDO messagepushType){
		
		//设置id
		messagepushType.setMsgTypeId(GenerateSequenceUtil.generateSequenceNo());
		//去除前后空格
		messagepushType.setTypeName(messagepushType.getTypeName().trim());
		messagepushType.setTypeDesc(messagepushType.getTypeDesc().trim());
		
		//设置创建人、修改人
		messagepushType.setCreateBy(this.getUsername());
		messagepushType.setCreateById(String.valueOf(this.getUserId()));
		messagepushType.setUpdateBy(this.getUsername());
		messagepushType.setUpdateById(String.valueOf(this.getUserId()));
		//设置创建、修改时间
		Date date = new Date();
		messagepushType.setUpdateTime(date);
		messagepushType.setCreateTime(date);
		
		if(messagepushTypeService.save(messagepushType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改后的提交方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("msgpush:messagepushType:edit")
	public R update( MessagepushTypeDO messagepushType){
		
		//去除前后空格
		messagepushType.setTypeName(messagepushType.getTypeName().trim());
		messagepushType.setTypeDesc(messagepushType.getTypeDesc().trim());
	
		//设置修改人、修改时间
		messagepushType.setUpdateBy(this.getUsername());
		messagepushType.setUpdateById(String.valueOf(this.getUserId()));
		messagepushType.setUpdateTime(new Date());
		
		
		messagepushTypeService.update(messagepushType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("msgpush:messagepushType:remove")
	public R remove( String msgTypeId){
		if(messagepushTypeService.remove(msgTypeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("msgpush:messagepushType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] msgTypeIds){
		messagepushTypeService.batchRemove(msgTypeIds);
		return R.ok();
	}
	
}
