package com.csot.recruit.service.impl.position;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.model.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.enums.OperateResult;
import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.EnumUtil;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandMapper;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteInstructMapper;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteMapper;
import com.csot.recruit.dao.position.DepartmentRequireMapper;
import com.csot.recruit.dao.position.DistributeMapper;
import com.csot.recruit.dao.position.PositionManaMapper;
import com.csot.recruit.dao.position.RecruitFlowConfigMapper;
import com.csot.recruit.dao.position.RecruitInforMapper;
import com.csot.recruit.dao.position.RecruitPositionMapper;
import com.csot.recruit.dao.position.RequireInforMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;
import com.csot.recruit.model.original.flow.websitePost.InstructSimpleDetail;
import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstructCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;
import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.DepartmentRequireCriteria;
import com.csot.recruit.model.position.Distribute;
import com.csot.recruit.model.position.DistributeCriteria;
import com.csot.recruit.model.position.PositionDistributeRecords;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.position.RecruitInfor;
import com.csot.recruit.model.position.RecruitInforCriteria;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitPositionColumns;
import com.csot.recruit.model.position.RecruitPositionCriteria;
import com.csot.recruit.model.position.RecruitSite;
import com.csot.recruit.model.position.RequireInfor;
import com.csot.recruit.model.position.RequireInforCriteria;
import com.csot.recruit.service.impl.flow.websitePost.PostWebsiteServiceImpl;
import com.csot.recruit.service.position.DistributeService;
import com.csot.recruit.service.position.RecruitPositionService;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Service("recruitPositionService")
@Transactional
public class RecruitPositionServiceImpl implements RecruitPositionService {
  private static final Logger logger = LoggerFactory.getLogger(RecruitPositionServiceImpl.class);

  @Resource
  private CommonService commonService;

  @Resource
  private RecruitPositionMapper recruitPositionMapper;
  @Resource
  private DepartmentRequireMapper departmentRequireMapper;
  @Resource
  private RequireInforMapper requireInforMapper;
  @Resource
  private PositionManaMapper positionManaMapper;
  @Resource
  private RecruitFlowConfigMapper precruitFlowConfigMapper;
  @Resource
  private RecruitInforMapper recruitInforMapper;
  @Resource
  private DistributeService distributeService;
  @Resource
  private DistributeMapper distributeMapper;
  @Resource
  private BaseUserMapper baseUserMapper;
  @Resource
  private PostWebsiteMapper postWebsiteMapper;
  @Resource
  private PostWebsiteInstructMapper postWebsiteInstructMapper;
  @Resource
  private RecruitDemandMapper recruitDemandMapper;

  @Override
  public MiniRtn2Grid<RecruitPosition> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<RecruitPosition> grid = new MiniRtn2Grid<RecruitPosition>();
    RecruitPositionCriteria criteria = new RecruitPositionCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andRecruitPositionIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RecruitPositionColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(recruitPositionMapper.selectByExample(criteria));
    grid.setTotal(recruitPositionMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public RecruitPosition getByPrimaryKey(String primaryKey) {
    return recruitPositionMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(RecruitPosition recruitPosition) throws ParseException {
    // recruitPosition.setStatus(PositionStatus.PUBLISHING.tag); // 设置为发布中状态
    recruitPosition.setReleaseDate(new Date());
    recruitPositionMapper.insert(recruitPosition);
    String positionId = recruitPosition.getRecruitPositionId();

    // 生成职位需求信息
    RequireInfor requireInfor = recruitPosition.getRequireInfor();
    requireInfor.setRecruitPositionId(positionId);
    requireInfor.setCreateDate(new Date());
    requireInforMapper.insert(requireInfor);

    // 生成部门需求信息
    DepartmentRequire departmentRequire = recruitPosition.getDepartmentRequire();
    departmentRequire.setRecruitPositionId(positionId);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    departmentRequire.setEffectiveDate(df.parse(departmentRequire.getEffectDate()));
    departmentRequire.setExpectDate(df.parse(departmentRequire.getExpecDate()));
    departmentRequireMapper.insert(departmentRequire);

    // 生成招聘流程角色设置信息
    RecruitInfor recruitInfor = recruitPosition.getRecruitInfor();
    recruitInfor.setRecruitPositionId(positionId);
    recruitInforMapper.insert(recruitInfor);
  }

  @Override
  public void create2(RecruitPosition recruitPosition, Map<String, String> colMap)
      throws ParseException {
    // recruitPosition.setStatus(PositionStatus.PUBLISHING.tag); // 设置为发布中状态
    recruitPosition.setReleaseDate(new Date());
    recruitPositionMapper.insert(recruitPosition);


    // 发布指令功能
    RecruitDemand recruitDemand = recruitDemandMapper.selectByPrimaryKey(colMap.get("demandId"));

    PostWebsiteCriteria criteria = new PostWebsiteCriteria();
    String websiteTypeStr = recruitPosition.getTrench(); // 发布渠道
    String content = recruitPosition.getPositionDescription(); // 岗位描述
    String content2 = recruitPosition.getPositionDescription2(); // 岗位描述
    // 岗位名称名称+(code)
    String webPostName =
        recruitPosition.getWebsitePostName() + "(" + recruitPosition.getPositionCode() + ")";
    List<String> websiteTypeList = new ArrayList<String>(); // 发布渠道集合
    if (StringUtil.isNotEmpty(websiteTypeStr)) {
      String[] websiteTypes = websiteTypeStr.split(",");
      for (String item : websiteTypes) {
        websiteTypeList.add(item);
      }
    }
    // 根据岗位编码查询网站岗位发布信息
    if (StringUtils.hasText(recruitPosition.getPositionCode())) {
      criteria.createCriteria().andPostIdEqualTo(recruitPosition.getPositionCode());
    }
    List<PostWebsiteWithBLOBs> selectByExample =
        postWebsiteMapper.selectByExampleWithBLOBs(criteria);
    List<PostWebsiteInstruct> postWebsiteInstructs = new ArrayList<PostWebsiteInstruct>();
    List<String> needDeleteType = new ArrayList<String>();
    // 获取该职位现有岗位发布信息
    for (PostWebsiteWithBLOBs postWebsite : selectByExample) {
      String websiteType = postWebsite.getWebsiteType(); // 渠道
      // 初始化指令对象 star
      PostWebsiteInstruct record = new PostWebsiteInstruct();
      record.setId(UUID.randomUUID().toString().replace("-", ""));
      record.setIsDeal(PostWebsiteInstruct.isDeal.NO.getValueStr());
      record.setCreateDate(new Date());
      record.setCreatorId(colMap.get("sysUserId"));
      record.setDeputyId(recruitDemand.getDeputyId());
      record.setDeputyName(recruitDemand.getDeputyName());
      record.setPostId(recruitDemand.getApplyPostId());
      record.setPostName(recruitDemand.getApplyPostName());
      record.setPostWebsiteId(postWebsite.getId()); // 已有网站岗位发布id
      record.setRecruitPositionId(recruitPosition.getRecruitPositionId());
      record.setWebsitePostName(webPostName);
      record.setWebsiteType(websiteType);
      // 初始化指令对象 end
      if (websiteTypeList.contains(postWebsite.getWebsiteType())) {// 当前渠道勾选
        if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {// 当前状态是发布中
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.CXFB.getValueStr());
            postWebsiteInstructs.add(record);
            needDeleteType.add(websiteType);
          }else{
            if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) { // 修改指令
              record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
              record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
              record.setInstructType(PostWebsiteInstruct.instructType.XG.getValueStr());
              postWebsiteInstructs.add(record);
              needDeleteType.add(websiteType);
            }
          }
        } else { // 当前状态是暂停
          if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) {// 修改指令
            record.setBeforeState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.XG.getValueStr());
            needDeleteType.add(websiteType);
          } else { // 重启指令
            record.setBeforeState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.CQ.getValueStr());
            needDeleteType.add(websiteType);
          }
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            record.setInstructType(PostWebsiteInstruct.instructType.CXFB.getValueStr());
          }
          postWebsiteInstructs.add(record);
        }
      } else { // 当前渠道未勾选
        if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除
          record.setBeforeState(postWebsite.getState());
          record.setAfterState(PostWebsiteInstruct.state.SC.getValueStr());
          record.setInstructType(PostWebsiteInstruct.instructType.SC.getValueStr());
          postWebsiteInstructs.add(record);
          needDeleteType.add(websiteType);
        }else{
          if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {// 当前状态是发布中
            // 暂停指令
            record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.ZT.getValueStr());
            postWebsiteInstructs.add(record);
            needDeleteType.add(websiteType);
          }
        }
      }
      // 移除已处理的发布渠道
      websiteTypeList.remove(postWebsite.getWebsiteType());
    }
    int fabuNum = 0; // 需要发布的需求个数
    // 存留的发布渠道为未发布的渠道
    for (String websiteType : websiteTypeList) {
      fabuNum++;
      // 初始化指令对象 star
      PostWebsiteInstruct record = new PostWebsiteInstruct();
      record.setIsDeal(PostWebsiteInstruct.isDeal.NO.getValueStr());
      record.setCreateDate(new Date());
      record.setCreatorId(colMap.get("sysUserId"));
      record.setDeputyId(recruitDemand.getDeputyId());
      record.setDeputyName(recruitDemand.getDeputyName());
      record.setPostId(recruitDemand.getApplyPostId());
      record.setPostName(recruitDemand.getApplyPostName());
      record.setRecruitPositionId(recruitPosition.getRecruitPositionId());
      record.setWebsitePostName(webPostName);
      // 初始化指令对象 end
      // 发布指令
      record.setPostWebsiteId(""); // 已有网站岗位发布id
      record.setId(UUID.randomUUID().toString().replace("-", ""));
      record.setBeforeState(PostWebsiteInstruct.state.WFB.getValueStr());
      record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
      record.setInstructType(PostWebsiteInstruct.instructType.FB.getValueStr());
      record.setWebsiteType(websiteType);
      postWebsiteInstructs.add(record);
      needDeleteType.add(websiteType);
      // postWebsiteInstructMapper.insert(record);
    }
    // 清除当前指令
    PostWebsiteInstructCriteria example11 = new PostWebsiteInstructCriteria();
    if (needDeleteType.size() > 0) {
      example11.or().andPostIdEqualTo(recruitDemand.getApplyPostId())
          .andWebsiteTypeIn(needDeleteType);
    }
    example11.or().andPostIdEqualTo(recruitDemand.getApplyPostId())
        .andInstructTypeEqualTo(PostWebsiteInstruct.instructType.FB.getValueStr())
        .andIsDealEqualTo(PostWebsiteInstruct.isDeal.NO.getValueStr());
    postWebsiteInstructMapper.deleteByExample(example11);
    // 添加指令
    for (PostWebsiteInstruct postWebsiteInstructItem : postWebsiteInstructs) {
      postWebsiteInstructMapper.insert(postWebsiteInstructItem);
    }
    PostWebsiteCriteria posetWebsiteExample = new PostWebsiteCriteria();
    posetWebsiteExample.createCriteria().andPostIdEqualTo(recruitDemand.getApplyPostId());
    int countByExample = postWebsiteMapper.countByExample(posetWebsiteExample);
    // 没有任何发布结果 对招聘需求的招聘状态进行处理
    if (countByExample <= 0) {
      // 暂未发布
      if (fabuNum == needDeleteType.size()) {
        // 全部是发布需求功能
        RecruitDemand recruitDemandUpdate = new RecruitDemand();
        recruitDemandUpdate.setInfoState(RecruitDemand.infoState.ANNOUNCED.getValueStr()); // 修改为待发布状态
        RecruitDemandCriteria recruitDemandExample = new RecruitDemandCriteria();
        recruitDemandExample.createCriteria().andApplyPostIdEqualTo(recruitDemand.getApplyPostId());
        recruitDemandMapper.updateByExampleSelective(recruitDemandUpdate, recruitDemandExample);
      }
      if (fabuNum == 0) {
        // 返回草稿状态
        RecruitDemand recruitDemandUpdate = new RecruitDemand();
        recruitDemandUpdate.setInfoState(RecruitDemand.infoState.DRAFT.getValueStr()); // 修改为待发布状态
        RecruitDemandCriteria recruitDemandExample = new RecruitDemandCriteria();
        recruitDemandExample.createCriteria().andApplyPostIdEqualTo(recruitDemand.getApplyPostId());
        recruitDemandMapper.updateByExampleSelective(recruitDemandUpdate, recruitDemandExample);
      }
    }

  }

  @Override
  public void updateSelective(RecruitPosition recruitPosition, Map<String, String> colMap) {
    // 修改岗位信息
    recruitPositionMapper.updateByPrimaryKeySelective(recruitPosition);
    // 发布指令功能
    RecruitDemand recruitDemand = recruitDemandMapper.selectByPrimaryKey(colMap.get("demandId"));
    PostWebsiteCriteria criteria = new PostWebsiteCriteria();
    String websiteTypeStr = recruitPosition.getTrench(); // 发布渠道
    String content = recruitPosition.getPositionDescription(); // 岗位描述
    String content2 = recruitPosition.getPositionDescription2(); // 岗位描述
    // 岗位名称名称+(code)
    String webPostName =
        recruitPosition.getWebsitePostName() + "(" + recruitPosition.getPositionCode() + ")";
    List<String> websiteTypeList = new ArrayList<String>(); // 发布渠道集合
    if (StringUtil.isNotEmpty(websiteTypeStr)) {
      String[] websiteTypes = websiteTypeStr.split(",");
      for (String item : websiteTypes) {
        websiteTypeList.add(item);
      }
    }
    // 根据岗位编码查询网站岗位发布信息
    if (StringUtils.hasText(recruitPosition.getPositionCode())) {
      criteria.createCriteria().andPostIdEqualTo(recruitPosition.getPositionCode());
    }
    List<PostWebsiteWithBLOBs> selectByExample =
        postWebsiteMapper.selectByExampleWithBLOBs(criteria);
    List<PostWebsiteInstruct> postWebsiteInstructs = new ArrayList<PostWebsiteInstruct>();
    List<String> needDeleteType = new ArrayList<String>();
    // 获取该职位现有岗位发布信息
    for (PostWebsiteWithBLOBs postWebsite : selectByExample) {
      String websiteType = postWebsite.getWebsiteType(); // 渠道
      // 初始化指令对象 star
      PostWebsiteInstruct record = new PostWebsiteInstruct();
      record.setId(UUID.randomUUID().toString().replace("-", ""));
      record.setIsDeal(PostWebsiteInstruct.isDeal.NO.getValueStr());
      record.setCreateDate(new Date());
      record.setCreatorId(colMap.get("sysUserId"));
      record.setDeputyId(recruitDemand.getDeputyId());
      record.setDeputyName(recruitDemand.getDeputyName());
      record.setPostId(recruitDemand.getApplyPostId());
      record.setPostName(recruitDemand.getApplyPostName());
      record.setPostWebsiteId(postWebsite.getId()); // 已有网站岗位发布id
      record.setRecruitPositionId(recruitPosition.getRecruitPositionId());
      record.setWebsitePostName(webPostName);
      record.setWebsiteType(websiteType);
      // 初始化指令对象 end
      if (websiteTypeList.contains(postWebsite.getWebsiteType())) {// 当前渠道勾选
        if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {// 当前状态是发布中
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.CXFB.getValueStr());
            postWebsiteInstructs.add(record);
            needDeleteType.add(websiteType);
          }else{
            if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) { // 修改指令
              record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
              record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
              record.setInstructType(PostWebsiteInstruct.instructType.XG.getValueStr());
              postWebsiteInstructs.add(record);
              needDeleteType.add(websiteType);
            }
          }
        } else { // 当前状态是暂停
          if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) {// 修改指令
            record.setBeforeState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.XG.getValueStr());
            needDeleteType.add(websiteType);
          } else { // 重启指令
            record.setBeforeState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.CQ.getValueStr());
            needDeleteType.add(websiteType);
          }
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            record.setInstructType(PostWebsiteInstruct.instructType.CXFB.getValueStr());
          }
          postWebsiteInstructs.add(record);
        }
      } else { // 当前渠道未勾选
        if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除
          record.setBeforeState(postWebsite.getState());
          record.setAfterState(PostWebsiteInstruct.state.SC.getValueStr());
          record.setInstructType(PostWebsiteInstruct.instructType.SC.getValueStr());
          postWebsiteInstructs.add(record);
          needDeleteType.add(websiteType);
        }else{
          if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {// 当前状态是发布中
            // 暂停指令
            record.setBeforeState(PostWebsiteInstruct.state.FBZ.getValueStr());
            record.setAfterState(PostWebsiteInstruct.state.ZT.getValueStr());
            record.setInstructType(PostWebsiteInstruct.instructType.ZT.getValueStr());
            postWebsiteInstructs.add(record);
            needDeleteType.add(websiteType);
          }
        }
      }
      // 移除已处理的发布渠道
      websiteTypeList.remove(postWebsite.getWebsiteType());
    }
    int fabuNum = 0; // 需要发布的需求个数
    // 存留的发布渠道为未发布的渠道
    for (String websiteType : websiteTypeList) {
      fabuNum++;
      // 初始化指令对象 star
      PostWebsiteInstruct record = new PostWebsiteInstruct();
      record.setIsDeal(PostWebsiteInstruct.isDeal.NO.getValueStr());
      record.setCreateDate(new Date());
      record.setCreatorId(colMap.get("sysUserId"));
      record.setDeputyId(recruitDemand.getDeputyId());
      record.setDeputyName(recruitDemand.getDeputyName());
      record.setPostId(recruitDemand.getApplyPostId());
      record.setPostName(recruitDemand.getApplyPostName());
      record.setRecruitPositionId(recruitPosition.getRecruitPositionId());
      record.setWebsitePostName(webPostName);
      record.setPostWebsiteId(""); // 已有网站岗位发布id
      // 初始化指令对象 end
      // 发布指令
      record.setId(UUID.randomUUID().toString().replace("-", ""));
      record.setBeforeState(PostWebsiteInstruct.state.WFB.getValueStr());
      record.setAfterState(PostWebsiteInstruct.state.FBZ.getValueStr());
      record.setInstructType(PostWebsiteInstruct.instructType.FB.getValueStr());
      record.setWebsiteType(websiteType);
      postWebsiteInstructs.add(record);
      needDeleteType.add(websiteType);
      // postWebsiteInstructMapper.insert(record);
    }
    // 清除当前指令
    PostWebsiteInstructCriteria example11 = new PostWebsiteInstructCriteria();
    if (needDeleteType.size() > 0) {
      example11.or().andPostIdEqualTo(recruitDemand.getApplyPostId())
          .andWebsiteTypeIn(needDeleteType);
    }
    example11.or().andPostIdEqualTo(recruitDemand.getApplyPostId())
        .andInstructTypeEqualTo(PostWebsiteInstruct.instructType.FB.getValueStr())
        .andIsDealEqualTo(PostWebsiteInstruct.isDeal.NO.getValueStr());
    postWebsiteInstructMapper.deleteByExample(example11);
    // 添加指令
    for (PostWebsiteInstruct postWebsiteInstructItem : postWebsiteInstructs) {
      postWebsiteInstructMapper.insert(postWebsiteInstructItem);
    }
    PostWebsiteCriteria posetWebsiteExample = new PostWebsiteCriteria();
    posetWebsiteExample.createCriteria().andPostIdEqualTo(recruitDemand.getApplyPostId());
    int countByExample = postWebsiteMapper.countByExample(posetWebsiteExample);
    // 没有任何发布结果 对招聘需求的招聘状态进行处理
    if (countByExample <= 0) {
      // 暂未发布
      if (fabuNum == needDeleteType.size()) {
        // 全部是发布需求功能
        RecruitDemand recruitDemandUpdate = new RecruitDemand();
        recruitDemandUpdate.setInfoState(RecruitDemand.infoState.ANNOUNCED.getValueStr()); // 修改为待发布状态
        RecruitDemandCriteria recruitDemandExample = new RecruitDemandCriteria();
        recruitDemandExample.createCriteria().andApplyPostIdEqualTo(recruitDemand.getApplyPostId());
        recruitDemandMapper.updateByExampleSelective(recruitDemandUpdate, recruitDemandExample);
      }
      if (fabuNum == 0) {
        // 返回草稿状态
        RecruitDemand recruitDemandUpdate = new RecruitDemand();
        recruitDemandUpdate.setInfoState(RecruitDemand.infoState.DRAFT.getValueStr()); // 修改为待发布状态
        RecruitDemandCriteria recruitDemandExample = new RecruitDemandCriteria();
        recruitDemandExample.createCriteria().andApplyPostIdEqualTo(recruitDemand.getApplyPostId());
        recruitDemandMapper.updateByExampleSelective(recruitDemandUpdate, recruitDemandExample);
      }
    }
  }

  @Override
  public void remove(String primaryKey) {
    recruitPositionMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void createRecruitPosition(RecruitPosition recruitPosition,
      DepartmentRequire departmentRequire, RequireInfor requireInfor) {
    if (null != recruitPosition && null != departmentRequire && null != requireInfor) {
      recruitPositionMapper.insertSelective(recruitPosition);
      departmentRequireMapper.insertSelective(departmentRequire);
      requireInforMapper.insertSelective(requireInfor);
    }

  }

  /**
   * 根据职位id查询职位详细信息，用于职位分发
   * 
   * @param recruitPositionId
   * @return
   */
  public PositionMana queryPositionManaForDistribute(String recruitPositionId) {
    PositionMana pm = new PositionMana();
    pm.setRecruitPositionId(recruitPositionId);
    List<PositionMana> list = positionManaMapper.queryPositionManaList(pm);
    if (null != list && list.size() > 0) {
      pm = list.get(0);
      pm.setPositionType(DatadictGroup.getTypeNameByTypeId(pm.getPositionType()));
      pm.setRecruitType(getDatadictGroupType(pm.getRecruitType()));
      pm.setPositionLevel(DatadictGroup.getTypeNameByTypeId(pm.getPositionLevel()));
      pm.setValidaty(DatadictGroup.getTypeNameByTypeId(pm.getValidaty()));
      pm.setSalary(DatadictGroup.getTypeNameByTypeId(pm.getSalary()));
      String s[] = pm.getSalary().split("-");
      if (s.length == 1) {
        pm.setSalaryMin("0");
        pm.setSalaryMax("0");
      } else if (s.length > 1) {
        if ("以下".equals(s[1])) {
          pm.setSalaryMin("0");
          pm.setSalaryMax(s[0]);
        } else if ("以上".equals(s[1])) {
          pm.setSalaryMin(s[0]);
          pm.setSalaryMax("1000000");
        } else {
          pm.setSalaryMin(s[0]);
          pm.setSalaryMax(s[1]);
        }
      }
      if (0 == pm.getAgeMin() || null == pm.getAgeMin()) {
        pm.setAgeMin(18);
      }
      if (0 == pm.getAgeMax() || null == pm.getAgeMax()) {
        pm.setAgeMax(70);
      }
      if (0 == pm.getWorkExperienceMax() || null == pm.getWorkExperienceMax()) {
        pm.setWorkExperienceMax(50);
      }
      pm.setRecruitObject(DatadictGroup.getTypeCodeByTypeId(pm.getRecruitObject()));
      pm.setEducationMin(DatadictGroup.getTypeCodeByTypeId(pm.getEducationMin()));
      pm.setEducationMax(DatadictGroup.getTypeCodeByTypeId(pm.getEducationMax()));
      pm.setWorkPlace(DatadictGroup.getTypeCodeByTypeId(pm.getWorkPlace()));
      pm.setEnglishLevel(DatadictGroup.getTypeCodeByTypeId(pm.getEnglishLevel()));
      pm.setPositionIndustry(DatadictGroup.getTypeNameByTypeId(pm.getPositionIndustry()));
      pm.setReceiveEmail(DatadictGroup.getTypeNameByTypeId(pm.getReceiveEmail()));
      pm.setDemandType(DatadictGroup.getTypeNameByTypeId(pm.getDemandType()));
      pm.setStatus(DatadictGroup.getTypeNameByTypeId(pm.getStatus()));
      pm.setSecrecy(DatadictGroup.getTypeNameByTypeId(pm.getSecrecy()));
      return pm;
    } else {
      return null;
    }
  }


  public List<PositionMana> queryPositionMana(PositionMana positionMana) {
    /*
     * if (StringUtil.isEmpty(positionMana.getStatus())) { positionMana.setStatus("011-002"); //
     * 默认发布中的职位 }
     */
    List<PositionMana> list = positionManaMapper.queryPositionManaList(positionMana);
    for (PositionMana pm : list) {
      pm.setPositionType(DatadictGroup.getTypeNameByTypeId(pm.getPositionType()));
      pm.setRecruitObject(getDatadictGroupType(pm.getRecruitObject()));
      pm.setRecruitType(getDatadictGroupType(pm.getRecruitType()));
      pm.setPositionLevel(DatadictGroup.getTypeNameByTypeCode(pm.getPositionLevel(),Constant.RANK_RECRUIT_DEMAND));
      pm.setValidaty(DatadictGroup.getTypeNameByTypeId(pm.getValidaty()));
      pm.setSalary(DatadictGroup.getTypeNameByTypeId(pm.getSalary()));
      pm.setWorkPlace(DatadictGroup.getTypeNameByTypeId(pm.getWorkPlace()));
      pm.setEnglishLevel(DatadictGroup.getTypeNameByTypeId(pm.getEnglishLevel()));
      pm.setEducationMin(DatadictGroup.getTypeNameByTypeId(pm.getEducationMin()));
      pm.setEducationMax(DatadictGroup.getTypeNameByTypeId(pm.getEducationMax()));
      pm.setPositionIndustry(DatadictGroup.getTypeNameByTypeId(pm.getPositionIndustry()));
      pm.setReceiveEmail(DatadictGroup.getTypeNameByTypeId(pm.getReceiveEmail()));
      pm.setDemandType(DatadictGroup.getTypeNameByTypeId(pm.getDemandType()));
      pm.setStatus(DatadictGroup.getTypeNameByTypeId(pm.getStatus()));
      pm.setSecrecy(DatadictGroup.getTypeNameByTypeId(pm.getSecrecy()));
    }
    return list;
  }

  @Override
  public MiniRtn2Grid<PositionMana> queryPositionManaList(PositionMana positionMana) {
    MiniRtn2Grid<PositionMana> miniGrid = new MiniRtn2Grid<PositionMana>();
    List<PositionMana> list = queryPositionMana(positionMana);
    miniGrid.setData(list);
    return miniGrid;
  }

  @Override
  public RecruitPosition queryPositionByPostId(String postId) {
    RecruitPosition recruitPosition = new RecruitPosition();
    RecruitPositionCriteria example = new RecruitPositionCriteria();
    example.createCriteria().andPositionCodeEqualTo(postId);
    List<RecruitPosition> list = recruitPositionMapper.selectByExample(example);
    if (list != null && list.size() > 0) {
      return list.get(0);
    }
    return recruitPosition;
  }

  @Override
  public MiniRtn2Grid<PositionMana> queryPositionManaListByPage(MiniGridPageSort pageSort,
      PositionMana positionMana) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("recruitPositionId", positionMana.getRecruitPositionId());
    map.put("positionName", positionMana.getPositionName());
    map.put("publisher", positionMana.getPublisher());
    map.put("recruiter", positionMana.getRecruiter());
    map.put("label", positionMana.getLabel());
    map.put("startDistributeDate", positionMana.getStartDistributeDate());
    map.put("endDistributeDate", positionMana.getEndDistributeDate());
    map.put("department", positionMana.getDepartment());
    map.put("positionCode", positionMana.getPositionCode());
    map.put("departmentCode", positionMana.getDepartmentCode());
    map.put("status", positionMana.getStatus());
    map.put("workPlace", positionMana.getWorkPlace());
    map.put("startExpireDate", positionMana.getStartExpireDate());
    map.put("endExpireDate", positionMana.getEndExpireDate());
    map.put("recruitType", positionMana.getRecruitType());
    map.put("positionType", positionMana.getPositionType());
    map.put("positionLevel", positionMana.getPositionLevel());
    map.put("recruitPersonOther", positionMana.getRecruitPersonOther());
    map.put("recruitObject", positionMana.getRecruitObject());
    map.put("positionSimilar", positionMana.getPositionSimilar());
    map.put("salary", positionMana.getSalary());
    map.put("validaty", positionMana.getValidaty());
    map.put("positionIndustry", positionMana.getPositionIndustry());
    map.put("demandType", positionMana.getDemandType());
    map.put("ageMin", positionMana.getAgeMin());
    map.put("ageMax", positionMana.getAgeMax());
    map.put("workExperienceMin", positionMana.getWorkExperienceMin());
    map.put("workExperienceMax", positionMana.getWorkExperienceMax());
    map.put("englishLevel", positionMana.getEnglishLevel());
    map.put("educationMin", positionMana.getEducationMin());
    map.put("educationMax", positionMana.getEducationMax());
    map.put("gender", positionMana.getGender());
    map.put("positionDescription", positionMana.getPositionDescription());
    map.put("pageSize", pageSort.getPageSize());
    map.put("pageIndex", pageSort.getPageIndex());
    map.put("sortField", pageSort.getSortField());
    map.put("sortOrder", pageSort.getSortOrder());
    MiniRtn2Grid<PositionMana> miniGrid = new MiniRtn2Grid<PositionMana>();
    List<PositionMana> list = positionManaMapper.queryPositionManaListByPage(map);
    for (PositionMana pm : list) {
      pm.setPositionType(DatadictGroup.getTypeNameByTypeId(pm.getPositionType()));
      pm.setRecruitObject(getDatadictGroupType(pm.getRecruitObject()));
      pm.setRecruitType(getDatadictGroupType(pm.getRecruitType()));
      pm.setPositionLevel(DatadictGroup.getTypeNameByTypeId(pm.getPositionLevel()));
      pm.setValidaty(DatadictGroup.getTypeNameByTypeId(pm.getValidaty()));
      pm.setSalary(DatadictGroup.getTypeNameByTypeId(pm.getSalary()));
      pm.setWorkPlace(DatadictGroup.getTypeNameByTypeId(pm.getWorkPlace()));
      pm.setEnglishLevel(DatadictGroup.getTypeNameByTypeId(pm.getEnglishLevel()));
      pm.setEducationMin(DatadictGroup.getTypeNameByTypeId(pm.getEducationMin()));
      pm.setEducationMax(DatadictGroup.getTypeNameByTypeId(pm.getEducationMax()));
      pm.setPositionIndustry(DatadictGroup.getTypeNameByTypeId(pm.getPositionIndustry()));
      pm.setReceiveEmail(DatadictGroup.getTypeNameByTypeId(pm.getReceiveEmail()));
      pm.setDemandType(DatadictGroup.getTypeNameByTypeId(pm.getDemandType()));
      pm.setStatus(DatadictGroup.getTypeNameByTypeId(pm.getStatus()));
      pm.setSecrecy(DatadictGroup.getTypeNameByTypeId(pm.getSecrecy()));
      pm.setGender(DatadictGroup.getTypeNameByTypeId(pm.getGender()));
    }
    miniGrid.setData(list);
    miniGrid.setTotal(positionManaMapper.countPositionMana(positionMana));
    return miniGrid;
  }

  /**
   * 获取Id和名字
   * 
   * @return
   */
  @Override
  public Map<String, Object> getIdName() {
    List<BaseUser> baseUserList = baseUserMapper.getAllUser();
    Map<String, Object> map = new HashMap<String, Object>();
    if (baseUserList != null && baseUserList.size() > 0) {
      for (BaseUser baseUser : baseUserList) {
        if (baseUser != null) {
          map.put(baseUser.getId(), baseUser.getName());
        }
      }
      if (map != null && map.size() > 0) {
        return map;
      }
    }
    return null;
  }

  /*
	 * 
	 */
  public String getDatadictGroupType(String str) {
    String recruitObject = "";
    if (str != null) {
      String[] arr = str.split(",");
      for (String s : arr) {
        recruitObject += DatadictGroup.getTypeNameByTypeId(s) + ",";
      }
      if (recruitObject != null && recruitObject.length() > 0) {
        recruitObject = recruitObject.substring(0, recruitObject.length() - 1);
      }
    }
    return recruitObject;
  }

  @Override
  public String getPosiCode() {
    String code = recruitPositionMapper.maxPosiCode();
    if (StringUtil.isNotEmpty(code)) {
      int code_i = Integer.parseInt(code);
      code = numToString(++code_i, 6); // 如:000xxx
    } else {
      code = "000001";
    }
    return code;
  }

  /**
   * 将数字转换为指定长度的字符串，不足长度前面补0，否则截取
   * 
   * @param num
   * @param length
   * @return
   */
  public String numToString(int num, int length) {
    String s = String.valueOf(num);
    int len = length - s.length();
    String ss = "";
    if (len > 0) {
      for (int i = 0; i < len; i++) {
        ss += "0";
      }
      return ss += s;
    } else {
      return s.substring(0, length - 1);
    }
  }

  @Override
  public MiniRtn2Grid<PositionDistributeRecords> queryPositionDistributeListByPage(
      MiniGridPageSort pageSort, PositionDistributeRecords positionDistribute) {
    MiniRtn2Grid<PositionDistributeRecords> miniGrid =
        new MiniRtn2Grid<PositionDistributeRecords>();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("department", positionDistribute.getDepartment());
    map.put("publisher", positionDistribute.getPublisher());
    map.put("publishSite", positionDistribute.getPublishSite());
    map.put("publishResult", positionDistribute.getPublishResult());
    map.put("positionName", positionDistribute.getPositionName());
    map.put("startDistributeDate", positionDistribute.getStartDistributeDate());
    map.put("endDistributeDate", positionDistribute.getEndDistributeDate());
    map.put("startExpireDate", positionDistribute.getStartExpireDate());
    map.put("endExpireDate", positionDistribute.getEndExpireDate());
    map.put("pageSize", pageSort.getPageSize());
    map.put("pageIndex", pageSort.getPageIndex());
    map.put("sortField", pageSort.getSortField());
    map.put("sortOrder", pageSort.getSortOrder());
    List<PositionDistributeRecords> prs = positionManaMapper.queryPositionDistributeListByPage(map);
    for (PositionDistributeRecords pr : prs) {
      pr.setWorkPlace(DatadictGroup.getTypeNameByTypeId(pr.getWorkPlace()));
    }
    miniGrid.setData(prs);
    miniGrid.setTotal(positionManaMapper.countPositionDistribute(positionDistribute));
    return miniGrid;
  }

  @Override
  public void removeByPositionId(String positionId) {
    String[] recruitPositionIds = positionId.split(",");
    for (int i = 0; i < recruitPositionIds.length; i++) {
      DepartmentRequireCriteria criteria = new DepartmentRequireCriteria();
      criteria.createCriteria().andRecruitPositionIdEqualTo(recruitPositionIds[i]);
      if (departmentRequireMapper.countByExample(criteria) > 0) {
        // 删除职位id对应的部门
        departmentRequireMapper.deleteByExample(criteria);
      }
      DistributeCriteria distributeCriteria = new DistributeCriteria();
      distributeCriteria.createCriteria().andRecruitPositionIdEqualTo(recruitPositionIds[i]);
      if (distributeMapper.countByExample(distributeCriteria) > 0) {
        // 删除职位id对应的职位分发记录
        distributeMapper.deleteByExample(distributeCriteria);
      }
      RecruitInforCriteria recruitInforCriteria = new RecruitInforCriteria();
      recruitInforCriteria.createCriteria().andRecruitPositionIdEqualTo(recruitPositionIds[i]);
      if (recruitInforMapper.countByExample(recruitInforCriteria) > 0) {
        // 删除职位的招聘信息
        recruitInforMapper.deleteByExample(recruitInforCriteria);
      }
      RequireInforCriteria requireInforCriteria = new RequireInforCriteria();
      requireInforCriteria.createCriteria().andRecruitPositionIdEqualTo(recruitPositionIds[i]);
      if (requireInforMapper.countByExample(requireInforCriteria) > 0) {
        // 删除招聘职位的基本要求
        requireInforMapper.deleteByExample(requireInforCriteria);
      }
      // 删除职位记录
      recruitPositionMapper.deleteByPrimaryKey(recruitPositionIds[i]);
    }
  }

  @Override
  public List<PositionMana> getPositionByStatus(String status) {
    return recruitPositionMapper.getPositionByStatus(status);
  }

  @Override
  public String positionDistribute(RecruitSite rs) {
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    PositionMana positionMana =
        queryPositionManaForDistribute(rs.getPosition().getRecruitPositionId());
    String publishSite = null;
    String publishUrl = null;
    String recruitSite = propertiesUtil.readProperty("recruitSite");
    String recruitSite_zh = propertiesUtil.readProperty("recruitSite_zh");
    if (StringUtil.isNotEmpty(recruitSite)) {
      String[] arra1 = recruitSite.split(",");
      String[] arra2 = recruitSite_zh.split(",");
      if (recruitSite.indexOf(rs.getSiteName()) > -1) {
        int i = Arrays.asList(arra1).indexOf(rs.getSiteName());
        publishSite = arra2[i];
        publishUrl = "www." + arra1[i] + ".com";
      } else {
        return "不支持该站点的职位分发！";
      }
    } else {
      return "站点数据不存在！";
    }
    String[] positionTypeIds = new String[] {};
    String ss = positionMana.getPositionSimilar();// position.getPositionSimilar();
    String positionStr = "";
    if (StringUtil.isNotEmpty(ss)) {
      String[] s = ss.split(":");
      positionTypeIds = s[0].split(",");
    } else {
      return "该职位没有绑定职位类别！";
    }
    for (String s : positionTypeIds) {
      positionStr += s + ",";
    }
    positionStr = positionStr.substring(0, positionStr.length() - 1);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    String postData =
        "{" + "'JobBoard':{" + "'Account':{" + "'Properties':{"
            + rs.getRsiAccountStr()
            + "},"
            + "'UserName':'"
            + rs.getUserNameInput()
            + "',"
            + "'UserPassword':'"
            + rs.getPwdInput()
            + "'"
            + "},"
            + "'Name':'"
            + rs.getUrl()
            + "',"
            + "'Properties':{"
            + rs.getRsiDistributeStr()
            + "},"
            + "'SessionId':''"
            + "},"
            + (StringUtil.isNotEmpty(rs.getCaptchaName()) ? "'Captcha':{" + "'SessionId':'"
                + rs.getCaptchaName().substring(0, rs.getCaptchaName().indexOf(".")) + "',"
                + "'Value':'" + rs.getCaptchaInput() + "'" + "}," : "")
            + "'Job':{"
            + "'ID':'"
            + positionMana.getRecruitPositionId()
            + "',"
            + "'Code':'"
            + positionMana.getPositionCode().trim()
            + "',"
            + "'Detail':{"
            + "'Title':'"
            + positionMana.getPositionName().trim()
            + "("
            + positionMana.getPositionCode()
            + ")',"
            + "'Type':"
            + positionMana.getRecruitObject()
            + ","
            + "'Position':["
            + positionStr
            + "],"
            + "'Location': "
            + positionMana.getWorkPlace()
            + ","
            + "'MonthlySalary':{"
            + "'Minimum':"
            + positionMana.getSalaryMin()
            + ","
            + "'Maximum':"
            + positionMana.getSalaryMax()
            + "},"
            + "'Description':'"
            + positionMana.getPositionDescription()
            + "',"
            + "'Age':{"
            + "'Minimum':"
            + positionMana.getAgeMin()
            + ","
            + "'Maximum':"
            + positionMana.getAgeMax()
            + "},"
            + "'YearsOfExperience':{"
            + "'Minimum':"
            + positionMana.getWorkExperienceMin()
            + ","
            + "'Maximum':"
            + positionMana.getWorkExperienceMax()
            + "},"
            + "'Degree':"
            + (StringUtil.isNotEmpty(positionMana.getEducationMin()) ? Integer
                .parseInt(positionMana.getEducationMin()) : (StringUtil.isNotEmpty(positionMana
                .getEducationMax()) ? Integer.parseInt(positionMana.getEducationMax()) : 0))
            + ","
            + "'EnglishLevel':"
            + (StringUtil.isNotEmpty(positionMana.getEnglishLevel()) ? Integer
                .parseInt(positionMana.getEnglishLevel()) : "") + "," + "'CustomDatas':{"

            + "}" + "}," + "'Employer':{" + "'Website':'http://www.szcsot.com',"
            + "'CompanyName':'深圳市华星光电技术有限公司'," + "'CompanyType':6" + "}," + "'NumberOfOpenings':"
            + positionMana.getRecruitNumbers() + "," + "'RecruitingDepartment':'"
            + positionMana.getDepartmentName() + "'," + "'StartingDate':'"
            + sdf.format(positionMana.getReleaseDate()) + "'," + "'EndingDate':'"
            + sdf.format(positionMana.getExpireDate()) + "'," + "'PublishUrl':'" + rs.getUrl()
            + "'," + "'ResumeReceiveEmail':'" + positionMana.getReceiveEmail()
            + "',"
            + "'Industry':5," // 电子,微电子
            + "'Recruiter':'" + positionMana.getRecruiterName() + "'" + "}," + "'JobFunctionId':''"
            + "}";
    String result = commonService.psotJob(postData, publishUrl);
    BaseUser user = commonService.loginUser();
    Distribute distribute = new Distribute();
    distribute.setPublishSite(publishSite);
    distribute.setPublishUrl(publishUrl);
    distribute.setDistributeDate(new Date());
    distribute.setRecruitPositionId(positionMana.getRecruitPositionId());
    distribute.setPublisher(user.getId());
    if (!"true".equals(result)) {
      distribute.setErrorMessage(result);
      distribute.setResult(OperateResult.FAILED.getValue());
    } else {
      distribute.setResult(OperateResult.SUCCESS.getValue());
    }
    /*
     * DistributeCriteria criteria = new DistributeCriteria();
     * criteria.createCriteria().andRecruitPositionIdEqualTo(positionMana.getRecruitPositionId());
     * List<Distribute> list = distributeService.getByExample(criteria); if(list.size() > 0) { //
     * 判断该职位是否已分发，如果是已分发并且分发网站相同则修改 // 如果分发网站相同则修改
     * if(distribute.getPublishUrl().trim().equals(list.get(0).getPublishUrl().trim())){
     * distributeService.updateSelective(distribute); } else { distributeService.create(distribute);
     * } } else { distributeService.create(distribute); }
     */
    distributeService.create(distribute);
    return result;
  }

  @Override
  public void updateSelective(RecruitPosition recruitPosition) {
    // 修改岗位信息
    recruitPositionMapper.updateByPrimaryKeySelective(recruitPosition);
    RequireInfor requireInfor = recruitPosition.getRequireInfor();
    // 修改职位需求信息
    RequireInforCriteria example = new RequireInforCriteria();
    example.createCriteria().andRecruitPositionIdEqualTo(recruitPosition.getRecruitPositionId());
    requireInforMapper.updateByExampleSelective(requireInfor, example);
    // 修改部门需求信息
    DepartmentRequire departmentRequire = recruitPosition.getDepartmentRequire();
    DepartmentRequireCriteria example2 = new DepartmentRequireCriteria();
    example2.createCriteria().andRecruitPositionIdEqualTo(recruitPosition.getRecruitPositionId());
    departmentRequireMapper.updateByExampleSelective(departmentRequire, example2);
  }

}
