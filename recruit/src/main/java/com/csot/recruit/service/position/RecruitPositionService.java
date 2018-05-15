package com.csot.recruit.service.position;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.PositionDistributeRecords;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitSite;
import com.csot.recruit.model.position.RequireInfor;

public interface RecruitPositionService {
  MiniRtn2Grid<RecruitPosition> getGrid(MiniGridPageSort pageSort, String searchKey);

  RecruitPosition getByPrimaryKey(String primaryKey);

  void create(RecruitPosition recruitPosition) throws ParseException;

  void updateSelective(RecruitPosition recruitPosition, Map<String, String> colMap);

  void remove(String primaryKey);

  /**
   * 新建发布职位时需获取一个职位编码
   * 
   * @return 职位编码
   */
  String getPosiCode();

  /***
   * 职位发布
   * 
   * @param recruitPosition 职位基本信息
   * @param departmentRequire 需求信息
   * @param requireInfor 招聘流程角色
   */
  void createRecruitPosition(RecruitPosition recruitPosition, DepartmentRequire departmentRequire,
      RequireInfor requireInfor);

  /***
   * 职位管理
   * 
   * @param positionMana 查询条件对象
   * @return
   */
  MiniRtn2Grid<PositionMana> queryPositionManaList(PositionMana positionMana);

  /**
   * 查询职位，不分页，不用表格对象封装
   * 
   * @param positionMana
   * @return
   */
  List<PositionMana> queryPositionMana(PositionMana positionMana);

  /***
   * 职位管理(带分页)
   * 
   * @param pageSort 分页对象
   * @param positionMana 查询条件对象
   * @return
   */
  MiniRtn2Grid<PositionMana> queryPositionManaListByPage(MiniGridPageSort pageSort,
      PositionMana positionMana);

  /**
   * 分发职位
   * 
   * @param rs
   * @return
   */
  String positionDistribute(RecruitSite rs);

  /***
   * 职位分发记录(带分页)
   * 
   * @param pageSort 分页对象
   * @param positionDistribute 查询条件对象
   * @return
   */
  MiniRtn2Grid<PositionDistributeRecords> queryPositionDistributeListByPage(
      MiniGridPageSort pageSort, PositionDistributeRecords positionDistribute);

  /***
   * 根据职位id删除职位与该职位id相关联的所有数据
   * 
   * @param positionId 职位id
   */
  void removeByPositionId(String positionId);

  /**
   * 根据状态查询相应的职位
   * 
   * @param status
   * @return
   */
  List<PositionMana> getPositionByStatus(String status);

  /**
   * 获取user表的Id和Name
   * 
   * @return
   */
  Map<String, Object> getIdName();

  void create2(RecruitPosition recruitPosition, Map<String, String> colMap) throws ParseException;

  RecruitPosition queryPositionByPostId(String postId);

  void updateSelective(RecruitPosition recruitPosition);

}