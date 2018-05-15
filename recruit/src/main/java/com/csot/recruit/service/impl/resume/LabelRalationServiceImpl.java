package com.csot.recruit.service.impl.resume;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.csot.recruit.dao.original.resume.LabelRalationMapper;
import com.csot.recruit.model.original.resume.LabelRalation;
import com.csot.recruit.model.original.resume.LabelRalationColumns;
import com.csot.recruit.model.original.resume.LabelRalationCriteria;
import com.csot.recruit.service.resume.LabelRalationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("labelRalationService")
public class LabelRalationServiceImpl implements LabelRalationService {
    private static final Logger logger = LoggerFactory.getLogger(LabelRalationServiceImpl.class);

    @Resource
    private LabelRalationMapper labelRalationMapper;

    @Override
    public MiniRtn2Grid<LabelRalation> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<LabelRalation> grid = new MiniRtn2Grid<LabelRalation>();
        LabelRalationCriteria criteria = new LabelRalationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = LabelRalationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(labelRalationMapper.selectByExample(criteria));
        grid.setTotal(labelRalationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public LabelRalation getByPrimaryKey(String primaryKey) {
        return labelRalationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(LabelRalation labelRalation) {
        labelRalationMapper.insert(labelRalation);
    }

    @Override
    public void updateSelective(LabelRalation labelRalation) {
        labelRalationMapper.updateByPrimaryKeySelective(labelRalation);
    }

    @Override
    public void remove(String primaryKey) {
        labelRalationMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public LabelRalation getByReservseId(String candidateId) {
      return labelRalationMapper.selectByReservseId(candidateId);
    }

    @Override
    public void updateTags(String candidateId, String labels,String deletes,String adds) {
      LabelRalation labelRalation = labelRalationMapper.selectByReservseId(candidateId);
      if(null != labelRalation){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("candidateId", candidateId);
        param.put("labels", labels);
        labelRalationMapper.updateTags(param);
      }else{
        labelRalation = new LabelRalation();
        labelRalation.setId(UUID.randomUUID().toString().replace("-", ""));
        labelRalation.setLabelIds(labels);
        labelRalation.setReservseId(candidateId);
        labelRalationMapper.insertSelective(labelRalation);
      }
    
      
    }
    
    @Override
    public void addTags(String candidateId, String labels,String deletes,String adds) {
      LabelRalation labelRalation = labelRalationMapper.selectByReservseId(candidateId);
      if(null != labelRalation){
      
        
        Map<String,Object> param = new HashMap<String,Object>();
        labels = labelRalation.getLabelIds()+ "," + labels;
        Set<String> set = new HashSet<String>();
        String[] labelIds = labels.split(",");
        String lastLabels ="" ;
        
        //去除重复的label
        for(String str : labelIds){
          set.add(str);
        }
        for (String item : set) {  
           lastLabels += item+",";
        }  
        if(lastLabels.endsWith(",")){
          lastLabels = lastLabels.substring(0, lastLabels.length()-1);
        }
        param.put("candidateId", candidateId);
        param.put("labels", lastLabels);
        labelRalationMapper.updateTags(param);
      }else{
        labelRalation = new LabelRalation();
        labelRalation.setId(UUID.randomUUID().toString().replace("-", ""));
        labelRalation.setLabelIds(labels);
        labelRalation.setReservseId(candidateId);
        labelRalationMapper.insertSelective(labelRalation);
      }
    
      
    }

    @Override
    public void addCandidateTagsBycid(String candidateId, String labels, String deletes, String adds) {
      LabelRalation labelRalation = labelRalationMapper.selectByReservseId(candidateId);
      if(null != labelRalation){
        labelRalation.setLabelIds(labels);
        labelRalationMapper.updateByPrimaryKeySelective(labelRalation);
      }else{
        labelRalation = new LabelRalation();
        labelRalation.setId(UUID.randomUUID().toString().replace("-", ""));
        labelRalation.setLabelIds(labels);
        labelRalation.setReservseId(candidateId);
        labelRalationMapper.insertSelective(labelRalation);
      }
    
      
    }
}