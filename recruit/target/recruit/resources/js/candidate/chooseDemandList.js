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
  var rows = grid.getSelecteds();
  if(oldPositionId == rows[0].applyPostId){
    mini.alert("不能转向同一个岗位！");
    return ;
  }
  if(rows.length == 1){
    var ajaxRe="";
    $.ajax({ 
      type: "post", 
      dataType: "json", 
      data:{
        candidateId:candidateId,
        applyPostId:rows[0].applyPostId,
        oldPositionId:oldPositionId
      },
      url: basePath + "/candidateController/changePosition", 
      success: function(data) { 
        CloseWindow(data.msg);
      }, 
      error: function() { 
        CloseWindow("网络异常！");
      }
  });
  }else{
    showWarnTip("请选择一条记录");
  }
  
}
function onCancel() {
  CloseWindow("cancel");
}

function GetDemandData() {
  var rows = grid.getSelecteds();
  if(oldPositionId == rows[0].applyPostId){
    mini.alert("不能转向同一个岗位！");
    return ;
  }
  if(rows.length == 1){
    var ajaxRe="";
    $.ajax({ 
      type: "post", 
      dataType: "json", 
      async:false ,
      data:{
        candidateId:candidateId,
        applyPostId:rows[0].applyPostId,
        oldPositionId:oldPositionId
      },
      url: basePath + "/candidateController/changePosition", 
      success: function(data) { 
        ajaxRe=data.msg ;
      }, 
      error: function() { 
        mini.alert("网络异常！");
      }
  });
  }else{
    showWarnTip("请选择一条记录");
  }
  
  return ajaxRe;
}
