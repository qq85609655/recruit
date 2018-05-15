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
            <td class="form-label" style="width: 200px;">供应商型号：
            <input id="combo2" class="mini-combobox" name="properties['plantVersionId']" onvalidation="onComboValidation"
              style="width: 115px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']" onvaluechanged="onDeptChanged('1')"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">包装方式：
            <input id="combo3" class="mini-combobox" name="properties['packageId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${packageEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">浓度：
            <input id="combo4" class="mini-combobox" name="properties['concentrationId']" onvalidation="onComboValidation"
              style="width: 150px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${concentrationEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td> 
            <td class="form-label" style="width: 240px;" colspan="2">成分：
            <input id="combo5" class="mini-combobox" name="properties['componentId']" onvalidation="onComboValidation"
              style="width: 180px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${componentEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/originalMaterialSupp.jsp"%>
    
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