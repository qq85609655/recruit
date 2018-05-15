<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>初版任务导入</title>
<%@ include file="/resources/context/headResource.jsp"%>
<script src="resources/js/jquery.form.js"></script>

<style>
html, body {
  overflow: hidden;
  /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <form id="form" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <th style="width: 100px;"><img src="resources/images/xls.gif" width="20" height="20" /></th>
        <td><a href="/recruit/campusTaskController/temple" target="_blank"
          style="text-decoration: underline;">下载模板</a></td>
      </tr>
      <tr>
        <th>导入Excel文件：</th>
        <td><input type="file" name="myFile" id="myFile"
          accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" /></td>
      </tr>
    </table>
  </form>
  <div style="text-align: center; padding: 10px;">
    <a class="mini-button" onclick="onOk" style="width: 60px; margin-right: 20px;">导入</a> <a
      class="mini-button" onclick="CloseWindow('cancel')" style="width: 60px;">取消</a>
  </div>
  <%@ include file="/resources/context/lazyResource.jsp"%>

  <script type="text/javascript">
      mini.parse();
      function onOk(e) {
        var form = new mini.Form("form");
        form.validate();
        if (form.isValid() == false)
          return;
        if ($("#myFile").val() == "") {
          alert("上传文件不能为空！");
          $("#myFile").focus();
          return;
        }
        var messageId = mini.loading("正在导入中!");
        $("#form").ajaxSubmit({
          url : "/recruit/campusTaskFirstController/excelImport",
          dataType : 'json', //数据格式为json
          success : function(data) {
            mini.hideMessageBox(messageId);
            window.Owner.datagrid.load();
            CloseWindow();
            alert(data.msg);
          }
        });
      }
    </script>

</body>
</html>
