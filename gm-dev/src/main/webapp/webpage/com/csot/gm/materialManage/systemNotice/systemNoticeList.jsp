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
  <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="center" region="center" bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="border-bottom: 0; padding: 0px;">
        <table style="width: 100%;">
          <tr>
            <td style="width: 100%;"><a class="mini-button" iconCls="icon-add"
              onclick="add()" plain="true" tooltip="新增">新增</a> <a
              class="mini-button" iconCls="icon-remove" onclick="remove()" plain="true">删除</a> <a
              class="mini-button" iconCls="icon-edit" onclick="modify()" plain="true">编辑</a> </td>
            <td style="white-space: nowrap;"><input id="key" class="mini-textbox" emptyText=""
              style="width: 150px;" onenter="onKeyEnter" /> <a class="mini-button"
              onclick="search()">查询</a></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="noticeGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[25,50,100]" pageSize="25" url="systemNotice/datagrid?showPager=true" idField="id"
          allowResize="true">
          <div property="columns">
            <div type="indexcolumn" width="2"></div>
            <div field="noticeTitle" width="100" headerAlign="center" allowSort="true">标题</div>
            <div field="updateTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="50" allowSort="true">更新时间</div>
            <div field="noticeLevel" width="25" headerAlign="center" allowSort="true">位置</div>
            <div field="isActive" width="25" headerAlign="center" allowSort="true">状态</div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
      mini.parse();
      var noticeGrid = mini.get("noticeGrid");
      noticeGrid.load();
      function add () {
        OpenDialog("systemNotice/create", "新建", noticeGrid, 600, 460);
      }
      
      function modify () {
        var row = noticeGrid.getSelected();
        if (row) {
          OpenDialog("systemNotice/modify/" + row.id, "编辑", noticeGrid, 600, 460);
        } else {
          ShowWarnTip("请选择一条公告");
        }
      }
      
      function remove () {
        var row = noticeGrid.getSelected();
        if (row) {
          mini.confirm("确定删除公告？<br>", "删除", function(action) {
            if (action == "ok") {
              SaveData("systemNotice/remove/" + row.id, "", function(e) {
                ShowActionTip(e);
                noticeGrid.reload();
              });
            }
          });
        } else {
          ShowWarnTip("请选择一条公告");
        }
      }

    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>