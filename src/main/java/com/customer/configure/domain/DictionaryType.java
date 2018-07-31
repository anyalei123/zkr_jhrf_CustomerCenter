package com.customer.configure.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * [Created By Sinosoft]
 * Table: dictionary_type
@mbggenerated do_not_delete_during_merge 2018-07-31 17:46:59
 */
public class DictionaryType implements Serializable {
    /**
     *   字典类型编码
     * Column: dictionary_type.type_id
    @mbggenerated 2018-07-31 17:46:59
     */
    private String type_id;

    /**
     *   字典类型名称
     * Column: dictionary_type.type_name
    @mbggenerated 2018-07-31 17:46:59
     */
    private String type_name;

    /**
     *   字典类型描述
     * Column: dictionary_type.type_desc
    @mbggenerated 2018-07-31 17:46:59
     */
    private String type_desc;

    /**
     *   创建时间
     * Column: dictionary_type.create_time
    @mbggenerated 2018-07-31 17:46:59
     */
    private Date create_time;

    /**
     *   创建人
     * Column: dictionary_type.create_by
    @mbggenerated 2018-07-31 17:46:59
     */
    private String create_by;

    /**
     *   修改时间
     * Column: dictionary_type.update_time
    @mbggenerated 2018-07-31 17:46:59
     */
    private Date update_time;

    /**
     *   修改人
     * Column: dictionary_type.update_by
    @mbggenerated 2018-07-31 17:46:59
     */
    private String update_by;

    /**
     *   是否可修改
     * Column: dictionary_type.can_edit
    @mbggenerated 2018-07-31 17:46:59
     */
    private String can_edit;

    /**
     * Table: dictionary_type
    @mbggenerated 2018-07-31 17:46:59
     */
    private static final long serialVersionUID = 1L;

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id == null ? null : type_id.trim();
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    public String getType_desc() {
        return type_desc;
    }

    public void setType_desc(String type_desc) {
        this.type_desc = type_desc == null ? null : type_desc.trim();
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

    public String getCan_edit() {
        return can_edit;
    }

    public void setCan_edit(String can_edit) {
        this.can_edit = can_edit == null ? null : can_edit.trim();
    }
}