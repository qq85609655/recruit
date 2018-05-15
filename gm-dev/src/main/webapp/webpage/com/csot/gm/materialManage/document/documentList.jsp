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

  <div class="table-header" style="border-bottom: 0; width: 100%">
    <div style="border-bottom: 0; width: 100%; height: 30px">
    <input id="searchKey" class="mini-textbox" onenter="search()" emptyText="请输入文档名称" selectOnFocus="true" />
      <a class="mini-button" iconCls="icon-search" plain="true" onclick="search()">查询</a>
      <a class="mini-button" iconCls="icon-add" onclick="onAdd()" plain="true">上传</a> 
      <a class="mini-button" iconCls="icon-remove" onclick="onDelete()" plain="true">删除</a>
    </div>
    <div id="fileList" class="mini-datagrid" style="width: 100%; height: 480px" allowResize="false"
      url="document/datagrid" idField="id" multiSelect="false" showPager="true"
      allowAlternating="true" pageSize="20">
      <div property="columns">
        <div type="indexcolumn" width="20"></div>
        <div field="fileName" width="200" allowSort="true">文档名称</div>
        <div field="uploader" width="50" allowSort="true">上传人</div>
        <div field="uploadTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="80"
          allowSort="true">上传时间</div>
        <div field="remark" width="100" allowSort="true" align="left"">备注</div>
      </div>
    </div>

  </div>
  <script type="text/javascript">
      mini.parse();
      var grid = mini.get("fileList");
      grid.load();
      grid.on("drawcell", function(e) {
        var row = e.row, field = e.field;
        //超链接任务
        if (field == "fileName") {
          e.cellHtml = "";
          // 下载
          e.cellHtml += '<a class="report-link" href="document/loadFile/' + row.id
              + '" target="_blank" style="text-decoration:underline;">' + row.fileName + '</a>';
          // 预览
          /* e.cellHtml += '<a class="report-link" href="document/browseFile/' + row.id 
          + '" target="_blank" >[预览]</a>'; */
        }
      });

      function onAdd() {
        mini.open({
          url : "document/uploadFile",
          title : "上传文档",
          width : 430,
          height : 270,
          allowResize : false,
          ondestroy : function(action) {
            grid.reload();
          }
        });
      }

      function onDelete() {
        var row = grid.getSelected();
        if (row) {
          mini.confirm("确定删除选中文件吗？", "提示", function(action) {
            if (action != "ok")
              return;
            grid.loading("操作中，请稍后......");
            
            $.ajax({
              url : "document/remove/" + row.id,
              dataType : "json",
              async : false,
              success : function(data) {
                grid.unmask();
                grid.reload();
                mini.alert(data.msg);
              },
              error : function(jqXHR, textStatus, errorThrown) {
                grid.unmask();
                mini.alert("抱歉，你没有权限操作！", "警告");
              }
            });
          });
        } else {
          mini.alert("请选中一条记录");
        }
      }
      
      function search() {
        var key = mini.get("searchKey");
        var data = key.getValue();
        grid.load({
          fileName : data
        });
      }

    </script>

  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>