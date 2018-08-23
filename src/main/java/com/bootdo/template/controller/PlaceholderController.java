package com.bootdo.template.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.template.domain.PlaceholderDO;
import com.bootdo.template.service.PlaceholderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 占位符管理
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Controller
@RequestMapping("/template/placeholder")
public class PlaceholderController extends BaseController {

	@Autowired
	private PlaceholderService placeholderService;

	/**
	 * 到占位符列表页面
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("template:placeholder:placeholder")
	String Placeholder(){
	    return "template/placeholder/placeholder";
	}

	/**
	 * 查询占位符列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("template:placeholder:placeholder")
	public PageUtils list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		//查询占位符列表数据
		List<PlaceholderDO> placeholderList = placeholderService.list(query);
		int total = placeholderService.count(query);
		PageUtils pageUtils = new PageUtils(placeholderList, total);
		return pageUtils;
	}

	/**
	 * 到占位符添加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("template:placeholder:add")
	String add(){
	    return "template/placeholder/add";
	}

	/**
	 * 到占位符修改页面
	 * @param placeholderId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{placeholderId}")
	@RequiresPermissions("template:placeholder:edit")
	String edit(@PathVariable("placeholderId") String placeholderId,Model model){
		//根据占位符id查询占位符
		PlaceholderDO placeholder = placeholderService.get(placeholderId);
		model.addAttribute("placeholder", placeholder);
	    return "template/placeholder/edit";
	}

	/**
	 * 保存占位符信息
	 * @param placeholder
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("template:placeholder:add")
	public R save( PlaceholderDO placeholder){
		//设置主键
		placeholder.setPlaceholderId(GenerateSequenceUtil.generateSequenceNo());
		//设置创建时间和修改时间为当前时间
		placeholder.setCreateTime(new Date());
		placeholder.setUpdateTime(new Date());
		//设置创建人和修改人
        placeholder.setCreateById(String.valueOf(this.getUserId()));
        placeholder.setUpdateById(String.valueOf(this.getUserId()));
		placeholder.setCreateBy(this.getUsername());
		placeholder.setUpdateBy(this.getUsername());
		//去除空格
		placeholder.setPlaceholderCode(placeholder.getPlaceholderCode().trim());
		placeholder.setPlaceholderName(placeholder.getPlaceholderName().trim());
		placeholder.setPlaceholderType(placeholder.getPlaceholderType().trim());
		//保存成功
		if(placeholderService.save(placeholder)>0){
			return R.ok();
		}
		//保存失败
		return R.error();
	}

	/**
	 * 修改占位符信息
	 * @param placeholder
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("template:placeholder:edit")
	public R update( PlaceholderDO placeholder){
		//设置修改时间为当前时间
		placeholder.setUpdateTime(new Date());
		//设置修改人
		placeholder.setUpdateById(String.valueOf(this.getUserId()));
		placeholder.setUpdateBy(this.getUsername());
		//去除空格
		placeholder.setPlaceholderCode(placeholder.getPlaceholderCode().trim());
		placeholder.setPlaceholderName(placeholder.getPlaceholderName().trim());
		placeholder.setPlaceholderType(placeholder.getPlaceholderType().trim());
		//修改成功
		if(placeholderService.update(placeholder)>0){
			return R.ok();
		}
		//修改失败
		return R.error();
	}

	/**
	 * 根据id删除占位符
	 * @param placeholderId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("template:placeholder:remove")
	public R remove( String placeholderId){
		//删除成功
		if(placeholderService.remove(placeholderId)>0){
		    return R.ok();
		}
		//删除失败
		return R.error();
	}

	/**
	 * 批量删除占位符
	 * @param placeholderIds
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("template:placeholder:batchRemove")
	public R remove(@RequestParam("ids[]") String[] placeholderIds){
		//批量删除成功
		if(placeholderService.batchRemove(placeholderIds)>0){
			return R.ok();
		}
		//批量删除失败
		return R.error();
	}
	
}
