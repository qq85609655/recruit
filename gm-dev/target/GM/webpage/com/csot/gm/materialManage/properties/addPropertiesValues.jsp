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
    <form id="mainForm" class="mainform" method="post">
      <input id="partId" class="mini-hidden" value="${partId}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">属性真实名称:</td>
          <td class="formContent"><input id="propertyName" class="mini-textbox" required="true"
            value="" onvalidation="ValidErrorText" /><label id="name_error1" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">属性真实值:</td>
          <td class="formContent"><input id="propertyValue" class="mini-textbox" required="true"
            value="" onvalidation="ValidErrorText" /><label id="name_error2" class="errorText"></label></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var form = new mini.Form("#mainForm");

      function onOk(e) {
        form.validate();
        if (form.isValid() == false) {
          return;
        }
        var partId = mini.get("partId").getValue();
        var propertyName = mini.get("propertyName").getValue();
        var propertyValue = mini.get("propertyValue").getValue();
        
        var messageId = mini.loading("正在更新中!");
        $.ajax({
          url : "propertyValue/addPropertyValues",
          type : "post",
          data : {
            partId : partId,
            propertyName : propertyName,
            propertyValue : propertyValue
          },
          dataType : 'json',
          success : function(data) {
            mini.hideMessageBox(messageId);
            mini.alert(data.msg, "提示");
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>