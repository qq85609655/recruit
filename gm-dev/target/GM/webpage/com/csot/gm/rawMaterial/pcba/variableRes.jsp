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
            <td class="form-label" style="width: 250px;">供应商料号：
            <input id="combo1" class="mini-combobox" name="properties['vendorNoId']"
              style="width: 160px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorNoEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 250px;">阻值(Ω)：
            <input id="combo3" class="mini-combobox" name="properties['resistanceValueId']" onvaluechanged="onDeptChanged('3')" onvalidation="onComboValidation"
              style="width: 180px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${resistanceValueEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-电子-适用于3403）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 200px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">次分类：
            <input id="combo5" class="mini-combobox" name="properties['subClassId']"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>             
            <td class="form-label" style="width: 160px;">分类：
            <input id="combo6" class="mini-combobox" name="properties['classId']"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">阻值(Ω)：
            <input id="combo7" class="mini-combobox" name="properties['resistanceValueId']" onvaluechanged="onDeptChanged('7')" onvalidation="onComboValidation"
              style="width: 125px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${resistanceValueEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">预留码：
            <input name="properties['reservedCodeId']" id="00" value="00" class="mini-textbox" style="width:90px" allowInput="false"/></td>
            <td class="form-label" style="width: 160px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:90px" allowInput="false"/></td>
          </tr>
          </table>
    </fieldset>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
  
  <script type="text/javascript">
  	mini.parse();
  	var comb3 = mini.get("combo3");
  	var comb7 = mini.get("combo7");
  	var comb5 = mini.get("combo5");
  	var comb6 = mini.get("combo6");
  	comb5.select(0);
  	comb6.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	
 // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "3") {
        comb7.setValue(comb3.getValue());
      } else if (e == "7") {
        comb3.setValue(comb7.getValue());
      } 
    }
  </script>
</body>
</html>