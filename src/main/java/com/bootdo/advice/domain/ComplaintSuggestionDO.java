package com.bootdo.advice.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chl
 * @email 1992lcg@163.com
 * @date 2018-08-02 23:15:55
 */
public class ComplaintSuggestionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String messageNumber;
	//
	private String messageType;
	//
	private String messageContent;
	//
	private String contentClassify;
	//
	private String senderType;
	//
	private String senderName;
	//
	private String senderMobile;
	//
	private String senderEmail;
	//
	private String senderAddress;
	//
	private Date sendTime;
	//
	private String messageSource;
	//
	private String channel;
	//
	private String messageResult;
	//
	private String messageDesc;
	//
	private String remarks;

	/**
	 * 设置：
	 */
	public void setMessageNumber(String messageNumber) {
	
		this.messageNumber = messageNumber;

	}
	/**
	 * 获取：
	 */
	public String getMessageNumber() {
		
		return messageNumber;
	}
	/**
	 * 设置：
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	/**
	 * 获取：
	 */
	public String getMessageType() {
		return messageType;
	}
	/**
	 * 设置：
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * 获取：
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 设置：
	 */
	public void setContentClassify(String contentClassify) {
		this.contentClassify = contentClassify;
	}
	/**
	 * 获取：
	 */
	public String getContentClassify() {
		return contentClassify;
	}
	/**
	 * 设置：
	 */
	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}
	/**
	 * 获取：
	 */
	public String getSenderType() {
		return senderType;
	}
	/**
	 * 设置：
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * 获取：
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * 设置：
	 */
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	/**
	 * 获取：
	 */
	public String getSenderMobile() {
		return senderMobile;
	}
	/**
	 * 设置：
	 */
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	/**
	 * 获取：
	 */
	public String getSenderEmail() {
		return senderEmail;
	}
	/**
	 * 设置：
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	/**
	 * 获取：
	 */
	public String getSenderAddress() {
		return senderAddress;
	}
	/**
	 * 设置：
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：
	 */
	public void setMessageSource(String messageSource) {
		this.messageSource = messageSource;
	}
	/**
	 * 获取：
	 */
	public String getMessageSource() {
		return messageSource;
	}
	/**
	 * 设置：
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：
	 */
	public void setMessageResult(String messageResult) {
		this.messageResult = messageResult;
	}
	/**
	 * 获取：
	 */
	public String getMessageResult() {
		return messageResult;
	}
	/**
	 * 设置：
	 */
	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
	/**
	 * 获取：
	 */
	public String getMessageDesc() {
		return messageDesc;
	}
	/**
	 * 设置：
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：
	 */
	public String getRemarks() {
		return remarks;
	}
}
