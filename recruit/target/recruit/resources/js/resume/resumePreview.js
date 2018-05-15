//简历预览设置数据
function SetData(d) {
  
	//基本信息的页面的预览
    previewBasicInfo(d);
    
	//简历信息预览的页面
	initPage(d);
	//工作经验预览
	previewWorkExperience(d);
	
	//教育经历预览
	previewEducationExperience(d);
	
	//语言信息预览
	previewLanguage(d);
	
	//技能信息预览
	previewSkill(d);
}

function previewBasicInfo(d){

	var data = {
			name:d.name,
			applyPostName:d.applyPostName,
			nationality:d.nationality,
			nationalityName:d.nationalityName,
			sex : d.sex,
			sexName:d.sexName,
			brithday:d.birthday,
			marriage:d.maritalStatus,
			marriageName:d.maritalName,
			residency:d.residence,
			workYears:d.workYears,
			alternativePhone:d.phoneReseave,
			phone:d.phone,
			email:d.email,
			address:d.address,
			ethnic:d.nation,
			nationName :d.nationName,
			certificateType : d.certificateType,
			certificateTypeName : d.certificateTypeName,
			IDNumber:d.idNumber,
			IDAddress:d.idAddress
	}
	var htm = writeBasicInfoHtml(data);
	$(".basicinfoData").html(htm);
	$(".basicinfoShow").show();
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

function initPage(d){
	//背景信息
	if($.trim(d.selfEvaluation) !=""){
		$("#showSelfEvaluationItem").click();
		$("#divEditSelfEvaluation").html(d.selfEvaluation);
	}
	//求职意向
	if($.trim(d.careerObject)!=""){
		$("#showCareerObjectItem").click();
		$("#divEditCareerObject").html(d.careerObject);
	}
	//奖励信息
	if($.trim(d.awardInfo) !=""){
		$("#showRewardsItem").click();
		$("#divEditRewards").text(d.awardInfo);
	}
	//证书信息
	if($.trim(d.certificateInfo) !=""){
	    $("#showCertificationItem").click();
	    $("#divEditCertification").text(d.certificateInfo);
	}
	//详细工作经历
	if($.trim(d.experienceDetail) !=""){
		$("#showWorkDetailsItem").click();
		$("#divEditExperienceDetail").text(d.experienceDetail);
		
	}
	//爱好信息
	if($.trim(d.hobbyInfo) !=""){
		$("#showHobbiesItem").click();
		$("#divEditHobbies").text(d.hobbyInfo);
	}
	//语言描述信息
	if($.trim(d.languageSkill) !=""){
		$("#showLanguageSkillItem").click();
		$("#divEditLanguageSkill").text(d.languageSkill);
		
	}
	//项目经验
	if($.trim(d.projectExperience) !=""){
		$("#showProjectExperienceItem").click();
		$("#divEditProjectExperience").text(d.projectExperience);
	}
	//其他技能信息
	if($.trim(d.skillText) !=""){
		$("#showSkillTextItem").click();
		$("#divEditSkillText").text(d.skillText);
		
	}
	//培训信息
	if($.trim(d.trainInfo) !=""){
		$("#showTrainingInfoItem").click();
		$("#divEditTrainingInfo").text(d.trainInfo);
	}
	//工作经验
	if($.trim(d.companys)!=""){
		$("#showWorkItem").click();
    }
	//教育经历   
	if($.trim(d.degreeName)!="" && $.trim(d.graduationSchool)!="" && $.trim(d.professional)!=""){
		$("#showEduItem").click();
	}
	//技能:

	if($.trim(d.skillInfo) !="" && $.trim(d.rank)!=""){
		$("#showSkillItem").click();
	}
	//语言
	if($.trim(d.languageName)!=""){
		$("#showLangItem").click();
	}
}

//切割工作经历的字符数据
function splitWorkExperienceInfo(d){
	var company = d.companys.split(",");
	var expStartDate = d.expStartDates.split(",");
	var expEndDate = d.expEndDates.split(",");
	var industryBtn =  d.industries.split(",");
	var roleName = d.roleNames.split(",");
	var locationBtn = d.locations.split(",");
	var companyTypeId = d.companyTypeIds.split(",");
	var companyTypeName = d.companyTypeName.split(",");
	var responsibility = d.responsibilitys.split(",");
	var reportObject = d.reportObjects.split(",");
	var subordinate = d.subordinates.split(",");
	var salary = d.salary.split(",");
	var currencyType = d.currencyTypes.split(",");
	var currencyTypeName = d.currencyTypeName.split(",");
	var achievement = d.achievements.split(",");
	var data = {
			company:company,
			expStartDate:expStartDate,
			expEndDate:expEndDate,
			industryBtn:industryBtn,
			roleName:roleName,
			locationBtn:locationBtn,
			roleName:roleName,
			locationBtn:locationBtn,
			companyTypeName:companyTypeName,
			responsibility:responsibility,
			reportObject:reportObject,
			subordinate:subordinate,
			salary:salary,
			currencyTypeName:currencyTypeName,
			achievement:achievement
	}
	return data;
}

//预览工作经历
function previewWorkExperience(d){
	var data = splitWorkExperienceInfo(d);
	for(var i=0;i<data.company.length-1;i++){
		var experience = {
				company:data.company[i],
				expStartDate:data.expStartDate[i],
				expEndDate:data.expEndDate[i],
				industryBtn:data.industryBtn[i],
				roleName:data.roleName[i],
				locationBtn:data.locationBtn[i],
				responsibility:data.responsibility[i],
				reportObject:data.reportObject[i],
				subordinate:data.subordinate[i],
				salary:data.salary[i],
				currencyTypeName:data.currencyTypeName[i],
				achievement:data.achievement[i]
		}
		var htm =  writeWorkExperienceHtml(experience);
		$(".workConData").append(htm);
	}
}

//切割学历的字符数据
function splitEducationExperienceInfo(d){
	var startYearMonth = d.startYearMonth.split(",") ;
	var endYearMonth=d.endYearMonth.split(",") ;
	var degreeId=d.degreeId.split(",");
	var degreeName=d.degreeNameShow.split(",") ;
	var eduType =d.eduType.split(",");
	var eduTypeName =d.eduTypeName.split(",");
	var schoolName=d.graduationSchool.split(",") ;
	var majorName=d.professional.split(",") ;
	
	var data = {
			startYearMonth:startYearMonth,
			endYearMonth:endYearMonth,
			degreeId:degreeId,
			degreeName:degreeName,
			eduTypeName:eduTypeName,
			eduType:eduType,
			schoolName:schoolName,
			majorName:majorName
	}
	return data;
}
//预览学历信息
function previewEducationExperience(d){
	var data = splitEducationExperienceInfo(d);
	for(var i=0;i<data.degreeName.length-1;i++){
		var educationExperience = {
				startYearMonth : data.startYearMonth[i],
				endYearMonth : data.endYearMonth[i],
				degreeName : data.degreeName[i],
				eduTypeName : data.eduTypeName[i],
				eduType : data.eduType[i],
				schoolName : data.schoolName[i],
				majorName : data.majorName[i],
				degreeId:data.degreeId[i],
		}
		var htm = writeEducationHtml(educationExperience);
		//展示后的相关操作的控制
		$(".educationExperience").append(htm);
	}
}

//切割语言信息的字符数据
function splitLanguageData(d){
	var languageName = d.language.split(",");
	var languageLevelName=d.languageLevelName.split(",");
	var oralLevelName = d.oralLevelName.split(",");
	
	var data = {
			languageName:languageName,
			languageLevelName:languageLevelName,
			oralLevelName:oralLevelName
	}
	return data;
}


//预览语言信息
function previewLanguage(d){
	var data = splitLanguageData(d);
	for(var i=0;i<data.languageName.length-1;i++){
		var languageData = {
				languageName:data.languageName[i],
				languageLevelName:data.languageLevelName[i],
				oralLevelName:data.oralLevelName[i],
				languageId:"1",
				languageLevelId:"1",
				oralLevelId:"1"
		}
		var htm = writeLanguageHtml(languageData);
		$(".languageList").append(htm);
	}
}

function splitSkillData(d){
	var skillInfo = d.skillInfo.split(",");
	var rankName = d.rankName.split(",");
	
    var data = {
    		skillInfo:skillInfo,
    		rankName:rankName
    }
    return data;
}

//预览技能信息
function previewSkill(d){
	var data = splitSkillData(d);
	for(var i=0;i<data.skillInfo.length-1;i++){
		var skillData = {
				skill:data.skillInfo[i],
				levelId:"1",
				levelName:data.rankName[i]
		}
		htm = writeSkillHtml(skillData);
		$("#skillData").append(htm);
		
	}
}
$(".record").die();

//将数据展示
function writeEducationHtml(educationData){
    var d = "<ul class='delSkill record' data-tip='education'>" +
              "<li class='f_r' style='display: none;'>" +
                "<a id='editEducation'>编辑</a><a class='del'>删除</a>" +
              "</li>" ;
    if($.trim(educationData.startYearMonth)!="" && $.trim(educationData.endYearMonth)!=""){
        d+="<li>"+educationData.startYearMonth+" 至 "+educationData.endYearMonth+"</li>" +
        "<li class='startYearMonth'>"+educationData.startYearMonth+"</li>" +
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
    d+="</ul>";
    return d;
}

//将工作经历的数据展示
function writeWorkExperienceHtml(experienceData){
    var d="<dl class='delSkill'>";
    d+="<dt class='record' value='"+experienceData.company+"'><span>"+experienceData.company+"</span><span  class='f_r' style='display: none;'><a  class='workExperienceEditor'>编辑</a>&nbsp;<a class='del'>删除</a></span ></dt>" ;
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

//点击保存后将语言数据显示
function writeLanguageHtml(languageData){
    var d = "<ul class='delSkill record'>" +
      "<li class='f_r' style='display: none;'>" +
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
  
      d+="<td ><span  class='f_r' style='display: none;align:right;'><a class='del'>删除</a></span ></td> </tr>";
 return d;
}