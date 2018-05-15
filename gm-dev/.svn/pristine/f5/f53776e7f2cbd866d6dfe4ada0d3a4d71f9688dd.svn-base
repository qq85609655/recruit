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
            <td class="form-label" style="width: 180px;">outline长(mm)
            <input id="sp2" name="properties['outlineLengthId']" class="mini-spinner" style="width:75px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 180px;">outline宽(mm)
            <input id="sp2" name="properties['outlineWidthId']" class="mini-spinner" style="width:75px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 180px;">outline厚(mm)
            <input id="sp2" name="properties['outlineHeightId']" class="mini-spinner" style="width:75px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 180px;">TPM Name：
            <input id="combo1" class="mini-combobox" name="properties['tpmNameId']"
              style="width: 80px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${tpmNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">供应商：
            <input id="combo2" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"
              style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">型号：
            <input id="combo3" class="mini-combobox" name="properties['versionId']" onvalidation="onComboValidation"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${versionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            </tr>
            <tr>
            <td class="form-label" style="width: 180px;">颜色：
            <input id="combo4" class="mini-combobox" name="properties['colorId']" onvalidation="onComboValidation"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${colorEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">补充属性：
            <input id="combo5" class="mini-combobox" name="properties['upVersionId']" onvalidation="onComboValidation"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${upVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">材质：
            <input id="combo6" class="mini-combobox" name="properties['materialQualityId']" onvalidation="onComboValidation"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${materialQualityEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 180px;">表面处理：
            <input id="combo7" class="mini-combobox" name="properties['surfaceTreatmentId']" onvalidation="onComboValidation"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${surfaceTreatmentEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-机构-适用于3B）</span>
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
            <td class="form-label" style="width: 140px;">功能分类：
            <input id="combo9" class="mini-combobox" name="properties['functionTypeId']"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${functionTypeEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 140px;">产品尺寸：
            <input id="combo10" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
              style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 140px;">预留码：
            <input name="properties['reservedCodeId']" id="000" value="000" class="mini-textbox" style="width:85px" allowInput="false"/></td>
            <td class="form-label" style="width: 140px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:80px" allowInput="false"/></td>
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
    var comb9 = mini.get("combo9");
    comb9.select(0);
    var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	var comb5 = mini.get("combo5");

    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb5.data;
      if (arr.length > 0) {
        for (i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb5.setValue(arr[i].id);
            }
          }
        }
    }
  </script>
</body>
</html>