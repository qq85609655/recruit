package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.apache.ibatis.annotations.Param;

public interface BaseUserMapper extends MyBatisBaseMapper {
    int countByExample(BaseUserCriteria example);

    int deleteByExample(BaseUserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);
    
    int insertUserOrg(BaseUser record);
    
    int insertUserRole(BaseUser record);
    
    List<BaseUser> selectByExample(BaseUserCriteria example);

    BaseUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserCriteria example);

    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserCriteria example);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    List<BaseUser> selectAllRecruiter();
    
    int validatePassowrd(String id,String password);
    
    List<BaseUser> getUserInfoList(BaseUserCriteria example);
    
    List<BaseUser> getBaseUserInfoList(Map<String,Object> map);
    
    List<BaseUser> getAllUser();
    
    int countBaseUser(Map<String,Object> map);
    
    int setStatus(String id);
    
    int deleteBaseUserOrg(String id);
    
    int deleteBaseUserRole(String id);
    
    int deleteBaseUserById(String id);
    
    List<BaseUser> selectFromAccount();

    List<SysUser> selectUsersByGroupId(Long groupId);

    int countByExampleByGroupId(BaseUserCriteria baseUserCriteria);

    List<BaseUser> selectByExampleByGroupId(BaseUserCriteria baseUserCriteria);

    Map<String, String> getInfoByCode(String code);
    
}