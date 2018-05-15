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
</style>
</head>
<script src="${basePath}resources/js/ckeditor/ckeditor.js"></script>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post" style="height: 400px; width: 550px;">
      <div class="mini-fit">
        <input class="mini-hidden" value="${systemNotice.id}" name="id" />
        <input class="mini-hidden" value="" name="noticeContents" id="noticeContents"/>
        <div style="margin-top: 10px; margin-bottom: 10px;">
          <table>
            <tr>
              <td><lable>公告标题：</lable> <input id="noticeTitle" class="mini-textbox"
                name="noticeTitle" style="height: 20px; width: 480px;"
                value="${systemNotice.noticeTitle}" /></td>
            </tr>
          </table>
        </div>
        <div>
          <input id="editor1" name="editor1" class="mini-textarea" />
        </div>
      </div>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var noticeContentbox = mini.get("noticeContents");
      var editor = CKEDITOR.replace('editor1');
      editor.setData('${contents}');
      var form = new mini.Form("#mainForm");
      function onOk(e) {
        debugger;
        editor.updateElement();
        var editordata = editor.getData();
        noticeContentbox.setValue(editordata);
        form.validate();
        if (form.isValid() == false) {
          return;
        }
        var data = $("#mainForm").serialize();
        
        SaveData("systemNotice/save", data);
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>