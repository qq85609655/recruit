param = new Object();
tabState = "0";
// 条件查询
function search() {
  param = new Object();
  param.state = mini.get("state").getValue();
  param.candidateName = $("#candidateName").val();
  param.inReason = $("#inReasonStr").val();
  param.outReason = $("#outReasonStr").val();
  grid.load(param);
}

function onKeyEnter(e) {
  search();
}

function outBlacklist() {
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var id = row.id;
    if (row.state == "2") {
      ShowWarnTip("请选择一条生效的记录");
      return;
    }
    var candidateName = row.candidateName;
    mini.prompt("候选人：" + candidateName + "<br>原因：", "撤销黑名单", function(action, value) {
      if (action == "ok") {
        var paramSave = new Object();
        paramSave.id = id;
        paramSave.outReason = value;
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
// 流程状态字典
var state = [ {
  id : 1,
  text : '生效'
}, {
  id : 2,
  text : '未生效'
} ];

// 渲染列表数据
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  if (field == "state" && row.state != null) {
    e.cellHtml = "";
    for (var i = 0, l = state.length; i < l; i++) {
      var g = state[i];
      if (g.id == row.state) {
        e.cellHtml = g.text;
      }
    }
  }
}
