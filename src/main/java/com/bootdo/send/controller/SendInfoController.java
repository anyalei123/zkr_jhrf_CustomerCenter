package com.bootdo.send.controller;

import java.io.*;
import java.util.*;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.send.domain.SendInfoDO;
import com.bootdo.send.service.SendInfoService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * 到寄送信息列表页面
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("send:sendInfo:sendInfo")
	String SendInfo(){
	    return "send/sendInfo/sendInfo";
	}

	/**
	 * 到寄送信息导入页面
	 * @return
	 */
	@GetMapping("/import")
	@RequiresPermissions("send:sendInfo:import")
	String sendImport(){
		return "send/sendInfo/import";
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
	 * 寄送附件上传
	 * @param sendInfo
	 * @param request
	 * @throws Exception
	 */
	public void uploadAttach(SendInfoDO sendInfo,HttpServletRequest request)throws Exception{
		if (request != null && request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			// 获取上传的文件
			Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
			for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
				// 对文件进行处理
				String fileName = entry.getValue().getOriginalFilename();
				if(fileName != null && !"".equals(fileName)){
					String extName = fileName.substring(fileName.lastIndexOf("."));
					String newFileName = GenerateSequenceUtil.generateSequenceNo();
					//上传路径
					File path = new File(ResourceUtils.getURL("classpath:").getPath());
					String filePath = path +"/files/" ;
					FileUtil.uploadFile(entry.getValue().getBytes(),filePath,newFileName+extName);
					sendInfo.setSendAttach(filePath+newFileName+extName);
				}
			}
		}
	}

	/**
	 * 保存寄送信息
	 * @param sendInfo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("send:sendInfo:add")
	public R save( SendInfoDO sendInfo,HttpServletRequest request)throws Exception{
		//寄送附件上传
		uploadAttach(sendInfo,request);
		//设置创建人和修改人
		sendInfo.setCreateById(String.valueOf(this.getUserId()));
		sendInfo.setUpdateById(String.valueOf(this.getUserId()));
		sendInfo.setCreateBy(this.getUsername());
		sendInfo.setUpdateBy(this.getUsername());
        //去除空格
		sendInfo.setPolicyNo(sendInfo.getPolicyNo().trim());
		sendInfo.setSendOrderno(sendInfo.getSendOrderno().trim());
		sendInfo.setFileType(sendInfo.getFileType().trim());
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
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("send:sendInfo:edit")
	public R update(SendInfoDO sendInfo,HttpServletRequest request)throws Exception{
		//寄送附件上传
		uploadAttach(sendInfo,request);
		//设置修改人
		sendInfo.setUpdateById(String.valueOf(this.getUserId()));
		sendInfo.setUpdateBy(this.getUsername());
		//去除空格
		sendInfo.setPolicyNo(sendInfo.getPolicyNo().trim());
		sendInfo.setSendOrderno(sendInfo.getSendOrderno().trim());
		sendInfo.setFileType(sendInfo.getFileType().trim());
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

	/**
	 * 寄送信息导入
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/importXlsx")
	@ResponseBody
	@RequiresPermissions("send:sendInfo:import")
	public ImportResult upLoadXlsx(@RequestParam("file") MultipartFile file) throws IOException {
		//导入成功的数据数量
		int importSuccess = 0;
		//导入失败的数据数量
		int importFail = 0;
		//导入失败的寄送单号(key)，原因(value)
		Map<String,String> failMap = new LinkedHashMap<String,String>();
		//文件名
		String filename=file.getOriginalFilename();
		//创建一个文档对象
		Workbook workbook=null;
		if(filename.endsWith("xlsx")){//Office 2007版本后excel.xls文件
			workbook=new XSSFWorkbook(file.getInputStream());
		}else if(filename.endsWith("xls")){//Office 2007版本前excel.xls文件
			workbook=new HSSFWorkbook(file.getInputStream());
		}
		//获取sheet的数目
		int sheetNum = workbook.getNumberOfSheets();
		//遍历所有的sheet
		for (int i=0;i<sheetNum;i++){
			//获取Sheet(表格页眉)
			Sheet sheet=workbook.getSheetAt(i);
			//遍历所有的Row
			for (Row row : sheet){
				if(row != null){
					int num = row.getRowNum();
					//跳过第一行标题行
					if(num == 0){
						continue;
					}
					SendInfoDO sendInfo = new SendInfoDO();
                    try {
						//读取cell的值并封装到SendInfoDO对象中
					    row.getCell(0).setCellType(CellType.STRING);
                        sendInfo.setPolicyNo(row.getCell(0).getStringCellValue());
					    row.getCell(1).setCellType(CellType.STRING);
                        sendInfo.setSendOrderno(row.getCell(1).getStringCellValue());
                        row.getCell(2).setCellType(CellType.STRING);
                        sendInfo.setFileType(row.getCell(2).getStringCellValue());
					    row.getCell(3).setCellType(CellType.STRING);
                        sendInfo.setInsuranceCompany(row.getCell(3).getStringCellValue());
					    row.getCell(4).setCellType(CellType.STRING);
                        sendInfo.setCourierCompany(row.getCell(4).getStringCellValue());
                        row.getCell(5).setCellType(CellType.STRING);
                        sendInfo.setSenderType(row.getCell(5).getStringCellValue());
					    row.getCell(6).setCellType(CellType.STRING);
                        sendInfo.setSenderName(row.getCell(6).getStringCellValue());
					    row.getCell(7).setCellType(CellType.STRING);
                        sendInfo.setSenderMobile(row.getCell(7).getStringCellValue());
					    row.getCell(8).setCellType(CellType.STRING);
                        sendInfo.setSenderAddress(row.getCell(8).getStringCellValue());
                        sendInfo.setSendTime(row.getCell(9).getDateCellValue());
					    row.getCell(10).setCellType(CellType.STRING);
                        sendInfo.setRecipientName(row.getCell(10).getStringCellValue());
					    row.getCell(11).setCellType(CellType.STRING);
                        sendInfo.setRecipientMobile(row.getCell(11).getStringCellValue());
					    row.getCell(12).setCellType(CellType.STRING);
                        sendInfo.setRecipientAddress(row.getCell(12).getStringCellValue());
                        sendInfo.setReceiptTime(row.getCell(13).getDateCellValue());
					    row.getCell(14).setCellType(CellType.STRING);
                        sendInfo.setSendContent(row.getCell(14).getStringCellValue());
					    row.getCell(15).setCellType(CellType.STRING);
                        sendInfo.setSendDesc(row.getCell(15).getStringCellValue());
					    row.getCell(16).setCellType(CellType.STRING);
                        sendInfo.setSendAttach(row.getCell(16).getStringCellValue());
                        row.getCell(17).setCellType(CellType.STRING);
                        sendInfo.setSendState(row.getCell(17).getStringCellValue());
                        sendInfo.setCalmPeriodStart(row.getCell(18).getDateCellValue());
                        sendInfo.setCalmPeriodEnd(row.getCell(19).getDateCellValue());
                        //根据寄送单号查询寄送信息
                        SendInfoDO byOrderno = sendInfoService.getByOrderno(sendInfo.getSendOrderno());
                        if(byOrderno==null){
                            //如果数据库中不存在该条数据，将该条数据导入
                            R r = save(sendInfo,null);
                            if(r.get("msg") == "操作成功"){
                                //导入成功
                                importSuccess++;
                            }else{
                                //导入失败
                                importFail++;
								failMap.put(sendInfo.getSendOrderno(),"导入的数据不合法");
                            }
                        }else{
                            //如果数据库中已经存在该条数据，则不导入
                            importFail++;
                            failMap.put(sendInfo.getSendOrderno(),"导入的数据已经存在");
                        }
                    }
                    catch (Exception e) {
                        //异常，导入失败
                        importFail++;
                        failMap.put(sendInfo.getSendOrderno(),"导入的数据不合法");
                    }
                }
			}
		}
		//创建封装返回结果的对象
		ImportResult result = new ImportResult();
		result.setImportSuccess(importSuccess);
		result.setImportFail(importFail);
		result.setFailMap(failMap);
		return result;
	}

	/**
	 * 寄送导入模板下载
	 * @param request
	 * @param fileName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downloadXlsx")
	@RequiresPermissions("send:sendInfo:import")
	public ResponseEntity<byte[]> downloadXlsx(HttpServletRequest request,
										   @RequestParam("fileName") String fileName,
										   Model model)throws Exception {
		//下载文件路径
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		File file = new File(path +"/files/"+ File.separator + fileName);
		HttpHeaders headers = new HttpHeaders();
		//下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		//通知浏览器以attachment（下载方式）打开文件
		headers.setContentDispositionFormData("attachment", downloadFielName);
		//application/octet-stream ： 二进制流数据（最常见的文件下载）
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

}
