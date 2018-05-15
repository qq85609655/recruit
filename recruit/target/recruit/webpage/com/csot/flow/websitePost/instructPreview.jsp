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
        <input type="button" class="button radius btn" id="addRecruitDemand" value="提交"
          onclick="onOk()" /> <input type="button" class="button radius btn" id="addRecruitDemand"
          value="取消" onclick="onCancel()" />
      </div>
      <div id="datagrid1" class="mini-datagrid" multiSelect="false" showPager="false"
        url="/recruit/postWebsite/instructPreviewList/${postId}?showPager=true&websiteTypes=${param.websiteTypes}"
        idField="id" sizeList="[1,2,50,100]" allowResize="false" style="height: 350px;">
        <div property="columns">
          <div field="name" width="60" headerAlign="center" allowSort="true">发布网站</div>
          <div field="state" width="40" headerAlign="center">发布状态</div>
          <div field="instruct" width="40" headerAlign="center">修改发布状态</div>
        </div>
      </div>

    </div>
  </div>
</body>
<script type="text/javascript">
  var type = "${param.type}";
  var nameStr = "${param.name}";
  mini.parse();
  //默认获取招聘代表组用户数据
  var grid = mini.get("datagrid1");
  grid.load({
    //岗位描述
    content : window.parent.editor.html(),
    name : nameStr,
    content2 : window.parent.editor2.html()
  });

  //渲染列表数据
  function ondrawcell(e) {
    var row = e.row, column = e.column, field = e.field, value = e.value;
    if (field == "updateDate" && row.updateDate != null) {
      //修改时间格式化
      e.cellHtml = new Date(row.updateDate).format("yyyy-MM-dd hh:mm:ss");
    }
  }

  //取消按钮
  function onCancel(e) {
    CloseWindow("close");
  }
  //确认按钮
  function onOk() {
    CloseWindow("ok");
  }
</script>
</html>








