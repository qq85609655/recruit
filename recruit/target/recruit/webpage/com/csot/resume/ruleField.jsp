<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
		<%@include file="/webpage/common.jsp"%>
	  <title>规则字段设置</title>
	  <link type="text/css" rel="stylesheet" href="${ctx}/resources/css/resume/ruleField.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"><jsp:param value="判重规则" name="currentPage"/></jsp:include>
    <div class="co">
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${ctx}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">简历库</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">规则字段设置</span>
    	  </div>
			  <div class="co-right-center">
			  	<div class="tab">
			  		<a class="tab-item" href="${ctx}/resume/resumeRule/main">设置判重规则</a>
			  		<a class="tab-item active">字段列表</a>
			  	</div>
			  	<div class="field-table">
			  		<a class="btn-a condition-add" onclick="Page.addRow()">新增字段</a>
			  		<div id="datagrid" class="mini-datagrid table" allowResize="true" url="${ctx}/resume/resumeRuleField/datagrid?showPager=false&sortField=createDate"
      				showEmptyText="true" showPager="false" emptyText="没有查询到相应的数据！" idField="id">
      				<div property="columns">
        				<div field="id" type="checkcolumn"></div>
        				<div type="indexcolumn"></div>
        				<div field="fieldName" name="fieldName" align="center" headerAlign="center" allowSort="true">字段
        					<input property="editor" required="true" class="mini-textbox editor-input"/>
        				</div>
        				<div field="score" name="score" align="center" headerAlign="center" allowSort="true">分数
        					<input property="editor" vtype="int" class="mini-textbox editor-input"/>
        				</div>
        				<div align="center" headerAlign="center" renderer="Page.onRenderer">操作</div>
      				</div>
    				</div>
			  	</div>
				</div>
	  	</div>
		</div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
    <script src="${ctx}/resources/js/resume/ruleField.js"></script>
  </body>
</html>
