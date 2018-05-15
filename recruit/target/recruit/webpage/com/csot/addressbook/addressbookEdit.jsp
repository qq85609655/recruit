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
      <input name="id" class="mini-hidden" value="${addressbook.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">姓名:</td>
          <td class="formContent"><input name="personName" class="mini-textbox" required="true"
            value="${addressbook.personName}" style="width: 180px" allowInput="true"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">公司:</td>
          <td class="formContent"><input name="company" class="mini-textbox" required="true"
            value="${addressbook.company}" style="width: 180px" allowInput="true"
            onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">组织:</td>
          <td class="formContent"><input name="organization" class="mini-textbox"
            required="true" value="${addressbook.organization}" style="width: 180px"
            allowInput="true" onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">职位:</td>
          <td class="formContent"><input name="currentPosition" class="mini-textbox"
            required="true" value="${addressbook.currentPosition}" style="width: 180px"
            allowInput="true" onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">职能:</td>
          <td class="formContent"><input name="remark" class="mini-textbox" required="true"
            value="${addressbook.remark}" style="width: 180px" allowInput="true"
            onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">邮箱:</td>
          <td class="formContent"><input name="email" class="mini-textbox" vtype="email"
            required="true" value="${addressbook.email}" style="width: 180px" allowInput="true"
            onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">手机:</td>
          <td class="formContent"><input name="phoneNo" class="mini-textbox" required="true"
            value="${addressbook.phoneNo}" style="width: 180px" allowInput="true"
            onvalidation="ValidErrorText" /></td>
        </tr>
        <tr>
          <td class="formLabel">固话:</td>
          <td class="formContent"><input name="tellphoneNo" class="mini-textbox"
            required="true" value="${addressbook.tellphoneNo}" style="width: 180px"
            allowInput="true" onvalidation="ValidErrorText" /></td>
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
        SaveData("/recruit/addressbookController/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>