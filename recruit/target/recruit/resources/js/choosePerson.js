var allRecruiter;

// 点击取消按钮隐藏
$(".selPost-cancel").click(function(){
	alert("111");
  $(".selPostBy-upper-data").hide();
  hideWindow("#selPostBy-choose-win");
  
})

// 控制按人员自动查询初始化值
$(".selPost-searchByNameOrAccount").val("请输入人员姓名或人员账号");
$(".selPost-searchByNameOrAccount").focus(function(){
	$(".selPost-searchByNameOrAccount").val("");
}).blur(function(){
	$(".selPost-searchByNameOrAccount").val("请输入人员姓名或人员账号");
})

// 查询所有账号
queryAccount();

function queryAccount() {
	$.ajax({
		url : "/recruit/baseUserController/queryAllRecruiter",
		dataType : "json",
		success : function(msg) {
			if(msg.obj) {
				allRecruiter = msg.obj;
			}
			intitAutoComplete();
		},
		error : function() {
			alert("异常！");   
		}
	});
}

function intitAutoComplete() {
	$("#accountSearch").autocomplete(
		allRecruiter,
		{
			minChars : 1,
			width : 160,
			matchContains : true,
			closeOnClick : false,
			formatItem : function(d, o, j) {
				return  d.account + "  --  " + d.name;
			},
			formatMatch : function(d, n, j) {
				return d.account + d.name;
			},
			formatResult : function(d) {
				return d.account;
			}
		}
	).result(function(i, d, j) { //当按人员查询框的值改变时所做的处理
		$(".selPostBy-upper-data").show();
		$(".selPostBy-background-data2").show();
		$("#selPostBy-data-span").html("<span id='selPost-span-val' value='" + d.id + "'>" + d.account + "</span>");
	});
}

// 鼠标在已选择人员处操作的处理
$(".selPostBy-background-data2").mouseover(function(){
	$(this).addClass("person-background");
	$(".person-img").show();
}).mouseleave(function(){
	$(this).removeClass("person-background");
	$(".person-img").hide();
}).click(function(){
	$(this).hide();
});

// 点击查询触发ajax请求
$(".selPostBy-queryByDept").click(function(){
	if(!departmentChoose["#selPostBy-departmentBtn"]) {
		return;
	}
	var aj = $.ajax({    
	    url:'/recruit/org/queryUserByOrg/' + departmentChoose["#selPostBy-departmentBtn"],// 跳转到 action    
	    type:'post',    
	    cache:false,
	    dataType:'json',    
	    success:function(data) { 
	    	var d="";
	        if(data.obj && data.obj.userList.length > 0){
	        	for(var i = 0; i < data.obj.userList.length; i++) {
	        		d += '<li><input type="radio" name="personName" value="' + data.obj.userList[i].id + '"  onclick="selectPerson(\'' + data.obj.userList[i].id + "\','"
					 + data.obj.userList[i].name + '\')" title="' + data.obj.userList[i].account + '" >' + data.obj.userList[i].name + '</li>'
	        	}
	        }
	        $(".selPostBy-department-data").show();
        	$(".selPostBy-department-data ul").html(d);
	     },    
	     error : function() {    
	        alert("异常！");    
	     }    
	});  
});

// 点击招聘人员单选按钮触发事件
function selectPerson(id,text){
	$(".selPostBy-upper-data").show();
	$(".selPostBy-background-data2").show();
	$("#selPostBy-data-span").html("<span>"+text+"</span>");
}

$(".usual").click(function(){
	alert("11111");
	/*var id = $(this).val();
	var account = $(this).text();
	$("#selPostBy-data-span").html("<span id='selPost-span-val' value='" + id + "'>" + account + "</span>");*/
})
