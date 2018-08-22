package com.bootdo.config.controller;

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
import com.bootdo.config.domain.DictionaryTypeDO;
import com.bootdo.config.service.DictionaryTypeService;

/**
 * 字典类型表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
 
@Controller
@RequestMapping("/config/dictionaryType")
public class DictionaryTypeController extends BaseController {
	@Autowired
	private DictionaryTypeService dictionaryTypeService;
	
	@GetMapping()
	@RequiresPermissions("config:dictionaryType:dictionaryType")
	String DictionaryType(){
	    return "config/dictionaryType/dictionaryType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("config:dictionaryType:dictionaryType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DictionaryTypeDO> dictionaryTypeList = dictionaryTypeService.list(query);
		int total = dictionaryTypeService.count(query);
		PageUtils pageUtils = new PageUtils(dictionaryTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("config:dictionaryType:add")
	String add(){
	    return "config/dictionaryType/add";
	}

	@GetMapping("/edit/{typeId}")
	@RequiresPermissions("config:dictionaryType:edit")
	String edit(@PathVariable("typeId") String typeId,Model model){
		DictionaryTypeDO dictionaryType = dictionaryTypeService.get(typeId);
		model.addAttribute("dictionaryType", dictionaryType);
	    return "config/dictionaryType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("config:dictionaryType:add")
	public R save( DictionaryTypeDO dictionaryType){
		
		//判断类型名称是否存在
		DictionaryTypeDO dictionaryType1 = dictionaryTypeService.getByTypeName(dictionaryType);
		if(dictionaryType1 !=null ){
			return R.error("字典类型名称  '"+dictionaryType1.getTypeName()+"' 已经存在,请勿重复创建!");
		}
		//设置主键
		dictionaryType.setTypeId(GenerateSequenceUtil.generateSequenceNo());
		
		//设置创建、修改信息
		dictionaryType.setCreateBy(this.getUsername());
		dictionaryType.setCreateById(String.valueOf(this.getUserId()));
		dictionaryType.setUpdateBy(this.getUsername());
		dictionaryType.setUpdateById(String.valueOf(this.getUserId()));
		
		//设置时间
		Date date = new Date();
		dictionaryType.setCreateTime(date);
		dictionaryType.setUpdateTime(date);
		
		
		if(dictionaryTypeService.save(dictionaryType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("config:dictionaryType:edit")
	public R update( DictionaryTypeDO dictionaryType){
		
		
		dictionaryType.setUpdateBy(this.getUsername());
		dictionaryType.setUpdateById(String.valueOf(this.getUserId()));
		
		//设置时间
		dictionaryType.setUpdateTime(new Date());
		
		dictionaryTypeService.update(dictionaryType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("config:dictionaryType:remove")
	public R remove( String typeId){
		if(dictionaryTypeService.remove(typeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("config:dictionaryType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] typeIds){
		dictionaryTypeService.batchRemove(typeIds);
		return R.ok();
	}
	
	/**
	 * 查看详细信息
	 */
	@GetMapping("/showDetail/{typeId}")
	@RequiresPermissions("config:dictionaryType:showDetail")
	String showDetail(@PathVariable("typeId") String typeId,Model model){
		//根据id查询并显示到明细页面
		DictionaryTypeDO dictionaryType = dictionaryTypeService.get(typeId);
		
		model.addAttribute("dictionaryType", dictionaryType);
		System.out.println("1111111111111111111");
	    return "config/dictionaryType/showDetail";
	}
}
