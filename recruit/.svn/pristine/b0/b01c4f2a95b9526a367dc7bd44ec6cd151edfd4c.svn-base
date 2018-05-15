function previewTemplate(id){
	var f = document.createElement("form");
	document.body.appendChild(f);
	f.target="_blank";
	var templateId = document.createElement("input");
	templateId.type = "hidden";
	f.appendChild(templateId);
	templateId.value = id;
	templateId.name = "templateId";
	f.method = "post";
	f.action = "/recruit/template/previewTemplateById";
	f.submit();
}
function queryTemplate(){
	var id = $("#sendResumeTemp").val();
	if(id != ""){
		previewTemplate(id);
	}
}
//转发
$(".operate-transmit").click(function(){
	 var win = mini.get("resume-transmit-win"); 
	 var lt = $(this).offset();
	 $("#candidateName1").text($("#resume-name").text());
	 win.showAtPos(200, lt.top-300); 
})
//转发
function transmitResume(id){
	$("#resume-transmit-win label[class=one1]").remove();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	var txtSrEmail = $("#txtSrEmail").val();
	var emails = new Array();
	emails = txtSrEmail.split(";");
	if(txtSrEmail.trim() == '' || txtSrEmail.trim() == '多个邮箱请用";"号隔开'){
		var html = $('<label style="width:180px;color:red;" class="one1">请输入邮箱</label>');
		$("#txtSrEmail").after(html);
		return false;
	}
	for(var i = 0; i < emails.length; i++){
		if(!reg.test(emails[i])){
			var html = $('<label style="width:180px;color:red;" class="one1">请输入正确邮箱</label>');
			$("#txtSrEmail").after(html);
		}
	}
	var candidateName = $("#candidateName1").text();
	var win = mini.get(id);
	var postscript = $("#txtComment").val();
	var sendResumeTemp = $("#sendResumeTemp").find("option:selected").text();
	if(sendResumeTemp == "请选择模版"){
		var html = $('<label style="width:180px;color:red;" class="one1">请选择模版</label>');
		$("#manage").after(html);
		return false;
	}
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/transmitResume",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"resumeIds": resumeId,"txtSrEmail":txtSrEmail,"candidateName" : candidateName,
        	"postscript" : postscript,"sendResumeTemp" : sendResumeTemp},
        success: function (json, textStatus) {
        	if(json.msg == "操作成功"){
        		alert(json.msg);
            	mini.get("datagrid2").reload();
            	$("#txtSrEmail").val("");
            	$("#sendResumeTemp").val("");
            	$("#sendResumeTemp").find("option:selected").text("请选择模版");
            	$("#txtComment").val("");
        	}else{
        		alert(json.msg);
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
}
