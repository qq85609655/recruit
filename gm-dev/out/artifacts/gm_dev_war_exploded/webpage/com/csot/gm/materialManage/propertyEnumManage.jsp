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
<div class="mini-splitter" style="width: 100%; height: 100%;">
    <div size="240" showCollapseButton="true">
      <div class="mini-toolbar"
        style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
        <input id="key" class="mini-textbox" onenter="onKeyEnter"/> 
        <a class="mini-button" iconCls="icon-search" plain="true" onclick="searchRaw()" >查找</a>
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
            <td style="width: 100%;"><a class="mini-button" iconCls="icon-edit" onclick="modify"
              plain="true">编辑</a></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="datagrid1" class="mini-datagrid" style="width:96%;height:660px;" 
            url="materialManage/propertyEnumDatagrid"  idField="id" allowResize="true" sizeList="[20,30,50,100]" pageSize="20">
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div field="propertyName" width="120" headerAlign="center" allowSort="true">属性名称</div>    
                <div field="enumTypeName" width="120" headerAlign="center" allowSort="true">枚举类名</div>                            
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
        
        rawTree.on("nodeselect", function(e) {
          if (e.isLeaf) {
            OpenDialog("partProperties/create/" + e.node.id, "新建", proDataGrid);
          } else {
            ShowWarnTip("请选择一条属性");
          }
        });
        
      }

      function modify() {
        var row = proDataGrid.getSelected();
        if (row) {
          OpenDialog("propertiesM/propertyEnumTypeEdit/" + row.propertyId, "编辑", proDataGrid);
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

    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>