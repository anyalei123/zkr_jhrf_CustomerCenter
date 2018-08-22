package com.bootdo.msgpush.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 消息推送类型表
 * 
 * @author anyalei
 * @email anyalei@sinosoft.com.cn
 * @date 2018-08-14 15:53:21
 */
public class MessagepushTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//消息推送类型编号
	private String msgTypeId;
	//消息推送类型名称
	private String typeName;
	//消息推送类型描述
	private String typeDesc;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//创建人ID
	private String createById;
	//修改人ID
	private String updateById;
	//创建人
	private String createBy;
	//修改人
	private String updateBy;

	
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
	 * 设置：消息推送类型编号
	 */
	public void setMsgTypeId(String msgTypeId) {
		this.msgTypeId = msgTypeId;
	}
	/**
	 * 获取：消息推送类型编号
	 */
	public String getMsgTypeId() {
		return msgTypeId;
	}
	/**
	 * 设置：消息推送类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：消息推送类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：消息推送类型描述
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	/**
	 * 获取：消息推送类型描述
	 */
	public String getTypeDesc() {
		return typeDesc;
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
