<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<% 
 String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/public/head.css"/>
<div class="head">
	<div class="logo-text">华星光电</div>
	<div class="head-right">
		<div class="message head-item">
			<span class="title" id="messageTitle">消息</span> <span class="message-alert">8</span> &nbsp;<span
				class="more"></span>
			<!-- 消息的弹框 -->
			<div class="" id="messageFeedbackBox" style="display: none;">
			  <span id="mFUpTri"></span>
			  <span>消息中心</span>
			  <input type="hidden" id="hidMessageTips" value="收到44条新消息其中动态消息消息33条其中提醒消息消息2条其中进展报告消息9条">
			  <input type="hidden" id="hidNewMessageCount" value="44">
			  <input type="hidden" id="getMessageCountUrl" value="http://feedback.hirede.com/GetMessageCountFromLastTime?authToken=9LOzFj9mIcwTW%2bCkY09Mew%3d%3d">
			  <input type="button" id="btnRefreshNewMessageStatus" value="">
			  <ul>
	        <li data-newmessagecount="33" data-category="hirede_100" class="messageStatusItem">
	          <a>动态消息</a>
	            <span>(0)</span>
	        </li>
	        <li data-newmessagecount="2" data-category="hirede_101" class="messageStatusItem">
	            <a>提醒消息</a>
	            <span>(0)</span>
	        </li>
	        <li data-newmessagecount="9" data-category="hirede_102" class="messageStatusItem">
	            <a>进展报告</a>
	            <span>(0)</span>
	        </li>
	        <li data-newmessagecount="0" data-category="hirede_103" class="messageStatusItem">
	            <a>系统消息</a>
	            <span>(0)</span>
	        </li>
		    </ul>
		  </div>
		</div>
		<div class="user head-item">
			<span class="user-img font-icon">&#xe81d;</span> <span
				class="title user-name"><shiro:principal type="java.lang.String"/></span> &nbsp;<span class="more"></span>
			<!-- 登陆人的弹框 -->
			<div id="PersonSettings">
		    <div class="PersonSettingsArrow"></div>
		    <ul id="currentUserAccount">
		      <li><span class="c999left">您当前使用的帐号： </span></li>
		      <li><span title="账号有效时间：2016/3/31"><shiro:principal type="java.lang.String"/></span></li>
		    <!--   <li><span style="line-height: 12px;" class="c999left">账号过期时间：</span><span>2016/3/31</span></li> -->
		    </ul>
		    <ul id="settingItems">
		      <li><a>个人中心</a></li>
		      <li><a>交接管理</a></li>
		      <li><a href="/recruit/baseUserController/modifyPassword/${w_Login_Client.user.id }">密码修改</a></li>
		      <li><a>招聘账号管理</a></li>
		      <li><a>面试地点管理</a></li>
		      <li><a>发送邮箱设置</a></li>
		      <li><a>常用联系人管理</a></li>
		      <li><a>消息订阅</a></li>
		      <li><a>切换到LM版</a></li>
		    </ul>
		    <ul id="menuSetting">
		    	<li><a>菜单排序</a></li>
		    </ul>
		    <ul class="normalItems">
		    	<li><a href="/recruit/loginController/logout">退出</a></li>
		    </ul>
		  </div>
		</div>
		<div class="user head-item">
			<span class="title help">帮助</span>
		</div>
		<div class="user head-item">
			<span class="title">反馈</span>
		</div>
	</div>
</div>


<script type="text/javascript" src="<%=basePath %>/resources/js/public/head.js"></script>