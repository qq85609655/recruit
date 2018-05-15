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
      <input name="id" class="mini-hidden" value="${sysUser.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">账号:</td>
          <td class="formContent">${sysUser.account}</td>
        </tr>
        <tr>
          <td class="formLabel">密码:</td>
          <td class="formContent"><input id="password" name="password" class="mini-password"
            required="true" vtype="minLength:3" onvalidation="ValidErrorText" /><label
            id="password_error" class="errorText"></label></label></td>
        </tr>
        <tr>
          <td class="formLabel">确认密码:</td>
          <td class="formContent"><input id="password2" name="password2" class="mini-password"
            required="true" vtype="minLength:3" onvalidation="doublePasswordValidation" /><label
            id="password2_error" class="errorText"></label></td>
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

        SaveData("auth/user/sysUser/savePassword", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

      function doublePasswordValidation(e) {
        if (e.isValid) {
          var password1 = mini.get("password");
          var password2 = mini.get("password2");
          if (password1.getValue() != password2.getValue()) {
            e.errorText = "两次密码输入必须相同";
            e.isValid = false;
          }
        }
        ValidErrorText(e);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>