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
      <div id="datagrid1" class="mini-datagrid" showPager="true"
        url="/recruit/demand/datagrid?showPager=true&demandState=${demandState}&postId=${param.postId}"
        idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"
        style="height: 350px;">
        <div property="columns">
          <div type="checkcolumn"></div>
          <c:if test="${param.type eq '1'}">
            <div name="workRemark" field="workRemark" align="center" headerAlign="center"
              allowSort="true">工作描述</div>
          </c:if>
          <c:if test="${param.type eq '2'}">
            <div name="workExperience" field="workExperience" align="center" headerAlign="center"
              allowSort="true" allowSort="false">工作经验</div>
          </c:if>
          <c:if test="${param.type eq '3'}">
            <div name="requiredSkill" field="requiredSkill" align="center" headerAlign="center"
              allowSort="false">必备技能</div>
          </c:if>
          <c:if test="${param.type eq '4'}">
            <div name="abilityDemanded" field="abilityDemanded" align="center" headerAlign="center"
              allowSort="false">素质及能力要求</div>
          </c:if>
        </div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  var type = "${param.type}";
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
  //渲染列表数据
  function ondrawcell(e) {
    var row = e.row, column = e.column, field = e.field, value = e.value;
    if (field == "updateDate" && row.updateDate != null) {
      //修改时间格式化
      e.cellHtml = new Date(row.updateDate).format("yyyy-MM-dd hh:mm:ss");
    }
  }
  //跨页面调用,获取当前选择的历史文案
  function GetData() {
    var result = new Object();
    var row = grid.getSelected();
    result.type = type;
    if (type == "1") { //工作描述
      result.str = row.workRemark;
    } else if (type == "2") { //工作经验
      result.str = row.workExperience;
    } else if (type == "3") { //必备技能
      result.str = row.requiredSkill;
    } else { //素质及能力要求
      result.str = row.abilityDemanded;
    }
    return result;
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
</script>
</html>









