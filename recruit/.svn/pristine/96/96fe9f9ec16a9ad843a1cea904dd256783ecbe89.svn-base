$(function() {
	$(this).toggleClass("button-out",false);
	$(this).toggleClass("button-up",true);
	$("#position-import-button2").toggleClass("button-out",true);
	mini.parse();
});

function upload(formId) {
	if($(formId+" #importExcel").val() == 3) { // 如果是excel上传，判断文件格式是否为xls、xlsx
		// 判断文件是否是指定格式
		if(!checkFileType($("#uploadfile").val(),new Array("xls","xlsx"))) {
			$("#validateFormat").show();
	        setTimeout("coloseErrorMsg(validateFormat)",1000*2);
	        return false;
		}
		$(".page-loading").show();
	    $(formId).ajaxSubmit({
	        type : "POST",
			url : basePath + '/file/uploadLocalByExcel',
			success : function(msg) {
				msg = JSON.parse(msg);
				removeLoad();
				opResult(msg);
			},
			error : function(e) {
				removeLoad();
				ShowErrorTip("上传出现异常！");
			}
	    });
	}
	else if($(formId+" #importLocal").val() == 1) {
		if($("input[name='resumeFormat']:checked").val() == 1) {
			if($("#textFile").val() == "") {
				$("#validateLocal").css({bottom:"10px",left:"10px"});
				$("#validateLocal .tanchu_nr").text("请选择简历!");
				$("#validateLocal").show();
				setTimeout("coloseErrorMsg(validateLocal)",1000*5);
				return false;
			}
		    // 判断文件是否是指定格式
		    if(!checkFileType($("#textFile").val(),new Array("docx","doc","txt","html","htm","pdf","mht"))) {
		    	$("#validateLocal").css({bottom:"10px",left:"10px"});
		    	$("#validateLocal .tanchu_nr").text("请上传doc,docx,txt,html,htm,pdf,mht格式的文件!");
		        $("#validateLocal").show();
	        	setTimeout("coloseErrorMsg(validateLocal)",1000*5);
		        return false;
		    }
		    $(".page-loading").show();
		    $(formId).ajaxSubmit({
		        type : "POST",
		        dataType: "json",
				url : basePath + '/file/uploadLocalByDocument',
				success : function(msg) {
					removeLoad();
					opResult(msg);
				},
				error : function(e) {
					removeLoad();
					ShowErrorTip("上传出现异常！");
				}
		    });
		}
		else {
			if($("#resumetext").val() == "") {
				$("#validateLocal").css({bottom:"10px",left:"10px"});
				$("#validateLocal .tanchu_nr").text("内容为空!");
				$("#validateLocal").show();
				setTimeout("coloseErrorMsg(validateLocal)",1000*5);
				return false;
			}
			$(".page-loading").show();
		    $(formId).ajaxSubmit({
		        type : "POST",
				url : basePath + '/file/uploadLocalByCopyContent',
				dataType: "json",
				success : function(msg) {
					removeLoad();
					opResult(msg);
				},
				error : function(e) {
					removeLoad();
					ShowErrorTip("上传出现异常！");
				}
		    });	
		}
	}
	else if ($(formId+" #importMulti").val() == 2) {
		if($("#resumeFile").val() == "") {
			$("#validateLocal").css({top:"240px",left:"30px"});
			$("#validateLocal .tanchu_nr").text("请选择简历!");
			$("#validateLocal").show();
			setTimeout("coloseErrorMsg(validateLocal)",1000*5);
			return false;
		}
		$(".page-loading").show();
	    $(formId).ajaxSubmit({
	        type : "POST",
			url : basePath + '/file/uploadLocalByDocument',
			dataType: "json",
			success : function(msg) {
				removeLoad();
				opResult(msg);
			},
			error : function(e) {
				removeLoad();
				ShowErrorTip("上传出现异常！");
			}
	    });	
	}
}
// 关闭错误提示框
function coloseErrorMsg(validateFormat) {
	$(validateFormat).hide();
}
function setFileVal() {
	$("#textFile").val($("#file").val());
}
// 本地上传点击事件
$("#position-import-button1").live("click",function() {
	window.location.href = '../resume/importResumeLocal';
});
// 邮件上传点击事件
$("#position-import-button2").live("click",function() {
	window.location.href = '../resume/importResumeEmail';
});
// 本地上传选择单份上传、批量上传、excel上传radio事件
$(":radio[name='uploadMode']").click(function() {
	var $selectedvalue = $("input[name='uploadMode']:checked").val();
	if($selectedvalue == 1) {
		$("#singleMode").show();
		$("#packageMode").hide();
		$("#excelMode").hide();
	}else if($selectedvalue == 2) {
		$("#packageMode").show();
		$("#singleMode").hide();
		$("#excelMode").hide();
	}else if($selectedvalue == 3) {
		$("#excelMode").show();
		$("#packageMode").hide();
		$("#singleMode").hide();
	}
});
// 本地上传--->单份上传的选择简历radio事件
$(":radio[name='resumeFormat']").click(function() {
	var $selectedvalue = $("input[name='resumeFormat']:checked").val();
	if($selectedvalue == 2) {
		$(".trResumefile").hide();
		$(".trResumeCopyTxt").show();
	}
	else if($selectedvalue == 1) {
		$(".trResumeCopyTxt").hide();
		$(".trResumefile").show();
	}
});
$('#recruitChannel').change(function() {
	$(".trInternalRecommend").hide();
	if($('#recruitChannel').val() == 3) {
		$(".trInternalRecommend").show();
	}
});
$('#recruitChannelMultiple').change(function() {
	$(".trInternalRecommendMultiple").hide();
	if($('#recruitChannelMultiple').val() == 3) {
		$(".trInternalRecommendMultiple").show();
	}
});
$("#upload-tab span").click(function() {
	$("#upload-tab span").attr("class","");
	$(this).attr("class","hover");
})

// 文件上传的样式控制
$(".localUploadResume").mouseenter(function() {
	$(".r_prompt_c").show();
}).mouseout(function() {
	$(".r_prompt_c").hide();
})

$(".localUploadResume").click(function() {
	$("#resumeFile").click();
})

// 获取文件的相关信息
function getFileInfor() {
	if(!checkFileType($("#resumeFile").val(),new Array("docx","doc","txt","html","htm","pdf","mht"))) {
		$("#validateLocal").css({top:"240px",left:"30px"});
		$("#validateLocal .tanchu_nr").text("请上传doc,docx,txt,html,htm,pdf,mht格式的文件!");
        $("#validateLocal").show();
    	setTimeout("coloseErrorMsg(validateLocal)",1000*5);
		return false;
	}
	var d="<tr class='flieRecord'>";
	var time = new Date().getTime();
	var file = $("#resumeFile")[0].files[0];
	d+="<td>"+file.name+"</td><td class='filesize'>"+file.size+"B</td><td ><span id='dele_file_" + time + "' class='delFileInfo' onClick='deleFile(\"file_" + time + "\")'>删除</span></td>";
	$("#tblUploadList tbody").prepend(d);
    var resumeFile = $("#resumeFile").clone();
    resumeFile.attr("id","file_" + time);
    resumeFile.attr("name","resumeFile_" + time);
    resumeFile.addClass("add-file");
    $("#importFromLocalMulti").append(resumeFile);
    refreshFileInfo();
}

// 统计已选择文件的信息
function refreshFileInfo() {
	var total = $("#tblUploadList tbody tr").length-1;
	var fileSize = $(".filesize");
    var totalSize=0;
    for(var i=0;i<fileSize.size();i++) {
    	totalSize += parseInt(fileSize[i].innerHTML);
    }
    if(total > 0) {
    	$(".localUploadResume").val("继续添加简历");
    }
    else {
    	$(".localUploadResume").val("添加简历");
    }
    $("#addResumeTotal").text(total);
    $("#fileCount").text(total);
    $("#fileSize").text(totalSize);
    $("#surplus").text(20 - total);
}

// 删除一行记录
function deleFile(fileId) {
	$("#dele_" + fileId).parent().parent().remove();
	$("#" + fileId).remove();
	refreshFileInfo();
}

// 清空记录
$("#btnClearUploadedResume").click(function() {
	$(".flieRecord").remove();
	$(".add-file").remove();
	refreshFileInfo();
})

// 验证文件类型
function checkFileType(filePath,types) {
    var fileLowerPath = filePath.toLowerCase();
    var fileType = fileLowerPath.substring(fileLowerPath.lastIndexOf('.') + 1); // 获取文件的后缀名
    return types.Exists(fileType);
}

