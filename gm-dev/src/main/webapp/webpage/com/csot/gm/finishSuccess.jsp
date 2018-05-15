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
<body onload="window.setTimeout('windowTips()',5000)">
  <script type="text/javascript">
  	function windowTips() {
  		alert("网页自动关闭异常，请手动关闭对话框"); // PLM_GM_CREATION_PART_NO_SUCCESS
  	}
  	
  </script>
</body>
</html>