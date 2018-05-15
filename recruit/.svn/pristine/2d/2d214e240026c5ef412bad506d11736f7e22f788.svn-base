mini.parse();
var grid = mini.get("accountDatagrid");
grid.load({
  
});
removeLoad();

function queryUserList(){
  var account = $("#txtAccount").val();
  var name = $("#txtName").val();
  
  var grid = mini.get("accountDatagrid");
  grid.load({
      account:account,
      name:name
  })
}

//在画表格的时候为操作添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value=e.value
    //超链接任务
    switch (field){
      case "moreOperate":
          var d = "";
          if(userForbidden.length>0){
              d += "<a id='"+row.id+"'  class='showCellTooltip forbidden'  data-placement='right'  target='new_window'>禁用 </a>";
          }
          if(userPermission.length>0){
              d +="<a id='"+row.id+"' href='"+basePath +"/permission/userOperatePermission?flag=operate&userId="+ row.id +"' class='showCellTooltip userPermission' data-placement='right'  target='new_window'>设置权限 </a>";
          }
          if(userModify.length>0){
              d +="<a id='"+row.id+"' class='showCellTooltip modifyUser' data-placement='right'  target='new_window' >修改</a>" ;
          }
          if(userDelete.length>0){
              d +="<a id='"+row.id+"'  class='showCellTooltip deleteUser' data-placement='right'  target='new_window'>删除 </a>";
          }
          e.cellHtml = d;
          break;
      case "status":
          if(row.status =="1"){
              e.cellHtml = "<span>启用</span>";
          }else{
              e.cellHtml = "<span>禁用</span>";
          }
          
          break;
      default:
          break;
    }
}

function GetData() {
  var rows = grid.getSelecteds();
  
  if(rows){
    var data = {};
    var ids = "";
    var name = "";
    for (var i = 0; i < rows.length; i++) {
      ids += rows[i].id;
      name += rows[i].name;
      if (i != rows.length - 1) {
        ids += ",";
        name += ",";
      }
    }
    data.id = ids;
    data.text = name;
    return data ;
  }else{
    ShowWarnTip("请选择一条记录");
  }
  
  return null;
}
function GetLinkmanData(){
  var row = grid.getSelected();
  if(row){
    var data = {};
    data.id = row.id;
    data.text = row.name;
    return data ;
  }else{
    ShowWarnTip("请选择一条记录");
  }
  
  return null;
}

function onOk() {
  CloseWindow("ok");
}
function onCancel() {
  CloseWindow("cancel");
}