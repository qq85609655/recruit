<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/importResume.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/system/baseUserList.css"/>
  <title>任务管理</title>
  <style type="text/css">
    .mini-datagrid{margin:20px 0;}
  </style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
<div class="co">
  <div class="co-right">
    <div class="position-path co-right-center">
      <span class="path-title">您的位置 :</span>
      <a class="path-item a-decoration" href="${ctx}/loginController/main">我的首页</a>
      <em class="path-icon">&gt;&gt;</em>
      <span class="path-leaf">校园招聘</span>
      <em class="path-icon">&gt;&gt;</em>
      <span class="path-leaf">任务管理</span>
    </div>
    <div class="co-right-main co-right-center">
      <div class="tab">
				<a class="tab-item active">任务总览</a>
				<a class="tab-item" href="${ctx}/campusTaskController/detailList">任务明细</a>
			</div>
      <div class="account-content">
        <div class="account-search">
          <table class="tblQuery2">
            <tbody>
            <tr>
              <th>&nbsp;年份：</th>
              <td><input id="yearth" class="mini-combobox" name="yearth"
                         style="width: 80px;" valueField="yearth" disabled="disabled"
                         url="${ctx}/campusTaskController/datagrid4Yearth" onitemclick="search()"
                         allowInput="false" textField="yearth" pinyinField="tag"/></td>
              <th>&nbsp;组织:</th>
              <td>
                <input id="organizationId" class="mini-combobox" name="organizationId"
                       style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                       url="${ctx}/datadictGroupTypeController/getDictsByCode/campus_company"
                       allowInput="true" textField="typeName" pinyinField="tag"
                       onitemclick="search()">
              </td>
              <th>&nbsp;站点:</th>
              <td>
                <input id="siteId" class="mini-combobox" name="siteId"
                        style="width: 120px;" valueField="siteId" showNullItem="true"
                        url="${ctx}/campusSiteController/datagrid" nullItemText="全部"
                        allowInput="true" textField="siteName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              <th>&nbsp;岗位:</th>
              <td>
                <input id="postId" class="mini-combobox" name="postId" nullItemText="全部"
                        style="width: 120px;" valueField="typeId" showNullItem="true"
                        url="${ctx}/datadictGroupTypeController/getDictsByCode/pose_type"
                        allowInput="true" textField="typeName" pinyinField="tag"
                        onitemclick="search()">
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div id="datagrid" class="mini-datagrid" url="${ctx}/campusTaskController/datagrid4Sum"
             idField="id" allowResize="false" showPager="false">
          <div property="columns">
            <div type="checkcolumn"></div>
            <div field="yearth" width="120" allowSort="true">年份</div>
            <div field="orgName" width="120" allowSort="true">所属组织</div>
            <div field="siteName" width="120" allowSort="true">站点名称</div>
            <div field="postName" width="120" allowSort="true">岗位名称</div>
            <div header="任务" headerAlign="center">
              <div property="columns">
                <div field="taskNumberBa" width="70">本科</div>
                <div field="taskNumberMa" width="70">硕士</div>
                <div field="taskNumberDo" width="70">博士</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script>
  mini.parse();
  mini.get("yearth").select(0);
  var datagrid = mini.get("datagrid");
  search();
  function search() {
    var yearth = mini.get("yearth").getValue();
    var organizationId = mini.get("organizationId").getValue();
    var siteId = mini.get("siteId").getValue();
    var postId = mini.get("postId").getValue();
    datagrid.load({
      yearth: yearth,
      organizationId: organizationId,
      siteId: siteId,
      postId: postId
    });
  }

</script>
</html>
