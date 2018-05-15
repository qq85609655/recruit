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
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}

.form-table {
  font-size: 10px
}

fieldset {
  border: solid 1px #aaa;
  margin: 10px;
  font-size: 10px
}
</style>
</head>
<body>

  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <div style="width: 700px; margin: 10px" align="center">

      <h3 style="font-family: 微软雅黑">创建维修料号</h3>
      <input name="preCode" class="mini-hidden" value="${preCode}" /> <input name="partId"
        class="mini-hidden" value="${partId}" /> <input name="classId" class="mini-hidden"
        value="${classId}" /> <input name="uid" id="uid" class="mini-hidden" value="${uid}" /> <input
        name="partType" id="partType" class="mini-hidden" value="${partType}" />

      <fieldset class="fieldset" id="fd1" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span style="font-size: 10px; align: center" align="center">创建人信息</span>
        </legend>
        <table class="form-table" border="0" cellpadding="3" cellspacing="0">
          <tr>
            <!--  <td class="form-label" style="width: 100px;">厂别：
        <input name="userInfo.plant" class="mini-textbox" style="width:60px" required="true"/></td>
      -->
            <td class="form-label" style="width: 230px;">部门： <input id="department"
              name="userInfo.department" class="mini-textbox" value="${department}"
              style="width: 190px" required="true" allowInput="false" /></td>

            <td class="form-label" style="width: 90px;">工号： <input id="userCode"
              name="userInfo.userCode" class="mini-textbox" value="${userCode}" style="width: 50px"
              required="true" onvaluechanged="onValueChanged()" /></td>

            <td class="form-label" style="width: 100px;">姓名： <input id="userName"
              name="userInfo.userName" class="mini-textbox" value="${userName}" style="width: 60px"
              required="true" allowInput="false" /></td>

            <td class="form-label" style="width: 170px;">联系电话： <input id="telephone"
              name="userInfo.telephone" class="mini-textbox" value="${telephone}"
              style="width: 100px" required="true" allowInput="false" /></td>
          </tr>

        </table>
      </fieldset>

      <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>原料号填写</span>
        </legend>
        <table class="form-table" border="0" cellpadding="1" cellspacing="0">
          <tr>
            <td class="form-label" style="width: 230px;">原料号：<input id="oldNumber"
              name="oldNumber" class="mini-lookup" style="width: 168px; margin: 0 0 0 0"
              textField="partNo" valueField="id" popupWidth="auto" showPopupOnClick="true"
              allowInput="false" emptyText="请选择原料号" popup="#gridPanelPartNo" grid="#datagridPartNo"
              multiSelect="false" value="" text="" />
              <div id="gridPanelPartNo" class="mini-panel" title="header" iconCls="icon-add"
                style="width: 400px; height: 250px;" showToolbar="true" showCloseButton="true"
                showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
                <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
                  <div style="float: left; padding-bottom: 2px;">
                    <span>料号：</span> <input id="keyTextPartNo" class="mini-textbox"
                      allowInput="true" style="width: 160px;" onenter="onSearchClick()" /> <a
                      class="mini-button" onclick="onSearchClick()">查询</a> <a class="mini-button"
                      onclick="onClearClick()">清除</a>
                  </div>
                  <div style="float: right; padding-bottom: 2px;">
                    <a class="mini-button" onclick="onOkClick()">生成维修</a>
                  </div>
                  <div style="clear: both;"></div>
                </div>
                <div id="datagridPartNo" class="mini-datagrid" style="width: 380px; heigth: 200px"
                  borderStyle="border:0" showPager="true" fitColumn="false"
                  url="rawMaterial/getAllSpareConsumptivePartNo?showPager=true&partType=${partType}">
                  <div property="columns">
                    <div type="indexcolumn"></div>
                    <div field="partNo" width="100" headerAlign="center">备选料号</div>
                  </div>
                </div>
              </div></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 230px;">维修号：<input id="wxlh"
              emptyText="生成维修料号" allowInput="false" name="wxlh" class="mini-textbox" value=""
              style="width: 168px" required="" /></td>
          </tr>
        </table>
      </fieldset>

      <fieldset class="fieldset" id="fd3" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>属性信息</span>
        </legend>
        <div id="propertyGrid" class="mini-datagrid" style="width: 98%; height: 250px"
          allowCellSelect="true" idField="id" url="propertyValue/proValuedatagrid"
          allowResize="true" showPager="false" expanded="true">
          <div property="columns">
            <div field="propertyDisName" width="40" headerAlign="center" allowSort="true">属性名</div>
            <div field="propertyValue" width="40" headerAlign="center" allowSort="true">真实值</div>
            <div field="propertyValueText" width="40" headerAlign="center" allowSort="true">显示值</div>
            <div field="propertyType" width="20" headerAlign="center" allowSort="true">唯一性</div>
          </div>
        </div>

      </fieldset>
    </div>
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
  </form>
  <%@ include file="/resources/context/lazyResource.jsp"%>
  <script type="text/javascript">
      mini.parse();
      var gridPartNo = mini.get("datagridPartNo");
      var keyTextPartNo = mini.get("keyTextPartNo");
      var partType = mini.get("partType").getValue();
      gridPartNo.load();
      var oldNumberUp = mini.get("oldNumber");

      function onOkClick() {
        var oldNumber = oldNumberUp.getText();
        oldNumberUp.hidePopup();
        if (oldNumber == null || oldNumber == "")
          return;
        // 检查备品
        $.ajax({
          url : "partNo/checkWxType/partType/" + partType + "/partNo/" + oldNumber,
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            if (data.success == true) {
              var oldNumberId = oldNumberUp.getValue();
              var wxlh = mini.get("wxlh");
              var newNumber = oldNumber.substring(0, 7) + 'R' + oldNumber.substring(8);
              wxlh.setValue(newNumber);
              var propertyGrid = mini.get("propertyGrid");
              propertyGrid.load({
                partNoId : oldNumberId,
                sortField : "propertyName",
                sortOrder : "asc"
              });
            } else {
              mini.alert(data.msg, "error", CloseWindow);
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });

      }

      function onClearClick() {
        var oldNumber = mini.get("oldNumber");
        oldNumber.deselectAll();
      }

      function onSearchClick() {
        gridPartNo.setUrl("partNo/datagrid?showPager=true");
        gridPartNo.load({
          searchKey : keyTextPartNo.value
        });
      }

      var department = mini.get("department");
      var userCode = mini.get("userCode");
      var userName = mini.get("userName");
      var telephone = mini.get("telephone");

      // 手动更改工号，自动带出创建人信息
      function onValueChanged() {
        var code = userCode.getValue();

        $.ajax({
          url : "userInfo/getUserInfo/" + code,
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            if (true == data.success) {
              department.setValue(data.attributes.department);
              userName.setValue(data.attributes.userName);
              telephone.setValue(data.attributes.telephone);
              //默认情况下部门、姓名、联系电话不可编辑,输入工号后这些信息可编辑
              telephone.setAllowInput("true");
            } else {
              department.setValue("");
              userName.setValue("");
              telephone.setValue("");
              mini.alert(data.msg);
            }

          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });

      }

      var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
      var uid = mini.get("uid").getValue();
      function onRtn() {
        window.location.href = base + "rawMaterial/rawMaterial?uid=" + uid + "&partType="
            + partType;
      }

      function submitForm() {
        var form = new mini.Form("form1");
        form.validate();
        if (form.isValid() == false)
          return;

        var dd = $("#form1").serialize();
        var oldNumber = oldNumberUp.getText();
        var oldNumberId = oldNumberUp.getValue();
        var wxlh = mini.get("wxlh").getValue();
        // 检查是否已生成
        if (oldNumberId == null || oldNumberId == "" || wxlh == null || wxlh == "")
          return;
        var newNumber = oldNumber.substring(0, 7) + 'R' + oldNumber.substring(8);
        if (wxlh != newNumber) {
          mini.alert("生成维修料号错误，请重新生成！");
          return;
        }

        $.ajax({
          url : "rawMaterial/checkMaintainAndCreate/oldNumberId/" + oldNumberId + "/wxlh/" + wxlh,
          type : "post",
          async : false,
          data : dd,
          dataType : 'json', //数据格式为json
          success : function(data) {
            var partNoId = data.attributes.partNoId;
            var success = data.attributes.success;
            // 物料类型检查不通过
            if (success == "falseType" || success == "false") {
              showErrorTexts(data.attributes.message);
            } else if (success == "true") {
              window.location.href = base + "rawMaterial/createComplete"
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function showErrorTexts(errorTexts) {
        var s = errorTexts;

        var win = window
            .open(
                '',
                "",
                'height=200,width=450,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no, titlebar=no');
        win.document.open('text/html', 'replace');
        win.document.write(s);
        win.document.close();
      }
    </script>

</body>
</html>