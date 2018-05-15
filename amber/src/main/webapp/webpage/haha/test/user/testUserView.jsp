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
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post">
      <input name="id" value="${testUser.id}" class="mini-hidden" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">名称:</td>
          <td class="formContent">${testUser.name}</td>
        </tr>
        <tr>
          <td class="formLabel">家庭地址:</td>
          <td class="formContent">${testUser.address }</td>
        </tr>
        <tr>
          <td class="formLabel">出生日期:</td>
          <td class="formContent"><fmt:formatDate value="${testUser.birthday }" type="both"
              pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
        <tr>
          <td class="formLabel">年龄:</td>
          <td class="formContent">${testUser.age }</td>
        </tr>
        <tr>
          <td class="formLabel">工资:</td>
          <td class="formContent">${testUser.salary }</td>
        </tr>
        <tr>
          <td class="formLabel">工作地址:</td>
          <td class="formContent">${testUser.workPlace }</td>
        </tr>
      </table>
    </form>
  </div>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>