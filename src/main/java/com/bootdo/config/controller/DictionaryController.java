package com.bootdo.config.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
 * 字典管理
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

	/**
	 * 到字典列表页面
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("config:dictionary:dictionary")
	String Dictionary(){
	    return "config/dictionary/dictionary";
	}

	/**
	 * 查询字典列表数据
	 * @param params
	 * @return
	 */
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

	/**
	 * 到字典增加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("config:dictionary:add")
	String add(){
	    return "config/dictionary/add";
	}

	/**
	 * 到字典修改页面
	 * @param dictId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{dictId}")
	@RequiresPermissions("config:dictionary:edit")
	String edit(@PathVariable("dictId") String dictId,Model model){
		DictionaryDO dictionary = dictionaryService.get(dictId);
		model.addAttribute("dictionary", dictionary);
	    return "config/dictionary/edit";
	}

	/**
	 * 保存字典数据
	 * @param dictionary
	 * @return
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
	 * 修改字典数据
	 * @param dictionary
	 * @return
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
	 * 根据id删除
	 * @param dictId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("config:dictionary:remove")
	public R remove( String dictId){
		DictionaryDO dictionary = dictionaryService.get(dictId);
		dictionary.setDelFlag("1");
		if(dictionaryService.update(dictionary)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 批量删除
	 * @param dictIds
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("config:dictionary:batchRemove")
	public R remove(@RequestParam("ids[]") String[] dictIds){
		for (String dictId: dictIds) {
			DictionaryDO dictionary = dictionaryService.get(dictId);
			dictionary.setDelFlag("1");
			dictionaryService.update(dictionary);
		}
		return R.ok();
	}

	/**
	 * 查看字典详情
	 * @param dictId
	 * @param model
	 * @return
	 */
	@GetMapping("/showDetail/{dictId}")
	@RequiresPermissions("config:dictionary:showDetail")
	String showDetail(@PathVariable("dictId")  String dictId,Model model){
		DictionaryDO dictionaryDO = dictionaryService.get(dictId);
		model.addAttribute("dictionary",dictionaryDO);
		return "config/dictionary/showDetail";
	}

	/**
	 * 根据字典类型名称查询字典数据
	 * @param typeName
	 * @return
	 */
	@GetMapping("/getByType/{typeName}")
	@ResponseBody
	@RequiresPermissions("config:dictionary:dictionary")
	public List<DictionaryDO> getByType(@PathVariable("typeName") String typeName) throws UnsupportedEncodingException {
        typeName = URLDecoder.decode(typeName,"UTF-8");
        List<DictionaryDO> dictionaryList = dictionaryService.getByType(typeName);
        return dictionaryList;
    }

	/**
	 * 根据字典数据值查询字典对象
	 * @param dictValue
	 * @return
	 */
	@GetMapping("/getByValue/{dictValue}")
	@ResponseBody
	@RequiresPermissions("config:dictionary:dictionary")
	public DictionaryDO getByValue(@PathVariable("dictValue") String dictValue){
		List<DictionaryDO> dictionaryList = dictionaryService.getByValue(dictValue);
		return dictionaryList.get(0);
	}

}
