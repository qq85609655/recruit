<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>

<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>

  <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
    <legend>
      <span>料号生成属性（料号规则-原材-适用于31,32,41,42,43-s2）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="7">
      <tr>
        <td class="form-label" style="width: 160px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">厂别代码：
        <input id="combo11" class="mini-combobox" name="properties['plantCodeId']" onvalidation="onComboValidation"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantCodeEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">材料种类区分代码：
        <input id="combo12" class="mini-combobox" name="properties['difKindId']"
          style="width: 55px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${difKindEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">预留空位A：
        <input name="properties['reservedCodeAId']" id="0" value="0" class="mini-textbox" style="width:70px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">材料种类细分代码：
        <input name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:35px" allowInput="false"/></td>
        <td class="form-label" style="width: 180px;">预留空位B：
        <input name="properties['reservedCodeBId']" id="00000" value="00000" class="mini-textbox" style="width:95px" allowInput="false"/></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 190px;" colspan=2>vendor区别代码：
        <input id="combo13" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('13')"
          style="width: 130px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
    </table>
    <table class="form-table" border="0" cellpadding="10" cellspacing="5">
      <tr>
        <td class="form-label" style="width: 100px;">物料描述完善项：</td>
        <td><input class="mini-textbox" name="properties['suppDescId']" style="width: 390px;"></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
	var comb11 = mini.get("combo11");
  	comb11.select(0);
  	var comb12 = mini.get("combo12");
  	comb12.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>