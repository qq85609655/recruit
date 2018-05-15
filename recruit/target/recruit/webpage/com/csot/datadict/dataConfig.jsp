<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>数据配置</title>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/dataConfig.css"/>
	</head>
	<body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-left">
        <jsp:include page="/webpage/left-bar.jsp"></jsp:include>
      </div>
      <div class="co-right">
        <div class="position-path co-right-center">
    	  	<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">数据配置</span>
    		</div>
    		<div class="co-right-main co-right-center">
	      	<div class="con-title">数据配置</div>
	      	<div class="data-tree blue radius">
		    		<div class="table-operate">
							<input type="button" id="addRow" class="button radius btn" value="新增" onclick="dataConfig('#addRow')"></input> 
							<input type="button" id="updateRow" class="button radius btn" value="编辑" onclick="dataConfig('#updateRow')"></input>
							<input type="button" id="removeRow" class="button radius btn" value="删除" onclick="removeRow()"></input>
						</div>
						<div id="treegrid1" class="mini-treegrid" url="${webRoot}/datadictGroupController/queryDatadictList" showTreeIcon="true" 
    					treeColumn="typeName" idField="groupId" parentField="typePid" resultAsTree="false" expandOnDblClick="true" expandOnLoad="0" onNodeClick="onNodeClick" onExpand="afterExpand" onCollapse="afterCollapse">
    		  		<div property="columns">
        				<div type="indexcolumn"></div>
        		  	<div name="typeName" field="typeName">
        		  		配置名称<input property="editor" class="mini-textbox" style="width:150px;" />
        		  	</div>
        		  	<div field="typeCode">
        		  		配置编码<input property="editor" class="mini-textbox"  value="0" style="width:50px;"/>
        		  	</div>
    					</div>
			  		</div>
			  		<!-- 更新数据配置一级项 -->
    		  	<div id="data-config-win" class="mini-window"
	     				style="width: 300px;height: 136px; display: none;" title="更新数据配置一级项"  showFooter="true">
	  					<div class="data-config-win" >
				  			<p>配置名称：<input style="width: 200px; height: auto;" type="text" id="typeName" /></p>
         		  	<p>配置编码：<input style="width: 200px; height: auto;" type="text" id="typeCode" /></p>
	    				</div>
	    				<div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
      			  	<input type="button" value="确定" onclick="saveDataGroup('data-config-win')" style="vertical-align:middle;width: 62px;height: 23px;">
      			  	<input type="button" value="取消" onclick="hideWindow('data-config-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    				</div>
			  		</div>
			  		<!-- 更新数据配置二级项 -->
    		  	<div id="data-group-type-win" class="mini-window"
	     				style="width: 300px;height: 136px; display: none;" title="更新数据配置二级项" showFooter="true">
	  					<div class="data-config-win" >
				  			<p>配置名称：<input style="width: 200px; height: auto;" type="text" id="typeName1" /></p>
         		  	<p>配置注释：<input style="width: 200px; height: auto;" type="text" id="typeComment" /></p>
	    				</div>
	    				<div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
      			  	<input type="button" value="确定" onclick="saveDataGroupType('data-group-type-win')" style="vertical-align:middle;width: 62px;height: 23px;">
      			 	 	<input type="button" value="取消" onclick="hideWindow('data-group-type-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    				</div>
			  		</div>
					</div>
		  	</div>
			</div>
		</div>
		<jsp:include page="/webpage/footer.jsp"></jsp:include>
	</body>
	<script>var typeGroupCode = "${typeGroupCode}";</script>
	<script type="text/javascript" src="${webRoot}/resources/js/dataConfig.js"></script>
</html>