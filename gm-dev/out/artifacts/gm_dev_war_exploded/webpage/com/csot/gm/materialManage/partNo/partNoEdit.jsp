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
      <input name="id" class="mini-hidden" value="${partNo.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">料号:</td>
          <td class="formContent"><input name="partNo" class="mini-textbox" required="true"
            value="${partNo.partNo}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">物料名称:</td>
          <td class="formContent"><input name="partName" class="mini-textbox" required="true"
            value="${partNo.partName}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">中文描述:</td>
          <td class="formContent"><input name="cnDesc" class="mini-textbox" required="true"
            value="${partNo.cnDesc}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">英文描述:</td>
          <td class="formContent"><input name="enDesc" class="mini-textbox" required="true"
            value="${partNo.enDesc}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">料号状态:</td>
          <td class="formContent"><input name="partNoStatus" class="mini-textbox" required="true"
            value="${partNo.partNoStatus}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">创建时间:</td>
          <td class="formContent"><input name="createTime" class="mini-textbox" required="true"
            value="${partNo.createTime}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">创建人厂别:</td>
          <td class="formContent"><input name="plant" class="mini-textbox" required="true"
            value="${partNo.plant}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        </tr>
        <tr>
          <td class="formLabel">创建人部门:</td>
          <td class="formContent"><input name="department" class="mini-textbox" required="true"
            value="${partNo.department}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">创建人姓名:</td>
          <td class="formContent"><input name="createName" class="mini-textbox" required="true"
            value="${partNo.createName}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">创建人工号:</td>
          <td class="formContent"><input name="createCode" class="mini-textbox" required="true"
            value="${partNo.createCode}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">创建人联系方式:</td>
          <td class="formContent"><input name="telephone" class="mini-textbox" required="true"
            value="${partNo.telephone}" style="width:350px" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onCancel()">确定</a>
  </div>
  <script>
      mini.parse();
      var form = new mini.Form("#mainForm");
      function onCancel(e) {
        CloseWindow("close", form);
      }

    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>