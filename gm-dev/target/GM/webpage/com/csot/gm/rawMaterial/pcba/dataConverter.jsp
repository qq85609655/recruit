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
            <td class="form-label" style="width: 160px;">IC类型：
            <input id="combo1" class="mini-combobox" name="properties['icTypeId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${icTypeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">封装：
            <input id="combo2" class="mini-combobox" name="properties['packageId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">供应商料号：
            <input id="combo3" class="mini-combobox" name="properties['vendorNoId']"
              style="width: 120px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorNoEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/pcba/ele3418_3422.jsp"%>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
  
  <script type="text/javascript">
  	mini.parse();
  	var comb4 = mini.get("combo4");
  	var comb5 = mini.get("combo5");
  	comb4.select(0);
  	comb5.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>