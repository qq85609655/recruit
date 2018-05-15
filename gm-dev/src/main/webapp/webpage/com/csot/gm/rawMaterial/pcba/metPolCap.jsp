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
           <td class="form-label" style="width: 160px;">电容值：
           <input id="combo1" class="mini-combobox" name="properties['capacityValueId']" onvaluechanged="onDeptChanged('1')"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${capacityValueEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">额定电压(V)：
            <input id="combo2" class="mini-combobox" name="properties['ratedVoltageId']" onvaluechanged="onDeptChanged('2')"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ratedVoltageEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 260px;" colspan="2">供应商料号：
            <input id="combo3" class="mini-combobox" name="properties['vendorNoId']"
              style="width: 170px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorNoEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性料号生成属性（料号规则-电子-适用于3434）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">次分类：
            <input id="combo6" class="mini-combobox" name="properties['subClassId']"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>             
            <td class="form-label" style="width: 160px;">分类：
            <input id="combo7" class="mini-combobox" name="properties['classId']"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">输入电压种类：
            <input id="combo8" class="mini-combobox" name="properties['inputVoltageTypeId']"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${inputVoltageTypeEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">电容值：
            <input id="combo9" class="mini-combobox" name="properties['capacityValueId']" onvaluechanged="onDeptChanged('9')"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${capacityValueEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">额定电压(V)：
            <input id="combo10" class="mini-combobox" name="properties['ratedVoltageId']" onvaluechanged="onDeptChanged('10')"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ratedVoltageEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">耐温(℃)：
            <input id="combo11" class="mini-combobox" name="properties['temperatureId']"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${temperatureEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:95px" allowInput="false"/></td>
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
  	var comb1 = mini.get("combo1");
  	var comb2 = mini.get("combo2");
  	var comb6 = mini.get("combo6");
  	var comb7 = mini.get("combo7");
  	var comb9 = mini.get("combo9");
  	var comb10 = mini.get("combo10");
  	comb6.select(0);
  	comb7.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	
  	// 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb9.setValue(comb1.getValue());
      } else if (e == "2") {
        comb10.setValue(comb2.getValue());
      } else if (e == "9") {
        comb1.setValue(comb9.getValue());
      } else if (e == "10") {
        comb2.setValue(comb10.getValue());
      } 
    }
  	

  </script>
</body>
</html>