<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@include file="/webpage/common.jsp"%>

<title>Insert title here</title>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}

.form-label {
  color: #888;
  display: inline-block;
  padding-left: 8px;
  font-size: 12px;
  font-family: 微软雅黑;
  width: 70px;
  align: left
}
</style>
</head>
<body>

  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <input id="breakOff" name="breakOff" class="mini-hidden" value="有" /> <input id="id" name="id"
      class="mini-hidden" value="${id}" />
    <div style="width: 500px; margin: 10px" align="center">
      <table class="form-table" border="0" align="left">
        <tr>
          <td class="form-label">违约原因</td>
          <td><input id="breakOffId" class="mini-combobox"
            style="width: 180px; margin-right: 40px;"
            url="/recruit/datadictGroupTypeController/getDictsByCode/breakOffReason"
            valueField="typeId" textField="typeName" onvaluechanged="onReasonChanged" /></td>
        </tr>
        <tr>
          <td colspan="3"><input id="reasonId" name="breakOffReason" class="mini-textarea"
            style="width: 250px; height: 130px; margin-left: 10px; margin-top: 35px;" /></td>
        </tr>
      </table>
    </div>
    <div style="height: 30px;"></div>
    <div style="width: 300px; margin: 3px; margin-top: 56px" align="center">
      <a class="mini-button" onclick="submitForm()" style="width: 80px; margin-right: 40px;">确定</a>
      <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 80px;">取消</a>
    </div>
  </form>
  <script type="text/javascript">
      mini.parse();
      var form = new mini.Form("form1");
      var reasonCombobox = mini.get("breakOffId");
      var reasonTextarea = mini.get("reasonId");

      function onReasonChanged(e) {
        var reason = reasonCombobox.getText();
        if ("" == reason || null == reason) {
          e.isValid = false;
          e.errorText = "请选择违约原因";
        }
        if ("其他" == reason) {
          reasonTextarea.setValue("");
          reasonTextarea.setReadOnly(false);
        } else {
          reasonTextarea.setValue(reason);
          //设置为只读模式
          reasonTextarea.setReadOnly(true);
        }
      }

      function submitForm() {

        var data = form.getData(true);//获取表单多个控件的数据
        form.validate();
        if (form.isValid() == false) {
          return;
        }
        $.ajax({
          url : "/recruit/campusStudentController/save",
          type : "post",
          data : data,
          dataType : "json",
          success : function(data) {
            if (data.success) {
              alert("违约原因设置成功！");
              CloseWindow("close", form);
            } else {
              mini.alert(data.msg);
            }
          }
        });
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>

</body>
</html>
