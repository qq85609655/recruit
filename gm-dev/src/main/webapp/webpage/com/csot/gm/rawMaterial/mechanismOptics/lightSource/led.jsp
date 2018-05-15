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
<%@ include file="/resources/context/lazyResource.jsp"%>
<style>
</style>
</head>
<body>
<form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
  <div style="width: 700px; margin: 10px" align="center">

  <%@ include file="/webpage/com/csot/gm/rawMaterial/classAndUserInfo.jsp"%>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>唯一性属性</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 220px;">ModelName：
            <input id="combo1" class="mini-combobox" name="properties['modelNameId']"
              style="width: 120px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${modelNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">型号：
            <input id="combo2" class="mini-combobox" name="properties['versionId']" onvalidation="onComboValidation"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${versionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">供应商：
            <input id="combo3" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            
          </tr>         
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/mechanismOptics/lightSource.jsp"%>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
</body>
</html>