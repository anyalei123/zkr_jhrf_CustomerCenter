package com.bootdo.configureManager.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.configureManager.domain.DictionaryDO;
import com.bootdo.configureManager.service.DictionaryService;

/**
 * 字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 11:34:31
 */
 
@Controller
@RequestMapping("/configureManager/dictionary")
public class DictionaryController extends BaseController {
	@Autowired
	private DictionaryService dictionaryService;
	
	
	
	/**
	 * 初始化时
	 * @param model
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("configureManager:dictionary:dictionary")
	String Dictionary(Model model){
		//初始化时给下拉列表复制
	List<DictionaryDO> list1=  dictionaryService.list1();
	model.addAttribute("list1", list1);
	    return "configureManager/dictionary/dictionary";
	}
	
	
	/**
	 *根据传入的参数查询数据   参数为空查所有
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("configureManager:dictionary:dictionary")
	public PageUtils list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<DictionaryDO> dictionaryList = dictionaryService.list(query);
		int total = dictionaryService.count(query);
		PageUtils pageUtils = new PageUtils(dictionaryList, total);
		return pageUtils;
	}
	

	
	/**
	 * 添加
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("configureManager:dictionary:add")
	String add(){
	    return "configureManager/dictionary/add";
	}

	
	/*
	 *根据ID查询数据 
	 */
	@GetMapping("/edit/{dictId}")
	@RequiresPermissions("configureManager:dictionary:edit")
	String edit(@PathVariable("dictId") String dictId,Model model){
		DictionaryDO dictionary = dictionaryService.get(dictId);
		model.addAttribute("dictionary", dictionary);
	    return "configureManager/dictionary/edit";
	}
	
	
	/**
	 * 查看详情
	 * @param dictId
	 * @param model
	 * @return
	 */
	@GetMapping("/see/{dictId}")
	@RequiresPermissions("configureManager:dictionary:see")
	String see(@PathVariable("dictId") String dictId,Model model){
		DictionaryDO dictionary = dictionaryService.get(dictId);
		model.addAttribute("dictionary", dictionary);
	    return "configureManager/dictionary/seeDetails";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("configureManager:dictionary:add")
	public R save( DictionaryDO dictionary){
		dictionary.setCreateTime(new Date());
		dictionary.setCreateBy(this.getUsername());
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
	@RequiresPermissions("configureManager:dictionary:edit")
	public R update( DictionaryDO dictionary){
		dictionary.setUpdateBy(this.getUsername());
		dictionary.setUpdateTime(new Date());
		dictionaryService.update(dictionary);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("configureManager:dictionary:remove")
	public R remove( String dictId){
		if(dictionaryService.remove(dictId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 多选删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("configureManager:dictionary:batchRemove")
	public R remove(@RequestParam("ids[]") String[] dictIds){
		dictionaryService.batchRemove(dictIds);
		return R.ok();
	}
	
}
