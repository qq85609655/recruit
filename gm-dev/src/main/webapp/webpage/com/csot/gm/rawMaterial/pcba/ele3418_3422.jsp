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
        <span>料号生成属性（料号规则-电子-适用于3418~3422）</span>
      </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码：
            <input id="combobigClass" class="mini-combobox" name="properties['bigClassId']"
              style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">次分类：
            <input id="combo4" class="mini-combobox" name="properties['subClassId']"
              style="width: 90px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${subClassEnumTypeId}" required=""
              allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">分类：
            <input id="combo5" class="mini-combobox" name="properties['classId']"
              style="width: 100px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${classEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">预留码：
            <input name="properties['reservedCodeId']" id="00" value="00" class="mini-textbox" style="width:90px" allowInput="false"/></td>
            <td class="form-label" style="width: 160px;">流水号：
            <input id="flowNo" name="properties['flowNoId']" value="XXXXXXX" class="mini-textbox" style="width:90px" allowInput="false"/></td>
          </tr>
          </table>
    </fieldset>
    
</body>
</html>