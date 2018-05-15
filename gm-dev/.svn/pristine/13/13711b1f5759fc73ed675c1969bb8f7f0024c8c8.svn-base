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
      <strong>批量创建</strong> <input id="pro" class="mini-buttonedit searchbox" style="width: 180px;"
        onenter="onKeyEnter" onbuttonclick="onKeyEnter" /> <a class="mini-button"
        iconCls="icon-add" onclick="onAdd()" plain="true">上传</a> <a class="mini-button"
        iconCls="icon-remove" onclick="onDelete()" plain="true">删除</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input value="单一创建" type="button"
        onclick="create('raw')" />
    </div>
    <div id="fileList" class="mini-datagrid" style="width: 100%; height: 480px" allowResize="false"
      url="fileUpload/datagrid?showPager=true" idField="id" multiSelect="false" showPager="true"
      allowAlternating="true" sortField="createTime" sortOrder="desc" pageSize="20">
      <div property="columns">
        <div type="indexcolumn" width="20"></div>
        <div field="fileName" width="200" allowSort="true" align="left"">文档名</div>
        <div field="applicantCode" width="50" allowSort="true">申请人工号</div>
        <div field="applicantName" width="50" allowSort="true">申请人姓名</div>
        <div field="createTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="80"
          allowSort="true">上传时间</div>
        <div field="createName" width="50" allowSort="true">上传人姓名</div>
        <div field="remark" width="200" allowSort="true" align="left"">备注</div>
      </div>
    </div>

  </div>
  <script type="text/javascript">
      mini.parse();
      var grid = mini.get("fileList");
      grid.load();
      grid.sortBy("createTime", "desc");

      grid.on("drawcell", function(e) {
        var row = e.row, field = e.field;
        //超链接任务
        if (field == "fileName") {
          e.cellHtml = "";
          e.cellHtml += '<a class="report-link" href="fileUpload/download?id=' + row.id
              + '" target="_blank" style="text-decoration:underline;">' + row.fileName + '</a>';
        }
      });

      function onAdd() {
        mini.open({
          url : "fileUpload/create",
          title : "上传文档",
          width : 430,
          height : 270,
          allowResize : false,
          ondestroy : function(action) {
            grid.reload();
            //alert("添加失败！");
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
              url : "fileUpload/delete?id=" + row.id,
              dataType : "json",
              async : false,
              success : function(data) {
                grid.unmask();
                grid.reload();
                mini.alert(data.msg);
              },
              error : function(jqXHR, textStatus, errorThrown) {
                grid.unmask();
                //alert("删除失败！");
                mini.alert("抱歉，你没有权限操作！", "警告");
                //alert(jqXHR.responseText);
              }
            });
          });
        } else {
          mini.alert("请选中一条记录");
        }
      }
      function onKeyEnter(e) {
        var key = mini.get("pro").getText();
        grid.load({
          searchKey : key
        });
      }

      function create(type) {
        if (type == "raw") {
          mini.open({
            url : "rawMaterial/rawMaterial",
            title : "",
            width : 720,
            height : 600,
            allowResize : false,
            ondestroy : function(action) {
            }
          });
        }
      }
    </script>

  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>