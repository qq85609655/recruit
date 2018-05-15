$(function(){
	 mini.parse();
	 var grid = mini.get("datagrid1");
	 grid.load({});
});
//button选中时的样式
$("#position-import-button1").live("click",function() {
	window.location.href = '../resume/importResumeLocal';
});
//button未选中时的样式
$("#position-import-button2").live("click",function() {
	window.location.href = '../resume/importResumeEmail';
});
//为数据添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value = e.value;
    var grid=mini.get("datagrid1");
    if(field=="recruitPositionId"){
    	grid.hideColumn( "recruitPositionId" ); 
     }
    //超链接任务
    if (field == "positionName") {
        e.cellHtml = '<a id="' + row.recruitPositionId + '" class="showCellTooltip" style="display:block;width:100px;height:20px;"data-placement="right" >' + value + '</a>';
    }
}
//初始化页面的选中与未选中状态
function loadData(e){
	var grid = mini.get("datagrid1");
	var checkNum = $(".position-checkbox");
	for(var i=0;i<checkNum.length;i++){
		var id = checkNum[i].getAttribute('id');
		var cookKey = $.cookie(id);
		if(typeof(cookKey) == "undefined"){
			$.cookie(id,"0",{ expires: 365 });
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
