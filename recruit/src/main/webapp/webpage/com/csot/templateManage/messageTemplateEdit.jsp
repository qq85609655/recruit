<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>短信模板</title>
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
  width: 200px;
}

.form-table #content {
  width: 550px;
  height: 300px;
  visibility: hidden;
}

.form-table .form-label {
  width: 80px;
  text-align: right;
  padding-right: 10px;
  vertical-align: top;
}

.form-table tr td {
  padding: 6px 0;
}

.form-table .mini-button {
  width: 100px;
}
</style>
<script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>
  <div id="form1" class="main">
    <form id="templateId" style="width: 750px;">
      <div class="title">
        <strong>短信模板：</strong>
      </div>
      <table class="form-table">
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;模板类型：</td>
          <td><input class="mini-combobox" style="width: 200px;" textField="typeName"
            valueField="typt" value="${template.type}" required="true" requiredErrorText="模板类型不能为空"
            url="${webRoot}/templateController/getTemplateType/${'2'}"
            <input name="type" value="2" class="mini-hidden" /></td>
            <input name="id" value = "${template.id}" class="mini-hidden" />
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;模板名称：</td>
          <td><input name="title" class="mini-textbox" value="${ template.title }"
            required="true" requiredErrorText="模板名称不能为空" vtype="maxLength:500"
            maxLengthErrorText="模板名称不能超过500个字符" /></td>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;短信内容：</td>
          <td><textarea id="content" name="context" vtype="maxLength:4000"
              maxLengthErrorText="模板内容不能超过4000个字符">${ template.context }</textarea></td>
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
    </script>
  <script type="text/javascript" src="${webRoot}/resources/js/templateManage/templateEdit.js"></script>
</body>
</html>