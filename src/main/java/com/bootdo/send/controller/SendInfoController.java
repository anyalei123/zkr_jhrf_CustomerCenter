package com.bootdo.send.controller;

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

import com.bootdo.send.domain.SendInfoDO;
import com.bootdo.send.service.SendInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 寄送管理
 * 
 * @author zhaolijuan
 * @date 2018-08-09 14:25:26
 */
@Controller
@RequestMapping("/send/sendInfo")
public class SendInfoController extends BaseController {

	@Autowired
	private SendInfoService sendInfoService;
	
	@GetMapping()
	@RequiresPermissions("send:sendInfo:sendInfo")
	String SendInfo(){
	    return "send/sendInfo/sendInfo";
	}

	/**
	 * 查询寄送信息列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("send:sendInfo:sendInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//封装前台传递的参数
        Query query = new Query(params);
        //查询寄送信息列表
		List<SendInfoDO> sendInfoList = sendInfoService.list(query);
		//查询寄送信息列表数据总条数
		int total = sendInfoService.count(query);
		//封装寄送信息列表数据和总条数
		PageUtils pageUtils = new PageUtils(sendInfoList, total);
		return pageUtils;
	}

	/**
	 * 到寄送信息添加页面
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("send:sendInfo:add")
	String add(){
	    return "send/sendInfo/add";
	}

	/**
	 * 到寄送信息修改页面
	 * @param sendId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{sendId}")
	@RequiresPermissions("send:sendInfo:edit")
	String edit(@PathVariable("sendId") String sendId,Model model){
		//根据id查询寄送信息
		SendInfoDO sendInfo = sendInfoService.get(sendId);
		//将查询到的寄送信息封装到model中用于前台页面显示
		model.addAttribute("sendInfo", sendInfo);
	    return "send/sendInfo/edit";
	}

	/**
	 * 保存寄送信息
	 * @param sendInfo
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("send:sendInfo:add")
	public R save( SendInfoDO sendInfo){
		//设置创建人id为当前登录的用户id
		sendInfo.setCreateById(String.valueOf(this.getUserId()));
		//设置修改人id为当前登录的用户id
		sendInfo.setUpdateById(String.valueOf(this.getUserId()));
		//设置创建人为当前登录的用户名
		sendInfo.setCreateBy(this.getUsername());
		//设置修改人为当前登录的用户名
		sendInfo.setUpdateBy(this.getUsername());
		//保存成功
		if(sendInfoService.save(sendInfo)>0){
			return R.ok();
		}
		//保存失败
		return R.error();
	}

	/**
	 * 修改寄送信息
	 * @param sendInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("send:sendInfo:edit")
	public R update(SendInfoDO sendInfo){
		//设置修改人id为当前登录的用户id
		sendInfo.setUpdateById(String.valueOf(this.getUserId()));
		//设置修改人为当前登录的用户名
		sendInfo.setUpdateBy(this.getUsername());
		//修改成功
		if(sendInfoService.update(sendInfo)>0){
			return R.ok();
		}
		//修改失败
		return R.error();
	}

	/**
	 * 根据id删除寄送信息
	 * @param sendId
	 * @return
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("send:sendInfo:remove")
	public R remove( String sendId){
		//删除成功
		if(sendInfoService.remove(sendId)>0){
			return R.ok();
		}
		//删除失败
		return R.error();
	}

	/**
	 * 批量删除寄送信息
	 * @param sendIds
	 * @return
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("send:sendInfo:batchRemove")
	public R remove(@RequestParam("ids[]") String[] sendIds){
		//批量删除成功
		if(sendInfoService.batchRemove(sendIds)>0){
			return R.ok();
		}
		//批量删除失败
		return R.error();
	}

}
