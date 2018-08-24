package com.bootdo.config.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.GenerateSequenceUtil;
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

import com.bootdo.config.domain.DictionaryDO;
import com.bootdo.config.service.DictionaryService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 字典表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
 
@Controller
@RequestMapping("/config/dictionary")
public class DictionaryController extends BaseController {
	@Autowired
	private DictionaryService dictionaryService;
	
	@GetMapping()
	@RequiresPermissions("config:dictionary:dictionary")
	String Dictionary(){
	    return "config/dictionary/dictionary";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("config:dictionary:dictionary")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DictionaryDO> dictionaryList = dictionaryService.list(query);
		int total = dictionaryService.count(query);
		PageUtils pageUtils = new PageUtils(dictionaryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("config:dictionary:add")
	String add(){
	    return "config/dictionary/add";
	}

	@GetMapping("/edit/{dictId}")
	@RequiresPermissions("config:dictionary:edit")
	String edit(@PathVariable("dictId") String dictId,Model model){
		DictionaryDO dictionary = dictionaryService.get(dictId);
		model.addAttribute("dictionary", dictionary);
	    return "config/dictionary/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("config:dictionary:add")
	public R save( DictionaryDO dictionary){
        //判断字典名称是否存在
		DictionaryDO dictionary1 = dictionaryService.getByDictName(dictionary);
		if(dictionary1 != null){
			return R.error("字典名称  '"+dictionary1.getDictName()+"' 已经存在,请勿重复创建!");
		}
		//设置主键
		dictionary.setDictId(GenerateSequenceUtil.generateSequenceNo());
		//设置创建人修改人信息
		dictionary.setCreateById(String.valueOf(this.getUserId()));
		dictionary.setCreateBy(this.getUsername());
		dictionary.setUpdateById(String.valueOf(this.getUserId()));
		dictionary.setUpdateBy(this.getUsername());
		//设置创建时间修改时间
		dictionary.setCreateTime(new Date());
		dictionary.setUpdateTime(new Date());
		//设置删除标记（0：未删除，1：已删除）
		dictionary.setDelFlag("0");
		//去除空格
		dictionary.setDictName(dictionary.getDictName().trim());
		dictionary.setDictValue(dictionary.getDictValue().trim());
		if(dictionaryService.save(dictionary)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("config:dictionary:edit")
	public R update( DictionaryDO dictionary){
		//判断字典名称是否存在
		DictionaryDO dictionary1 = dictionaryService.getByDictName(dictionary);
		if(dictionary1 != null && !dictionary1.getDictId().equals(dictionary.getDictId())){
			return R.error("字典名称  '"+dictionary1.getDictName()+"' 已经存在,请勿重复创建!");
		}
        //设置修改人信息
		dictionary.setUpdateById(String.valueOf(this.getUserId()));
		dictionary.setUpdateBy(this.getUsername());
        //设置修改时间
		dictionary.setUpdateTime(new Date());
		//去除空格
		dictionary.setDictName(dictionary.getDictName().trim());
		dictionary.setDictValue(dictionary.getDictValue().trim());

		dictionaryService.update(dictionary);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("config:dictionary:remove")
	public R remove( String dictId){
		if(dictionaryService.remove(dictId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("config:dictionary:batchRemove")
	public R remove(@RequestParam("ids[]") String[] dictIds){
		dictionaryService.batchRemove(dictIds);
		return R.ok();
	}
	
	/**
	 * 查看字典详情
	 */
	@GetMapping("/showDetail/{dictId}")
	@RequiresPermissions("config:dictionary:showDetail")
	String showDetail(@PathVariable("dictId")  String dictId,Model model){
		DictionaryDO dictionaryDO = dictionaryService.get(dictId);
		model.addAttribute("dictionary",dictionaryDO);
		return "config/dictionary/showDetail";
	}

}
