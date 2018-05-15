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
            <td class="form-label" style="width: 160px;">outline长(mm)
            <input id="sp1" name="properties['outlineLengthId']" class="mini-spinner" style="width:70px" minValue="0" maxValue="99999" format="n0" required="true"/></td>
            <td class="form-label" style="width: 160px;">outline宽(mm)
            <input id="sp2" name="properties['outlineWidthId']" class="mini-spinner" style="width:70px" minValue="0" maxValue="99999" format="n0" required="true"/></td>
            <td class="form-label" style="width: 160px;">outline高(mm)
            <input id="sp3" name="properties['outlineHeightId']" class="mini-spinner" style="width:70px" minValue="0" maxValue="99999" format="n0" required="true"/></td>
          </tr>
          
          <tr>
            <td class="form-label" style="width: 160px;">是否回收：
            <input id="combo1" class="mini-combobox" name="properties['isRecoveryId']"
              style="width: 90px;" valueField="id" onvaluechanged="onDeptChanged('1')" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${isRecoveryEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">重量(Kg)
            <input id="sp4" name="properties['weightId']" class="mini-spinner" style="width:100px" minValue="0" maxValue="99999" format="n3" required="true"/></td>
            <td class="form-label" style="width: 160px;">形状：
            <input id="combo2" class="mini-combobox" name="properties['shapeId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${shapeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">补充属性：
            <input id="combo3" class="mini-combobox" name="properties['suppPropertyId']" value="3" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${suppPropertyEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/packMaterial/pallet.jsp"%>
    
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
    var comb14 = mini.get("combo14");
    var comb3 = mini.get("combo3");

    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb3.data;
      if (arr.length > 0) {
        for (var i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb3.setValue(arr[i].id);
            }
          }
        }
    }
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb14.setValue(comb1.getValue());
      } else if (e == "14") {
        comb1.setValue(comb14.getValue());
      } 
    }
  </script>
</body>
</html>