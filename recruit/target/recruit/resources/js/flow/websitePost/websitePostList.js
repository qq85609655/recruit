param = new Object();
// 头部状态过滤数据
tabState = "";
function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  tabState = state;
  search();
}

// 导出全部日程
function exportData() {
  window.location.href = "/recruit/postWebsiteLog/exportInstuctLog";
}

// 导出岗位网站一览
function exportData1() {
  window.location.href = "/recruit/postWebsite/exportWebsiteList";
}
function search() {
  var grid = mini.get("datagrid1");
  param = new Object();
  param.tabState = tabState;
  param.state = mini.get("state").getValue();
  param.instructType = mini.get("instructType").getValue();
  param.postNameStr = mini.get("postNameStr").getValue();
  param.webpostName = mini.get("webpostName").getValue();
  grid.load(param);
}

function onKeyEnter(e) {
  search();
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
} , {
  id : 5,
  text : '删除并且重新发布'
}, {
  id : 6,
  text : '删除'
}];
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
  if (field == "instructDate" && row.instructDate != null) {
    // 修改时间格式化
    e.cellHtml = new Date(row.instructDate).format("yyyy-MM-dd hh:mm");
  }
  if (field == "postInfo") {
    e.cellHtml = "<span onclick=showChange('" + row.postId + "')>查看</span>";
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
  if (field == "beforeState" && row.beforeState != null) {
    e.cellHtml = "";
    for (var i = 0, l = state.length; i < l; i++) {
      var g = state[i];
      if (g.id == row.beforeState) {
        e.cellHtml = g.text;
      }
    }
  }
  if (field == "lastInstruct" && row.lastInstruct != null) {
    e.cellHtml = "";
    for (var i = 0, l = instructType.length; i < l; i++) {
      var g = instructType[i];
      if (g.id == row.lastInstruct) {
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

}
function showChange(postId) {
  // window.open(basePath + "/position/postInfo/" + postId)
  OpenDialog(basePath + "/position/postInfo/" + postId, "查看岗位详细信息", null, 800, 510);
}