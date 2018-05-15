<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.css"/>
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/choosePerson.css"/>
<!-- 选择人员 -->
			<div class="mini-window" id="selPostBy-choose-win" style="width: 607px; display: none;" title="选择人员 " showFooter="true">
		      <div class="selPost-content">  
			     <div class="selPostBy-upper">
				    <div class="selPostBy-upper-data">
				      <div style="padding-top: 10px;">
				        <div class="selPostBy-background-data">
				          <span><b>已选择相关人员:</b></span>
				        </div>
				        <div class="selPostBy-background-data2">
				          <div style="float:left;">
				            &nbsp;&nbsp;<span id="selPostBy-data-span"></span>&nbsp;
				          </div>
				          <div style="float:left;">
				             <img src="${webRoot}/resources/images/x.jpg" class="person-img">
				          </div>
				        </div>
				       </div>
				     </div>
				    <div class="selPostBy-upper-content">
				      <p class="selPostBy-upper-p"><span class="mini-panel-title">常用联系人<span style="display:none;">(<a style="color:#5278D9;">管理</a>)</span></span></p>
				    </div>
				  </div>
				  <div class="selPostBy-middle">
				    <div class="selPostBy-middle-data">
				      <span class="usual" value="${w_Login_Client.user.id }">${w_Login_Client.user.name }</span>
				    </div>
				    <div class="selPostBy-middle-content">
				      <p class="selPostBy-middle-p"><span class="mini-panel-title">快速查找</span></p>
				    </div>
				  </div>
				  <div class="selPostBy-bottom">
				    <div class="selPostBy-bottom-data">
				      <input type="text" class="radius account-search" id="accountSearch" value="请输入人员姓名或人员账号">
				    </div>
				    <div class="selPostBy-bottom-content">
				      <p class="selPostBy-bottom-p"><span class="mini-panel-title">按部门查询</span></p>
				    </div>
				  </div>
				  <div class="selPostBy-footer">
				    <div class="selPostBy-footer-tool">
				      <input type="button" name="department" id="selPostBy-departmentBtn" class="selPostBy-departmentBtn dep-choosebtn" value="选择部门">&nbsp;&nbsp;
				      <input type="button" name="query" class="selPostBy-queryByDept" value="查询">
				    </div>
				    <div class="selPostBy-department-data">
				      <ul></ul>
				    </div>
				  </div>
				  <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;border: white;">
		        <input type="button" value="确定" class="selPost-submit"  style="vertical-align:middle;width: 62px;height: 23px;">
		        <input type="button" value="取消" class="selPost-cancel" style="vertical-align:middle;width: 62px;height: 23px;">
		      </div>
				</div>
			</div>
			<script type="text/javascript" src="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.js"></script>