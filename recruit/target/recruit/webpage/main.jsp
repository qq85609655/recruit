<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>华星招聘</title>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <c:forEach items="${reminds}" var="remind">
            ${remind.remindContent }
              <br />
    </c:forEach>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
</html>