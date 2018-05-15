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
      <input name="id" value="${testUser.id}" class="mini-hidden" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">名称:</td>
          <td class="formContent"><input id="name" name="name" class="mini-textbox"
            value="${testUser.name}" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">家庭地址:</td>
          <td class="formContent"><input id="address" name="address" class="mini-textbox"
            value="${testUser.address }" /><label id="address_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">出生日期:</td>
          <td class="formContent"><input id="birthday" name="birthday" class="mini-datepicker"
            format="yyyy-MM-dd HH:mm:ss" timeFormat="HH:mm:ss" showTime="true" valueType="date"
            allowInput="false" value="${testUser.birthday }" /><label id="birthday_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">年龄:</td>
          <td class="formContent"><input id="age" name="age" class="mini-textbox"
            value="${testUser.age }" /><label id="age_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">工资:</td>
          <td class="formContent"><input id="salary" name="salary" class="mini-textbox"
            value="${testUser.salary }" /><label id="salary_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">工作地址:</td>
          <td class="formContent"><input id="workPlace" name="workPlace" class="mini-textbox"
            value="${testUser.workPlace }" /><label id="workPlace_error" class="errorText"></label></td>
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

        SaveData("testUserController/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>