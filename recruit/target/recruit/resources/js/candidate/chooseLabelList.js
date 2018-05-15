  var userDelete = "";
  var userForbidden = "";
  var userModify = "";
  var userPermission = "";  
  mini.parse();
  var grid = mini.get("accountDatagrid");
$(document).ready(function() {
       // 初始化mini ui
        mini.parse();
        var grid = mini.get("accountDatagrid");
        grid.load();
        
        //获取角色
        queryRole();
        
        //初始化查询的数据
        initData();
        
        setPermissionData();
    })
  
  function initData(){
      $("#txtAccount").val("");
      $("#txtName").val("");
      $("#txtTel").val("");
  }

    function GetData() {
      var rows = grid.getSelecteds();
      if(rows){
        var ids = [], texts = [];
        for (var i = 0, l = rows.length; i < l; i++) {
            var row = rows[i];
            ids.push(row.id);
            texts.push(row.name);
        }
        var data = {};
        data.id = ids.join(",");
        data.text = texts.join(",");
        return data ;
      }
      return null;
    }
    
    function GetLinkmanData() {
      var rows = grid.getSelecteds();
      if(rows.length == 1){
        var data = {};
        data.id = rows[0].id;
        data.text = rows[0].name;
        return data ;
      }else{
        showWarnTip("请选择一条记录");
      }
      
      return null;
    }
    
    function search() {
      var key = mini.get("key").getValue();
      grid.load({ key: key });
    }
    function onKeyEnter(e) {
      search();
    }
    
    function onOk() {
      CloseWindow("ok");
    }
    function onCancel() {
      CloseWindow("cancel");
    }


  // ====================================================================
  // 抽离的公共方法
  function showActionTip(action) {
    if (action.success != null) {
      if (action.success) {
        showSuccessTip(action.msg);
      } else {
        showFailureTip(action.msg);
      }
    }
  }

  function showSuccessTip(message, title) {
    if (title) {
      showTips(title, message, "success");
    } else {
      showTips("成功", message, "success");
    }
  }

  function showFailureTip(message, title) {
    if (title) {
      showTips(title, message, "danger");
    } else {
      showTips("失败", message, "danger");
    }
  }

  function showInfoTip(message, title) {
    if (title) {
      showTips(title, message, "info");
    } else {
      showTips("提示", message, "info");
    }
  }

  function showWarnTip(message, title) {
    if (title) {
      showTips(title, message, "warning");
    } else {
      showTips("警告", message, "warning");
    }
  }

  function showTips(title, message, state) {
    mini.showTips({
      content : "<div style=\"padding: 5px 10px;\"><b>" + title + "</b><p>"
          + message + "</p></div>",
      state : state,
      x : "right",
      y : "bottom",
      timeout : 3000
    });
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
  function setPermissionData(){
      userDelete = $("#userDelete").val();
      userForbidden = $("#userForbidden").val();
      userModify = $("#userModify").val();
      userPermission = $("#userPermission").val();
  }
  
    // 新增账号提交
    $("#accountAddOK").click(function() {
        $("#accountAddForm").trigger("submit");
    });
    
    // 新增账号的验证
    $("#accountAddForm").validator({
        theme : "simple_right",
        msgClass : "n-right ",
        rules : {
            telVoid : function(e) {
                if($("#accountTel").val() == "") {
                    return true;
                }
                else {
                    return false;
                }
            }
        },
        fields : {
            "#account" : {
                rule : "required;length[~32]"
            },
            "#name" : "required;length[~32]",
            "#email" : "required;email",
            "#cellphone" : {
                rule : "required(telVoid);mobile",
                msg : {required : "联系电话或手机<font color='red'>必须填写其中之一</font>"},
                msgStyle : "margin-top:-5px;",
                target : "#cellphoneMsg"
            }
        },
        valid : function(form) {
            var me = this;
            me.holdSubmit();
            addAccount(function(msg) {
                if(msg.success) {
                    mini.showTips({
                        content : "<span class='font-icon icon_ok'></span><span class='success-text'>新建成功</span>",
                        state : "success",
                        x : "center",
                        y : "center",
                        timeout : 3000
                    });
                    me.holdSubmit(false);
                    hideWindow('recruit-assistant-win');
                }
                else {
                    mini.showTips({
                        content : "<span class='font-icon icon_error'></span><span class='success-text'>" +  msg.msg + "</span>",
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
    
    // 清除验证
    function cleanValidator(id) {
        $(id)[0].reset();
        $(id).validator("cleanUp");
    }
    
    //清除Id
    $("#btnNew").click(function(){
        $("#userId").val("");
        $("#accountStatu").attr("checked",false);
        $("#accountRoleSelect").val("");
        notChoose();
        $("#recruit-assistant-dept").val("请选择部门");
        
    })
    
    // 新增账号
    function addAccount(fn) {
        $.ajax({
            type : "post",
            dataType : "json",
            data : JSON.stringify(getAccountData()),
            url : basePath + "/baseUserController/save",
            contentType : "application/json;charset=UTF-8",
            success : fn,
            error: function() {
                alert("新增失败!");
            }
        });
    }
    // 获取新增账号的数据
    function getAccountData() {
        return {
            id : $("#userId").val(),
            account : $("#account").val(),
            name : $("#name").val(),
            status : ($("#accountStatu")[0].checked ? "1" : "0"),
            tel : $("#accountTel").val(),
            cellphone : $("#cellphone").val(),
            depId : departmentChoose["#recruit-assistant-dept"],
            roleId : $("#accountRoleSelect").val()
        };
    }
    
    function queryRole(){
        $.ajax({
            type : "post",
            dataType : "json",
            url : basePath + "/baseRoleController/getAllRole",
            success : function(data){
                var d="";
                for(var i=0;i<data.data.length;i++){
                  if(data.data[i].name !=""){
                      d+="<option value='"+data.data[i].id+"' roleName='"+data.data[i].name+"'>"+data.data[i].name+"</option>";
                  }
                }
                 $("#accountRoleSelect").append(d);
                 $("#selRole").append(d);
            },
            error: function() {
                alert("新增失败!");
            }
        });
    }
    
    $(".forbidden").live('click',function(){
        $.ajax({
            type : "post",
            dataType : "json",
            url : basePath + "/baseUserController/status?id="+$(this).attr("id"),
            success : function(data){
                if(data.success == true){
                    alert(data.msg);
                }else{
                    alert(data.msg);
                }
                mini.get("accountDatagrid").reload()
            },
            error: function() {
                alert("禁用失败!");
            }
        });
        
    })
    
    $(".modifyUser").live('click',function(){
        var grid  = mini.get("accountDatagrid");
        var row = grid.getSelected();
        setValue(row);
        showAtPos('recruit-assistant-win','#btnNew');
    })
    
    
    function setValue(row){
        $("#userId").val(row.id);
        $("#account").val(row.account);
        $("#name").val(row.name);
        $("#accountTel").val(row.tel);
        $("#cellphone").val(row.cellphone);
        if(row.status =="1"){
            $("#accountStatu").attr("checked",true);
        }else{
            $("#accountStatu").attr("checked",false);
        }
        $("#recruit-assistant-dept").val(row.deptName);
        
        $("#accountRoleSelect option[roleName='"+row.roleName+"']").attr("selected",true); 
    }
    
    $(".deleteUser").live('click',function(){
        $.ajax({
            type : "post",
            dataType : "json",
            url : basePath + "/baseUserController/delete?id="+$(this).attr("id"),
            success : function(data){
                if(data.success == true){
                    alert(data.msg);
                }else{
                    alert(data.msg);
                    
                }
                mini.get("accountDatagrid").reload();
            },
            error: function() {
                alert("删除失败!");
            }
        });
    })
    
    function queryUserList(){
        var account = $("#txtAccount").val();
        var name = $("#txtName").val();
        var tel = $("#txtTel").val();
        var role = $("#selRole").val();
        var depId = departmentChoose["#btnSelDeptTitle1"];
        var grid = mini.get("accountDatagrid");
        grid.load({
            account:account,
            name:name,
            tel:tel,
            depId:depId,
            roleId:role
        })
    }
    
    function changePassword() {
      var grid = mini.get("accountDatagrid");
      var row = grid.getSelected();
      if (row) {
        OpenDialog("auth/user/sysUser/changePassword/" + row.id, "重置密码", grid);
      } else {
        ShowWarnTip("请选择一条记录");
      }
    }