//发送短信
function sendMessage(id){
	if($(".tbody1 label[class=one1]").length > 0){
		$(".tbody1 label[class=one1]").remove();
	}
	var smsContent = $("#smsContent").val();
	var phoneHtml = $('<label style="width:180px;color:red;" class=one1>请输入手机号码</label>');
	var val = $("#mobilePhone").val().trim();
	var mobileArray = new Array();
	mobileArray = $("#mobilePhone").val().split(";");
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;
	if (val == "") {
		$("#mobilePhone").after(phoneHtml);
		return false;
	}
	for(var i = 0; i< mobileArray.length; i++){
		if (!isMobile.test(mobileArray[i])) {
			str = "请输入正确的手机号";
			phoneHtml = $('<label style="width:180px;color:red;" class=one1>' + str + '</label>');
			$("#mobilePhone").after(phoneHtml);
			return false;
		}
	}
	if(smsContent.trim() == ''){
		var html = $('<label style="width:180px;color:red;" class=one1>请输入短信内容</label>');
		$("#smsContent").after(html);
		return false;
	}
	var mobilePhone = $("#mobilePhone").val();
	var smsTemplate = $("#smsTemplate").val();	
	var smsContent = $("#smsContent").val();	
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/sendMessage",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"mobilePhone": mobilePhone,"smsTemplate":smsTemplate,"smsContent" : smsContent},
        success: function (json, textStatus) {
        	if(json.msg == "操作成功"){
        		alert(json.msg);
        		mini.get("datagrid2").reload();
        		$("#smsContent").val("");
            	$("#smsTemplate").text("")
        	}else{
        		alert("操作失败");
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
}
//加载短信模板内容
function loadSmsTemplate(){
	var context = $("#smsTemplate").val();
	$("#smsContent").val(context);
}