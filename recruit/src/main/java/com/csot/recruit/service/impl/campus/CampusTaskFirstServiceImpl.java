package com.csot.recruit.service.impl.campus;

import com.csot.recruit.common.util.CampusUtils;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.ExcelReadUtils;
import com.csot.recruit.dao.original.campus.CampusTaskFirstMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.original.campus.*;
import com.csot.recruit.service.campus.CampusPostService;
import com.csot.recruit.service.campus.CampusSiteService;
import com.csot.recruit.service.campus.CampusTaskFirstService;

import javax.annotation.Resource;

import com.csot.recruit.service.datadict.DatadictGroupTypeService;
import org.amberframework.core.common.model.AjaxRtnJson;
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

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

@Service("campusTaskFirstService")
public class CampusTaskFirstServiceImpl implements CampusTaskFirstService {
  private static final Logger logger = LoggerFactory.getLogger(CampusTaskFirstServiceImpl.class);

  @Resource
  private CampusTaskFirstMapper campusTaskFirstMapper;
  @Resource
  private CampusSiteService campusSiteService;
  @Resource
  private DatadictGroupTypeService datadictGroupTypeService;
  @Resource
  private CampusPostService campusPostService;

  @Override
  public MiniRtn2Grid<CampusTaskFirst> getGrid(MiniGridPageSort pageSort, String yearth, String organizationId,
                                               String siteId, String postId) {
    MiniRtn2Grid<CampusTaskFirst> grid = new MiniRtn2Grid<CampusTaskFirst>();
    CampusTaskFirstCriteria criteria = new CampusTaskFirstCriteria();
    CampusTaskFirstCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusTaskFirstColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusTaskFirstMapper.selectByExample(criteria));
    grid.setTotal(campusTaskFirstMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public CampusTaskFirst getByPrimaryKey(String primaryKey) {
    return campusTaskFirstMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(CampusTaskFirst campusTaskFirst) {
    campusTaskFirstMapper.insert(campusTaskFirst);
  }

  @Override
  public void updateSelective(CampusTaskFirst campusTaskFirst) {
    campusTaskFirstMapper.updateByPrimaryKeySelective(campusTaskFirst);
  }

  @Override
  public void remove(String ids) {
    String[] idArr = ids.split(",");
    for (int i = 0; i < idArr.length; i++) {
      campusTaskFirstMapper.deleteByPrimaryKey(idArr[i]);
    }
  }

  @SuppressWarnings("resource")
  @Override
  public AjaxRtnJson importCampusTaskFirst(MultipartFile multipartFile, String basePath)
          throws Exception {
    String msg = "";
    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    multipartFile.transferTo(new File(path));
    FileInputStream in = new FileInputStream(path);
    Workbook wb = null;
    int count = 0;
    if (path.endsWith(".xls")) {
      wb = new HSSFWorkbook(in);
    } else if (path.endsWith(".xlsx")) {
      wb = new XSSFWorkbook(in);
    } else {
      return new AjaxRtnJson(false, "上传文件格式有误！");
    }
    Sheet sheet = wb.getSheetAt(0);
    int rowNum = sheet.getLastRowNum();
    if (rowNum < 2) {
      logger.error("上传文件为空！");
      return new AjaxRtnJson(false, "上传文件为空！");
    } else {
      for (int i = 2; i <= rowNum; i++) {
        Row row = sheet.getRow(i);
        String siteName = ExcelReadUtils.getValue(row.getCell(0));
        String orgName = ExcelReadUtils.getValue(row.getCell(1));
        String bigCenter = ExcelReadUtils.getValue(row.getCell(2));
        String smallCenter = ExcelReadUtils.getValue(row.getCell(3));
        String department = ExcelReadUtils.getValue(row.getCell(4));
        String branch = ExcelReadUtils.getValue(row.getCell(5));
        String jobFamily = ExcelReadUtils.getValue(row.getCell(6));
        String jobClass = ExcelReadUtils.getValue(row.getCell(7));
        String jobSubclass = ExcelReadUtils.getValue(row.getCell(8));
        String jobDescribe = ExcelReadUtils.getValue(row.getCell(9));
        String nightShift = ExcelReadUtils.getValue(row.getCell(10));
        String dustFree = ExcelReadUtils.getValue(row.getCell(11));
        String education = ExcelReadUtils.getValue(row.getCell(12));
        String taskNumberSum = ExcelReadUtils.getValue(row.getCell(13));
        String taskNumberMail = ExcelReadUtils.getValue(row.getCell(14));
        String taskNumberFemail = ExcelReadUtils.getValue(row.getCell(15));
        String specialRequire = ExcelReadUtils.getValue(row.getCell(16));
        String preferredMajor = ExcelReadUtils.getValue(row.getCell(17));
        String alternativeMajor = ExcelReadUtils.getValue(row.getCell(18));
        String remark = ExcelReadUtils.getValue(row.getCell(19));

        Integer taskNumberSumInt =
                StringUtils.hasText(taskNumberSum) ? Integer.parseInt(taskNumberSum) : 0;
        Integer taskNumberMailInt =
                StringUtils.hasText(taskNumberMail) ? Integer.parseInt(taskNumberMail) : 0;
        Integer taskNumberFemailInt =
                StringUtils.hasText(taskNumberFemail) ? Integer.parseInt(taskNumberFemail) : 0;
        String yearth = CampusUtils.getCurrentYearth();

        // 校验唯一性校验字段是否已填
        if (!StringUtils.hasText(siteName)) {
          msg = msg + (i + 1) + "行未填写站点；";
          continue;
        }
        if (!StringUtils.hasText(orgName)) {
          msg = msg + (i + 1) + "行未填写组织；";
          continue;
        }
        if (!StringUtils.hasText(bigCenter)) {
          msg = msg + (i + 1) + "行未填写大中心；";
          continue;
        }
        if (!StringUtils.hasText(smallCenter)) {
          msg = msg + (i + 1) + "行未填写小中心；";
          continue;
        }
        if (!StringUtils.hasText(department)) {
          msg = msg + (i + 1) + "行未填写部门；";
          continue;
        }
        if (!StringUtils.hasText(branch)) {
          msg = msg + (i + 1) + "行未填写科室；";
          continue;
        }
        if (!StringUtils.hasText(jobFamily)) {
          msg = msg + (i + 1) + "行未填写职位族；";
          continue;
        }
        if (!StringUtils.hasText(jobClass)) {
          msg = msg + (i + 1) + "行未填写职位类；";
          continue;
        }

        if (!(StringUtils.hasText(education) && (CommonConstant.EDUCATION_BA.equals(education)
                || CommonConstant.EDUCATION_MA.equals(education) || CommonConstant.EDUCATION_DO.equals(education)))) {
          msg = msg + (i + 1) + "行未填写正确学历（本科/硕士/博士）；";
          continue;
        }

        if (taskNumberSumInt < taskNumberMailInt + taskNumberFemailInt) {
          msg = msg + (i + 1) + "行任务总数应不小于男女总和；";
          continue;
        }

        // 校验组织、站点、职位族、职位类是否存在
        CampusSite site = campusSiteService.getBySiteIdOrName("", siteName);
        DatadictGroupType jf =
                datadictGroupTypeService.getTypeByGorupCodeAndName("post_family", jobFamily);
        DatadictGroupType post =
                datadictGroupTypeService.getTypeByGorupCodeAndName("pose_type", jobClass);
        DatadictGroupType org =
                datadictGroupTypeService.getTypeByGorupCodeAndName("campus_company", orgName);
        if (null == site || null == post || null == org || null == jf || !"1".equals(site.getStatus())) {
          if (null == site) {
            msg = msg + siteName + "站点不存在；";
          } else if (!"1".equals(site.getStatus())) {
            msg = msg + siteName + "站点已停用；";
          }
          if (null == jf) {
            msg = msg + jobFamily + "职位族不存在；";
          }
          if (null == post) {
            msg = msg + jobClass + "职位类不存在；";
          }
          if (null == org) {
            msg = msg + orgName + "组织不存在；";
          }
          continue;
        }

        // 校验该职位族对应的职位类是否已创建为岗位
        CampusPost campusPost =
                campusPostService.getByPostIdAndJobFamily(post.getTypeId(), jf.getTypeId());
        if (null == campusPost) {
          msg = msg + "职位族[" + jobFamily + "]下的职位类[" + jobClass + "]岗位未创建；";
          continue;
        }

        CampusTaskFirst task = new CampusTaskFirst();
        task.setYearth(yearth);
        task.setPostId(post.getTypeId());
        task.setPostName(jobClass);
        task.setSiteId(site.getSiteId());
        task.setSiteName(siteName);
        task.setOrganization(org.getTypeId());
        task.setOrgName(orgName);
        task.setBigCenter(bigCenter);
        task.setSmallCenter(smallCenter);
        task.setDepartment(department);
        task.setBranch(branch);
        task.setJobFamily(jobFamily);
        task.setJobClass(jobClass);
        task.setJobSubclass(jobSubclass);
        task.setJobDescribe(jobDescribe);
        task.setNightShift(nightShift);
        task.setDustFree(dustFree);
        task.setReserved1(education);
        task.setTaskNumberSum(taskNumberSumInt);
        task.setTaskNumberMail(taskNumberMailInt);
        task.setTaskNumberFemail(taskNumberFemailInt);
        task.setSpecialRequire(specialRequire);
        task.setPreferredMajor(preferredMajor);
        task.setAlternativeMajor(alternativeMajor);
        task.setRemark(remark);

        CampusTaskFirst isExsit = checkTaskFirstIsExsit(task);
        if (null == isExsit) {
          task.setId(UUID.randomUUID().toString().replace("-", ""));
          campusTaskFirstMapper.insert(task);
        } else {
          task.setId(isExsit.getId());
          updateSelective(task);
        }
        count++;
      }
    }
    return new AjaxRtnJson(true, "成功更新" + count + "条任务； " + msg);
  }

  public CampusTaskFirst checkTaskFirstIsExsit(CampusTaskFirst task) {
    CampusTaskFirstCriteria criteria = new CampusTaskFirstCriteria();
    CampusTaskFirstCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(task.getYearth())) {
      criter.andYearthEqualTo(task.getYearth());
    }
    if (StringUtils.hasText(task.getPostId())) {
      criter.andPostIdEqualTo(task.getPostId());
    }
    if (StringUtils.hasText(task.getSiteId())) {
      criter.andSiteIdEqualTo(task.getSiteId());
    }
    if (StringUtils.hasText(task.getOrganization())) {
      criter.andOrganizationEqualTo(task.getOrganization());
    }
    if (StringUtils.hasText(task.getBigCenter())) {
      criter.andBigCenterEqualTo(task.getBigCenter());
    }
    if (StringUtils.hasText(task.getSmallCenter())) {
      criter.andSmallCenterEqualTo(task.getSmallCenter());
    }
    if (StringUtils.hasText(task.getDepartment())) {
      criter.andDepartmentEqualTo(task.getDepartment());
    }
    if (StringUtils.hasText(task.getBranch())) {
      criter.andBranchEqualTo(task.getBranch());
    }
    if (StringUtils.hasText(task.getReserved1())) {
      criter.andReserved1EqualTo(task.getReserved1());
    }
    List<CampusTaskFirst> list = campusTaskFirstMapper.selectByExample(criteria);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public List<CampusTaskFirst> getTaskFirstByOrganizationSitePostYearth(String organizationId, String siteId,
                                                                        String postId, String yearth) {
    CampusTaskFirstCriteria criteria = new CampusTaskFirstCriteria();
    CampusTaskFirstCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    List<CampusTaskFirst> list = campusTaskFirstMapper.selectByExample(criteria);
    return list;
  }
}