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
<script src="${basePath}resources/js/ajaxfileupload.js"></script>
</head>
<body>
  <div class="mini-splitter" style="width: 100%; height: 100%;">
    <div size="240" showCollapseButton="true">
      <div class="mini-toolbar"
        style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
        <input id="key" class="mini-textbox" onenter="onKeyEnter" /> <a class="mini-button"
          iconCls="icon-search" plain="true" onclick="searchRaw()">查找</a>
      </div>
      <div class="mini-fit">
        <ul id="rawTree" class="mini-tree" url="rawMaterial/partClassTree" style="width: 100%;"
          showTreeIcon="true" textField="name" idField="id" parentField="parentId"
          resultAsTree="false">
        </ul>
      </div>
    </div>

    <div showCollapseButton="true">
      <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
        <table style="width: 100%;">
          <tr>
            <td style="width: 100%;"><a class="mini-button" iconCls="icon-add" onclick="create"
              plain="true">新增</a> <a class="mini-button" iconCls="icon-edit" onclick="modify"
              plain="true">编辑</a> <a class="mini-button" iconCls="icon-remove" onclick="remove"
              plain="true">删除</a> <a class="mini-button" iconCls="icon-upload"
              onclick="uploadPart('property')" plain="true">物料属性导入</a> <input id="excelDoc"
              name="excelDoc" type="file" /> <a class="mini-button" iconCls="icon-print"
              onclick="addHistDataProValue()" plain="true">历史料新增属性值</a></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="datagrid1" class="mini-datagrid" style="width: 96%; height: 660px;"
          url="materialManage/propertyDatagrid" idField="id" allowResize="true"
          sizeList="[20,30,50,100]" pageSize="20">
          <div property="columns">
            <div type="indexcolumn"></div>
            <div field="partName" width="120" headerAlign="center" allowSort="true">物料名称</div>
            <div field="propertyName" width="120" headerAlign="center" allowSort="true">属性真实名称</div>
            <div field="propertyDisName" width="120" headerAlign="center" allowSort="true">属性显示名称</div>
            <div field="propertyUnit" width="120" headerAlign="center" allowSort="true">属性单位</div>
            <div field="isUnique" width="120" headerAlign="center" allowSort="true">是否唯一性</div>
            <div field="isEnum" width="120" headerAlign="center" allowSort="true">是否下拉</div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
      mini.parse();
      var proDataGrid = mini.get("datagrid1");
      var rawTree = mini.get("rawTree");

      rawTree.on("nodeselect", function(e) {
        var pn = rawTree.getParentNode(e.node);
        if (e.isLeaf) {
          proDataGrid.load({
            partId : e.node.id
          });
        } else {
          proDataGrid.setData([]);
          proDataGrid.setTotalCount(0);
        }
      });

      function create() {
        var row = rawTree.getSelected();
        var partId = row.id;
        OpenDialog("partProperties/create/" + partId, "新建", proDataGrid);

      }

      function modify() {
        var row = proDataGrid.getSelected();
        if (row) {
          OpenDialog("partProperties/modify/" + row.propertyId, "编辑", proDataGrid);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = proDataGrid.getSelected();
        if (row) {

          mini.confirm("确定删除记录？<br>", "删除", function(action) {
            if (action == "ok") {
              SaveData("partProperties/remove/" + row.propertyId, "", function(e) {
                ShowActionTip(e);
                proDataGrid.reload();
              });
            }
          });

        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function searchRaw() {
        var key = mini.get("key").getValue();
        if (key == "") {
          rawTree.clearFilter();
        } else {
          key = key.toLowerCase();
          rawTree.filter(function(node) {
            var text = node.name ? node.name.toLowerCase() : "";
            if (text.indexOf(key) != -1) {
              return true;
            }
          });
          rawTree.expandAll();
        }
      }

      function onKeyEnter(e) {
        searchRaw();
      }

      function uploadPart(level) {
        var file = $("#excelDoc").val();
        if (!file) {
          mini.alert("请选择需上传的文件!");
        } else {
          var messageId = mini.loading("正在导入中!");
          $.ajaxFileUpload({
            url : "materialManage/upload/" + level,
            secureuri : false,
            fileElementId : 'excelDoc',
            dataType : "json",
            data : null,
            success : function(data) {
              mini.hideMessageBox(messageId);
              rawTree.reload();
              mini.alert(data.msg, "提示");
            },
            error : function(data) {
              mini.alert(data.msg, "提示");
            }
          });
        }
      }

      // level3新增属性之后，给历史数据新增属性值
      function addHistDataProValue() {
        var node = rawTree.getSelectedNode();
        if (node && (rawTree.isLeaf(node))) {
          OpenDialog("partProperties/addProValue/" + node.id, "新增", proDataGrid);
        } else {
          ShowWarnTip("请选择level3操作");
        }
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>