package com.bootdo.config.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 字典类型表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
public class DictionaryTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典类型编码
	private String typeId;
	//字典类型编码
	private String typeValue;
	//字典类型名称
	private String typeName;
	//字典类型描述
	private String typeDesc;
	//是否可修改
	private String canEdit;
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
	 * 设置：字典类型编码
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：字典类型编码
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * 设置：字典类型编码
	 */
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	/**
	 * 获取：字典类型编码
	 */
	public String getTypeValue() {
		return typeValue;
	}
	/**
	 * 设置：字典类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：字典类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：字典类型描述
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	/**
	 * 获取：字典类型描述
	 */
	public String getTypeDesc() {
		return typeDesc;
	}
	/**
	 * 设置：是否可修改
	 */
	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}
	/**
	 * 获取：是否可修改
	 */
	public String getCanEdit() {
		return canEdit;
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
