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
      <span>料号生成属性（料号规则-机构-适用于55）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="7">
      <tr>
        <td class="form-label" style="width: 140px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 140px;">产品应用领域：
        <input id="combo11" class="mini-combobox" name="properties['prodApplDomainId']" onvalidation="onComboValidation"
          style="width: 40px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodApplDomainEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 140px;">产品类别：
        <input id="combo12" class="mini-combobox" name="properties['prodCategoryId']"
          style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
         <td class="form-label" style="width: 140px;">产品规格：
         <input id="combo13" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
          style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">是否回收：
        <input id="combo14" class="mini-combobox" name="properties['isRecoveryId']" onvalidation="onComboValidation"
          style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${isRecoveryEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag" onvaluechanged="onDeptChanged('14')"></td>
        <td class="form-label" style="width: 160px;">预留码：
        <input name="properties['reservedCodeId']" id="00" value="00" class="mini-textbox" style="width:75px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:75px" allowInput="false"/></td>
      </tr>
    </table>
    <table class="form-table" border="0" cellpadding="10" cellspacing="5">
      <tr>
        <td class="form-label" style="width: 120px;">物料描述完善项：</td>
        <td><input class="mini-textbox" name="properties['suppDescId']" style="width: 480px;"></td>
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