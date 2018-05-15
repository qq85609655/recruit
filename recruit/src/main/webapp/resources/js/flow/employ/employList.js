param = new Object();
tabState = "0";

// 添加标签
function addTag() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var candidateId = row.candidateId;
    TagPage.init({
      resumeId : candidateId
    });
    getBasicInfor();
    showAtPos('tagSelectWin', '#detail-button1');
  } else {
    ShowWarnTip("请选择一条记录");
    return false;
  }

};

// 形成基本信息
function getBasicInfor() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var candidateId = row.candidateId;
    $.ajax({
      url : basePath + "/candidateController/queryLabelList/" + candidateId,
      dataType : "json",
      typ : "post",
      success : function(data) {
        $("#tagSelected .tag-a").remove();
        var d = data.labelList;
        for (var i = 0; i < d.length; i++) {
          str = '<a class="tag-a radius" pid="' + d[i].categoryId + '" id="tag-' + d[i].id
              + '"><span class="tag-a-add"></span>' + d[i].name + '</a>'
          $("#tagSelected").append(str);
          $(".tag-li #tag-" + d[i].id).remove();
        }
      },
      error : function() {
        console.log("获取标签异常!");
      }
    });
  } else {
    ShowWarnTip("请选择一条记录");
    return false;
  }

}

// 发送消息
function sentMessage() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var candidateId = row.candidateId;
    OpenDialog(webRoot + "/employ/sendByDefinition?candidateId=" + candidateId, "自定义发送邮件", "", 780,
        660);
  } else {
    ShowWarnTip("请选择一条记录");
  }

}

// 提醒
function remind() {
  OpenDialog(webRoot + "/remind/create", "日程提醒", "", 580, 360);
}

// 列入黑名单
function inBlacklist() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    var candidateName = row.candidateName;
    mini.prompt("候选人：" + candidateName + "<br>原因：", "列入黑名单", function(action, value) {
      if (action == "ok") {
        var paramSave = new Object();
        paramSave.candidateName = candidateName;
        paramSave.candidateId = row.candidateId;
        paramSave.inReason = value;
        SaveData("/recruit/employBlacklistController/save", paramSave, function(e) {
          if (e.success) {
            ShowSuccessTip(e.msg)
            grid.reload();
          } else {
            ShowWarnTip(e.msg);
          }
        });
      } else {
        // alert("取消");
      }
    }, true);
  } else {
    ShowWarnTip("请选择一条记录");
  }
}
// 头部状态过滤数据
function choseState(state, e) {

  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  if (state == "0") {
    location.href = "/recruit/employ/list";
  } else if (state == "1") {
    location.href = "/recruit/employ/offerList";
  } else if (state == "2") {
    location.href = "/recruit/employ/refuseOfferList";
  } else if (state == "3") {
    location.href = "/recruit/employ/entryList";
  } else if (state == "4") {
    location.href = "/recruit/employ/refuseEntryList";
  }
}

// 条件查询
function search() {
  var grid = mini.get("datagrid1");
  param = new Object();
  param.candidateName = $("#candidateName").val();
  param.postName = $("#postName").val();
  grid.load(param);
}

// 打开录用申请页面
function editEmploy() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    location.href = basePath + "/employ/modify/" + id;
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

function onKeyEnter(e) {
  search();
}
// 为数据添加超链接
function cellclick(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 岗位名称
  if (field == "applyPostName") {
    openUpdateView(row.id);
  }
  if (field == "logNum") {
    // 查看该需求的变更记录
    OpenDialog(basePath + "/recruitDemandLogController/list?id=" + row.id, "查看需求变更记录列表", null, 800,
        410);
  }
}

// 流程状态字典
var flowState = [ {
  id : 1,
  text : '未提交'
}, {
  id : 2,
  text : '审核中'
}, {
  id : 3,
  text : '废弃'
}, {
  id : 4,
  text : '审核通过'
} ];

// 流程状态渲染
function onFlowStateRenderer(e) {
  for (var i = 0, l = flowState.length; i < l; i++) {
    var g = flowState[i];
    if (g.id == e.value)
      return g.text;
  }
  return "";
}

// 渲染列表数据
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  if (field == "offerDate" && row.offerDate != null) {
    // 修改时间格式化
    e.cellHtml = new Date(row.offerDate).format("yyyy-MM-dd hh:mm");
  }
  if (field == "refuseReason") {
    e.cellHtml = "<span onclick=showRefuseReason('" + row.id + "')>查看</span>";
  }
  if (field == "state" && row.state != null) {
    e.cellHtml = "";
    for (var i = 0, l = state.length; i < l; i++) {
      var g = state[i];
      if (g.id == row.state) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "interviewForm") {
    e.cellHtml = "";
    if (row.employmentForm != null && row.employmentForm != "") {
      e.cellHtml = "<span class='color-blue curpo' onclick=showEmploymentForm('"
          + row.employmentForm + "')>查看</span>";
    }
  }
}
// 查看应聘申请表
function showEmploymentForm(employmentForm) {
  window.open("/recruit/interviewController/editInfo?personCode=" + employmentForm);
}
// 招聘状态字典
var stage = [ {
  id : 1,
  text : '录用'
}, {
  id : 2,
  text : '已发offer'
}, {
  id : 3,
  text : '拒offer'
}, {
  id : 4,
  text : '入职'
}, {
  id : 5,
  text : '放弃入职'
} ];

// 招聘状态渲染
function onStageRenderer(e) {
  for (var i = 0, l = stage.length; i < l; i++) {
    var g = stage[i];
    if (g.id == e.value)
      return g.text;
  }
  return "";
}

// 删除录用信息
function delEmploy() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    var ids = new Array();
    var canDeal = false;
    for (var i = 0; i < rows.length; i++) {
      ids.push(rows[i].id);
      if (rows[i].flowState == "1") { // 判断有没有选择草稿状态的录用记录
        canDeal = true;
      }
    }
    if (canDeal) {
      SaveData("/recruit/employ/remove/" + ids.join(","), null, function(e) {
        if (e.success) {
          ShowSuccessTip(e.msg)
          grid.reload();
        } else {
          ShowWarnTip(e.msg);
        }
      });
    } else {
      ShowWarnTip("请至少选择一条草稿状态的录用记录！");
    }
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}

// 发offer
function sentOffer() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    var ids = new Array();
    var canOffer = true;
    var discard = false;
    for (var i = 0; i < rows.length; i++) {
      ids.push(rows[i].id);
      if (rows[i].demandId == null || rows[i].demandId == "") {
        canOffer = false;
      }
      if (rows[i].flowState == "3") {
        discard = true;
      }
    }
    if (canOffer) {
      if (discard) {
        ShowWarnTip("操作失败，不能选择已经废弃的录用记录！");
      } else {
        SaveData("/recruit/employ/sentOffer/" + ids.join(","), null, function(e) {
          if (e.success) {
            ShowSuccessTip(e.msg)
            grid.reload();
          } else {
            ShowWarnTip(e.msg);
          }
        });
      }
    } else {
      ShowWarnTip("操作失败，不能选择没有设定招聘需求的录用记录，请完善信息！");
    }
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}
// 入职
function entry() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    var ids = new Array();
    var canEntry = false;
    for (var i = 0; i < rows.length; i++) {
      ids.push(rows[i].id);
      if (rows[i].flowState != "4") {
        canEntry = true;
      }
    }
    if (canEntry) {
      ShowWarnTip("操作失败，不能选择没有审批通过的录用记录！");
    } else {
      SaveData("/recruit/employ/doentry/" + ids.join(","), null, function(e) {
        if (e.success) {
          ShowSuccessTip(e.msg)
          grid.reload();
        } else {
          ShowWarnTip(e.msg);
        }
      });
    }
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}
// 面试评估
function estimateEdit() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    var candidateId = rows[0].candidateId;
    var employPostId = rows[0].employPostId;
    window.open(basePath + "/estimateController/estimateEdit?candidateId=" + candidateId
        + "&positionId=" + employPostId + "&type=HR");
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}
// 拒绝offer
function refuseOffer() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    if (rows[0].flowState == "3") {
      ShowWarnTip("无法操作已经废弃的录用记录！");
    } else {
      showRefuseReason(id);
    }
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}
// 放弃入职
function refuseEntry() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    if (rows[0].flowState == "3") {
      ShowWarnTip("无法操作已经废弃的录用记录！");
    } else {
      showRefuseEntry(id);
    }
  } else {
    ShowWarnTip("请至少选择一条录用记录！");
  }
}
// 打开拒绝offer页面
function showRefuseReason(id) {
  var grid = mini.get("datagrid1");
  OpenDialog(basePath + "/employ/refuseOffer/" + id, "拒绝offer原因", grid, 800, 420);
}
// 打开放弃入职页面
function showRefuseEntry(id) {
  var grid = mini.get("datagrid1");
  OpenDialog(basePath + "/employ/refuseEntry/" + id, "放弃入职", grid, 800, 420);
}
// 批量解锁
function unlocked() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
      ids += rows[i].candidateId;
      if (i != rows.length - 1) {
        ids += ",";
      }
      $.ajax({
        url : basePath + "/candidateController/unlockCandidate",
        type : "post",
        data : {
          ids : ids
        },
        dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
        success : function(data) {
          mini.alert(data.msg);
          grid.reload();
        }
      });
    }

  } else {
    alert("请先选中候选人！");
  }

}
