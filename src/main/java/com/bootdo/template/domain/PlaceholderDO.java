package com.bootdo.template.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 占位符
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
public class PlaceholderDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//占位符编号
	private String placeholderId;
	//占位符代码
	private String placeholderCode;
	//占位符名称
	private String placeholderName;
	//占位符类型
	private String placeholderType;
	//占位符描述
	private String placeholderDesc;
	//创建时间
	private Date createTime;
	//创建人
	private String createBy;
	//修改时间
	private Date updateTime;
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
	 * 设置：占位符编号
	 */
	public void setPlaceholderId(String placeholderId) {
		this.placeholderId = placeholderId;
	}
	/**
	 * 获取：占位符编号
	 */
	public String getPlaceholderId() {
		return placeholderId;
	}
	/**
	 * 设置：占位符代码
	 */
	public void setPlaceholderCode(String placeholderCode) {
		this.placeholderCode = placeholderCode;
	}
	/**
	 * 获取：占位符代码
	 */
	public String getPlaceholderCode() {
		return placeholderCode;
	}
	/**
	 * 设置：占位符名称
	 */
	public void setPlaceholderName(String placeholderName) {
		this.placeholderName = placeholderName;
	}
	/**
	 * 获取：占位符名称
	 */
	public String getPlaceholderName() {
		return placeholderName;
	}
	/**
	 * 设置：占位符类型
	 */
	public void setPlaceholderType(String placeholderType) {
		this.placeholderType = placeholderType;
	}
	/**
	 * 获取：占位符类型
	 */
	public String getPlaceholderType() {
		return placeholderType;
	}
	/**
	 * 设置：占位符描述
	 */
	public void setPlaceholderDesc(String placeholderDesc) {
		this.placeholderDesc = placeholderDesc;
	}
	/**
	 * 获取：占位符描述
	 */
	public String getPlaceholderDesc() {
		return placeholderDesc;
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
