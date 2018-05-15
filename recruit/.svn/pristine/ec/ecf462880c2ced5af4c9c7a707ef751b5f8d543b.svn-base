<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>邮件模板</title>
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
      <div></div>
      <div class="title">
        <strong>邮件模板：</strong>
      </div>
      <table class="form-table">
        <tr>
          <td><label><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;收件人：</label></td>
          <td><input id="interviewer" type="hidden" name="interviewer" value="" />
              <input id="addInterviewers0" class="mini-buttonedit" onbuttonclick="onButtonEdit"/> <input id="candidateId" value="${candidateId}" name="candidateId" class="mini-hidden" /></td>
        </tr>
        <tr>
          <td class="form-label">候选人：</td>
          <td>${realName}</td>
        </tr>
        <tr>
        <tr>
          <td>相关资料：</td>
          <td>
             <input id="isBzjl" type="hidden" name="isBzjl" value="" />
          <input id="bzjl" type="checkbox" name="isEmailCheckbox" value="1"><label>标准简历</label>
          
          <input id="isJlyw" type="hidden" name="isJlyw" value="" />
          <input id="jlyw" type="checkbox" name="isEmailCheckbox" value="1"><label>简历原文</label> 
          </td>
        </tr>
         <td class="form-label">邮件模板:</td>
         <td>
            <input id="modelId" type="hidden" name="modelId" value="" />
            <input id="addEmailModel" class="mini-buttonedit" onbuttonclick="onEmailModelButtonEdit"/>
         </td>
        </tr>
        <tr style="height: 30px;" id="uploadArea">
          <td align="left" class="formLabel"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;上传附件：</td>
          <td colspan="3">
            <div>
              <input type="file" name="attachment" id="attachment" /> &nbsp;&nbsp; <a
                class="mini-button" onclick="onUpload">上传</a>
            </div>
          </td>
        </tr>
        <tr style="height: 50px;">
          <td class="formContent" colspan="4">
            <div id="fileArea" class="fileArea">
              <input id="attchmentIds" type="hidden" name="attchmentIds" value="" />
                       <div id="fileArea" class="fileArea"><span id="span1"></span><span id="span2"></span></div>
            </div>
          </td>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;邮件内容：</td>
          <td>
          <input id="emailContent" type="hidden" name="emailContent" value="" />
          <textarea id="content" name="context" vtype="maxLength:4000"
              maxLengthErrorText="模板内容不能超过4000个字符">${template.context} </textarea></td>
        </tr>
        <tr>
          <td></td>
          <td><a id="button1" class="mini-button" onclick="saveTemplate()">发送邮件</a><span
            style="display: inline-block; width: 25px;"></span> <a class="mini-button"
            style="width: 100px;" onclick="onCancel()">取消发送</a></td>
        </tr>
      </table>
    </form>
  </div>

  <script type="text/javascript">
      mini.parse();
      var form1 = new mini.Form("#form1");
      var jsWebRoot = "${webRoot}";
      var relateId = "${template.id}";
          
    </script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/candidate/sendMessage.js"></script>
</body>
</html>