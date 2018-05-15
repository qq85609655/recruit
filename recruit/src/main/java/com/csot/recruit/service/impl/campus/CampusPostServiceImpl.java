package com.csot.recruit.service.impl.campus;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

import com.csot.recruit.common.util.ExcelReadUtils;
import com.csot.recruit.dao.original.campus.CampusPostMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusPostColumns;
import com.csot.recruit.model.original.campus.CampusPostCriteria;
import com.csot.recruit.service.campus.CampusPostService;

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

@Service("campusPostService") public class CampusPostServiceImpl implements CampusPostService {
  private static final Logger logger = LoggerFactory.getLogger(CampusPostServiceImpl.class);

  @Resource private CampusPostMapper campusPostMapper;
  @Resource private DatadictGroupTypeService datadictGroupTypeService;

  @Override public MiniRtn2Grid<CampusPost> getGrid(MiniGridPageSort pageSort, String postId,
      String jobFamily, String organization) {
    MiniRtn2Grid<CampusPost> grid = new MiniRtn2Grid<CampusPost>();
    CampusPostCriteria criteria = new CampusPostCriteria();
    CampusPostCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(jobFamily)) {
      criter.andJobFamilyEqualTo(jobFamily);
    }
    if (StringUtils.hasText(organization)) {
      criter.andOrganizationEqualTo(organization);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusPostColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusPostMapper.selectByExample(criteria));
    grid.setTotal(campusPostMapper.countByExample(criteria));
    return grid;
  }

  @Override public CampusPost getByPrimaryKey(String primaryKey) {
    return campusPostMapper.selectByPrimaryKey(primaryKey);
  }

  @Override public void create(CampusPost campusPost) {
    campusPostMapper.insert(campusPost);
  }

  @Override public void updateSelective(CampusPost campusPost) {
    campusPostMapper.updateByPrimaryKeySelective(campusPost);
  }

  @Override public void remove(String primaryKey) {
    campusPostMapper.deleteByPrimaryKey(primaryKey);
  }

  @SuppressWarnings("resource") @Override
  public AjaxRtnJson importCampusPost(MultipartFile multipartFile, String basePath) throws Exception {
    AjaxRtnJson ajax = new AjaxRtnJson();
    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    multipartFile.transferTo(new File(path));
    FileInputStream in = new FileInputStream(path);
    Workbook wb;
    int countInsert = 0;
    int countUpdate = 0;
    String msg = "";
    if (path.endsWith(".xls")) {
      wb = new HSSFWorkbook(in);
    } else if (path.endsWith(".xlsx")) {
      wb = new XSSFWorkbook(in);
    } else {
      return new AjaxRtnJson(false, "上传文件格式有误");
    }
    Sheet sheet = wb.getSheetAt(0);
    int rowNum = sheet.getLastRowNum();
    if (rowNum < 2) {
      logger.error("上传文件为空！");
    } else {
      for (int i = 2; i <= rowNum; i++) {
        Row row = sheet.getRow(i);
        String postName = ExcelReadUtils.getValue(row.getCell(0));
        String recruitQuantity = ExcelReadUtils.getValue(row.getCell(1));
        String organization = ExcelReadUtils.getValue(row.getCell(2));
        String bigCenter = ExcelReadUtils.getValue(row.getCell(3));
        String smallCenter = ExcelReadUtils.getValue(row.getCell(4));
        String jobFamily = ExcelReadUtils.getValue(row.getCell(5));
        String jobClass = ExcelReadUtils.getValue(row.getCell(6));
        String jobSubclass = ExcelReadUtils.getValue(row.getCell(7));
        String educationAdvise = ExcelReadUtils.getValue(row.getCell(8));
        String schoolAdvise = ExcelReadUtils.getValue(row.getCell(9));
        String sexAdvise = ExcelReadUtils.getValue(row.getCell(10));
        String otherDemand = ExcelReadUtils.getValue(row.getCell(11));
        String preferredMajor = ExcelReadUtils.getValue(row.getCell(12));
        String alternativeMajor = ExcelReadUtils.getValue(row.getCell(13));
        String postDescribe = ExcelReadUtils.getValue(row.getCell(14));
        String specialCondition = ExcelReadUtils.getValue(row.getCell(15));

        // 检查岗位名称，职位族，所属组织是否存在
        DatadictGroupType postNameGroupType =
            datadictGroupTypeService.getTypeByGorupCodeAndName("pose_type", postName);
        DatadictGroupType jobFamilyGroupType =
            datadictGroupTypeService.getTypeByGorupCodeAndName("post_family", jobFamily);
        DatadictGroupType organizationGroupType =
            datadictGroupTypeService.getTypeByGorupCodeAndName("campus_company", organization);
        if (null == postNameGroupType || null == jobFamilyGroupType
            || null == organizationGroupType) {
          msg += "第" + i + 1 + "行岗位或者职位族或者组织不存在；\n";
          continue;
        }
        CampusPost cp = new CampusPost();
        cp.setOrganization(organizationGroupType.getTypeId());
        cp.setReserved1(organization);
        cp.setRecruitQuantity(recruitQuantity);
        cp.setBigCenter(bigCenter);
        cp.setSmallCenter(smallCenter);
        cp.setJobClass(jobClass);
        cp.setJobSubclass(jobSubclass);
        cp.setEducationAdvise(educationAdvise);
        cp.setSchoolAdvise(schoolAdvise);
        cp.setSexAdvise(sexAdvise);
        cp.setOtherDemand(otherDemand);
        cp.setPreferredMajor(preferredMajor);
        cp.setAlternativeMajor(alternativeMajor);
        cp.setPostDescribe(postDescribe);
        cp.setSpecialCondition(specialCondition);
        // 检查是更新还是新建
        CampusPost postCheck =
            getByPostIdAndJobFamily(postNameGroupType.getTypeId(), jobFamilyGroupType.getTypeId());
        if (null == postCheck) {
          cp.setId(UUID.randomUUID().toString().replace("-", ""));
          cp.setPostId(postNameGroupType.getTypeId());
          cp.setPostName(postName);
          cp.setJobFamily(jobFamilyGroupType.getTypeId());
          cp.setReserved2(jobFamily);
          campusPostMapper.insert(cp);
          countInsert ++;
        } else {
          cp.setId(postCheck.getId());
          campusPostMapper.updateByPrimaryKeySelective(cp);
          countUpdate ++;
        }
      }
    }
    msg += "成功更新" + countUpdate + "条数据；\n成功新增" + countInsert + "条数据；\n";
    ajax.setSuccess(true);
    ajax.setMsg(msg);
    return ajax;
  }

  @Override public CampusPost getByPostIdAndJobFamily(String postId, String jobFamily) {
    CampusPostCriteria criteria = new CampusPostCriteria();
    CampusPostCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(jobFamily)) {
      criter.andJobFamilyEqualTo(jobFamily);
    }
    List<CampusPost> list = campusPostMapper.selectByExample(criteria);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override public List<CampusPost> getPostByJobFamily(String jobFamilyId) {
    CampusPostCriteria criteria = new CampusPostCriteria();
    criteria.or().andJobFamilyEqualTo(jobFamilyId);
    return campusPostMapper.selectByExample(criteria);
  }

  @Override public List<CampusPost> getByPostJobFamilyOrganiztion(String postId, String jobFamilyId,
      String organizationId) {
    CampusPostCriteria criteria = new CampusPostCriteria();
    CampusPostCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(jobFamilyId)) {
      criter.andJobFamilyEqualTo(jobFamilyId);
    }
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    return campusPostMapper.selectByExample(criteria);
  }
}
