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
  <div id="RoleMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="角色列表" region="center" showHeader="true" showCollapseButton="false"
      bodyStyle="overflow:hidden;">
      <div class="mini-fit">
        <div id="roleGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[20,30,50]" pageSize="20" url="auth/role/sysRole/datagrid?showPager=true"
          idField="id" selectOnLoad="true">
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
    <div showHeader="false" region="east" width="620" maxWidth="750" minWidth="450"
      bodyStyle="overflow:hidden;">
      <div id="ResourceMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
        <div title="菜单选择列表 " region="center" showHeader="false" showCollapseButton="false"
          bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td style="width: 100%;">资源(菜单)列表:&nbsp;<label id="resourceTitle"></label></td>
                <td style="white-space: nowrap; padding-right: 8px;"><a class="mini-button"
                  iconCls="icon-reload" plain="true" onclick="reloadCheckedMenu"></a> <a
                  class="mini-button" iconCls="icon-save" plain="true" onclick="saveMenu"></a></td>
              </tr>
            </table>
          </div>
          <div class="mini-fit">
            <ul id="resourceTree" class="mini-tree" style="width: 100%; height: 100%; padding: 8px;"
              showTreeIcon="true" textField="name" idField="id" parentField="parentId"
              resultAsTree="false" allowSelect="true" enableHotTrack="false" expandOnLoad="true"
              showCheckBox="true" checkRecursive="false" autoCheckParent="true"
              ondrawnode="onDrawNode">
            </ul>
          </div>
        </div>
        <div title="资源权限配置列表" showHeader="false" region="east" width="270" maxWidth="350"
          minWidth="150" showCollapseButton="false" bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td style="width: 100%;">权限配置列表:&nbsp;<label id="permissionTitle"></label></td>
                <td style="white-space: nowrap; padding-right: 8px;"><a class="mini-button"
                  iconCls="icon-edit" plain="true" onclick="editPermission">编辑权限</a></td>
              </tr>
            </table>
          </div>
          <div class="mini-fit">
            <div id="permissionList" class="mini-listbox" style="width: 100%; height: 100%"
              showCheckBox="false" showAllCheckBox="false" multiSelect="false">
              <div property="columns">
                <div header="权限名称" field="name"></div>
                <div header="权限标识符" field="permission"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var roleGrid = mini.get("roleGrid");
      var resourceTree = mini.get("resourceTree");
      var permissionList = mini.get("permissionList");

      roleGrid.load();

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

      function onDrawNode(e) {
        var tree = e.sender;
        var node = e.node;
        var isLeaf = tree.isLeaf(node);

        if (node.menuName != null && node.menuName != ""
            && node.showAsMenu == "1") {
          e.cellHtml = node.name + "(" + node.menuName + ")";
        } else {
          e.cellHtml = node.name + "*";
          e.nodeStyle = "text-decoration:underline;color:blue;";
          e.iconCls = "";
        }
        
        if (node.hasPermissions == "1") {
          e.cellHtml = ">>&nbsp;" + e.cellHtml;
        }
      }

      roleGrid.on("selectionchanged", function(e) {
        var role = e.selected;
        resourceTree.load("auth/resource/sysRoleResource/resource/checkedTree/"
            + role.id);
        $("#resourceTitle").text(role.name);

      });

      resourceTree.on("nodeselect", function(e) {
        var resource = e.node;
        var role = roleGrid.getSelected();
        if (role != null && resource != null) {
          loadPermissionList(role.id, resource.id);
          $("#permissionTitle").text(resource.name);
        } else {
          mini.alert("请选择需要配置权限的角色和资源");
        }
      });

      function saveMenu() {
        var role = roleGrid.getSelected();
        if (role) {
          var data = resourceTree.getCheckedNodes(true);
          var json = mini.encode(data);

          SaveData("auth/resource/sysRoleResource/saveMenu/roleId/" + role.id,
              {
                json : json
              }, ShowActionTip);
        } else {
          mini.alert("请选择需要配置菜单的角色");
        }
      }

      function reloadCheckedMenu() {
        var role = roleGrid.getSelected();
        if (role) {
          resourceTree
              .load("auth/resource/sysRoleResource/resource/checkedTree/"
                  + role.id);
        }
      }

      function editPermission() {
        var role = roleGrid.getSelected();
        var resource = resourceTree.getSelectedNode();
        
        if (role != null && resource != null) {
          OpenDialog("auth/permission/sysRoleResourcePermission/modify/roleId/"
              + role.id + "/resourceId/" + resource.id, "权限编辑-[" + role.name
              + "]-" + resource.name, null, 650, 400, function(e) {
            loadPermissionList(role.id, resource.id);
          });
        } else {
          mini.alert("请选择需要配置权限的角色和资源");
        }
      }

      function loadPermissionList(roleId, resourceId) {
        permissionList
            .load("auth/permission/sysRoleResourcePermission/roleResourcePerms/roleId/"
                + roleId + "/resourceId/" + resourceId);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>