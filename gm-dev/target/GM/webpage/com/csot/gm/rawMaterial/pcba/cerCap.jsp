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
                style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${capacityValueEnumTypeId}" required=""
                allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">封装：
            <input id="combo2" class="mini-combobox" name="properties['packageId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('2')"> </td>
            <td class="form-label" style="width: 160px;">介电值：
            <input id="combo3" class="mini-combobox" name="properties['dielectricValueId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('3')"
              url="rawMaterial/getComboData?enumTypeId=${dielectricValueEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">额定电压(V)：
            <input id="combo4" class="mini-combobox" name="properties['ratedVoltageId']"
              style="width: 65px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('4')"
              url="rawMaterial/getComboData?enumTypeId=${ratedVoltageEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">误差：
            <input id="combo5" class="mini-combobox" name="properties['deviationId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${deviationEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('5')"></td>
          </tr>
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-电子-适用于3405）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">次分类：
            <input id="combo6" class="mini-combobox" name="properties['subClassId']"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>             
            <td class="form-label" style="width: 160px;">分类：
            <input id="combo7" class="mini-combobox" name="properties['classId']"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">电容值：
            <input id="combo8" class="mini-combobox" name="properties['capacityValueId']" onvaluechanged="onDeptChanged('8')"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${capacityValueEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">封装：
            <input id="combo9" class="mini-combobox" name="properties['packageId']" onvaluechanged="onDeptChanged('9')"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">介电值：
            <input id="combo10" class="mini-combobox" name="properties['dielectricValueId']" onvaluechanged="onDeptChanged('10')"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${dielectricValueEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">额定电压(V)：
            <input id="combo11" class="mini-combobox" name="properties['ratedVoltageId']" onvaluechanged="onDeptChanged('11')"
              style="width: 65px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ratedVoltageEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">误差：
            <input id="combo12" class="mini-combobox" name="properties['deviationId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${deviationEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('12')"> </td>
            <td class="form-label" style="width: 160px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="X" class="mini-textbox" style="width:90px" allowInput="false"/></td>
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
  	var comb3 = mini.get("combo3");
  	var comb4 = mini.get("combo4");
  	var comb5 = mini.get("combo5");
  	var comb6 = mini.get("combo6");
  	var comb7 = mini.get("combo7");
  	var comb8 = mini.get("combo8");
  	var comb9 = mini.get("combo9");
  	var comb10 = mini.get("combo10");
  	var comb11 = mini.get("combo11");
  	var comb12 = mini.get("combo12");
  	comb6.select(0);
  	comb7.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	
  	// 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb8.setValue(comb1.getValue());
      } else if (e == "2") {
        comb9.setValue(comb2.getValue());
      } else if (e == "3") {
        comb10.setValue(comb3.getValue());
      } else if (e == "4") {
        comb11.setValue(comb4.getValue());
      } else if (e == "5") {
        comb12.setValue(comb5.getValue());
      } else if (e == "8") {
        comb1.setValue(comb8.getValue());
      } else if (e == "9") {
        comb2.setValue(comb9.getValue());
      } else if (e == "10") {
        comb3.setValue(comb10.getValue());
      } else if (e == "11") {
        comb4.setValue(comb11.getValue());
      } else if (e == "12") {
        comb5.setValue(comb12.getValue());
      }
    }
  	

  </script>
</body>
</html>