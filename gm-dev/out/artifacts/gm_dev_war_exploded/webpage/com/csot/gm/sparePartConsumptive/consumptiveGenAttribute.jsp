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
      <span>料号生成属性（料号规则-耗材-适用于71）</span>
    </legend>
    <table class="form-table" border="0" cellpadding="6" cellspacing="1">
      <tr>
        <td class="form-label" style="width: 160px;">大分类码： <input id="combobigClass"
          class="mini-combobox" name="properties['bigClassId']" style="width: 80px;" valueField="id"
          url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">厂别码： <input id="combo3"
          class="mini-combobox" name="properties['plantCodeId']" style="width: 90px;"
          valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantCodeEnumTypeId}"
          required="" allowInput="false" onvalidation="onComboValidation" textField="text"
          pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">大类： <input id="combo4"
          class="mini-combobox" name="properties['largeClassId']" style="width: 100px;"
          valueField="id" url="rawMaterial/getComboData?enumTypeId=${largeClassEnumTypeId}"
          required="" allowInput="false" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">中类： <input id="combo5"
          class="mini-combobox" name="properties['mediumClassId']" style="width: 90px;"
          valueField="id" url="rawMaterial/getComboData?enumTypeId=${mediumClassEnumTypeId}"
          required="" allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">小类： <input id="combo6"
          class="mini-combobox" name="properties['miniClassId']" style="width: 105px;"
          valueField="id" url="rawMaterial/getComboData?enumTypeId=${miniClassEnumTypeId}"
          required="" allowInput="false" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">维修区别码： <input
          name="properties['maintainCodeId']" id="0" value="0" class="mini-textbox"
          style="width: 65px" allowInput="false" /></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">流水码： <input name="properties['flowNoId']"
          value="XXXXXX" class="mini-textbox" style="width: 80px" allowInput="false" /></td>
      </tr>
    </table>
  </fieldset>

</body>
</html>