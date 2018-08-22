package com.bootdo.template.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 模板
 * 
 * @author zhaolijuan
 * @date 2018-08-02 11:40:43
 */
public class TemplateDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//模板编号
	private String templateId;
	//模板名称
	private String templateName;
	//模板语言（简体中文，繁体中文，English）
	private String templateLanguage;
	//模板内容
	private String templateContent;
	//模板版本
	private String templateVersion;
	//模板生效时间
	private Date effectTime;
	//模板备注
	private String remarks;
	//模板类型编号
	private String typeId;
	//模板创建时间
	private Date createTime;
	//模板修改时间
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
	 * 格式化生效时间
	 * @return
	 */
	public String getEffectTimeString(){
		if(effectTime!=null){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(effectTime);
		}
        return null;
	}

	/**
	 * 设置：模板编号
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板编号
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：模板语言（简体中文，繁体中文，English）
	 */
	public void setTemplateLanguage(String templateLanguage) {
		this.templateLanguage = templateLanguage;
	}
	/**
	 * 获取：模板语言（简体中文，繁体中文，English）
	 */
	public String getTemplateLanguage() {
		return templateLanguage;
	}
	/**
	 * 设置：模板内容
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	/**
	 * 获取：模板内容
	 */
	public String getTemplateContent() {
		return templateContent;
	}
	/**
	 * 设置：模板版本
	 */
	public void setTemplateVersion(String templateVersion) {
		this.templateVersion = templateVersion;
	}
	/**
	 * 获取：模板版本
	 */
	public String getTemplateVersion() {
		return templateVersion;
	}
	/**
	 * 设置：模板生效时间
	 */
	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}
	/**
	 * 获取：模板生效时间
	 */
	public Date getEffectTime() {
		return effectTime;
	}
	/**
	 * 设置：模板备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：模板备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：模板类型编号
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：模板类型编号
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * 设置：模板创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：模板创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：模板修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：模板修改时间
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
