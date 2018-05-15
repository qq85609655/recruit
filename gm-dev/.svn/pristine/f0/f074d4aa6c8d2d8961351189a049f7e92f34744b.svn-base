package com.csot.gm.materialManage.service.partNo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.util.SpareExcelVbo;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.ss.usermodel.Workbook;

public interface PartNoService {

  MiniRtn2Grid<PartNo> getGrid(MiniGridPageSort pageSort, String searchKey, String partId,
      String partClassId, String brandValue, String specValue, String ownerName, String partType,
      String partName, String beginDate, String endDate, String partNos, String department);

  PartNo getByPrimaryKey(String primaryKey);

  void create(PartNo partNo);

  void updateSelective(PartNo partNo);

  void remove(String primaryKey, String userAccount);

  List<PartNoExt> getPartNoListByPartId(String partId);

  PartNoExt getPartNoByUid(String uid);

  void updateAllHashCode();

  String exportPartNoById(HttpServletRequest request, String partNoIds);

  void updateHashCode(String partNoId);

  MiniRtn2Grid<PartNo> getAllSpareConsumptive(MiniGridPageSort pageSort, String partType);

  String getIdByPartNo(String partNo);

  AjaxRtnJson checkPartNoType(String partType, String partNo);

  String getLevelByPartNoId(String partNoId);

  String export6171(HttpServletRequest request);

  List<PartNo> getAll6171PartNo();

  PartNo getPartNoByPartNoId(String partNoId);

  String exportPartNoByClass(HttpServletRequest request);

  String exportPartNoByGroup(HttpServletRequest request);

  String exportPartNoByProperty(HttpServletRequest request);

  String exportPartNoByAnySearch(HttpServletRequest request);

  MiniRtn2Grid<PartNo> getUserDataGrid(MiniGridPageSort pageSort, String searchKey, String partId,
      String partClassId, String brandValue, String specValue, String ownerName, String partType,
      String partName, String beginDate, String endDate, String partNos, String department);

  List<SpareExcelVbo> getListByBrandSpec(String brand, String spec);

  Workbook exportBrandSpecExcel(List<SpareExcelVbo> list);

  List<PartNo> getPartNoListByIdArray(String[] partNoIdArr);
}
