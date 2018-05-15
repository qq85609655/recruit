$(function() {
  // 初始化页面元素对象
  apply_post_name = mini.get("applyPostName"); // 申请岗位名称
  apply_organization_name = mini.get("applyOrganizationName"); // 申请部门名称
  apply_organization_nameStr = mini.get("applyOrganizationNameStr"); // 申请部门名称
  apply_post_id = mini.get("applyPostId"); // 申请岗位id
  apply_organization_id = mini.get("applyOrganizationId"); // 申请部门id
  predictComeDate = mini.get("predictComeDate"); // 预计到岗时间
  workRemark = mini.get("workRemark"); // 工作描述
  workExperience = mini.get("workExperience"); // 工作经验
  requiredSkill = mini.get("requiredSkill"); // 必备技能
  abilityDemanded = mini.get("abilityDemanded"); // 素质及能力要求
  applyDate = mini.get("applyDate"); // 申请日期
  if(applyDate.getValue()==null||applyDate.getValue()==""){
    applyDate.setValue(new Date().format("yyyy-MM-dd"));
  }
 
  // 新建招聘需求默认预计到岗日期为当前时间加一个月
  /*
   * if (id == null || id == "") { var date = new Date();
   * predictComeDate.setValue(dateAdd(date, "month", 1).format("yyyy-MM-dd")); }
   */
});

function onDrawDate(e) {
  var date = e.date;
  var d = new Date();

  if (date.getTime() < d.getTime()) {
      e.allowSelect = false;
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
    apply_organization_nameStr.setValue(data.cOrgname);
    apply_organization_id.setValue(data.cOrgcode);
    apply_post_id.setValue(data.cJobcode);
  }
}

// 选择历史记录回调函数 回调函数
function setHistoryData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    if (data.type == "1") { // 工作描述
      workRemark.setValue(data.str);
    } else if (data.type == "2") { // 工作经验
      workExperience.setValue(data.str);
    } else if (data.type == "3") { // 必备技能
      requiredSkill.setValue(data.str);
    } else { // 素质及能力要求
      abilityDemanded.setValue(data.str);
    }
  }
}

// 工 作描述、工作经验、必备技能、素质及能力要求 选择历史记录
function choseHistory(type) {
  var postId = apply_post_id.getValue();
  if (postId == null || postId == "") {
    ShowWarnTip("请先选择岗位");
  } else {
    OpenDialog("/recruit/demand/history?type=" + type + "&postId=" + postId, "选择历史记录", '', '680',
        '460', setHistoryData);
  }
}

// 提交新增需求表单
function submitForm(typeStr) {
  if (typeStr == "TJ") {
    form.validate();
    if (form.isValid() == false) {
      return;
    }
  }
  // 处理附件
  var attchmentIds = '';
  $(".fileStyle").each(function() {
    attchmentIds += $(this).attr('id').substring(4, $(this).attr('id').length) + ",";
  });
  $("#attchmentIds").val(attchmentIds);
  SaveData("/recruit/demand/save?typeStr=" + typeStr, $("#form1").serialize());
}

// 选中职级自动带出预计到岗时间
function getDateByRank(e) {
  var rank = mini.get("rankId");
  if (rank.getValue() == null || rank.getValue() == "") {
    predictComeDate.setValue("");
    // predictComeDate.setValue(dateAdd(date, "month", 1).format("yyyy-MM-dd"));
  } else {
    var rankName = rank.getText();
    var date = new Date();
    if (rankName == "助理工程师" || rankName == "助理专员" || rankName == "干事" || rankName == "工程师"
        || rankName == "专员") {
      // 预计到岗时间时间加上一个月
      predictComeDate.setValue(dateAdd(date, "day", 30).format("yyyy-MM-dd"));
    } else if (rankName == "主任工程师" || rankName == "主任专员" || rankName == "中级干事") {
      // 预计到岗时间时间加上一个半月
      predictComeDate.setValue(dateAdd(date, "day", 45).format("yyyy-MM-dd"));
    }else if (rankName == "OP" || rankName == "技术员" ) {
      predictComeDate.setValue(dateAdd(date, "day", 30).format("yyyy-MM-dd"));
    }else {
      // 预计到岗时间时间加上二个月
      predictComeDate.setValue(dateAdd(date, "day", 60).format("yyyy-MM-dd"));
    }
  }
}

// 选择员工类别获取对应职级
function reloadRank(e) {
  var positionCombo = mini.get("employeeType");
  var rankId = mini.get("rankId"); // 直接下拉框
  if (positionCombo.getValue() == "1") {
    // 职员
    rankId.load("/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand");
  } else {
    // 现场人员
    rankId.load("/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand");
  }
  getDateByRank();
}
// 选择招聘原因判断是否可填写离职转调人
function dimissionChangePersonCheck(e) {
  var recruitDemandReason = mini.get("recruitDemandReason");
  var dimissionChangePerson = mini.get("dimissionChangePerson"); // 直接下拉框
  if (recruitDemandReason.getValue() == "1" || recruitDemandReason.getValue() == "2") {
    dimissionChangePerson.setReadOnly(false);
    dimissionChangePerson.enable();
  } else {
    dimissionChangePerson.setValue("");
    dimissionChangePerson.setReadOnly(true);
    dimissionChangePerson.disable();
  }
}

function onChineseValidation(e) {
  if (e.isValid) {
    if (isChineseAndEng(e.value) == false) {
      e.errorText = "必须输入中文+英文";
      e.isValid = false;
    }
  }
}

function educationValidation(e) {
  var positionCombo = mini.get("employeeType");
  if (e.isValid) {
    if (e.value == "高中中专" && positionCombo.getValue() == "1") {
      e.errorText = "职员不能选择高中中专学历";
      e.isValid = false;
    }
  }
}


function onChineseValidationNull(e) {
  if (e.isValid) {
    if(e.value!=null&&e.value!=""){
      if (isChineseAndEng(e.value) == false) {
        e.errorText = "必须输入中文+英文";
        e.isValid = false;
      }
    }
  }
}

/* 是否汉字+英语 */
function isChineseAndEng(v) {
  var re = new RegExp("^[A-Za-z\u4e00-\u9fa5]+$");
  if (re.test(v))
    return true;
  return false;
}

// 取消按钮
function onCancel(e) {
  CloseWindow("close", form);
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

// 修改申请人数
function updateApplyPersonNum(id) {
  OpenDialog("/recruit/demand/updateApplyPersonNum/" + id, "修改申请人数", '', '450', '380',function(){});
}

// 修改期望到岗时间
function updateWantTime(id) {
  OpenDialog("/recruit/demand/updateWantTime/" + id, "修改期望到岗时间", '', '500', '400',function(){});
}