param = new Object();
tabState = "0";
// 头部状态过滤数据
function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  tabState = state;
  search();
}
function comboxChange(e) {
  if (e.value == null || e.value == "") {
    search();
  }
}
function onDrawDate(e) {
  var date = e.date;
  var d = new Date();

  if (date.getTime() < d.getTime()) {
      e.allowSelect = false;
  }
}

function onCloseClick(e) {
  var obj = e.sender;
  obj.setText("全部");
  obj.setValue("");
}

// 条件查询
function search() {
  var grid = mini.get("datagrid1");
  param = new Object();
  param.postName = mini.get("postName").getValue();
  param.stateSelf = tabState;
  param.rankId = mini.get("rankId").getValue();
  param.flowState = mini.get("flowState").getValue();
  param.isShare = mini.get("isShare").getValue();
  param.startDistributeDate = mini.get("startDistributeDate").getText();
  param.endDistributeDate = mini.get("endDistributeDate").getText();
  param.orgCode = mini.get("orgCode").getValue();
  grid.load(param);
}

// 导出招聘需求列表
function exportDemand() {
  window.location.href = "/recruit/demand/exportDemand?postName=" + mini.get("postName").getValue()
      + "&stateSelf=" + tabState + "&rankId=" + mini.get("rankId").getValue();
}

// 渲染列表数据
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  if (field == "flowDate" && row.flowDate != null) {
    // 修改时间格式化
    e.cellHtml = new Date(row.flowDate).format("yyyy-MM-dd");
  }
  if (field == "predictComeDate" && row.predictComeDate != null) {
    // 修改时间格式化
    var predictComeDate = new Date(row.predictComeDate);
    var nowDate = new Date();
    var date = dateAdd(nowDate, "day", 15);
    if (nowDate > predictComeDate) { // 到期红色
      e.cellHtml = "<span style='color:red;'>" + row.predictComeDate + "</span>";
    } else if (date > predictComeDate) { // 预计到岗时间与当前时间相差小于15天 橙色
      e.cellHtml = "<span style='color:orange;'>" + row.predictComeDate + "</span>";
    } else {
      e.cellHtml = row.predictComeDate;
    }

  }

}
// 共承岗位
function sharePost() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    SaveData(basePath + "/recruitDemandShareController/checkShare/" + id, param, function(e) {
      if (e.success) {
        OpenDialog(basePath + "/demand/share?id=" + id, "共承岗位", grid, 700, 500);
      } else {
        mini.alert(e.msg);
      }
    });
  } else {
    ShowWarnTip("请选择一条记录");
  }
}
// 取消共承岗位
function cancelSharePost() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    SaveData(basePath + "/recruitDemandShareController/checkShare/" + id, param,
        function(e) {
          if (e.success) {
            SaveData(basePath + "/recruitDemandShareController/removeShare/" + id, param,
                sharePostCall);
          } else {
            mini.alert(e.msg);
          }
        });
  } else {
    ShowWarnTip("请选择一条记录");
  }
}
function sharePostCall(e) {
  if (e.success) {
    grid.reload();
    ShowSuccessTip(e.msg);
  } else {
    mini.alert(e.msg);
  }
}

// 修改招聘需求信息
function updateRecruitDemand() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    if (row.isFinish != "1") {
      ShowWarnTip("请选择未完成的招聘需求");
    } else {
      openUpdateView(id);
    }
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

// 修改招聘需求信息-经理人
function updateRecruitDemandByHandler() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    openUpdateViewByHandler(id);
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

// 发布岗位
function applyPost() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    if (row.flowState != "4") {
      ShowWarnTip("请选择审批通过的招聘需求");
    } else if (row.isFinish != "1") {
      ShowWarnTip("请选择未完成的招聘需求");
    } else {
      window.open(basePath + "/position/positionEditByDemand/" + id)
    }
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

// 打开修改页面
function openUpdateView(id) {
  var grid = mini.get("datagrid1");
  OpenDialog(basePath + "/demand/modify/" + id, "招聘需求修改", grid, 960, 710);
}

// 打开修改页面
function openUpdateViewByHandler(id) {
  var grid = mini.get("datagrid1");
  OpenDialog(basePath + "/demand/modifyByHandler/" + id, "招聘需求修改", grid, 960, 710);
}

// 打开新增需求页面
function addRecruitDemand() {
  var grid = mini.get("datagrid1");
  OpenDialog(basePath + "/demand/create", "招聘需求申请", grid, 900, 710);
}

function onKeyEnter(e) {
  search();
}
// 为数据添加超链接
function cellclick(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 岗位名称
  if (field == "applyPostName") {
    if (isHandler) {
      openUpdateViewByHandler(row.id);
    } else {
      openUpdateView(row.id);
    }
  }
  if (field == "logNum") {
    // 查看该需求的变更记录
    OpenDialog(basePath + "/recruitDemandLogController/list?id=" + row.id, "查看需求变更记录列表", null, 800,
        410);
  }
  if (field == "changeNum") {
    // 查看该需求的变更记录
    OpenDialog(basePath + "/recruitDemandChangeControllerLogin/list?id=" + row.id, "查看需求变更审批记录列表", null, 800,
        410);
  }
}

// 流程状态字典
var flowState = [ {
  id : 1,
  text : '草稿'
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
// 招聘状态字典
var infoState = [ {
  id : 1,
  text : '未发布'
}, {
  id : 2,
  text : '待发布'
}, {
  id : 3,
  text : '已发布'
} ];

// 招聘状态渲染
function onInfoStateRenderer(e) {
  for (var i = 0, l = infoState.length; i < l; i++) {
    var g = infoState[i];
    if (g.id == e.value)
      return g.text;
  }
  return "";
}


//需求状态
var isFinish = [ {
  id : 1,
  text : '未完成'
}, {
  id : 2,
  text : '已完成'
}, {
  id : 3,
  text : '取消'
} ];

//需求状态
function onIsFinishRenderer(e) {
  for (var i = 0, l = isFinish.length; i < l; i++) {
    var g = isFinish[i];
    if (g.id == e.value)
      return g.text;
  }
  return "";
}
