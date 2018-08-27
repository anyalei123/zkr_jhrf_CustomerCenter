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

import com.bootdo.template.domain.TemplateTypeDO;
import com.bootdo.template.service.TemplateTypeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 模板类型管理
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
@Controller
@RequestMapping("/template/templateType")
public class TemplateTypeController extends BaseController {

	@Autowired
	private TemplateTypeService templateTypeService;

	/**
	 * 到模板类型列表页面
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("template:templateType:templateType")
	String TemplateType(){
	    return "template/templateType/templateType";
	}

	/**
	 * 查询模板类型列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("template:templateType:templateType")
	public PageUtils list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        //查询模板类型列表数据
		List<TemplateTypeDO> templateTypeList = templateTypeService.list(query);
		int total = templateTypeService.count(query);
		PageUtils pageUtils = new PageUtils(templateTypeList, total);
		return pageUtils;
	}

	/**
	 * 到模板类型添加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("template:templateType:add")
	String add(){
	    return "template/templateType/add";
	}

	/**
	 * 到模板类型修改页面
	 * @param typeId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{typeId}")
	@RequiresPermissions("template:templateType:edit")
	String edit(@PathVariable("typeId") String typeId,Model model){
		//根据id查询模板类型
		TemplateTypeDO templateType = templateTypeService.get(typeId);
		model.addAttribute("templateType", templateType);
	    return "template/templateType/edit";
	}

	/**
	 * 保存模板类型
	 * @param templateType
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("template:templateType:add")
	public R save( TemplateTypeDO templateType){
		//判断模板类型名称是否存在
		TemplateTypeDO templateType1 = templateTypeService.getByTypeName(templateType);
		if(templateType1 != null){
			return R.error("模板类型名称  '"+templateType1.getTypeName()+"' 已经存在,请勿重复创建!");
		}
		//设置主键
		templateType.setTypeId(GenerateSequenceUtil.generateSequenceNo());
		//设置创建时间和修改时间为当前时间
		templateType.setCreateTime(new Date());
		templateType.setUpdateTime(new Date());
		//设置创建人和修改人
		templateType.setCreateById(String.valueOf(this.getUserId()));
		templateType.setUpdateById(String.valueOf(this.getUserId()));
		templateType.setCreateBy(this.getUsername());
		templateType.setUpdateBy(this.getUsername());
		//去除空格
		templateType.setTypeName(templateType.getTypeName().trim());
		//保存成功
		if(templateTypeService.save(templateType)>0){
			return R.ok();
		}
		//保存失败
		return R.error();
	}

	/**
	 * 修改模板类型
	 * @param templateType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("template:templateType:edit")
	public R update( TemplateTypeDO templateType){
		//判断模板类型名称是否存在
		TemplateTypeDO templateType1 = templateTypeService.getByTypeName(templateType);
		if(templateType1 != null && !templateType1.getTypeId().equals(templateType.getTypeId())){
			return R.error("模板类型名称  '"+templateType1.getTypeName()+"' 已经存在,请勿重复创建!");
		}
		//设置修改时间为当前时间
		templateType.setUpdateTime(new Date());
		//设置修改人
		templateType.setUpdateById(String.valueOf(this.getUserId()));
		templateType.setUpdateBy(this.getUsername());
		//去除空格
		templateType.setTypeName(templateType.getTypeName().trim());
		//修改成功
		if(templateTypeService.update(templateType)>0){
			return R.ok();
		}
		//修改失败
        return R.error();
	}

	/**
	 * 根据id删除模板类型
	 * @param typeId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("template:templateType:remove")
	public R remove(String typeId){
		//删除成功
		if(templateTypeService.remove(typeId)>0){
			return R.ok();
		}
		//删除失败
		return R.error("该类型下有模板，不能删除！");
	}

	/**
	 * 批量删除模板类型
	 * @param typeIds
	 * @param selectRows
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("template:templateType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] typeIds,Integer selectRows){
		//如果删除成功的条数等于选中的条数，说明全部删除成功
		int removeRows = templateTypeService.batchRemove(typeIds);
		if(removeRows == selectRows){
			return R.ok();
		}
        //删除失败的条数
		int errorRows = selectRows - removeRows;
		return R.error(errorRows+"条数据删除失败，失败原因：类型下有模板，类型不能删除！");
	}

	/**
	 * 查询模板类型列表数据
	 * 将模板类型名称展示到模板添加页面的模板类型下拉选项中
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listType")
	@RequiresPermissions("template:templateType:templateType")
	public List<TemplateTypeDO> listType(){
		List<TemplateTypeDO> templateTypeList = templateTypeService.listType();
		return templateTypeList;
	}

	/**
	 * 根据id查询模板类型
	 * 用于模板列表中模板类型的格式化
	 * @param typeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get/{typeId}")
	@RequiresPermissions("template:templateType:templateType")
	public TemplateTypeDO get(@PathVariable String typeId){
		TemplateTypeDO templateType = templateTypeService.get(typeId);
		return templateType;
	}

	/**
	 * 查看详情页面
	 * @param typeId
	 * @param model
	 * @return
	 */
	@GetMapping("/showDetail/{typeId}")
	@RequiresPermissions("template:templateType:templateType")
	String showDetail(@PathVariable("typeId") String typeId,Model model){
		//根据id查询模板类型
		TemplateTypeDO templateType = templateTypeService.get(typeId);
		model.addAttribute("templateType", templateType);
		return "template/templateType/showDetail";
	}
	
}
