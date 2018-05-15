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
      <div id="datagrid1" class="mini-datagrid" ondrawcell="ondrawcell" showPager="true"
        url="/recruit/recruitDemandChangeControllerLogin/datagrid?showPager=true&searchKey=${param.id}"
        idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true">
        <div property="columns">
          <div type="indexcolumn">序号</div>
          <div name="type" field="type" width="80" align="center" headerAlign="center"
            allowSort="true">变更字段</div>
          <div name="oldStr" field="oldStr" width="80" align="center" headerAlign="center"
            allowSort="false">变更前信息</div>
          <div name="newStr" field="newStr" width="80" allowSort="false" align="center"
            headerAlign="center">变更后信息</div>
          <div name="isDeal" field="isDeal" width="80" allowSort="false" align="center"
            headerAlign="center">是否审批</div>
          <div name="isAgerr" field="isAgerr" width="80" allowSort="false" align="center"
            headerAlign="center">审批结果</div>
          <div name="updateDate" field="updateDate" width="80" allowSort="false" align="center"
            headerAlign="center" dateFormat="yyyy-MM-dd">更新时间</div>
        </div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
  //招聘状态字典
  var type = [ {
    id : 1,
    text : '申请人数'
  }, {
    id : 2,
    text : '期望到岗日期'
  } ];
  //是否处理
  var isDeal = [ {
    id : 1,
    text : '未审批'
  }, {
    id : 2,
    text : '已经审批'
  } ];
  //是否同意
  var isAgerr = [ {
    id : 1,
    text : '审批不通过'
  }, {
    id : 2,
    text : '审批通过'
  } ];

  //为数据添加超链接
  function ondrawcell(e) {
    var row = e.row, column = e.column, field = e.field, value = e.value;
    if (field == "type" && row.type != null) {
      for (var i = 0, l = type.length; i < l; i++) {
        var g = type[i];
        if (g.id == row.type)
          e.cellHtml = g.text;
      }
    }
    
    if (field == "isDeal" && row.isDeal != null) {
      for (var i = 0, l = isDeal.length; i < l; i++) {
        var g = isDeal[i];
        if (g.id == row.isDeal)
          e.cellHtml = g.text;
      }
    }
    if (field == "isAgerr" && row.isAgerr != null) {
      for (var i = 0, l = isAgerr.length; i < l; i++) {
        var g = isAgerr[i];
        if (g.id == row.isAgerr)
          e.cellHtml = g.text;
      }
    }
    if (field == "updateDate" && row.updateDate != null) {
      e.cellHtml = new Date(row.updateDate).format("yyyy-MM-dd hh:mm:ss");
    }
  }
</script>
</html>









