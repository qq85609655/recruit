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
        <span>料号生成属性（料号规则-原材-适用于31,32,41,42,43-s3【G6-G85-G11玻璃】）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">厂别代码：
            <input id="combo7" class="mini-combobox" name="properties['plantCodeId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantCodeEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">材料种类：
            <input id="combo8" class="mini-combobox" name="properties['difKindId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${difKindEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
        <td class="form-label" style="width: 160px;">预留空位A：
        <input name="properties['reservedCodeAId']" id="0" value="0" class="mini-textbox" style="width:70px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">材料种类细分代码：
        <input name="properties['flowNoId']" value="XX" class="mini-textbox" style="width:35px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">预留空位B：
        <input name="properties['reservedCodeBId']" id="00000" value="00000" class="mini-textbox" style="width:70px" allowInput="false"/></td>
      </tr>
      <tr> 
        <td class="form-label" style="width: 160px;">供应商：
        <input id="combo9" class="mini-combobox" name="properties['vendorId']" onvalidation="onComboValidation"  onvaluechanged="onDeptChanged('9')"
          style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${vendorEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
      </tr>
          </table>
    </fieldset>
  
</body>
</html>