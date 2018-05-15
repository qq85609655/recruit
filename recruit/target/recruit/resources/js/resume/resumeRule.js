var Page = {
	init: function() {	
		mini.parse();
		grid = mini.get("datagrid");
		grid.load(
			{},
		    function(msg) {Page.gridLoadData(msg.data)},
		    function(msg) {mini.alert(msg);}
		);
	},
	ajaxData: function() { // 发送ajax获取数据
		$.ajax({
			url: basePath + "/resume/resumeRule/queryAll",
			type:"post",
			data:{},
			dataType : "json",
			success: function(msg) {Page.gridLoadData(msg.data)},
			error:function(msg){mini.alert(msg);}
		});
	},
	gridLoadData: function(data) { // 加载表格数据
		var columnSet = [
		    {field: "field1_name", headerAlign: "center", align: "center", header: "字段一"},
     	    {field: "field1_score", headerAlign: "center", align: "center", header: "字段一分数"},
     	    {field: "field2_name", headerAlign: "center", align: "center", header: "字段二"},
     	    {field: "field2_score", headerAlign: "center", align: "center", header: "字段二分数"},
     	    {field: "field3_name", headerAlign: "center", align: "center", header: "字段三"},
     	    {field: "field3_score", headerAlign: "center", align: "center", header: "字段三分数"},
     	    {field: "total_score", headerAlign: "center", align: "center", header: "总分数"},
     	    {field: "field1", headerAlign: "center", align: "center", header: "操作",renderer: "Page.onRenderer"},
     	];
     	if(data && data.length > 0) {
     		columnSet.unshift({type: "checkcolumn"},{type: "indexcolumn"});
     		grid.set({columns: columnSet});
     	}
     	else {
     		grid.set({columns: columnSet});
     	}	
	},
	onRenderer: function(e) { // 操作栏渲染
		var record = e.record;
	    var uid = record._uid;
	    return "<a class='font-icon icon-cancel-1' title='删除' onclick='Page.delRow(\"" + uid + "\")'></a>";
	},
	delRow: function(row_uid) { // 删除判重条件
		var row = grid.getRowByUID(row_uid);
	    if(row) {
			SaveData(basePath + "/resume/resumeRule/remove/" + row.id, "", function(e) {
		        if (e.success != null) {
		          if (e.success) {
		        	  window.location.reload(true);
		          } else {
		              ShowFailureTip(e.msg);
		          }
		        }
			});
	    }	
	},
	resumeRuleAdd: function() { // 新增判重条件窗口
	  mini.open({
	    url : basePath + "/webpage/com/csot/resume/resumeRuleAdd.jsp", 
	    title : "新增判重条件(最多可选三项)", // 标题
	    width : 800, // 宽度
	    height : 500, // 高度
	    allowResize : true, // 允许尺寸调节
	    allowDrag : true, // 允许拖拽位置
	    showCloseButton : true, // 显示关闭按钮
	    showMaxButton : true, // 显示最大化按钮
	    showModal : true, // 显示遮罩
	    loadOnRefresh : true, // true每次刷新都激发onload事件
	    onload : function() { // 弹出页面加载完成
	    },
	    ondestroy : function(action) { // 弹出页面关闭前
	      if (action == "ok") { // 如果点击"确定"
	    	var ids = "";
	        var iframe = this.getIFrameEl();
	        var rows = iframe.contentWindow.GetData();
	        for(var i = 0; i < rows.length; i++) {
	        	ids += "," + rows[i].id;
	        }
	        if(ids.length > 0) {
	        	ids = ids.substr(1);
	        }
	        SaveData(basePath + "/resume/resumeRule/save", {fields: ids}, function(e) {
	          if (e.success != null) {
	            window.location.reload(true);
	          } else {
	            ShowFailureTip(e.msg);
	          }
	        });
	      }
	    }
	  });
	},
	onValueChanged: function() { // 判重分数发生变化
		var hidden = $("#passLineSave").hasClass("none");
		if(hidden) {
			$("#passLineSave").removeClass("none");
		}
	},
	lineSave: function() { // 分数线修改保存
		var t = mini.get("lineSpin");
		SaveData(basePath + "/resume/resumeRule/lineSave/" + t.getValue(), null, function(e) {
	        if (e.success != null) {
	          if (e.success) {
	        	  ShowSuccessTip(e.msg);
	          } else {
	              ShowFailureTip(e.msg);
	          }
	        }
		});
	}
};
Page.init();