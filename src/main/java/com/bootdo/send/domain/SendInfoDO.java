package com.bootdo.send.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 寄送管理
 * 
 * @author zhaolijuan
 * @date 2018-08-09 14:25:26
 */
public class SendInfoDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//寄送id
	private String sendId;
	//保单号
	private String policyNo;
	//寄送单号
	private String sendOrderno;
	//寄送文件类型
	private String fileType;
	//保险公司
	private String insuranceCompany;
	//快递公司
	private String courierCompany;
	//寄送人类型
	private String senderType;
	//寄送人姓名
	private String senderName;
	//寄送人电话
	private String senderMobile;
	//寄送人地址
	private String senderAddress;
	//寄送时间
	private Date sendTime;
	//收件人姓名
	private String recipientName;
	//收件人电话
	private String recipientMobile;
	//收件人地址
	private String recipientAddress;
	//收件时间
	private Date receiptTime;
	//寄送内容
	private String sendContent;
	//寄送描述
	private String sendDesc;
	//寄送附件url
	private String sendAttach;
	//寄送状态
	private String sendState;
	//冷静期起
	private Date calmPeriodStart;
	//冷静期止
	private Date calmPeriodEnd;
	//创建时间
	private Date createTime;
	//创建人id
	private String createById;
	//创建人
	private String createBy;
	//修改时间
	private Date updateTime;
	//修改人id
	private String updateById;
	//修改人
	private String updateBy;

	/**
	 * 格式化寄送时间
	 * @return
	 */
	public String getSendTimeString(){
		if(sendTime!=null){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sendTime);
		}
        return null;
	}

	/**
	 * 格式化收件时间
	 * @return
	 */
	public String getReceiptTimeString(){
		if(receiptTime!=null){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(receiptTime);
		}
        return null;
	}

	/**
	 * 格式化冷静期起
	 * @return
	 */
	public String getCalmPeriodStartString(){
		if(calmPeriodStart!=null){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calmPeriodStart);
		}
		return null;
	}

	/**
	 * 格式化冷静期止
	 * @return
	 */
	public String getCalmPeriodEndString(){
		if(calmPeriodEnd!=null){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calmPeriodEnd);
		}
        return null;
	}

	/**
	 * 格式化创建时间
	 * @return
	 */
	public String getCreateTimeString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
	}

	/**
	 * 格式化修改时间
	 * @return
	 */
	public String getUpdateTimeString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(updateTime);
	}

	/**
	 * 设置：寄送ID
	 */
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	/**
	 * 获取：寄送ID
	 */
	public String getSendId() {
		return sendId;
	}
	/**
	 * 设置：保单号
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 获取：保单号
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 设置：寄送单号
	 */
	public void setSendOrderno(String sendOrderno) {
		this.sendOrderno = sendOrderno;
	}
	/**
	 * 获取：寄送单号
	 */
	public String getSendOrderno() {
		return sendOrderno;
	}
	/**
	 * 设置：寄送文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：寄送文件类型
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 设置：保险公司
	 */
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	/**
	 * 获取：保险公司
	 */
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	/**
	 * 设置：快递公司
	 */
	public void setCourierCompany(String courierCompany) {
		this.courierCompany = courierCompany;
	}
	/**
	 * 获取：快递公司
	 */
	public String getCourierCompany() {
		return courierCompany;
	}
	/**
	 * 设置：寄送人类型
	 */
	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}
	/**
	 * 获取：寄送人类型
	 */
	public String getSenderType() {
		return senderType;
	}
	/**
	 * 设置：寄送人姓名
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * 获取：寄送人姓名
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * 设置：寄送人电话
	 */
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	/**
	 * 获取：寄送人电话
	 */
	public String getSenderMobile() {
		return senderMobile;
	}
	/**
	 * 设置：寄送人地址
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	/**
	 * 获取：寄送人地址
	 */
	public String getSenderAddress() {
		return senderAddress;
	}
	/**
	 * 设置：寄送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：寄送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：收件人姓名
	 */
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	/**
	 * 获取：收件人姓名
	 */
	public String getRecipientName() {
		return recipientName;
	}
	/**
	 * 设置：收件人电话
	 */
	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}
	/**
	 * 获取：收件人电话
	 */
	public String getRecipientMobile() {
		return recipientMobile;
	}
	/**
	 * 设置：收件人地址
	 */
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	/**
	 * 获取：收件人地址
	 */
	public String getRecipientAddress() {
		return recipientAddress;
	}
	/**
	 * 设置：收件时间
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	/**
	 * 获取：收件时间
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}
	/**
	 * 设置：寄送内容
	 */
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	/**
	 * 获取：寄送内容
	 */
	public String getSendContent() {
		return sendContent;
	}
	/**
	 * 设置：寄送描述
	 */
	public void setSendDesc(String sendDesc) {
		this.sendDesc = sendDesc;
	}
	/**
	 * 获取：寄送描述
	 */
	public String getSendDesc() {
		return sendDesc;
	}
	/**
	 * 设置：寄送附件url
	 */
	public void setSendAttach(String sendAttach) {
		this.sendAttach = sendAttach;
	}
	/**
	 * 获取：寄送附件url
	 */
	public String getSendAttach() {
		return sendAttach;
	}
	/**
	 * 设置：寄送状态
	 */
	public void setSendState(String sendState) {
		this.sendState = sendState;
	}
	/**
	 * 获取：寄送状态
	 */
	public String getSendState() {
		return sendState;
	}
	/**
	 * 设置：冷静期起
	 */
	public void setCalmPeriodStart(Date calmPeriodStart) {
		this.calmPeriodStart = calmPeriodStart;
	}
	/**
	 * 获取：冷静期起
	 */
	public Date getCalmPeriodStart() {
		return calmPeriodStart;
	}
	/**
	 * 设置：冷静期止
	 */
	public void setCalmPeriodEnd(Date calmPeriodEnd) {
		this.calmPeriodEnd = calmPeriodEnd;
	}
	/**
	 * 获取：冷静期止
	 */
	public Date getCalmPeriodEnd() {
		return calmPeriodEnd;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateById(String createById) {
		this.createById = createById;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreateById() {
		return createById;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人id
	 */
	public void setUpdateById(String updateById) {
		this.updateById = updateById;
	}
	/**
	 * 获取：修改人id
	 */
	public String getUpdateById() {
		return updateById;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateBy() {
		return updateBy;
	}
}
