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
 * 字典类型管理
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

	/**
	 * 到字典类型列表页面
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("config:dictionaryType:dictionaryType")
	String DictionaryType(){
	    return "config/dictionaryType/dictionaryType";
	}

	/**
	 * 查询字典类型列表数据
	 * @param params
	 * @return
	 */
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

	/**
	 * 到字典类型增加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("config:dictionaryType:add")
	String add(){
	    return "config/dictionaryType/add";
	}

	/**
	 * 到字典类型修改页面
	 * @param typeId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{typeId}")
	@RequiresPermissions("config:dictionaryType:edit")
	String edit(@PathVariable("typeId") String typeId,Model model){
		DictionaryTypeDO dictionaryType = dictionaryTypeService.get(typeId);
		model.addAttribute("dictionaryType", dictionaryType);
	    return "config/dictionaryType/edit";
	}

	/**
	 * 保存字典类型
	 * @param dictionaryType
	 * @return
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
		//去除空格
		dictionaryType.setTypeValue(dictionaryType.getTypeValue().trim());
		dictionaryType.setTypeName(dictionaryType.getTypeName().trim());
		if(dictionaryTypeService.save(dictionaryType)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改字典类型
	 * @param dictionaryType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("config:dictionaryType:edit")
	public R update( DictionaryTypeDO dictionaryType){
		//判断类型名称是否存在
		DictionaryTypeDO dictionaryType1 = dictionaryTypeService.getByTypeName(dictionaryType);
		if(dictionaryType1 != null && !dictionaryType1.getTypeId().equals(dictionaryType.getTypeId())){
			return R.error("字典类型名称  '"+dictionaryType1.getTypeName()+"' 已经存在,请勿重复创建!");
		}
		//设置修改信息
		dictionaryType.setUpdateBy(this.getUsername());
		dictionaryType.setUpdateById(String.valueOf(this.getUserId()));
		//设置时间
		dictionaryType.setUpdateTime(new Date());
		//去除空格
		dictionaryType.setTypeValue(dictionaryType.getTypeValue().trim());
		dictionaryType.setTypeName(dictionaryType.getTypeName().trim());
		
		dictionaryTypeService.update(dictionaryType);
		return R.ok();
	}

	/**
	 * 根据id删除
	 * @param typeId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("config:dictionaryType:remove")
	public R remove( String typeId){
		if(dictionaryTypeService.removeById(typeId)>0){
			return R.ok();
		}
		return R.error("该字典类型下有数据，不能删除！");
	}

	/**
	 * 批量删除
	 * @param typeIds
	 * @param selectRows
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("config:dictionaryType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] typeIds,Integer selectRows){
		//如果删除成功的条数等于选中的条数，说明全部删除成功
		int removeRows = dictionaryTypeService.batchRemove1(typeIds);
		if(removeRows == selectRows){
			return R.ok();
		}
		//删除失败的条数
		int errorRows = selectRows - removeRows;
		return R.error(errorRows+"条数据删除失败，失败原因：类型下有数据，类型不能删除");
	}

	/**
	 * 查看详情信息
	 * @param typeId
	 * @param model
	 * @return
	 */
	@GetMapping("/showDetail/{typeId}")
	@RequiresPermissions("config:dictionaryType:showDetail")
	String showDetail(@PathVariable("typeId") String typeId,Model model){
		//根据id查询并显示到明细页面
		DictionaryTypeDO dictionaryType = dictionaryTypeService.get(typeId);
		model.addAttribute("dictionaryType", dictionaryType);
	    return "config/dictionaryType/showDetail";
	}

	/**
	 * 查询字典类型下拉选项
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listType")
	@RequiresPermissions("config:dictionaryType:dictionaryType")
	public List<DictionaryTypeDO> listType(){
		return dictionaryTypeService.listType();
	}

	/**
	 * 根据id查询字典类型对象
	 * @param typeId
	 * @return
	 */
	@ResponseBody
	@GetMapping("/get/{typeId}")
	@RequiresPermissions("config:dictionaryType:dictionaryType")
	public DictionaryTypeDO get(@PathVariable("typeId") String typeId){
		DictionaryTypeDO dictionaryType = dictionaryTypeService.get(typeId);
        return dictionaryType;
	}
}
