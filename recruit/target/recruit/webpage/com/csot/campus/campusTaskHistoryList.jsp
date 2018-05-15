<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="/recruit-tags" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
  <title>任务变更记录</title>
  <style type="text/css">
    .mini-datagrid {
      width: 800px;
      overflow: visible;
    }
  </style>
</head>
<body onload="removeLoad();">
  <div class="co-right">
    <div class="co-right-main co-right-center">
      <div class="con-title">任务变更记录</div>
      <div class="account-content">
        <div class="blue radius">
          <div class="table-operate" style="padding: 10px">
            <table class="tblQuery2">
              <tbody>
              <th>&nbsp;年份：</th>
              <td><input class="mini-combobox" style="width: 80px;" textField="yearth"
                         id="yearth" disabled="disabled" onitemclick="search()"
                         valueField="yearth" url="/recruit/campusTaskController/datagrid4Yearth"
                         allowInput="false"/></td>
              <th>&nbsp;组织:</th>
              <td>
                <input
                        id="organizationId" class="mini-combobox" name="organizationId"
                        style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company"
                        allowInput="true" textField="typeName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              <th>&nbsp;站点:</th>
              <td>
                <input
                        id="siteId" class="mini-combobox" name="siteId"
                        style="width: 120px;" valueField="siteId" showNullItem="true"
                        url="/recruit/campusSiteController/datagrid" nullItemText="全部"
                        allowInput="true" textField="siteName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              <th>&nbsp;岗位:</th>
              <td>
                <input
                        id="postId" class="mini-combobox" name="postId" nullItemText="全部"
                        style="width: 120px;" valueField="typeId" showNullItem="true"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/pose_type"
                        allowInput="true" textField="typeName" pinyinField="tag"
                        onitemclick="search()">
              </td>
              </tr>
              </tbody>
            </table>
          </div>
          <div id="datagrid1" class="mini-datagrid" url="/recruit/campusTaskHistoryController/datagrid?showPager=true"
               idField="id" sizeList="[15,30,50,100]" multiSelect="true" pageSize="15" allowResize="false">
            <div property="columns">
              <div type="checkcolumn"></div>
              <div field="yearth" width="60" allowSort="true">年份</div>
              <div field="orgName" width="80" allowSort="true">所属组织</div>
              <div field="siteName" width="60" allowSort="true">站点名称</div>
              <div field="postName" width="80" allowSort="true">职位类</div>
              <div field="bigCenter" width="70" allowSort="true">大中心</div>
              <div field="smallCenter" width="80" allowSort="true">小中心</div>
              <div field="department" width="80" allowSort="true">部门</div>
              <div field="branch" width="80" allowSort="true">科室</div>
              <div field="education" width="45" allowSort="true">学历</div>
              <div field="changeDate" width="120" allowSort="true" renderer="onDateRenderer">变更时间</div>
              <div header="变更前任务" headerAlign="center">
                <div property="columns">
                  <div field="taskNumberMail" width="40">男</div>
                  <div field="taskNumberFemail" width="40">女</div>
                  <div field="taskNumberSum" width="40">总数</div>
                </div>
              </div>
              <div header="变更后任务" headerAlign="center">
                <div property="columns">
                  <div field="taskNumberMailNew" width="40">男</div>
                  <div field="taskNumberFemailNew" width="40">女</div>
                  <div field="taskNumberSumNew" width="40">总数</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script>
  mini.parse();
  var datagrid = mini.get("datagrid1");

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

  function onDateRenderer(e) {
    var value = e.value;
    if (value)
      return new Date(value).format("yyyy-MM-dd hh:mm");
    return "";
  }

</script>
</html>
