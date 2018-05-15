<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<%@ include file="/resources/context/jspBase.jsp"%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>学生资料信息模板导入</title>
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
        <td><input type="file" name="myFile" id="myFile"
          accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" /></td>
      </tr>
    </table>
  </form>
  <div style="text-align: right; padding: 10px;">
    <a class="mini-button" onclick="onOk" style="width: 60px; margin-right: 20px;">上传</a>

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
        var message = '${msg}';
        if ("" == message || message == null) {
          var messageId = mini.loading("正在导入中!");
          $("#form").ajaxSubmit({
            url : "/recruit/campusStudentController/importStudentInfoExcel",
            dataType : 'json', //数据格式为json
            success : function(data) {
              mini.hideMessageBox(messageId);
              alert(data.msg);
              window.Owner.datagrid.load();            
              CloseWindow();
            }
          });
        } else {
          alert(message);
          CloseWindow();
        }

      }
    </script>

</body>
</html>