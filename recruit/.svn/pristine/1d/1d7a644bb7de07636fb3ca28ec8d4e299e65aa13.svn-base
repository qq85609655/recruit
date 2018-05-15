/**
 * departmentBtn 标识相应的部门btn
 * deparmentId 
 */
var departmentBtn = "";
var departmentChoose = {};

// 选择部门
$(".dep-choosebtn").click(function() {
	departmentBtn = "#" + this.id;
	chooseDepartment(departmentBtn);
});

// 显示华星部门树
function chooseDepartment(cl) {
	var lt = $(cl).offset();
	var l = lt.left;
	var t = lt.top;
	$("#mini-dept-tree").show();
	$("#mini-dept-tree").css({
		top : t + 25,
	    left : l,
	    width :154,
	    "border-width" : 1,
	    "z-index":"100000"
	});
	$(".clearButton").remove();
	$("#mini-dept-tree").append("<span class='clearButton'>不选择</span>");
}

$(".clearButton").live('click',function() {
	notChoose();
});

function notChoose() {
	$(departmentBtn).val("请选择部门");
	collapseTree();
	$("#mini-dept-tree").hide();
	delete departmentChoose[departmentBtn];
	departmentBtn = "";
}

// 隐藏华星部门树
$(".csot-department").mouseleave(function(){
	$("#mini-dept-tree").hide();
});

// 获取部门相关数据并赋值
 function onNodeSelect(e) {
    var node = e.node;
    var isLeaf = e.isLeaf;
    //if(isLeaf || departmentBtn == "#orgParentForAdd"){ // 如果是新增部门选择上绷部门时也可以
    	$(departmentBtn).val(node.orgName);
        departmentChoose[departmentBtn] = node.id;
        $("#mini-dept-tree").hide();
        if(departmentBtn == "#depChoose") {
        	$(departmentBtn).trigger("validate");
        }
    //}
}

// 获取部门树
function queryDep() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : basePath + "/org/datagrid",
		contentType : "application/json;charset=UTF-8",
		success : function(d) {
			var depTree = mini.get("mini-dept-tree");
			depTree.loadList(d,"id","orgParent");
			depTree.hide();
		},
		error: function() {
			console.log("加载部门数据失败!");
		}
	});
}

// 折叠树
function collapseTree() {
	var depTree = mini.get("mini-dept-tree")
	depTree.collapseAll();
}

/*
 * 获取人员信息
 */
// 保存button和隐藏域
var selPost ="";
var hidSelPostId="";
var hidSelPostText="";
var allRecruiter;

// 职位发布者选择弹框
function openSelPost(btnId,hidId,hidText) {
	showAtPos("selPostBy-choose-win",btnId);
	selPost = btnId;
	hidSelPostId = hidId;
	hidSelPostText=hidText;
	var value = $(btnId).val();
	var Id = $(hidId).val();
	var text = $(hidText).val();
	$(".selPostBy-upper-data").hide();
	$("#selPostBy-data-span").html("");
	$(".account-search")[0].value = $(".account-search")[0].defaultValue;
	$(".account-search").removeClass("input-in");
	$("#selPostBy-departmentBtn").val("选择部门");
	$(".selPostBy-department-data ul").html();
	if(Id || text) {
		$(".selPostBy-upper-data").show();
		$("#selPostBy-data-span").html("<span id='selPost-span-val' value='"+Id+"'>"+text+"</span>");
	}
}

// 点击确定按钮给相应的元素赋值
$(".selPost-submit").click(function(){
	var va = $("#selPost-span-val").text();
	var v = $("#selPost-span-val").attr("value");
	if(va.length > 0 && v.length > 0) {
		$(selPost).attr("value",va);
		$(hidSelPostText).attr("value",va);
		$(hidSelPostId).attr("value",v);
	}
	else {
		(selPost == "#recruiterChoose") ? $(selPost).attr("value","请选择招聘专员") : $(selPost).attr("value","请选择人员");
		$(hidSelPostText).attr("value","");
		$(hidSelPostId).attr("value","");
	}
	collapseTree();
	$("#mini-dept-tree").hide();
	hideWindow("#selPostBy-choose-win");
	if(selPost == "#recruiterChoose") {
		$(selPost).trigger("validate");
	}
});

// 点击取消按钮隐藏
$(".selPost-cancel").click(function(){
  $(".selPostBy-upper-data").hide();
  collapseTree();
  $("#mini-dept-tree").hide();
  hideWindow("#selPostBy-choose-win");
});

// 控制按人员自动查询初始化值
$("#accountSearch").focus(function() {
	if ($.trim(this.value) == this.defaultValue) {
		this.value = "";
		$(this).addClass("input-in");
	}
}).blur(function() {
	if ($.trim(this.value) == "") {
		this.value = this.defaultValue;
		$(this).removeClass("input-in");
	}
});

// 查询所有账号
queryAccount();

function queryAccount() {
	$.ajax({
		url : "/recruit/baseUserController/queryAllUser",
		dataType : "json",
		success : function(msg) {
			if(msg.obj) {
				allRecruiter = msg.obj;
			}
			intitAutoComplete();
		},
		error : function() {
			console.log("查询人员异常！");   
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
				return d.name;
			}
		}
	).result(function(i, d, j) { // 当按人员查询框的值改变时所做的处理
		$(".selPostBy-upper-data").show();
		$(".selPostBy-background-data2").show();
		$("#selPostBy-data-span").html("<span id='selPost-span-val' value='" + d.id + "'>" + d.name + "</span>");
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
	$("#selPostBy-data-span").html("");
	//$(this).hide();
});

// 点击查询触发ajax请求
$(".selPostBy-queryByDept").click(function(){
	if(!departmentChoose["#selPostBy-departmentBtn"]) { // 
		return;
	}
	var aj = $.ajax({    
	    url:'/recruit/org/queryUserByOrg/' + departmentChoose["#selPostBy-departmentBtn"],// 跳转到 action    
	    type:'post',    
	    cache:false,
	    dataType:'json',    
	    success:function(data) { 
	    	var d="";
	        if(data.obj && data.obj.userList.length > 0) {
	        	for(var i = 0; i < data.obj.userList.length; i++) {
	        		d += '<li><input type="radio" name="personName" value="' + data.obj.userList[i].id + '"  onclick="selectPerson(\'' + data.obj.userList[i].id + "\','"
					 + data.obj.userList[i].name + '\')" title="' + data.obj.userList[i].account + '">' + data.obj.userList[i].name + '</li>'
	        	}
	        }
        	$(".selPostBy-department-data ul").html(d);
	    },    
	    error : function() {    
	        console.log("根据部门查询人员异常！");    
	    }    
	});  
});

// 点击招聘人员单选按钮触发事件
function selectPerson(id,text) {
	$(".selPostBy-upper-data").show();
	$(".selPostBy-background-data2").show();
	$("#selPostBy-data-span").html("<span id='selPost-span-val' value='" + id + "'>" + text + "</span>");
}

$(".usual").click(function() {
	var id = $(this).attr("value");
	var account = $(this).text();
	if(typeof(account) !=undefined) {
		account = account.replace("+","");
	}
	$(".selPostBy-upper-data").show();
	$(".selPostBy-background-data2").show();
	$("#selPostBy-data-span").html("<span id='selPost-span-val' value='" + id + "'>" + account + "</span>");
});

