package com.csot.gm.materialManage.service.impl.clean;

import com.csot.gm.materialManage.dao.extension.clean.CleanExtMapper;
import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.original.clean.CleanMapper;
import com.csot.gm.materialManage.model.extension.clean.CleanExt;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.materialManage.model.original.clean.Clean;
import com.csot.gm.materialManage.model.original.clean.CleanColumns;
import com.csot.gm.materialManage.model.original.clean.CleanCriteria;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.service.clean.CleanService;
import com.csot.gm.util.PropertyName;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("cleanService")
public class CleanServiceImpl implements CleanService {
  private static final Logger logger = LoggerFactory.getLogger(CleanServiceImpl.class);

  @Resource
  private CleanMapper cleanMapper;
  @Resource
  private CleanExtMapper cleanExtMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;

  @Override
  public MiniRtn2Grid<Clean> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<Clean> grid = new MiniRtn2Grid<Clean>();
    CleanCriteria criteria = new CleanCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andPartNoLike("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CleanColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(cleanMapper.selectByExample(criteria));
    grid.setTotal(cleanMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Clean getByPrimaryKey(String primaryKey) {
    return cleanMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Clean clean) {
    clean.setId(UUID.randomUUID().toString().replace("-", ""));
    cleanMapper.insert(clean);
  }

  @Override
  public void updateSelective(Clean clean) {
    cleanMapper.updateByPrimaryKeySelective(clean);
  }

  @Override
  public void remove(String primaryKey) {
    cleanMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void checkPartNoAndInsert(PartNo partNo) {
    logger.info("开始更新料号" + partNo.getPartNo());
    List<PropertyValueExt> brandValue =
        propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(partNo.getId(),
            PropertyName.SC_BRAND);
    List<PropertyValueExt> specValue =
        propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(partNo.getId(),
            PropertyName.SC_SPEC);

    if (brandValue.isEmpty() || specValue.isEmpty()) {
      logger.info("该料号没有品牌或者规格属性值，不可清洗");
    } else {
      String brand = brandValue.get(0).getPropertyValue();
      String spec = specValue.get(0).getPropertyValue();
      Clean clean = new Clean();
      clean.setBrand(brand);
      clean.setSpec(spec);
      clean.setPartNo(partNo.getPartNo());
      List<CleanExt> list = cleanExtMapper.selectByBrandSpec(spec, brand);
      if (!list.isEmpty()) {
        clean.setStatus("F");
        clean.setInfo("已创建料号品牌规格重复，原料号为：" + list.get(0).getPartNo());
        logger.info("#####" + new Date() + "已创建料号品牌规格重复，原料号为：" + list.get(0).getPartNo());
      } else {
        clean.setStatus("S");
        clean.setInfo("");
        logger.info("#####" + new Date() + "料号清洗通过");
      }
      create(clean);
    }
  }

  @Override
  public void exportClean(HttpServletResponse response) {
    // 创建一个webbook，对应一个Excel文件
    HSSFWorkbook wb = new HSSFWorkbook();

    createCleanSheet(wb);

    // 将文件存到指定位置
    try {
      Date date = new Date();
      String fileName = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(date) + "_备品耗材料号信息";

      response.setCharacterEncoding("UTF-8");
      response.setContentType("multipart/form-data");

      response.setHeader("Content-Disposition", "attachment;fileName="
          + new String((fileName + ".xls").getBytes("gbk"), "iso-8859-1"));

      OutputStream out = response.getOutputStream();
      wb.write(out);
      out.close();
    } catch (UnsupportedEncodingException e1) {
      logger.error("文件格式不对.", e1);
    } catch (Exception e) {
      logger.error("文件不存在。", e);
    }

  }

  private void createCleanSheet(HSSFWorkbook wb) {
    HSSFCellStyle titleStyle = wb.createCellStyle();
    titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置居中
    titleStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
    titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
    headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
    titleStyle.setFont(headerFont); // 为标题样式设置字体样式

    HSSFCellStyle valueStyle = wb.createCellStyle();
    valueStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    valueStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

    HSSFSheet sheet = wb.createSheet();
    HSSFRow rowTitle = sheet.createRow((int) 0);
    HSSFCell cell1 = rowTitle.createCell(0);
    cell1.setCellValue("料号");
    cell1.setCellStyle(titleStyle);
    HSSFCell cell2 = rowTitle.createCell(1);
    cell2.setCellValue("创建人姓名");
    cell2.setCellStyle(titleStyle);
    HSSFCell cell3 = rowTitle.createCell(2);
    cell3.setCellValue("创建人工号");
    cell3.setCellStyle(titleStyle);
    HSSFCell cell4 = rowTitle.createCell(3);
    cell4.setCellValue("创建人部门");
    cell4.setCellStyle(titleStyle);
    HSSFCell cell5 = rowTitle.createCell(4);
    cell5.setCellValue("物料名称");
    cell5.setCellStyle(titleStyle);
    HSSFCell cell6 = rowTitle.createCell(5);
    cell6.setCellValue("品牌");
    cell6.setCellStyle(titleStyle);
    HSSFCell cell7 = rowTitle.createCell(6);
    cell7.setCellValue("规格");
    cell7.setCellStyle(titleStyle);
    for (int k = 0; k < 7; k++) {
      sheet.setColumnWidth((short) k, (short) 4500);
    }
    List<Clean> cleanList = cleanMapper.selectByExample(null);
    for (int i = 0; i < cleanList.size(); i++) {
      String partNo = cleanList.get(i).getPartNo();
      String brandText = cleanList.get(i).getBrand();
      String specText = cleanList.get(i).getSpec();
      String owner = "";
      String userCode = "";
      String department = "";
      String partNoName = "";
      List<PartNoExt> pn = partNoExtMapper.selectPartNoListByPartNo(partNo);
      if (!pn.isEmpty()) {
        owner = pn.get(0).getCreateName();
        userCode = pn.get(0).getCreateCode();
        department = pn.get(0).getDepartment();
        partNoName = pn.get(0).getPartName();
      }
      HSSFRow row = sheet.createRow((int) i + 1);

      HSSFCell cellPartNo = row.createCell(0);
      if (null == partNo || "".equals(partNo)) {
        cellPartNo.setCellValue("");
        cellPartNo.setCellStyle(valueStyle);
      } else {
        cellPartNo.setCellValue(partNo);
        cellPartNo.setCellStyle(valueStyle);
      }

      HSSFCell cellOwner = row.createCell(1);
      if (null == owner || "".equals(owner)) {
        cellOwner.setCellValue("");
        cellOwner.setCellStyle(valueStyle);
      } else {
        cellOwner.setCellValue(owner);
        cellOwner.setCellStyle(valueStyle);
      }

      HSSFCell cellCode = row.createCell(2);
      if (null == userCode || "".equals(userCode)) {
        cellCode.setCellValue("");
        cellCode.setCellStyle(valueStyle);
      } else {
        cellCode.setCellValue(userCode);
        cellCode.setCellStyle(valueStyle);
      }

      HSSFCell cellDep = row.createCell(3);
      if (null == department || "".equals(department)) {
        cellDep.setCellValue("");
        cellDep.setCellStyle(valueStyle);
      } else {
        cellDep.setCellValue(department);
        cellDep.setCellStyle(valueStyle);
      }

      HSSFCell cellPartNoName = row.createCell(4);
      if (null == partNoName || "".equals(partNoName)) {
        cellPartNoName.setCellValue("");
        cellPartNoName.setCellStyle(valueStyle);
      } else {
        cellPartNoName.setCellValue(partNoName);
        cellPartNoName.setCellStyle(valueStyle);
      }

      HSSFCell cellBrand = row.createCell(5);
      if (null == brandText || "".equals(brandText)) {
        cellBrand.setCellValue("");
        cellBrand.setCellStyle(valueStyle);
      } else {
        cellBrand.setCellValue(brandText);
        cellBrand.setCellStyle(valueStyle);
      }

      HSSFCell cellSpec = row.createCell(6);
      if (null == specText || "".equals(specText)) {
        cellSpec.setCellValue("");
        cellSpec.setCellStyle(valueStyle);
      } else {
        cellSpec.setCellValue(specText);
        cellSpec.setCellStyle(valueStyle);
      }
    }

  }

  @Override
  public List<Clean> getAllClean() {
    return cleanMapper.selectByExample(null);
  }
}
