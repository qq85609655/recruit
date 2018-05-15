//添加标签类别点击事件
function btnAddCategory(id,cl,title){
	//弹出window框
    var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(lt.left+60, lt.top-100); 
    $("#resume-category-win .mini-panel-title").text(title);
    $("#resume-category-win #id").val($(cl).attr("data-categoryid"));
    $("#categoryName").val($(cl).attr("data-categoryname"));
}
function delCategory(id){
	var categoryId = $(id).attr("data-categoryid");
	mini.confirm("确认删除","",function(action) {
		if(action == "ok") {
			window.location.href = "/recruit/category/removeById?id="+categoryId;
		}
	});
}
//添加标签点击事件
function btnAddCommonlyUsedTag(id,cl,title){
	//弹出window框
    var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(lt.left+60, lt.top-100); 
    $("#" + id + " .mini-panel-title").text(title);
}
//添加类别
function addCategory(id){
	var categoryId = $("#resume-category-win #id").val();
	var categoryName = $("#categoryName").val();
	var win = mini.get(id);
	jQuery.ajax({
        url: "/recruit/category/addCategory",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"id":categoryId,"name": categoryName},
        success: function (json, textStatus) {
        	if(json.msg == "修改成功" || json.msg == "新建成功"){
        		win.hide();
            	window.location.href = "/recruit/resume/commonlyUsedTag";
        	}else if(json.msg == "最多可设置50个类别"){
        		win.hide();
        		alert(json.msg);
        	}else{
        		$("#tipWrap").show();
        	}
        }
    });
}
//添加标签
function addLabel(id){
	var labelName = $("#labelName").val();
	var obj = mini.get("categroyId");
	var categoryId = obj.getValue();
	var win = mini.get(id);
	jQuery.ajax({
        url: "/recruit/label/addLabel",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"categoryId": categoryId,"name":labelName},
        success: function (json, textStatus) {
        	if(json.msg == "修改成功" || json.msg == "新建成功"){
        		win.hide();
            	window.location.href = "/recruit/resume/commonlyUsedTag";
        	}else if(json.msg == "最多可设置150个标签"){
        		win.hide();
        		alert(json.msg);
        	}else{
        		$("#tipWrapLabel").show();
        	}
        }
    });
}
//关闭提示信息
function closeTipWrap(id){
	$(id).hide();
}