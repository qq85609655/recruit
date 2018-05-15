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
            <td class="form-label" style="width: 150px;">类别：
            <input id="combo2" class="mini-combobox" name="properties['typeId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('2')"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${typeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 130px;">pin数：
            <input id="combo3" class="mini-combobox" name="properties['pinDigitId']" onvalidation="onComboValidation"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${pinDigitEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">pitch(mm)：
            <input id="combo4" class="mini-combobox" name="properties['pitchId']"
              style="width: 60px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${pitchEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 150px;">长度(mm)：
            <input id="sp2" name="properties['lengthId']" class="mini-spinner" style="width:70px" minValue="0" maxValue="99999" format="n1" required="true"/></td>
            <td class="form-label" style="width: 120px;">位置：
            <input id="combo5" class="mini-combobox" name="properties['positionId']" onvalidation="onComboValidation"
              style="width: 75px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${positionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 130px;">有无背胶：
            <input id="combo7" class="mini-combobox" name="properties['isGumId']"
              style="width: 70px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${isGumEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 150px;">升版：
            <input id="combo8" class="mini-combobox" name="properties['upVersionId']"
              style="width: 100px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${upVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 220px;" colspan="2">Model Name：
            <input id="combo1" class="mini-combobox" name="properties['modelNameId']"
              style="width: 110px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${modelNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
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
    var comb2 = mini.get("combo2");
    var comb13 = mini.get("combo13");
    var comb8 = mini.get("combo8");
    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb8.data;
      if (arr.length > 0) {
        for (i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb8.setValue(arr[i].id);
            }
          }
        }
    }
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "2") {
        comb13.setValue(comb2.getValue());
      } else if (e == "13") {
        comb2.setValue(comb13.getValue());
      } 
    }
  </script>
</body>
</html>