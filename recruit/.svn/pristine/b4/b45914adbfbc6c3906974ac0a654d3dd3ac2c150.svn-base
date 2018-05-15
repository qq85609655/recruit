$(".distribute-surface:last").removeClass("border-b-dotted");

// 切换选项卡
$(".posi-distribute-btn").click(function() {
	if($(this).hasClass("tab-up")) {
		return;
	}
	var _index = $(this).index(); 
	var _oindex = $(".posi-distribute-btn.tab-up").index();
	$(".posi-distribute-btn.tab-up").removeClass("tab-up");
	$(this).addClass("tab-up");
	$(".posi-distribute-div:eq(" + _oindex + ")").removeClass("tab-up").hide();
	$(".posi-distribute-div:eq(" + _index + ")").addClass("tab-up").show();
});

// 如果站点被选中刷新后去掉选中状态 
$(".distribute-surface input[type='checkbox'].site-expand").each(function() {
	if($(this)[0].checked) {
		$(this)[0].checked = false;
	}
});
// 站点点击时的展开和收缩
$(".distribute-surface input[type='checkbox'].site-expand").click(function(){
	var check = $(this).attr("checked");
	var cl = "#"+this.id+"-hidden-form";
	if(check=="checked"){
		$(cl).show();
	}else{
		$(cl).hide();
	}
});

// 每个站点提交数据时
$(".distribute-form").each(function() {
	var id = $(this).attr("id");
	var site = id.substring(0,id.lastIndexOf("-") );
	$("#" + id).validator({
		theme : "simple_right",
		msgClass : "n-right ",
		valid : function(form) {
			var me = this;
	        me.holdSubmit();
	        $(".page-loading").show();
	        distribute({
	        	site : site,
	        	captchaName : $("#" + site + "Captcha").attr("captchaName"),
	        	recruitPositionId : $(".distribute-position-name").attr("id")
	        },function(msg) {
	        	$(".page-loading").hide();
	        	opResult(msg);
	        	me.holdSubmit(false);
	        },function() {
	        	$(".page-loading").hide();
	        	ShowErrorTip("分发失败！");
	        	me.holdSubmit(false);
	        });
		}
	});
});

// 更换验证码图片
function refreshCaptcha(site,id) {
	$.ajax({
		type: "post",
		url: basePath + "/position/getCaptcha",
		async: false,
		dataType: "json",
		data: "site=" + site,
		success: function(msg) {
			if(msg.success) {
				$("#"+ id)[0].src = basePath + "/resources/captcha/" + site.substring(0,site.indexOf(".com")) + "/" + msg.obj;
				$("#"+ id).attr("captchaname",msg.obj);
			}
			else {
				ShowErrorTip(msg.msg);
			}
		},
		error: function() {
			ShowErrorTip("查询验证码异常");
		}
	});
}

// 职位分发
function distribute(d,successFn,errorFn) {
	jQuery.ajax({
        url: basePath + "/position/addPositionDistribute",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify({
        	url : d.site + ".com",
        	siteName : d.site,
        	captchaName : d.captchaName,
        	userNameInput : $("#" + d.site + "-LoginName").val(),
        	pwdInput : $("#" + d.site + "-LoginPassword").val(),
        	captchaInput : $("#" + d.site + "CaptchaInput").val(),
        	rsiAccountStr : getExtDistributeStr(d.site,2),
        	rsiDistributeStr : getExtDistributeStr(d.site,3),
        	position : {
        		recruitPositionId : d.recruitPositionId
        	}
        }),
        success: successFn,
        error: errorFn
    });
}

// 获取职位分发所需的额外字段信息
function getExtDistributeStr(site,type) {
	var str = "";
	$("." + site + "-surface .field-" + type).each(function() {
		var id = $(this).attr("id");
		var field = id.substring(id.lastIndexOf("-") + 1,id.length);
		str += "'" + field + "':'" + $(this).val() + "',";
	});
	if(str.length > 0) {
		str = str.substring(0,str.length - 1);
	}
	return str;
}


