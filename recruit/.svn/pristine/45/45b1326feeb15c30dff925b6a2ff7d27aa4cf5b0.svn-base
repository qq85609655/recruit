<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/tagSelect.css"/>
<div id="tagSelectWin" class="mini-window" style="width: 700px; display: none;" title="添加标签 " showFooter="true">
	<div class="pop-main">
		<div class="pop-co">
			<div id="tagSelected" class="tag-selected radius">
				<span class="title">已增加的标签 :</span>
			</div>
			<div class="tag-list">
					<div class="title"><span class="title-text">常用标签</span><a id="tagMana" class="tag-mana-a">标签管理 <span class="font-icon icon-angle-double-right"></span></a></div>
					<div class="tag-all">
						<div id="tagVoid" class="void-tip">无数据</div>
					</div>
			</div>
		</div>
	</div>
	<div property="footer" class="win-footer">
		<input type="button" class="win-footer-btn" id ="confirmTagSelect" value="确定"></input>
		<input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('#tagSelectWin')"></input>
	</div>
</div>
<script type="text/javascript" src="${webRoot}/resources/js/resume/tagSelect.js"></script>