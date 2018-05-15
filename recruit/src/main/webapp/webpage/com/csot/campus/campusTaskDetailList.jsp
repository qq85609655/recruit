<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/importResume.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/system/baseUserList.css"/>
  <title>任务管理</title>
  <style type="text/css">
  .mini-datagrid{margin:0 0 40px;}
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
		<a class="tab-item" href="${ctx}/campusTaskController/list">任务总览</a>
		<a class="tab-item active">任务明细</a>
	</div>
      <div class="account-content">
        <div class="account-search">
          <table class="tblQuery2">
            <tbody>
            <tr>
              <th>&nbsp;年份：</th>
              <td><input class="mini-combobox" style="width: 80px;" textField="yearth"
                         id="yearth" disabled="disabled" onitemclick="search()"
                         valueField="yearth" url="${ctx}/campusTaskController/datagrid4Yearth"
                         allowInput="false"/></td>
              <th>&nbsp;组织:</th>
              <td>
                <input
                        id="organizationId" class="mini-combobox" name="organizationId"
                        style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                        url="${ctx}/datadictGroupTypeController/getDictsByCode/campus_company"
                        allowInput="true" textField="typeName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              <th>&nbsp;站点:</th>
              <td>
                <input
                        id="siteId" class="mini-combobox" name="siteId"
                        style="width: 120px;" valueField="siteId" showNullItem="true"
                        url="${ctx}/campusSiteController/datagrid" nullItemText="全部"
                        allowInput="true" textField="siteName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              <th>&nbsp;岗位:</th>
              <td>
                <input
                        id="postId" class="mini-combobox" name="postId" nullItemText="全部"
                        style="width: 120px;" valueField="typeId" showNullItem="true"
                        url="${ctx}/datadictGroupTypeController/getDictsByCode/pose_type"
                        allowInput="true" textField="typeName" pinyinField="tag"
                        onitemclick="search()">
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="table-operate" style="padding: 10px">
          <shiro:hasPermission name="campus:taskMsg:task:taskOpera">
            <input type="button" class="button radius btn" id="uploadButton" value="excel导入" onclick="onImport()"/>
            <input type="button" class="button radius btn" id="removeTask" value="删除" onclick="removeTask()"/>
            <input type="button" class="button radius btn" id="createTask" value="新增" onclick="createTask()"/>
            <input type="button" class="button radius btn" id="modifyTask" value="编辑" onclick="modifyTask()"/>
            <input type="button" class="button radius btn" id="editSiteStatus" value="修改站点状态" onclick="editSiteStatus()" />
            <input type="button" class="button radius btn" id="viewTaskHistory" value="查看任务变更记录" onclick="viewTaskHistory()" />
          </shiro:hasPermission>
          <input type="button" class="button radius btn" id="exportTask" value="导出" onclick="exportTask()" />
        </div>
        <div id="datagrid" class="mini-datagrid" url="${ctx}/campusTaskController/datagrid?showPager=true"
             idField="id" sizeList="[10,20,50,100]" pageSize="10" allowResize="false" multiSelect="true">
          <div property="columns">
            <div type="checkcolumn"></div>
            <div field="yearth" width="80" allowSort="true">年份</div>
            <div field="orgName" width="80" allowSort="true">所属组织</div>
            <div field="siteName" width="60" allowSort="true">站点名称</div>
            <div field="jobFamily" width="80" allowSort="true">职位族</div>
            <div field="jobClass" width="120" allowSort="true">职位类</div>
            <div field="jobSubclass" width="120" allowSort="true">职位子类</div>
            <div field="bigCenter" width="80" allowSort="true">大中心</div>
            <div field="smallCenter" width="120" allowSort="true">厂/小中心</div>
            <div field="department" width="120" allowSort="true">部门</div>
            <div field="branch" width="120" allowSort="true">科室</div>
            <div field="reserved1" width="60" allowSort="true">学历</div>
            <div header="任务" headerAlign="center">
              <div property="columns">
                <div field="taskNumberMail" width="60">男</div>
                <div field="taskNumberFemail" width="60">女</div>
                <div field="taskNumberSum" width="60">总人数</div>
              </div>
            </div>
            <div field="jobDescribe" width="120" allowSort="true">职责描述</div>
            <div field="nightShift" width="120" allowSort="true">夜班频率</div>
            <div field="dustFree" width="120" allowSort="true">无尘室频率</div>
            <div field="specialRequire" width="120" allowSort="true">特殊要求</div>
            <div field="preferredMajor" width="120" allowSort="true">首选专业</div>
            <div field="alternativeMajor" width="120" allowSort="true">备选专业</div>
            <div field="remark" width="120" allowSort="true">备注</div>
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

  function createTask() {
    OpenDialog("${ctx}/campusTaskController/create", "新增任务", datagrid, 750, 600);
  }

  function modifyTask() {
    var data = datagrid.getSelecteds();
    if (data.length == 1) {
      var id = data[0].id;
      OpenDialog("${ctx}/campusTaskController/modify/" + id, "编辑任务", datagrid, 750, 600);
    } else {
      ShowWarnTip("请选择一条记录");
    }
  }

  function removeTask() {
    var data = datagrid.getSelecteds();
    if (data) {
      var ids = "";
      for (var i=0; i < data.length; i++) {
        ids += data[i].id + ",";
      }
      mini.confirm("确定删除记录？<br>", "删除", function (action) {
        if (action == "ok") {
          SaveData("${ctx}/campusTaskController/remove/" + ids, "", function (e) {
            ShowActionTip(e);
            datagrid.reload();
          });
        }
      });
    } else {
      ShowWarnTip("请选择至少一条记录");
    }
  }

  function onImport() {
    mini.open({
      url: "/recruit/campusTaskController/importCampusTask",
      title: "导入任务",
      width: 400,
      height: 170,
      allowResize: false
    });
  }

  function saveData() {
    datagrid.validate();
    if (datagrid.isValid() == false) {
      var error = datagrid.getCellErrors()[0];
      mini.alert(error.errorText);
      datagrid.beginEditCell(error.record, error.column);
      return;
    }
    var data = datagrid.getChanges();
    var json = mini.encode(data);

    datagrid.loading("保存中，请稍后......");
    $.ajax({
      url: "${ctx}/campusTaskController/saveData",
      dataType: 'json',
      contentType: 'application/json',
      data: json,
      type: "post",
      success: function (text) {
        mini.alert(text.msg);
        datagrid.reload();
      },
      error: function (jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
      }
    });
  }

  function exportTask() {
    var yearth = mini.get("yearth").getValue();
    var yearthValue = encodeURI(encodeURI(yearth));
    var organizationId = mini.get("organizationId").getValue();
    var siteId = mini.get("siteId").getValue();
    var postId = mini.get("postId").getValue();
    window.location.href = '${ctx}/campusTaskController/exportTask?yearth=' + yearthValue + '&organizationId='
     + organizationId + '&siteId=' + siteId + '&postId=' + postId;
  }

  function editSiteStatus() {
    mini.open({
      url: "${ctx}/campusSiteController/editSiteStatus",
      title: "站点状态编辑",
      width: 400,
      height: 540,
      allowResize: true
    });
  }

  function viewTaskHistory() {
    mini.open({
      url: "${ctx}/campusTaskHistoryController/list",
      title: "任务变更记录",
      width: 1000,
      height: 550,
      allowResize: true
    });
  }

</script>
</html>
