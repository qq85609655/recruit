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
  <div class="mini-toolbar" style="text-align: center; line-height: 30px;"
    borderStyle="border-left:0;border-top:0;border-right:0;">
    <label>名称：</label> <input id="key" class="mini-textbox" style="width: 150px;"
      onenter="onKeyEnter" /> <a class="mini-button" style="width: 60px;" onclick="search()">查询</a>
  </div>
  <div class="mini-fit">

    <ul id="treeList" class="mini-tree" style="width: 100%; height: 100%;"
      url="auth/group/sysGroup/datagrid" showTreeIcon="true" textField="name" idField="id"
      parentField="parentId" resultAsTree="false" expandOnLoad="true"
      onnodedblclick="onNodeDblClick" expandOnDblClick="false">
    </ul>

  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var tree = mini.get("treeList");
      tree.load();

      function GetData() {
        var node = tree.getSelectedNode();
        return node;
      }

      function search() {
        var key = mini.get("key").getValue();
        if (key == "") {
          tree.clearFilter();
        } else {
          key = key.toLowerCase();
          tree.filter(function(node) {
            var text = node.name ? node.name.toLowerCase() : "";
            if (text.indexOf(key) != -1) {
              return true;
            }
          });
        }
      }

      function onKeyEnter(e) {
        search();
      }

      function onNodeDblClick(e) {
        onOk();
      }

      function onOk() {
        CloseWindow("ok");
      }

      function onCancel() {
        CloseWindow("cancel");
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>