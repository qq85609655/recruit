package com.csot.recruit.service.impl.resume;

import com.csot.recruit.dao.original.resume.BasicinforMapper;
import com.csot.recruit.model.original.resume.Basicinfor;
import com.csot.recruit.model.original.resume.BasicinforColumns;
import com.csot.recruit.model.original.resume.BasicinforCriteria;
import com.csot.recruit.service.resume.BasicinforService;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("basicinforService")
public class BasicinforServiceImpl implements BasicinforService {
    private static final Logger logger = LoggerFactory.getLogger(BasicinforServiceImpl.class);

    @Resource
    private BasicinforMapper basicinforMapper;

    @Override
    public MiniRtn2Grid<Basicinfor> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Basicinfor> grid = new MiniRtn2Grid<Basicinfor>();
        BasicinforCriteria criteria = new BasicinforCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = BasicinforColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(basicinforMapper.selectByExample(criteria));
        grid.setTotal(basicinforMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Basicinfor getByPrimaryKey(String primaryKey) {
        return basicinforMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Basicinfor basicinfor) {
        basicinforMapper.insert(basicinfor);
    }

    @Override
    public void updateSelective(Basicinfor basicinfor) {
        basicinforMapper.updateByPrimaryKeySelective(basicinfor);
    }

    @Override
    public void remove(String primaryKey) {
        basicinforMapper.deleteByPrimaryKey(primaryKey);
    }
}