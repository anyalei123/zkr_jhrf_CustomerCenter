package com.customer.configure.domain ;

import java.io.Serializable;
import java.util.Date;

/**
 * [Created By Sinosoft]
 * Table: dictionary
@mbggenerated do_not_delete_during_merge 2018-07-31 17:46:59
 */
public class Dictionary implements Serializable {
    /**
     *   字典编号
     * Column: dictionary.dict_id
    @mbggenerated 2018-07-31 17:46:59
     */
    private String dict_id;

    /**
     *   字典名称
     * Column: dictionary.dict_name
    @mbggenerated 2018-07-31 17:46:59
     */
    private String dict_name;

    /**
     *   字典类型编号
     * Column: dictionary.type_id
    @mbggenerated 2018-07-31 17:46:59
     */
    private String type_id;

    /**
     *   字典描述
     * Column: dictionary.dict_desc
    @mbggenerated 2018-07-31 17:46:59
     */
    private String dict_desc;

    /**
     *   排序（升序）
     * Column: dictionary.dict_sort
    @mbggenerated 2018-07-31 17:46:59
     */
    private Long dict_sort;

    /**
     *   创建时间
     * Column: dictionary.create_time
    @mbggenerated 2018-07-31 17:46:59
     */
    private Date create_time;

    /**
     *   创建人
     * Column: dictionary.create_by
    @mbggenerated 2018-07-31 17:46:59
     */
    private String create_by;

    /**
     *   修改时间
     * Column: dictionary.update_time
    @mbggenerated 2018-07-31 17:46:59
     */
    private Date update_time;

    /**
     *   修改人
     * Column: dictionary.update_by
    @mbggenerated 2018-07-31 17:46:59
     */
    private String update_by;

    /**
     *   删除标记
     * Column: dictionary.del_flag
    @mbggenerated 2018-07-31 17:46:59
     */
    private String del_flag;

    /**
     *   备注信息
     * Column: dictionary.remarks
    @mbggenerated 2018-07-31 17:46:59
     */
    private String remarks;

    /**
     * Table: dictionary
    @mbggenerated 2018-07-31 17:46:59
     */
    private static final long serialVersionUID = 1L;

    public String getDict_id() {
        return dict_id;
    }

    public void setDict_id(String dict_id) {
        this.dict_id = dict_id == null ? null : dict_id.trim();
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name == null ? null : dict_name.trim();
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id == null ? null : type_id.trim();
    }

    public String getDict_desc() {
        return dict_desc;
    }

    public void setDict_desc(String dict_desc) {
        this.dict_desc = dict_desc == null ? null : dict_desc.trim();
    }

    public Long getDict_sort() {
        return dict_sort;
    }

    public void setDict_sort(Long dict_sort) {
        this.dict_sort = dict_sort;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by == null ? null : create_by.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by == null ? null : update_by.trim();
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag == null ? null : del_flag.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}