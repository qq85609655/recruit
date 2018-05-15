param = new Object();
// 头部状态过滤数据
function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  tabState = state;
  search();
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
// 招聘状态字典
var infoState = [ {
  id : 1,
  text : '草稿'
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

function onOk() {
  CloseWindow("ok");
}
function onCancel() {
  CloseWindow("cancel");
}


function GetPositionData() {
  var rows = grid.getSelecteds();
  if(rows.length == 1){
    var data = {};
    data.id = rows[0].applyPostId;
    data.text = rows[0].applyPostName;
    return data ;
  }else{
    showWarnTip("请选择一条记录");
  }
  
  return null;
}
