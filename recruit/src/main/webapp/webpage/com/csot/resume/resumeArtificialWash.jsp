<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
		<%@include file="/webpage/common.jsp"%>
	  <title>简历清洗-人工清洗</title>
	  <link type="text/css" rel="stylesheet" href="${ctx}/resources/css/resume/resumeArtificialWash.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">简历库</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">人工清洗</span>
    	  </div>
			  <div class="co-right-center">
			  	<div class="tab">
			  		<a class="tab-item active">日程</a>
			  		<a class="tab-item">全部日程</a>
			  	</div>
			  	<div class="main-item">
			  		<div class="operate-bar">
				  		<a class="btn-a" onclick="">下一个</a> 
				  		<a class="btn-a" onclick="">重复</a> 
				  		<a class="btn-a" onclick="">不重复</a> 
			  		</div>
			  	</div>
			  	<div class="main-item">
			  		<div class="main-item-left">
			  			<div class="main-item-dec">疑似简历</div>
			  			<div class="left-item">
			  				<input name="suspected-select" class="select" type="radio"></input>
			  				<div class="suspected"></div>
			  			</div>
			  			<div class="left-item">
			  				<input name="suspected-select" class="select" type="radio"></input>
			  				<div class="suspected"></div>
			  			</div>
			  			<div class="left-item">
			  				<input name="suspected-select" class="select" type="radio"></input>
			  				<div class="suspected"></div>
			  			</div>
			  		</div>
			  		<div class="main-item-center"></div>
			  		<div class="main-item-right">
			  			<div class="main-item-dec">新简历</div>
			  			<div class="right-item">&nbsp;</div>
			  		</div>
			  	</div>
				</div>
	  	</div>
		</div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
    <script src="${ctx}/resources/js/resume/resumeArtificialWash.js"></script>
  </body>
</html>

