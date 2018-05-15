var Page = {
	init: function() {	
		mini.parse();
		grid = mini.get("datagrid");
		grid.load();
	},
	onRenderer: function (e) { // 操作栏渲染
	    var grid = e.sender;
	    var record = e.record;
	    var uid = record._uid;
		var str = "<a class='font-icon icon-edit-1' title='修改' onclick='Page.editRow(\"" + uid + "\")'></a>" +
				  "<a class='font-icon icon-cancel-1' title='删除' onclick='Page.delRow(\"" + uid + "\")'></a>";
		if(grid.isEditingRow(record)) {
	        str = "<a class='font-icon icon-check' title='确定' onclick='Page.updateRow(\"" + uid + "\")'></a>"
	            + "<a class='font-icon icon-cancel-1' title='取消' onclick='Page.cancelRow(\"" + uid + "\")'></a>";
	    }
		return str;
	},
	addRow: function() { // 新增一行         
	    var newRow = {};
	    grid.cancelEdit();
	    grid.addRow(newRow, 0);
	    grid.beginEditRow(newRow);
	},
	editRow: function(row_uid) { // 编辑行
	    var row = grid.getRowByUID(row_uid);
	    if (row) {
	        grid.cancelEdit();
	        grid.beginEditRow(row);
	    }
	},
	cancelRow: function(row_uid) { // 取消编辑或新增           
	    grid.reload();
	},
	updateRow: function(row_uid) { // 修改或新增
		var row = grid.getRowByUID(row_uid);
		var form = new mini.Form("#datagrid");
        form.validate();
        if(form.isValid() == false) return;
		grid.commitEdit();
	    var data = {
	    	id : row.id,
	    	fieldName: row.fieldName,
	    	score : row.score
	    };
	    SaveData(basePath + "/resume/resumeRuleField/save", data, function(e) {
	        if (e.success != null) {
		          if (e.success) {
		            grid.reload();
		          } else {
		            ShowFailureTip(e.msg);
		          }
		        }
	    });
	},
	delRow: function(row_uid) { // 删除一行
		var row = grid.getRowByUID(row_uid);
	    if (row) {
			SaveData(basePath + "/resume/resumeRuleField/remove/" + row.id, "", function(e) {
		        if (e.success != null) {
		          if (e.success) {
		            ShowSuccessTip(e.msg);
		            grid.reload();
		          } else {
		            ShowFailureTip(e.msg);
		          }
		        }
			});
	    }
	}
};
Page.init();