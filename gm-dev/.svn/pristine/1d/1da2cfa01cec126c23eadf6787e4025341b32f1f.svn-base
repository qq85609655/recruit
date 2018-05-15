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
            <td class="form-label" style="width: 160px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']" onvaluechanged="onDeptChanged('1')"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">机种尺寸：
            <input id="combo2" class="mini-combobox" name="properties['machineSizeId']" onvalidation="onComboValidation"
              style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${machineSizeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">上/下偏：
            <input id="combo3" class="mini-combobox" name="properties['upOrDownId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${upOrDownEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">补偿膜：
            <input id="combo4" class="mini-combobox" name="properties['compensationFilmId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${compensationFilmEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">Mark：
            <input id="combo10" class="mini-combobox" name="properties['markId']"
              style="width: 80px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${markEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">等级：
            <input id="combo6" class="mini-combobox" name="properties['gradeId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${gradeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">形态：
            <input id="combo7" class="mini-combobox" name="properties['formId']"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${formEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">应用：
            <input id="combo8" class="mini-combobox" name="properties['applicationId']" onvalidation="onComboValidation"
              style="width: 85px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${applicationEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">表面处理：
            <input id="combo9" class="mini-combobox" name="properties['surfaceTreatmentId']" onvalidation="onComboValidation"
              style="width: 75px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${surfaceTreatmentEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">轴向：
            <input id="combo20" class="mini-combobox" name="properties['axialId']"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${axialEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 260px;" colspan="2">POL尺寸(mm)：
            <input id="combo5" class="mini-combobox" name="properties['polSizeId']" onvalidation="onComboValidation"
              style="width: 160px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${polSizeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
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