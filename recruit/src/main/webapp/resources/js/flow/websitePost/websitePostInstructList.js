param = new Object();
// 头部状态过滤数据
tabState = "";

function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  tabState = state;
  search();
}

// 导出指令列表
function exportData() {
  window.location.href = "/recruit/instruct/exportInstruct?tabState=" + tabState + "&bState="
      + mini.get("bState").getValue() + "&aState=" + mini.get("aState").getValue()
      + "&instructType=" + mini.get("instructType").getValue() + "&isDeal="
      + mini.get("isDeal").getValue() + "&postNameStr=" + $("#postNameStr").val() + "&webpostName="
      + $("#webpostName").val();
}
function search() {
  var grid = mini.get("datagrid1");
  param = new Object();
  param.tabState = tabState;
  param.bState = mini.get("bState").getValue();
  param.aState = mini.get("aState").getValue();
  param.instructType = mini.get("instructType").getValue();
  param.isDeal = mini.get("isDeal").getValue();
  param.postNameStr = mini.get("postNameStr").getValue();
  param.webpostName = mini.get("webpostName").getValue();
  grid.load(param);
}

function onKeyEnter(e) {
  search();
}
// 完成指令操作
function dealInstruct() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var id = rows[0].id;
    var ids = new Array();
    var canDeal = false;
    for (var i = 0; i < rows.length; i++) {
      ids.push(rows[i].id);
      if (rows[i].isDeal == "2") { // 判断有没有选择未完成的指令
        canDeal = true;
      }
    }
    if (canDeal) {
      mini.confirm("已经选择"+ids.length+"条指令", "确定操作?", function(action) {
        if (action == "ok") {
          SaveData("/recruit/instruct/changeInstructState/" + ids.join(","), null, function(e) {
            if (e.success) {
              ShowSuccessTip(e.msg)
              grid.reload();
            } else {
              ShowWarnTip(e.msg);
            }
          });
        }
      });
      
    } else {
      ShowWarnTip("请至少选择一条未操作的指令！");
    }
  } else {
    ShowWarnTip("请至少选择一条指令！");
  }
}
// 状态字典
var state = [ {
  id : 3,
  text : '未发布'
}, {
  id : 1,
  text : '发布中'
}, {
  id : 2,
  text : '暂停'
}, {
  id : 4,
  text : '删除'
} ];
// 操作类型字典
var instructType = [ {
  id : 1,
  text : '发布'
}, {
  id : 2,
  text : '修改'
}, {
  id : 3,
  text : '暂停'
}, {
  id : 4,
  text : '重启'
}, {
  id : 5,
  text : '删除并且重新发布'
}, {
  id : 6,
  text : '删除'
} ];
// 操作状态字典
var deal = [ {
  id : 1,
  text : '已操作'
}, {
  id : 2,
  text : '未操作'
} ];
// 渠道字典
var websiteType = [ {
  id : 1,
  text : '前程无忧网'
}, {
  id : 2,
  text : '智联'
}, {
  id : 3,
  text : '猎聘网'
}, {
  id : 4,
  text : '人才热线'
}, {
  id : 5,
  text : '华星官网'
}, {
  id : 6,
  text : '荐客'
}, {
  id : 7,
  text : '58'
}, {
  id : 8,
  text : '赶集网'
} ];

// 渲染列表数据
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  if (field == "createDate" && row.createDate != null) {
    // 修改时间格式化
    e.cellHtml = new Date(row.createDate).format("yyyy-MM-dd");
  }
  if (field == "beforeState" && row.beforeState != null) {
    e.cellHtml = "";
    for (var i = 0, l = state.length; i < l; i++) {
      var g = state[i];
      if (g.id == row.beforeState) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "afterState" && row.afterState != null) {
    var dealState=row.afterState;
    if(row.isDeal=="2"||row.isDeal=="2"){
      dealState=row.beforeState; //未操作显示操作前状态
    }
    e.cellHtml = "";
    for (var i = 0, l = state.length; i < l; i++) {
      var g = state[i];
      if (g.id == dealState) {
        e.cellHtml = g.text;
      }
    }
  }

  if (field == "instructType" && row.instructType != null) {
    e.cellHtml = "";
    for (var i = 0, l = instructType.length; i < l; i++) {
      var g = instructType[i];
      if (g.id == row.instructType) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "isDeal" && row.isDeal != null) {
    e.cellHtml = "";
    for (var i = 0, l = deal.length; i < l; i++) {
      var g = deal[i];
      if (g.id == row.isDeal) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "websiteType" && row.websiteType != null) {
    e.cellHtml = "";
    for (var i = 0, l = websiteType.length; i < l; i++) {
      var g = websiteType[i];
      if (g.id == row.websiteType) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "change") {
    e.cellHtml = "";
    if (row.instructType == "2") {
      e.cellHtml = "<span onclick=showChange('" + row.postId + "')>查看</span>";
    }
  }
  
  if (field == "postName") {
    e.cellHtml = "<span onclick=showInfo('" + row.postId + "')>"+row.postName+"</span>";
  }

}

function showChange(postId) {
  OpenDialog(basePath + "/position/showChange/" + postId, "查看岗位修改点", null, 800, 510);
}
function showInfo(postId) {
  // window.open(basePath + "/position/postInfo/" + postId)
  OpenDialog(basePath + "/position/postInfo/" + postId, "查看岗位详细信息", null, 800, 510);
}