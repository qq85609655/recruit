$(function(){
	$("#position-import-button1").toggleClass("button-out",true);
	$("#position-import-button2").toggleClass("button-out",false);
	$("#position-import-button2").toggleClass("button-up",true);
});
//本地上传点击事件
$("#position-import-button1").live("click",function() {
	window.location.href = '../resume/importResumeLocal';
});
//邮件上传点击事件
$("#position-import-button2").live("click",function() {
	window.location.href = '../resume/importResumeEmail';
});
function uploadMail(){
	$(".page-loading").show();
	$("#form1").ajaxSubmit( {
		//var param = $(this).serialize();
		url : basePath + '/file/uploadMail',
		type: "POST",
	    cache: false,
	    async: false,
	    dataType: "json",
	    //data : param,
		success : function(msg) {
			$(".page-loading").hide();
	        opResult(msg);
		},
		error : function(e) {
			$(".page-loading").hide();
	        ShowErrorTip("解析发生异常！");
		}
	});
}
