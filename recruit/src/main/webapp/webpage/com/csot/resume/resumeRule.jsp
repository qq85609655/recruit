<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
		<%@include file="/webpage/common.jsp"%>
	  <title>判重规则设置</title>
	  <link type="text/css" rel="stylesheet" href="${ctx}/resources/css/resume/resumeRule.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${ctx}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">简历库</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">判重规则</span>
    	  </div>
			  <div class="co-right-center">
			  	<div class="tab">
			  		<a class="tab-item active">设置判重规则</a>
			  		<a class="tab-item" href="${ctx}/webpage/com/csot/resume/ruleField.jsp">字段列表</a>
			  	</div>
			  	<div class="tip-bar">
			  		<div class="tip-msg">
			  			<p>说明：请不要随意变更此设置，此设置的变更将会使人才库简历全部重新判重，耗时较长，可能会影响使用。</p>
			  		</div>
			  	</div>
			  	<div class="main-item score">
			  		<label>判重分数线：</label><input id="lineSpin" class="mini-spinner" value="${passLine}" onvaluechanged="Page.onValueChanged"></input><a id="passLineSave" class="btn-a none" onclick="Page.lineSave();">保存</a>
			  	</div>
			  	<div class="main-item table">
			  		<label>判重条件:</label>
			  		<div>
			  			<div id="datagrid" class="mini-datagrid" allowResize="true" url="${ctx}/resume/resumeRule/queryAll"
      					showEmptyText="true" showPager="false" emptyText="没有查询到相应的数据！" idField="id">
    					</div>
				  		<a class="btn-a condition-add" onClick="Page.resumeRuleAdd();">新增判重条件</a>
			  		</div>
			  	</div>
				</div>
	  	</div>
		</div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
    <script src="${ctx}/resources/js/resume/resumeRule.js"></script>
  </body>
</html>
