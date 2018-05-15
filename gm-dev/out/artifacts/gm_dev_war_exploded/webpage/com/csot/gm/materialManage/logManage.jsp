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
  <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="center" region="center" bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
        <table style="width: 100%;">
          <tr>
            <!-- <td style="width: 100%;"><a class="mini-button" iconCls="icon-remove"
              onclick="remove" plain="true">删除</a></td> -->
            <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
              class="mini-textbox" onenter="onKeyEnter" emptyText="请输入操作内容" selectOnFocus="true" />
              <a class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="logGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[25,50,100]" pageSize="25" url="log/datagrid?showPager=true" idField="id"
          allowResize="true" multiSelect="true">
          <div property="columns">
            <div type="checkcolumn" width="10"></div>
            <div field="userName" width="25" headerAlign="center" allowSort="true">用户</div>
            <div field="operation" width="25" headerAlign="center" allowSort="true">操作</div>
            <div field="content" width="200" headerAlign="center" allowSort="true">内容</div>
            <div field="createTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="100" allowSort="true">操作时间</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var logGrid = mini.get("logGrid");
      logGrid.load();
      logGrid.sortBy("createTime", "desc");
      
      function remove() {
        var rows = logGrid.getSelecteds();
        if (rows.length > 0) {
            if (confirm("确定删除选中记录？")) {
                var ids = [];
                for (var i = 0, l = rows.length; i < l; i++) {
                    var r = rows[i];
                    ids.push(r.id);
                }
                var id = ids.join(',');
                logGrid.loading("操作中，请稍后......");
                SaveData("log/remove/" + id, "", function(e) {
                  ShowActionTip(e);
                  logGrid.reload();
                });
            }
        } else {
            alert("请选中一条记录");
        }
    }

      function search() {
        var searchKey = mini.get("searchKey").getValue();
        logGrid.load({
          searchKey : searchKey
        });
      }

      function onKeyEnter(e) {
        search();
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>