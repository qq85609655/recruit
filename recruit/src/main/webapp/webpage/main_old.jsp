<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<html>
  <head>
	  <title>首页</title>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-left">
    		<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    	</div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><span class="path-leaf">我的首页</span>
    	  </div>
    	  <div class="co-right-main co-right-center">
    	  
    	  </div>
    	</div>   	  
    </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
  
</html>