<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>系统用户信息</title>
<script src="resources/plugins/miniui/boot.js"></script>
<style type="text/css">
html, body {
  margin: 0;
  padding: 0;
  border: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.errorText {
  color: red;
}
</style>
</head>
<body>
  <form id="mainForm" method="post">
    <input name="id" class="mini-hidden" />
    <input name="status" class="mini-hidden" />
    <div style="padding-left: 11px; padding-bottom: 5px;">
      <table style="table-layout: fixed;">
        <tr>
          <td>员工帐号：</td>
          <td><input name="account" class="mini-textbox" required="true" vtype="maxLength:32"
            emptyText="请输入帐号" onvalidation="accountValidation" /><label id="account_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input id="password" name="password" class="mini-password" 
            required="true" vtype="minLength:6" onvalidation="validErrorText" /><label id="password_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td>再次输入密码：</td>
          <td><input id="password2" name="password2" class="mini-password" 
            required="true" vtype="minLength:6" onvalidation="doublePasswordValidation" /><label id="password2_error"
            class="errorText"></label></td>
        </tr>
      </table>
    </div>
    <div id="dialogFooter" style="text-align: center; padding: 18px;">
      <a class="mini-button" onclick="onOk()" style="width: 60px; margin-right: 10px;">确定</a> <a
        class="mini-button" onclick="onCancel()" style="width: 60px; margin-left: 10px;">取消</a>
    </div>
  </form>
  <script>
      mini.parse();
      var form = new mini.Form("mainForm");

      function saveData() {

        form.validate();
        if (form.isValid() == false) {
          return;
        }

        $.ajax({
          url : "baseUserController/save",
          type : 'post',
          async : false,
          data : $("#mainForm").serialize(),
          dataType : "json",
          cache : false,
          success : function(data) {
            if (data.success) {
              CloseWindow(data);
            } else {
              mini.alert(data.msg);
            }
          },
          error : function(jqXHR, textStatus, errorThrown) {
            mini.alert(jqXHR.responseText);
            CloseWindow();
          }
        });
      }

      function onOk(e) {
        saveData();
      }

      function onCancel(e) {
        CloseWindow("close");
      }

      function CloseWindow(action) {
        if (action == "close" && form.isChanged()) {
          if (confirm("数据被修改了，是否先保存？")) {
            return false;
          }
        }
        if (window.CloseOwnerWindow) {
          return window.CloseOwnerWindow(action);
        } else {
          alert(action.msg);
          window.close();
        }
      }

      function doublePasswordValidation(e) {
        if (e.isValid) {
          var password1 = mini.get("password");
          var password2 = mini.get("password2");
          console.log(password1.getValue());
          console.log(password2.getValue());
          if (password1.getValue() != password2.getValue()) {
            e.errorText = "两次密码输入必须相同";
            e.isValid = false;
          }
        }
        validErrorText(e);
      }
      
      function accountValidation(e) {
        if (e.isValid) {
          var re = new RegExp("^[0-9a-zA-Z\_]+$");
          if (re.test(e.value) == false) {
            e.errorText = "账号只能包含字母、数字或下划线这几种字符";
            e.isValid = false;
          }
        }
        validErrorText(e);
      }

      // 作为统一的错误文本直接显示方法，需要有对应ID的_error Label标签配合
      function validErrorText(e) {
        var id = e.sender.name + "_error";
        var el = document.getElementById(id);
        if (el) {
          el.innerHTML = e.errorText;
        }
      }
    </script>
</body>
</html>