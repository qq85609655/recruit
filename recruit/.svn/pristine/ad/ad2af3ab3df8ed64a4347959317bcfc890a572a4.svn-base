var Genders = [{ code: 1, text: '男' }, { code: 2, text: '女'}];
var familyRelations = [{ code: 1, text: '父母' }, { code: 2, text: '配偶'}, { code: 3, text: '兄弟姐妹'}, { code: 4, text: '子女'}];
var emergentRelations=[{ code: 1, text: '父母' }, { code: 2, text: '配偶'}, { code: 3, text: '兄弟姐妹'}, { code: 4, text: '朋友'}, { code: 5, text: '其他亲戚'}, { code: 6, text: '其他'}];

// 获取一组checkbox的选中值,返回逗号分隔的字符串
function getCheckboxValue(Class) {
	var i=0,s = [];
	$(Class).each(function() {
		if($(this)[0].checked) {
			s[i++] = $(this).val();
		}
	});
	return s.join(",");
}

function getCheckboxText(Class) {
	var i=0,s = [];
	$(Class).each(function() {
		if($(this)[0].checked) {
			s[i++] = $(this).next().text();
		}
	});
	return s.join(",");
}

// 获取一组radio中的选中值 
function getRadioValue(Class) {
	var s;
	$(Class).each(function() {
		if($(this)[0].checked) {
			s = $(this).val();
		}
	});
	return s;
}

// 获取一组radio中的选中的label值 
function getRadioText(Class) {
	var s;
	$(Class).each(function() {
		if($(this)[0].checked) {
			s = $(this).next().text();
		}
	});
	return s;
}

// 设置一组radio的选中状态
function setRadioValue(Class,value) {
	$(Class).each(function() {
		if($(this).attr("value") == value) {
			this.checked = true;
		}
	});
}

// 获取select选中的值
function getSelectValue(Id) {
	return $(Id).find("option[value='" + $(Id).val() + "']").attr("id");
}

// 选中下拉列表中的某一项
function setSelectValue(id,value) {
	$(id).find("option[text='" + value + "']").attr("selected",true);
}

// 设置一组checkbox中的选中状态
function selectCheckbox(Class, values) {
	$(Class).each(function() {
		if(values[$(this).next().text()]) {
			$(this)[0].checked = true;
		}
	});
}

function ondrawcell(e) {
    switch (e.field){
		case "releaseDate":
			if(e.row.releaseDate != null){
				e.cellHtml = new Date(e.row.releaseDate).format("yyyy-MM-dd");
			}
     }  
}

function onValueChanged(e){
  var checked = this.getChecked();
//  alert(this.getValue());
}

//页面绑定事件调用
function bindingEvent(){
  //绑定国籍修改事件
  $("#nationality").change(function(){
    nationalityEvent();
  });
  //绑定招聘途径修改事件
  $(".recruitment-approach").change(function(){
    approachEvent();
  });
  //绑定是否有亲属在华星事件
  $(".relatives-flag").change(function(){
    relativesEvent();
  });
}

//国籍监听事件
function nationalityEvent(){
  var na = $("#nationality").val();
  if(na == '1'){
    $(".cnarea").css("display","table-row");
    //选择中国时证件关联为身份证
    $("#certificateType").val("1");
    
  }else{
    $(".cnarea").css("display","none");
    //台湾
    if(na == '2'){
      $("#certificateType").val("2");
    }
    else if(na == '3' || na == '4'){
      //港澳
      $("#certificateType").val("4");
    }else{
      //其他外国
      $("#certificateType").val("3");
    }
  }
}

//招聘途径修改事件
function approachEvent(e){
  var ap = $("input[name='recruitmentApproach']:checked").val();
  //内部推荐
  if(ap == '2'){
    $("#refereeArea").css("display","inline");
    $("#otherWayArea").css("display","none");
  }
  else if(ap == '4'){
    //其他途径
    $("#otherWayArea").css("display","inline");
    $("#refereeArea").css("display","none");
  }else{
    $("#refereeArea").css("display","none");
    $("#otherWayArea").css("display","none");
  }
}

//是否有亲属在华星事件
function relativesEvent(){
  var re = $("input[name='relativesFlag']:checked").val();
  if(re == '1'){
    $(".relativesArea").css("display","inline");
  }else{
    $(".relativesArea").css("display","none");
  }
  
}

//紧急联系人绑定事件
function emergentEvent(e){
  var grid = mini.get("datagrid-family");
  var grid2 = mini.get("datagrid-emergent");
  var emergentContacts = new Array();
  var familyData = grid.getData();
  for(var i = 0; i < familyData.length; i++) {
    var flag = familyData[i].emergentFlag
    //当前为紧急联系人时
    if(flag == '1' && emergentContacts.length<2){
      var emergent = new Object();
      emergent.emergentName = familyData[i].menberName;
      if(familyData[i].familyRelation == '4'){
        emergent.emergentRelation = '5';
      }else{
        emergent.emergentRelation = familyData[i].familyRelation;
      }
      emergent.emergentAddress = familyData[i].menberAddress;
      emergentContacts.push(emergent);
    }
  }
  var length=emergentContacts.length;
  for(var i=0;i<2-length;i++){
    var emergent = new Object();
    emergentContacts.push(emergent);
  }
  
  grid2.setData(emergentContacts);
}

//基本信息校验
$("#editform").validator({
  theme : "simple_right",
  msgClass : "n-right ",
  rules: {
      selectVoid : function(e, p, f) {
          if(Number($(e).val())) {
              return true;
          }
          else {
              return false;
          }
      }
  },
  fields : {
      "#cnname" : {
          rule : "中文名称:required;length[~32]",
          msgStyle : "position:absolute;left:90%;"
      },
      "#namepy" : {
          rule : "姓名拼音:required;length[~32]",
          msg : "请填写姓名拼音",
          msgStyle : "position:absolute;left:90%;"
      },
      "maritalStatus" : {
          rule : "checked;",
          msg : "请选择婚姻状况"
      },
      "#nativePlace" : {
          rule : "籍贯:required;length[~100]",
          msgStyle : "position:absolute;left:85%;"
      },
      "#residence" : {
          rule : "户籍地址:required;length[~100]",
          msgStyle : "position:absolute;left:90%;"
      },
      "#certificateNum" : {
        rule : "证件号码:required;length[8~19]",
        msgStyle : "position:absolute;left:80%;"
      },
      "#certificateName" : {
        rule : "证件名称:required;length[~32]",
        msgStyle : "position:absolute;left:90%;"
      },
      "#phonenumber" : {
        rule : "required(telVoid);mobile",
        msg : "请正确填写手机号码",
        msgStyle : "position:absolute;left:90%;"
      },
      "#email" : {
          rule : "邮箱:required;email",
          msgStyle : "position:absolute;left:80%;",
          msg : "请正确填写邮箱"
      },
      "#address"  : {
          rule : "通讯地址:required;length[~200]",
          msgStyle : "position:absolute;left:90%;"
      },
      "#positionName" : {
          rule : "应聘职位:required;length[~36]",
          msgStyle : "position:absolute;left:85%;"
      },
      "recruitmentApproach" : {
        rule : "checked;",
        msg : "请选择信息来源"
      },
      "relativesFlag" : {
          rule : "checked",
          msg : "请选择"
      }
  },
  valid : function(form) {
      var me = this;
      me.holdSubmit();
      baseInfoSave("0");
      me.holdSubmit(false);
  }
});

//校验其他信息
function checkData(){
  var birthdateStr = mini.get("birthdate").getFormValue();
  var arriveDateStr = mini.get("arriveDate").getFormValue();
  if(birthdateStr == null || birthdateStr == ''){
    alert("请正确填写出生日期");
    return false;
  }
  if(arriveDateStr == null || arriveDateStr == ''){
    alert("请正确填写可到岗时间");
    return false;
  }
  
  //薪水
  var salaryMonth = $("#expectedSalaryMonth").val();
  var salaryYear = $("#expectedSalaryYear").val();
  var salaryOther = $("#expectedSalaryOther").val();
  if(salaryMonth == '' && salaryMonth == '' && salaryMonth == '' ){
    alert("请填写期望薪水");
    return false;
  }
  
  //教育开始时间
  var eduDates = $('[name="eduStartDate"]');
  for(var i=0;i < eduDates.length;i++){
    if(eduDates[i].value == null || eduDates[i].value == ''){
      alert("请正确填写教育经历--教育起始时间");
      return false;
    }
  }
  //教育结束时间
  var eduDatee = $('[name="eduEndDate"]');
  for(var i=0;i < eduDatee.length;i++){
    if(eduDatee[i].value == null || eduDatee[i].value == ''){
      alert("请正确填写教育经历--教育起始时间");
      return false;
    }
  }
  //教育学校
  var schools = $('[name="schoolName"]');
  for(var i=0;i < schools.length;i++){
    if(schools[i].value == null || schools[i].value == ''){
      alert("请正确填写教育经历--学校");
      return false;
    }
  }
  //教育专业
  var majors = $('[name="major"]');
  for(var i=0;i < majors.length;i++){
    if(majors[i].value == null || majors[i].value == ''){
      alert("请正确填写教育经历--专业");
      return false;
    }
  }
  //紧急联系人
  var emes = getEmergentData();
  if(emes[0].emergentName){
  }else{
    alert("至少填写一位紧急联系人 ");
    return false;
  }

  //家庭成员
  var fams = mini.get("datagrid-family").getData();
  if(fams[0].menberName){
  }else{
    alert("请填写家庭成员 ");
    return false;
  }
  return true;
}



//获取基本信息
function getBaseData() {
    return {
        id : $("#id").val(),
        personCode : $("#personCode").val(),
        recruiterNumber : $("#recruiterNumber").val(),
        recruiterName : $("#recruiterName").val(),
        nationality : $("#nationality").val(),
        cnname : $("#cnname").val(),
        enname : $("#enname").val(),
        sex : $("#sex").val(),
        maritalStatus : getRadioValue(".marital-status-interview"),
        namepy : $("#namepy").val(),
        nation : $("#nation").val(),
        politicalStatus : $("#politicalStatus").val(),
        nativePlace : $("#nativePlace").val(),
        residenceProperty : $("#residenceProperty").val(),
        residence : $("#residence").val(),
        certificateType : $("#certificateType").val(),
        certificateNum : $("#certificateNum").val(),
        certificateName : $("#certificateName").val(),
        birthdate : mini.get("birthdate").getFormValue(),
        highestEducation : $("#highestEducation").val(),
        phonenumber : $("#phonenumber").val(),
        email : $("#email").val(),
        address : $("#address").val(),
        postcodes : $("#postcodes").val(),
        startworkingdate : mini.get("startworkingdate").getFormValue(),
        positionName : $("#positionName").val(),
        arriveDate : mini.get("arriveDate").getFormValue(),
        expectedSalaryMonth : $("#expectedSalaryMonth").val(),
        expectedSalaryYear : $("#expectedSalaryYear").val(),
        expectedSalaryOther : $("#expectedSalaryOther").val(),
        recruitmentApproach : getRadioValue(".recruitment-approach"),
        refereeName : $("#refereeName").val(),
        refereeWorkCode : $("#refereeWorkCode").val(),
        refereePhone : $("#refereePhone").val(),
        otherWay : $("#otherWay").val(),
        relativesFlag : getRadioValue(".relatives-flag"),
        relativesName : $("#relativesName").val(),
        relativesShip : $("#relativesShip").val()
    };
}

//获取家庭成员
function getFamilyData(){
    var json = mini.encode(mini.get("datagrid-family").getData(),"yyyy-MM-dd");
    return json;
}

//紧急联系人
function getEmergentData(){
  return mini.get("datagrid-emergent").getData(true);
}

//教育经历
function getEducationData(){
  var edus = new Array();
  for(var i = 1; i <= educount; i++) {
    var edu = new Object();
    edu["eduStartDate"] = mini.get("eduStartDate"+i).getFormValue();
    edu["eduEndDate"] = mini.get("eduEndDate"+i).getFormValue();
    edu["schoolName"] = $("#schoolName"+i).val();
    edu["major"] = $("#major"+i).val();
    edu["education"] = $("#education"+i).val();
    edu["eduType"] = $("#eduType"+i).val();
    edu["certificate"] = getCheckboxValue(".certificate"+i);
    edu["certNationality"] = $("#certNationality"+i).val();
    if(edu["eduStartDate"]!=""&&edu["eduEndDate"]!=""){
      edus.push(edu);
    }
    
  }
  return edus;
}

//获得证书
function getCertificationData(){
  var certifications = new Array();
  
  for(var i = 1; i <= 2; i++) {
    var dateArea = mini.get("diplomaDate"+i);
    if(dateArea){
      var date= dateArea.getFormValue();
      if(date != ''){
        var certification = new Object();
        certification["type"] = $("#diplomaType"+i).val();
        certification["name"] = $("#diplomaName"+i).val();
        certification["receivingdate"] =  mini.get("diplomaDate"+i).getFormValue();
        certification["num"] = $("#diplomaNum"+i).val();
        certification["authorityOrg"] = $("#diplomaOrgan"+i).val();
        certifications.push(certification);
      }
    }
  }
  return certifications;
}

//计算机与语言
function getLanguageData(){
  var language = new Object();
  language["officeFlag"] = mini.get("officeFlag").getValue();
  language["officeSkilledLevel"] = getRadioValue(".officeSkilledLevel");
  language["officeDiploma"] = $(".officeDiploma").val();
  
  language["englishFlag"] = mini.get("englishFlag").getValue();
  language["officeSkilledLevel"] = getRadioValue(".officeSkilledLevel");
  language["englishDiploma"] = $("#englishDiploma").val();

  language["sapFlag"] = mini.get("sapFlag").getValue();
  language["sapSkilledLevel"] = getRadioValue(".sapSkilledLevel");
  language["sapDiploma"] = $("#sapDiploma").val();

  language["koreanFlag"] = mini.get("koreanFlag").getValue();
  language["koreanSkilledLevel"] = getRadioValue(".koreanSkilledLevel");
  language["koreanDiploma"] = $("#koreanDiploma").val();

  language["vbaFlag"] = mini.get("vbaFlag").getValue();
  language["vbaSkilledLevel"] = getRadioValue(".vbaSkilledLevel");
  language["vbaDiploma"] = $("#vbaDiploma").val();

  language["japaneseFlag"] = mini.get("japaneseFlag").getValue();
  language["japaneseSkilledLevel"] = getRadioValue(".japaneseSkilledLevel");
  language["japaneseDiploma"] = $("#japaneseDiploma").val();

  language["otheritFlag"] = mini.get("otheritFlag").getValue();
  language["otheritSkilledLevel"] = getRadioValue(".otheritSkilledLevel");
  language["otheritDiploma"] = $("#otheritDiploma").val();

  language["otherFlag"] = mini.get("otherFlag").getValue();
  language["otherSkilledLevel"] = getRadioValue(".otherSkilledLevel");
  language["otherDiploma"] = $("#otherDiploma").val();
  return language;
}

//工作履历
function getWorkData(){
  var works = new Array();
  for(var i = 1; i <= wkcount; i++) {
    var stratdate =  mini.get("workstartdate"+i).getFormValue();
    if(stratdate){
      var work = new Object();
      work["jobStartDate"] = mini.get("workstartdate"+i).getFormValue();
      work["jobEndDate"] = mini.get("workenddate"+i).getFormValue();
      work["companyName"] = $("#companyName"+i).val();
      work["salary"] = $("#finalSalary"+i).val();
      work["department"] = $("#department"+i).val();
      work["positionName"] = $("#finalPosition"+i).val();
      work["debriefer"] = $("#reportTo"+i).val();
      work["subordinate"] = $("#subordinates"+i).val();
      work["seniority"] = $("#seniority"+i).val();
      work["jobDuty"] = $("#responsibilities"+i).val();
      work["leaveReason"] = $("#leaveReason"+i).val();
      work["reterence"] = $("#reterence"+i).val();
      work["relationship"] = $("#relationship"+i).val();
      work["reterencePhone"] = $("#reterencePhone"+i).val();
      works.push(work);
    }
  }
  return works;
}

//奖励及特长
function getRewardData(){
  var reward = new Object();
  for(var i = 1; i <= 3; i++) {
    reward["rewardName"+i] = $("#rewardName"+i).val();
    reward["rewardDate"+i] = mini.get("rewardDate"+i).getFormValue();
    reward["authorities"+i] = $("#authorities"+i).val();
  }
  reward["hobby"] = $("#hobby").val();
  reward["speciality"] = $("#speciality").val();
  return reward;
}

//推荐人
function getRecommendedData(){
  return  mini.get("datagrid-recommended").getData(true);
}

//声明
function getIllustrateData(){
  var illustrate = new Object();
  illustrate["id"] = $("#infectionId").val();
  illustrate["infectionFlag"] = mini.get("infectionFlag").getValue();
  illustrate["infectionText"] = $("#infectionText").val();

  illustrate["criminalFlag"] = mini.get("criminalFlag").getValue();
  illustrate["criminalText"] = $("#criminalText").val();
  
  illustrate["employFlag"] = mini.get("employFlag").getValue();
  illustrate["employText"] = $("#employText").val();
  
  illustrate["investigateFlag"] = mini.get("investigateFlag").getValue();
  illustrate["investigateText"] = $("#investigateText").val();
  
  illustrate["banFlag"] = mini.get("banFlag").getValue();
  illustrate["banStartdate"] = mini.get("banStartdate").getFormValue();
  illustrate["banEnddate"] = mini.get("banEnddate").getFormValue();
  illustrate["payment"] = $("#payment").val();
  
  return illustrate;
}

//保存为草稿
$("#saveData").click(function() {
  	$("#editform").trigger("submit");
});
//发布
$("#review").click(function() {
  reviewData();
});

//打印
$("#print").click(function() {
  printResume();
});

//数据保存
function baseInfoSave(fn) {
  var operatorType = $("#operatorType").val();
  
  if(!checkData()){
    return;
  }
  var baseInfo=getBaseData();
  baseInfo["interviewStatus"]=fn;
  var messageId = mini.loading("数据保存中,请稍后...");
    $.ajax({
        type : "post",
        async : false,
        dataType : "json",
        data : {"baseInfo" : JSON.stringify(baseInfo),
                "family" : getFamilyData(),
                "emergent" : JSON.stringify(getEmergentData()),
                "education" : JSON.stringify(getEducationData()),
                "certification" : JSON.stringify(getCertificationData()),
                "language" : JSON.stringify(getLanguageData()),
                "work" : JSON.stringify(getWorkData()),
                "reward" : JSON.stringify(getRewardData()),
                "recommended" : JSON.stringify(getRecommendedData()),
                "illustrate" : JSON.stringify(getIllustrateData()),
                "studentId" : studentId
        },
        url : basePath + "/interviewController/save",
        success : function(data){
            if(data.success){
              mini.hideMessageBox(messageId);
              alert("提交成功，关闭页面即可！");
              $("#saveData").css("display","none");
              if(operatorType == 'edit'){
                window.close();
              }else{
                window.location.href = basePath + "/resources/html/showInfo.html";
              }
            }else{
              alert(data.msg);
            }
        },
        error: function() {
            $(".page-loading").hide();
            alert("保存失败!");
        }
    });
}

//预览
function reviewData(){
  
  var baseInfo=getBaseData();
  $("#baseInfo").val(JSON.stringify(baseInfo));
  $("#family").val(getFamilyData());
  $("#emergent").val(JSON.stringify(getEmergentData()));
  $("#education").val(JSON.stringify(getEducationData()));
  $("#certification").val(JSON.stringify(getCertificationData()));
  $("#language").val(JSON.stringify(getLanguageData()));
  $("#work").val(JSON.stringify(getWorkData()));
  $("#reward").val(JSON.stringify(getRewardData()));
  $("#recommended").val(JSON.stringify(getRecommendedData()));
  $("#illustrate").val(JSON.stringify(getIllustrateData()));
  
  $("#reviewForm").submit();

  
  
}