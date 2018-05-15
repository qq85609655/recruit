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
      <input id="propertyId" name="propertyId" class="mini-hidden" value="${propertyId}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">属性名称:</td>
          <td class="formContent"><input name="propertyName" class="mini-textbox" required="true"
            value="${propertyName}" allowInput="false" style="width: 240px;"/></td>
        </tr>
        <tr>
          <td class="formLabel">枚举类:</td>
          <td class="formContent"><input id="combo1" name="enumTypeName" value="${enumTypeId}" class="mini-combobox"
              style="width: 240px;" valueField="id" url="propertiesM/enumTypeList"
              required="" allowInput="true" textField="name" pinyinField="tag"></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>


  <script type="text/javascript">
    mini.parse();
    var form = new mini.Form("#mainForm");
    
    function onOk(e) {
      
      var enumTypeId = mini.get("combo1").getValue();
      if (enumTypeId == "") {
        enumTypeId = "1";
      }
      var propertyId = mini.get("propertyId").getValue();
      SaveData("propertiesM/updatePropertyEnumType/enumTypeId/" + enumTypeId + "/propertyId/" + propertyId, $("#mainForm").serialize());
    }

    function onCancel(e) {
      CloseWindow("close", form);
    }

  </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>