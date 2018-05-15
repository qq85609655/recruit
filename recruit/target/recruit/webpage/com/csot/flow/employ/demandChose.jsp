<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>招聘需求管理</title>
</head>
<body onload="removeLoad();">
  <div class="account-search" style="padding: 5px;">
    <div class="blue radius">
      <div class="table-operate" style="padding-top: 0px;">
        <input type="button" class="button radius btn" id="addRecruitDemand" value="确认"
          onclick="onOk()" onclick="addRecruitDemand()" /> <input type="button"
          class="button radius btn" id="addRecruitDemand" value="取消" onclick="onCancel()"
          onclick="addRecruitDemand()" />
      </div>
      <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
        url="/recruit/demand/datagrid?showPager=true&demandState=${demandState}" idField="id"
        sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true">
        <div property="columns">
          <div type="checkcolumn"></div>
          <div name="demandId" field="demandId" width="80" allowSort="true">需求流程ID</div>
          <div name="flowState" field="flowState" width="80" align="center" headerAlign="center"
            allowSort="true" allowSort="false" renderer="onFlowStateRenderer">流程状态</div>
          <div name="applyPostName" field="applyPostName" width="80" align="center"
            cellCls="color-blue curpo updateAtag" headerAlign="center" allowSort="false">岗位名称</div>
          <div name="applyPostId" field="applyPostId" width="80" allowSort="false" align="center"
            headerAlign="center">岗位ID</div>
          <div name="rankName" field="rankName" width="100" allowSort="false" align="center"
            headerAlign="center">职级</div>
          <div name="recruiterNumber" field="recruiterNumber" width="60" allowSort="false"
            align="center" headerAlign="center">接收简历</div>
          <div name="recruiterName" field="recruiterName" width="60" allowSort="false"
            align="center" headerAlign="center">匹配简历</div>
          <div name="deputyName" field="deputyName" width="80" allowSort="true" align="center"
            headerAlign="center">招聘代表</div>
          <div name="applyOrganizationName" field="applyOrganizationName" width="80"
            allowSort="true" align="center" headerAlign="center">需求部门</div>
          <div name="applyPersonNumber" field="applyPersonNumber" width="60" allowSort="false"
            align="center" headerAlign="center">需求人数</div>
          <div name="websitePostName" field="websitePostName" width="120" allowSort="false"
            align="center" headerAlign="center">网站发布岗位名称</div>
          <div name="predictComeDate" field="predictComeDate" width="80" allowSort="false"
            align="center" headerAlign="center">预计到岗日期</div>
          <!-- <div name="infoState" field="infoState" width="60" allowSort="false"
                        align="center" headerAlign="center">编辑状态</div> -->
          <div name="websiteTypes" field="websiteTypes" width="120" allowSort="false" align="center"
            headerAlign="center">发布的网站</div>
          <div name="releaseDate" field="releaseDate" width="100" allowSort="false" align="center"
            headerAlign="center">最新发布日期</div>
          <div name="editPerson" field="editPerson" width="80" allowSort="false" align="center"
            headerAlign="center">已入职数量</div>
          <div name="infoState" field="infoState" width="60" allowSort="false" align="center"
            headerAlign="center" renderer="onInfoStateRenderer">招聘状态</div>
          <div name="logNum" field="logNum" width="80" allowSort="false" cellclick="showAllLog"
            cellCls="color-blue curpo demandLog" align="center" headerAlign="center">需求变更记录</div>
        </div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  param = new Object();
  param.stateSelf = 6;
  grid.load(param);

  function GetData() {
    var rows = grid.getSelecteds();
    return rows[0];
  }
  //取消按钮
  function onCancel(e) {
    CloseWindow("close");
  }
  //确认按钮
  function onOk() {
    //确保选中一条数据
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      CloseWindow("ok");
    } else {
      ShowWarnTip("请选择一条记录");
    }
  }

  //流程状态字典
  var flowState = [ {
    id : 1,
    text : '未提交'
  }, {
    id : 2,
    text : '审核中'
  }, {
    id : 3,
    text : '废弃'
  }, {
    id : 4,
    text : '审核通过'
  } ];

  // 流程状态渲染
  function onFlowStateRenderer(e) {
    for (var i = 0, l = flowState.length; i < l; i++) {
      var g = flowState[i];
      if (g.id == e.value)
        return g.text;
    }
    return "";
  }
  // 招聘状态字典
  var infoState = [ {
    id : 1,
    text : '草稿'
  }, {
    id : 2,
    text : '待发布'
  }, {
    id : 3,
    text : '已发布'
  } ];

  // 招聘状态渲染
  function onInfoStateRenderer(e) {
    for (var i = 0, l = infoState.length; i < l; i++) {
      var g = infoState[i];
      if (g.id == e.value)
        return g.text;
    }
    return "";
  }
</script>
</html>









