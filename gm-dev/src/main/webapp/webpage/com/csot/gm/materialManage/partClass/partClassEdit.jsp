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
      <input name="id" class="mini-hidden" value="${partClass.id}" /> <input name="parentId"
        class="mini-hidden" value="${partClass.parentId}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">分类名称:</td>
          <td class="formContent"><input name="classDesc" class="mini-textbox" required="true"
            value="${partClass.classDesc}" style="width: 300px" allowInput="true"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">排列顺序:</td>
          <td class="formContent"><input name="sortId" class="mini-textbox" required="true"
            value="${partClass.sortId}" style="width: 300px" allowInput="true"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
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

        SaveData("partClass/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>