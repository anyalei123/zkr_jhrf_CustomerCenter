package com.bootdo.config.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 字典表
 * 
 * @author anyalei
 * @email anyalei163@163.com
 * @date 2018-08-21 16:11:18
 */
public class DictionaryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典编号
	private String dictId;
	//字典名称
	private String dictName;
	//数据值
	private String dictValue;
	//字典描述
	private String dictDesc;
	//排序（升序）
	private String dictSort;
	//删除标记
	private String delFlag;
	//备注信息
	private String remarks;
	//父级编号
	private String parentId;
	//字典类型编号,外键，关联字典类型表(pz_dictionary_type)主键id
	private String typeId;
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
	 * 设置：字典编号
	 */
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：字典编号
	 */
	public String getDictId() {
		return dictId;
	}
	/**
	 * 设置：字典名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：字典名称
	 */
	public String getDictName() {
		return dictName;
	}
	/**
	 * 设置：数据值
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	/**
	 * 获取：数据值
	 */
	public String getDictValue() {
		return dictValue;
	}
	/**
	 * 设置：字典描述
	 */
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	/**
	 * 获取：字典描述
	 */
	public String getDictDesc() {
		return dictDesc;
	}
	/**
	 * 设置：排序（升序）
	 */
	public void setDictSort(String dictSort) {
		this.dictSort = dictSort;
	}
	/**
	 * 获取：排序（升序）
	 */
	public String getDictSort() {
		return dictSort;
	}
	/**
	 * 设置：删除标记
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标记
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：父级编号
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级编号
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：字典类型编号,外键，关联字典类型表(pz_dictionary_type)主键id
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：字典类型编号,外键，关联字典类型表(pz_dictionary_type)主键id
	 */
	public String getTypeId() {
		return typeId;
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
