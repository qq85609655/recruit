package com.csot.recruit.service.impl.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.recruit.dao.resume.LabelMapper;
import com.csot.recruit.model.resume.Label;
import com.csot.recruit.model.resume.LabelColumns;
import com.csot.recruit.model.resume.LabelCriteria;
import com.csot.recruit.service.resume.LabelService;

@Service("labelService")
public class LabelServiceImpl implements LabelService {
    private static final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Resource
    private LabelMapper labelMapper;

    @Override
    public MiniRtn2Grid<Label> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Label> grid = new MiniRtn2Grid<Label>();
        LabelCriteria criteria = new LabelCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = LabelColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(labelMapper.selectByExample(criteria));
        grid.setTotal(labelMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Label getByPrimaryKey(String primaryKey) {
        return labelMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Label label) {
        labelMapper.insert(label);
    }

    @Override
    public void updateSelective(Label label) {
        labelMapper.updateByPrimaryKeySelective(label);
    }

    @Override
    public void remove(String primaryKey) {
        labelMapper.deleteByPrimaryKey(primaryKey);
    }

	@Override
	public List<Label> getLabelList() {
		LabelCriteria example = new LabelCriteria();
		/*example.setOrderByClause("cast(ID as int)");*/
		return labelMapper.selectByExample(example);
	}

	@Override
	public int getLabelCount(Label label) {
		return labelMapper.getLabelCount(label);
	}

  @Override
  public Map<String,Object> getLabelListByIds(List<String> labels) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(labels !=null && labels.size()>0){
          List<Label> labelList  = labelMapper.getLabelListByIds(labels);
          if(labelList !=null && labelList.size()>0){
            for(Label label:labelList){
               map.put(label.getId(), label.getName());
            }
          }
        }
        return map;
  }

  @Override
  public Map<String, Object> getLabelListByLabelNames(List<String> labelNames) {
    Map<String,Object> map = new HashMap<String,Object>();
    if(labelNames !=null && labelNames.size()>0){
      List<Label> labelList  = labelMapper.getLabelListByNames(labelNames);
      if(labelList !=null && labelList.size()>0){
        for(Label label:labelList){
           map.put(label.getName(), label.getId());
        }
      }
    }
    return map;
  }
  
  public static void main(String[] args){
    for(int i=0;i<20;i++){
      System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
  }
}