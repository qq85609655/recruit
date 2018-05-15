<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
  <script>
  	mini.alert("用户名或密码错误！", "登录错误", goLoginPage);
  	function goLoginPage() {
      window.location.href="webpage/login.jsp";
      // 如果login.jsp本身就是首选的<welcome-file>, 则可以使用下面的语句
      // window.location.href="";
  	}
  </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>