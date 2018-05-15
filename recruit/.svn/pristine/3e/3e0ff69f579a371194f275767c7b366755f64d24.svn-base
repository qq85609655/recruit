$(document).ready(function() {
	
	// 初始化mini ui
	mini.parse();

    //设置初始化生日数据
	var date = mini.get("brithday");
	
	 var d = new Date();
     var y = d.getFullYear()-18;
     var m = d.getMonth();
     var d = d.getDate();
     var formatnowdate = y+'-'+m+'-'+d;
     var x = new Date(y,m,d);
     
	date.setValue(x);
	$(".dels").show();
	$(".lxl").show();
	
	
})

$("h3 a").hide();

//点击更多操作中的a标签，生成相应的编辑页面
$("#moreItems li a").click(function(){
	var id = $(this).attr("href");
	$(id).show();
	$(id).next().show();
	$(this).hide();
	$(this).parent().hide();
	
})

$(".dels").click(function(){
  $(this).parent().next().hide();
  $(this).parent().hide();
  var parentId = $(this).parent().attr("id");
  if(parentId == 'showSelfEvaluation'){
    //背景信息
    $("#editSelfEvaluation").val("");
    $("#viewSelfEvaluation").html("");
  }
  
  if(parentId == 'showCareerObject'){
    //求职意向
    $("#editCareerObject").val("");
    $("#viewCareerObject").html("");
  }
  
  if(parentId == 'showProjectExperience'){
  //项目经验
    $("#editProjectExperience").val("");
    $("#viewProjectExperience").html("");
  }
  if(parentId == 'showTrainingInfo'){
  //培训信息
      $("#editTrainingInfo").val("");
      $("#viewTrainingInfo").html("");
    }
  if(parentId == 'showLanguageSkill'){
  //语言描述  
        $("#editLanguageSkill").val("");
        $("#viewLanguageSkill").html("");
      }
  
  if(parentId == 'showRewards'){
    //奖励信息
          $("#editRewards").val("");
          $("#viewRewards").html("");
        }
  if(parentId == 'showCertification'){
    //证书信息
          $("#editCertification").val("");
          $("#viewCertification").html("");
        }
  
  if(parentId == 'showHobbies'){
    //兴趣爱好
          $("#editHobbies").val("");
          $("#viewHobbies").html("");
        }
  var id = $(this).parent().attr("id");
  $("#"+id+"Item").parent().show();
  $("#"+id+"Item").show();
})

//点击取消按钮隐藏相应的form
$(".cancel_btn_pop").click(function(){
	$(this).parents("form").hide();
	var dataTip = $(this).attr("data-tip");
	$("a[data-tip="+dataTip+"]").show();
})

//点击编辑按钮。再次编辑相应的表单信息
$(".edit_resume").click(function(){
	$(this).hide();
	$(this).parent().next().find('form').show();
	//工作经历中的更多信息的样式控制
	$("#plus").removeClass("minus");
	$("#plus").addClass("plus");
	$("#moreInfo").hide();
	//第二次点击编辑按钮时
	var dataTip = $(this).attr("data-tip");
	$("div[data-tip=pt8"+dataTip+"]").hide();
})

//工作经历中的更多信息按钮
$("#plus").click(function(){
	$(this).toggleClass("minus").toggleClass("plus");
	var temp= $("#moreInfo").is(":hidden");
	if(temp==true){
		$("#moreInfo").show();
	}else{
		$("#moreInfo").hide();
	}
});

//点击非表单数据的保存按钮，保存数据
$(".submit_btn_pop").click(function(){
	var dataTi = $(this).attr("data-tip");
	var value = $(this).parents("form").find("textarea").val();
	value = "<p>"+value+"</p>"
	value=value.replace(/\n/g,"<br/>");
	$("div[data-tip='"+dataTi+"']").show();
	$("div[data-tip='"+dataTi+"']").html(value);
	$(this).parents("form").hide();
	var editdataTi= $(this).next().attr("data-tip");
	$("a[data-tip="+editdataTi+"]").show();
})

//基本信息的保存
$("#editBascicInfoSave").click(function(){
	var d="";
	var flag = true;
	//验证数据信息
	var flag = verificationBascicInfoData();
	if(flag == true){
		//获得数据信息
		var basicInfoData = getBasicInfoData();
		d = writeBasicInfoHtml(basicInfoData);
		basicinfoOperation(d);
		
	}else{
		return;
	}
})


function getBasicInfoData(){
	var data = {
			id:$("#hiddenData").val(),
			name : $("#Name").val(),
			applyPostName :mini.get("applyPostName").getValue(),
			nationality : $("#nationality").val(),
			nationalityName : $("#nationality option:selected").text(),
			sex : $("#Sex").val(),
			sexName:$("#Sex option:selected").text(),
			brithday:mini.get("#brithday").getFormValue(),
			marriage:$("#Marriage").val(),
			marriageName:$("#Marriage option:selected").text(),
			residency:$("#residencyHid").val(),
			workYears:$("#WorkYears").val(),
			alternativePhone:$("#AlternativePhone").val(),
			phone:$("#Phone").val(),
			email:$("#Email").val(),
			address:$("#Address").val(),
			ethnic:$("#nation").val(),
			nationName :$("#nation option:selected").text(),
			certificateType : $("#certificateType").val(),
			certificateTypeName : $("#certificateType option:selected").text(),
			IDNumber:$("#IDNumber").val(),
			IDAddress:$("#IDAddress").val(),
	}
	return data;
}

//验证基本信息
function verificationBascicInfoData(){
	var flag = true;
	$('#Email').isValid(function(v){
	    if (v==false) {
	    	flag= false;
	    }
	});
	
	$("#Name").isValid(function(v){
	    if (v==false) {
	    	flag= false;
	    }
	});
	
	/*$("#Phone").isValid(function(v){
		if(v==false){
			flag= false;
		}
	});*/
	var x = $("#Phone").val() ;
    if($.trim(x)==""||x.length < 5 || x.length > 11){
      mini.alert("手机号位数只能5到11位！");
      flag = false ;
      return flag;
    }
	
	if($.trim($("#IDNumber").val())==""||$.trim($("#IDNumber").val()).length >18){
	  mini.alert("证件号不能为空,长度能超过18位！");
      flag = false ;
      return flag;
	}
	if($.trim(mini.get("#applyPostName").getValue())==""){
	  mini.alert("岗位不能为空！");
	  flag = false ;
	  return flag;
	}
	return flag;
}

//将基本信息写入页面
function writeBasicInfoHtml(basicInfoData){
	var d= "<ul>" +
			  "<li><span>姓名: </span><span id='bName' class='w300'>"+basicInfoData.name+"</span></li>";
	if($.trim(basicInfoData.applyPostName)!=""){
      d+="<li><span>岗位：</span><span id='applyPostName' class='w300'>"+basicInfoData.applyPostName+"</span></li>";
  }
	if($.trim(basicInfoData.nationality) !="" && $.trim(basicInfoData.nationalityName)!=""){
      d+="<li><span>国籍：</span><span class='w300' id='bNationalityName'>"+basicInfoData.nationalityName+"</span></li>";
      d+="<li style='display:none'><span  id='bNationality'>"+basicInfoData.nationality+"</span></li>";
  }
	if($.trim(basicInfoData.sex) !="" && $.trim(basicInfoData.sexName)!=""){
		d+="<li><span>性别：</span><span class='w300' id='bSexName'>"+basicInfoData.sexName+"</span></li>";
		d+="<li style='display:none'><span  id='bSex'>"+basicInfoData.sex+"</span></li>";
	}
	if($.trim(basicInfoData.brithday)!=""){
		d+="<li><span>出生日期：</span><span id='bBrith' class='w300'>"+basicInfoData.brithday+"</span></li>";
	}
	if($.trim(basicInfoData.marriage)!="" && $.trim(basicInfoData.marriageName)!=""){
		d+="<li><span>婚姻状况：</span><span class='w300' id='bMarriageName'>"+basicInfoData.marriageName+"</span></li>";
		d+="<li style='display:none'><span id='bMarriage'>"+basicInfoData.marriage+"</span></li>";
	}
	if($.trim(basicInfoData.residency)!=""){
		d+="<li><span>居住地：</span><span id='bResidency' class='w300'>"+basicInfoData.residency+"</span></li>";
	}
	if($.trim(basicInfoData.workYears)!=""){
		var workYears = basicInfoData.workYears;
		if(isNaN(workYears)){
		}else{
			d+="<li><span>工作年限：</span><span id='bWorkYears' class='w300'>"+basicInfoData.workYears+"</span></li>";
		}
	}
	if($.trim(basicInfoData.alternativePhone)!=""){
		d+="<li><span>备用电话：</span><span id='bAlternativePhone' class='w300'>"+basicInfoData.alternativePhone+"</span></li>";
	}
	if($.trim(basicInfoData.phone)!=""){
		d+="<li><span>手机号码：</span> <span id='bPhone' class='w300'>"+basicInfoData.phone+"</span></li>";
	}
	if($.trim(basicInfoData.email)!=""){
		d+="<li><span>Email：</span><span id='bEmail' class='w300'>"+basicInfoData.email+"</span></li>";
	}
	if($.trim(basicInfoData.address)!=""){
		d+="<li><span>联系地址：</span><span id='bAddress' class='w300'>"+basicInfoData.address+"</span></li>";
	}
	if($.trim(basicInfoData.ethnic)!=""&& $.trim(basicInfoData.nationName)!=""){
		d+="<li><span>民族：</span><span id='nationName' class='w300'>"+basicInfoData.nationName+"</span></li>";
		d+="<li style='display:none'><span  id='bEthnic'>"+basicInfoData.ethnic+"</span></li>";
	}
	if($.trim(basicInfoData.certificateType)!=""&& $.trim(basicInfoData.certificateTypeName)!=""){
      d+="<li><span>证件类型：</span><span id='certificateTypeName' class='w300'>"+basicInfoData.certificateTypeName+"</span></li>";
      d+="<li style='display:none'><span  id='certificateType'>"+basicInfoData.certificateType+"</span></li>";
  }
	if($.trim(basicInfoData.IDNumber)!=""){
		d+="<li><span>身份证号：</span><span id='bIDNumber' class='w300'>"+basicInfoData.IDNumber+"</span></li>";
	}
	if($.trim(basicInfoData.IDAddress)!=""){
		d+="<li><span>身份证地址：</span><span id='bIDAddress' class='w300'>"+basicInfoData.IDAddress+"</span></li></ul>";
	}
	d+="</ul>";
	return d;
}

function basicinfoOperation(d){
	$(".basicinfoData").html(d);
	$("#basicInforForm").hide();
	$("#basicInforForm")[0].reset();
	$(".basicinfoShow").show();
	$("#btnEditBasicInfo").show();
}

//用btn实现文件上传
$("#btnUpload").click(function(){
	$('#file_upload').click();
})

/*//实现上传图片的功能
function ajaxFileUpload(){
	$.ajaxFileUpload(
        {
             url:'/recruit/resume/uploadImage',      
             secureuri:false,
             fileElementId:'file_upload',                      
             dataType: 'text',                                
             success: function (data, status)            
               {   
            	 if(data !=""){
            		 data = data.substr(1, data.length-8);
    			     data = data.substr(5, data.length);
    			     var str =  data.split("*");
    			     if(str[0] =="文件上传路径"){
    			    	 $("#resumeAvatarImg").attr("src",str[1]);
    			    	 return ;
    			     }
            	 }
			
               },
             error: function (data, status, e)           
                {
            	 console.log(data);
                }
          }
    );
}*/

$("#residencyBtn").click(function(){
	$(".residencyData").show();
	residency.show('residency');
});

$("#industryBtn").click(function(){
	$(".industryBtn").show();
	industry.show();
})

$("#locationBtn").click(function(){
	$(".locationData").show();
	residency.show('location');
})

//保存按钮点击后收集相应的信息
$("#editResumeExperienceSave").click(function(){
	//标记是编辑还是添加
	var mark = "";
	var jObject ="";
	var cl = $(this).parents("form").prev().attr("class");
	if(cl == "delSkill"){
		jObject = $(this).parents("form").prev();
		mark = "editor";
	}
	//保存时首先将form移动到原来的地方
	$("#expFormWrap").append($("#editExperienceForm"));
	//获取工作经历相关数据
	var experienceData = getExperience();
	//保存之前验证工作经历
	var flag = verificationWorkExperienceData(experienceData);
	if(flag ==true){
		//将工作经历相关数据展示
		var d =  writeWorkExperienceHtml(experienceData);
		//工作经历展示的相关样式的控制
		workExperienceOperation(d);
		//获取form前面的元素，如果是dl就表示移动过form表单，是编辑，如果不是则是新增
		if(mark == "editor"){
			jObject.after(d);
			jObject.remove();
		}else{
			$(".workConData").append(d);
		}
	}else{
		return;
	}
	
})

//获取工作经历的数据
function getExperience(){
	var data = {
			company:$("#Company").val(),
			expStartDate:mini.get("#expStartDate").getFormValue(),
			expEndDate:mini.get("#expEndDate").getFormValue(),
			industryBtn:$("#industryHid").val(),
			roleName:$("#RoleName").val(),
			locationBtn:$("#locationHid").val(),
			companyTypeId:$("#CompanyTypeId").val(),
			companyTypeName:$("#CompanyTypeId option:selected").text(),
			responsibility:$("#Responsibility").val(),
			reportObject:$("#ReportObject").val(),
			subordinate:$("#Subordinate").val(),
			salary:$("#Salary").val(),
			currencyType:$("#CurrencyType").val(),
			currencyTypeName:$("#CurrencyType option:selected").text(),
			achievement:$("#Achievement").val(),
	}
	return data;
}

function checkEndTime(startTime,endTime){  
  var start=new Date(startTime.replace("-", "/").replace("-", "/"));  
  var end=new Date(endTime.replace("-", "/").replace("-", "/"));  
  if(end<start){  
      return true;  
  }  
  return false;  
}  

//验证工作经历的数据
function verificationWorkExperienceData(experienceData){
	var flag = true;
	if($.trim(experienceData.company) ==""){
		$("#companyError").html("<label for='Company' generated='true' class='error'>请输入公司名称</label>");
		flag = false;
	}else{
		$("#companyError").empty();
	}
	
	if($.trim(experienceData.expStartDate) =="" || $.trim(experienceData.expEndDate) ==""){
		$("#expDateError").html("请选择开始年份");
		flag = false;
	}else if(checkEndTime($.trim(experienceData.expStartDate),$.trim(experienceData.expEndDate))){
	  $("#expDateError").html("开始时间不能大于结束时间");
	  flag = false;
	}
	else{
		$("#expDateError").empty();
	}
	
	if($.trim(experienceData.roleName)==""){
		$("#roleError").html("<label for='RoleName' generated='true' class='error'>请输入职位名称</label>");
		flag = false;
	}else{
		$("#roleError").empty();
	}
	return flag;
}


//将工作经历的数据展示
function writeWorkExperienceHtml(experienceData){
	var d="<dl class='delSkill'>";
	d+="<dt class='record' value='"+experienceData.company+"'><span>"+experienceData.company+"</span><span style='float: right;'><a  class='workExperienceEditor'>编辑</a>&nbsp;<a class='del'>删除</a></span ></dt>" ;
	if($.trim(experienceData.expStartDate) !="" && $.trim(experienceData.expEndDate) !=""){
		d+="<dd class='expStartDate' value='"+experienceData.expStartDate+"'><span>开始时间:</span>&nbsp;&nbsp;&nbsp;"+experienceData.expStartDate+"</dd><dd class='expEndDate' value='"+experienceData.expEndDate+"'><span>结束时间:</span>&nbsp;&nbsp;&nbsp;"+experienceData.expEndDate+"</dd>";
	}
	if($.trim(experienceData.industryBtn) !="" && $.trim(experienceData.industryBtn) !="选择/修改"){
		d+="<dd class='industryBtn' value='"+experienceData.industryBtn+"'><span>行业类别：</span>&nbsp;&nbsp;&nbsp;"+experienceData.industryBtn+"</dd>";
	}else{
		d+="<dd class='industryBtn' value=' ' style='display:hidden'></dd>";
	}
	
	d+="<dd  class='roleName' value='"+experienceData.roleName+"' ><span>职位名称：</span>&nbsp;&nbsp;&nbsp;"+experienceData.roleName+"</dd>";
	
	if($.trim(experienceData.locationBtn)!="" && $.trim(experienceData.locationBtn)!="选择/修改"){
		d+="<dd class='locationBtn' value='"+experienceData.locationBtn+"'><span>工作地点：</span>&nbsp;&nbsp;&nbsp;"+experienceData.locationBtn+"</dd>";
	}else{
		d+="<dd class='locationBtn' style='display:none' value=''></dd>";
	}
	if($.trim(experienceData.companyTypeId)!=""){
		d+="<dd style='display:none;' class='companyTypeId' value='"+experienceData.companyTypeId+"'>"+experienceData.companyTypeId+"</dd>";
	}else{
		d+="<dd style='display:none;' class='companyTypeId' value=''></dd>"; 
	}
	if($.trim(experienceData.companyTypeName)!="" && $.trim(experienceData.companyTypeId)!=""){
		d+="<dd class='companyTypeName' value='"+experienceData.companyTypeName+"'><span>公司性质：</span>&nbsp;&nbsp;&nbsp;"+experienceData.companyTypeName+"</dd>";
	}else{
		d+="<dd style='display:none;' class='companyTypeName' value=''></dd>"; 
	}
	if($.trim(experienceData.responsibility)!=""){
		d+="<dd class='responsibility' value='"+experienceData.responsibility+"'><span>工作职责：</span>&nbsp;&nbsp;&nbsp;<div class='blockRight'><p> "+experienceData.responsibility.replace(/\n/g,"<br/>")+"</p></div></dd>";
	}else{
		d+="<dd style='display:none;' class='responsibility' value=''></dd>"; 
	}
	if($.trim(experienceData.reportObject)!=""){
		d+="<dd class='reportObject' value='"+experienceData.reportObject+"'><span>汇报对象：</span>&nbsp;&nbsp;&nbsp;"+experienceData.reportObject+"</dd>";
	}else{
		d+="<dd style='display:none;' class='reportObject' value=''></dd>"; 
	}
	if($.trim(experienceData.subordinate)!=""){
		var subordinate = experienceData.subordinate;
		if(isNaN(subordinate)){
			d+="<dd style='display:none;' class='subordinate' value=''></dd>";
		}else{
			d+="<dd class='subordinate' value='"+experienceData.subordinate+"'><span>下属人数：</span>&nbsp;&nbsp;&nbsp;"+experienceData.subordinate+"</dd>";
		}
	}else{
		d+="<dd style='display:none;' class='subordinate' value=''></dd>"; 
	}
	if($.trim(experienceData.currencyType)!=""){
		d+="<dd style='display:none;' class='currencyType' value='"+experienceData.currencyType+"'>&nbsp;&nbsp;&nbsp;"+experienceData.currencyType+"</dd>";
	}else{
		d+="<dd style='display:none;' class='currencyType' value=''></dd>"; 
	}
	if($.trim(experienceData.salary)!=""){
		var salary = experienceData.salary;
		if(isNaN(salary)){
			d+="<dd style='display:none;' class='salary' value=''></dd>"; 
		}else{
			d+="<dd class='salary' value='"+experienceData.salary+"'><span>职位薪水：</span>&nbsp;&nbsp;&nbsp;"+experienceData.salary+"</dd>";
		}
		
	}else{
		d+="<dd style='display:none;' class='salary' value=''></dd>"; 
	}
	if($.trim(experienceData.achievement)!=""){
		d+="<dd class='achievement' value='"+experienceData.achievement+"'><span>业绩描述：</span>&nbsp;&nbsp;&nbsp;<div class='blockRight'><p> "+experienceData.achievement.replace(/\n/g,"<br/>")+"</p></div></dd>";
	}else{
		d+="<dd style='display:none;' class='achievement' value=''></dd>"; 
	}
	d+="</dl>";
	return d;
}

//相关工作经历保存后的相关操作
function workExperienceOperation(d){
	$("#editExperienceForm").hide();
	$("#expAddBtn").show();
	$("#expDateError").empty();
	//清空表单
	$("#editExperienceForm")[0].reset();
	$("#industryClear").click();
	$("#locationClear").click();
	mini.get("#expStartDate").setValue("");
	mini.get("#expEndDate").setValue("");
	
}


//工作经历删除按钮的显示和隐藏
$(".record").live("mouseenter",function(){
	$(this).find(".f_r").show();
}).live("mouseleave",function(){
	$(".f_r").hide();
})

//工作经历的删除
$(".del").live("click",function(){
	$(this).parents(".delSkill").remove();
})

//技能的保存
$("#editResumeSkillSave").click(function(){
	var flag = true;
	var d="";
	//取值
	var skillData = getSkillData();
	//验证技能
	flag = verificationSkillData(skillData);
	if(flag ==true){
		//将技能数据展示
		d = writeSkillHtml(skillData);
		//技能的相关操作
		skillOperation(d);
	}else{
		return;
	}
})

//获得技能相关的数据
function getSkillData(){
	var skillData = {
			skill:$("#skillHid").val(),
			levelId:$("#skillLevelId").val(),
			levelName:$("#skillLevelId option:selected").text()
	}
	return skillData;
}

function verificationSkillData(skillData){
	var flag = true;
	if($.trim(skillData.skill) ==""){
		$("#skillError").html('<label for="skill" generated="true" class="error">请选择技能</label>');
		flag = false;
	}else{
		$("#skillError").empty();
	}
	
	if($.trim(skillData.levelName)=="" || $.trim(skillData.levelId)==""){
		$("#errorLevelId").html('<label class="error" for="LevelId" generated="true" style="display: inline;">请选择熟练程度</label>');
		flag = false;
	}else{
		$("#errorLevelId").empty();
	}
	return flag;
}

function writeSkillHtml(skillData){
	var d="<tr class='record delSkill'>" ;
	if($.trim(skillData.skill) !=""){
		d+="<td width='25%' class='skill'>"+skillData.skill+"</td>" ;
	}else{
		d+="<td width='25%' class='skill'></td>" ;
	}
	
	if($.trim(skillData.levelName)!="" && $.trim(skillData.levelId)!=""){
		d+="<td width='65%' class='levelName'>"+skillData.levelName+"</td>"+
	    "<td class='levelId' style='display:none;'>"+skillData.levelId+"</td>" ;
	}else{
		d+="<td class='levelName' style='display:none;></td>"+
	    "<td class='levelId' style='display:none;'></td>" ;
	}
	
		d+="<td ><span style='align:right;'><a class='del'>删除</a></span ></td> </tr>";
   return d;
}

function skillOperation(d){
	$("#skillData").append(d);
	$("#editSkillForm").hide();
	$("#btnAddResumeSkill").show();
	$("#skillError").empty();
	$('#editSkillForm')[0].reset();
	$("#skillClear").click();
}



$("#skillBtn").click(function(){
	skill.show();
})


//验证一般的input,文本框
$(".fl").blur(function(){
	var value = $(this).val();
	if($.trim(value)!=""){
		$(this).next().empty();
	}
})

//验证select为非空
$(".selectEvent option").click(function(){ 
	var value = $(this).val();
	if($.trim(value) !=""){
		$(this).parent().next().empty();
	}
})

$("#schoolBtn").click(function(){
	$(".schoolData").show();
	resumeDataOperate.show("school");
})


$("#majorBtn").click(function(){
	$(".majorData").show();
	resumeDataOperate.show("major");
})

//教育经历的保存
$("#editResumeEducationSave").click(function(){
    //标记是编辑还是新增
	var mark = "";
	var qObject = "";
	var dataTip = $(this).parents("form").prev().attr("data-tip");
	if(dataTip=="education"){
		mark = "editor";
		qObject = $(this).parents("form").prev();
	}
	//执行学历添加操作时要把form表单放回原处
	$("#eduFormWrap").append($("#editEducationForm"));
	var flag = true;
	var d = "";
	//获得要保存的数据
	var educationData = getEducationData();
	//对数据进行验证
	flag = verificationData(educationData);
	if(flag == true){
		//对数据进行写
		d = writeEducationHtml(educationData);
		if(mark=="editor"){
			 qObject.after(d);
			 qObject.remove();
		}else{
			$(".educationExperience").append(d);
		}
		
	}else{
		return;
	}
	//保存后的相关操作
	educationOperation();
})

function getEducationData(){
	var data = {
			startYearMonth:mini.get("startYearMonth").getFormValue().substr(0,7),
			endYearMonth:mini.get("endYearMonth").getFormValue().substr(0,7),
			degreeId:$("#DegreeId").val(),
			degreeName:$("#DegreeId option:selected").text(),
			eduType:$("#eduType").val(),
			eduTypeName:$("#eduType option:selected").text(),
			hidschoolName:$("#schoolHid").val(),
			schoolName:$("#SchoolName").val(),
			hidMajor:$("#majorHid").val(),
			majorName:$("#MajorName").val(),
	}
	return data;
}

function compare(start,end){
  var flag = false ;
  var start = start ;
  var end = end ;
  var startYear = parseInt(start.substr(0,4));
  var endYear = parseInt(end.substr(0,4));
  var startMonth = parseInt(start.substr(5,7));
  var endMonth = parseInt(end.substr(5,7));
  if(startYear == endYear && endMonth < startMonth){
    flag = true ;
  }
  if(startYear > endYear){
    flag = true ;
  }
  
  return flag ;
}



function verificationData(educationData){
	var flag = true;
	if($.trim(educationData.startYearMonth)=="" || $.trim(educationData.endYearMonth)==""){
		$("#eduDateError").html('<span class="red" id="eduDateError">请选择开始年份</span>');
		flag = false;
	}else if(compare($.trim(educationData.startYearMonth),$.trim(educationData.endYearMonth))){
      $("#eduDateError").html("开始时间不能大于结束时间");
      flag = false;
    }
	else{
		$("#eduDateError").empty();
	}
	
	if($.trim(educationData.degreeId) =="" || $.trim(educationData.degreeName)==""){
		$("#DegreeIdError").html('<label for="DegreeId" generated="true" class="error">请选择学历</label>');
		flag =false;
	}else{
		$("#DegreeIdError").empty();
	}
	
	if($.trim(educationData.hidschoolName) =="" && $.trim(educationData.schoolName)=="" ){
		$("#eduSchoolError").html('<span class="red" id="eduSchoolError">请选择毕业院校或输入学校名称</span>');
		flag = false;
	}else{
		$("#eduSchoolError").empty();
	}
	
	if($.trim(educationData.hidMajor) =="" && $.trim(educationData.majorName)==""){
		$("#eduMajorError").html('<span class="red" id="eduMajorError">请选择专业或输入专业名称</span>');
		flag = false;
	}else{
		$("#eduMajorError").empty();
	}
	
	return flag;
}

//将数据展示
function writeEducationHtml(educationData){
	var d = "<ul class='delSkill record' data-tip='education'>";
	if($.trim(educationData.startYearMonth)!="" && $.trim(educationData.endYearMonth)!=""){
		d+="<li>"+educationData.startYearMonth+" 至 "+educationData.endYearMonth+"</li>" +
		"<li style='display:none;' class='startYearMonth'>"+educationData.startYearMonth+"</li>" +
		"<li style='display:none;' class='endYearMonth'>"+educationData.endYearMonth+"</li>" ;
	}else{
		d+="<li style='display:none;' class='startYearMonth'></li>" +
		"<li style='display:none;' class='endYearMonth'></li>" ;
	}
	if($.trim(educationData.degreeId) !="" && $.trim(educationData.degreeName)!=""){
		d+="<li class='degreeName'>"+educationData.degreeName+"</li>" +
		"<li class='degreeId' style='display:none;'>"+educationData.degreeId+"</li>" ;
	}else{
		d+="<li class='degreeId' style='display:none;'></li>" +
			"<li class='degreeName' style='display:none;'></li>" ;
	}	
	
	if($.trim(educationData.eduType) !="" && $.trim(educationData.eduTypeName)!=""){
      d+="<li class='eduTypeName'>"+educationData.eduTypeName+"</li>" +
      "<li class='eduType' style='display:none;'>"+educationData.eduType+"</li>" ;
  }else{
      d+="<li class='degreeId' style='display:none;'></li>" +
          "<li class='degreeName' style='display:none;'></li>" ;
  }   
			
	if($.trim(educationData.schoolName) !=""){
		d+="<li class='schoolName'>"+educationData.schoolName+"</li>" ;
	}else{
		d+="<li  class='schoolName'>"+educationData.hidschoolName+"</li>";
	}
	
	if($.trim(educationData.majorName) !=""){
		d+="<li class='majorName'>"+educationData.majorName+"</li>" ;
	}else{
		d+="<li class='majorName'>"+educationData.hidMajor+"</li>"
	}
	d+= "<li style='float:right;'><a id='editEducation'>编辑</a><a class='del'>删除</a></li>";
	d+="</ul>";
	return d;
}

//学历信息的保存后的相关操作
function educationOperation(){
	//显示添加按钮
	$("#eduAddBtn").show();
	//清空表单值
	$("#editEducationForm")[0].reset();
	mini.get("#startYearMonth").setValue("");
	mini.get("#endYearMonth").setValue("");
	$("#schoolClear").click();
	$("#majorClear").click();
	$("#editEducationForm").hide();
}

//执行学历添加操作时要把form表单放回原处
/*$("#eduAddBtn").click(function(){
	$("#eduFormWrap").append($("#editEducationForm"));
})*/


//语言保存显示
$("#editResumeLanguageSave").click(function(){
	//收集语言的数据
	var d = "";
	var flag = true;
	var languageData = getLanguageData();
	//验证
	flag = verificationLanguageData(languageData);
	if(flag == true){
		d = writeLanguageHtml(languageData);
	}else{
		return;
	}
	languageOperation(d);
})

//获取语言的数据
function getLanguageData(){
	var data = {
			languageId:$("#LanguageId").val(),
			languageName:$("#LanguageId option:selected").text(),
			languageLevelId:$("#languageLevelId").val(),
			languageLevelName:$("#languageLevelId option:selected").text(),
			oralLevelId:$("#OralLevelId").val(),
			oralLevelName:$("#OralLevelId option:selected").text()
	}
	return data;
}
//验证语言的数据
function verificationLanguageData(languageData){
	var flag = true;
	if($.trim(languageData.languageId)=="" || $.trim(languageData.languageName)==""){
		$("#languageError").html('<label class="error" for="LanguageId" generated="true">请选择语言</label>');
		flag = false;
	}else{
		$("#languageError").empty();
	}
	return flag;
}
//点击保存后将语言数据显示
function writeLanguageHtml(languageData){
	var d = "<ul class='delSkill record'>" +
	  "<li style='float:right;'>" +
	    "<a class='del'>删除</a>" +
	  "</li>" ;
	if($.trim(languageData.languageId)!="" && $.trim(languageData.languageName)!=""){
	  d+="<li class='languageName'>"+languageData.languageName+"</li>" +
	  "<li class='languageId' style='display:none;'>"+languageData.languageId+"</li>" ;
	}else{
		 d+="<li class='languageName' style='display:none;'></li>" +
		 "<li class='languageId' style='display:none;'></li>" ;
	}
	if($.trim(languageData.languageLevelName)!="" && $.trim(languageData.languageLevelId)!=""){
	    d+="<li>等&#12288;&#12288;级:&#12288;&#12288;"+languageData.languageLevelName+"</li>"+
	   "<li style='display:none;' class='languageLevelName'>"+languageData.languageLevelName+"</li>"+
	    "<li style='display:none;' class='languageLevelId'>"+languageData.languageLevelId+"</li>";
	}else{
		 d+="<li style='display:none;' class='languageLevelName'></li>"+
		"<li style='display:none;' class='languageLevelId'></li>";
	}
	
	if($.trim(languageData.oralLevelName)!="" && $.trim(languageData.oralLevelId)!="" ){
		d+="<li>口语水平：&#12288;&#12288;"+languageData.oralLevelName+"</li>" +
		"<li style='display:none;' class='oralLevelName'>"+languageData.oralLevelName+"</li>" +
		"<li style='display:none;' class='oralLevelId'>"+languageData.oralLevelId+"</li>";
	}else{
		d+="<li style='display:none;' class='oralLevelName'></li>" +
		"<li style='display:none;' class='oralLevelId'></li>";
	}
	d+="</ul>";
	return d;
}

function languageOperation(d){
	$(".languageList").append(d);
	//显示添加按钮
	$("#btnAddResumeLanguage").show();
	//清空表单值
	$("#editLanguageForm")[0].reset();
	$("#editLanguageForm").hide();
}

//关闭弹框
$(".close").click(function(){
	$(this).parents(".pData").hide();
	$(this).parents(".cData").hide();
})

//清除button所选的数据
$(".fltl").click(function(){
	var mark = $(this).attr("id");
    mark = mark.substring(0,mark.length-5);
    $("#"+mark+"Btn").val("选择/修改");
    $("#"+mark+"Hid").val("");
	$(this).hide();
	
})
//获取工作经历保存后的信息
function getWorkExperienceData(){
	var company="";
	var expStartDate="";
	var expEndDate="";
	var industryBtn="";
	var roleName="";
	var locationBtn="";
	var companyTypeId="";
	var companyTypeName="";
	var responsibility="";
	var reportObject="";
	var subordinate="";
	var salary="";
	var currencyType="";
	var currencyTypeName="";
	var achievement="";
	
	var experience = document.getElementById("workConData");
	var dl = experience.childNodes;
	for(var i = 0;i<dl.length;i++){
		var dd = dl.item(i).childNodes;
		for(var j=0;j<dd.length;j++){
			var name= dd.item(j).getAttribute("class");
			var value = dd.item(j).getAttribute("value");
			switch(name){
				case "record":
					company+= value+",";
					break;
				case "expStartDate":
					expStartDate+= value+",";
					break;
				case "expEndDate":
					expEndDate +=value+",";
					break;
				case "industryBtn":
					industryBtn +=value+",";
					break;
				case "roleName":
					roleName +=value+",";
					break;
				case "locationBtn":
					locationBtn +=value+",";
					break;
				case "companyTypeId":
					companyTypeId +=value+",";
					break;
				case "companyTypeName":
					companyTypeName +=value+",";
					break;
				case "responsibility":
					responsibility +=value+",";
					break;
				case "reportObject":
					reportObject +=value+",";
					break;
				case "subordinate":
					subordinate +=value+",";
					break;
				case "salary":
					salary +=value+",";
					break;
				case "currencyType":
					currencyType +=value+",";
					break;
				case "currencyTypeName":
					currencyTypeName +=value+",";
					break;
				case "achievement":
					achievement +=value+",";
					break;
				default:
					break;
			}
		}
	}
	var experienceData = {
		 company:company,
		 expStartDate:expStartDate,
		 expEndDate:expEndDate,
		 industryBtn:industryBtn,
		 roleName:roleName,
		 locationBtn:locationBtn ,
		 companyTypeId:companyTypeId,
		 companyTypeName:companyTypeName,
		 responsibility:responsibility,
		 reportObject:reportObject,
		 subordinate:subordinate,
		 salary: salary,
		 currencyType:currencyType,
		 currencyTypeName:currencyTypeName,
		 achievement:achievement
	}
	return experienceData;
}

//获取教育经历保存后的数据
function getEducationSaveData(){
	var eductionData=document.getElementById('educationExperience');
	var num=eductionData.childNodes;
	var startYearMonth="";
	var endYearMonth=""; 
	var degreeId="";
	var eduType="";
	var eduTypeName="";
	var schoolName="";
	var majorName="";
	var degreeName="";
	for(var i =0;i<num.length;i++){
		var ul = num.item(i);
		var lis=ul.childNodes;
		for(var j=0;j<lis.length;j++){
			var name = lis.item(j).getAttribute("class");
			switch(name){
			    case "startYearMonth":
			    	startYearMonth +=lis.item(j).innerHTML+",";
			    	break;
			    case "endYearMonth":
			    	endYearMonth +=lis.item(j).innerHTML+",";
			    	break;
			    case "degreeId":
			    	degreeId +=lis.item(j).innerHTML+",";
			    	break;
			    case "eduType":
			      eduType +=lis.item(j).innerHTML+",";
                  break;
			    case "eduTypeName":
			      eduTypeName +=lis.item(j).innerHTML+",";
                  break;
			    case "schoolName":
			    	schoolName +=lis.item(j).innerHTML+",";
			    	break;
			    case "majorName":
			    	majorName +=lis.item(j).innerHTML+",";
			    	break;
			    case "degreeName":
			    	degreeName +=lis.item(j).innerHTML+",";
			    	break;
			    default:
			    	break;
			}
		}  
	}
	var educationData = {
		startYearMonth:startYearMonth,	
		endYearMonth:endYearMonth,
		degreeId:degreeId,
	    degreeName:degreeName,
	    eduType:eduType,
        eduTypeName:eduTypeName,
	    schoolName:schoolName,
	    majorName:majorName
	}
	return educationData;
}

//获取语言保存后的信息
function getLanguageSaveData(){
	var languageId="";
	var languageLevelId ="";
	var oralLevelId="";
	
	var languageName = "";
	var languageLevelName="";
	var oralLevelName="";
	var languageList=document.getElementById('languageList');
	var num = languageList.childNodes;
	for(var i =0;i<num.length;i++){
		var ul = num.item(i);
		var lis=ul.childNodes;
		for(var j=0;j<lis.length;j++){  
			var name = lis.item(j).getAttribute("class");
			switch(name){
			    case "languageId":
			    	languageId +=lis.item(j).innerHTML+",";
			    	break;
			    case "languageLevelId":
			    	languageLevelId +=lis.item(j).innerHTML+","; 
			    	break;
			    case "oralLevelId":
			    	oralLevelId +=lis.item(j).innerHTML+",";
			    	break;
			    	
			    case "languageLevelName":
			    	languageLevelName +=lis.item(j).innerHTML+",";
			    	break;
			    case "languageName":
			    	languageName +=lis.item(j).innerHTML+",";
			    	break;
			    case "oralLevelName":
			    	oralLevelName +=lis.item(j).innerHTML+",";
			    	break;
			    default:
			    	break;
			}
		}  
	}
	
	var languageData = {
		languageId:languageId,
		languageLevelId:languageLevelId,
	    oralLevelId:oralLevelId,
	    languageName :languageName,
	    languageLevelName :languageLevelName,
	    oralLevelName :oralLevelName
	};
	return languageData;
}
//获取技能保存后的信息
function getSkillSaveData(){
	var skill="";
	var levelId="";
	var levelName="";
	var skillTaData=document.getElementById('skillData');
	var trs=skillTaData.getElementsByTagName("tr"); 
	for(var i =0;i<trs.length;i++){
		var tr = trs.item(i);
		var tds = tr.getElementsByTagName("td"); 
		for(var j=0;j<tds.length;j++){
			var name = tds.item(j).getAttribute("class");
			switch(name){
			    case "skill":
			    	skill +=tds.item(j).innerHTML+",";
			    	break;
			    case "levelId":
			    	levelId +=tds.item(j).innerHTML+",";
			    	break;
			    case "levelName":
			    	levelName +=tds.item(j).innerHTML+",";
			    	break;
			    default:
			    	break;
			}
		}  
	}
	var skillSaveData = {
			skill:skill,
			levelId:levelId,
			levelName:levelName
	}
	return skillSaveData;
	
}

//获取简历基本信息
function getBasicInfoSaveData(){
    var isLock = 0 ;
    if($("#isLock").prop('checked') == true ){
      isLock = 1 ;
    }

  
	var basicInfoData = {
			id:$("#hiddenData").val(),
			name:$("#bName").text(),
			applyPostName:$("#applyPostName").text(),
			nationality : $("#bNationality").text(),
			nationalityName : $("#bNationalityName").text(),
			sex : $("#bSex").text(),
			sexName:$("bSexName").text(),
			birthday: $("#bBrith").text(),
			maritalStatus:$("#bMarriage").text(),
			maritalName:$("bMarriageName").text(),
			residency:$("#bResidency").text(),
			workYears:$("#bWorkYears").text(),
			phoneReseave:$("#bAlternativePhone").text(),
			phone:$("#bPhone").text(),
			email:$("#bEmail").text(),
			address:$("#bAddress").text(),
			nation:$("#bEthnic").text(),
			nationName :$("#nationName").text(),
			certificateType : $("#certificateType").text(),
			certificateTypeName : $("#certificateTypeName").text(),
			idNumber:$("#bIDNumber").text(),
			idAddress:$("#bIDAddress").text(),	
			isLock:isLock,
			positionId:$("#positionId").val(),
	}
	return basicInfoData;
}

/*//获取简历相关信息主要是（textArea的数据）
function getResumeInfoSaveData(){
	var  resumeInfoSaveData = {
		//背景信息
		selfEvaluation: $("#viewSelfEvaluation").text(),
		//求职意向
		careerObject: $("#viewCareerObject").text(),
		//详细工作经历
		experienceDetail:$("#viewExperienceDetail").text(),
	    //项目经验
		projectExperience:$("#viewProjectExperience").text(),
		//培训信息
		trainInfo:$("#viewTrainingInfo").text(),
		 //语言描述  
	    languageSkill:$("#viewLanguageSkill").text(),
	    //奖励信息
	    awardInfo :$("#viewRewards").text(),
	    //其他技能信息 
	    skillText:$("#viewSkillText").text(),
		//证书信息
		certificateInfo:$("#viewCertification").text(),
		//爱好信息
		hobbyInfo:$("#viewHobbies").text()
	}
	return resumeInfoSaveData;
}*/

//获取简历相关信息主要是（textArea的数据）
function getResumeInfoSaveData(){
	var  resumeInfoSaveData = {
		//背景信息
		selfEvaluation: $("#editSelfEvaluation").val(),
		//求职意向
		careerObject: $("#editCareerObject").val(),
		//详细工作经历
		experienceDetail:$("#editExperienceDetail").val(),
	    //项目经验
		projectExperience:$("#editProjectExperience").val(),
		//培训信息
		trainInfo:$("#editTrainingInfo").val(),
		 //语言描述  
	    languageSkill:$("#editLanguageSkill").val(),
	    //奖励信息
	    awardInfo :$("#editRewards").val(),
	    //其他技能信息 
	    skillText:$("#editSkillText").val(),
		//证书信息
		certificateInfo:$("#editCertification").val(),
		//爱好信息
		hobbyInfo:$("#editHobbies").val()
	}
	return resumeInfoSaveData;
}


//所有数据的保存
function getAllData(){
	var basicInfoData = getBasicInfoSaveData();
	var experienceSaveData = getWorkExperienceData();
	var educationSaveData = getEducationSaveData();
	var languageSaveData = getLanguageSaveData();
	var skillSaveData = getSkillSaveData();
	var resumeInfoSaveData = getResumeInfoSaveData();
	var allData={
		    //基本信息数据	
			id:basicInfoData.id,
			name:basicInfoData.name,
			applyPostName:basicInfoData.applyPostName,
			nationality : basicInfoData.nationality,
			nationalityName : basicInfoData.nationalityName,
			sex : basicInfoData.sex,
			sexName:basicInfoData.sexName,
			birthday:basicInfoData.birthday,
			maritalStatus:basicInfoData.maritalStatus,
			maritalName:basicInfoData.maritalName,
			residence:basicInfoData.residency,
			workYears:basicInfoData.workYears,
			phoneReseave:basicInfoData.phoneReseave,
			phone:basicInfoData.phone,
			email:basicInfoData.email,
			address:basicInfoData.address,
			nation:basicInfoData.nation,
			nationName :basicInfoData.nationName,
			certificateType : basicInfoData.certificateType,
		    certificateTypeName : basicInfoData.certificateTypeName,
			idNumber:basicInfoData.idNumber,
			idAddress:basicInfoData.idAddress,
			isLock:basicInfoData.isLock,
			positionId:basicInfoData.positionId,
			//背景信息
			selfEvaluation: resumeInfoSaveData.selfEvaluation,
			//求职意向
			careerObject: resumeInfoSaveData.careerObject,
			//工作经历
			companys:experienceSaveData.company,
			expStartDates:experienceSaveData.expStartDate ,
			expEndDates:experienceSaveData.expEndDate ,
			industries:experienceSaveData.industryBtn ,
			roleNames:experienceSaveData.roleName ,
			locations:experienceSaveData.locationBtn ,
			companyTypeIds:experienceSaveData.companyTypeId ,
			companyTypeName:experienceSaveData.companyTypeName ,
			responsibilitys:experienceSaveData.responsibility ,
			reportObjects:experienceSaveData.reportObject ,
			subordinates:experienceSaveData.subordinate ,
			salary:experienceSaveData.salary ,
			currencyTypes:experienceSaveData.currencyType ,
			currencyTypeName:experienceSaveData.currencyTypeName ,
			achievements:experienceSaveData.achievement ,
			//详细工作经历
			experienceDetail:resumeInfoSaveData.experienceDetail,
			//项目经验
			projectExperience:resumeInfoSaveData.projectExperience,
			//教育经历
			startYearMonth:educationSaveData.startYearMonth ,
			endYearMonth:educationSaveData.endYearMonth ,
			degreeId:educationSaveData.degreeId,
			degreeName:educationSaveData.degreeId ,
			eduType:educationSaveData.eduType,
			eduTypeName:educationSaveData.eduTypeName,
			graduationSchool:educationSaveData.schoolName ,
			professional:educationSaveData.majorName ,
			degreeNameShow:educationSaveData.degreeName,
			//培训信息
			trainInfo:resumeInfoSaveData.trainInfo,
			//语言信息
			languageName:languageSaveData.languageId,
			languageLevel:languageSaveData.languageLevelId,
			oralLevel:languageSaveData.oralLevelId,
			
			language:languageSaveData.languageName,
			languageLevelName:languageSaveData.languageLevelName,
			oralLevelName:languageSaveData.oralLevelName,
		    //语言描述  
		    languageSkill:resumeInfoSaveData.languageSkill,
		    //奖励信息
		    awardInfo :resumeInfoSaveData.awardInfo,
		    //技能
		    skillInfo:skillSaveData.skill,
		    rank:skillSaveData.levelId,
		    rankName:skillSaveData.levelName,
			//其他技能信息 
		    skillText:resumeInfoSaveData.skillText,
			//证书信息
			certificateInfo:resumeInfoSaveData.certificateInfo,
			//爱好信息
			hobbyInfo:resumeInfoSaveData.hobbyInfo
	}
	return allData;
}

//点击保存按钮，保存全文信息
$("#btnSaveResume").click(function(){
	// 人员简历
	if($.trim($("#bName").text())!="" && $.trim($("#bEmail").text()) !="" && $.trim($("#bPhone").text())!=""&& $.trim($("#applyPostName").text())!=""){
		resumeSave();
	}else{
		alert("请完成表格的必填数据");
	}
	
})

function resumeSave() {
        
		$.ajax({
			type : "post",
			dataType : "json",
			data : {jsonData:JSON.stringify(getAllData())},
			url : basePath + "/resume/resumeSave",
			dataType : 'json', 
			success:function(data){
		       window.location.href="/recruit/candidateController/getResumeList/"+data.msg;
		      
			},
			error: function() {
				alert("保存失败!");
			}
		});
	}


//简历的编辑
var id =  $("#hiddenData").val();
if($.trim(id) !=""){
	$.ajax({
		type : "post",
		dataType : "json",
		url : basePath + "/resume/editAddResume/"+id,
		contentType : "application/json;charset=UTF-8",
		success:function(data){
			initAddResume(data);
			showResumeBasicInfoData(data);
			showResumeWorkExperience(data);
			showEducationExperience(data);
			showLanguageInfo(data);
			showSkillInfo(data);
		},
		error: function(data) {
			
		}
	});
}

//初始化页面信息
function initAddResume(data){
	//简历的信息的初始化
	basicInfoInit(data);
	//工作经历
	if(data.workExperience.length>0){
		$("#showWorkItem").click();
	}
	//教育经历
	if(data.educationExperience.length>0){
		$("#showEduItem").click();
	}
	//技能
	if(data.skill.length>0){
		$("#showSkillItem").click();
	}
	//语言
	if(data.resumeLanguage.length>0){
		$("#showLangItem").click();
	}
}

//简历的信息的初始化
function basicInfoInit(data){
	//背景概要
	if($.trim(data.selfEvaluation) !=""){
		$("#showSelfEvaluationItem").click();
		$("#editSelfEvaluation").val(data.selfEvaluation);
		$("#SelfEvaluationSave").click();
	}
	//求职意向
	if($.trim(data.careerObject)!=""){
		$("#showCareerObjectItem").click();
		$("#editCareerObject").val(data.careerObject);
		$("#careerObjectSave").click();
	}
	//奖励信息
	if($.trim(data.awardInfo) !=""){
		$("#showRewardsItem").click();
		$("#editRewards").val(data.awardInfo);
		$("#rewardsSave").click();
	}
	//证书信息
	if($.trim(data.certificateInfo) !=""){
	    $("#showCertificationItem").click();
	    $("#editCertification").val(data.certificateInfo);
	    $("#certificationSave").click();
	}
	//详细工作经历
	if($.trim(data.experienceDetail) !=""){
		$("#showWorkDetailsItem").click();
		$("#editExperienceDetail").val(data.experienceDetail);
		$("#experienceDetailSave").click();
		
	}
	//爱好信息
	if($.trim(data.hobbyInfo) !=""){
		$("#showHobbiesItem").click();
		$("#editHobbies").val(data.hobbyInfo);
		$("#hobbiesSave").click();
	}
	//语言描述信息
	if($.trim(data.languageSkill) !=""){
		$("#showLanguageSkillItem").click();
		$("#editLanguageSkill").val(data.languageSkill);
		$("#languageSkillSave").click();
		
	}
	//项目经验
	if($.trim(data.projectExperience) !=""){
		$("#showProjectExperienceItem").click();
		$("#editProjectExperience").val(data.projectExperience);
		$("#projectExperienceSave").click();
	}
	//其他技能信息
	if($.trim(data.skillText) !=""){
		$("#showSkillTextItem").click();
		$("#editSkillText").val(data.skillText);
		$("#skillTextSave").click();
		
	}
	//培训信息
	if($.trim(data.trainInfo) !=""){
		$("#showTrainingInfoItem").click();
		$("#editTrainingInfo").val(data.trainInfo);
		$("#trainingInfoSave").click();
	}
}

//基本信息的编辑
function showResumeBasicInfoData(data){
	var basicInfoData = getBasicInfoData();
	basicInfoData.name = data.name;
	basicInfoData.sex= data.sex;//需要加表示性别的字段
	basicInfoData.sexName=data.sexName;
	basicInfoData.brithday = data.birthday;
	basicInfoData.marriage = data.maritalStatus;
	basicInfoData.marriageName = data.maritalName;
	basicInfoData.residency = data.residence;
	basicInfoData.workYears = data.workYears;
	basicInfoData.alternativePhone = data.phoneReseave;
	basicInfoData.phone = data.phone;
	basicInfoData.email = data.email;
	basicInfoData.address = data.address;
	basicInfoData.ethnic = data.nation;
	basicInfoData.IDNumber = data.idNumber;
	basicInfoData.IDAddress = data.idAddress;
	var d = writeBasicInfoHtml(basicInfoData);
	basicinfoOperation(d);
}

//工作经历数据的编辑显示
function showResumeWorkExperience(data){
	var experience = getExperience();
	for(var i=0;i<data.workExperience.length;i++){
		experience.id = data.workExperience[i].id;
		experience.company = data.workExperience[i].companyName;
		if($.trim(data.workExperience[i].jobStartDate)!=""){
			experience.expStartDate =data.workExperience[i].jobStartDate.substring(0,11);
			experience.expEndDate =data.workExperience[i].jobEndDate.substring(0,11);
		}
		experience.industryBtn =data.workExperience[i].industry;
		experience.roleName =data.workExperience[i].positionName;
		experience.locationBtn =data.workExperience[i].workplace;
		experience.companyTypeId =data.workExperience[i].companyNature;
		experience.companyTypeName =data.workExperience[i].companyNatureName;
		experience.responsibility =data.workExperience[i].jobDuty;
		experience.reportObject =data.workExperience[i].debriefer;
		experience.subordinate =data.workExperience[i].subordinate;
		experience.salary = data.workExperience[i].salary
		experience.currencyType =data.workExperience[i].currency;
		experience.currencyTypeName =data.workExperience[i].currencyTypeName;
		experience.achievement = data.workExperience[i].workPerformace;
		
		var d =  writeWorkExperienceHtml(experience);
		//工作经历展示的相关样式的控制
		workExperienceOperation(d);
		$(".workConData").append(d);
	}
}

//学历信息的编辑显示
function showEducationExperience(data){
	var educationExperience = getEducationData();
	for(var i=0;i<data.educationExperience.length;i++){
		if($.trim(data.educationExperience[i].eduStartDate)!=""){
			educationExperience.startYearMonth = data.educationExperience[i].eduStartDate.substring(0,11);
			educationExperience.endYearMonth = data.educationExperience[i].eduEndDate.substring(0,11);
		}
		educationExperience.degreeId = data.educationExperience[i].education;
		educationExperience.degreeName = data.educationExperience[i].educationName;
		educationExperience.eduType = data.educationExperience[i].eduType;
	    educationExperience.eduTypeName = data.educationExperience[i].eduTypeName;
		educationExperience.schoolName = data.educationExperience[i].schoolName;
		educationExperience.majorName = data.educationExperience[i].major;
		var d = writeEducationHtml(educationExperience);
		//展示后的相关操作的控制
		educationOperation();
		$(".educationExperience").append(d);
	}
}

//语言描述信息
function showLanguageInfo(data){
	var languageData =  getLanguageData();
	for(var i=0;i<data.resumeLanguage.length;i++){
		languageData.languageId=data.resumeLanguage[i].languageName;
		languageData.languageName=data.resumeLanguage[i].name;
		languageData.languageLevelId=data.resumeLanguage[i].languageLevelId;
		languageData.languageLevelName=data.resumeLanguage[i].languageLevelName;
		languageData.oralLevelId=data.resumeLanguage[i].oralLevel;
		languageData.oralLevelName=data.resumeLanguage[i].oralLevelName;
		var d = writeLanguageHtml(languageData);
		languageOperation(d);
	}
	
}
//技能信息
function showSkillInfo(data){
	for(var i=0;i<data.skill.length;i++){
		var skillData = getSkillData();
		skillData.skill = data.skill[i].skill;
		skillData.levelId = data.skill[i].rank;
		skillData.levelName = data.skill[i].rankName;
		d = writeSkillHtml(skillData);
		//技能的相关操作
		skillOperation(d);
	}
}

//基本信息表单的验证
$("#basicInforForm").validator({
	theme : "simple_right",
	msgClass : "n-right ",
    stopOnError: false,
    timely: 1,
    msgStyle: "margin-left:-5px; margin-top:20px;",
    fields: {
        '#Email': 'required;email;',
        '#Name':'required;',
        '#WorkYears':'range[0~99];',
        "#Phone":'required;'
        
    }
});

//基本信息的再次编辑的功能
$("#btnEditBasicInfo").click(function(){
	var basicInfoData = getBasicInfoSaveData();
	$("#basicinfoData").empty();
	$(".basicinfoShow").hide();
	basicInfoEdit(basicInfoData);
	
})
//编辑基本信息收集数据
function basicInfoEdit(basicInfoData){
    $("#Name").val(basicInfoData.name);
    $("#Sex").find("option[value='"+basicInfoData.sex+"']").attr("selected",true);
    mini.get("#brithday").setValue(basicInfoData.birthday);
    $("#Marriage").find("option[value='"+basicInfoData.maritalStatus+"']").attr("selected",true);
	$("#residencyHid").val(basicInfoData.residency);
	$("#WorkYears").val(basicInfoData.workYears);
	$("#AlternativePhone").val(basicInfoData.phoneReseave);
	$("#Phone").val(basicInfoData.phone);
	$("#Email").val(basicInfoData.email);
	$("#Address").val(basicInfoData.address);
	$("#Ethnic").val(basicInfoData.nation);
	$("#IDNumber").val(basicInfoData.idNumber);
	$("#IDAddress").val(basicInfoData.idAddress);
}

//工作经历再次编辑的功能
$(".workExperienceEditor").live('click',function(){
	//数据的编辑
	var childs = $(this).parents("dl").find("dd");
	var company = $(this).parents("dt").attr("value");
	editWorkExperience(company,childs);
	$("#editExperienceForm").show();
	$(this).parents("dl").after($("#editExperienceForm"));
	
});
//编辑工作经历
function editWorkExperience(company,object){
	$("#Company").val(company);
	for(var i=0;i<object.length;i++){
		var cl = object[i].getAttribute("class")
		var val = object[i].getAttribute("value")
		switch(cl){
			case "expStartDate":
				mini.get("#expStartDate").setValue(val);
				break;
			case "expEndDate":
				mini.get("#expEndDate").setValue(val);
				break;
			case "industryBtn":
				$("#industryBtn").val(val);
				$("#industryHid").val(val);
				break;
			case "roleName":
				$("#RoleName").val(val);
				break;
			case "locationBtn":
				$("#locationHid").val(val);
				$("#locationBtn").val(val);
				break;
			case "companyTypeId":
				$("#CompanyTypeId").find("option[value='"+val+"']").attr("selected",true);
				break;
			case "responsibility":
				$("#Responsibility").val(val);
				break;
			case "reportObject":
				$("#ReportObject").val(val);
				break;
			case "subordinate":
				$("#Subordinate").val(val);
				break;
			case "salary":
				$("#Salary").val(val);
				break;
			case "currencyType":
				$("#CurrencyType").find("option[value='"+val+"']").attr("selected",true);
				break;
			case "achievement":
				$("#Achievement").val(val);
				break;
			default:
				break;
		}
	}
	
}


//教育经历的编辑功能
$("#editEducation").live("click",function(){
	//取得编辑数据
	var childs = $(this).parents("ul").find("li");
	editEducationExperience(childs);
	$("#editEducationForm").show();
	$(this).parents("ul").after($("#editEducationForm"));
})

function editEducationExperience(object){
	for(var i=0;i<object.length;i++){
		var cl = object[i].getAttribute("class");
		var val = object[i].innerHTML;
		switch(cl){
		    case "startYearMonth":
		    	mini.get("#startYearMonth").setValue(val);
		    	break;
		    case "endYearMonth":
		    	mini.get("#endYearMonth").setValue(val);
		    	break;
		    case "degreeId":
		    	$("#DegreeId").find("option[value='"+val+"']").attr("selected",true);
		    	break;
		    case "schoolName":
		    	$("#schoolHid").val(val);
		    	$("#SchoolName").val(val);
				$("#schoolBtn").val(val);
		    	break;
		    case "majorName":
		    	$("#majorHid").val(val);
		    	$("#majorBtn").val(val);
				$("#MajorName").val(val);
		    	break;
		    default:
		    	break;
		}
	}
} 
	
//简历的预览	
$("#btnShowResume").click(function(){
	var d = getAllData();
	mini.open({
      url: basePath + "/webpage/com/csot/resume/resumePreview.jsp",
      title: "编辑员工", width: 1000, height: 700,
      onload: function () {
          var iframe = this.getIFrameEl();
          iframe.contentWindow.SetData(d);
          
      },
      ondestroy: function (action) {
      }
    });
	
})

function onDrawDate(e) {
  var date = e.date;
  var d = new Date();

  if (date.getTime() >= d.getTime()) {
      e.allowSelect = false;
  }
}

function onBrithDrawDate(e) {
  var date = e.date;
  var d = new Date();
  var y = d.getFullYear()-18;
  var m = d.getMonth();
  var d = d.getDate();
  var formatnowdate = y+'-'+m+'-'+d;
  var x = new Date(y,m,d);

  if (date.getTime() >= x.getTime()) {
      e.allowSelect = false;
  }
}

//选择岗位
function choseJob() {
  // 模拟选中岗位
  // 获取选中值（岗位ID,岗位名称,部门ID,部门名称）
  // 模拟操作
  OpenDialog("/recruit/jobController/toSelectPage", "选择岗位", '', '680', '460', setJobData);
}

//选择岗位 回调函数
function setJobData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    mini.get("applyPostName").setValue(data.cJobname);
    $("#positionId").val(data.cJobcode);
  }
}

/*//实现上传图片的功能
function ajaxFileUpload(){
	$.ajaxFileUpload(
        {
             url:'/recruit/resume/uploadImage',      
             secureuri:false,
             fileElementId:'file_upload',                      
             dataType: 'text',                                
             success: function (data, status)            
               {   
            	 if(data !=""){
            		 data = data.substr(1, data.length-8);
    			     data = data.substr(5, data.length);
    			     var str =  data.split("*");
    			     if(str[0] =="文件上传路径"){
    			    	 $("#resumeAvatarImg").attr("src",str[1]);
    			    	 return ;
    			     }
            	 }
			
               },
             error: function (data, status, e)           
                {
            	 console.log(data);
                }
          }
    );
}*/

