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
  <div class="mini-fit">
    <table cellpadding="0" cellspacing="0" style="margin: auto 10px;">
      <tr>
        <td colspan="4" style="text-align:center;line-height:23px;padding:5px;">
          <span>权限名称or标识符：</span>    
            <input id="keyText" class="mini-textbox" style="width:160px;" onenter="onSearchClick"/>
            <a class="mini-button" onclick="onSearchClick" style="width:60px;height:20px;">查找</a>
            <a class="mini-button" onclick="onClearClick" style="width:60px;height:20px;">清除</a>
        </td>
      </tr>
      <tr>
        <td>
          <h3>权限操作列表</h3>
          <div id="mainGrid" class="mini-datagrid" style="width: 250px; height: 200px;"
            sizeList="[20,30,50]" pageSize="20"
            url="auth/permission/sysPermission/datagrid?showPager=true&enabled=1" idField="id"
            allowResize="false" multiSelect="true">
            <div property="columns">
              <div type="checkcolumn" width="10"></div>
              <div field="name" width="45" headerAlign="center" allowSort="true">权限名称</div>
              <div field="permission" width="45" headerAlign="center" allowSort="true">权限标识符</div>
            </div>
          </div>
        </td>
        <td style="width: 60px; text-align: center;"><a class="mini-button" onclick="addOne">&gt;</a><br>
          <a class="mini-button" onclick="removeOne">&lt;</a></td>
        <td>
          <h3>已选权限操作</h3>
          <div id="selectedList" class="mini-listbox" style="width: 250px; height: 200px;"
            showCheckBox="true" multiSelect="true" valueField="id"
            url="auth/permission/sysRoleResourcePermission/roleResourcePerms/roleId/${roleId}/resourceId/${resourceId}">
            <div property="columns">
              <div field="name" width="45" headerAlign="center" allowSort="true">权限名称</div>
              <div field="permission" width="45" headerAlign="center" allowSort="true">权限标识符</div>
            </div>
          </div>
        </td>
        <td style="width: 60px; text-align: center;"><a class="mini-button" onclick="addAll">&gt;&gt;</a><br>
          <a class="mini-button" onclick="removeAll">&lt;&lt;</a></td>
      </tr>
    </table>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var selectedList = mini.get("selectedList");
      var grid = mini.get("mainGrid");
      var keyText = mini.get("keyText");
      grid.load();

      function onOk(e) {
        var data = selectedList.getData();
        var json = mini.encode(data);

        SaveData(
            "auth/permission/sysRoleResourcePermission/save/roleId/${roleId}/resourceId/${resourceId}",
            {
              json : json
            });
      }

      function onCancel(e) {
        CloseWindow("close");
      }

      function doAddItems(items) {
        items = mini.clone(items);

        //根据id属性，来甄别要加入选中的记录
        var idField = grid.getIdField();

        //把已选中的数据，用key-value缓存，以便进一步快速匹配
        var idMaps = {};
        var selecteds = selectedList.getData();
        for (var i = 0, l = selecteds.length; i < l; i++) {
          var o = selecteds[i];
          var id = o[idField];
          idMaps[id] = o;
        }

        //遍历要加入的数组
        for (var i = items.length - 1; i >= 0; i--) {
          var o = items[i];
          var id = o[idField];
          if (idMaps[id] != null)
            items.removeAt(i);
        }

        selectedList.addItems(items);
      }

      function addOne() {
        var items = grid.getSelecteds();
        doAddItems(items);
      }

      function addAll() {
        var items = grid.getData();
        doAddItems(items);
      }

      function removeOne() {
        var items = selectedList.getSelecteds();
        selectedList.removeItems(items);
      }

      function removeAll() {
        selectedList.removeAll();
      }
      
      grid.on("rowdblclick", function(e) {
        var addItem = e.record;
        doAddDblItem(addItem);
      });

      selectedList.on("itemdblclick", function(e) {
        selectedList.removeItem(e.item);
      });

      function doAddDblItem(item) {
        item = mini.clone(item);

        //根据id属性，来甄别要加入选中的记录
        var idField = grid.getIdField();

        //遍历查看要加入的item是否已经被选中
        var id = item[idField];
        var selecteds = selectedList.getData();
        for (var i = 0, l = selecteds.length; i < l; i++) {
          var o = selecteds[i];
          var selectedId = o[idField];
          if (selectedId == id) {
            return;
          }
        }

        selectedList.addItem(item);
      }
      
      function onSearchClick(e) {
        grid.load({
          searchKey : keyText.value
        });
      }
      
      function onClearClick(e) {
        grid.load();
        keyText.setValue("");
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>