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
      <span>料号生成属性（料号规则-机构-适用于37）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="13" cellspacing="2">
      <tr>
        <td class="form-label" style="width: 130px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 140px;">产品应用领域：
        <input id="combo11" class="mini-combobox" name="properties['prodApplDomainId']" onvalidation="onComboValidation"
          style="width: 50px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodApplDomainEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 180px;">产品类别：
        <input id="combo12" class="mini-combobox" name="properties['prodCategoryId']" onvalidation="onComboValidation"
          style="width: 110px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 130px;">产品尺寸：
        <input id="combo14" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
          style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 140px;">预留码：
        <input name="properties['reservedCodeId']" id="00" value="00" class="mini-textbox" style="width:80px" allowInput="false"/></td>
        <td class="form-label" style="width: 180px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:120px" allowInput="false"/></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>