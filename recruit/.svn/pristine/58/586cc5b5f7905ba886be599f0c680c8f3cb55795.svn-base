package com.csot.recruit.service.impl.interview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csot.recruit.dao.original.interview.InterviewInfoMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.model.original.interview.InterviewInfoColumns;
import com.csot.recruit.model.original.interview.InterviewInfoCriteria;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.service.interview.InterviewInfoService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.amberframework.web.system.pojo.LoginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("interviewInfoService")
public class InterviewInfoServiceImpl implements InterviewInfoService {
    private static final Logger logger = LoggerFactory.getLogger(InterviewInfoServiceImpl.class);

    @Resource
    private InterviewInfoMapper interviewInfoMapper;
    
    @Resource
    BaseUserMapper baseUserMapper;

    @Override
    public MiniRtn2Grid<InterviewInfo> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<InterviewInfo> grid = new MiniRtn2Grid<InterviewInfo>();
        InterviewInfoCriteria criteria = new InterviewInfoCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = InterviewInfoColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(interviewInfoMapper.selectByExample(criteria));
        grid.setTotal(interviewInfoMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public InterviewInfo getByPrimaryKey(String primaryKey) {
        return interviewInfoMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(InterviewInfo interviewInfo) {
        interviewInfoMapper.insert(interviewInfo);
    }

    @Override
    public void updateSelective(InterviewInfo interviewInfo) {
        interviewInfoMapper.updateByPrimaryKeySelective(interviewInfo);
    }

    @Override
    public void remove(String primaryKey) {
        interviewInfoMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public String getUserNameByAccount(String account) {
      String res = "";
      BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
      baseUserCriteria.createCriteria().andWorkCodeEqualTo(account).andStatusEqualTo("1");
      List<BaseUser> userList = baseUserMapper.selectByExample(baseUserCriteria);
      if (userList != null && userList.size() > 0) {
        BaseUser baseUser = userList.get(0);
        res = baseUser.getName();
      }
      return res;
    }
    
    @Override
    public MiniRtn2Grid<InterviewInfo> queryInterviewListByPage(Map<String,Object> map) {
        MiniRtn2Grid<InterviewInfo> miniGrid = new MiniRtn2Grid<InterviewInfo>();
        List<InterviewInfo> list = interviewInfoMapper.queryInterviewListByPage(map);
        miniGrid.setData(list);
        miniGrid.setTotal(interviewInfoMapper.countByPage(map));
        return miniGrid;
    }
    
    @Override
    public String getPersonCode(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      String dataStr = sdf.format(new Date());
      Map<String,Object> map = new HashMap<String, Object>();
      map.put("dataStr", dataStr);
      Integer currentNum = interviewInfoMapper.searchPersonCode(map);
      if(currentNum == null || currentNum == 0){
        currentNum = 10001;
        map.put("currentNum", currentNum);
        interviewInfoMapper.addPersonCode(map);
      }else{
        currentNum += 1;
        map.put("currentNum", currentNum);
        interviewInfoMapper.updatePersonCode(map);
      }
      return dataStr + currentNum;
    }

    @Override
    public InterviewInfo getByPersonCode(String personCode) {
      // TODO Auto-generated method stub
      InterviewInfo info=interviewInfoMapper.selectByPersonCode(personCode);
      if(null != info) {
        info.setNationalityName(DatadictGroup.getTypeNameByTypeCode(info.getNationality(),"nationality"));
        info.setSexName(DatadictGroup.getTypeNameByTypeCode(info.getSex(),"sex-interview"));
        info.setCertificateTypeName(DatadictGroup.getTypeNameByTypeCode(info.getCertificateType(),"certificate-type"));
        info.setMaritalName(DatadictGroup.getTypeNameByTypeCode(info.getMaritalStatus(),"marital-status-interview"));
        info.setNationName(DatadictGroup.getTypeNameByTypeCode(info.getNation(),"nation"));
        info.setHighestEducationName(DatadictGroup.getTypeNameByTypeCode(info.getHighestEducation(),"highest-education"));
        info.setPoliticalName(DatadictGroup.getTypeNameByTypeCode(info.getPoliticalStatus(),"political-status"));
        info.setResidencePropertyName(DatadictGroup.getTypeNameByTypeCode(info.getResidenceProperty(),"residence-property"));
      }
      return info;
    }
}