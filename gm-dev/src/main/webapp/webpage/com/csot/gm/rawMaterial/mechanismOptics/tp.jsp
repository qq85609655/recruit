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
      <span>料号生成属性（料号规则-机构-适用于3A）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="7">
      <tr>
        <td class="form-label" style="width: 140px;">大分类码：
        <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
          style="width: 60px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">材料类型：
        <input id="combo11" class="mini-combobox" name="properties['prodCategoryId']"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${prodCategoryEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 150px;">材料结构：
        <input id="combo12" class="mini-combobox" name="properties['structureId']" onvalidation="onComboValidation" onvaluechanged="onDeptChanged('12')"
          style="width: 70px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${structureEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">材料功能：
        <input id="combo13" class="mini-combobox" name="properties['functionTypeId']" onvalidation="onComboValidation" 
          style="width: 85px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${functionTypeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 140px;">尺寸：
        <input id="combo14" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('14')"
          style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">型号标示：
        <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:80px" allowInput="false"/></td>
        <td class="form-label" colspan="2" style="width: 200px;">vendor区分代码：
        <input id="combo15" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('15')"
          style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
  	var comb11 = mini.get("combo11");
  	comb11.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  </script>
</body>
</html>