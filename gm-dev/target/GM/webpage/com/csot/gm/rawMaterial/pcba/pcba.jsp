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
            <td class="form-label" style="width: 310px;"colspan="2">ModelName：
            <input id="combo1" class="mini-combobox" name="properties['modelNameId']"
              style="width: 200px;" valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${modelNameEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">PCB版本号：
            <input id="combo2" class="mini-combobox" name="properties['pcbVersionId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${pcbVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 180px;">PCBA版本号：
            <input id="combo3" class="mini-combobox" name="properties['pcbaVersionId']" onvalidation="onComboValidation"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${pcbaVersionEnumTypeId}" required="" allowInput="true"
              textField="text" pinyinField="tag"></td>
          </tr>         
        </table>
    </fieldset>
    
    
    <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
      <legend>
        <span>料号生成属性（料号规则-电子-适用于3429）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="6" cellspacing="7">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">次分类：
            <input id="combo4" class="mini-combobox" name="properties['subClassId']"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">用途分类：
            <input id="combo5" class="mini-combobox" name="properties['classId']"  onvalidation="onComboValidation"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">小分类：
            <input id="combo6" class="mini-combobox" name="properties['smallClassId']" 
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${smallClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">产品编码：
            <input id="combo7" class="mini-combobox" name="properties['productionCodeId']"  onvalidation="onComboValidation"
              style="width: 85px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${productionCodeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td> 
            <td class="form-label" style="width: 160px;">版本流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:80px" allowInput="false"/></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">供应商码：
            <input id="combo8" class="mini-combobox" name="properties['vendorCodeId']" onvalidation="onComboValidation"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorCodeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">内控码：
            <input id="combo9" class="mini-combobox" name="properties['internalControlCodeId']"  onvalidation="onComboValidation"
              style="width: 95px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${internalControlCodeEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td> 
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
  <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
  
  <script type="text/javascript">
  	mini.parse();
  	var comb4 = mini.get("combo4");
  	var comb6 = mini.get("combo6");
  	comb4.select(0);
  	comb6.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>