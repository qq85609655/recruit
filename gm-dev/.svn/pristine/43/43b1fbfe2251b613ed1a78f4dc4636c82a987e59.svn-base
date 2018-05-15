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
            <td class="form-label" style="width: 140px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']"
              style="width: 70px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('1')"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 250px;">供应商型号：
            <input id="combo2" class="mini-combobox" name="properties['plantVersionId']"
              style="width: 160px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${plantVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 140px;">颜色：
            <input id="combo3" class="mini-combobox" name="properties['colorId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${colorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 250px;">升版：
            <input id="combo4" class="mini-combobox" name="properties['upVersionId']" onvalidation="onComboValidation"
              style="width: 180px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${upVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>                    
        </table>
    </fieldset>
    
    <%@ include file="/webpage/com/csot/gm/rawMaterial/mechanismOptics/tp.jsp"%>
    
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
    var comb15 = mini.get("combo15");
    var comb4 = mini.get("combo4");

    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb4.data;
      if (arr.length > 0) {
        for (i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb4.setValue(arr[i].id);
            }
          }
        }
    }
  // 唯一性属性与料号生成属性重复，选择联动
    function onDeptChanged(e) {
      if (e == "1") {
        comb15.setValue(comb1.getValue());
      } else if (e == "15") {
        comb1.setValue(comb15.getValue());
      } 
    }
  </script>
</body>
</html>