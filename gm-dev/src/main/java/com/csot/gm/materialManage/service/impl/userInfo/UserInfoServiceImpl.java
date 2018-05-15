package com.csot.gm.materialManage.service.impl.userInfo;

import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.gm.esbws.dao.AccountInfoDao;
import com.csot.gm.esbws.entity.AccountInfoEntity;
import com.csot.gm.esbws.service.OrgInfoService;
import com.csot.gm.materialManage.dao.original.userInfo.UserInfoMapper;
import com.csot.gm.materialManage.model.original.userInfo.UserInfo;
import com.csot.gm.materialManage.model.original.userInfo.UserInfoColumns;
import com.csot.gm.materialManage.model.original.userInfo.UserInfoCriteria;
import com.csot.gm.materialManage.service.userInfo.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
  private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

  @Resource
  private OrgInfoService orgInfoService;

  @Resource
  private UserInfoMapper userInfoMapper;
  @Resource
  private AccountInfoDao accountInfoDao;

  @Override
  public MiniRtn2Grid<UserInfo> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<UserInfo> grid = new MiniRtn2Grid<UserInfo>();
    UserInfoCriteria criteria = new UserInfoCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = UserInfoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(userInfoMapper.selectByExample(criteria));
    grid.setTotal(userInfoMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public UserInfo getByPrimaryKey(String primaryKey) {
    return userInfoMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(UserInfo userInfo) {
    userInfo.setId(UUID.randomUUID().toString().replace("-", ""));
    userInfoMapper.insert(userInfo);
  }

  @Override
  public void updateSelective(UserInfo userInfo) {
    userInfoMapper.updateByPrimaryKeySelective(userInfo);
  }

  @Override
  public void remove(String primaryKey) {
    userInfoMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public com.csot.gm.rawMaterial.model.UserInfo getByUserCode(String userCode) {
    com.csot.gm.rawMaterial.model.UserInfo user = new com.csot.gm.rawMaterial.model.UserInfo();
    AccountInfoEntity accInfo = accountInfoDao.queryItemByCode(userCode);
    if (null != accInfo) {
      user.setUserCode(userCode);
      user.setUserName(accInfo.getName());
      user.setTelephone(accInfo.getMobile());

      // 查询组合创建人部门信息
      String department = "";
      AccountInfoEntity org = accInfo;
      do {
        department = org.getName() + "/" + department;
        org = orgInfoService.getParentItem(org.getCode());
      } while (null != org);

      if (!"".equals(department)) {
        department = department.replace("华星光电/", ""); // 删除字符串开头的“CEO/**/”
        department = department.replace("深圳市华星光电技术有限公司/", ""); // 删除字符串开头的“CEO/**/”
        department = department.replace("武汉华星光电技术有限公司/", ""); // 删除字符串开头的“CEO/**/”
        department = department.replace("武汉华星光电技术有限公司 /", "");
        department = department.replace("(执行)董事长/", ""); // 删除字符串开头的“CEO/**/”
        department = department.replace("CEO/", ""); // 删除字符串开头的“CEO/**/”
        department = department.replace("副总裁/", ""); // 删除字符串开头的“副总裁/**/”
        department = department.replace("总裁/", ""); // 删除字符串开头的“总裁/**/”
        department = department.replace("制造中心/", ""); // 删除字符串开头的“制造中心/**/”
        department = department.replace("/" + accInfo.getName() + "/", ""); // 删除字符串结尾的“/姓名/”
      }
      logger.info("创建人：" + userCode + "所在部门信息为：" + department);
      user.setDepartment(department);
    }

    return user;
  }
}
