$(document).ready(function() {
	initPage();
	
})

function initPage(){
	//已上传的文件数
	var length = $("#tGlobal tr").length-1;
	$("#countUploadFile").html(length);
	//还可上传多少文件
	$("#countSurplus").html(50-length);
}

//当文件改变时
function ajaxFileUpload(){
	//验证
	var files = $("#file").val();
//	var files = document.getElementById("file");
//	var file = files.files[0];
	var flag = isValidFile(files,files.size);
	//赋值
	if(flag == true){
		$("#textFile").val(files);
	}else{
		$("#textFile").val("上传文件类型不匹配");
	}
}

//判断文件是否符合上传的要求
function isValidFile(fileName,fileSize){
	 var fileTypeArray = new Array("word","excel","html","htm","rar","zip","jpg","png","gif","doc","docx","txt","pdf","jpeg","xls","xlsx");
	 var fileLowerPath = fileName.toLowerCase();
		//获取文件的后缀名
     var fileType = fileLowerPath.substring(fileLowerPath.lastIndexOf('.') + 1);
     console.log(fileType);
     var count = "";
     for(var i = 0; i < fileTypeArray.length; i++){
     	if(fileType == fileTypeArray[i]){
     		count = 1;
	        }
     }
     if(count != 1){
    	 alert("上传文件类型不匹配，请上传WPRD|EXCEL|ZIP|RAR|DOC|DOCX|TXT|HTML|HTM|PDF|JPG|JPEG|GIF|PNG|XLS|XLSX|RAR|ZIP格式的文件")
    	 return false;
     }
     
     if(fileSize >4*1024*1024){
    	 alert("请上传小于4M的文件");
    	 return false;
     }
     return true;
}

$(".fileButton").click(function(){
	 var win = mini.get("file-win"); 
	 var lt = $(this).offset();
	 win.showAtPos(lt.left+160, lt.top+150); 
	
})

$("#cancelBtn").click(function(){
	hideWindow("file-win");
})

//提交表单
$("#submitBtn").click(function(){
	//form的验证
	var fileName = $("#fileName").val();
	if($.trim(fileName) ==''){
		$(".tipMessage").show();
		$(".tipContent").html("<b>文档名称不能为空</b>");
		$(".tipMessage").delay(3000).hide(1);
		return;
	}
	var name = $("#textFile").val();
	if($.trim(name) == "上传文件类型不匹配"){
		$(".tipMessage").show();
		$(".tipContent").html("<b>请选择文件上传</b>");
		$(".tipMessage").delay(3000).hide(1);
		return;
	}

	$.ajax({
		   url: "/recruit/resume/validateFileName", 
//		   context: document.body, 
		   async:false,
		   data:{fileName:$.trim(fileName)},
		   dataType:"json",
		   success: function(data){
			   if(data.success ==true){
//				   $("#fileForm").submit();
				   $("#fileForm").ajaxSubmit({
				        type : "POST",
				        dataType:"json",
						url : "/recruit/resume/addFile",
						success : function(msg) {
							console.log(msg);
							removeLoad();
							opResult(msg);
						},
						error : function(e) {
							removeLoad();
							ShowErrorTip("上传出现异常！");
						}
				    });
			   }else{
				   $(".tipMessage").show();
				   $(".tipContent").html("<b>文件名称已存在</b>");
				   $(".tipMessage").delay(3000).hide(1);
				   return;
			   }
      }});
	
})

$(".showFile").click(function(){
	/*$("#file").onclick()*/;
	document.getElementById('file').click();
})

$("#textFile").click(function(){
	/*$("#file").click();*/
	document.getElementById('file').click();
})


