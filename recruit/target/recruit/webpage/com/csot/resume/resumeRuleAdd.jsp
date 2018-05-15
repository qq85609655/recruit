<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
		<%@include file="/webpage/common.jsp"%>
	  <title>新增判重规则</title>
	  <style>
	  body{height:auto;}
	  .mini-grid-rows-view{height:auto;}
  	.mini-grid-emptyText{text-align:center;}
  	.operate-bar{position:absolute;bottom:0;left:250px;}
  	.btn-a{margin:20px;width:80px;}
  	.mini-grid-border .mini-grid-pager{border-bottom:1px solid #999;}
	  </style>
  </head>
  <body onload="removeLoad();">
    <div class="main">
 			<div id="datagrid" class="mini-datagrid" allowResize="true" url="${ctx}/resume/resumeRuleField/datagrid?showPager=false&sortField=createDate"
      		showEmptyText="true" emptyText="没有查询到相应的数据！" idField="id" multiSelect="true" showPager="false">
      		<div property="columns">
        		<div type="checkcolumn"></div>
        		<div field="fieldName" align="center" headerAlign="center" allowSort="true">字段</div>
        		<div field="score" align="center" headerAlign="center" allowSort="true">分数</div>
      		</div>
    		</div>
    		<div class="operate-bar">
        	<a class="btn-a btn-submit" onclick="onOk()">提交</a> 
        	<a class="btn-a btn-cancle" onclick="onCancel()">取消</a>
      	</div>
 		</div>
 		<script>

 		mini.parse();
 		var grid = mini.get("datagrid");
 		grid.load();

 		/**
 		 * 获取数据
 		 */
 		function GetData() {
 		  var rows = grid.getSelecteds();
 		  return rows;
 		}

 		function CloseWindow(action) {
 		  if (window.CloseOwnerWindow)
 		    return window.CloseOwnerWindow(action);
 		  else
 		    window.close();
 		}
 		
 		// 确认关闭当前窗口
 		function onOk() {
 			var rows = grid.getSelecteds();
 	 		if(rows.length > 3) {
				mini.alert("最多可选三项！");
				return;
 	 	 	}
 	 		else if(rows.length == 0) {
 	 			mini.alert("请至少选择一项，再提交！");
				return;
 	 	 	}
 		  CloseWindow("ok");
 		}
 		
 		// 取消关闭当前窗口
 		function onCancel() {
 		  CloseWindow("cancel");
 		}
 		</script>
  </body>
</html>

