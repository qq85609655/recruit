<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<html>
<head>
	<title>常用标签</title>
	<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/commonlyUsedTag.css"/>
</head>
<body onload="removeLoad();">
	<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
		<div class="co-left">
			<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
		</div>
		<div class="co-right">
			<div class="position-path co-right-center">
				<span class="path-title">您的位置 :</span><a
					class="path-item a-decoration"
					href="${webRoot}/loginController/main">我的首页</a><em
					class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">人才库</a><em
					class="path-icon">&gt;&gt;</em><span class="path-leaf">常用标签</span>
			</div>
			<div class="co-right-main co-right-center">
				<div class="con-title">常用标签</div>
				<div class="main blue radius">
				  <div id="jobManaTxt">
				  	<p class="pt5 pb15">
				  	    <a type="button" class="increase" id="btnAddCategory" onclick="btnAddCategory('resume-category-win','#btnAddCategory','添加标签类别')">+添加标签类别</a>&nbsp;
				  	    <a type="button" class="increase" id="btnAddCommonlyUsedTag" onclick="btnAddCommonlyUsedTag('resume-label-win','#btnAddCommonlyUsedTag','添加常用标签')">+添加常用标签</a>
				  	  <span class="c999">（最多可设置50个类别，150个标签）</span>
				  	</p>
				  	<c:forEach var="category" items="${categoryList}" varStatus="sta">
				  		<c:set var="percent" value="0" />
            	<c:forEach var="la" items="${labelList}">
	            	<c:if test="${category.id eq la.categoryId}">
	            		<c:set var="percent" value="${percent+1}" />
	            	</c:if>
	            </c:forEach>
					  	<div class="tags_Category_title">
	              <strong>${category.name}</strong>&nbsp;&nbsp;
	              <c:if test="${not empty u_category_addCategory }">
	                <a id="btnUpdateCategory${sta.index+1}" onclick="btnAddCategory('resume-category-win','#btnUpdateCategory${sta.index+1}','编辑标签类别')" data-categoryid="${category.id}" data-categoryname="${category.name}" class="editCategory">编辑</a>&nbsp;
	            	</c:if>
	            	<c:if test="${percent==0}">
	            		<a id="delCategory${sta.index+1}" class="editCategory" onclick="delCategory('#delCategory${sta.index+1}')" data-categoryid="${category.id}">删除</a>
	            	</c:if>
	            </div>
	            <div class="label-list">
	            	<c:forEach var="label" items="${labelList}">
	            		<c:if test="${category.id eq label.categoryId}">
	            			<p class="commonlyUsedTag">
	                  	<span class="tagsList">${label.name}<a href="/recruit/label/removeById?id=${label.id}" class="deleteCommonlyUsedTag closeTags">&nbsp;x</a></span>       
	            			</p>
	            		</c:if>
	            	</c:forEach>
	           		<c:if test="${percent==0}">
            			<p class="commonlyUsedTag">
                  	<span class="c999">该类别暂无标签</span>       
            			</p>
           			</c:if>
           		</div>
				  	</c:forEach>
			  	</div>
		  	</div>
			</div>
		    <!-- 更新类别 -->
		    <div id="resume-category-win" class="mini-window"
			     style="display: none;" title="更新类别" showFooter="true">
			  	<div class="win-co" >
						<p>
		          <span>类别名称：</span>
		          <input type="hidden" id="id" name="id">
		        	<input type="text" id="categoryName" class="category-name radius" name="categoryName">
		      	</p>
			    </div>
			    <div property="footer" class="win-footer">
			      <input type="button" class="win-footer-btn" value="确定" onclick="addCategory('resume-category-win')">
			      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('resume-category-win')">
			    </div>
			</div>
	    	<!-- 添加标签 -->
		    <div id="resume-label-win" class="mini-window"
			     style="display: none;" title="添加类别" showFooter="true">
			  	<div class="win-co" >
						<p class="tr">
		          <span  class="label">标签类别：</span>
		          <input id="categroyId" class="mini-combobox label-select" textField="name" valueField="id" 
    						url="/recruit/category/datagrid" showNullItem="true" allowInput="true" nullItemText="请选择" valueFromSelect="true"/>    
		        </p>
		        <p class="tr">
		          <span class="label">标签名称；</span>
		          <input type="text" id="labelName" class="label-name radius" name="labelName">
		        </p>
			    </div>
			    <div property="footer" class="win-footer">
			      <input type="button" class="win-footer-btn" value="确定" onclick="addLabel('resume-label-win')">
			      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('resume-label-win')">
			    </div>
			</div>
			<div id="tipWrap">
				<div class="tips_icon_t tips_icon_f">已存在同名称的类别</div>
				<div id="oTipsWrap">
					<input class="cancel_btn_pop" value="确定" type="button" onclick="closeTipWrap('#tipWrap')">
				</div>
			</div>
			<div id="tipWrapLabel">
				<div class="tips_icon_t tips_icon_f">该标签类别已存在同名称的标签</div>
				<div id="oTipsWrapLabel">
					<input class="cancel_btn_pop" value="确定" type="button" onclick="closeTipWrap('#tipWrapLabel')">
				</div>
			</div>
	  	</div>
	</div>
	<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/commonlyUsedTag.js"></script>
</html>