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
            <input id="combo1" class="mini-combobox" name="properties['vendorId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('1')"
              url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">结构：
            <input id="combo2" class="mini-combobox" name="properties['structureId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('2')"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${structureEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">VA区尺寸：
            <input id="combo3" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('3')"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">TPM型号：
            <input id="combo4" class="mini-combobox" name="properties['tpmVersionId']"
              style="width: 80px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${tpmVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">颜色：
            <input id="combo7" class="mini-combobox" name="properties['colorId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${colorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">IC型号：
            <input id="combo6" class="mini-combobox" name="properties['icVersionId']"
              style="width: 90px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${icVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td> 
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">升版：
            <input id="combo8" class="mini-combobox" name="properties['upVersionId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${upVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 250px;" colspan="2">供应商型号：
            <input id="combo5" class="mini-combobox" name="properties['plantVersionId']"
              style="width: 160px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${plantVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
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
    var comb2 = mini.get("combo2");
    var comb3 = mini.get("combo3");
    var comb12 = mini.get("combo12");
    var comb14 = mini.get("combo14");
    var comb15 = mini.get("combo15");
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
      if (e == "1") {
        comb15.setValue(comb1.getValue());
      } else if (e == "15") {
        comb1.setValue(comb15.getValue());
      } else if (e == "2") {
        comb12.setValue(comb2.getValue());
      } else if (e == "12") {
        comb2.setValue(comb12.getValue());
      } else if (e == "3") {
        comb14.setValue(comb3.getValue());
      } else if (e == "14") {
        comb3.setValue(comb14.getValue());
      }
    }
  </script>
</body>
</html>