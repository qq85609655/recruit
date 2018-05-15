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
          <td><input id="realName" value="${realName }" name="realName" class="mini-textbox"
            required="true" /> <input id="ids" value="${ids }" name="ids" class="mini-hidden" /></td>
          <input name="id" value="${template.id}" class="mini-hidden" />
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;邮件主题：</td>
          <td><input name="subject" class="mini-textbox" required="true"
            requiredErrorText="模板主题不能为空" vtype="maxLength:200" maxLengthErrorText="模板主题不能超过200个字符" /></td>
        </tr>
        <tr style="height: 30px;" id="uploadArea">
          <td align="left" class="formLabel"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;上传附件：</td>
          <td colspan="3">
            <div <c:if test="${type == 'view' }"> </c:if>>
              <input type="file" name="attachment" id="attachment" /> &nbsp;&nbsp; <a
                class="mini-button" onclick="onUpload">上传</a>
            </div>
          </td>
        </tr>
        <tr style="height: 50px;">
          <td class="formContent" colspan="4">
            <div id="fileArea" class="fileArea">
              <c:forEach var="att" items="${attachments }">
                <c:if test="${att.type == 'emailTemplate' }">
                  <div class="fileStyle" id="del_div_${att.id }">
                    <input id="${att.id }" type="button" onclick="delAttach('${att.id}')" value="删除" />
                    &nbsp;&nbsp; <a href="javascript:downloadAttach('${att.id }')"><span>${att.showName }</span></a>
                  </div>
                </c:if>
              </c:forEach>
            </div>
          </td>
        </tr>
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;邮件内容：</td>
          <td><textarea id="content" name="context" vtype="maxLength:4000"
              maxLengthErrorText="模板内容不能超过4000个字符"> </textarea></td>
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
      var type =  "${sendType}";
          
    </script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/campus/campusStuEmailSendByDef.js"></script>
</body>
</html>