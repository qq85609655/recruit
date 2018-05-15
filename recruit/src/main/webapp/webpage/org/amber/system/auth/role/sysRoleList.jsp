<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>角色列表</title>
<style>
</style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>

  <div class="co">
    <div class="co-left">
      <jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    </div>
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span>
        <a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a>
        <em class="path-icon">&gt;&gt;</em>
        <span class="path-leaf">系统管理</span>
        <em class="path-icon">&gt;&gt;</em>
        <span class="path-leaf">角色列表</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">角色列表</div>
        <div class="blue radius">
          <div class="table-operate">
            <table style="width: 100%;">
              <tr>
                <td style="width: 100%;"><a class="mini-button" iconCls="icon-add" onclick="create"
                  plain="true">新建</a> <a class="mini-button" iconCls="icon-edit" onclick="modify"
                  plain="true">编辑</a> <a class="mini-button" iconCls="icon-remove" onclick="remove"
                  plain="true">删除</a></td>
                <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
                  class="mini-textbox" onenter="onKeyEnter" emptyText="请输入查询角色名称或编码" selectOnFocus="true" /> <a
                  class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
              </tr>
            </table>
          </div>
          <div id="mainGrid" class="mini-datagrid" style="height: 350px;" sizeList="[20,30,50]"
            pageSize="20" url="/recruit/auth/role/sysRole/datagrid?showPager=true" idField="id" allowResize="true">
            <div property="columns">
              <div type="indexcolumn" width="5"></div>
              <div field="name" width="25" headerAlign="center" allowSort="true">角色名称</div>
              <div field="role" width="25" headerAlign="center" allowSort="true">角色编码</div>
              <div field="description" width="25" headerAlign="center" allowSort="true">详细描述</div>
              <div field="enabled" width="20" headerAlign="center" renderer="onEnabledRenderer">状态</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <script>
      mini.parse();
      var grid = mini.get("mainGrid");
      grid.load();

      function create() {
        OpenDialog("/recruit/auth/role/sysRole/create", "新建", grid);
      }

      function modify() {
        var row = grid.getSelected();
        if (row) {
          OpenDialog("/recruit/auth/role/sysRole/modify/" + row.id, "编辑", grid);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = grid.getSelected();
        if (row) {
          mini.confirm("确定删除记录？", "删除", function(action) {
            if (action == "ok") {
              SaveData("/recruit/auth/role/sysRole/remove/" + row.id, "", function(e) {
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

      var enabledEnum = [ {
        id : 1,
        text : '启用'
      }, {
        id : 0,
        text : '停用'
      } ];
      function onEnabledRenderer(e) {
        for (var i = 0, l = enabledEnum.length; i < l; i++) {
          var g = enabledEnum[i];
          if (g.id == e.value) {
            return g.text;
          }
        }
        return e.value;
      }
    </script>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
</html>