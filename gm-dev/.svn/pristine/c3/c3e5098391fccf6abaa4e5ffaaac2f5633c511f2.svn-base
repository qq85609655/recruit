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
            <td class="form-label" style="width: 180px;">实验代号：
            <input id="combo1" class="mini-combobox" name="properties['expNoId']"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${expNoEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 240px;">材料种类区分代码：
            <input id="combo2" class="mini-combobox" name="properties['difKindId']" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('2')"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${difKindEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>      
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
    <legend>
      <span>料号生成属性（料号规则-原材-适用于Cell材料实验类）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="7">
      <tr>
        <td class="form-label" style="width: 160px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">厂别代码：
        <input id="combo11" class="mini-combobox" name="properties['plantCodeId']" onvalidation="onComboValidation"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantCodeEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 200px;">材料种类区分代码：
        <input id="combo12" class="mini-combobox" name="properties['difKindId']"
          style="width: 75px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${difKindEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">预留空位A：
        <input name="properties['reservedCodeAId']" id="0" value="0" class="mini-textbox" style="width:70px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">材料种类细分代码：
        <input name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:35px" allowInput="false"/></td>
        <td class="form-label" style="width: 200px;">预留空位B：
        <input name="properties['reservedCodeBId']" id="00000" value="00000" class="mini-textbox" style="width:115px" allowInput="false"/></td>
      </tr>
      <tr> 
        <td class="form-label" style="width: 160px;">vendor区别代码：
        <input id="combo13" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"
          style="width: 40px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
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
    var comb2 = mini.get("combo2");
    var comb12 = mini.get("combo12");
	var comb11 = mini.get("combo11");
	var comb13 = mini.get("combo13");
  	comb11.select(0);
  	comb13.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
    
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "2") {
        comb12.setValue(comb2.getValue());
      } else if (e == "12") {
        comb2.setValue(comb12.getValue());
      }
    }
  </script>
</body>
</html>