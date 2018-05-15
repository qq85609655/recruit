<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/permission.css"/>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>权限</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
  	<div class="co-left">
    	<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    </div>
   	<div class="co-right">
    	<div class="position-path co-right-center">
    		<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">系统管理</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">角色权限管理</span>
      </div>
    	<div class="co-right-main co-right-center">
		  	<div class="con-title">权限角色管理</div>
		  	<div class="account-content">
		  	  <div class="permissionTip">
		  	    <br>
		  	    <span>权限更改后,用户需要重新登陆才有效</span>
		  	  </div>
		  	  <form action="">
		  	    <input type="hidden" name="roleId" id="roleId" value="${roleId }">
		  	    <input type="hidden" name="flag" id="flag" value="${flag }">
		  	    <input type="hidden" name="userId" id="userId" value="${userId }">
		  	    <div class="permissionContent">
		  	      <table class="permissionTable" >
		  	        <thead>
	  	            <c:choose>
	  	              <c:when test="${flag=='menuId' }">
	  	                <tr class="tbodyTr">
		  	                <td width="25%">一级菜单</td>
		  	                <td>二级菜单</td>
		  	              </tr>
	  	              </c:when>
	  	              <c:otherwise>
	  	                <tr class="tbodyTr">
		  	                <td width="25%">模块</td>
		  	                <td>权限设置</td>
		  	              </tr>
	  	              </c:otherwise>
	  	            </c:choose>
		  	        </thead>
		  	        <tbody id="permissionTbody">
			  	        <c:if test="${ not empty pageResourceList }">
			  	          <c:forEach var="item" items="${pageResourceList }">
			  	      			<tr>
			  	        			<td width="20%">${item.menuName }<input type="checkbox" name="permission" checked value="${item.permission }" resourceId="${item.id }" style="display:none;"/></td>
			  	        			<td>
			  	        				<c:if test="${not empty item.resourceList }">
			  	                  <c:forEach var="citem" items="${item.resourceList }" >
			  	                    <li><input type="checkbox" class="cPermission" name="permission" value="${citem.permission }" resourceId="${citem.id }">${citem.menuName}</li>
			  	                  </c:forEach>
			  	                </c:if>
			  	        			</td>
			  	      			</tr>
			  	      	  </c:forEach>
			  	        </c:if>
		  	        </tbody>
		  	        <tfoot>
		  	          <tr height="50px;">
		  	            <td style="text-align:right;">
		  	              <c:if test="${ empty userId }">
		  	                <input type="button" class="submit_btn" value="保存权限" onclick="submitData()"> 
		  	              </c:if>
		  	              <c:if test="${not empty userId }">
		  	                <input type="button" class="submit_btn" value="保存权限" onclick="submitUserData()">
		  	                 <input type="button" class="submit_btn" value="恢复角色权限" onclick="retainRolePermission()">
		  	              </c:if>
			  	            <input type="checkbox" id="checkAll" onclick="checkAllBox()">全选 
		  	            </td>
		  	            <td></td>
		  	          </tr>
		  	        </tfoot>
		  	   	  </table>
		  	 	  </div>
		  	  </form>
		  	</div>
			</div>
		</div>
	</div>
  <script type="text/javascript" src="${webRoot}/resources/js/system/permission.js"></script>
</body>
</html>