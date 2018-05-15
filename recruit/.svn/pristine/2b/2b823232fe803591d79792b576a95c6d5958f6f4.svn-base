package org.amberframework.core.excel.poi.param;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("excelExport")
public class ExcelExportParamCollection {

  @XStreamImplicit
  private List<ExcelExportParameter> entityList = new ArrayList<ExcelExportParameter>();
  
  @XStreamAlias("showIndex")
  private boolean showIndex;
  
  @XStreamAlias("indexColumnNum")
  private int indexColumnNum;

  public List<ExcelExportParameter> getEntityList() {
    return entityList;
  }

  public void setEntityList(List<ExcelExportParameter> entityList) {
    this.entityList = entityList;
  }

  public boolean isShowIndex() {
    return showIndex;
  }

  public void setShowIndex(boolean showIndex) {
    this.showIndex = showIndex;
  }

  public int getIndexColumnNum() {
    return indexColumnNum;
  }

  public void setIndexColumnNum(int indexColumnNum) {
    this.indexColumnNum = indexColumnNum;
  }
}
