package com.csot.recruit.service.template;

import java.util.List;

import com.csot.recruit.model.original.template.TemplateType;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface TemplateTypeService {
  MiniRtn2Grid<TemplateType> getGrid(MiniGridPageSort pageSort, String searchKey);

  TemplateType getByPrimaryKey(String primaryKey);

  void create(TemplateType templateType);

  void updateSelective(TemplateType templateType);

  void remove(String primaryKey);

  // 根据模板类型typt查询相应的模板类型
  List<TemplateType> queryTemplateTpeyList(String type);
}
