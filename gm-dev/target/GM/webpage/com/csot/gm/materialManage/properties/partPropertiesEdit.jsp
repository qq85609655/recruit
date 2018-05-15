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
      <input name="partId" class="mini-hidden" value="${pp.partId}" />
      <input name="id" class="mini-hidden" value="${pp.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">物料名称:</td>
          <td class="formContent"><input name="partName" class="mini-textbox" required="true"
            value="${partName}" vtype="maxLength:80" allowInput="false"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">属性真实名称:</td>
          <td class="formContent"><input name="propertyName" class="mini-textbox" required="true"
            value="${pp.propertyName}"  
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">属性显示名称:</td>
          <td class="formContent"><input name="propertyDisName" class="mini-textbox" required="true"
            value="${pp.propertyDisName}"  
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">唯一性属性:</td>
          <td class="formContent">
            <input id="combo4" class="mini-combobox" name="isUnique" value="${pp.isUnique}"
              style="width: 125px;" valueField="id" url="materialManage/getIsEnumOrIsUnique" required="true"
              textField="text" pinyinField="tag"></td>
        </tr>
        <tr>
          <td class="formLabel">属性值为下拉:</td>
          <td class="formContent"><input id="combo5" class="mini-combobox" name="isEnum" value="${pp.isEnum}"
              style="width: 125px;" valueField="id" url="materialManage/getIsEnumOrIsUnique" required="true"
              textField="text" pinyinField="tag"></td>
        </tr>
        <tr>
          <td class="formLabel">属性值单位:</td>
          <td class="formContent"><input name="propertyUnit" class="mini-textbox" required="false"
            value="${pp.propertyUnit}"  
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

        SaveData("partProperties/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>