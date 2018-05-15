<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />

<title>发送邮件</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">

  <div class="table-operate">
    <input type="button" id="sendOne" value="按模板发送邮件" onclick="sendByTemplate()" />&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" id="sendTwo" value="自定义发送邮件" onclick="sendByDefinition()" />
  </div>

</body>
<script type="text/javascript">
  mini.parse();

  var webRoot = "${webRoot}";
  var ids = "${ids}";
  var type = "${type}";
  
</script>
<script type="text/javascript" src="${webRoot}/resources/js/campus/campusStuEmailSend.js"></script>
</html>