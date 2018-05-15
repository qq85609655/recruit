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
<script>
  var userStatus = [ {id : 1, text : '启用'}, {id : 0, text : '停用'} ];
</script>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post">
      <input name="id" class="mini-hidden" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">账号:</td>
          <td class="formContent"><input name="account" class="mini-textbox" required="true" vtype="maxLength:32"
            emptyText="请输入帐号" onvalidation="accountValidation" /><label id="account_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">密码:</td>
          <td class="formContent"><input id="password" name="password" class="mini-password" 
            required="true" vtype="minLength:3" onvalidation="ValidErrorText" /><label id="password_error"
            class="errorText"></label></label></td>
        </tr>
        <tr>
          <td class="formLabel">确认密码:</td>
          <td class="formContent"><input id="password2" name="password2" class="mini-password" 
            required="true" vtype="minLength:3" onvalidation="doublePasswordValidation" /><label id="password2_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">状态:</td>
          <td class="formContent"><div id="status" name="status" class="mini-radiobuttonlist"
              repeatItems="1" repeatLayout="table" repeatDirection="vertical" textField="text"
              valueField="id" value="1" data="userStatus"></div>
            <label id="status_error" class="errorText"></label></td>
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

        SaveData("auth/user/sysUser/save", $("#mainForm").serialize());
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
      
      function accountValidation(e) {
        if (e.isValid) {
          var re = new RegExp("^[0-9a-zA-Z\_\.]+$");
          if (re.test(e.value) == false) {
            e.errorText = "账号只能包含字母、数字、下划线或英文的点这几种字符";
            e.isValid = false;
          }
        }
        ValidErrorText(e);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>