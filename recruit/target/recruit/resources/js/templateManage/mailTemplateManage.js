var templateId="";
$(function(){
	initKE(); 
	initKE2();
	$(".tGlobal .btnDelete").click(function(){
		deleteTemplate($(this).attr("data-id"),this);
	});
	//删除附件
	$(document).delegate(".fileName .delAttach","click",function(){
		var attach = $("#attach").val();
		var attachs = new Array();
		attachs = attach.split(",");
		for (var i = 0; i < attachs.length; i++) {
			var length = $(this).parent().text().length;
			if(attachs[i] == $(this).parent().text().substring(0,length-1)){
				attachs.splice(i,1);//从下标为i的元素开始，连续删除1个元素
				 i--;
			}
		}
		$("#attach").val(attachs.join(","));
		$(this).parent().remove();
	});
});
//保存短信模板
function saveMsgTemplate() {
	var templateType = $("#msgTemplateType").val();
	var templateTitle = $("#msgTemplateTitle1").val();
	var templateContext = $("#msgTemplateContext").val();
	if(templateTitle.trim() == ''){
		var html = $('<label class="one1" style="width:180px;color:red;">请填写模板名称</label>');
		$("#templateTitle").after(html);
		return false;
	}
	if(templateContext.trim() == ''){
		var html = $('<label class="one1" style="width:180px;color:red;">请填写模板内容</label>');
		$("#templateContext").after(html);
		return false;
	}
	jQuery.ajax({
        url: "/recruit/template/saveTemplate",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"templateId":templateId,
        	"templateType":templateType,
        	"templateTitle": templateTitle,
        	"templateContext":templateContext},
        success: function (json, textStatus) {
        	alert(json.msg);
        	if(json.msg == "操作成功"){
        		window.location.href="/recruit/template/templateManage";
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
}
//保存邮件模板(不带附件)
function saveTemplate(templateType) {
	if(templateType == '1'){
		var templateTitle = $("#templateTitle").val();
		var templateContext = $("#templateContext").val();
		if(templateTitle.trim() == ''){
			var html = $('<label class="one1" style="width:180px;color:red;">请填写模板名称</label>');
			$("#templateTitle").after(html);
			return false;
		}
		if(templateContext.trim() == ''){
			var html = $('<label class="one1" style="width:180px;color:red;">请填写模板内容</label>');
			$("#templateContext").after(html);
			return false;
		}
	}else if(templateType == '2'){
		var templateTitle = $("#templateTitle2").val();
		var templateContext = editor1.html();
		var templateSubject = $("#Subject2").val();
	}else if(templateType == '3'){
		var templateTitle = $("#templateTitle3").val();
		var templateContext = editor2.html();
		var templateSubject = $("#Subject3").val();
	}
	jQuery.ajax({
        url: "/recruit/template/saveTemplate",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"templateId":templateId,
        	"templateType":templateType,
        	"templateTitle": templateTitle,
        	"templateContext":templateContext,
        	"templateSubject":templateSubject},
        success: function (json, textStatus) {
        	alert(json.msg);
        	if(json.success){
        		window.location.href="/recruit/template/templateManage";
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
}
//保存邮件模板(带附件)
function saveTemplateFile(formId) {
	var templateTitle = $("#templateTitle").val();
	var templateContext = $("#templateContext").val();
	$(formId).submit(function() {
		if($("#form1 label[class=one1]").length > 0){
			$("#form1 label[class=one1]").remove();
		}
		if(templateTitle.trim() == ''){
			var html = $('<label class="one1" style="width:180px;color:red;">请填写模板名称</label>');
			$("#templateTitle").after(html);
			return false;
		}
		if(templateContext.trim() == ''){
			var html = $('<label class="one1" style="width:180px;color:red;">请填写模板内容</label>');
			$("#templateContext").after(html);
			return false;
		}
		var isFileCount = 0;
		if($("input[name='resumeFile']").length > 5){
			isFileCount = 1;
		}
		if(isFileCount == 1){
			var html = $('<label class="one1" style="width:180px;color:red;">模板附件最多上传5个</label>');
			$("input[name='resumeFile']").after(html);
			return false;
		}
		var dataType = "multipart/form-data";
		if($("input[name='resumeFile']").length == 0){
			$(formId).ajaxSubmit({
		        url: "/recruit/template/saveTemplate",
		        type: "POST",
		        dataType: "json",
		        success: function (json) {
		        	alert(json.msg);
		        	if(json.success){
		        		window.location.href="/recruit/template/templateManage";
		        	}
		        },
		        error:function (e){
		        	alert(e)
		        }
		    });
			return false;
		}else{
			$(formId).ajaxSubmit({
		        url: "/recruit/template/saveTemplateAttach",
		        type: "POST",
		        dataType: dataType,
		        success: function (json) {
		        	alert("操作成功");
		        	window.location.href="/recruit/template/templateManage";
		        },
		        error:function (e){
		        	alert(e)
		        }
		    });
			return false;
		}
	});
	
}
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
//	f.dataType = "json";
	f.action = "/recruit/template/previewTemplateById";
//	document.getElementById("form6").submit();
	f.submit();
}
//查询出模板数据以作修改
function updateTemplate(templateType,id){
	jQuery.ajax({
        url: "/recruit/template/queryTemplateById",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"templateId":id},
        success: function (json, textStatus) {
        	templateId = id;
        	$("#templateId").val(templateId);
        	if(templateType == "1"){
        		var attch = new Array();
        		attch = json.obj.attch.split(",");
        		$("#addAttach").before("<textarea style='display:none' id='attach' name='attach'>"+json.obj.attch+"</textarea>");
        		for (var i = 0; i < attch.length; i++) {
    			    $("#addAttach").before("<a class='fileName'>"+attch[i]+"<span class='delAttach'>x</span></a>");
				}
        		$("#templateTitle").val(json.obj.title);
            	$("#templateContext").val(json.obj.context);
        	}else if(templateType == "2"){
        		$("#templateTitle2").val(json.obj.title);
        		editor1.html(json.obj.context);
        		$("#Subject2").val(json.obj.subject);
        	}else if(templateType == "3"){
        		$("#templateTitle3").val(json.obj.title);
        		editor2.html(json.obj.context);
        		$("#Subject3").val(json.obj.subject);
        	}else if(templateType == "4"){
        		$("#msgTemplateTitle1").val(json.obj.title);
        		editor2.html(json.obj.context);
        		$("#msgTemplateContext").val(json.obj.context);
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
	if(templateType == "1"){
		$("#addPlainTextTemplate").show();
	}else if(templateType == "2"){
		$("#addPlainTextTemplate2").show();
	}else if(templateType == "3"){
		$("#addPlainTextTemplate3").show();
	}else if(templateType == "4"){
		$("#addMsgTextTemplate").show();
	}
}
//删除模板
function deleteTemplate(id,that){
	var med = that;
	jQuery.ajax({
        url: "/recruit/template/deleteTemplate",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"templateId":id},
        success: function (json, textStatus) {
        	$(med).parent().parent().remove();
        },
        error:function (e){
        	alert(e)
        }
    });
}
//添加附件
function getFileInfor(){
    var resumeFile = $("#resumeFile").clone();
    resumeFile.attr("id","");
    resumeFile.attr("name","resumeFile");
    $("#form1").append(resumeFile);
    $("#addAttach").before("<a class='fileName'>"+$("#resumeFile").val()+"<span class='delAttach'>x</span></a>");
}

$(".attch666").click(function(){
	$("#resumeFile").click();
})
//邮件模板点击事件
function emailTemplateLink(id){
	if($(id).is(":hidden")){
		$(id).show();
	}else{
		$(id).hide();
	}
}
//短信模板点击事件
function msgTemplateLink(id){
	if($(id).is(":hidden")){
		$(id).show();
	}else{
		$(id).hide();
	}
}
//候选人面试模板点击事件
function interviewEmailTemplateLink(id){
	if($(id).is(":hidden")){
		$(id).show();
	}else{
		$(id).hide();
	}
}
//添加候选人面试模板
function addPlainTextTemplateClick(id,form){
	$(form)[0].reset();
	if($(id).is(":hidden")){
		$(id).show();
	}else{
		$(id).hide();
	}
	if(id == "#addPlainTextTemplate2"){
		var html = '<table class="ke-zeroborder" style="margin:12px;padding:0;width:600px;border:15px solid #ddf0f8;vertical-align:top;border-spacing:0;border-collapse:collapse;">'
		+'<tbody><tr><td class="pad50"><table align="center" class="t-txt ke-zeroborder" _moz_resizing="true"><tbody>'
		+'<tr><td class="style1">你好：</td></tr><tr><td class="style1"><p style="text-indent:2em;"> ${UserName}向您推荐贵部门当前所需职位的简历，请查看附件并及时反馈你的意见，谢谢。<br>'
		+'附言：<br>${sendReason}</p></td></tr><tr><td align="right"><p style="text-align:right;">${sendDate}</p></td></tr></tbody></table>'
		+'</td></tr><tr><td style="margin:0;padding:20px 0;background:#efefef;color:#595959;text-align:center;font-size:12px;">${CompanyName}<br</td>'
		+'</tr></tbody></table>';
		editor1.html(html);
	}else if(id == "#addPlainTextTemplate3"){
		var html = '<table class="ke-zeroborder" style="margin:12px;padding:0;width:600px;border:15px solid #ddf0f8;text-align:left;vertical-align:top;border-spacing:0;border-collapse:collapse;font-weight:normal;font-size:14px;line-height:20px;">'
			+'<tbody><tr><td><table class="ke-zeroborder" style="margin:15px 30px 40px;width:540px;border-collapse:collapse;"><tbody>'
			+'<tr><td> 尊敬的${CandidateName}${SexName}：<br><p style=" text-indent:20px;">非常感谢您加入我公司的意愿，因名额有限，您未被录取。我们再次真诚的感谢您应聘我公司职位，愿您今后一切顺利！</p>'
			+'</td></tr><tr><td align="right">${EmployerName}</td></tr><tr><td align="right">${SendDate}</td></tr></tbody></table>'
			+'</td></tr></tbody></table>';               
		editor2.html(html);
//		editor2.html("<div>尊敬的${CandidateName}${SexName}：</div><div>&nbsp;&nbsp;&nbsp;&nbsp;非常感谢您加入我公司的意愿，因名额有限，您未被录取。我们再次真诚的感谢您应聘我公司职位，愿您今后一切顺利！</div><div style='text-align:right'>${EmployerName}</div><div style='text-align:right'>${SendDate}</div>");
	}
}
//初始化编辑器
function initKE() {
	KindEditor.ready(function(K) {
		editor1 = K.create(
				'#content_1',
				{
					width : "100%",
					height : '244px',
					afterChange : function() {
						K('.word_count').html(this.count('text'));
					},
					afterCreate : afterInitKE,
					resizeMode : 0
				});
	});
}
function initKE2() {
	KindEditor.ready(function(K) {
		editor2 = K.create(
				'#content_2',
				{
					width : "100%",
					height : '244px',
					afterChange : function() {
						K('.word_count').html(this.count('text'));
					},
					afterCreate : afterInitKE,
					resizeMode : 0
				});
	});
}
function afterInitKE() {
//	initData();
}
//添加邮件参数
function btnAddParameter1(selId){
	if(selId == '#selMailParameters'){
		editor1.insertHtml($(selId).val());
	}else if(selId == '#selMailParameters2'){
		editor2.insertHtml($(selId).val());
	}
}
//返回
function returnTemplateManage(){
	window.location.href="/recruit/template/templateManage";
}
