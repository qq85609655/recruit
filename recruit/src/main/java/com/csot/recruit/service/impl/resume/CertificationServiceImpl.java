package com.csot.recruit.service.impl.resume;

import java.util.List;

import com.csot.recruit.dao.resume.CertificationMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.nresume.Certification;
import com.csot.recruit.model.resume.CertificationColumns;
import com.csot.recruit.model.resume.CertificationCriteria;
import com.csot.recruit.service.resume.CertificationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("certificationService")
public class CertificationServiceImpl implements CertificationService {
    private static final Logger logger = LoggerFactory.getLogger(CertificationServiceImpl.class);

    @Resource
    private CertificationMapper certificationMapper;

    @Override
    public MiniRtn2Grid<Certification> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Certification> grid = new MiniRtn2Grid<Certification>();
        CertificationCriteria criteria = new CertificationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = CertificationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(certificationMapper.selectByExample(criteria));
        grid.setTotal(certificationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Certification getByPrimaryKey(String primaryKey) {
        return certificationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Certification certification) {
        certificationMapper.insert(certification);
    }

    @Override
    public void updateSelective(Certification certification) {
        certificationMapper.updateByPrimaryKeySelective(certification);
    }

    @Override
    public void remove(String primaryKey) {
        certificationMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public void create(com.csot.recruit.model.resume.Certification credential) {
      certificationMapper.insert2(credential);
      
    }

    @Override
    public com.csot.recruit.model.resume.Certification getByPrimaryKey2(String primaryKey) {
      // TODO Auto-generated method stub
      return certificationMapper.selectByPrimaryKey2(primaryKey);
    }

    @Override
    public void updateSelective(com.csot.recruit.model.resume.Certification certification) {
      certificationMapper.updateByPrimaryKeySelective2(certification);
      
    }

    @Override
    public List<com.csot.recruit.model.resume.Certification> queryByResumeId(String resumeId) {
      List<com.csot.recruit.model.resume.Certification> certifications=certificationMapper.selectByResumeId(resumeId);
      for(com.csot.recruit.model.resume.Certification certification:certifications ){
        certification.setTypeName(DatadictGroup.getTypeNameByTypeCode(certification.getType(),"diploma-type"));
      }
      return certifications;
    }
    
    @Override
    public void deleteByResumeId(String resumeId){
      certificationMapper.deleteByResumeId(resumeId);
    }

}