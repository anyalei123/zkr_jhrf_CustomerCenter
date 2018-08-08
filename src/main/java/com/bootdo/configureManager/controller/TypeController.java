package com.bootdo.configureManager.controller;

import java.util.Date;
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

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.configureManager.domain.DictionaryDO;
import com.bootdo.configureManager.domain.TypeDO;
import com.bootdo.configureManager.service.TypeService;

/**
 * 字典类型表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 11:34:37
 */
 
@Controller
@RequestMapping("/configureManager/type")
public class TypeController extends BaseController {
	@Autowired
	private TypeService typeService;
	
	@GetMapping()
	@RequiresPermissions("configureManager:type:type")
	String Type(){
	    return "configureManager/type/type";
	}
	
	
	
	/**
	 * 根据传入的参数查询数据 参数为空查所有
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("configureManager:type:type")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TypeDO> typeList = typeService.list(query);
		int total = typeService.count(query);
		PageUtils pageUtils = new PageUtils(typeList, total);
		return pageUtils;
	}
	
	
	//添加
	@GetMapping("/add")
	@RequiresPermissions("configureManager:type:add")
	String add(){
	    return "configureManager/type/add";
	}

	/**
	 * 根据主键ID查询
	 * @param typeId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{typeId}")
	@RequiresPermissions("configureManager:type:edit")
	String edit(@PathVariable("typeId") String typeId,Model model){
		TypeDO type = typeService.get(typeId);
		model.addAttribute("type", type);
	    return "configureManager/type/edit";
	}
	
	/**
	 * 查看详情
	 * @param dictId
	 * @param model
	 * @return
	 */
	@GetMapping("/see/{typeId}")
	@RequiresPermissions("configureManager:type:see")
	String see(@PathVariable("typeId") String typeId,Model model){
		TypeDO type = typeService.get(typeId);
		model.addAttribute("type", type);
	    return "configureManager/type/seeDetails";
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("configureManager:type:add")
	public R save( TypeDO type){
		type.setCreateBy(this.getUsername());
		type.setCreateTime(new Date());
		if(typeService.save(type)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("configureManager:type:edit")
	public R update( TypeDO type){
		type.setUpdateBy(this.getUsername());
		type.setUpdateTime(new Date());
		typeService.update(type);
		return R.ok();
	}
	

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("configureManager:type:remove")
	public R remove( String typeId){
		if(typeService.remove(typeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 多选删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("configureManager:type:batchRemove")
	public R remove(@RequestParam("ids[]") String[] typeIds){
		typeService.batchRemove(typeIds);
		return R.ok();
	}
	
}
