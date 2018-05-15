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
            <td class="form-label" style="width: 200px;">阻值(Ω)：
            <input id="combo1" class="mini-combobox" name="properties['resistanceValueId']" onvalidation="onComboValidation"
              style="width: 130px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${resistanceValueEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('1')"> </td>
            <td class="form-label" style="width: 150px;">封装：
            <input id="combo2" class="mini-combobox" name="properties['packageId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('2')"
              url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">Rated Power(W)：
            <input id="combo4" class="mini-combobox" name="properties['ratedPowerId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ratedPowerEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('4')"></td>
            <td class="form-label" style="width: 150px;">误差：
            <input id="combo3" class="mini-combobox" name="properties['deviationId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('3')"
              url="rawMaterial/getComboData?enumTypeId=${deviationEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-电子-适用于3401）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="6" cellspacing="7">
          <tr>
            <td class="form-label" style="width: 180px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 115px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">次分类：
            <input id="combo5" class="mini-combobox" name="properties['subClassId']"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>             
            <td class="form-label" style="width: 140px;">分类：
            <input id="combo6" class="mini-combobox" name="properties['classId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 180px;">阻值(Ω)：
            <input id="combo7" class="mini-combobox" name="properties['resistanceValueId']" onvaluechanged="onDeptChanged('7')"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${resistanceValueEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">封装：
            <input id="combo8" class="mini-combobox" name="properties['packageId']" onvaluechanged="onDeptChanged('8')"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">误差：
            <input id="combo9" class="mini-combobox" name="properties['deviationId']" onvaluechanged="onDeptChanged('9')"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${deviationEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 180px;">Rated Power(W)：
            <input id="combo10" class="mini-combobox" name="properties['ratedPowerId']" onvalidation="onComboValidation"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ratedPowerEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('10')"> </td>
            <td class="form-label" style="width: 120px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:70px" allowInput="false"/></td>
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
  	comb5.select(0);
  	comb6.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	
  	// 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb7.setValue(comb1.getValue());
      } else if (e == "2") {
        comb8.setValue(comb2.getValue());
      } else if (e == "3") {
        comb9.setValue(comb3.getValue());
      } else if (e == "4") {
        comb10.setValue(comb4.getValue());
      } else if (e == "7") {
        comb1.setValue(comb7.getValue());
      } else if (e == "8") {
        comb2.setValue(comb8.getValue());
      } else if (e == "9") {
        comb3.setValue(comb9.getValue());
      } else if (e == "10") {
        comb4.setValue(comb10.getValue());
      }
    }
  	

  </script>
</body>
</html>