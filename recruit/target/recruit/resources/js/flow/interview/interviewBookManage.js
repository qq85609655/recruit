$(function() {
	mini.parse();
	search();
	linkFunction(temp);
});

function linkFunction(temp){
  if(temp == 2){
    $(".posi-import-btn").removeClass("tab-up");
    $("#detail-button").addClass("tab-up");
    
      $("#cancelBookInterview").hide();
      $("#outBookInterview").hide();
      $("#interview_status").hide();
      $("#status_span").hide();
      $("#feedback").hide();
      $("#delBookInterview").hide();
      $("#breakBookInterview").hide();
      $("#estimateEdit").hide();
      $("#isBook").val(2);
      search();
  }
 
}

function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  if(state == 1 ){
    $("#cancelBookInterview").show();
    $("#outBookInterview").show();
    $("#interview_status").show();
    $("#status_span").show();
    $("#delBookInterview").show();
    $("#breakBookInterview").show();
    $("#estimateEdit").show();
    $("#isBook").val(1);
    $("#feedback").show();
  }
  
  if(state == 2){
    $("#cancelBookInterview").hide();
    $("#outBookInterview").hide();
    $("#interview_status").hide();
    $("#status_span").hide();
    $("#feedback").hide();
    $("#delBookInterview").hide();
    $("#breakBookInterview").hide();
    $("#estimateEdit").hide();
    $("#isBook").val(2);
  }
  
  search();
}

function search() {
  

  var isBook = $("#isBook").val() ;
 
    var interview_status = $("#interview_status").val();
	var startDate = mini.get("startDate").getFormValue();
	var endDate = mini.get("endDate").getFormValue();
	var searchKey = $("#searchKey").val();
	var grid = mini.get("datagrid1");
	grid.load({startDate:startDate, 
	    endDate:endDate,
	    searchKey:searchKey,
	    isBook:isBook,
	    interviewStatus:interview_status});
}

//为数据添加超链接
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 超链接任务
  if(field =="name"){
    e.cellHtml = '<a id="name_' + row.id + '" href="' + basePath + "/candidateController/getResumeList/" + row.candidateId + '" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + value + '</a>';
  }
}

//列表中性别转换00:默认,10:安排面试,20:淘汰,30:录入流程中,40:已经入职
var interviewers = [{ id: '00', text: '候选人状态' },{ id: '10', text: '安排面试' }, { id: '20', text: '淘汰'},{ id: '30', text: '录入流程中'},{ id: '40', text: '已经入职'}];        
function onInterviewRenderer(e) {
  for (var i = 0, l = interviewers.length; i < l; i++) {
      var g = interviewers[i];
      if (g.id == e.value) return g.text;
  }
  return "";
}

function bookInterview() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
    if(rows[0].cpStatus=='20'){
      
      mini.alert("该候选人已被淘汰，不能安排面试！");
    }else if(rows[0].cpStatus=='30'){
      mini.alert("该候选人已录入流程中，不能安排面试！");
    }else if(rows[0].cpStatus=='40'){
      mini.alert("该候选人已录入职，不能安排面试！");
    }else{
      if(rows[0].lockStatus !="被他人锁定"){
        var id = rows[0].candidateId;
        var positionId = rows[0].positonId;
        if( valiateCandidate(id,positionId)){
          //验证该候选人已存有草稿

          var flag = isDraftInterview(id,positionId);
          if(flag){
            mini.showMessageBox({
              width: 400,
              title: "请选择",       
              message: "",    
              buttons: ["草稿列表", "直接进入安排面试"],  
              buttonWidth:100,
              iconCls: "mini-messagebox-question",   
              html: "请选择安排面试方式？",    
              callback:  function (action) {
                if(action == "草稿列表"){

                  $(".posi-import-btn").removeClass("tab-up");
                  $("#detail-button").addClass("tab-up");
                  
                    $("#cancelBookInterview").hide();
                    $("#outBookInterview").hide();
                    $("#interview_status").hide();
                    $("#status_span").hide();
                    $("#feedback").hide();
                    $("#delBookInterview").hide();
                    $("#breakBookInterview").hide();
                    $("#estimateEdit").hide();
                    $("#isBook").val(2);
                    $("#searchKey").val(rows[0].name);
                  search();

                }
                if(action == "直接进入安排面试"){
                  $.ajax({
                    url : basePath + "/employ/isBlackList",
                    type : "post",
                    data : {
                      candidateId : id,
                    },
                    dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
                    success : function(e) {
                      if (e.success) {
                        // 没有列入过黑名单
                        if (e.msg == "1") {
                          mini.confirm("候选人" + rows[0].name + "曾被列入黑名单", "确定安排面试?", function(action) {
                            if (action == "ok") {
                              window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id +"&positionId="+positionId);
                            }
                          });
                        } else {
                          window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id +"&positionId="+positionId);
                        }
                      } else {
                        mini.alert(e.msg);
                      }
                    }
                  });
                  //window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id+"&positionId="+positionId);
                }
            }
            });
          }else{
            $.ajax({
              url : basePath + "/employ/isBlackList",
              type : "post",
              data : {
                candidateId : id,
              },
              dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
              success : function(e) {
                if (e.success) {
                  // 没有列入过黑名单
                  if (e.msg == "1") {
                    mini.confirm("候选人" + rows[0].name + "曾被列入黑名单", "确定安排面试?", function(action) {
                      if (action == "ok") {
                        window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id +"&positionId="+positionId);
                      }
                    });
                  } else {
                    window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id +"&positionId="+positionId);
                  }
                } else {
                  mini.alert(e.msg);
                }
              }
            });
            //window.open(basePath + "/interviewBookController/addInterviewBook?id=" + id+"&positionId="+positionId);
          }
        }
      }else{
        mini.alert("该候选人已被他人锁定");
      }
    
    }
    
  }else{
    alert("请先选中一条数据！");
  }
}

function valiateCandidate(id,positionId){
  var flag = false ;
  $.ajax({
    url : basePath + "/candidateController/valiateCandidate",
    type : "post",
    data : {
      candidateId:id,
      positionId:positionId
    },
    async : false,
    dataType : "json",
    success : function(data) {
       if(data.code == '200'){
         if(data.interviewStatus =='30'){
           alert("该候选人已录入流程中,不能安排面试"); 
         }else if(data.interviewStatus =='40'){
           alert("该候选人已入职,不能安排面试"); 
         }else if(data.interviewStatus =='20'){
           alert("该候选人已淘汰,不能安排面试"); 
         }else{
           flag = true ;
         }
       }
       if(data.code == '404'){
         mini.alert(data.msg);
       }
    }
  });
  return flag ;
  
}


function isDraftInterview(candidateId,positionId){
  var flag = false ;
  if($("#isBook").val()=="2"){
    return flag ;
  }
  $.ajax({
    url : basePath + "/interviewBookController/isDraftInterview",
    type : "post",
    data : {
      candidateId:candidateId,
      positionId:positionId
    },
    async : false,
    dataType : "json",
    success : function(data) {
       if(data.code == '200'){
         flag = true ;
       }
    }
  });
  return flag ;
}


function onKeyEnter(e) {
    search();
}

function onDateRenderer(e) {
  var value = e.value;
  if (value) return new Date(value).format("yyyy-MM-dd");
  return "";
}

function updateInterviewBook(){
  
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  
  if (rows.length > 0) {
    var ids="";
    var flag = true ;
    for(var i=0;i<rows.length&&flag;i++){
      if(rows[i].interviewStatus == "淘汰"||rows[i].interviewStatus.indexOf("取消") > 0){
        flag = false ;
      }
      ids+=rows[i].id;
      if(i!=rows.length-1){
        ids+=",";
      }
    }
    if(flag){
      mini.open({
        url: basePath + "/interviewBookController/outInterview/"+ids,
        title: "取消面试", width: 400, height: 250,
        onload: function () {
          /*  var iframe = this.getIFrameEl();
            var data = { action: "new"};
            iframe.contentWindow.SetData(data);*/
        },
        ondestroy: function (action) {

            grid.reload();
        }
    });
    }else{
      mini.alert("其中一条数据为淘汰或者取消状态，不能操作！");
    }
   
  }else{
    mini.alert("请先选中面试！");
  }
}

function updateAjaxInterviewBook(ids,reason){
  
  $.ajax({
    url : basePath + "/interviewBookController/cancelInterviewBook",
    type : "post",
    data : {
      ids:ids,
      reason:reason
    },
    success : function(data) {
     var dataJson = eval('(' + data + ')');
        mini.alert(dataJson.msg);
        grid.reload();
    }
  });
  
}

function outInterviewBook(){
  
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  var arr = new Array();
  if (rows.length > 0) {
    var temp="";
    var ids="";
    var positionIds="";
    var flag = true ;
    for(var i=0;i<rows.length&&flag;i++){
      if(rows[i].cpStatus == "20"||rows[i].cpStatus == "40"){
        flag = false ;
      }
      temp = rows[i].candidateId + "_" + rows[i].positonId ;
      if(!contains(arr,temp)){
       arr.push(temp);
       ids+= rows[i].candidateId + ",";
       positionIds+= rows[i].positonId + ",";
      }
    }
    if(flag){
      mini.open({
        url: basePath + "/candidateController/outCandidate/"+ids+"/"+positionIds,
        title: "淘汰", width: 400, height: 250,
        onload: function () {
          /*  var iframe = this.getIFrameEl();
            var data = { action: "new"};
            iframe.contentWindow.SetData(data);*/
        },
        ondestroy: function (action) {

            grid.reload();
        }
    });
    }else{
      mini.alert("其中一条数据为淘汰或已入职状态，不能操作！");
    }
  }else{
    mini.alert("请先选中面试！");
  }
}

function chooseDemand(action) {
  if (action != "close"&&action != "cancel") {
    mini.alert(action);
  }
  var datagrid = mini.get("datagrid1");
  datagrid.reload();
}

function outAjaxInterviewBook(ids,positionIds,reason){

  
  $.ajax({
    url : basePath + "/interviewBookController/outInterviewBook",
    type : "post",
    data : {
      ids:ids,
      positionIds:positionIds,
      reason:reason
    },
    beforeSend:function(XMLHttpRequest){ 
      $("#loading").html("<img src="+webRoot+"'/resources/images/ajax-loader.gif' />"); //在后台返回success之前显示loading图标
      }, 
    success : function(data) {
     var dataJson = eval('(' + data + ')');
        mini.alert(dataJson.msg);
        grid.reload();
    }
  });
  

}

function contains(arr, obj) {  
  var i = arr.length;  
  while (i--) {  
      if (arr[i] === obj) {  
          return true;  
      }  
  }  
  return false;  
}  

/**
 * 编辑面试信息
 */
function editInterviewBook(){
  
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
      var id = rows[0].id;
      var date = rows[0].interviewTimes;
     
      var compareDate = new Date(date.substring(0,10));
      if(date.length == 0||compareDateMethod(compareDate)||$("#isBook").val()=="2"){
        window.open(basePath + "/interviewBookController/editInterviewBook?id=" + id);
      }else{
        mini.alert('不能编辑当前时间以前的数据！');
      }
      
   
  }else{
    mini.alert("请先选中一条面试信息！");
  }

  
}

function compareDateMethod(date){
  var now = new Date(new Date().toLocaleDateString());
  var d = new Date(date);
  if (now > d) {
    return false ;
  } else if (now < d) {
      return true ;
  } 
}

function breakBookInterview(){
  var gridsss = mini.get("datagrid1");
  var rowssss = gridsss.getSelecteds();
  if (rowssss.length == 1) {
    mini.showMessageBox({
      width: 400,
      title: "爽约",       
      message: "",    
      buttons: ["淘汰", "修改面试安排"],  
      buttonWidth:100,
      iconCls: "mini-messagebox-question",   
      html: "请重新处理此候选人？",    
      callback:  function (action) {
        if(action == "淘汰"){
          outInterviewBook();
        }
        if(action == "修改面试安排")
          editInterviewBook();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }
    });
  }else{
    mini.alert("请先选中一条面试信息！");
  }
  

  
}

function estimateEdit(){
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
      var id = rows[0].candidateId;
      window.open(basePath + "/estimateController/estimateEdit?candidateId=" + id + "&positionId="+rows[0].positonId +"&type=HR");
  }else{
    alert("请选中一条数据！");
  }
  
  
}

function unlocked(){

  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids="";
    for(var i=0;i<rows.length;i++){
      ids+=rows[i].candidateId;
      if(i!=rows.length-1){
        ids+=",";
      }
        $.ajax({
          url : basePath + "/candidateController/unlockCandidate",
          type : "post",
          data : {
            ids:ids
          },
          dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
          success : function(data) {
              mini.alert(data.msg);
              grid.reload();
          }
        });
    }

   
  }else{
    alert("请先选中候选人！");
  }

}

function feedback(){
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  
  if (rows.length > 0) {
    var ids="";
    for(var i=0;i<rows.length;i++){
      ids+=rows[i].id;
      if(i!=rows.length-1){
        ids+=",";
      }
    }
    mini.prompt("请输入反馈信息：", "请输入",
        function (action, value) {
            if (action == "ok") {
              if(value.length){
                insertFeedBack(ids,value);
              }else{
                mini.alert("请输入反馈信息！");
              }
              
              
            } 
        },
        true
    );
  }else{
    mini.alert("请先选中面试！");
  }
  
  
  
}

function insertFeedBack(ids,reason){
  
  $.ajax({
    url : basePath + "/feedbackController/batchInsertFeedBack",
    type : "post",
    data : {
      ids:ids,
      reason:reason
    },
    success : function(data) {
     var dataJson = eval('(' + data + ')');
        mini.alert(dataJson.msg);
        grid.reload();
    }
  });
  
}

//发送消息
function sentMessage() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var row = rows[0];
    var candidateId = row.candidateId;
    OpenDialog(webRoot + "/candidateController/sendMessage?candidateId=" + candidateId, "自定义发送邮件", "", 780,
        660);
  } else {
    ShowWarnTip("请选择一条记录");
  }

}


