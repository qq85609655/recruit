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

  <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑; font-size: 4px">
    <legend>
      <span style="font-size: 10px">料号生成属性（料号规则-机构-适用于35）</span>
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
        <td class="form-label" style="width: 160px;">功能分类：
        <input id="combo12" class="mini-combobox" name="properties['functionTypeId']"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${functionTypeEnumTypeId}" required=""
          allowInput="false" textField="text" pinyinField="tag"></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 160px;">产品尺寸：
        <input id="combo13" class="mini-combobox" name="properties['sizeId']" onvalidation="onComboValidation"
          style="width: 80px;" valueField="id" url="rawMaterial/getComboData?enumTypeId=${sizeEnumTypeId}" required=""
          allowInput="true" textField="text" pinyinField="tag"></td>
        <td class="form-label" style="width: 160px;">预留码：
        <input name="properties['reservedCodeId']" id="000" value="000" class="mini-textbox" style="width:105px" allowInput="false"/></td>
        <td class="form-label" style="width: 160px;">流水号：
        <input id="flowNo" name="properties['flowNoId']" value="XXXX" class="mini-textbox" style="width:95px" allowInput="false"/></td>
      </tr>
    </table>
  </fieldset>
  
  <script type="text/javascript">
	mini.parse();
  	var comb12 = mini.get("combo12");
  	comb12.select(0);
  	var combobigClass = mini.get("combobigClass");
  	combobigClass.select(0);
  	var comb4 = mini.get("combo4");

    window.onload=function()//用window的onload事件，窗体加载完毕的时候
    {
      var arr = comb4.data;
      if (arr.length > 0) {
        for (i=0; i<arr.length; i++) {
          if (arr[i].text == "NA") {
            comb4.setValue(arr[i].id);
            }
          }
        }
    }
  </script>
</body>
</html>