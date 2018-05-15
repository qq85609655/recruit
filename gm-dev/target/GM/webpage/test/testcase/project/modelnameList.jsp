<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" />

<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<script src="plugins/jquery/jquery-1.6.2.min.js"></script>
</head>
<body>
<p><a href="webpage/index.jsp">ModelnameList</a>
<p><input class="gotoButton" value="goto View" type="button">
<p><a href="modelnameController/view">ModelnameView</a>
</body>
<script>
function iclick() {
  window.location.href="webpage/test/testcase/project/modelnameView.jsp";
}

$(document).ready(function(){
  alert("hello");
  $(".gotoButton").click(function(){
    window.location.href="webpage/test/testcase/project/modelnameView.jsp";
  });
});
</script>
</html>