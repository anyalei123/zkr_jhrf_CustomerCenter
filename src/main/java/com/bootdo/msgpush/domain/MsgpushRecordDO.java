package com.bootdo.msgpush.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 消息推送记录表
 * 
 * @author anyalei
 * @email anyalei163i@163.com.cn
 * @date 2018-08-17 15:52:27
 */
public class MsgpushRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//消息编号
	private String messageId;
	//消息类型
	private String messageType;
	//消息推送内容
	private String messageContent;
	//消息推送联系方式
	private String messagePhone;
	//消息结果
	private String messageResult;
	//消息状态
	private String messageStatus;
	//消息推送模板编号
	private String templateId;
	//消息发送方
	private String senderName;
	//消息发送时间
	private Date sendTime;
	//消息接收人类型
	private String recipientType;
	//接收人姓名
	private String recipientName;
	//接收人电话
	private String recipientMobile;
	//接收人邮箱
	private String recipientEmail;
	//机构名称
	private String institutionName;
	//渠道名称
	private String channelName;
	//消息修改人
	private String msgUpdateBy;
	//消息修改时间
	private Date msgUpdateTime;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//消息推送类型编号,外键，关联消息推送类型表(xx_messagepush_type)主键id
	private String msgTypeId;
	//创建人ID
	private String createById;
	//修改人ID
	private String updateById;
	//创建人
	private String createBy;
	//修改人
	private String updateBy;

	/**
	 * 设置：消息编号
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	/**
	 * 获取：消息编号
	 */
	public String getMessageId() {
		return messageId;
	}
	/**
	 * 设置：消息类型
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	/**
	 * 获取：消息类型
	 */
	public String getMessageType() {
		return messageType;
	}
	/**
	 * 设置：消息推送内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * 获取：消息推送内容
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 设置：消息推送联系方式
	 */
	public void setMessagePhone(String messagePhone) {
		this.messagePhone = messagePhone;
	}
	/**
	 * 获取：消息推送联系方式
	 */
	public String getMessagePhone() {
		return messagePhone;
	}
	/**
	 * 设置：消息结果
	 */
	public void setMessageResult(String messageResult) {
		this.messageResult = messageResult;
	}
	/**
	 * 获取：消息结果
	 */
	public String getMessageResult() {
		return messageResult;
	}
	/**
	 * 设置：消息状态
	 */
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	/**
	 * 获取：消息状态
	 */
	public String getMessageStatus() {
		return messageStatus;
	}
	/**
	 * 设置：消息推送模板编号
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：消息推送模板编号
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：消息发送方
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * 获取：消息发送方
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * 设置：消息发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：消息发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：消息接收人类型
	 */
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	/**
	 * 获取：消息接收人类型
	 */
	public String getRecipientType() {
		return recipientType;
	}
	/**
	 * 设置：接收人姓名
	 */
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	/**
	 * 获取：接收人姓名
	 */
	public String getRecipientName() {
		return recipientName;
	}
	/**
	 * 设置：接收人电话
	 */
	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}
	/**
	 * 获取：接收人电话
	 */
	public String getRecipientMobile() {
		return recipientMobile;
	}
	/**
	 * 设置：接收人邮箱
	 */
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	/**
	 * 获取：接收人邮箱
	 */
	public String getRecipientEmail() {
		return recipientEmail;
	}
	/**
	 * 设置：机构名称
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	/**
	 * 获取：机构名称
	 */
	public String getInstitutionName() {
		return institutionName;
	}
	/**
	 * 设置：渠道名称
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * 获取：渠道名称
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * 设置：消息修改人
	 */
	public void setMsgUpdateBy(String msgUpdateBy) {
		this.msgUpdateBy = msgUpdateBy;
	}
	/**
	 * 获取：消息修改人
	 */
	public String getMsgUpdateBy() {
		return msgUpdateBy;
	}
	/**
	 * 设置：消息修改时间
	 */
	public void setMsgUpdateTime(Date msgUpdateTime) {
		this.msgUpdateTime = msgUpdateTime;
	}
	/**
	 * 获取：消息修改时间
	 */
	public Date getMsgUpdateTime() {
		return msgUpdateTime;
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
	 * 设置：消息推送类型编号,外键，关联消息推送类型表(xx_messagepush_type)主键id
	 */
	public void setMsgTypeId(String msgTypeId) {
		this.msgTypeId = msgTypeId;
	}
	/**
	 * 获取：消息推送类型编号,外键，关联消息推送类型表(xx_messagepush_type)主键id
	 */
	public String getMsgTypeId() {
		return msgTypeId;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateById(String createById) {
		this.createById = createById;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreateById() {
		return createById;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setUpdateById(String updateById) {
		this.updateById = updateById;
	}
	/**
	 * 获取：修改人ID
	 */
	public String getUpdateById() {
		return updateById;
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
