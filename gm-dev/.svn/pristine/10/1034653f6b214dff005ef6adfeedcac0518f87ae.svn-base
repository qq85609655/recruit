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
      <span>料号生成属性（料号规则-机构-适用于39-s1）</span>
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
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">编码类别：
        <input id="combo13" class="mini-combobox" name="properties['typeId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('13')"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${typeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">预留码：
        <input name="properties['reservedCodeId']" id="000" value="000" class="mini-textbox" style="width:105px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXXXX" class="mini-textbox" style="width:95px" allowInput="false"/></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
  	var comb12 = mini.get("combo12");
  	comb12.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>