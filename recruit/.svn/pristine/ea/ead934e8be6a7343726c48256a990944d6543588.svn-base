<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>修改密码</title>
</head>
<body>
  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-left">
        <jsp:include page="/webpage/left-bar.jsp"></jsp:include>
      </div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    		<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">个人信息</span>
    	  </div>
    	    <div class="co-right-main co-right-center">
			      <div class="con-title">个人信息设置</div>
			      <div class="myresume blue_radius">
						  <form id="mainForm" method="post">
						    <input name="id" class="mini-hidden" id="id" value="${user.id }"/>
						    <input name="account" class="mini-hidden" value="${user.account }">
						    <input name="status" class="mini-hidden" >
						    <div style="padding-left: 11px; padding-bottom: 5px;">
						      <table style="table-layout: fixed;" class="pwdTable">
						        <tr>
											<td class="c999left">帐号：</td>
											<td>${user.account }</td>
										</tr>
						        <tr>
						          <td>原密码：</td>
						          <td><input id="password1" name="password1" class="mini-password" required="true"
						            vtype="minLength:6" onvalidation="validErrorText" /><label id="password_error"
						            class="errorText"></label></td>
						        </tr>
						         <tr>
											<td class="c999left">新密码：</td>
											<td><input id="password" name="password" class="mini-password" required="true"
						            vtype="minLength:6" onvalidation="validErrorText" /><label id="password_error"
						            class="errorText"></label></td>
										</tr>
						        <tr>
						          <td>再次输入新密码：</td>
						          <td><input id="password2" name="password2" class="mini-password" required="true"
						            vtype="minLength:6" onvalidation="doublePasswordValidation" /><label
						            id="password2_error" class="errorText"></label></td>
						        </tr>
						      </table>
						    </div>
						    <div id="dialogFooter" style="text-align: left; padding: 18px;">
						      <a class="mini-button" onclick="onOk()" style="width: 60px; margin-right: 10px;">确定</a> <a
						        class="mini-button" onclick="onCancel()" style="width: 60px; margin-left: 10px;">取消</a>
						    </div>
						  </form>
					  </div>
  				</div>
  		 </div>
    </div>
</body>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserPasswordEdit.css"/>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${webRoot }/resources/js/system/baseUserPasswordEdit.js"></script>
</html>
