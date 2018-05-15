<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>系统用户列表</title>
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
          plain="true">新建</a> <a class="mini-button" iconCls="icon-user" onclick="changeStatus"
          plain="true">修改状态</a> <a class="mini-button" iconCls="icon-edit" onclick="changePassword"
          plain="true">重置密码</a> <a class="mini-button" iconCls="icon-remove" onclick="remove"
          plain="true">删除</a></td>
        <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
          class="mini-textbox" onenter="onKeyEnter" emptyText="请输入查询账号名" selectOnFocus="true" /> <a
          class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
      </tr>
    </table>
  </div>
  <div class="mini-fit">
    <div id="mainGrid" class="mini-datagrid" style="width: 100%; height: 100%" sizeList="[20,30,50]"
      pageSize="20" url="auth/user/sysUser/datagrid?showPager=true" idField="id" allowResize="true">
      <div property="columns">
        <div type="indexcolumn" width="5"></div>
        <div field="account" width="65" headerAlign="center" allowSort="true">帐号</div>
        <div field="status" width="30" headerAlign="center" renderer="onStatusRenderer">状态</div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var grid = mini.get("mainGrid");
      grid.load();

      function create() {
        OpenDialog("auth/user/sysUser/create", "新建", grid);
      }

      function changePassword() {
        var row = grid.getSelected();
        if (row) {
          OpenDialog("auth/user/sysUser/changePassword/" + row.id, "重置密码", grid);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }
      
      function changeStatus() {
        var row = grid.getSelected();
        if (row) {
          if (row.status == '1') {
            mini.confirm("确定停用记录？", "停用", function(action) {
              if (action == "ok") {
                SaveData("auth/user/sysUser/changeStatus/userId/" + row.id + "/status/0", "", function(e) {
                  ShowActionTip(e);
                  grid.reload();
                });
              }
            });
          } else {
            mini.confirm("确定启用记录？", "启用", function(action) {
              if (action == "ok") {
                SaveData("auth/user/sysUser/changeStatus/userId/" + row.id + "/status/1", "", function(e) {
                  ShowActionTip(e);
                  grid.reload();
                });
              }
            });
          }
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = grid.getSelected();
        if (row) {
          mini.confirm("确定删除记录？", "删除", function(action) {
            if (action == "ok") {
              SaveData("auth/user/sysUser/remove/" + row.id, "", function(e) {
                ShowActionTip(e);
                grid.reload();
              });
            }
          });
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

      var userStatus = 
      [ {
        id : 1,
        text : '启用'
      }, {
        id : 0,
        text : '停用'
      } ];
      function onStatusRenderer(e) {
        for (var i = 0, l = userStatus.length; i < l; i++) {
          var g = userStatus[i];
          if (g.id == e.value) {
            return g.text;
          }
        }
        return e.value;
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>