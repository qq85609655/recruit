$(function() {
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load({status:"011-002"});
	// 获取部门树
	queryDep();
});

var recruitPositionId ='';
$(".more-expand").die("click");
$(".more-expand").live("click",function() {
	$(".more-search").toggle();
	$(this).find(".font-icon").toggleClass("icon-angle-double-up").toggleClass("icon-angle-double-down");
});
function search() {
	var positionName = $("#positionName1").val();
	var publisher = $("#hidPostBy").val();
	var recruiter = $("#hidrecruiter").val();
	var label = $("#label1").val();
	var startDistributeDate = mini.get("#startDistributeDate").getFormValue();
	var endDistributeDate = mini.get("#endDistributeDate").getFormValue();
	var department = departmentChoose["#department1"];
	var positionCode = $("#positionCode1").val();
	var departmentCode =$("#departmentCode1").val();
//	var status = $("#status1").val();
	var status = $("#status1 option:selected").attr("id");
	var workPlace = $("#workPlace1 option:selected").attr("id");
	var startExpireDate = mini.get("#startExpireDate").getFormValue();
	var endExpireDate = mini.get("#endExpireDate").getFormValue();
	var recruitType="";
	$("input[name='recruitType1']:checked").each(function(){
		recruitType += $(this).val()+"," 
	});
	recruitType = recruitType.substr(0,recruitType.length-1);
//	var positionType = $("#positionType1").val();
//	var positionLevel = $("#positionLevel1").val();
	var positionType = $("#positionType1 option:selected").attr("id");
	var positionLevel = $("#positionLevel1 option:selected").attr("id");
	mini.parse();
    var grid = mini.get("datagrid1");
    var positionManage =grid.getSelecteds();
	grid.load({positionName:positionName, 
		publisher:publisher,
		recruiter:recruiter,
		label:label,
		startDistributeDate:startDistributeDate,
		endDistributeDate:endDistributeDate,
		department:department,
		positionCode:positionCode,
		departmentCode:departmentCode,
		status:status,
		workPlace:workPlace,
		startExpireDate:startExpireDate,
		endExpireDate:endExpireDate,
		recruitType:recruitType,
		positionType:positionType,
		positionLevel:positionLevel});
}

function onKeyEnter(e) {
    search();
}

// 获取选中checkbox的getPositionId
function getPositionId() {
    var grid = mini.get("datagrid1");
    var positionManage =grid.getSelecteds();
    var PositionIdArray = new Array();
    for(var i = 0; i < positionManage.length; i++) {
    	PositionIdArray[i] = positionManage[i].recruitPositionId.trim();
    }
    recruitPositionId = PositionIdArray.join(",");
}

// 分发职位
function distributionPosition() {
	getPositionId();
	if(recruitPositionId=="") {
		openErrormsg(validateChecked);
		return false;
	}
	$(".page-loading").show();
	window.location.href = "/recruit/position/distribute?recruitPositionId="+recruitPositionId;
}

// 修改保密设置
function updateSetSecurity(id) {
	var secrecy = $("input[name='secrecy']:checked").val();
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/position/setSecurity",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"recruitPositionId": recruitPositionId,"secrecy":secrecy},
        success: function (json, textStatus) {
        	alert("设置成功");
        	mini.get("datagrid1").reload();
        }
    });
}

// 职位重新发布
function againRelease(id) {
//	var validity = mini.get("#validity").getFormValue();
	var validity = $("#validity option:selected").val();
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/position/againRelease",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"recruitPositionId": recruitPositionId,"validity":validity},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid1").reload();
        }
    });
}

// 职位启用
function enablePosition(id) {
	var effectiveDate = mini.get("#effectiveDate").getFormValue();
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/position/enablePosition",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"recruitPositionId": recruitPositionId,"effectiveDate":effectiveDate},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid1").reload();
        }
    });
}

// 招聘完成、招聘暂停
function updatePositionStatus(id,status) {
	if(status == 5) {
		status = "011-005";
	}else {
		status = "011-001";
	}
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/position/updatePositionStatus",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"recruitPositionId": recruitPositionId,"status":status},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid1").reload();
        }
    });
}

// 招聘删除
function delPosition(id) {
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/position/delPosition",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"recruitPositionId": recruitPositionId},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid1").reload();
        }
    });
}

// 导出excel
function exportPosition() {
	var positionName = $("#positionName1").val();
	var recruiter = $("#recruiter1").val();
	var label = $("#label1").val();
	var startDistributeDate = mini.get("#startDistributeDate").getFormValue();
	var endDistributeDate = mini.get("#endDistributeDate").getFormValue();
	var department = $("#department1").val();
	var positionCode = $("#positionCode1").val();
	var departmentCode =$("#departmentCode1").val();
	var status = $("#status1 option:selected").attr("id");
	var workPlace = $("#workPlace1").val();
	var startExpireDate = mini.get("#startExpireDate").getFormValue();
	var endExpireDate = mini.get("#endExpireDate").getFormValue();
	var recruitType="";
	$("input[name='recruitType1']:checked").each(function(){
		recruitType += $(this).val()+"," 
	});
	recruitType = recruitType.substr(0,recruitType.length-1);
	var positionType = $("#positionType1 option:selected").attr("id");
	var positionLevel = $("#positionLevel1 option:selected").attr("id");
	var ser = "positionName="+positionName+"&"+
	"recruiter="+recruiter+"&"+
	"label="+label+"&"+
	"startDistributeDate="+startDistributeDate+"&"+
	"endDistributeDate="+endDistributeDate+"&"+
	"department="+department+"&"+
	"positionCode="+positionCode+"&"+
	"departmentCode="+departmentCode+"&"+
	"status="+status+"&"+
	"workPlace="+workPlace+"&"+
	"startExpireDate="+startExpireDate+"&"+
	"endExpireDate="+endExpireDate+"&"+
	"recruitType="+recruitType+"&"+
	"positionType="+positionType+"&"+
	"positionLevel="+positionLevel;
	var urlval = '/recruit/position/queryPositionManaListExcel?'+ser;
	window.open(urlval);
}

// 保密设置点击事件
function setSecurity(validateChecked,id,cl) {
	getPositionId();
	if(recruitPositionId==""){
		openErrormsg(validateChecked);
		return false;
	}
	//弹出window框
    var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(lt.left+60, lt.top-100); 
}

// 验证是否选择职位
function openErrormsg(validateChecked) {
	$(validateChecked).show();
	setTimeout("coloseErrorMsg(validateChecked)",1000*2);
}

// 关闭选择职位提示框
function coloseErrorMsg(validateChecked) {
	$(validateChecked).hide();
}

// 为数据添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value = e.value;
    var grid=mini.get("datagrid1");
    if(field=="recruitPositionId") {
    	grid.hideColumn( "recruitPositionId" ); 
     }
    //超链接任务
    if (field == "positionName") {
        e.cellHtml = '<a id="' + row.recruitPositionId + '" class="showCellTooltip color-blue">' + value + '</a>';
    }
    if(field =="effectiveDate" && row.effectiveDate!=null){
    	 e.cellHtml = new Date(row.effectiveDate).format("yyyy-MM-dd"); 
    }
    if(field =="expectDate" && row.expectDate !=null){
   	  e.cellHtml = new Date(row.expectDate).format("yyyy-MM-dd");  
    }
    if(field =="releaseDate" && row.releaseDate !=null){
   	  e.cellHtml = new Date(row.releaseDate).format("yyyy-MM-dd");  
    }
    if(field =="modifyDate" && row.modifyDate !=null){
   	  e.cellHtml = new Date(row.modifyDate).format("yyyy-MM-dd");  
    }
	if(field =="expireDate" && row.expireDate !=null){
	  e.cellHtml = new Date(row.expireDate).format("yyyy-MM-dd");  
	}
}

$(".showCellTooltip").live("mouseenter",function() {
	var lt = $(this).offset();
	var l=lt.left,
	    t=lt.top;
	$(".position-operate").show();
	recruitPositionId = $(this).attr("id");
	$("#positionView")[0].href = basePath + "/position/preview?recruitPositionId=" + recruitPositionId;
	if($("#positionEdit")[0] !=null) {
		$("#positionEdit")[0].href = basePath + "/position/positionEdit?recruitPositionId=" + recruitPositionId;
	}
	if($("#positionDistribute")[0] !=null) {
		$("#positionDistribute")[0].href = basePath + "/position/distribute?recruitPositionId=" + recruitPositionId;
	}
	$(".position-operate").css({
		top:t-60,
		left:l+90
	});
}).live("mouseleave",function() {
	$(".position-operate").hide()
})

$(".position-operate").mouseleave(function() {
	$(this).hide();
}).mouseenter(function() {
	$(".position-operate").show();
})

// 弹出标记页面
function openLabel(validateChecked,id,cl) {
	getPositionId();
	if(recruitPositionId==""){
		openErrormsg(validateChecked);
		return false;
	}
	$("#txtTag").val("多个标记词间请用空格隔开");
	var len = $("#addedTags span");
	if(len.length>0){
		$("#addedWrap").show();
	}else{
		$("#addedWrap").hide();
	}
	showAtPos(id, cl); 
}

// 取消按钮关闭弹出框
function closeWindow(id) {
	$("#addedTags span").empty();
	hideWindow(id)
}

// 为标记添加初始提示
$("#txtTag").focus(function() {
	var text = $(this).val();
	if(text=="多个标记词间请用空格隔开") {
		$("#txtTag").val("");
	}
}).blur(function() {
	var text = $(this).val();
	if(text.trim() == "") {
		$("#txtTag").val("多个标记词间请用空格隔开");
	}
})

// 新增标记
$("#btnAddTagConfirm").click(function() {
	var textTagValue = $("#txtTag").val();
	if(textTagValue == "多个标记词间请用空格隔开" || textTagValue.length==0){
		$(".tipMessage").show();
		return
	}
	$(".tipMessage").hide();
	$("#addedWrap").show();
	var valueArray = textTagValue.split(" ");
	var addedTagsValue = $("#addedTags span");
	var d="";
	if(valueArray.length>0) {
		if(addedTagsValue.length>0) {
			removeRepeat(addedTagsValue,valueArray);
		}
		for(var i=0;i<valueArray.length;i++) {
			d +="<span class='tagList'>"+valueArray[i]+"</span>";
		}
		$("#addedTags").show();
		$("#addedTags").append(d);
	}
	$("#txtTag").val("");
	$("#txtTag").focus();
});

// 删除标记
$(".tagList").live("click",function() {
	$(this).remove()
}).live("mouseenter",function() {
	$(this).css("backgroundColor","white");
}).live("mouseleave",function() {
	$(this).css("backgroundColor","#CDDEF2");
});

// 热门标记添加
$(".hotLabel").click(function() {
	$("#addedWrap").show();
	$(".tipMessage").hide();
	var text = $(this).text();
	var addedTagsValue = $("#addedTags span");
	if(addedTagsValue.length>0) {
		for(var i=0;i<addedTagsValue.length;i++) {
			if(text ==addedTagsValue[i].innerHTML) {
				return
			}
		}
		$("#addedTags").append("<span class='tagList'>"+text+"</span>");
	}else{
		$("#addedTags").append("<span class='tagList'>"+text+"</span>");
	}
})

// positioninfo页面关于职位的相关操作
function setPosition(positionId,winId) {
  recruitPositionId = positionId;
  var win = mini.get(winId); 
  win.showAtPos(300, 300); 
}

// 点击标记确认按钮ajax传值
function submitLabelValue(id) {
	var label = "";
	var addedTagsValue = $("#addedTags span");
	for(var i=0;i<addedTagsValue.length;i++) {
		if(i == addedTagsValue.length-1){
			label += addedTagsValue[i].innerHTML
		}else{
			label += addedTagsValue[i].innerHTML+",";
		}
	}
	if(label.length>0) {
		var win = mini.get(id);
		win.hide();
		jQuery.ajax({
	        url: "/recruit/position/addLabels",
	        type: "POST",
	        cache: false,
	        async: false,
	        dataType: "json",
	        data: {"recruitPositionId": recruitPositionId,"label":label},
	        success: function (json, textStatus) {
	        	alert("设置成功");
	        	mini.get("datagrid1").reload();
	        }
	    });
	}else{
		alert("请添加标记");
	}
}

// 除去重复的方法
function removeRepeat(preArray,array) {
	for(var j=0;j< preArray.length; j++){
		var span = preArray[j].innerHTML;
		for(var i=0;i<array.length;i++){
			if(span == array[i]){
				array.splice(i,1);
			}
		}
	}
	return array;
}

// 显示设置的panel弹出
$("#isShow").click(function() {
	var lt = $(this).offset();
	$(".showPosition-choose").show();
	$(".showPosition-choose").css({
		left:lt.left,
		top:lt.top-350
	});
});

// 当鼠标移开panel时隐藏
$("#isShow").mouseleave(function() {
	$(".showPosition-choose").hide();
})
$(".showPosition-choose").mouseenter(function() {
	$(this).show();
}).mouseleave(function() {
	$(this).hide();
});

// 点击checkbox设置显示的内容
$(".position-checkbox").click(function() {
	var column = $(this).val();
	var id = $(this).attr("id");
	var isChecked = $(this).attr("checked");
	if(isChecked == "checked") {
		$.cookie(id,"1",{ expires: 3650 });
		dataShow(column);
	}else{
		$.cookie(id,"0",{ expires: 3650 });
		dataHide(column);
	}
});

// 显示设置
function dataShow(column) {
    var grid = mini.get("datagrid1");
    grid.showColumn(column);
}

// dataGrid隐藏设置
function dataHide(column) {
	 var grid = mini.get("datagrid1");
	 grid.hideColumn(column);
}

// 初始化页面的选中与未选中状态
function loadData(e) {
	var grid = mini.get("datagrid1");
	var checkNum = $(".position-checkbox");
	for(var i=0;i<checkNum.length;i++){
		var id = checkNum[i].getAttribute('id');
		var cookKey = $.cookie(id);
		if(typeof(cookKey) == "undefined"){
			$.cookie(id,"1",{ expires: 3650 });
			$("#"+id).attr("checked", "checked"); 
		}else if(cookKey=="1"){
			var column = $("#"+id).val();
			$("#"+id).attr("checked","checked");
			grid.showColumn( column ); 
		}else{
			$("#"+id).attr("checked", false); 
			var column = $("#"+id).val();
			grid.hideColumn(column);
		}
	}
	$(".position-table").show();
}