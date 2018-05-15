package com.csot.gm.materialManage.service.clean;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.csot.gm.materialManage.model.original.clean.Clean;

import com.csot.gm.materialManage.model.original.partNo.PartNo;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface CleanService {
  MiniRtn2Grid<Clean> getGrid(MiniGridPageSort pageSort, String searchKey);

  Clean getByPrimaryKey(String primaryKey);

  void create(Clean clean);

  void updateSelective(Clean clean);

  void remove(String primaryKey);
  
  void checkPartNoAndInsert(PartNo partNo);

  void exportClean(HttpServletResponse response);
  
  List<Clean> getAllClean();
}