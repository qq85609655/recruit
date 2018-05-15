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
            <td class="form-label" style="width: 200px;">ModelName：
            <input id="combo1" class="mini-combobox" name="properties['modelNameId']"
              style="width: 110px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${modelNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 170px;">组装供应商：
            <input id="combo2" class="mini-combobox" name="properties['assembleSupplierId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${assembleSupplierEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 170px;">灯条供应商：
            <input id="combo3" class="mini-combobox" name="properties['lampBarSupplierId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${lampBarSupplierEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            </tr>
            <tr>
            <td class="form-label" style="width: 200px;">convert供应商：
            <input id="combo4" class="mini-combobox" name="properties['convertSupplierId']" onvalidation="onComboValidation"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${convertSupplierEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 170px;">LED型号：
            <input id="combo5" class="mini-combobox" name="properties['ledVersionId']" onvalidation="onComboValidation"
              style="width: 105px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ledVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 170px;">LED颗数：
            <input id="combo6" class="mini-combobox" name="properties['ledNoId']" onvalidation="onComboValidation"
              style="width: 105px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${ledNoEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 200px;">升版：
            <input id="combo7" class="mini-combobox" name="properties['upVersionId']"
              style="width: 155px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${upVersionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-机构-适用于38）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 140px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">产品应用领域：
            <input id="combo8" class="mini-combobox" name="properties['prodApplDomainId']" onvalidation="onComboValidation"
              style="width: 50px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodApplDomainEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 220px;">产品类别：
            <input id="combo9" class="mini-combobox" name="properties['prodCategoryId']"
              style="width: 150px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 140px;">产品尺寸：
            <input id="combo10" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">预留码：
            <input name="properties['reservedCodeId']" id="000" value="000" class="mini-textbox" style="width:80px" allowInput="false"/></td>
            <td class="form-label" style="width: 220px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:160px" allowInput="false"/></td>
          </tr>
          </table>
    </fieldset>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
  
  <script type="text/javascript">
    mini.parse();
    var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
    var comb7 = mini.get("combo7");

    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb7.data;
      if (arr.length > 0) {
        for (i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb7.setValue(arr[i].id);
            }
          }
        }
    }
  </script>
</body>
</html>