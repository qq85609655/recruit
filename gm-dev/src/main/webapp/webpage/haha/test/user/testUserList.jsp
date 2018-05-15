<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
    <table style="width: 100%;">
      <tr>
        <td style="width: 100%;"><a class="mini-button" iconCls="icon-add" onclick="create"
          plain="true">新建</a> <a class="mini-button" iconCls="icon-edit" onclick="modify"
          plain="true">编辑</a> <a class="mini-button" iconCls="icon-remove" onclick="remove"
          plain="true">删除</a> <a class="mini-button" iconCls="icon-node" onclick="view" plain="true">查看</a>
          <a class="mini-button" iconCls="icon-goto" onclick="gotoIndex" plain="true">返回首页</a>
          <a class="mini-button" iconCls="icon-goto" onclick="gotoUserList" plain="true">跳转用户列表</a>
        </td>
        <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
          class="mini-textbox" onenter="onKeyEnter" emptyText="请输入查询条件" selectOnFocus="true" /> <a
          class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
      </tr>
    </table>
  </div>
  <div class="mini-fit">
    <div id="mainGrid" class="mini-datagrid" style="width: 100%; height: 100%" sizeList="[2,3,5]"
      pageSize="2" url="testUserController/datagrid" idField="id" allowResize="true">
      <div property="columns">
        <div type="indexcolumn" width="15"></div>
        <div field="name" headerAlign="center" allowSort="true">姓名</div>
        <div field="address" headerAlign="center" allowSort="true">家庭地址</div>
        <div field="birthday" heeaderAlign="center" dateFormat="yyyy-MM-dd HH:mm:ss"
          allowSort="true">出生日期</div>
        <div field="age" headerAlign="center" allowSort="true">年龄</div>
        <div field="salary" headerAlign="center" allowSort="true">工资</div>
        <div field="workPlace" headerAlign="center" allowSort="true">工作地址</div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var grid = mini.get("mainGrid");
      grid.load();

      function create() {
        OpenDialog("testUserController/create", "新建", grid);
      }

      function modify() {
        var row = grid.getSelected();
        if (row) {
          OpenDialog("testUserController/modify/" + row.id, "编辑", grid);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = grid.getSelected();
        if (row) {
          mini.confirm("确定删除记录？", "删除", function(action) {
            if (action == "ok") {
              SaveData("testUserController/remove/" + row.id, "", function(e) {
                ShowActionTip(e);
                grid.reload();
              });
            }
          });
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function view() {
        var row = grid.getSelected();
        if (row) {
          OpenDialog("testUserController/view/" + row.id, "查看");
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function search() {
        var searchKey = mini.get("searchKey").getValue();
        grid.load({
          searchKey : searchKey
        });
      }

      function onKeyEnter(e) {
        search();
      }
      
      function gotoIndex() {
        parent.loadIframePage("webpage/index.jsp", "首页");
      }
      
      function gotoUserList() {
        parent.loadIframePage("auth/user/sysUser/list", "用户列表");
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>