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
      <input name="id" class="mini-hidden" value="${enumValue.id}" /> <input name="enumTypeId"
        class="mini-hidden" value="${enumValue.enumTypeId}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">枚举显示值:</td>
          <td class="formContent"><input id="valueD" name="enumText" class="mini-textbox"
            required="true" value="${enumValue.enumText}" style="width: 300px"
            onvaluechanged="onValueChanged()" onvalidation="ValidErrorText" vtype="maxLength:30" /><label
            id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">枚举真实值:</td>
          <td class="formContent"><input id="valueV" name="enumValue" class="mini-textbox"
            required="false" value="${enumValue.enumValue}" style="width: 300px" onvalidation="" /><label
            id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">枚举类名:</td>
          <td class="formContent"><input id="typeName" name="name" class="mini-textbox"
            required="true" allowInput="false" value="${enumTypeName}" style="width: 300px"
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

      var typeName = mini.get("typeName");
      typeName.disable();

      var valueV = mini.get("valueV");
      var valueD = mini.get("valueD");

      //$(function(){
      //  $("input[name='enumText']").change(function(){
      //var text = $(this).val();
      //$("input[name='enumValue']").val(text);
      //});
      //})

      // 唯一性属性与料号生成属性重复，选择联动
      function onValueChanged() {
        valueV.setValue(valueD.getValue());
      }

      function onOk(e) {
        form.validate();
        if (form.isValid() == false) {
          return;
        }
        SaveData("enumValue/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

      function GetData() {
        var enumText = valueD.getValue();
        return enumText;
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>