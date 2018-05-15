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
            <td class="form-label" style="width: 200px;">类别：
            <input id="combo7" class="mini-combobox" name="properties['typeId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('7')"
              style="width: 140px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${typeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">公称直径(mm)
            <input id="combo8" class="mini-combobox" name="properties['nominalDId']" onvalidation="onComboValidation"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${nominalDEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">outline长(mm)
            <input id="sp2" name="properties['outlineLengthId']" class="mini-spinner" style="width:90px" minValue="0" maxValue="99999" format="n1" required="true"/></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">表面处理：
            <input id="combo1" class="mini-combobox" name="properties['surfaceTreatmentId']"
              style="width: 120px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${surfaceTreatmentEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">防松：
            <input id="combo2" class="mini-combobox" name="properties['looseproofId']" onvalidation="onComboValidation"
              style="width: 140px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${looseproofEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">颜色：
            <input id="combo3" class="mini-combobox" name="properties['colorId']" onvalidation="onComboValidation"
              style="width: 140px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${colorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">头径(mm)：
            <input id="combo4" class="mini-combobox" name="properties['diameterHeadId']"
              style="width: 110px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${diameterHeadEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">头厚(mm)：
            <input id="combo5" class="mini-combobox" name="properties['thickHeadId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${thickHeadEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">头型：
            <input id="combo6" class="mini-combobox" name="properties['versionHeadId']" onvalidation="onComboValidation"
              style="width: 140px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${versionHeadEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
   <%@ include file="/webpage/com/csot/gm/rawMaterial/mechanismOptics/other.jsp"%>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
  <script type="text/javascript">
    mini.parse();
    var comb7 = mini.get("combo7");
    var comb13 = mini.get("combo13");
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "7") {
        comb13.setValue(comb7.getValue());
      } else if (e == "13") {
        comb7.setValue(comb13.getValue());
      } 
    }
  </script>
</body>
</html>