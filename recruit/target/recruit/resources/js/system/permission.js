
 $(document).ready(function() {
	 initPage();
 })

 //初始化角色的权限
 function initPage(){
	 var userId = $("#userId").val();
	 var roleId = $("#roleId").val();
	 var flag = $("#flag").val();
	 $(".cPermission").attr("checked",false);
	 $.ajax({
			type : "post",
			dataType : "json",
			url : basePath + "/permission/resourceIds",
			data:{
				"userId":userId,
				"roleId":roleId,
				"flag":flag
			},
			success : function(data){
				for(var i=0;i<data.length;i++){
					$("input[resourceId='"+data[i]+"'] ").attr("checked",true);
				}
			},
			error: function() {
			}
		});
 }

//获取资源和权限的数据
function submitData(){
	var submitData =  getSubmitData();
  	$.ajax({
		type: "post",
		dataType: "json",
		async: false,
		url: basePath + "/permission/roleResourcePermission",
		data:submitData,
		success: function(data) {
			initPage();
			alert(data.msg);
		},
		error: function(msg) {
			initPage();
			alert("新增异常！");
		}
	});
}

 
//全选
function checkAllBox(){
	if($('#checkAll').is(':checked')){
		$(".cPermission").attr("checked",true)  
	}else{
		$(".cPermission").attr("checked",false)  
	}
}

//给用户设置权限
function submitUserData(){
	var submitData =  getSubmitData();
  	$.ajax({
		type: "post",
		dataType: "json",
		async: false,
		url: basePath + "/permission/userRoleResourcePermission",
		data:submitData,
		success: function(data) {
			initPage();
			alert(data.msg);
		},
		error: function(msg) {
			initPage();
			alert("新增异常！");
		}
	});
}

//获取权限的数据
function getSubmitData(){
	var input = $("#permissionTbody input:checkbox[name=permission]:checked");
  	var roleId = $("#roleId").val();
  	var flag = $("#flag").val();
  	var userId = $("#userId").val();
  	if(flag=="menuId"){
  		flag="1";
  	}else{
  		flag="0";
  	}
  	var resourceId = "";
  	var permissionId="";
  	for(var i=0;i<input.length;i++){
  		var doc = input[i];
  		resourceId += doc.getAttribute("resourceId")+",";
  		permissionId += doc.getAttribute("value")+",";
  	}
  	var data={
  		"userId":userId,
		"roleId":roleId,
		"resourceId":resourceId,
		"permissionId":permissionId,
		"flag":flag
  	}
  	return data;
}

//恢复角色权限
function retainRolePermission(){
	$.ajax({
		type: "post",
		dataType: "json",
		async: false,
		url: basePath + "/permission/retainRolePermission",
		data:{
			"userId":$("#userId").val()
		},
		success: function(data) {
			initPage();
			alert(data.msg);
		},
		error: function(msg) {
			initPage();
			alert("恢复异常！");
		}
	});
}

