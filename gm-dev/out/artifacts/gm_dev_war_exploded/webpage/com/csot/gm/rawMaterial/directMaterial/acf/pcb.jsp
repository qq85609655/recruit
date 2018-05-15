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
        <table class="form-table" border="0" cellpadding="6" cellspacing="7">
          <tr>
            <td class="form-label" style="width: 200px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']" onvaluechanged="onDeptChanged('1')"
              style="width: 120px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">型号：
            <input id="combo2" class="mini-combobox" name="properties['versionId']" onvalidation="onComboValidation"
              style="width: 150px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${versionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">树脂类型：
            <input id="combo3" class="mini-combobox" name="properties['resinTypeId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${resinTypeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">最小绝缘间距(um)：
            <input id="combo4" class="mini-combobox" name="properties['miniInsulationId']"
              style="width: 60px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${miniInsulationEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">接续面积(um²)：
            <input id="combo5" class="mini-combobox" name="properties['continuousAreaId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${continuousAreaEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">ACF厚度(um)：
            <input id="combo6" class="mini-combobox" name="properties['thicknessId']" onvalidation="onComboValidation"
              style="width: 65px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${thicknessEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">包装规格(M/卷)：
            <input id="combopackage" class="mini-combobox" name="properties['packageId']" onvalidation="onComboValidation"
              style="width: 75px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">导电粒子直径(um)：
            <input id="combo8" class="mini-combobox" name="properties['diameterId']" onvalidation="onComboValidation"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${diameterEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">保管温度：
            <input id="combo9" class="mini-combobox" name="properties['temperatureId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${temperatureEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">保管期限：
            <input id="combo10" class="mini-combobox" name="properties['deadlineId']"
              style="width: 110px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${deadlineEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 250px;" colspan="2">导电粒子密度(pcs/ｍm2)：
            <input id="combo7" class="mini-combobox" name="properties['densityId']"
              style="width: 70px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${densityEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>                     
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/originalMaterial.jsp"%>
    
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
    var comb13 = mini.get("combo13");
    
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb13.setValue(comb1.getValue());
      } else if (e == "13") {
        comb1.setValue(comb13.getValue());
      } 
    }
  </script>
</body>
</html>