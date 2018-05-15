package com.csot.recruit.service.impl.flow.recruitdemand;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandChangeMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandLogMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandMapper;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChange;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChangeColumns;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChangeCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLog;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandChangeService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.service.BaseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("recruitDemandChangeService")
public class RecruitDemandChangeServiceImpl implements RecruitDemandChangeService {
  private static final Logger logger = LoggerFactory
      .getLogger(RecruitDemandChangeServiceImpl.class);

  @Resource
  private RecruitDemandChangeMapper recruitDemandChangeMapper;
  @Resource
  private RecruitDemandLogMapper recruitDemandLogMapper;
  @Resource
  private RecruitDemandMapper recruitDemandMapper;
  @Resource
  private MailSendService mailSendService;
  @Resource
  private BaseUserService baseUserService;
  @Resource
  private TemplateService templateService;

  @Override
  public MiniRtn2Grid<RecruitDemandChange> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<RecruitDemandChange> grid = new MiniRtn2Grid<RecruitDemandChange>();
    RecruitDemandChangeCriteria criteria = new RecruitDemandChangeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andDemandIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RecruitDemandChangeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(recruitDemandChangeMapper.selectByExample(criteria));
    grid.setTotal(recruitDemandChangeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public RecruitDemandChange getByPrimaryKey(String primaryKey) {
    return recruitDemandChangeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public AjaxRtnJson create(RecruitDemandChange recruitDemandChange, String email) {
    Template eTemplate = new Template();
    eTemplate = templateService.getByPrimaryKey(Constant.DEMAND_CHANGE_EMAIL_TEMPLATEID);
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    String projectUrl = propertiesUtil.readProperty("projectUrl");
    recruitDemandChange.setDemandChangeUrl(projectUrl
        + "visitor/recruitDemandChangeController/toCheck/" + recruitDemandChange.getId());
    try {
      mailSendService.sendEmail(email, eTemplate, recruitDemandChange);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return new AjaxRtnJson(false, "申请失败: 邮件发送失败");
    }
    recruitDemandChangeMapper.insert(recruitDemandChange);
    AjaxRtnJson ajaxRtnJson =
        new AjaxRtnJson(true, "修改申请已发送至需求单位主管审批，审批通过后<br/>将生效，并同步抄送招聘代表直接领导。");
    ajaxRtnJson.setAttributes(new HashMap<String, Object>());
    ajaxRtnJson.setAttribute("id", recruitDemandChange.getId());
    return ajaxRtnJson;
  }

  @Override
  public void updateSelective(RecruitDemandChange recruitDemandChange) {
    recruitDemandChangeMapper.updateByPrimaryKeySelective(recruitDemandChange);
  }

  @Override
  public void remove(String primaryKey) {
    recruitDemandChangeMapper.deleteByPrimaryKey(primaryKey);
  }


  @Override
  /**
   * 获取未完成的字段修改申请
   */
  public List<RecruitDemandChange> getInfoWithNotDeal(String id, String type) {
    RecruitDemandChangeCriteria criteria = new RecruitDemandChangeCriteria();
    criteria.or().andDemandIdEqualTo(id).andIsDealEqualTo(RecruitDemandChange.isDeal.NO.valueStr())
        .andTypeEqualTo(type);
    return recruitDemandChangeMapper.selectByExample(criteria);
  }

  @Override
  /**
   * 修改审核记录详情 生成修改记录
   * 
   * @param recruitDemandChange  
   * @param baseUser 默认审批人
   */
  public void updateSelectiveSelf(RecruitDemandChange recruitDemandChange, BaseUser baseUser,
      RecruitDemand recruitDemand) {
    // 判断是否同意修改同意进行数据修改和日志记录
    if (RecruitDemandChange.isAgerr.YES.valueStr().equals(recruitDemandChange.getIsAgerr())) {
      RecruitDemandLog recruitDemandLog = new RecruitDemandLog();
      recruitDemandLog.setDemandId(recruitDemandChange.getDemandId());
      recruitDemandLog.setUpdateDate(new Date());
      recruitDemandLog.setModifiedId(baseUser.getId());
      recruitDemandLog.setModifiedName(baseUser.getAccount());
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemandChange.getNewStr());
      recruitDemandLog.setOldStr(recruitDemandChange.getOldStr());
      // 修改招聘需求对应字段
      if (RecruitDemandChange.type.APPLYNUM.valueStr().equals(recruitDemandChange.getType())) {
        // 修改申请人数
        recruitDemandLog.setUpdateField("申请人数");
        recruitDemand.setApplyPersonNumber(Integer.valueOf(recruitDemandChange.getNewStr()));

        if (recruitDemand.getApplyPersonNumber().equals(0)) {
          // 修改为0时取消需求
          recruitDemand.setIsFinish(RecruitDemand.isFinish.CANCEL.valueStr());
        } else if (recruitDemand.getApplyPersonNumber().equals(recruitDemand.getEntryNumber())) {
          // 如果修改后的人数和已经入职的人数相同 将需求变成已完成状态
          recruitDemand.setIsFinish(RecruitDemand.isFinish.FINISHED.valueStr());
        }
      }
      if (RecruitDemandChange.type.WANTCOMEDATE.valueStr().equals(recruitDemandChange.getType())) {
        // 修改期望到岗时间
        recruitDemandLog.setUpdateField("期望到岗时间");
        recruitDemand.setWantComeDate(recruitDemandChange.getNewStr());
      }
      recruitDemand.setUpdateDate(new Date());
      recruitDemand.setModifiedId(baseUser.getId());
      // 修改招聘需求的字段
      recruitDemandMapper.updateByPrimaryKeySelective(recruitDemand);
      // 生成修改记录
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    // 修改操作记录
    recruitDemandChange.setUpdateDate(new Date());
    recruitDemandChange.setIsDeal(RecruitDemandChange.isDeal.YES.valueStr()); // 设置处理完成
    // 发送催促邮件
    if (RecruitDemandChange.isAgerr.YES.valueStr().equals(recruitDemandChange.getIsAgerr())) {
      List<String> superior = recruitDemandChangeMapper.getSuperior(baseUser.getWorkCode());
      String email = StringUtil.joinString(superior, ";");
      Template eTemplate = new Template();
      eTemplate = templateService.getByPrimaryKey(Constant.DEMAND_CHANGED_EMAIL_TEMPLATEID);
      PropertiesUtil propertiesUtil = new PropertiesUtil();
      String projectUrl = propertiesUtil.readProperty("projectUrl");
      Map<String, String> colMap = new HashMap<String, String>();
      colMap.put("demandName", recruitDemand.getTheme());
      String changeVal = "";
      if (recruitDemandChange.getType().equals(RecruitDemandChange.type.APPLYNUM.valueStr())) {
        changeVal +=
            "申请人数由" + recruitDemandChange.getOldStr() + "人变更为" + recruitDemandChange.getNewStr()
                + "人";
      } else {
        changeVal +=
            "期望到岗日期由" + recruitDemandChange.getOldStr() + "变更为" + recruitDemandChange.getNewStr();
      }
      colMap.put("changeVal", changeVal);
      recruitDemandChange.setDemandChangeUrl(projectUrl
          + "visitor/recruitDemandChangeController/toCheck/" + recruitDemandChange.getId());
      try {
        mailSendService.sendEmail(email, eTemplate, colMap);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    recruitDemandChangeMapper.updateByPrimaryKeySelective(recruitDemandChange);

  }

  @Override
  public AjaxRtnJson urge(RecruitDemandChange recruitDemandChange, String email) {
    Template eTemplate = new Template();
    eTemplate = templateService.getByPrimaryKey(Constant.DEMAND_CHANGE_EMAIL_TEMPLATEID);
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    String projectUrl = propertiesUtil.readProperty("projectUrl");
    recruitDemandChange.setDemandChangeUrl(projectUrl
        + "visitor/recruitDemandChangeController/toCheck/" + recruitDemandChange.getId());
    try {
      mailSendService.sendEmail(email, eTemplate, recruitDemandChange);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return new AjaxRtnJson(false, "存在没有审批完成的申请，邮件发送失败请稍后再试！");
    }
    AjaxRtnJson ajaxRtnJson = new AjaxRtnJson(true, "存在没有审批完成的申请,已经发送催促邮件！");
    ajaxRtnJson.setAttributes(new HashMap<String, Object>());
    ajaxRtnJson.setAttribute("id", recruitDemandChange.getId());
    return ajaxRtnJson;
  }
}
