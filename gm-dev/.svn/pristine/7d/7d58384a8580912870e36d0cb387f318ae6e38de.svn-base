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
            <td class="form-label" style="width: 180px;">outline长(mm)
            <input id="sp2" name="properties['outlineLengthId']" class="mini-spinner" style="width:90px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 180px;">outline宽(mm)
            <input id="sp2" name="properties['outlineWidthId']" class="mini-spinner" style="width:90px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
            <td class="form-label" style="width: 200px;">outline厚(mm)
            <input id="sp2" name="properties['outlineHeightId']" class="mini-spinner" style="width:100px" minValue="0" maxValue="99999" format="n2" required="true"/></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 180px;">供应商：
            <input id="combo1" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"
              style="width: 120px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" 
              required="" allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">型号：
            <input id="combo2" class="mini-combobox" name="properties['versionId']"
              style="width: 140px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${versionEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
        </table>
    </fieldset>
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
    <legend>
      <span>料号生成属性（料号规则-机构-适用于39-s2【胶带】）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="10" cellspacing="10">
      <tr>
        <td class="form-label" style="width: 160px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">产品应用领域：
        <input id="combo11" class="mini-combobox" name="properties['prodApplDomainId']" onvalidation="onComboValidation"
          style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodApplDomainEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">产品类别：
        <input id="combo12" class="mini-combobox" name="properties['prodCategoryId']"
          style="width: 85px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">类别：
        <input id="combo13" class="mini-combobox" name="properties['typeId']" onvalidation="onComboValidation"
          style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${typeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">预留码：
        <input name="properties['reservedCodeId']" id="000" value="000" class="mini-textbox" style="width:105px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXXXX" class="mini-textbox" style="width:95px" allowInput="false"/></td>
      </tr>
    </table>
    <table class="form-table" border="0" cellpadding="10" cellspacing="5">
      <tr>
        <td class="form-label" style="width: 100px;">物料描述完善项：</td>
        <td><input class="mini-textbox" name="properties['suppDescId']" style="width: 400px;"></td>
      </tr>
    </table>
  </fieldset>
    
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
    
  </div>
</form>
  <script type="text/javascript">
  	mini.parse();
    var comb12 = mini.get("combo12");
    comb12.select(0);
    var comb13 = mini.get("combo13");
    comb13.select(0);
    var combobigClass = mini.get("combobigClass");
    combobigClass.select(0);
  </script>
   <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
</body>
</html>