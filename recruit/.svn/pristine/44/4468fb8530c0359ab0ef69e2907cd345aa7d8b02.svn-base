var professionalNum ,postNum,schoolNum=0;
var timeId,resumeId ='',sucData ="",headerTime ="";
var positionHtml,channelHtml,graduationSchoolHtml,highestEducationHtml,residencerHtml,labelHtml="";
var currentPositionData,channelData,graduationSchoolData,highestEducationData,residenceData,labelData = "";
var resumeEditorPermission = "";

$(function(){
	mini.parse();
	initPage();
	searchResume();
	eventBind();
	getPermissionData();
	// 标签选择器初始化
	TagPage.init({
		beforeClose: beforeTagPageClose
	});
});

//标签选择器关闭前把页面中职位的标签更新
function beforeTagPageClose() {
	 var grid = mini.get("datagrid2");
	 grid.load();
}

function getPermissionData(){
	resumeEditorPermission = $("#resumeEditorPermission").val();
}

// 事件绑定 
function eventBind() {
	$('input[name="isChannel"]').change(function() {
		if($('input[name="isChannel"]:checked').val() == 1){
			$("#resumeChannel").show();
		}else{
			$("#resumeChannel").hide();
		}
	});
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
		if($("#txtComment").val().trim() == '附言内容字数不能超过2000字'){
			$("#txtComment").val("");
		}
	}).blur(function(){
		if($("#txtComment").val().trim() == ""){
			$("#txtComment").val('附言内容字数不能超过2000字');
		}
	});
	
	$(".more-expand").live("click",function() {
		$(".more-search").toggle();
		$(this).find(".font-icon").toggleClass("icon-angle-double-up").toggleClass("icon-angle-double-down");
	});
	
	$(".baza-resumeTag-icon").click(function(){
		showAtPos("resume-choose-win",".resume-label");
	})
	
	//热门标记添加
	$(".resume-hotLabel").click(function(){
		$("#choosedTags").show();
		var text = $(this).text();
		var addedTagsValue = $("#choosedTags span");
		if(addedTagsValue.length>0){
			for(var i=0;i<addedTagsValue.length;i++){
				if(text ==addedTagsValue[i].innerHTML){
					return
				}
			}
			$("#choosedTags").append("<span class='label-show'><span class='tagList'>"+text+"</span><img class='label-img' src='"+basePath+"/resources/images/x.jpg'></span>");
		
		}else{
			$("#choosedTags").append("<span class='label-show'><span class='tagList'>"+text+"</span><img class='label-img' src='"+basePath+"/resources/images/x.jpg'></span>");
		}
	})
	
	//删除标记
	$(".label-show").live("click",function(){
		$(this).remove();
	}).live("mouseenter",function(){
		$(this).children("img").show();
		$(this).css("backgroundColor","white");
	}).live("mouseleave",function(){
		$(this).children("img").hide();
		$(this).css("backgroundColor","#CDDEF2");
	});
	
	//专业，学校以及意向岗位等点击类别弹出子类
	$(".professional-category-pdata a").click(function(){
		var datavalue = $(this).attr("datavalue");
		dataCategory.show('professional',pro ,datavalue);

	})

	$(".post-category-pdata a").click(function(){
		var datavalue = $(this).attr("datavalue");
		dataCategory.show('post',job ,datavalue);
	})

	$(".school-category-pdata a").click(function(){
		var datavalue = $(this).attr("datavalue");
		dataCategory.show('school',school,datavalue);
	})
	
	$(".remove").click(function(){
		$(this).next().val("");
		$(this). prev().val("选择/修改");
		$(this).hide();
	})

	$("#currentryWorkplace").click(function(){
		chooseArea(this.id);
	});
	$("#intentionWorkplace").click(function(){
		chooseArea(this.id);
	})
	
	//更多操作弹框的显示与隐藏
	$("#sltMoreOperate").click(function(){
		$(".moreOperate").show();
	}).mouseout(function(){
		timeId = setTimeout("$('.moreOperate').hide()",20);
	})

	$(".moreOperate").mouseout(function(){
		timeId = setTimeout("$('.moreOperate').hide()",20);
	}).mouseover(function(){
		clearTimeout(timeId);
	})

	//显示设置弹出框的显示与隐藏
	$("#showSetLabel").click(function(){
		$(".showPosition-choose").show();
	}).mouseout(function(){
		timeId = setTimeout("$('.showPosition-choose').hide()",20);
	})

	$(".showPosition-choose").mouseout(function(){
		timeId = setTimeout("$('.showPosition-choose').hide()",20);
	}).mouseover(function(){
		clearTimeout(timeId);
	})

	//点击checkbox设置显示的内容
	$(".resume-check").click(function(){
		var column = $(this).val();
		var id = $(this).attr("id");
		var isChecked = $(this).attr("checked");
		if(isChecked == "checked"){
			$.cookie(id,"1",{ expires: 3650 });
			dataShow(column);
		}else{
			$.cookie(id,"0",{ expires: 3650 });
			dataHide(column);
		}
	})
	
	//给不同的div不同的数据
	$(".header").live("click",function(){
		var id = $(this).attr("id");
		var lt = $(this).offset();
		$("#selectDrop").show();
		$("#selectDrop").css({
			top:lt.top+25,
			left:lt.left
		});
		switch (id){
   			case "headerPositionName":
   				$("#selectDrop ul").html(positionHtml);
   				break;
   			case "headerResidence":
   				$("#selectDrop ul").html(residencerHtml);
   				break;
   			case "headerHighestEducation":
   				$("#selectDrop ul").html(highestEducationHtml);
   				break;
   			case "headerGraduationSchool":
   				$("#selectDrop ul").html(graduationSchoolHtml);
   				break;
   			case "headerChannel":
   				$("#selectDrop ul").html(channelHtml);
   				break;
   			case "headerLabel":
   				$("#selectDrop ul").html(labelHtml);
   				break;
   			default:
   				break;
		}
	}).live("mouseleave",function(){
		headerTime=	setTimeout("$('#selectDrop').hide()",10);
	}).live("mouseenter",function(){
		clearTimeout(headerTime);
	})

	//控制显示统计数据的div的显示和隐藏
	$("#selectDrop").mouseleave(function(){
		headerTime = setTimeout("$('#selectDrop').hide()",50);
	}).mouseenter(function(){
		clearTimeout(headerTime);
	})
	
	//点击统计数据查询相关数据
	$(".classifyInfo").live("click",function(){
		var value = $(this).attr("val");
		var sign = $(this).attr("sign");
		var textValue = $(this).text();
		if(value.length == textValue.length){
			value = "";
		}
		var data = getData();
		switch (sign){
			case "position":
				currentPositionData = value;
				break;
			case "channel":
				channelData = value;
				break;
			case "graduationSchool":
				graduationSchoolData = value;
				break;
			case "highestEducation":
				highestEducationData = value;
				break;
			case "residencer":
				residenceData = value;
				break;
			case "label":
				labelData = value;
		}
		data.currentPosition=currentPositionData;
		data.channel=channelData;
		data.graduationSchool = graduationSchoolData;
		data.highestEducation = highestEducationData;
		data.residence = residenceData;
		data.label=labelData;
		loadData(data);
	})
	
	
}

//除去重复的方法
function removeRepeat(preArray,array){
	for(var j=0;j< preArray.length; j++){
		var span = preArray[j].innerHTML;
		for(var i=0;i<array.length;i++){
			if(span == array[i]){
				array.splice(i,1);
			}
		}
	}
	return array;
}

//确认按钮，标记赋值
function confirmLabel(id){
	var label= $(".tagList");
	var value="";
	if(label.length >0){
		for(var i=0;i<label.length;i++){
			value += label[i].innerHTML+",";
		}
	}
	$("#resumeTag").val(value);
	hideWindow(id)
	
}

//打开win窗口
function openThisWin(id,win){
	saveCategoryNum(id);
	showAtPos(win,"#"+id);
}

function saveCategoryNum(name){
	switch (name) {
	case "professional":
	    dataCategory.count = $(".choose-professional-data li").length;
		break;
	case "post":
		dataCategory.count = $(".choose-post-data li").length;
		break;
	case "school":
	   dataCategory.count = $(".choose-school-data li").length;
		break;
	default:
		break;
	}
}

//弹出数据类别选项
function openData(name){
	$(".choose-"+name+"-panel2").show();
	$(".choose-"+name+"-panel").show();
	$("."+name+"-category-pdata").show();
	var o = $(".choose-"+name+"-tip").offset();
	var l = o.left;
	var t = o.top;
	$("."+name+"-category-pdata").css({
		top: t+25,
		left: l
	})
}

//隐藏数据类的panel
function hidePanel(s){
	$("."+s+"-category-pdata").hide();
	$(".choose-"+s+"-panel2").hide();
	$(".choose-"+s+"-panel").hide();
}

function closeDataPanel(s){
	timeId = setTimeout("hidePanel('"+s+"')",20);
}

function cancelEvent(){
	clearTimeout(timeId);
}

//隐藏win
function hideCaegoryWindow(category,id){
	$("."+category+"-category").css("border-bottom","0px");
	hideWindow(id)
}

//提交数据
function submitCategoryData(category){
	var name = "";
	var value = "";
	var arrayLi = $(".choose-"+category+"-data li");
	for(var i = 0; i < arrayLi.length; i++){
		name += arrayLi[i].title+",";
		value +=arrayLi[i].value+",";
	}
	if(arrayLi.length > 0) {
		name = name.substring(0,name.length - 1);
	}
	else {
		name = "选择/修改";
	}
	$("#"+category).val(name);
	$("#"+category+"1").val(name);
	$("#"+category).next().show();
	positionSimilarName = name;
	positionSimilarId = value;
	hideWindow("#"+category+"-category-win");
	/*$("#positionSimilar").trigger("validate");*/
	$("."+category+"-category").css("border-bottom","0px");
	saveCategoryNum(category);
}

//选择城市
function chooseArea(separateId) {
	area.Show(separateId);
	showAtPos('popInner','#'+separateId);
	var win = mini.get('popInner');
	win.setTitle("请选择城市");
}

//关闭地区弹出框
function closeWin(separateId){
	$(".ac_results").remove();
	$("#areaSearch").removeClass("input-in");
	$("#areaSearch")[0].value = $("#areaSearch")[0].defaultValue;
	hideWindow("#popInner");
	$("#"+separateId).trigger("validate");
}

//显示设置
function dataShow(column){
    var grid = mini.get("datagrid2");
    grid.showColumn(column);
}
//dataGrid隐藏设置
function dataHide(column){
	 var grid = mini.get("datagrid2");
	 grid.hideColumn(column);
}

//初始化页面的选中与未选中状态
function loadShowSetData(e){
	var grid = mini.get("datagrid2");
	var checkNum = $(".resume-check");
	//隐藏id列
	grid.hideColumn("id");
	grid.hideColumn("positionId");
	grid.hideColumn("labelIdColumn");
	for(var i=0;i<checkNum.length;i++){
		var id = checkNum[i].getAttribute('id');
		var cookKey = $.cookie(id);
		if(typeof(cookKey) == "undefined"){
			$.cookie(id,"1",{ expires: 3650 });
			$("#"+id).attr("checked", "checked"); 
		}else if(cookKey=="1"){
			var column = $("#"+id).val();
			$("#"+id).attr("checked","checked");
			grid.showColumn( column ); 
		}else{
			$("#"+id).attr("checked", false); 
			var column = $("#"+id).val();
			grid.hideColumn(column);
		}
	}
	$(".position-table").show();
}


//封装简历的搜索参数
function getData(){
	var labelSign = 1;
	if($("#labelSign").attr('checked')==undefined){
		labelSign = 0;
	}
	var keyWordsSign = 1;
	if($("#keyWordsSign").attr('checked')==undefined){
		keyWordsSign = 0;
	}
	
	var educationSign = 1;
	if($("#educationSign").attr('checked')==undefined){
		educationSign = 0;
	}
	var lowerExperience = $("#lowerWorkYear").val();
	if($.trim(lowerExperience) !=""){
	      if(isNumber(lowerExperience)==false){
	    	  alert("您输入的工作年限不是数字");
	    	  return;
	      }
	}
	var upperExperience = $("#upperWorkYear").val();
	if($.trim(upperExperience) !=""){
		if(isNumber(upperExperience)==false){
		    alert("您输入的工作年限不是数字");
		    return;
		}
	}
	var lowerAge = $("#lowerAge").val();
	if($.trim(lowerAge) !=""){
		if(isNumber(lowerAge)==false){
			alert("您输入的年龄非法");
			 return;
		}
	}
	
	var upperAge = $("#upperAge").val();
	if($.trim(upperAge) !=""){
		if(isNumber(upperAge)==false){
			alert("您输入的年龄非法");
			 return;
		}
	}
	var channel = $("#channel option:selected").text();
	if(channel =="请选择"){
		channel = "";
	}
	var resumeData={
			 keyword: $("#keyword").val(),
			 name : $("#name").val(),
			 currentPosition : $("#currentPosition").val(),
			 lowerUpdateDate : mini.get("#lowerUpdateDate").getFormValue(),
			 upperUpdateDate:mini.get("#upperUpdateDate").getFormValue(),
			 company :$("#companyName").val(),
			 label :$("#resumeTag").val(),
			 sex : $("#sex option:selected").attr("value"),
			 highestEducation : $("#highestEducation option:selected").attr("value"),
			 professional : $("#professional1").val(),
			 lowerExperience : lowerExperience,
			 upperExperience : upperExperience,
			 channel : channel,
			 email : $("#email").val(),
			 currentIndustry : $("#currentlyIndustry1").val(),
			 residence : $("#currentryWorkplace1").val(),
			 graduationSchool : $("#school1").val(),
			 lowerAge : $("#lowerAge").val(),
			 upperAge : $("#upperAge").val(),
			 postExpect : $("#post1").val(),
			 industryExpect : $("#intentionIndustry1").val(),
			 workplaceExpect : $("#intentionWorkplace1").val(),
			 salaryExpect : $("#expectedSalary").val(),
			 labelSign:labelSign,
			 keyWordsSign:keyWordsSign,
			 educationSign:educationSign
    }
	return resumeData;
}

function isNumber(str){
    if(!$.isNumeric(str )){
    	return false;
    } else{
    	return true;
    }
}

//搜索
function searchResume(){
    var data = getData();
    loadData(data);
}

//根据条件加载简历数据
function loadData(data){
	sucData = data;
    var grid = mini.get("datagrid2");
    /*var positionManage =grid.getSelecteds();*/
    //console.log(data);
	grid.load({
		keyword:data.keyword, 
		name:data.name,
		currentPosition:data.currentPosition,
		lowerUpdateDate:data.lowerUpdateDate,
		upperUpdateDate:data.upperUpdateDate,
		company:data.company,
		label:data.label,
		sex:data.sex,
		highestEducation:data.highestEducation,
		professional:data.professional,
		lowerExperience:data.lowerExperience,
		upperExperience:data.upperExperience,
		channel:data.channel,
		email:data.email,
		currentIndustry:data.currentIndustry,
		residence:data.residence,
		graduationSchool:data.graduationSchool,
		lowerAge:data.lowerAge,
		upperAge:data.upperAge,
		postExpect:data.postExpect,
		industryExpect:data.industryExpect,
		workplaceExpect:data.workplaceExpect,
		salaryExpect:data.salaryExpect,
		educationSign:data.educationSign,
		keyWordsSign:data.keyWordsSign,
		labelSign:data.labelSign,
	});
}

//按更新时间进行排序
function sortByUpdateDate() {
  var grid = mini.get("datagrid2");
  grid.sortBy('updateDate','asc');
}
//在画表格的时候为操作添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value=e.value
    //超链接任务
    switch (field){
        case "name":
        	if(value !=null) {
        		e.cellHtml = '<a id="' + row.id + '" href="' + basePath + "/resume/personalResume/" + row.id + '" class="showCellTooltip" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + value + '</a>';
        	}else{
        		e.cellHtml = '<a id="' + row.id + '" href="' + basePath + "/resume/personalResume/" + row.id + '" class="showCellTooltip" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + "" + '</a>';
        	}
        	break;
        case "residence":
        	if(value) {
        		if(areas[value]) {
        			e.cellHtml = areas[value].name;
        		}
        	}
        	break;
    	case "operate":
    		if(resumeEditorPermission.length>0) {
    			e.cellHtml = '<a id="' + row.id + '" href="' + basePath + "/resume/editResume/" + row.id + '" class="showCellTooltip" style="display:block;width:100px;height:20px;color:blue;" data-placement="right"  target="editor_window" >' + "编辑" + '</a>';
    		}
    		break;
    	case "position":
    		if(value) {
    			e.cellHtml = '<a id="' + row.positionId + '" class="showCellTooltip"  href="/recruit/position/preview?recruitPositionId='+row.positionId +'" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + value+ '</a>';
    		}
    		break;
    	case "updateDate":
    		if(row.updateDate !=null) {
    			e.cellHtml = (new Date(row.updateDate).format("yyyy-mm-dd"))
    		}
    	default:
    		break;
    }
}

//成功加载完数据显示总的记录数
function successLoad(){
	var grid = mini.get("datagrid2");
	$("#totalCount").html(grid.getTotalCount()+"份");
	positionHtml = "<li class='classifyInfo'  sign='position' val='职位或岗位'>职位或岗位</li>";
	channelHtml = "<li class='classifyInfo'  sign='channel' val='招聘渠道'>招聘渠道</li>";
	graduationSchoolHtml="<li class='classifyInfo' sign='graduationSchool' val='毕业学校'>毕业学校</li>";
    highestEducationHtml="<li class='classifyInfo' sign='highestEducation' val='学历'>学历</li>";
    residencerHtml="<li class='classifyInfo' sign='residencer' val='当前所在地'>当前所在地</li>";
    labelHtml = "<li class='classifyInfo' sign='label' val='标签'>标签</li>"
	//数据加载成功之后用ajax返回页面需要的一些小信息
	$.ajax(  
      {  
		type : "post",
		dataType : "json",
		data : JSON.stringify(getData()),
		url : basePath + '/resume/queryClassifyInfo',
		contentType : "application/json;charset=UTF-8",
        error:function(){},  
        success:function(data)  
          {  
            for(var i=0;i<data.channel.length;i++){
              if(typeof(data.channel[i].name)!="undefined"){
                channelHtml+="<li class='classifyInfo' sign='channel' val="+data.channel[i].name+">"+data.channel[i].name+"("+data.channel[i].totalCount+")</li>"
              }
            }
            for(var i=0;i<data.position.length;i++){
              if(typeof(data.position[i].name) != "undefined"){
                positionHtml+="<li class='classifyInfo' sign='position' val="+data.position[i].name+">"+data.position[i].name+"("+data.position[i].totalCount+")</li>"
              }
            }
            for(var i=0;i<data.graduationSchool.length;i++){
              if(typeof(data.graduationSchool[i].name) != "undefined"){
                graduationSchoolHtml+="<li class='classifyInfo' sign='graduationSchool' val="+data.graduationSchool[i].name+">"+data.graduationSchool[i].name+"("+data.graduationSchool[i].totalCount+")</li>"
              }
            }
            for(var i=0;i<data.highestEducation.length;i++){
              if(typeof(data.highestEducation[i].name) != "undefined"){
                highestEducationHtml+="<li class='classifyInfo' sign='highestEducation' val="+data.highestEducation[i].name+">"+data.highestEducation[i].name+"("+data.highestEducation[i].totalCount+")</li>"
              }
            }
            for(var i=0;i<data.residencer.length;i++){
              if( typeof(data.residencer[i].name) != "undefined"){
                residencerHtml+="<li class='classifyInfo' sign='residencer' val="+data.residencer[i].name+">"+data.residencer[i].name+"("+data.residencer[i].totalCount+")</li>"
              }
            }
                          
            for(var i=0;i<data.label.length;i++){
              if( typeof(data.label[i].name) != "undefined"){
                labelHtml+="<li class='classifyInfo' sign='label' val="+data.label[i].name+">"+data.label[i].name+"("+data.label[i].totalCount+")</li>"
               }
             }
           }  
         }  
       );                                    
     }

//导出
function repositoryExport(){
	var ser = $("#resume-searchPositionManage").serialize();
	window.location.href = "/recruit/resume/repositoryExport?"+ser;
}

//简历删除
function deleteResume(id){
	var win = mini.get(id);
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/deleteResumeById",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"resumeIds": resumeId},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid2").reload();
        },
        error:function (e){
        	alert(e)
        }
    });
}

//加入候选人
function addToCandidate(id){
	var channel = "";
	var win = mini.get(id);
	var isChannel = $('input[name="isChannel"]:checked').val();
	if(isChannel == "1"){
		channel = $("#resumeChannel option:selected").text();
	}
	var relatePositionId = $("#relatePositionName").val();
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/addToCandidate",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"resumeId": getFirstResumeId(),"channel" : channel,"relatePositionId":relatePositionId},
        success: function (json, textStatus) {
        	alert("操作成功");
        	mini.get("datagrid2").reload();
        },
        error:function (e){
        	alert(e)
        }
    });
}

//发送简历
/*function transmitResume(id){
	var txtSrEmail = $("#txtSrEmail").val();
	if(txtSrEmail.trim() == '' || txtSrEmail.trim() == '多个邮箱请用";"号隔开'){
		var html = $('<label style="width:180px;color:red;">请输入邮箱</label>');
		$("#txtSrEmail").after(html);
		return false;
	}
	var candidateName = $("#candidateName1").text();
	var win = mini.get(id);
	var postscript = $("#txtComment").val();
	var sendResumeTemp = $("#sendResumeTemp").val();
	win.hide();
	jQuery.ajax({
        url: "/recruit/resume/transmitResume",
        type: "POST",
        cache: false,
        async: false,
        dataType: "json",
        data: {"resumeIds": resumeId,"txtSrEmail":txtSrEmail,"candidateName" : candidateName,"postscript" : postscript,"sendResumeTemp" : sendResumeTemp},
        success: function (json, textStatus) {
        	if(json.msg == "操作成功"){
        		alert(json.msg);
            	mini.get("datagrid2").reload();
        	}else{
        		alert("操作成功失败");
        	}
        },
        error:function (e){
        	alert(e)
        }
    });
}*/

//发送邮件
function sendMail(id){
	var win = mini.get(id);
	win.hide();
	window.location.href = "mailto:"+$("#txtResumeEmails").val();
}
//获取选中checkbox的getResumeId
function getResumeId(){
	mini.parse();
    var grid = mini.get("datagrid2");
    var resume =grid.getSelecteds();
    var resumeIdArray = new Array();
    var resumeNameArray = new Array();
    var resumeEmailArray = new Array();
    var resumePhoneArray = new Array();
    for(var i = 0; i < resume.length; i++){
    	resumeIdArray[i] = resume[i].id.trim();
    	if(resume[i].name) {
    		resumeNameArray[i] = resume[i].name.trim();
    	}
    	if(resume[i].email){
    		resumeEmailArray[i] = resume[i].email.trim();
    	}
    	if(resume[i].phone){
    		resumePhoneArray[i] = resume[i].phone.trim();
    	}
    }
    resumeId = resumeIdArray.join(",");
    if(resume.length > 0){
    	$("#positionName").text(resume[0].position);
        $("#candidateName").text(resumeNameArray.join());
        $("#candidateName1").text(resumeNameArray.join());
        $("#txtResumeEmails").text(resumeEmailArray.join(";"));
        $("#mobilePhone").text(resumePhoneArray.join(";"));
    }
}

//验证是否选中简历
function validateCheck(validateChecked,id,cl){
	getResumeId();
	if(resumeId==""){
		openErrormsg(validateChecked);
		return false;
	}
	//弹出window框
    var win = mini.get(id); 
    var lt = $(cl).offset();
    win.showAtPos(lt.left+60, lt.top-100); 
}
//选择简历提示
function openErrormsg(validateChecked){
	$(validateChecked).show();
	setTimeout("coloseErrorMsg(validateChecked)",1000*2);
}
//关闭选择职位简历提示框
function coloseErrorMsg(validateChecked){
	$(validateChecked).hide();
}
//取消按钮关闭弹出框
function closeWindow(id){
	$("#addedTags span").empty();
	hideWindow(id)
}
//初始化页面
function initPage(){
	$("#professional1").val("");
	$("#currentlyIndustry1").val("");
	$("#school1").val("");
	$("#post1").val("");
	$("#intentionWorkplace1").val("");
	$("#currentryWorkplace1").val("");
	$("#intentionIndustry1").val("");
}

//查看
$("#setSecurity").click(function(){
	var id = getFirstResumeId();
	if(id.length<1){
		openErrormsg(validateChecked);
		return false;
	}
	window.open("/recruit/resume/personalResume/"+id);
})

//获取首个简历Id
function getFirstResumeId(){
	getResumeId();
	var ids = resumeId.split(",");
	return ids[0];
}

$("#addToCandidate").click(function(){
	validateCheck('#validateChecked','resume-add-candidate-win','#addToCandidate');
	$("#relatePositionName").html("");
	$("#relatePositionName").append("<option selected>请选择</option>");
	addRelatePosition()
})

function addRelatePosition(){
	$.ajax({
		url:'/recruit/position/positionByStatus',
		type:"post",
		data:{"status":"011-002"},
		dataType:"json",
	    success:function(data){
	    	var positionData = data.obj;
	    	var d = "";
	    	for(var i=0;i<positionData.length;i++){
	    		d+="<option value="+positionData[i].recruitPositionId+" >"+positionData[i].positionName+"</option>";
	    	}
	    	$("#relatePositionName").append(d);
	    },
	    error:function (e){
        	alert(e)
        }
	    
	})
}

$("#label").click(function(){
	var id = getFirstResumeId();
	if(id.length<1){
		openErrormsg(validateChecked);
		return false;
	}else{
		var grid = mini.get("datagrid2");
		var resume =grid.getSelecteds();
		var row = resume[0];
		TagPage.o.resumeId = id;
		TagPage.setSelect(row.labelId);
		showAtPos('tagSelectWin','#label');
	}

})

//重置
function resetResume(){
	$("#resume-searchPositionManage")[0].reset();
	$("#professional").val("选择/修改");
	$("#currentryWorkplace").val("选择/修改");
	$("#school").val("选择/修改");
	$("#post").val("选择/修改");
	$("#intentionIndustry").val("选择/修改");
	$("#intentionWorkplace").val("选择/修改");
	$("#currentlyIndustry").val("选择/修改");
	initPage();
	$(".remove").hide();
	/*searchResume();*/
}


