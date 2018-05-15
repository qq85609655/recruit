var _jiaoyuindex = 1; // 教育经历id
var _gzindex = 1;// 工作经历id
var _jiaoyuindexs = new Array();
var _gzindexs = new Array();

// 是否竞业
function typeNameChange(e) {
  if (mini.get("isDevote").getValue() == "1") {
    $(".emailName").show();
  } else {
    $(".emailName").hide();
  }
}
$(function() {
  typeNameChange();
  // 初始化页面元素对象
  apply_post_name = mini.get("candidatePostName"); // 申请岗位名称
  apply_organization_name = mini.get("candidateOrgName"); // 申请部门名称
  apply_post_id = mini.get("candidatePostId"); // 申请岗位id
  apply_organization_id = mini.get("candidateOrgId"); // 申请部门id

  // 自动带出教育经历并且进行顺序的构建
  if (educationSize == "0" || educationSize == "1") {
    _jiaoyuindexs.push(0);
  } else {
    _jiaoyuindex = parseInt(educationSize); // 教育经历id
    var educationSizeInt = parseInt(educationSize);
    for (var i = 0; i < educationSizeInt; i++) {
      _jiaoyuindexs.push(i);
    }
  }
  // 自动带出工作经历并且进行顺序的构建
  if (worksSize == "0" || worksSize == "1") {
    _gzindexs.push(0);
  } else {
    _gzindex = parseInt(worksSize);// 工作经历id
    var worksSizeInt = parseInt(worksSize);
    for (var i = 0; i < worksSizeInt; i++) {
      _gzindexs.push(i);
    }
  }

});
// 移除教育经历项
function removeTableJy(index) {
  if (_jiaoyuindexs.length == 1) {
    mini.alert("至少填写一条教育经历");
    return;
  }
  $(".jiaoYuTable" + index).remove();
  _jiaoyuindexs.remove(index);
}
// 移除工作经历项
function removeTableGz(index) {
  if (_gzindexs.length == 1) {
    mini.alert("至少填写一条工作经历");
    return;
  }
  $(".gzTable" + index).remove();
  _gzindexs.remove(index);
}

// 选择岗位
function choseJob() {
  // 模拟选中岗位
  // 获取选中值（岗位ID,岗位名称,部门ID,部门名称）
  // 模拟操作
  OpenDialog("/recruit/jobController/toSelectPage", "选择岗位", '', '680', '460', setJobData);
}

// 选择应聘申请单
function choseInterview() {
  OpenDialog("/recruit/employ/choseInterview", "选择应聘申请单", '', '680', '460', setInterviewData);
}

// 选择应聘申请单 回调
function setInterviewData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    if(data.sex=="2"){
      mini.get("gender").setValue(1);
    }else if(data.sex=="1"){
      mini.get("gender").setValue(0);
    }
    mini.get("name").setValue(data.cnname);
    mini.get("pinyin").setValue(data.namepy);
    mini.get("englishName").setValue(data.enname);
    mini.get("birthday").setValue(data.birthdate);
    mini.get("email").setValue(data.email);
    mini.get("phone").setValue(data.phonenumber);
    mini.get("employmentForm").setValue(data.personCode);
  }
  // 获取应聘申请教育经历和工作经历
  SaveData("/recruit/employ/getEduAndWorkBy?personCode=" + data.personCode,
      $("#form1").serialize(), getEduAndWorkBy);
}

// 选择招聘需求
function choseDemand() {
  OpenDialog("/recruit/employ/choseDemand", "选择招聘需求", '', '680', '460', setDemandData);
}
// 选择员工类别获取对应职级
function reloadRank(e) {
  var positionCombo = mini.get("candidateType");
  var rankId = mini.get("employRankId"); // 直接下拉框
  if (positionCombo.getValue() == "1") {
    // 职员
    rankId.load("/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand");
  } else {
    // 现场人员
    rankId.load("/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand");
  }
}

// 输入工号获取部门和名称
function getInfoByCode(e) {
  var referrerId = mini.get("referrerId");
  $.ajax({
    url : basePath + "/baseUserController/getInfoByCode",
    type : "post",
    data:{'code':referrerId.getValue()},
    async : false,
    dataType : "json",
    success : function(data) {
      if(data!=null){
        mini.get("referrerName").setValue(data.C_NAME+"&"+data.C_UNITNAME);
      }else{
        mini.get("referrerName").setValue("");
      }
    }
  });
}

// 选择招聘需求 回调函数
function setDemandData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    // alert(JSON.stringify(data));
    mini.get("demandId").setValue(data.demandId);
    mini.get("employeeType").setValue(data.employeeType);
    mini.get("district").setValue(data.district);
    mini.get("applyOrganizationName").setValue(data.applyOrganizationName);
    mini.get("applyPostName").setValue(data.applyPostName);
    mini.get("rankId").setValue(data.rankId);
    mini.get("recruitDemandReason").setValue(data.recruitDemandReason);
    if (data.employeeType == "1") {
      // 职员
      mini.get("rankId").load(
          "/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand");
    } else {
      // 现场人员
      mini.get("rankId").load(
          "/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand");
    }
  }

}

// 选择岗位
function choseJob() {
  // 模拟选中岗位
  // 获取选中值（岗位ID,岗位名称,部门ID,部门名称）
  // 模拟操作
  OpenDialog("/recruit/jobController/toSelectPage", "选择岗位", '', '680', '460', setJobData);
}
// 选择岗位 回调函数
function setJobData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    apply_post_name.setValue(data.cJobname);
    apply_organization_name.setValue(data.cOrgname);
    apply_organization_id.setValue(data.cOrgcode);
    apply_post_id.setValue(data.cJobcode);
  }
}

// 提交新增需求表单
function submitForm(typeStr) {
  form.validate();
  if (form.isValid() == false) {
    mini.alert("请完整填写表单", "提示");
    return;
  }
  if (!checkData()) {
    return;
  }
  // 处理附件
  var attchmentIds = '';
  $(".fileStyle").each(function() {
    attchmentIds += $(this).attr('id').substring(4, $(this).attr('id').length) + ",";
  });

  $("#jiaoyu").val(JSON.stringify(getEducationData()));
  $("#work").val(JSON.stringify(getWorkData()));
  $("#attchmentIds").val(attchmentIds);
  SaveData("/recruit/employ/saveEmployInfo?typeStr=" + typeStr, $("#form1").serialize(),
      submitFormCall);

}

function submitFormCall(e) {
  if (e.success) {
    alert("修改成功");
    location.href = "/recruit/employ/list";
  } else {
    mini.alert(e.msg);
  }
}

// 取消按钮
function onCancel() {
  location.href = "/recruit/employ/list";
}

// 上传附件
function uploadDemandFile() {
  uploadAttachments("attachment");
}

// 下载附件
function downloadAttach(attachId) {
  window.location.href = jsWebRoot + "/attachmentController/downloadCommonAttachment/" + attachId;
}

// 上传附件
function uploadAttachments(name) {
  $.ajaxFileUpload({
    url : jsWebRoot + "/attachmentController/uploadFiles?type=" + "recruitDemand" + "&relateId=0",
    secureuri : false,
    fileElementId : name,
    dataType : "json",
    data : null,
    success : function(data, status) {
      // 得到附件ID
      var aid = data.attributes.attachId;
      var htmlStr = '';
      if (aid == null || aid == "") {
        mini.alert("请选择需上传的附件!");
      } else {
        var attachName = data.attributes.attachName;
        htmlStr += '<div id="div_' + aid + '" class="fileStyle">' + '<input id="' + aid
            + '" type="button" onclick="delAttach(\'' + aid + '\',this)" value="删除" />'
            + '&nbsp;&nbsp;' + '<a href=javascript:downloadAttach("' + aid + '")><span>'
            + attachName + '</span></a></div>';
        // 添加可删除附件的链接
        $("#span2").append(htmlStr);
        mini.alert(data.msg, "提示");
      }
    },
    error : function(data, status, e) {
      mini.alert(data.msg, "提示");
    }
  });
}

// 删除附件
function delAttach(attId, e) {
  /*
   * mini.confirm("确认要删除该附件吗？", "删除", function(e) { if (e == "ok") { $('#div_' +
   * attId).remove(); } })
   */
  $('#div_' + attId).remove();
}

function gotoCheck() {

}

// 教育经历
function getEducationData() {
  var edus = new Array();
  for (var i = 0; i < _jiaoyuindexs.length; i++) {
    var edu = new Object();
    edu["startDate"] = mini.get("startDate" + _jiaoyuindexs[i]).getFormValue();
    edu["endDate"] = mini.get("endDate" + _jiaoyuindexs[i]).getFormValue();
    edu["school"] = mini.get("school" + _jiaoyuindexs[i]).getFormValue();
    edu["major"] = mini.get("major" + _jiaoyuindexs[i]).getFormValue();
    edu["education"] = $("#education" + _jiaoyuindexs[i]).val();
    edu["educationType"] = $("#educationType" + _jiaoyuindexs[i]).val();
    if (edu["startDate"] != "" && edu["endDate"] != "") {
    }
    edus.push(edu);
  }
  return edus;
}
// 校验其他信息
function checkData() {
  // 教育开始时间
  var eduDates = $('[name="startDate"]');
  for (var i = 0; i < eduDates.length; i++) {
    if (eduDates[i].value == null || eduDates[i].value == '') {
      alert("请正确填写教育经历--开始时间");
      return false;
    }
  }
  // 教育结束时间
  var eduDatee = $('[name="endDate"]');
  for (var i = 0; i < eduDatee.length; i++) {
    if (eduDatee[i].value == null || eduDatee[i].value == '') {
      alert("请正确填写教育经历--结束时间");
      return false;
    }
  }
  // 工作开始时间
  var tstartDates = $('[name="tstartDate"]');
  for (var i = 0; i < tstartDates.length; i++) {
    if (tstartDates[i].value == null || tstartDates[i].value == '') {
      alert("请正确填写工作经历--开始时间");
      return false;
    }
  }
  // 工作结束时间
  var tendDates = $('[name="tendDate"]');
  for (var i = 0; i < tendDates.length; i++) {
    if (tendDates[i].value == null || tendDates[i].value == '') {
      alert("请正确填写工作经历--结束时间");
      return false;
    }
  }
  // 教育学校
  var schools = $('[name="school"]');
  for (var i = 0; i < schools.length; i++) {
    if (schools[i].value == null || schools[i].value == '') {
      alert("请正确填写教育经历--学校");
      return false;
    }
  }
  // 教育专业
  var majors = $('[name="major"]');
  for (var i = 0; i < majors.length; i++) {
    if (majors[i].value == null || majors[i].value == '') {
      alert("请正确填写教育经历--专业");
      return false;
    }
  }
  // 任职公司
  var companys = $('[name="company"]');
  for (var i = 0; i < companys.length; i++) {
    if (companys[i].value == null || companys[i].value == '') {
      alert("请正确填写工作经历--任职公司");
      return false;
    }
  }
  // 职位
  var posts = $('[name="post"]');
  for (var i = 0; i < posts.length; i++) {
    if (posts[i].value == null || posts[i].value == '') {
      alert("请正确填写工作经历--职位");
      return false;
    }
  }
  return true;
}
// 工作经历
function getWorkData() {
  var edus = new Array();
  for (var i = 0; i < _gzindexs.length; i++) {
    var edu = new Object();
    edu["startDate"] = mini.get("tstartDate" + _gzindexs[i]).getFormValue();
    edu["endDate"] = mini.get("tendDate" + _gzindexs[i]).getFormValue();
    edu["company"] = mini.get("company" + _gzindexs[i]).getFormValue();
    edu["post"] = mini.get("post" + _gzindexs[i]).getFormValue();
    if (edu["startDate"] != "" && edu["endDate"] != "") {
    }
    edus.push(edu);
  }
  return edus;
}