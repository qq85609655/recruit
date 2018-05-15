<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>发送邮件</title>
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
  height: 20px;
  visibility: hidden;
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
  width: 100px;
}

.fileArea {
  width: 99%;
  height: 48px;
  overflow-y: auto;
}

.fileStyle {
  float: left;
  margin-top: 7px;
  margin-left: 10px;
}
</style>
<script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>

  <div id="form1" class="main">
    <form id="templateId" style="width: 750px;">
      <div>
        <table>
          <tr class="jobEdit-tr" id="email_model_tr" style="margin-top: 20px;">
            <td><font style="margin-: 20px;" class="font-title">邮件模板：</font></td>
            <td><input id="modelId" type="hidden" name="modelId" value="" /> <inpu
                id="addEmailModel" class="mini-buttonedit" onbuttonclick="onEmailTemplateButtonEdit" /></td>
          </tr>
        </table>
      </div>
      <div class="title">
        <strong>邮件模板：</strong>
      </div>
      <table class="form-table">
        <tr>
          <td>
            <!-- <label>
              <span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;收件人：</label></td>
          <td>
             <input id="realName" value="${realName }" name="realName" class="mini-textbox" required="true" />  -->
            <input id="ids" value="${ids }" name="ids" class="mini-hidden" /> 
            <input  name="siteId" id="siteId" class="mini-hidden" /> 
            <input  name="postId" id="postId" class="mini-hidden" /> 
            <input name="stuName" id="stuName" class="mini-hidden" /> 
            <input name="school" id="school" class="mini-hidden" /> 
            <input name="org" id="org" class="mini-hidden" /> 
            <input name="center" id="center" class="mini-hidden" /> 
            <input name="yearth" id="yearth" class="mini-hidden" /> 
            <input name="showType" id="showType" class="mini-hidden" /> 
            <input
            id="radioValue1" name="radioValue1" class="mini-hidden" /> 
            <input
            id="radioValue2" name="radioValue2" class="mini-hidden" /> 
            <input
            id="radioValue3" name="radioValue3" class="mini-hidden" /> 
            <input
            id="radioValue4" name="radioValue4" class="mini-hidden" /> 
            <input
            id="radioValue5" name="radioValue5" class="mini-hidden" /> 
            <input
            id="radioValue6" name="radioValue6" class="mini-hidden" /> 
            <input
            id="radioValue7" name="radioValue7" class="mini-hidden" /> 
            <input
            id="radioValue8" name="radioValue8" class="mini-hidden" />

          </td>
          <%-- <input name="id" value="${relateId}" class="mini-hidden" /> 
          <input name="relateId" id="relateId" class="mini-hidden" />--%>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;邮件主题：</td>
          <td><input name="subject" class="mini-textbox" required="true" id="subjectText"
            requiredErrorText="模板主题不能为空" vtype="maxLength:200" maxLengthErrorText="模板主题不能超过200个字符" /></td>
        </tr>
        <tr id="uploadFileTr" class="jobEdit-tr">
          <td><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;上传附件：</td>
          <td colspan="3">
            <div>
              <input type="file" name="attachment" id="attachment" /> &nbsp;&nbsp; <a
                class="mini-button" id="upLoadButton" onclick="onUpload">上传</a>
            </div>
          </td>
        </tr>
        <tr class="jobEdit-tr" id="attchmentList">
          <td><span style="color: red;">*</span><font class="font-title">&nbsp;&nbsp;&nbsp;附件列表：</font></td>
          <td><input id="attchmentIds" type="hidden" name="attchmentIds" value="" />
            <div id="fileArea" class="fileArea">
              <span id="span1"></span><span id="span2"></span>
            </div></td>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;邮件内容：</td>
          <td><textarea id="content" name="context" vtype="maxLength:4000"
              maxLengthErrorText="模板内容不能超过4000个字符" required="true" requiredErrorText="模板内容不能为空">  </textarea>
          </td>
        </tr>
        <tr>
          <td></td>
          <td><a id="button1" class="mini-button" onclick="saveTemplate()">发送邮件</a> <span
            style="display: inline-block; width: 25px;"></span> <a class="mini-button"
            style="width: 100px;" onclick="onCancel()">关闭</a></td>
        </tr>
      </table>
    </form>
  </div>

  <script type="text/javascript">
      mini.parse();
      var form1 = new mini.Form("#form1");
      var jsWebRoot = "${webRoot}";
      var type = "${type}";
      var ids = "${ids}"; // 选中的学生id
      var btnEdit = mini.get("addEmailModel");
      var subjectText = mini.get("subjectText");

      
    </script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/campus/campusStuAllEmailSend.js"></script>
</body>
</html>