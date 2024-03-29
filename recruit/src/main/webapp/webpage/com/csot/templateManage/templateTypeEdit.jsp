<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>模板类型</title>
<style>
.title {
  padding: 8px;
  border-bottom: 2px solid #888;
  font-size: 1.4em;
}

.form-table {
  margin-top: 20px;
}

.form-table .mini-textbox {
  width: 150px;
}

.form-table tr td {
  padding: 6px 0;
}

.form-table .form-label {
  width: 80px;
  text-align: left;
  padding-right: 10px;
  vertical-align: top;
}

.form-table .mini-button {
  width: 70px;
}
</style>
<script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>
  <div id="form1" class="main">
    <form id="templateId" style="width: 750px;">

      <table class="form-table">
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;类型名称：</td>
          <td><input name="typeName" class="mini-textbox" value="${ templateType.typeName }"
            required="true" requiredErrorText="类型名称不能为空" vtype="maxLength:100"
            maxLengthErrorText="类型名称不能超过100个字符" /></td>
            <td> <input name="id" class="mini-hidden" value="${templateType.id}"/>
            </td>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;类型：</td>
          <td><input name="typt" class="mini-radiobuttonlist" value="${templateType.typt }"
            data="[{id: 1, text: '邮件模板'}, {id: 2, text: '短信模板'}]" /></td>
        </tr>

        <tr>
          <td></td>
          <td><a id="button1" class="mini-button" onclick="onOk()">保存</a></td>
        </tr>
      </table>
    </form>
  </div>

  <script type="text/javascript">
      mini.parse();
      var form1 = new mini.Form("#form1");

      var jsWebRoot = "${webRoot}";

      function onOk() {

        $("input[name='docKeyWord']").each(function() {
          if ($(this).attr('checked') == false) {
            alert($(this).val());
          }
        });
        mini.get("button1").setEnabled(false)
        var data = form1.getData(true);// / 获取表单多个控件的数据
        /**
         * 表单序列化后的数据传参注意：Ajax参数不需要设置contentType
         */
        form1.validate();
        if (form1.isValid() == false)
          return;
        else {
          $.ajax({
            url : jsWebRoot + "/templateType/save",
            type : "post",
            data : data,
            dataType : "json",
            success : function(data) {
              if (data.success == true) {
                alert("保存成功！");
                CloseWindow("close", form1);
              } else {
                mini.alert("保存失败！" + data.msg);
              }
            }
          });
        }
      }
    </script>
</body>
</html>