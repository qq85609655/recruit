<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>组角色列表</title>
<%@ include file="/resources/context/headResource.jsp"%>
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
        <span class="path-leaf">组角色列表</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">组角色列表</div>
        <div class="blue radius">
          
          <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 600px;">
            <div title="center" region="center" bodyStyle="overflow:hidden;">
              <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
                <table style="width: 100%;">
                  <tr>
                    <td style="width: 100%;"><a class="mini-button" iconCls="icon-edit"
                      onclick="modify" plain="true">编辑组角色</a></td>
                    <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
                      class="mini-textbox" onenter="onKeyEnter" emptyText="请输入查询组名" selectOnFocus="true" />
                      <a class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
                  </tr>
                </table>
              </div>
              <div class="mini-fit">
                <div id="mainTreeGrid" class="mini-treegrid" style="width: 100%; height: 100%"
                  url="/recruit/auth/group/sysGroup/datagrid" treeColumn="name" idField="id" parentField="parentId"
                  resultAsTree="false" allowResize="true" expandOnLoad="true" selectOnLoad="true">
                  <div property="columns">
                    <div type="indexcolumn" width="5"></div>
                    <div name="name" field="name" width="65" headerAlign="center">组名称</div>
                    <div field="enabled" width="30" headerAlign="center" renderer="onEnabledRenderer">状态</div>
                  </div>
                </div>
              </div>
            </div>
            <div showHeader="false" region="east" width="400" maxWidth="500" minWidth="300"
              bodyStyle="overflow:hidden;">
              <div id="roleGrid" class="mini-datagrid" style="width: 100%; height: 100%" treeColumn="name"
                idField="id" url="/recruit/auth/role/sysGroupRole/groupRoles" allowResize="true" showPager="false">
                <div property="columns">
                  <div field="name" width="40" headerAlign="center" allowSort="true">角色名称</div>
                  <div field="role" width="40" headerAlign="center" allowSort="true">角色编码</div>
                  <div field="enabled" width="20" headerAlign="center" renderer="onEnabledRenderer">状态</div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

  <script>
      mini.parse();
      var tree = mini.get("mainTreeGrid");
      tree.load();

      var roleGird = mini.get("roleGrid");

      function modify() {
        var row = tree.getSelected();
        if (row) {
          OpenDialog("/recruit/auth/group/sysGroup/groupRole/modify/" + row.id, "编辑", tree,
              650, 400);
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

      tree.on("selectionchanged", function(e) {
        var groupGrid = e.sender;
        var record = groupGrid.getSelected();
        roleGird.load({
          groupId : record.id
        });
      });
    </script>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
</html>