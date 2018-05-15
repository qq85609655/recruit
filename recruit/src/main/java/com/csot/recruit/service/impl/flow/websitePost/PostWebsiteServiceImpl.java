package com.csot.recruit.service.impl.flow.websitePost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.EnumUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteMapper;
import com.csot.recruit.model.original.flow.websitePost.InstructSimpleDetail;
import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteColumns;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;
import com.csot.recruit.service.flow.websitePost.PostWebsiteService;

@Service("postWebsiteService")
public class PostWebsiteServiceImpl implements PostWebsiteService {
  private static final Logger logger = LoggerFactory.getLogger(PostWebsiteServiceImpl.class);

  @Resource
  private PostWebsiteMapper postWebsiteMapper;

  @Override
  public MiniRtn2Grid<PostWebsite> getGrid(MiniGridPageSort pageSort, Map<String, String> col) {
    MiniRtn2Grid<PostWebsite> grid = new MiniRtn2Grid<PostWebsite>();
    PostWebsiteCriteria criteria = new PostWebsiteCriteria();
    // 查询条件
    PostWebsiteCriteria.Criteria criteriaOr = criteria.or();
    // 查询条件
    if (StringUtils.hasText(col.get("tabState"))) {
      criteriaOr.andWebsiteTypeEqualTo(col.get("tabState"));
    }
    if (StringUtils.hasText(col.get("state"))) {
      criteriaOr.andStateEqualTo(col.get("state"));
    }
    if (StringUtils.hasText(col.get("instructType"))) {
      criteriaOr.andLastInstructEqualTo(col.get("instructType"));
    }
    if (StringUtils.hasText(col.get("postNameStr"))) {
      criteriaOr.andPostNameLike("%" + col.get("postNameStr") + "%");
    }
    if (StringUtils.hasText(col.get("webpostName"))) {
      criteriaOr.andWebsitePostNameLike("%" + col.get("webpostName") + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PostWebsiteColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(postWebsiteMapper.selectByExample(criteria));
    grid.setTotal(postWebsiteMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PostWebsite getByPrimaryKey(String primaryKey) {
    return postWebsiteMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PostWebsiteWithBLOBs postWebsiteWithBLOBs) {
    postWebsiteMapper.insert(postWebsiteWithBLOBs);
  }

  @Override
  public void updateSelective(PostWebsiteWithBLOBs postWebsite) {
    postWebsiteMapper.updateByPrimaryKeySelective(postWebsite);
  }

  @Override
  public void remove(String primaryKey) {
    postWebsiteMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public List<InstructSimpleDetail> getGridByPostId(MiniGridPageSort pageSort,
      Map<String, String> colMap) {
    List<InstructSimpleDetail> instructSimpleDetails = new ArrayList<InstructSimpleDetail>();
    PostWebsiteCriteria criteria = new PostWebsiteCriteria();
    String websiteTypeStr = colMap.get("websiteTypes"); // 发布渠道
    String content = colMap.get("content"); // 岗位描述
    String content2 = colMap.get("content2"); // 岗位描述
    // 岗位名称名称+(code)
    String webPostName =
        colMap.get("name") + "(" + colMap.get("postId") + ")";
    List<String> websiteTypeList = new ArrayList<String>(); // 发布渠道集合
    if (StringUtil.isNotEmpty(websiteTypeStr)) {
      String[] websiteTypes = websiteTypeStr.split(",");
      for (String item : websiteTypes) {
        websiteTypeList.add(item);
      }
    }
    // 根据岗位编码查询网站岗位发布信息
    if (StringUtils.hasText(colMap.get("postId"))) {
      criteria.createCriteria().andPostIdEqualTo(colMap.get("postId"));
    }
    List<PostWebsiteWithBLOBs> selectByExample =
        postWebsiteMapper.selectByExampleWithBLOBs(criteria);
    // 获取该职位现有岗位发布信息
    for (PostWebsiteWithBLOBs postWebsite : selectByExample) {
      // postWebsiteState.put(postWebsite.getWebsiteType(), postWebsite.getState());
      String websiteType = postWebsite.getWebsiteType(); // 渠道
      if (websiteTypeList.contains(postWebsite.getWebsiteType())) {
        // 当前渠道勾选
        if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {
          // 当前状态是发布中
          InstructSimpleDetail detail = new InstructSimpleDetail();
          detail.setWebsiteType(websiteType); // 渠道类型
          detail.setName(EnumUtil.getWebsiteNameByType(websiteType)); // 渠道名称
          detail.setState(PostWebsite.state.FBZ.getText()); // 发布中状态
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            detail.setInstruct(InstructSimpleDetail.instruct.CXFB.getText());
            instructSimpleDetails.add(detail);
          }else{
            if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) {
              // 修改指令
              detail.setInstruct(InstructSimpleDetail.instruct.XG.getText()); // 暂停指令
              instructSimpleDetails.add(detail);
            }
          }
        } else {
          // 当前状态是暂停
          InstructSimpleDetail detail = new InstructSimpleDetail();
          detail.setWebsiteType(websiteType); // 渠道类型
          detail.setName(EnumUtil.getWebsiteNameByType(websiteType)); // 渠道名称
          detail.setState(PostWebsite.state.ZT.getText()); // 暂停状态
          if (!content.equals(postWebsite.getContent())||!content2.equals(postWebsite.getContent2())) {
            // 修改指令
            detail.setInstruct(InstructSimpleDetail.instruct.XG.getText()); // 暂停指令
          } else {
            // 重启指令
            detail.setInstruct(InstructSimpleDetail.instruct.CQ.getText()); // 暂停指令
          }
          if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除并重新发布
            detail.setInstruct(InstructSimpleDetail.instruct.CXFB.getText()); // 暂停指令
          }
          instructSimpleDetails.add(detail);
        }
      } else {
        // 当前渠道未勾选
        if (!webPostName.equals(postWebsite.getWebsitePostName())) { // 修改岗位名称删除
          InstructSimpleDetail detail = new InstructSimpleDetail();
          detail.setWebsiteType(websiteType); // 渠道类型
          detail.setName(EnumUtil.getWebsiteNameByType(websiteType)); // 渠道名称
          detail.setState(EnumUtil.getStateNameByType(postWebsite.getState())); //获取当前状态
          detail.setInstruct(InstructSimpleDetail.instruct.SC.getText()); // 删除指令
          instructSimpleDetails.add(detail);
        }else{
          if (PostWebsite.state.FBZ.getValueStr().equals(postWebsite.getState())) {
            // 当前状态是发布中
            // 暂停指令
            InstructSimpleDetail detail = new InstructSimpleDetail();
            detail.setWebsiteType(websiteType); // 渠道类型
            detail.setName(EnumUtil.getWebsiteNameByType(websiteType)); // 渠道名称
            detail.setState(PostWebsite.state.FBZ.getText()); // 发布中状态
            detail.setInstruct(InstructSimpleDetail.instruct.ZT.getText()); // 暂停指令
            instructSimpleDetails.add(detail);
          }
        }
        
      }
      // 移除已处理的发布渠道
      websiteTypeList.remove(postWebsite.getWebsiteType());
    }
    // 存留的发布渠道为未发布的渠道
    for (String websiteType : websiteTypeList) {
      // 发布指令
      InstructSimpleDetail detail = new InstructSimpleDetail();
      detail.setWebsiteType(websiteType); // 渠道类型
      detail.setName(EnumUtil.getWebsiteNameByType(websiteType)); // 渠道名称
      detail.setState(PostWebsite.state.WFB.getText());
      detail.setInstruct(InstructSimpleDetail.instruct.FB.getText());// 发布指令
      instructSimpleDetails.add(detail);
    }
    return instructSimpleDetails;
  }



  public static void main(String[] args) {
    System.out.println(getWuLiao("8100000760：1655,8100000760：1656,8100000718：1511"));
  }

  public static Map<String, List<String>> getWuLiao(String json) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    if (StringUtil.isNotEmpty(json)) {
      String[] split1 = json.split(","); // 获取物料和订单集合
      for (String item : split1) {
        if (StringUtil.isNotEmpty(item)) {
          String[] split2 = item.split("："); // 获取单独物料和集合信息
          String wuliao = split2[1]; // 物料id
          String dingdan = split2[0]; // 订单id
          if (map.keySet().contains(dingdan)) {
            // 订单存在
            List<String> wuliaos = map.get(dingdan);
            wuliaos.add(wuliao);
            map.put(dingdan, wuliaos);
          } else {
            // 订单不存在
            List<String> wuliaos = new ArrayList<String>();
            wuliaos.add(wuliao);
            map.put(dingdan, wuliaos);
          }
        }
      }
    }
    return map;
  }
}
