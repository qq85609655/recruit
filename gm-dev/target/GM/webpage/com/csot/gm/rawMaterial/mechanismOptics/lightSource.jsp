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
      <span>料号生成属性（料号规则-机构-适用于36）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="7">
      <tr>
        <td class="form-label" style="width: 180px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">产品应用领域：
        <input id="combo11" class="mini-combobox" name="properties['prodApplDomainId']" onvalidation="onComboValidation"
          style="width: 65px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodApplDomainEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">分类代码：
        <input id="combo12" class="mini-combobox" name="properties['functionTypeId']" onvalidation="onComboValidation"
          style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${functionTypeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 180px;">产品类别：
        <input id="combo13" class="mini-combobox" name="properties['prodCategoryId']"
          style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">产品规格：
        <input id="combo14" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
          style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">预留码：
        <input name="properties['reservedCodeId']" id="00" value="00" class="mini-textbox" style="width:110px" allowInput="false"/></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 180px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:100px" allowInput="false"/></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
  	var comb13 = mini.get("combo13");
  	comb13.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>