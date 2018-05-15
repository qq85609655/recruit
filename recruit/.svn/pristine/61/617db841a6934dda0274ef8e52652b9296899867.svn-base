var updateRoleOperate = "";
var deleteRoleOperate ="";
var rolePermission ="";

$(document).ready(function() {
  mini.parse();
  var grid = mini.get("accountDatagrid");
  grid.load();
  getRolePermission();
  
})
  
function getRolePermission(){
	updateRoleOperate = $("#updateRoleOperate").val();
    deleteRoleOperate =$("#deleteRoleOperate").val();
    rolePermission =$("#rolePermission").val();
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
      		if(rolePermission.length>0){
      			d += "<a id='"+row.id+"' href='"+basePath +"/permission/permission?flag=menuId&roleId="+ row.id +"' class='menuPermission role'  data-placement='right'  target='new_window'>菜单权限</a>" +
				     "<a id='"+row.id+"'   href='"+basePath +"/permission/permission?flag=operate&roleId="+ row.id +"' class='operatePermission role'  data-placement='right'  target='new_window'>操作权限 </a>" ;
      		}
      		if(updateRoleOperate.length>0){
      			d += "<a id='"+row.id+"'  class='updateRole role'  data-placement='right'  target='new_window'>更改</a>";
      		}
      		if(deleteRoleOperate.length>0){
      			d +="<a id='"+row.id+"'  class='deleteRole role' data-placement='right'  target='new_window'>删除 </a>";
      		}
      		e.cellHtml =d;
      		break;
      	default:
      		break;
      }
  }
  
  $(".updateRole").live('click',function(){
	  //赋值
	  $("#roleId").val($(this).attr("id"));
	  var row = mini.get("accountDatagrid").getSelected();
	  $("#name").val(row.name);
	  $("#description").val(row.description);
	  //打开window
	  var win = mini.get("role-win");
	  win.setTitle("更新角色");
	  win.showAtPos(300,300);
	  
  })
  
  $(".deleteRole").live('click',function(){
	  $("#deleteRoleId").val($(this).attr("id"));
	  var win = mini.get("delete-win");
	  win.showAtPos(700,300);
	  
  })
  
  function deleteRole(){
	 var id = $("#deleteRoleId").val();
	 window.location.href=basePath+"/baseRoleController/delete?id="+id;
  }
  
  $("#addRoleButton").click(function(){
	  //刷新form表单
	  $("#roleId").val("");
	  $("#roleForm")[0].reset();
	  var win = mini.get("role-win");
	  win.showAtPos(300,300);
	  
  })
  
  function roleSubmit(){
	  var name =  $.trim($("#name").val());
	  if(name ==''){
		  alert('角色名称为必填项');
		  return;
	  }else{
		  $("#roleForm").submit();
	  }
  }
  
  $(".operatePermission").live(function(){
	  
  })