<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>文件上传</title>
<%@ include file="/resources/context/headResource.jsp"%>
<script src="<%=basePath%>resources/js/jquery.form.js"></script>

<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
    <form id="form" method="post" enctype="multipart/form-data">
      <input name="id" value="${file.id}" type="hidden">
      <table >
        <tr>
          <th>创建人姓名：</th>
          <td><input class="mini-textbox" name="createName" value="${file.createName}" required="true" style="width:200px"/></td>
        </tr>
        <tr>
          <th>申请人工号：</th>
          <td><input class="mini-textbox" name="applicantCode" value="${file.applicantCode}" required="true" style="width:200px"/></td>
        </tr>
        <tr>
          <th>申请人姓名：</th>
          <td><input class="mini-textbox" name="applicantName" value="${file.applicantName}" required="true" style="width:200px"/></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><input class="mini-textarea" name="remark" value="${file.remark}" required="true" style="width:200px;height:80px;"/></td>
        </tr>
        <tr>
          <th>上传文件:</th>
          <td><input type="file" name="myFile" id="myFile" value="${file.fileName}" /></td>
        </tr>    
      </table>
    </form>
    <div style="text-align: center; padding: 10px;">
      <a class="mini-button" onclick="onOk" style="width: 60px; margin-right: 20px;">确定</a>
      <a class="mini-button" onclick="CloseWindow('cancel')" style="width: 60px;">取消</a>
    </div>
  <%@ include file="/resources/context/lazyResource.jsp"%>
    
  <script type="text/javascript">
    mini.parse();
    function onOk(e){
      var form = new mini.Form("form");
      form.validate();
      if (form.isValid() == false)
        return;
      if( $("#myFile").val() == "" ){
    	mini.alert( "上传文件不能为空！");
    	$("#myFile").focus();
    	return;
      }
      
      $("#form").ajaxSubmit({
        url : "fileUpload/upload",
        /*data : {
          id : "123"
        },*/
        dataType : 'json', //数据格式为json
        success : function(data) { //成功
          mini.alert(data.msg,"提示",function(e){
            CloseWindow(data.success ? "save" : "");
          });
        },
      });
    }
  </script>
  
</body>
</html>