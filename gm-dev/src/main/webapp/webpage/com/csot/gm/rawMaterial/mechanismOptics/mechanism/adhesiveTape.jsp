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
            <td class="form-label" style="width: 200px;">outline长(mm)
            <input id="sp2" name="properties['outlineLengthId']" class="mini-spinner" style="width:100px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 180px;">outline宽(mm)
            <input id="sp2" name="properties['outlineWidthId']" class="mini-spinner" style="width:90px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 180px;">outline厚(mm)
            <input id="sp2" name="properties['outlineHeightId']" class="mini-spinner" style="width:90px" minValue="0" maxValue="99999" format="n3" required="true"/></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">ModelName：
            <input id="combo1" class="mini-combobox" name="properties['modelNameId']"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${modelNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">编码类别：
            <input id="combo3" class="mini-combobox" name="properties['typeId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('3')"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${typeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">细分类别：
            <input id="combo4" class="mini-combobox" name="properties['difTypeId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${difTypeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">材质：
            <input id="combo2" class="mini-combobox" name="properties['materialQualityId']" onvalidation="onComboValidation"
              style="width: 145px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${materialQualityEnumTypeId}" required="" allowInput="true"
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
    var comb3 = mini.get("combo3");
    var comb13 = mini.get("combo13");
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "3") {
        comb13.setValue(comb3.getValue());
      } else if (e == "13") {
        comb3.setValue(comb13.getValue());
      } 
    }
  </script>
</body>
</html>