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
            <td class="form-label" style="width: 200px;">玻璃类别：
            <input id="combo2" class="mini-combobox" name="properties['glassTypeId']" onvalidation="onComboValidation"
              style="width: 105px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${glassTypeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']" onvaluechanged="onDeptChanged('1')"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">尺寸(mm)：
            <input id="combo3" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td> 
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">厚度(mm)：
            <input id="combo4" class="mini-combobox" name="properties['thicknessId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${thicknessEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">厂商型号：
            <input id="combo5" class="mini-combobox" name="properties['plantVersionId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 200px;">穿透率：
            <input id="combo6" class="mini-combobox" name="properties['penetrateRateId']" onvalidation="onComboValidation"
              style="width: 115px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${penetrateRateEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/directMaterial/glass/g6_g85.jsp"%>
    
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
  	var comb9 = mini.get("combo9");
  	var comb8 = mini.get("combo8");
  	comb8.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	
 	// 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb9.setValue(comb1.getValue());
      } else if (e == "9") {
        comb1.setValue(comb9.getValue());
      }
    }
  </script>
</body>
</html>