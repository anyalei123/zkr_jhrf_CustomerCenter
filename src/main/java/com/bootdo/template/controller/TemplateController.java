package com.bootdo.template.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
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

import com.bootdo.template.domain.TemplateDO;
import com.bootdo.template.service.TemplateService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 模板管理
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Controller
@RequestMapping("/template/template")
public class TemplateController extends BaseController {

	@Autowired
	private TemplateService templateService;
	
	@GetMapping()
	@RequiresPermissions("template:template:template")
	String Template(){
	    return "template/template/template";
	}

	/**
	 * 查询模板列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("template:template:template")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//封装前台传递的参数
        Query query = new Query(params);
		//查询模板列表数据
		List<TemplateDO> templateList = templateService.list(query);
		//查询模板列表数据总条数
		int total = templateService.count(query);
		//封装列表数据和总条数
		PageUtils pageUtils = new PageUtils(templateList, total);
		return pageUtils;
	}

	/**
	 * 到模板添加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("template:template:add")
	String add(){
	    return "template/template/add";
	}

	/**
	 * 到模板修改页面
	 * @param templateId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{templateId}")
	@RequiresPermissions("template:template:edit")
	String edit(@PathVariable("templateId") String templateId,Model model){
		//根据模板id查询模板
		TemplateDO template = templateService.get(templateId);
		//将查询到的模板对象封装到model中用于在页面回显信息
		model.addAttribute("template", template);
	    return "template/template/edit";
	}

	/**
	 * 保存模板信息
	 * @param template
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("template:template:add")
	public R save( TemplateDO template){
		//获取当前登录的用户名
		String username = this.getUsername();
		//设置创建人为当前登录用户
		template.setCreateBy(username);
		//设置修改人为当前登录用户
		template.setUpdateBy(username);
		//保存成功
		if(templateService.save(template)>0){
			return R.ok();
		}
		//保存失败
		return R.error();
	}

	/**
	 * 修改模板信息
	 * @param template
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("template:template:edit")
	public R update( TemplateDO template){
		//获取当前登录的用户名
		String username = this.getUsername();
		//设置修改人为当前登录用户
		template.setUpdateBy(username);
		//修改成功
		if(templateService.update(template)>0){
			return R.ok();
		}
		//修改失败
        return R.error();
	}

	/**
	 * 根据id删除模板
	 * @param templateId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("template:template:remove")
	public R remove( String templateId){
		//删除成功
		if(templateService.remove(templateId)>0){
			return R.ok();
		}
		//删除失败
		return R.error();
	}

	/**
	 * 批量删除模板
	 * @param templateIds
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("template:template:batchRemove")
	public R remove(@RequestParam("ids[]") String[] templateIds){
		//批量删除成功
		if(templateService.batchRemove(templateIds)>0){
			return R.ok();
		}
		//批量删除失败
		return R.error();
	}
	
}
