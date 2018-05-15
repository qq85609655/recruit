package com.csot.recruit.service.impl.campus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
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

import com.csot.recruit.common.util.CampusUtils;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.ExcelReadUtils;
import com.csot.recruit.dao.original.campus.CampusStudentMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusStudent;
import com.csot.recruit.model.original.campus.CampusStudentColumns;
import com.csot.recruit.model.original.campus.CampusStudentCriteria;
import com.csot.recruit.service.campus.CampusAddressbookService;
import com.csot.recruit.service.campus.CampusPostService;
import com.csot.recruit.service.campus.CampusStudentService;
import com.csot.recruit.service.datadict.DatadictGroupTypeService;
import com.google.common.collect.Lists;

@Service("campusStudentService")
public class CampusStudentServiceImpl implements CampusStudentService {
  private static final Logger logger = LoggerFactory.getLogger(CampusStudentServiceImpl.class);

  @Resource
  private CampusStudentMapper campusStudentMapper;

  @Resource
  private CampusAddressbookService campusAddressbookService;

  @Resource
  private CampusPostService campusPostService;

  @Resource
  private DatadictGroupTypeService datadictGroupTypeService;


  @Override
  public MiniRtn2Grid<CampusStudent> getGrid(MiniGridPageSort pageSort, String siteId,
      String postId, String stuName, String school, String org, String center, String yearth,
      String showType, String radioValue1, String radioValue2, String radioValue3,
      String radioValue4, String radioValue5, String radioValue6, String radioValue7,
      String radioValue8) {
    MiniRtn2Grid<CampusStudent> grid = new MiniRtn2Grid<CampusStudent>();
    // 组合查询编辑器应用如下：
    CampusStudentCriteria criteria = new CampusStudentCriteria();
    CampusStudentCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(stuName)) {
      if (stuName.contains(";")) {
        String[] stuArray = stuName.split(";");
        List<String> stuList = Lists.newArrayList();
        for (int i = 0; i < stuArray.length; i++) {
          stuList.add(stuArray[i]);
        }
        criter.andRealnameIn(stuList);
      } else {
        criter.andRealnameLike("%" + stuName + "%");
      }
    }
    if (StringUtils.hasText(school)) {
      criter.andSchoolLike("%" + school + "%");
    }
    if (StringUtils.hasText(org)) {
      criter.andOrgIdEqualTo(org);
    }
    if (StringUtils.hasText(center)) {
      criter.andBigCenterLike("%" + center + "%");
    }
    if (StringUtils.hasText(yearth)) {
      criter.andYearthLike("%" + yearth + "%");
    }
    if (StringUtils.hasText(showType)) {
      // 有三方
      if ("054-001".equals(showType)) {
        criter.andTrilateralEqualTo("有");
        // criter.andOfferEqualTo("有");
        // criter.andBreakOffEqualTo("无");
      } else if ("054-002".equals(showType)) {
        // 有三方且违约
        criter.andTrilateralEqualTo("有");
        criter.andBreakOffEqualTo("有");
      } else if ("054-003".equals(showType)) {
        // 有offer无三方
        criter.andOfferEqualTo("有");
        criter.andTrilateralEqualTo("无");
      } else if ("054-004".equals(showType)) {
        // 有offer无三方
        criter.andOfferEqualTo("无");
        criter.andTrilateralEqualTo("有");
      }
    }
    if (StringUtils.hasText(radioValue1)) {
      criter.andOfferEqualTo(radioValue1);
    }
    if (StringUtils.hasText(radioValue2)) {
      criter.andTrilateralEqualTo(radioValue2);
    }
    if (StringUtils.hasText(radioValue3)) { // 成绩单
      criter.andTranscriptEqualTo(radioValue3);
    }
    if (StringUtils.hasText(radioValue4)) { // 就业推荐表
      criter.andReferenceFormEqualTo(radioValue4);
    }
    if (StringUtils.hasText(radioValue5)) { // 身份证复印件
      criter.andIdcardCopyEqualTo(radioValue5);
    }
    if (StringUtils.hasText(radioValue6)) { // 四六级成绩单
      criter.andCetTranscriptEqualTo(radioValue6);
    }
    if (StringUtils.hasText(radioValue7)) { // 照片
      criter.andPhotoEqualTo(radioValue7);
    }
    if (StringUtils.hasText(radioValue8)) { // 违约情况
      criter.andBreakOffEqualTo(radioValue8);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusStudentColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusStudentMapper.selectByExample(criteria));
    grid.setTotal(campusStudentMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public CampusStudent getByPrimaryKey(String primaryKey) {
    return campusStudentMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(CampusStudent campusStudent) {
    campusStudentMapper.insert(campusStudent);
  }

  @Override
  public void updateSelective(CampusStudent campusStudent) {
    campusStudentMapper.updateByPrimaryKeySelective(campusStudent);
  }

  @Override
  public void remove(String primaryKey) {
    campusStudentMapper.deleteByPrimaryKey(primaryKey);
  }

  @SuppressWarnings("resource")
  @Override
  public String importStudentInfo(MultipartFile multipartFile, String basePath,
      @CurrentUser SysUser sysUser) {


    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    Workbook wb = null;
    String message = "";
    int count = 0;
    try {
      multipartFile.transferTo(new File(path));
      FileInputStream in = new FileInputStream(path);
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
        return "上传文件为空！";
      } else {
        // 解析单元格时,从第3行开始,第一行为标题,第二行为列说明item
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          int lastCell = row.getPhysicalNumberOfCells();
          if (StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(0)))
              && StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(1)))
              && StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(lastCell - 1)))
              && StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(lastCell - 1)))) {
            continue;
          }
          String msg = checkStudentInfo(row, i, sysUser);
          message = message.concat(msg);
          if ("".equals(msg)) {
            count++;
          }
        }
        message = message.concat("总共成功导入" + count + "条数据!");
      }
    } catch (IllegalStateException | IOException e) {

      logger.debug(e.getMessage());
    }

    return message;
  }

  /**
   * 校验学生信息表
   * 
   * @param coloumNum最大列数
   * @return 校验错误提示信息
   */
  public String checkStudentInfo(Row row, int i, @CurrentUser SysUser sysUser) {

    String message = "";

    String idNo = ExcelReadUtils.getValue(row.getCell(0));
    if (null != campusStudentMapper.selectByPrimaryKey(idNo)) {
      logger.error("学生信息已存在");
      message = message.concat("第" + (i + 1) + " 行" + "的学生信息已存在" + "\n");
    }
    if (idNo.length() != 18) {
      logger.error("身份证号码长度应为18");
      message = message.concat("第" + (i + 1) + " 行" + "的身份证号码长度应为18" + "\n");
    }
    String siteName = ExcelReadUtils.getValue(row.getCell(1));
    if (campusAddressbookService.doGetSiteInfo("", siteName).size() <= 0) {
      logger.error("站点名不存在");
      message = message.concat("第" + (i + 1) + " 行" + "的站点名不存在" + "\n");
    }
    String orgName = ExcelReadUtils.getValue(row.getCell(3));
    if (null == datadictGroupTypeService.getTypeByGorupCodeAndName("campus_company", orgName)) {
      logger.error("组织名不存在");
      message = message.concat("第" + (i + 1) + " 行" + "的组织名不存在" + "\n");
    }
    String postName = ExcelReadUtils.getValue(row.getCell(8));
    List<CampusPost> cas = campusAddressbookService.doGetPostInfo("", postName);
    if (null == cas || cas.size() <= 0) {
      logger.error("岗位名不存在");
      message = message.concat("第" + (i + 1) + " 行" + "的岗位名不存在" + "\n");
    }
    String phoneNo = ExcelReadUtils.getValue(row.getCell(15));
    if (phoneNo.length() != 11) {
      logger.error("电话号码长度应为11");
      message = message.concat("第" + (i + 1) + " 行" + "电话号码长度应为11" + "\n");
    }
    String email = ExcelReadUtils.getValue(row.getCell(16));
    int m = email.indexOf('@');
    int n = email.indexOf('.');
    if (!(m != -1 && n != -1 && m < n)) {
      logger.error("邮箱格式不对");
      message = message.concat("第" + (i + 1) + " 行" + "邮箱格式不对" + "\n");
    }
    String competency = ExcelReadUtils.getValue(row.getCell(19));
    if (!competency.endsWith("%")) {
      logger.error("胜任力填百分数");
      message = message.concat("第" + (i + 1) + " 行" + "胜任力填含%的百分数" + "\n");
    }
    String first = ExcelReadUtils.getValue(row.getCell(20));
    if (!("S".equals(first)) && !("A".equals(first)) && !("B".equals(first))
        && !("C".equals(first))) {
      logger.error("一面成绩应填S、A、B或C");
      message = message.concat("第" + (i + 1) + " 行" + "一面成绩应填S、A、B或C" + "\n");
    }
    String second = ExcelReadUtils.getValue(row.getCell(21));
    if (!("S".equals(second)) && !("A".equals(second)) && !("B".equals(second))
        && !("C".equals(second))) {
      logger.error("二面成绩应填S、A、B或C");
      message = message.concat("第" + (i + 1) + " 行" + "二面成绩应填S、A、B或C" + "\n");
    }
    for (int j = 22; j <= 29; j++) {
      String isHas = ExcelReadUtils.getValue(row.getCell(j));
      if (!CommonConstant.YES.equals(isHas) && !CommonConstant.NO.equals(isHas)) {
        logger.error("第" + j + "列应填写有或无");
        message = message.concat("第" + (i + 1) + " 行" + "的第" + (j + 1) + "列应填写有或无" + "\n");
      }
    }
    // 第1到28列为必填项
    for (int k = 0; k <= 29; k++) {
      if (StringUtils.isEmpty(ExcelReadUtils.getValue(row.getCell(k)))) {
        logger.error("第" + k + "列为必填项！");
        message = message.concat("第" + (i + 1) + " 行" + "的第" + (k + 1) + "列为必填项" + "\n");
      }
    }

    // 若校验全部通过
    if ("".equals(message)) {

      CampusStudent campusStu = doSetCampusStuInfo(row, sysUser);

      campusStudentMapper.insert(campusStu);
    }

    return message;
  }

  /**
   * 获取excel表内容且set到CampusStudent对象中
   * 
   * @param row
   * @return
   */
  public CampusStudent doSetCampusStuInfo(Row row, @CurrentUser SysUser sysUser) {
    CampusStudent campusStu = new CampusStudent();
    // id为身份证号码
    campusStu.setId(ExcelReadUtils.getValue(row.getCell(0)));
    campusStu.setSiteName(ExcelReadUtils.getValue(row.getCell(1)));
    // 根据站点名查询站点id
    String siteId =
        campusAddressbookService.doGetSiteInfo("", ExcelReadUtils.getValue(row.getCell(1))).get(0)
            .getSiteId();
    campusStu.setSiteId(siteId);
    campusStu.setWorkingPlace(ExcelReadUtils.getValue(row.getCell(2)));
    // 根据组织名获取组织id，set到orgId中
    DatadictGroupType orgGroupType = new DatadictGroupType();
    orgGroupType =
        datadictGroupTypeService.getTypeByGorupCodeAndName("campus_company",
            ExcelReadUtils.getValue(row.getCell(3)));
    if (null != orgGroupType) {
      campusStu.setOrgId(orgGroupType.getTypeId());
      campusStu.setOrganization(orgGroupType.getTypeName());
    }
    campusStu.setBigCenter(ExcelReadUtils.getValue(row.getCell(4)));
    campusStu.setSmallCenter(ExcelReadUtils.getValue(row.getCell(5)));
    campusStu.setDepartment(ExcelReadUtils.getValue(row.getCell(6)));
    campusStu.setOffices(ExcelReadUtils.getValue(row.getCell(7)));

    // 根据岗位名称获取岗位id,职位族id,职位族名称,职位子类名称
    List<CampusPost> campusStuList = Lists.newArrayList();
    campusStuList =
        campusAddressbookService.doGetPostInfo("", ExcelReadUtils.getValue(row.getCell(8)));
    if (campusStuList.size() > 0) {
      campusStu.setPostId(campusStuList.get(0).getPostId());
      campusStu.setPostName(campusStuList.get(0).getPostName());
      // set 职位族id
      campusStu.setJobFamily(campusStuList.get(0).getJobFamily());
      // set 职位族名称
      campusStu.setJobFamilyName(campusStuList.get(0).getReserved2());
      // set 职位子类名称
      campusStu.setJobSubclass(campusStuList.get(0).getJobSubclass());
    }

    campusStu.setRealname(ExcelReadUtils.getValue(row.getCell(9)));
    campusStu.setSex(ExcelReadUtils.getValue(row.getCell(10)));
    campusStu.setEducation(ExcelReadUtils.getValue(row.getCell(11)));
    campusStu.setNativePlace(ExcelReadUtils.getValue(row.getCell(12)));
    campusStu.setSchool(ExcelReadUtils.getValue(row.getCell(13)));
    campusStu.setMajor(ExcelReadUtils.getValue(row.getCell(14)));
    campusStu.setPhoneNo(ExcelReadUtils.getValue(row.getCell(15)));
    campusStu.setEmail(ExcelReadUtils.getValue(row.getCell(16)));
    campusStu.setEvaluation(ExcelReadUtils.getValue(row.getCell(17)));
    campusStu.setMoraleRisk(ExcelReadUtils.getValue(row.getCell(18)));
    campusStu.setCompetency(ExcelReadUtils.getValue(row.getCell(19)));
    campusStu.setResultFirst(ExcelReadUtils.getValue(row.getCell(20)));
    campusStu.setResultSecond(ExcelReadUtils.getValue(row.getCell(21)));
    campusStu.setOffer(ExcelReadUtils.getValue(row.getCell(22)));
    campusStu.setIdcardCopy(ExcelReadUtils.getValue(row.getCell(23)));
    campusStu.setTrilateral(ExcelReadUtils.getValue(row.getCell(24)));
    campusStu.setReferenceForm(ExcelReadUtils.getValue(row.getCell(25)));
    campusStu.setTranscript(ExcelReadUtils.getValue(row.getCell(26)));
    campusStu.setCetTranscript(ExcelReadUtils.getValue(row.getCell(27)));
    campusStu.setPhoto(ExcelReadUtils.getValue(row.getCell(28)));
    campusStu.setBreakOff(ExcelReadUtils.getValue(row.getCell(29)));
    campusStu.setBreakOffReason(ExcelReadUtils.getValue(row.getCell(30)));
    campusStu.setYearth(CampusUtils.getCurrentYearth());
    // 设置创建人
    campusStu.setCreateUser(sysUser.getId());;

    return campusStu;
  }

  @Override
  public List<CampusStudent> getStuInfoByStudentList(List<String> studentIdList) {
    
    List<CampusStudent> studentList = campusStudentMapper.selectStuInfoByStudentList(studentIdList);
    
    return studentList;
  }

}
