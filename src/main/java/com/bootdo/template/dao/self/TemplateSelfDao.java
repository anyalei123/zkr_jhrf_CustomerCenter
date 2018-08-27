package com.bootdo.template.dao.self;

import com.bootdo.template.domain.PlaceholderDO;
import com.bootdo.template.domain.TemplateDO;
import com.bootdo.template.domain.TemplateTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 赵丽娟
 * @date 2018/8/26 21:24
 */
@Mapper
public interface TemplateSelfDao {

    /**
     * 查询模板类型列表数据
     * 将模板类型名称展示到模板添加页面的模板类型下拉选项中
     * @return
     */
    List<TemplateTypeDO> listType();

    /**
     * 根据id删除模板类型，若该类型下有模板，该模板类型不能删除
     * @param typeId
     * @return
     */
    int remove(String typeId);

    /**
     * 批量删除模板类型，若该类型下有模板，该模板类型不能删除
     * @param typeIds
     * @return
     */
    int batchRemove(String[] typeIds);

    /**
     * 通过模板类型名称查询模板类型对象
     * @param templateType
     * @return
     */
    TemplateTypeDO getByTypeName(TemplateTypeDO templateType);

    /**
     * 通过模板名称查询模板对象
     * @param template
     * @return
     */
    TemplateDO getByTemplateName(TemplateDO template);

    /**
     * 通过占位符名称查询占位符对象
     * @param placeholder
     * @return
     */
    PlaceholderDO getByPlaceholderName(PlaceholderDO placeholder);

}
