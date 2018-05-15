var typePid;
var groupId;
var typeId;
$(function(){
	mini.parse();
	var tree = mini.get("treegrid1");
	var nodes =tree.findNodes(function(node) {
		if(node.typeCode) {
			if( typeGroupCode == node.typeCode) return true;
		}
		else {
			return false;
		}
	});
	tree.selectNode(nodes[0]);
	tree.expandNode(nodes[0]);
})

// 配置名称点击事件
function onNodeClick(e){
    var tree = mini.get("treegrid1")
    node = tree.getSelectedNode();
    field = e.field;
    if(field == "typeName"){
//    	alert(node.typePid);
    }
}

// 添加数据字典点击事件
function dataConfig(cl){
	validateSelect(cl);
}

// 新增、更新数据字典group数据
function saveDataGroup(id){
	var win = mini.get(id);
	win.hide();
	var groupName = $("#typeName").val();
	var groupCode = $("#typeCode").val();
	if(groupId == "0"){
		groupId = "";
	}
	jQuery.ajax({
        url: "/recruit/datadictGroupController/saveDataGroup",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"groupId": groupId,"groupName":groupName,"groupCode":groupCode,"groupPid":"0"},
        success: function (json, textStatus) {
        	alert(json.msg);
        	mini.get("treegrid1").reload();
        }
    });
}

// 新增、更新数据字典group数据
function saveDataGroupType(id){
	var win = mini.get(id);
	win.hide();
	var typeName = $("#typeName1").val();
	var typeComment = $("#typeComment").val();
	if(!groupId){
		groupId = typePid;
	}
	jQuery.ajax({
        url: "/recruit/datadictGroupTypeController/saveDataGroupType",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"typeId":typeId,"groupId": groupId,"typeName":typeName,"typeComment":typeComment},
        success: function (json, textStatus) {
        	alert(json.msg);
        	mini.get("treegrid1").reload();
        }
    });
}

// 删除数据配置一级项
function removeRow(){
	var tree = mini.get("treegrid1")
    node = tree.getSelectedNode();
	if (node) {
    	typePid = node.typePid;
    	groupId = node.groupId;
    } else {
    	alert("请选中节点");
    	return false;
    }
	if(typePid){
		if(groupId){
			if (confirm("是否删除该配置项?")) {
				//删除配置项数据
				jQuery.ajax({
			        url: "/recruit/datadictGroupController/removeByGroupId",
			        type: "POST",
			        cache: false,
			        async: false,
			        dataType: "json",
			        data: {"groupId": groupId},
			        success: function (json, textStatus) {
			        	if(json.msg != "删除成功"){
			        		alert(json.msg);
			        	}
			        	mini.get("treegrid1").reload();
			        }
			    });

			}
		}else{
			if (confirm("是否删除该配置项?")) {
				//删除子配置项数据
				jQuery.ajax({
			        url: "/recruit/datadictGroupTypeController/removeByGroupTypeId",
			        type: "POST",
			        cache: false,
			        async: false,
			        dataType: "json",
			        data: {"id":node.id},
			        success: function (json, textStatus) {
			        	if(json.msg != "删除成功"){
			        		alert(json.msg);
			        	}
			        	mini.get("treegrid1").reload();
			        }
			    });
			}
		}
	}
	
}

// 验证是否选择事件
function validateSelect(cl){
	var tree = mini.get("treegrid1")
    node = tree.getSelectedNode();
	if (node) {
		if(cl == '#updateRow'&& !node.typePid){
			return false;
		}
    	typePid = node.typePid;
    	groupId = node.groupId;
    	typeId = node.id;
    } else {
    	alert("请选中节点");
    	return false;
    }
	if(!node.typePid){
		// 添加数据字典一级选项
		var id = "data-config-win";
		$("#typeName").val("");
		$("#typeCode").val("");
	}else{
		// 修改数据字典一级选项
		if(cl == '#updateRow' && !node.id){
			var id = "data-config-win";
			$("#typeName").val(node.typeName);
			$("#typeCode").val(node.typeCode);
		}else if(cl == '#addRow'){
			if(node.id){
				return;
			}
			// 添加数据字典二级选项弹出框
			var id = "data-group-type-win";
			$("#typeName1").val("");
			$("#typeComment").val("");
		}else{
			// 修改数据字典二级选项弹出框及给控件赋值
			var id = "data-group-type-win";
			$("#typeName1").val(node.typeName);
			$("#typeComment").val(node.typeComment);
		}
	}
	// 弹出window框
	var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(lt.left+60, lt.top-100);
}