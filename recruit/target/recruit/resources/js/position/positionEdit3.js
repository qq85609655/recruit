var editor, editor2, workPlaceId, workPlaceName, positionSimilarId = "", positionSimilarName = "", positionRequire = "", editType = false, // 当前职位是编辑的状态
copyFlag = false, // 是否是复制
saveType = "011-002"; // 保存类型: 011-000,保存为草稿 011-002,保存为发布中的职位;
function needHide() {
  var obj = document.getElementsByName('recruitType');
  var s = true;
  for (var i = 0; i < obj.length; i++) {
    // 判断如果选择内部招聘则显示内招岗位描述
    if (obj[i].checked) {
      if (obj[i].value == "009-003") {
        $(".needHide").show();
        s = false;
      }
    }
  }
  if (s) {
    $(".needHide").hide();
  }
}
$(document).ready(function() {

  // 绑定招聘类别值变化事件
  $("input[name=recruitType]").change(function() {
    needHide();
  });

  // 初始化mini ui
  mini.parse();

  // 富文本编辑器初始化
  initKE();
  initKE2();


  // 获取职位列表用于职位复制
  queryPosi();

  // 职位类别初始化
  positionCategory.init();
  positionCategory.closeAfter = positionCategoryClose;

  // 初始化有默认提示的查询框
  initInputSearch(".choose-position-input");

  // 一些事件的绑定
  eventBind();

  // 初始化职位要求
  initPositionRequire();

  // 获取部门树
  queryDep();

  // 获取角色
  queryRole();

  // 初始化面试模板
  queryTemplete();
})
// 初始化编辑器
function initKE() {
  KindEditor.ready(function(K) {
    editor = K.create('#content_1', {
      width : "100%",
      height : '244px',
      afterChange : function() {
        K('.word_count').html(this.count('text'));
      },
      afterCreate : afterInitKE,
      resizeMode : 0
    });
  });
}

// 初始化编辑器
function initKE2() {
  KindEditor.ready(function(K) {
    editor2 = K.create('#content_2', {
      width : "100%",
      height : '244px',
      afterChange : function() {
        K('.word_count2').html(this.count('text'));
      },
      resizeMode : 0
    });
  });
}

// 一些事件的绑定
function eventBind() {

  // 弹出已有职位的window
  $(".copy-posi").click(function() {
    showAtPos("positionName-choose-win", "#positionName");
  });

  // 选择工作地点
  $("#workPlace").click(chooseArea);

  // 新增部门提交
  $("#orgAddOK").click(function() {
    $("#orgAddForm").trigger("submit");
  });

  // 新增账号提交
  $("#accountAddOK").click(function() {
    $("#accountAddForm").trigger("submit");
  });

  // 表单提交
  $('#release').click(function() {
    saveType = "011-002";
    /*
     * if(editType !== "草稿") { mini.confirm("该职位" + editType +
     * ",是否重新发布?","",function(action) { if(action == "ok") {
     * $("#editform").trigger("submit"); } }); } else {
     * $("#editform").trigger("submit"); }
     */
    $("#editform").trigger("submit");
  });

  // 保存为草稿
  $("#saveDraft").click(function() {
    saveType = "011-000";
    $("#editform").trigger("submit");
  });

}

// 
function afterInitKE() {
  initData();
}

// 如果是修改
function initData() {
  var _id = getPositionId();
  if (null != _id) {
    $("#saveDraft").remove();
    editType = true;
    $.ajax({
      type : "post",
      dataType : "json",
      async : false,
      url : basePath + "/position/queryPosition",
      data : "positonId=" + _id,
      success : function(msg) {
        if (msg.success) {
          if (msg.obj) {
            // $("#saveDraft").text("保存");
            // $("#release").hide();
            setPosiData(msg.obj);

          }
        }
        needHide();
      },
      error : function(msg) {
        alert("查询职位异常！");
      }
    });
  } else {
    // getPositionCode()
    // $("#saveDraft").text("暂存");
    // $("#release").show();
  }
}

// 获取简历id
function getPositionId() {
  if (postId != null && postId != "") {
    return postId
  } else {
    return null;
  }
}

// 给职位类别选择器传初始值
function positionCategoryinit() {
  if ("" == positionSimilarName) {
    positionCategory.setValue("");
  } else {
    positionCategory.setValue(positionSimilarId + ":" + positionSimilarName);
  }
  positionCategory.num = ($(".choose-position-data li").length);
}

// 职位类别选择器关闭后调用函数
function positionCategoryClose() {
  var name = "", value = "";
  if ("" == positionCategory.selectedPositions) {
    name = "选择/修改";
  } else {
    value = positionCategory.selectedPositions.split(":")[0];
    name = positionCategory.selectedPositions.split(":")[1];
  }
  $("#positionSimilar").val(name);
  positionSimilarName = name;
  positionSimilarId = value;
  $("#positionSimilar").trigger("validate");
}

// 职位要求小界面初始化
function initPositionRequire() {
  // 将职位要求中不满足条件都选项默认选中第一项，英语条件 的选项置灰
  $(".ageScheme")[0].checked = true;
  $(".workYearScheme")[0].checked = true;
  $(".englishLevelScheme")[0].checked = true;
  $(".degreeScheme")[0].checked = true;
  $(".genderScheme")[0].checked = true;
  $(".englishLevelScheme").each(function() {
    $(this)[0].disabled = true;
  });
}

// 获取职位列表
function queryPosi() {
  var grid = mini.get("datagrid1");
  grid.load({});
}

// 弹出选择工作地点窗口
function chooseArea() {
  area.Show("workPlace");
  showAtPos('popInner', '#workPlace');
}

// 关闭选择工作地点弹窗
function closeWin(separateId) {
  $(".ac_results").remove();
  $("#areaSearch").removeClass("input-in");
  $("#areaSearch")[0].value = $("#areaSearch")[0].defaultValue;
  hideWindow("#popInner");
  $("#" + separateId).trigger("validate");
}

// 获取选中的职位相关数据
function getPositionNameData() {
  var grid = mini.get("datagrid1");
  var cell = grid.getSelected();
  if (typeof cell == 'undefined') {
    // 进行相关操作
    alert("请选中一条数据");
    return;
  } else {
    var code = cell.positionName;
    copyFlag = true;
    setPosiData(cell);
    $("#editform").validator("cleanUp");
  }
  hideWindow("positionName-choose-win");
}

// 设置职位数据
function setPosiData(d) {
  var values = {};
  $("#positionName").val(d.positionName.trim());
  var array = d.recruitObject.trim().split(",");
  array = array.concat(d.recruitType.trim().split(","));
  for (var i = 0; i < array.length; i++) {
    values[array[i]] = true;
  }
  values[d.secrecy] = true;
  $("#recruiterChoose").val(d.recruiterName);
  $("#hiddrecruiter").val(d.recruiterId);
  mini.get("trench").setValue(d.trench);
  selectCheckbox(".recruit-object", values);
  selectCheckbox(".recruit-type", values);
  selectCheckbox(".privacy", values); // radio也可以用
  setSelectValue("#positionType", d.positionType);
  //setSelectValue("#positionLevel", d.positionLevel);
  mini.get("positionLevel").setValue(d.positionLevel);
  setSelectValue("#workPlace1", d.workPlace.trim());
  positionSimilarId = d.positionSimilar.split(":")[0].trim();
  positionSimilarName = d.positionSimilar.split(":")[1].trim();
  $("#positionSimilar").val(positionSimilarName);
  $("#recruitNumbers").val(d.recruitNumbers);
  $("#websitePostName").val(d.websitePostName)
  setSelectValue("#validaty", d.validaty);
  setSelectValue("#salary", d.salary);

  $("#ageLower").val(d.ageMin);
  $("#ageUpper").val(d.ageMax);
  if (d.ageNot) {
    setRadioValue(".ageScheme", d.ageNot.trim());
  }
  $("#workYearLower").val(d.workExperienceMin);
  $("#workYearUpper").val(d.workExperienceMax);
  if (d.workExperienceNot) {
    setRadioValue(".workYearScheme", d.workExperienceNot.trim());
  }
  setSelectValue("#englishLevel", d.englishLevel);
  // setRadioValue(".englishLevelScheme",d.englishLevelNot);
  setSelectValue("#fromDegreeIdLower", d.educationMin);
  if (d.educationMax) {
    setRadioValue("#fromDegreeIdUpper", d.educationMax.trim());
  }
  $("#gender").val(d.gender);
  if (d.agenderNot) {
    setRadioValue(".genderScheme", d.agenderNot.trim());
  }
  $("#positionRequire").val(getPositionRequireDesc()).addClass("input-long");

  setSelectValue("#positionIndustry", d.positionIndustry);
  editor.html(d.positionDescription);
  editor2.html(d.positionDescription2);
  $("#deptManager").val(d.departmentManager);
  setSelectValue("#receiveEmail", d.receiveEmail);
  if (editType && !copyFlag) { // 修改
    $("#positionCode").text(d.positionCode);
  }
}

// 获取职位要求数据
function getRequireInforData() {
  return {
    "ageMin" : $("#ageLower").val(),
    "ageMax" : $("#ageUpper").val(),
    "ageNot" : getRadioValue(".ageScheme"),
    "workExperienceMin" : $("#workYearLower").val(),
    "workExperienceMax" : $("#workYearUpper").val(),
    "workExperienceNot" : getRadioValue(".workYearScheme"),
    "englishLevel" : getSelectValue("#englishLevel"),
    "englishLevelNot" : getRadioValue(".englishLevelScheme"),
    "educationMin" : getSelectValue("#fromDegreeIdLower"),
    "educationMax" : getSelectValue("#fromDegreeIdUpper"),
    "educationNot" : getRadioValue(".degreeScheme"),
    "gender" : $("#gender").val(),
    "agenderNot" : getRadioValue(".genderScheme")
  }
}

// 获取职位要求数据用于预览
function getPreviewRequireInforData() {
  return {
    age : getAgeDec(),
    workExperience : getworkExperienceDec(),
    englishLevel : (Number($("#englishLevel").val()) ? ($("#englishLevel option:selected").text() + "以上")
        : "不限"),
    education : getEducationDec(),
    gender : $("#gender option:selected").text()
  };
}

// 返回年龄的描述
function getAgeDec() {
  var a = Number($("#ageLower").val());
  var b = Number($("#ageUpper").val());
  if (!(a || b)) {
    return "不限";
  } else if (a && b) {
    return $("#ageLower option:selected").text() + "~" + $("#ageUpper option:selected").text();
  } else if (a) {
    return "大于" + $("#ageLower option:selected").text();
  } else if (b) {
    return "小于" + $("#ageUpper option:selected").text();
  } else {
    return "";
  }
}

// 返回工作经验的描述
function getworkExperienceDec() {
  var a = Number($("#workYearLower").val());
  var b = Number($("#workYearUpper").val());
  if (!(a || b)) {
    return "不限";
  } else if (a && b) {
    return $("#workYearLower option:selected").text() + "~"
        + $("#workYearUpper option:selected").text() + "年";
  } else if (a) {
    return $("#workYearLower option:selected").text() + "年以上";
  } else if (b) {
    return $("#workYearUpper option:selected").text() + "年以下";
  } else {
    return "";
  }
}

// 返回学历要求的描述
function getEducationDec() {
  var a = Number($("#fromDegreeIdLower").val());
  var b = Number($("#fromDegreeIdUpper").val());
  if (!(a || b)) {
    return "不限";
  } else if (a && b) {
    return $("#fromDegreeIdLower option:selected").text() + "~"
        + $("#fromDegreeIdUpper option:selected").text();
  } else if (a) {
    return $("#fromDegreeIdLower option:selected").text() + "以上";
  } else if (b) {
    return $("#fromDegreeIdUpper option:selected").text() + "以下";
  } else {
    return "";
  }
}

// 获取日期控件的值
function getDatePickerValue(id) {
  var t = mini.get(id);
  return t.getFormValue();
}

// 设置日期控件的值
function setDatePickerValue(id, value) {
  var t = mini.get(id);
  t.setValue(value);
}

// 获取职位的部门需求信息
function getDepartmentRequireData() {
  return {
    department : departmentChoose["#depChoose"],
    positionCode : $("#innerCode").val(),
    demandType : getSelectValue("#operateType"),
    demands : $("#depDemands").val(),
    effectDate : getDatePickerValue("effectiveDate"),
    expecDate : getDatePickerValue("expectDate")
  };
}

// 获取职位的部门需求信息 for预览
function getDepartmentRequireViewData() {
  var d = getDepartmentRequireData();
  d.demandType = $("#operateType").val();
  return d;
}

// 提交职位要求数据
function submitPRData() {
  $("#positionRequire").val(getPositionRequireDesc()).addClass("input-long");
  hideWindow("#position-requirement-win");
  $("#positionRequire").trigger("validate");
}

// 获得职位要求的描述
function getPositionRequireDesc() {
  positionRequire = "年龄:" + getAgeDec() + "; 工作经验:" + getworkExperienceDec() + "; 学历:"
      + getEducationDec() + "; 性别:" + $("#gender option:selected").text();
  return positionRequire;
}

// 获取需要新增的职位编码，后台生成
function getPositionCode() {
  $.ajax({
    type : "post",
    url : basePath + "/position/posiCode",
    dataType : "html",
    success : function(code) {
      $("#positionCode").text(code);
    }
  });

}

// 职位保存
function posiSave(fn) {
  $.ajax({
    type : "post",
    async : false,
    dataType : "json",
    data : JSON.stringify(getData()),
    url : basePath + "/position/save2?demandId=" + demandId,
    contentType : "application/json;charset=UTF-8",
    success : fn,
    error : function() {
      $(".page-loading").hide();
      alert("保存失败!");
    }
  });
}
// 获取提交数据
function getData() {
  return {
    trench : mini.get("trench").getValue(),
    recruitPositionId : getPositionId(),
    positionName : $("#positionName").val(),
    positionCode : $("#positionCode").text(),
    recruitObject : getCheckboxValue(".recruit-object"),
    recruitType : getCheckboxValue(".recruit-type"),
    positionType : getSelectValue("#positionType"),
    positionLevel : mini.get("positionLevel").getValue(),
    workPlace : getSelectValue("#workPlace1"),
    positionSimilar : positionSimilarId + ":" + positionSimilarName,
    recruitNumbers : $("#recruitNumbers").val(),
    validaty : getSelectValue("#validaty"),
    salary : getSelectValue("#salary"),
    requireInfor : getRequireInforData(),
    websitePostName : $("#websitePostName").val(),
    positionIndustry : getSelectValue("#positionIndustry"),
    positionDescription : editor.html(),
    positionDescription2 : editor2.html(),
    recruitInfor : {
      recruiter : $("#hiddrecruiter").val(),
      recruiterOther : $("#otherHiddrecruiter").val(),
      departmentManager : $("#deptManager").val(),
      receiveEmail : getSelectValue("#receiveEmail"),
      interviewEvaluateTemplate : $("#interviewTemplate").val()
    },
    secrecy : getRadioValue(".privacy"),
    status : saveType
  };
}

// 获取预览数据
function getPreviewData() {
  return {
    trench : mini.get("trench").getValue(),
    websitePostName : $("#websitePostName").val(),
    positionName : $("#positionName").val(),
    positionCode : $("#positionCode").text(),
    recruitPerson : $("#recruiterChoose").val(),
    otherRecruitPerson : $("#otherRecruiter").val(),
    deptManager : $("#deptManager").val(),
    recruitObject : getCheckboxText(".recruit-object"),
    recruitType : getCheckboxText(".recruit-type"),
    positionType : $("#positionType option:selected").text(),
    positionLevel : mini.get("positionLevel").getValue(),
    workPlace : $("#workPlace1 option:selected").text(),
    positionSimilar : positionSimilarName,
    recruitNumbers : $("#recruitNumbers").val(),
    publisher : $(".user-name").text(),
    validaty : $("#validaty option:selected").text(),
    publishDate : new Date().format("yyyy-MM-dd"),
    salary : $("#salary option:selected").text(),
    requireInfor : getPreviewRequireInforData(),
    positionIndustry : $("#positionIndustry option:selected").text(),
    positionDescription : editor.html(),
    positionDescription2 : editor2.html(),
    recruitInfor : {
      receiveEmail : $("#receiveEmail option:selected").text(),
      interviewEvaluateTemplate : $("#interviewTemplate option:selected").text()
    },
    secrecy : getRadioText(".privacy")
  };
}

// 获取一组checkbox的选中值,返回逗号分隔的字符串
function getCheckboxValue(Class) {
  var i = 0, s = [];
  $(Class).each(function() {
    if ($(this)[0].checked) {
      s[i++] = $(this).val();
    }
  });
  return s.join(",");
}

function getCheckboxText(Class) {
  var i = 0, s = [];
  $(Class).each(function() {
    if ($(this)[0].checked) {
      s[i++] = $(this).next().text();
    }
  });
  return s.join(",");
}

// 获取一组radio中的选中值
function getRadioValue(Class) {
  var s;
  $(Class).each(function() {
    if ($(this)[0].checked) {
      s = $(this).val();
    }
  });
  return s;
}

// 获取一组radio中的选中的label值
function getRadioText(Class) {
  var s;
  $(Class).each(function() {
    if ($(this)[0].checked) {
      s = $(this).next().text();
    }
  });
  return s;
}

// 设置一组radio的选中状态
function setRadioValue(Class, value) {
  $(Class).each(function() {
    if ($(this).attr("value") == value) {
      this.checked = true;
    }
  });
}

// 获取select选中的值
function getSelectValue(Id) {
  return $(Id).find("option[value='" + $(Id).val() + "']").attr("id");
}

// 选中下拉列表中的某一项
function setSelectValue(id, value) {
  $(id).find("option[text='" + value + "']").attr("selected", true);
}

// 设置一组checkbox中的选中状态
function selectCheckbox(Class, values) {
  $(Class).each(function() {
    if (values[$(this).next().text()]) {
      $(this)[0].checked = true;
    }
  });
}

function ondrawcell(e) {
  switch (e.field) {
  case "releaseDate":
    if (e.row.releaseDate != null) {
      e.cellHtml = new Date(e.row.releaseDate).format("yyyy-MM-dd");
    }
  }
}

// 获取新增部门的数据
function getOrgData() {
  return {
    orgName : $("#orgName").val(),
    linkman : $("#orglinkman")[0].linkman,
    orgParent : departmentChoose["#orgParentForAdd"],
    tel : $("#orgAddTel").val(),
    email : $("#orgAddEmail").val()
  };
}

// 获取新增账号的数据
function getAccountData() {
  return {
    account : $("#account").val(),
    name : $("#name").val(),
    status : ($("#accountStatu")[0].checked ? "1" : "0"),
    tel : $("#accountTel").val(),
    cellphone : $("#cellphone").val(),
    depId : departmentChoose["#recruit-assistant-dept"],
    roleId : $("#roleOperate").val()
  };
}

// 创建部门
function addOrg(fn) {
  $.ajax({
    type : "post",
    dataType : "json",
    data : JSON.stringify(getOrgData()),
    url : basePath + "/org/save",
    contentType : "application/json;charset=UTF-8",
    success : fn,
    error : function() {
      alert("保存失败!");
    }
  });
}

// 新增账号
function addAccount(fn) {
  $.ajax({
    type : "post",
    dataType : "json",
    data : JSON.stringify(getAccountData()),
    url : basePath + "/baseUserController/save",
    contentType : "application/json;charset=UTF-8",
    success : fn,
    error : function() {
      alert("新增失败!");
    }
  });
}

// 清除验证
function cleanValidator(id) {
  $(id)[0].reset();
  $(id).validator("cleanUp");
}

$("#editform")
    .validator(
        {
          theme : "simple_right",
          msgClass : "n-right ",
          rules : {
            selectVoid : function(e, p, f) {
              if (Number($(e).val())) {
                return true;
              } else {
                return false;
              }
            },
            workPlaceVoid : function(e, p, f) {
              if ($(e).val() == "0") {
                return false;
              } else {
                return true;
              }
            },
            positionSimilarVoid : function(e) {
              if ($(e).val() == "选择/修改") {
                return false;
              } else {
                return true;
              }
            },
            depVoid : function(e) {
              if ($(e).val() == "请选择部门") {
                return false;
              } else {
                return true;
              }
            },
            recruiterVoid : function(e) {
              if ($(e).val() == "请选择招聘专员") {
                return false;
              } else {
                return true;
              }
            }
          },
          fields : {
            "#websitePostName" : {
              rule : "岗位发布名称:required;length[~100]",
              msgStyle : "position:absolute;left:100%;"
            },
            "#positionName" : {
              rule : "职位名称:required;length[~100]",
              msgStyle : "position:absolute;left:100%;"
            },
            "recruitObject" : {
              rule : "checked;",
              msg : "请选择招聘对象"
            },
            "recruitType" : {
              rule : "checked;",
              msg : "请选择招聘类别"
            },
            "#positionType" : {
              rule : "selectVoid",
              msg : "请选择职能类别",
              msgStyle : "position:absolute;right:170px;"
            },
            "#workPlace1" : {
              rule : "workPlaceVoid",
              msg : "请选择工作地点",
              msgStyle : "position:absolute;right:170px;"
            },
            "#positionSimilar" : {
              rule : "positionSimilarVoid",
              msg : "请选择职位类别",
              msgStyle : "position:absolute;right:170px;"
            },
            "#recruitNumbers" : {
              rule : "招聘人数:required;integer[*];range[0~999]",
              msgStyle : "position:absolute;right:70px;"
            },
            "#positionRequire" : {
              rule : "positionSimilarVoid",
              msg : "请选择职位要求",
              msgStyle : "position:absolute;right:170px;"
            },
            "#positionIndustry" : {
              rule : "selectVoid",
              msg : "请选择行业",
              msgStyle : "position:absolute;right:110px;"
            },
            "#recruiterChoose" : {
              rule : "recruiterVoid",
              msg : "请选择招聘专员",
              msgStyle : "position:absolute;right:200px;"
            },
            "privacy" : {
              rule : "checked;",
              msg : "请选择"
            }
          },
          valid : function(form) {
            var me = this;
            me.holdSubmit();
            // $(".page-loading").show();
            if (saveType == "011-002") { // 去发布
              // $("#release").addClass("submiting");
              // 下一步指令预览
              OpenDialog(basePath + "/postWebsite/instructPreview/" + demandIdPostId
                  + "?websiteTypes=" + mini.get("trench").getValue(), "确认指令列表", null, 700, 500,
                  function(action, e) {
                    if (action == "ok") {
                      posiSave(fabu);
                    }
                    me.holdSubmit(false);
                  });
              $("#saveDraft").remove();
            } else { // 保存为草稿
              $("#saveDraft").addClass("submiting");
              posiSave(function(msg) {
                if (msg.success) {
                  $("#saveDraft").removeClass("submiting");
                  $(".page-loading").hide();
                  mini
                      .showTips({
                        content : "<span class='font-icon icon_ok'></span><span class='success-text'>保存成功</span>",
                        state : "success",
                        x : "center",
                        y : "center",
                        timeout : 3000
                      });
                  // alert("新增成功");
                  // window.location.href = basePath + "/position/positionMana";
                } else {
                  $("#saveDraft").removeClass("submiting");
                  $(".page-loading").hide();
                  mini
                      .showTips({
                        content : "<span class='font-icon icon_ok'></span><span class='success-text'>保存成功</span>",
                        state : "warning",
                        x : "center",
                        y : "center",
                        timeout : 3000
                      });
                }
                me.holdSubmit(false);
              });
            }
          }
        });

// 新增部门时的验证
$("#orgAddForm").validator({
  theme : "simple_right",
  msgClass : "n-right ",
  fields : {
    "#orgName" : {
      rule : "required;length[~32]"
    },
    "#orglinkman" : "length[~32]",
    "#orgAddTel" : "length[~32]",
    "#orgAddEmail" : {
      rule : "email;length[~64]",
    }
  },
  valid : function(form) {
    var me = this;
    me.holdSubmit();
    addOrg(function(msg) {
      hideWindow('department-win');
      mini.showTips({
        content : "<span class='font-icon icon_ok'></span><span class='success-text'>新建成功</span>",
        state : "warning",
        x : "center",
        y : "center",
        timeout : 3000
      });
      me.holdSubmit(false);
    });
  }
});

// 发布 回调函数
function fabu(msg) {
  if (msg.success) {
    $("#release").removeClass("submiting");
    $(".page-loading").hide();
    mini.showTips({
      content : "<span class='font-icon icon_ok'></span><span class='success-text'>保存成功</span>",
      state : "success",
      x : "center",
      y : "center",
      timeout : 3000
    });
    // window.location.href = basePath + "/position/positionMana";
  } else {
    $("#release").removeClass("submiting");
    $(".page-loading").hide();
    mini.showTips({
      content : "<span class='font-icon icon_ok'></span><span class='success-text'>保存成功</span>",
      state : "warning",
      x : "center",
      y : "center",
      timeout : 3000
    });
  }
  // me.holdSubmit(false);
}
// 新增账号的验证
$("#accountAddForm")
    .validator(
        {
          theme : "simple_right",
          msgClass : "n-right ",
          rules : {
            telVoid : function(e) {
              if ($("#accountTel").val() == "") {
                return true;
              } else {
                return false;
              }
            }
          },
          fields : {
            "#account" : {
              rule : "required;length[~32]"
            },
            "#name" : "required;length[~32]",
            "#accountTel" : "tel",
            "#cellphone" : {
              rule : "required(telVoid);mobile",
              msg : {
                required : "联系电话或手机<font color='red'>必须填写其中之一</font>"
              },
              msgStyle : "margin-top:-5px;",
              target : "#cellphoneMsg"
            }
          },
          valid : function(form) {
            var me = this;
            me.holdSubmit();
            addAccount(function(msg) {
              if (msg.success) {
                mini
                    .showTips({
                      content : "<span class='font-icon icon_ok'></span><span class='success-text'>新建成功</span>",
                      state : "success",
                      x : "center",
                      y : "center",
                      timeout : 3000
                    });
                me.holdSubmit(false);
                hideWindow('recruit-assistant-win');
              } else {
                mini.showTips({
                  content : "<span class='font-icon icon_error'></span><span class='success-text'>"
                      + msg.msg + "</span>",
                  state : "danger",
                  x : "center",
                  y : "center",
                  timeout : 3000
                });
                me.holdSubmit(false);
              }
            });
          }
        });

function queryRole() {
  $.ajax({
    type : "post",
    dataType : "json",
    url : basePath + "/baseRoleController/getAllRole",
    success : function(data) {
      var d;
      for (var i = 0; i < data.data.length; i++) {
        if (data.data[i].name != "") {
          d += "<option value='" + data.data[i].id + "'>" + data.data[i].name + "</option>";
        }
      }
      $("#roleOperate").append(d);
    },
    error : function() {
      alert("失败!");
    }
  });
}

function queryTemplete() {
  $.ajax({
    type : "post",
    dataType : "json",
    url : basePath + "/templateController/queryTempleteByType?type=1",
    success : function(data) {
      if (data.msg == "success") {
        var d;
        for (var i = 0; i < data.obj.length; i++) {
          if (data.obj[i].title != "") {
            d += "<option value='" + data.obj[i].id + "'>" + data.obj[i].title + "</option>";
          }
        }
        $("#interviewTemplate").append(d);
      }
    }
  });
}
