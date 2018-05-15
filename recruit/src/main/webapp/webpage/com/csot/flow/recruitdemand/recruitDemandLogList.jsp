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
        url="/recruit/recruitDemandLogController/datagrid?showPager=true&searchKey=${param.id}"
        idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true"
        style="height: 350px;">
        <div property="columns">
          <div type="indexcolumn">序号</div>
          <div name="updateField" field="updateField" width="80" align="center" headerAlign="center"
            allowSort="true">变更字段</div>
          <div name="oldStr" field="oldStr" width="80" align="center" headerAlign="center"
            allowSort="false">变更前信息</div>
          <div name="newStr" field="newStr" width="80" allowSort="false" align="center"
            headerAlign="center">变更后信息</div>
          <div name="updateDate" field="updateDate" width="80" allowSort="false" align="center"
            headerAlign="center" dateFormat="yyyy-MM-dd">更新时间</div>
          <div name="modifiedName" field="modifiedName" width="80" allowSort="false" align="center"
            headerAlign="center">操作人</div>
        </div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
  //为数据添加超链接
  function ondrawcell(e) {
    var row = e.row, column = e.column, field = e.field, value = e.value;
    if (field == "updateDate" && row.updateDate != null) {
      e.cellHtml = new Date(row.updateDate).format("yyyy-MM-dd hh:mm:ss");
    }
  }
</script>
</html>








