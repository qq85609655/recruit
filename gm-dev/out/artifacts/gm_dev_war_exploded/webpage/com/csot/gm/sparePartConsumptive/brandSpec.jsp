<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
  <table class="form-table" border="0" cellpadding="6" cellspacing="2">
    <tr>
      <td class="form-label" style="width: 240px;">品牌：<input id="brandLookup"
        name="properties['brandId']" class="mini-lookup" style="width: 168px; margin: 0 0 0 0"
        textField="enumText" valueField="id" onvalidation="onlookupBrandValidation"
        popupWidth="auto" showPopupOnClick="true" allowInput="false" emptyText="请选择品牌值"
        popup="#gridPanelBrand" grid="#datagridBrand" multiSelect="false" value="" text="" />
        <div id="gridPanelBrand" class="mini-panel" title="header" iconCls="icon-add"
          style="width: 400px; height: 250px;" showToolbar="true" showCloseButton="true"
          showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
          <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
            <div style="float: left; padding-bottom: 2px;">
              <span>品牌：</span> <input id="keyTextBrand" class="mini-textbox" allowInput="true"
                style="width: 160px;" onenter="onSearchClick('brand')" /> <a class="mini-button"
                onclick="onSearchClick('brand')">查询</a> <a class="mini-button"
                onclick="onClearClick('brand')">清除</a>
            </div>
            <div style="float: right; padding-bottom: 2px;">
              <a class="mini-button" onclick="onOkClick('brand')">确定</a>
            </div>
            <div style="clear: both;"></div>
          </div>
          <div id="datagridBrand" class="mini-datagrid" style="width: 380px; heigth: 200px"
            borderStyle="border:0" showPager="true" fitColumn="false"
            onrowdblclick="onRowClickBrand"
            url="enumValue/datagrid?showPager=true&enumTypeId=${brandEnumTypeId}">
            <div property="columns">
              <div type="indexcolumn"></div>
              <div field="enumText" width="100" headerAlign="center">备选品牌</div>
            </div>
          </div>
        </div></td>

      <td class="form-label" style="width: 240px;">规格：<input id="specLookup"
        name="properties['specId']" class="mini-lookup" style="width: 168px; margin: 0 0 0 0"
        textField="enumText" valueField="id" onvalidation="onlookupSpecValidation" popupWidth="auto"
        showPopupOnClick="true" allowInput="false" emptyText="请选择规格值" popup="#gridPanelSpec"
        grid="#datagridSpec" multiSelect="false" value="" text="" />
        <div id="gridPanelSpec" class="mini-panel" title="header" iconCls="icon-add"
          style="width: 400px; height: 250px;" showToolbar="true" showCloseButton="true"
          showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
          <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
            <div style="float: left; padding-bottom: 2px;">
              <span>规格：</span> <input id="keyTextSpec" class="mini-textbox" allowInput="true"
                style="width: 160px;" onenter="onSearchClick('spec')" /> <a class="mini-button"
                onclick="onSearchClick('spec')">查询</a> <a class="mini-button"
                onclick="onClearClick('spec')">清除</a>
            </div>
            <div style="float: right; padding-bottom: 2px;">
              <a class="mini-button" onclick="onOkClick('spec')">确定</a>
            </div>
            <div style="clear: both;"></div>
          </div>
          <div id="datagridSpec" class="mini-datagrid" style="width: 380px; heigth: 200px"
            borderStyle="border:0" showPager="true" fitColumn="false" onrowdblclick="onRowClickSpec"
            url="enumValue/datagrid?showPager=true&enumTypeId=${specEnumTypeId}">
            <div property="columns">
              <div type="indexcolumn"></div>
              <div field="enumText" width="100" headerAlign="center">备选规格</div>
            </div>
          </div>
        </div></td>
    </tr>
  </table>
  <script type="text/javascript">
      mini.parse();

      function onRowClickBrand(e) {
        onOkClick('brand');

      }
      function onRowClickSpec(e) {
        onOkClick('spec');
      }
    </script>
</body>
</html>