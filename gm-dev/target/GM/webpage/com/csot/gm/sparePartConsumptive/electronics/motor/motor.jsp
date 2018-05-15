<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style>
</style>
</head>
<body>
  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <div style="width: 700px; margin: 10px" align="center">

      <%@ include file="/webpage/com/csot/gm/rawMaterial/classAndUserInfo.jsp"%>
      <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>唯一性属性</span>
        </legend>
        <%@ include file="/webpage/com/csot/gm/sparePartConsumptive/brandSpec.jsp"%>
      </fieldset>
      <%@ include file="/webpage/com/csot/gm/sparePartConsumptive/spareGenAttribute.jsp"%>
      <fieldset class="fieldset" id="fd3" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>其他属性</span>
        </legend>
        <table class="form-table" border="0" cellpadding="6" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 220px;">功率： <input id="combo11"
              class="mini-combobox" name="properties['powerId']" style="width: 173px;"
              valueField="id" onvalidation="onComboValidation"
              url="rawMaterial/getComboData?enumTypeId=${powerEnumTypeId}" required=""
              allowInput="true" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 220px;">原厂料号：<input id="oldNumber"
              emptyText="不能填写供应商，品牌，规格" name="properties['oldNumberId']" class="mini-textbox"
              value="" style="width: 160px" required="false" /></td>
            <td class="form-label" style="width: 100px;"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 220px;">设备类别：<input id="classLookup"
              name="properties['deviceClassId']" class="mini-lookup"
              style="width: 152px; margin: 0 0 0 0" textField="enumText" valueField="id"
              onvalidation="onlookupClassValidation" popupWidth="auto" showPopupOnClick="true"
              allowInput="false" emptyText="请选择设备类别" popup="#gridPanelClass" grid="#datagridClass"
              multiSelect="false" value="" text="" />
              <div id="gridPanelClass" class="mini-panel" title="header" iconCls="icon-add"
                style="width: 400px; height: 250px;" showToolbar="true" showCloseButton="true"
                showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
                <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
                  <div style="float: left; padding-bottom: 2px;">
                    <span>设备类别：</span> <input id="keyTextClass" class="mini-textbox"
                      allowInput="true" style="width: 160px;" onenter="onSearchClick('class')" /> <a
                      class="mini-button" onclick="onSearchClick('class')">查询</a> <a
                      class="mini-button" onclick="onClearClick('class')">清除</a>
                  </div>
                  <div style="float: right; padding-bottom: 2px;">
                    <a class="mini-button" onclick="onOkClick('class')">确定</a>
                  </div>
                  <div style="clear: both;"></div>
                </div>
                <div id="datagridClass" class="mini-datagrid" style="width: 380px; heigth: 200px"
                  borderStyle="border:0" showPager="true" fitColumn="false"
                  onrowdblclick="onRowClickClass"
                  url="enumValue/datagrid?showPager=true&enumTypeId=${deviceClassEnumTypeId}">
                  <div property="columns">
                    <div type="indexcolumn"></div>
                    <div field="enumText" width="100" headerAlign="center">备选设备类别</div>
                  </div>
                </div>
              </div></td>

            <td class="form-label" style="width: 220px;">设备厂商：<input id="plantLookup"
              name="properties['devicePlantId']" class="mini-lookup"
              style="width: 160px; margin: 0 0 0 0" textField="enumText" valueField="id"
              onvalidation="onlookupPlantValidation" popupWidth="auto" showPopupOnClick="true"
              allowInput="false" emptyText="请选择设备厂商" popup="#gridPanelPlant" grid="#datagridPlant"
              multiSelect="false" value="" text="" />
              <div id="gridPanelPlant" class="mini-panel" title="header" iconCls="icon-add"
                style="width: 400px; height: 250px;" showToolbar="true" showCloseButton="true"
                showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
                <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
                  <div style="float: left; padding-bottom: 2px;">
                    <span>设备厂商：</span> <input id="keyTextPlant" class="mini-textbox"
                      allowInput="true" style="width: 160px;" onenter="onSearchClick('plant')" /> <a
                      class="mini-button" onclick="onSearchClick('plant')">查询</a> <a
                      class="mini-button" onclick="onClearClick('plant')">清除</a>
                  </div>
                  <div style="float: right; padding-bottom: 2px;">
                    <a class="mini-button" onclick="onOkClick('plant')">确定</a>
                  </div>
                  <div style="clear: both;"></div>
                </div>
                <div id="datagridPlant" class="mini-datagrid" style="width: 380px; heigth: 200px"
                  borderStyle="border:0" showPager="true" fitColumn="false"
                  onrowdblclick="onRowClickPlant"
                  url="enumValue/datagrid?showPager=true&enumTypeId=${devicePlantEnumTypeId}">
                  <div property="columns">
                    <div type="indexcolumn"></div>
                    <div field="enumText" width="100" headerAlign="center">备选设备厂商</div>
                  </div>
                </div>
              </div></td>
          </tr>
        </table>
      </fieldset>
      <div style="text-align: center; padding: 10px;">
        <a id="rtnBtn" class="mini-button" onclick="onRtn()"
          style="width: 60px; margin-right: 20px;">返回</a> <a class="mini-button"
          onclick="submitForm()" style="width: 80px;">生成料号</a>
      </div>
      <%@ include file="/webpage/com/csot/gm/rawMaterial/checkAndCreate.jsp"%>
      <%@ include file="/resources/context/lazyResource.jsp"%>
    </div>
  </form>

  <script type="text/javascript">
      mini.parse();
      /* 默认选中值，联动选择等简单js */
      var comb4 = mini.get("combo4");
      comb4.select(0);
      var comb5 = mini.get("combo5");
      comb5.select(0);
      var comb6 = mini.get("combo6");
      comb6.select(0);
      var combobigClass = mini.get("combobigClass");
      combobigClass.select(0);

      function onRowClickClass(e) {
        onOkClick('class');
      }

      function onRowClickPlant(e) {
        onOkClick('plant');
      }
    </script>

</body>
</html>