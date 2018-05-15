$(function() {
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load({publisher:$("#hidrecruiter").val()});
	queryDep();
	eventInit();
});

function search() {
	var department = departmentChoose[departmentBtn];
	var publisher = $("#hidrecruiter").val();
	var publishSite = $("#publishSite1").val();
	var publishResult =$("#publishResult1").val();
	var positionName = $("#positionName1").val();
	var startDistributeDate = mini.get("#startDistributeDate").getFormValue();
	var endDistributeDate = mini.get("#endDistributeDate").getFormValue();
	var startExpireDate = mini.get("#startExpireDate").getFormValue();
	var endExpireDate = mini.get("#endExpireDate").getFormValue();
	mini.parse();
    var grid = mini.get("datagrid1");
	grid.load({department:department, 
		publisher:publisher,
		publishSite:publishSite,
		publishResult:publishResult,
		positionName:positionName,
		startDistributeDate:startDistributeDate,
		endDistributeDate:endDistributeDate,
		startExpireDate:startExpireDate,
		endExpireDate:endExpireDate});
}

// 为数据添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value = e.value;
    var grid=mini.get("datagrid1");
    if(field=="recruitPositionId") {
    	grid.hideColumn("recruitPositionId"); 
    }
    switch(field) {
	    case "positionName":
	    	e.cellHtml = "<a target='_blank' href='" + basePath + "/position/preview?recruitPositionId=" + row.recruitPositionId + "' class='color-blue'>" + value + "</a>";
	    	break;
		case "releaseDate":
			if(row.releaseDate != null) {
				e.cellHtml = new Date(row.releaseDate).format("yyyy-MM-dd");
			}
			break;
		case "distributeDate":
			if(row.distributeDate != null) {
				e.cellHtml = new Date(row.distributeDate).format("yyyy-MM-dd");
			}
			break;
		case "expireDate":
			if(row.expireDate !=null ) {
				e.cellHtml = new Date(row.expireDate).format("yyyy-MM-dd");
			}
     }  
}

// 行单击时，判断分发按钮是否可用. 失败的就置为可用
function onrowclick(e) {
	var data = e.row;
	if(data.publishResult == "成功") {
		$("#posi_publish_btn").addClass("jobPost-disable");
	}
	else { // failed
		$("#posi_publish_btn").removeClass("jobPost-disable");
	}
}

// 事件绑定
function eventInit() {
	$("#posi_publish_btn").click(function(e) { // 失败的可以再分发
		if($("#posi_publish_btn").hasClass("jobPost-disable")) {
			ShowErrorTip("该职位已经分发成功!");
			return false;
		}
		var grid = mini.get("datagrid1");
	    var selects =grid.getSelecteds();
	    if(selects.length < 1) {
	    	ShowErrorTip("请先选择!");
	    }
	    else {
	    	window.location.href = basePath + "/position/distribute?recruitPositionId=" + selects[0].recruitPositionId.trim() + "&sites=" + selects[0].publishUrl;
	    }
	});
}
