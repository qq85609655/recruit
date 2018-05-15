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
          plain="true">删除</a></td>
        <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
          class="mini-textbox" onenter="onKeyEnter" emptyText="请输入查询组名" selectOnFocus="true" /> <a
          class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
      </tr>
    </table>
  </div>
  <div class="mini-fit">
    <div id="mainTreeGrid" class="mini-treegrid" style="width: 100%; height: 100%"
      url="auth/group/sysGroup/datagrid" treeColumn="name" idField="id" parentField="parentId"
      resultAsTree="false" allowResize="true" expandOnLoad="true">
      <div property="columns">
        <div type="indexcolumn" width="5"></div>
        <div name="name" field="name" width="65" headerAlign="center">组名称</div>
        <div field="enabled" width="30" headerAlign="center" renderer="onEnabledRenderer">状态</div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var tree = mini.get("mainTreeGrid");
      tree.load();

      function create() {
        var row = tree.getSelected();
        if (row) {
          OpenDialog("auth/group/sysGroup/create/" + row.id, "新建", tree);
        } else {
          OpenDialog("auth/group/sysGroup/create/0", "新建", tree);
        }
        
      }

      function modify() {
        var row = tree.getSelected();
        if (row) {
          OpenDialog("auth/group/sysGroup/modify/" + row.id, "编辑", tree);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = tree.getSelected();
        if (row) {
          mini.confirm("确定删除记录？<br><span style='color:red;'>删除会将所有该组的子组一起删除！</span>", "删除", function(action) {
            if (action == "ok") {
              SaveData("auth/group/sysGroup/remove/" + row.id, "", function(e) {
                ShowActionTip(e);
                tree.reload();
              });
            }
          });
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function search() {
        var searchKey = mini.get("searchKey").getValue();
        tree.load({
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
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>