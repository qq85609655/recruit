var resumeD = null;
var resumeUrl = "";
var privacylevel = 1; // 0:私密;1:公开.

$(function() {
	mini.parse();
	
	// 获取简历基本数据
	getBasicInfor();
	
	// 标签选择器初始化
	TagPage.init({
		resumeId: getResumeId(),
		beforeClose: beforeTagPageClose
	});
	
	initTextarea();
	
	// 数据转换
	dataParse();
});

// 返回首页
$(".head .return").click(function() {
	window.location.href = basePath + "/loginController/main";
}); 

// 添加标签
$("#tagAdd").click(function() {
	
	TagPage.setSelect($(this)[0].data);
	showAtPos('tagSelectWin','#tagAdd');
});

// 删除标签
$(document).delegate(".label-dele","click",function() {
	var id = $(this).parent().attr("id");
	var labelId = id.substring("label-".length,id.length);
	var temp = $("#tagAdd")[0].data.split(",");
	temp.removeV(labelId);
	$("#tagAdd")[0].data = temp.join(",");
	deleTag(getResumeId(),$("#tagAdd")[0].data,$(this).parent()[0].data);
	$(this).parent().remove();
}); 

// resume tool 切换面板
$(".resume-tool li.li-ul").click(function() {
	if($(this).hasClass("current")) {
		return;
	}
	else {
		var _str = "Right";
		var _id = $(this).attr("id");
		var _index = $(this).index();
		var _target = $(".resume .resume-item").get(_index)
		$(".resume-tool ul .current").removeClass("current");
		$(this).addClass("current");
		$(".resume .resume-item.current").removeClass("current");
		$(_target).addClass("current");
		_index > 1 ? ($(".resume .resume-attach").hide()) : ($(".resume .resume-attach").show());
		if("dynamic" == _id || "opRecord" == _id) { // 评论或操作记录
			$("#" + _id + "Right").hide();
			"dynamic" == _id ? $("#opRecordRight").show() : $("#dynamicRight").show();
		}
		else {
			$("#dynamicRight").show();
			$("#opRecordRight").show();
		}
	}
});

// 附件上传
$("#attachUpload").click(function() {
	showAtPos('fileSelectWin','#attachUpload',initUpload);
});

// 文件上传小窗中
$("#selectFile").click(function() {
	$("#selectFileR").click();
});
$("#selectFileR").change(function() {
	var _file = $("#selectFileR")[0].files[0];
	var _notExist = true;
	var _count = $(".file-list a form").length;
	$(".file-list a .file-name").each(function() {
		if(_file.name == $(this).text()) {
			_notExist = false;
		}
	});
	if(_notExist) { // 如果文件不存在 
		var _append = $("<a class='file-attach'><span class='font-icon icon-doc-text file-text'></span><span class='file-name file-text'>" + _file.name + "</span><span class='file-text'>(</span><span class='file-size file-text'>" + fileSize(_file.size) + "</span><span class='file-text'>)</span><span class='file-dele'></span></a>");
		var _form = $("<form enctype='multipart/form-data' class='file-upload-form' name='file-upload-" + _count  + "' id='file-upload-" + _count + "'><input type='text' class='none' name='resumeUrl' value='" + resumeUrl + "'></input></form>");
		var _clone = $(this).clone();
		var _id = $(_clone).attr("id") + "_" + _count;
		$(_clone).attr("id",_id);  
		$(_clone).attr("name",_id);
		$(_form).append(_clone);
		$(_append).append(_form);
		$(".file-list").append(_append);
		_count++;
	}
});

// 文件上传
$("#selectFileConfirm").click(function() {
	var _count = 0;
	var _size = $("#fileSelectWin .file-list a .file-upload-form").length;
	if( _size == 0) {return;}
	$("#uploadTip").show();
	$("#sucSize").text(_count);
	$("#totalSize").text(_size);
	$("#uploadFailedTip").empty().hide();
	$(".file-upload-form").each(function() {
		var that = this;
		$(this).ajaxSubmit({
			type : "POST",	
			url : '/recruit/file/uploadAttach',
			dataType: "json",
			success : function(data) {
				//var reg = /<pre>(.+)<\/pre>/g;  
				//var result = data.match(reg);  
				//data = JSON.parse(RegExp.$1);
				if(data.success) {
					$(that).parent().find(".file-text").addClass("file-suc");
					$("#sucSize").text(++_count); 
				}
				else {
					$(that).parent().find(".file-text").addClass("file-error");
					$("#uploadFailedTip").show().append("<div>" + $(that).parent().find(".file-name").text() + "&nbsp;&nbsp;&nbsp;&nbsp;( " + data.msg + ")</div>");
				}
			},
			error : function(e) {
				//alert("上传失败!");
			}
		});
	});
	if(_size == _count) {
		setTimeout(function() {hideWindow('#fileSelectWin')},2000);
	}
	$("#selectFileCancle").val("确定");
});

// 评论确定
$("#commentConfirm").click(commentConfirm);

// 数据转换  
function dataParse() {
	var value = $("#currentLocation").text();
	if(areas) { 
		value = Number(value);
		if(areas[value]) {
			$("#currentLocation").text(areas[value].name); // 当前所在地的id-》name
		}
	}
} 

// 生成页面上的附件列
function drawAttach(d) {
	if(d) {
		$(".resume-attach .attach-list .file-attach").remove();
		for(var i = 0; i < d.length; i++) {
			$("#attachUpload").before("<a class='file-attach'><span class='font-icon icon-doc-text file-text file-suc'></span><span class='file-name file-text file-suc'>" + d[i].fileName + "</span><span class='file-text file-suc'>(</span><span class='file-size file-text file-suc'>" + d[i].fileSize + "</span><span class='file-text file-suc'>)</span><span class='file-dele' title='删除附件'></span></a>");
		}
	}
}

//初始化上传附件窗口
function initUpload() {
	$(".file-list").empty();
	$(".resume-attach .attach-list .file-attach").each(function() {
		$(".file-list").append($(this).clone());
	});
	
	$("#uploadTip").hide();
	$("#uploadFailedTip").empty().hide();
	$("#selectFileCancle").val("取消");
}

// 上传窗口关闭后,设置页面上的附件列      注：删掉之后点取消，还是会删掉
function setAttach() {
	var _size1 = $(".file-list .file-attach").length,
	    _size2 = $(".attach-list .file-attach").length;
	if("取消" == $("#selectFileCancle").val() && _size1 == _size2) {return;}
	var _i = 0,
		_file = [];
	$(".file-list .file-attach").each(function() {
		if($(this).find(".file-suc").length > 0) {
			_file[_i++] = {fileName: $(this).find(".file-name").text(), fileSize: $(this).find(".file-size").text()};
		}
	});	
	drawAttach(_file);
}

// 附件删除 
function attachDele(fileName) {
	$.ajax({
		type: "post",
		dataType: "json",
		url: basePath + "/file/deleAttach",
		data: "resumeId=" + getResumeId() + "&fileName=" + fileName,
		success: function(msg) {
			if(!msg.success) {
				opResult(msg);
			}
		},
		error: function(msg) {
			opResult(msg);
		}
	});
}

// 附件上传中的删除附件
$(document).delegate(".file-attach .file-dele","click",function() {
	$(this).parent().remove();
	attachDele($(this).parent().find(".file-name").text());
});

// @TA面板中的私密设置下拉
$(".view-range").mouseover(function() {
	$(".view-range").removeClass("remove-hover");
});
$(".li-more-co .more-a").click(function() {
	var index = $(this).index();
	index > 0 ? ($(".view-range-tip #view-range-tip-1").show(),$(".view-range-tip #view-range-tip-0").hide(),privacylevel=0) : ($(".view-range-tip #view-range-tip-0").show(),$(".view-range-tip #view-range-tip-1").hide(),privacylevel=1); // 切换提示
	$(".view-range").addClass("remove-hover");
	$("#viewRange").text($(this).find(".text").text());
});

// 您可以中的更多下拉
$(".more-function .operate .operate-more").click(function() {
	$(".more-function .operate-more-list").slideToggle();
	$(this).find(".expand").toggleClass("icon-angle-double-down").toggleClass("icon-angle-double-up");
});

ToCandidate.init();
ToCandidate.ajaxSuccess = function() {
	hideWindow('resume-add-candidate-win');
	$(".more-function .operate-bar").empty().append("<a class='operate-bar-item' id='toRecomend'>推荐</a> <a class='operate-bar-item' id='toInterview'>进入面试</a> <a class='operate-bar-item' id='toObsolete'>淘汰</a> <a class='operate-bar-item' id='toSwerve'>转向</a>");
	$("#recruitProgress").empty().append("<div class='current statu01'><span class='progress-text t-bottom'></span></div>");
	var append = "<li class='bottom-dashed'>" +
  					"<div class='head-img'><span class='font-icon icon-user-1'></span></div>" +
  					"<div class='operate-infor'>" +
  						"<div><a class='user-name font-b'>" + $("#account").text() + "</a><span class='operate-time'>" + (new Date()).format("yyyy-MM-dd hh:mm:ss") + "</span></div>" +
  						"<div><span>加为候选人，关联职位</span> @ <a class='font-b' title='" + (resumeD.applyPosition?resumeD.applyPosition.positionName:"没找到应聘职位") + "'>" + (resumeD.applyPosition?resumeD.applyPosition.positionName:"没找到应聘职位") + "</a></div>" +
  					"</div>" +
  				"</li>";
	$(".void-tip",".op-record").remove();
	$(".op-record ul").append(append);
	$(".void-tip",".ul-records").remove();
	var length = $(".operate-record ul li").length;
	if(length <= 2) {
		$(".operate-record ul li:last").addClass("bottom-dashed");
		$(".operate-record .ul-records").append(append);
		$(".operate-record ul li:last").removeClass("bottom-dashed");
	}
	else if(length == 3) {
		if($(".operate-record .review-more").length == 0) {
			$(".operate-record").append("<div class='review-more'><a class='view-more-a'>查看更多...</a></div>");
		}
	}
}

// 加为候选人
$("#toCandidate").click(function() {
	showAtPos('resume-add-candidate-win','#toCandidate',function() {
		ToCandidate.resumeIds = getResumeId();
		$("#candidateName").text(resumeD.name);
		$("#positionName").text(resumeD.applyPosition.positionName);
	});
});

// 去掉最后的线条
$(".resume-item .co-item:last").removeClass("b-solid");
$(".operate-record ul li:last").removeClass("bottom-dashed");

// 点击更多
$(".dynamic").delegate(".view-more-a","click",function() {
	$("#dynamic").trigger("click");
});
$(".operate-record").delegate(".view-more-a","click",function() {
	$("#opRecord").trigger("click");
});

// 形成基本信息 
function getBasicInfor() {

	$.ajax({
		url : basePath + "/resume/queryResume/" + getResumeId(),
		dataType: "json",
		typ: "post",
		success: function(msg) {
			var d = msg.obj;
			resumeD = d;
			if(d.highestEducation !=null){
				$("#edu").text(d.highestEducation);
			}
			if(d.eduExperienceList.length > 0) {
				$("#eduSchool").text(d.eduExperienceList[0].schoolName);
				$("#eduMajor").text(d.eduExperienceList[0].major);
			}
			var append = null;
			for(var i = 0; i < d.labelList.length; i++) {
				append = $("<a class='resume-label' id='label-" + d.labelList[i].id + "' pid='category-" + d.labelList[i].categoryId + "'><span class='font-icon icon-tag'></span><span class='label-dele font-icon icon-cancel-1'></span><span>" + d.labelList[i].name + "</span></a>");
				$(append)[0].data = d.labelList[i];
				$("#tagAdd").before(append);
			}
			$("#tagAdd")[0].data = d.label;
			removeLoad();
			resumeUrl = d.resumeDir;
			drawAttach(d.attachments);
		},
		error: function() {
			console.log("获取简历信息异常!");
		}
	});
}

// 获取简历id
function getResumeId() {
	var curl = window.location.href;
	return curl.substring(curl.lastIndexOf("/")+1);
}

// 删除标签
function deleTag(resumeId,resumeTags,tag) {
	$.ajax({
		url: basePath + "/resume/deleTag?resumeId=" + resumeId + "&resumeTags=" + resumeTags + "&tagId=" + tag.id,
		dataType: "json",
		typ: "post",
		success: function(msg) {
			if(!msg.success) {
				alert("删除标签 " + tag.name + " 失败!");
			}
		},
		error: function() {
			alert("删除标签 " + tag.name + " 异常!");
		}
	});
}

// 标签选择器关闭前把页面中职位的标签更新
function beforeTagPageClose() {
	var append = null;
	var labels = TagPage.getSelectTags();
	$(".tags-tr .resume-label").remove();
	for(var i = 0; i < labels.length; i++) {
		append = $("<a class='resume-label' id='label-" + labels[i].id + "' pid='category-" + labels[i].categoryId + "'><span class='font-icon icon-tag'></span><span class='label-dele font-icon icon-cancel-1'></span><span>" + labels[i].name + "</span></a>");
		$(append)[0].data = labels[i];
		$("#tagAdd").before(append);
	}
	$("#tagAdd")[0].data = TagPage.getSelect();
}

// init textarea
function initTextarea() {
	$("div.comment-div").each(function() {
		var area = $("textarea",$(this));
		var span = $("span",$(this));
		/*if(area[0].attachEvent) {// IE8
			area[0].attachEvent("onpropertychange",function() {
				area.val(area.val().substring(0,200));
				span.text(area.val());
				//$(".text-tip .text-num").text(200-area.val().length);
			});
		}
		else {*/
			area.bind("input",function() {
				area.val(area.val().substring(0,200));
				span.text(area.val());
				$(".text-tip .text-num").text(200-area.val().length);
			});
		//}
		span.text(area.val());
	});
}

// @/评论
function commentConfirm() {
	if("" == $("#commentInput").val()) {return;}
	var value = $("#commentInput").val();
	var span = $(".plugSpan");
	
	var d = "";
	for(var i=0;i<span.length;i++){
		var name = span[i].getAttribute("name");
		var val = span[i].getAttribute("value");
		d+="<a class='comment-name font-b' href='"+val+"'>"+name+"</a>&nbsp;";
	}
	var fn = function() {
		var append = "<li>" +
						 "<div class='head-img'><span class='font-icon icon-user-1'></span></div>" +
						 "<div class='comment-infor'>" +
							"<div><a class='comment-name font-b'>" + $("#account").text() + "</a></div>" +
							"<pre class='comment-content'>" + value + "</pre>" +
							d +
							"<div class='comment-content-infor'><span>刚刚</span><span class='comment-split'>|</span><span>" + (resumeD.applyPosition?resumeD.applyPosition.positionName:"没有找到应聘的职位") + "</span><span class='comment-split'>|</span><span class='font-icon font-b " + (privacylevel==0?'icon-lock-1':'icon-public') + "'></span></div></div>" +
					"</li>"; 
		$(".comment-list .void-tip").remove();
		$(".comment-list ul").append(append);
		$("#commentInput").val("");
		$(".text-tip .text-num").text("200");
		$("span",".comment-div pre").text("");
		var length = $(".dynamic ul li").length;
		if(length == 0) {
			$(".dynamic ul .void-tip").remove();
		}
		if(length <= 2) {
			$(".dynamic ul").append(append);
		}
		else if(length == 3) {
			if($(".dynamic .review-more").length == 0) {
				$(".dynamic").append("<div class='review-more'><a class='view-more-a'>查看更多...</a></div>");
			}
		}
	};
	addCommendAjax(value,fn);
}

// 发送添加评论的ajax
function addCommendAjax(content,fn) {
	$.ajax({
		type: "post",
		dataType: "json",
		data: "resumeId=" + getResumeId() + "&content=" + content + "&privacylevel=" + privacylevel,
		url: basePath + "/resume/addResumeComment",
		success: function(msg) {
			if(msg.success) {
				fn&&fn();
			}
			else {
				opResult(msg);
			}
		},
		error: function(msg) {
			opResult(msg);
		}
	});
}

/*//转发
$(".operate-transmit").click(function(){
	 var win = mini.get("resume-transmit-win"); 
	 var lt = $(this).offset();
	 $("#candidateName1").text($("#resume-name").text());
	 win.showAtPos(200, lt.top-300); 
})
//转发
function transmitResume(id){
	var txtSrEmail = $("#txtSrEmail").val();
	if(txtSrEmail.trim() == '' || txtSrEmail.trim() == '多个邮箱请用";"号隔开'){
		var html = $('<label style="width:180px;color:red;">请输入邮箱</label>');
		$("#txtSrEmail").after(html);
		return false;
	}
	var candidateName = $("#candidateName1").text();
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/transmitResume",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"resumeIds": resumeId,"txtSrEmail":txtSrEmail,"candidateName" : candidateName},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid2").reload();
        },
        error:function (e){
        	alert(e)
        }
    });
}*/

$("#txtSrEmail").click(function(){
	if($("#txtSrEmail").val().trim() == '多个邮箱请用";"号隔开'){
		$("#txtSrEmail").val("");
	}
}).blur(function(){
	if($("#txtSrEmail").val().trim() == ""){
		$("#txtSrEmail").val('多个邮箱请用";"号隔开');
	}
});
$("#txtComment").click(function(){
	/*console.log($("#txtComment").val());*/
	if($("#txtComment").val().trim() == '附言内容字数不能超过2000字'){
		$("#txtComment").val("");
	}
}).blur(function(){
	if($("#txtComment").val().trim() == ""){
		$("#txtComment").val('附言内容字数不能超过2000字');
	}
});

//从资料库选择
$("#fileList").click(function(){
	 fileListShow();
})

//页面初始化时获取
$.ajax({
	 url:"/recruit/resume/fileList",
	 type: "POST",
     dataType: "json",
     success: function (data) {
    	 var d = "<ul>";
    	 var file = data.obj;
    	 for(var i=0;i<file.length;i++){
    		 d+="<li class='fileLi'><input class='fileInput' type='checkbox' name="+file[i].fileName+" value="+file[i].filePath+">&nbsp;"+file[i].fileName+"</li>";
    	 }
    	 d+="</ul>";
    	 $(".fileData").html(d);
     },
     error:function (e){
         alert(e)
     }
})

function fileListShow(){
	var lt = $("#fileList").offset();
	$(".fileData").css({
		left:lt.left,
		top:lt.top+25
	});
	$(".fileData").show();
}

var fileTime;
$("#fileList").mouseleave(function(){
	fileTime = setTimeout("$('.fileData').hide()",100);
})
$(".fileData").mouseleave(function(){
	$(this).hide();
}).mouseover(function(){
	clearTimeout(fileTime);
})

$(".fileInput").live('click',function(){
	var val = $(this).val();
	var value = $(this).attr("name");
	if($(this).is(':checked')){
		$("#addPlugs").append("<span class='plugSpan' name='"+value+"' value='"+val+"'>"+value+"<span>&nbsp;<b>x</b></span></span>");
		$("#addPlugs").css("display",'block');
	}else{
		$(".plugSpan[value='"+val+"']").remove();
	}
})

$(".plugSpan").live('click',function(){
	var val = $(this).attr("value");
	$(this).remove();
	$(".fileInput[value='"+val+"']").attr("checked",false);
})

function openSendMessage(id,cl){
	//弹出window框
    var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(450, 300); 
}

//发送短信
function sendMessage(id){
	var smsContent = $("#smsContent").val();
	if(smsContent.trim() == ''){
		var html = $('<label style="width:180px;color:red;">请输入短信内容</label>');
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
        	alert("操作成功");
        	mini.get("datagrid2").reload();
        },
        error:function (e){
        	alert(e)
        }
    });
}
