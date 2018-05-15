package com.csot.recruit.service.impl.campus;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.csot.recruit.common.util.ExcelReadUtils;
import com.csot.recruit.dao.original.campus.CampusAddressbookMapper;
import com.csot.recruit.dao.original.campus.CampusPostMapper;
import com.csot.recruit.dao.original.campus.CampusSiteMapper;
import com.csot.recruit.model.original.campus.CampusAddressbook;
import com.csot.recruit.model.original.campus.CampusAddressbookColumns;
import com.csot.recruit.model.original.campus.CampusAddressbookCriteria;
import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusPostCriteria;
import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusSiteCriteria;
import com.csot.recruit.service.campus.CampusAddressbookService;
import com.google.common.collect.Lists;

@Service("campusAddressbookService")
public class CampusAddressbookServiceImpl implements CampusAddressbookService {
  private static final Logger logger = LoggerFactory.getLogger(CampusAddressbookServiceImpl.class);

  @Resource
  private CampusAddressbookMapper campusAddressbookMapper;

  @Resource
  private CampusSiteMapper campusSiteMapper;

  @Resource
  private CampusPostMapper campusPostMapper;

  @Override
  public MiniRtn2Grid<CampusAddressbook> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<CampusAddressbook> grid = new MiniRtn2Grid<CampusAddressbook>();
    CampusAddressbookCriteria criteria = new CampusAddressbookCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andRealnameLike("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusAddressbookColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusAddressbookMapper.selectByExample(criteria));
    grid.setTotal(campusAddressbookMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public CampusAddressbook getByPrimaryKey(String primaryKey) {
    return campusAddressbookMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(CampusAddressbook campusAddressbook) {
    campusAddressbookMapper.insert(campusAddressbook);
  }

  @Override
  public void updateSelective(CampusAddressbook campusAddressbook) {
    campusAddressbookMapper.updateByPrimaryKeySelective(campusAddressbook);
  }

  @Override
  public void remove(String primaryKey) {
    campusAddressbookMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 导入校招模板信息，即批量新增
   */
  @SuppressWarnings("resource")
  @Override
  public String importAddressbook(MultipartFile multipartFile, String basePath, String importer)
      throws Exception {
    // 获取模板名称
    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    multipartFile.transferTo(new File(path));
    FileInputStream in = new FileInputStream(path);
    Workbook wb = null;
    String message = "";
    if (path.endsWith(".xls")) {
      wb = new HSSFWorkbook(in);
    } else if (path.endsWith(".xlsx")) {
      wb = new XSSFWorkbook(in);
    } else {
      return "导入文件格式不对!";
    }
    Sheet sheet = wb.getSheetAt(0);
    int rowNum = sheet.getLastRowNum();
    if (rowNum < 1) {
      logger.error("上传文件为空！");
    } else {
      for (int i = 2; i <= rowNum; i++) {
        // 解析单元格时,从第3行开始,第一行为标题,第二行为列说明item
        Row row = sheet.getRow(i);

        for (int j = 0; j <= 6; j++) {
          if (StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(j)))) {
            logger.error(sheet.getRow(1).getCell(j) + "为必填项");
            message =
                message.concat("第：" + (i + 1) + "行的" + sheet.getRow(1).getCell(j) + "为必填项" + "\n");
          }
        }
        // 调用ExcelReadUtils类的getValue()方法，根据不同的单元格数据格式获取相应类型的数据。
        String siteName = ExcelReadUtils.getValue(row.getCell(0));
        String siteId = ExcelReadUtils.getValue(row.getCell(1));
        if (!StringUtils.isEmpty(siteName) && !(StringUtils.isEmpty(siteId))
            && (doGetSiteInfo(siteId, siteName).size() <= 0)) {
          logger.error("站点名或者站点ID不存在");
          message = message.concat("第：" + (i + 1) + "行" + "站点名或者站点ID不存在" + "\n");
        }

        String workNo = ExcelReadUtils.getValue(row.getCell(3));
        // 如果工号长度大于16，则此数据新建不成功
        if (!StringUtils.isEmpty(workNo) && workNo.length() > 16) {
          logger.error("工号长度大于16");
          message = message.concat("第：" + (i + 1) + "行" + "的工号长度大于16" + "\n");
        }
        String phoneNo = ExcelReadUtils.getValue(row.getCell(5));
        if (phoneNo.length() != 11) {
          logger.error("联系电话长度大于11");
          message = message.concat("第：" + (i + 1) + "行" + "的联系电话长度应为11" + "\n");
        }
        String email = ExcelReadUtils.getValue(row.getCell(6));
        int m = email.indexOf('@');
        int n = email.indexOf('.');
        if (!(m != -1 && n != -1 && m < n)) {
          logger.error("邮箱格式不对");
          message = message.concat("第" + (i + 1) + " 行" + "邮箱格式不对" + "\n");
        }
      }
      // 当所有的检验都通过时才新增所以的数据，否则返回错去的信息到界面
      if ("".equals(message)) {
        for (int j = 1; j <= rowNum; j++) {

          Row row1 = sheet.getRow(j);
          CampusAddressbook campusAb = new CampusAddressbook();
          campusAb.setSiteName(ExcelReadUtils.getValue(row1.getCell(0)));
          campusAb.setSiteId(ExcelReadUtils.getValue(row1.getCell(1)));
          campusAb.setCampusRole(ExcelReadUtils.getValue(row1.getCell(2)));
          campusAb.setRealname(ExcelReadUtils.getValue(row1.getCell(3)));
          campusAb.setWorkNo(ExcelReadUtils.getValue(row1.getCell(4)));
          campusAb.setPhoneno(ExcelReadUtils.getValue(row1.getCell(5)));
          campusAb.setEmail(ExcelReadUtils.getValue(row1.getCell(6)));
          // UUID方式生成ID
          campusAb.setId(UUID.randomUUID().toString().replace("-", ""));
          campusAddressbookMapper.insert(campusAb);
        }
        message = "成功导入数据" + rowNum + "条";
      }
    }
    return message;
  }

  /**
   * 按姓名导出通讯录信息
   */
  @Override
  public List<CampusAddressbook> exportPartNoRealName(String realName) {

    List<CampusAddressbook> campusList = Lists.newArrayList();
    CampusAddressbookCriteria criteria = new CampusAddressbookCriteria();
    // 查询条件
    if (StringUtils.hasText(realName)) {
      criteria.createCriteria().andRealnameLike("%" + realName + "%");
    }
    campusList = campusAddressbookMapper.selectByExample(criteria);

    return campusList;
  }



  @Override
  public List<CampusSite> doGetSiteInfo(String siteId, String siteName) {

    CampusSiteCriteria criteria = new CampusSiteCriteria();

    // 查询条件
    if (StringUtils.hasText(siteId)) {
      criteria.or().andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(siteName)) {
      criteria.or().andSiteNameEqualTo(siteName);
    }
    List<CampusSite> campusSiteList = campusSiteMapper.selectByExample(criteria);

    return campusSiteList;
  }

  @Override
  public List<CampusPost> doGetPostInfo(String id, String postName) {

    CampusPostCriteria criteria = new CampusPostCriteria();

    // 查询条件
    if (StringUtils.hasText(id)) {
      criteria.or().andIdEqualTo(id);
    }
    if (StringUtils.hasText(postName)) {
      criteria.or().andPostNameEqualTo(postName);
    }

    return campusPostMapper.selectByExample(criteria);

  }

}
