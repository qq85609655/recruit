var professionalNum ,postNum,schoolNum=0;
var timeId,resumeId ='',sucData ="",headerTime ="";
var positionHtml,channelHtml,graduationSchoolHtml,highestEducationHtml,residencerHtml,labelHtml="";
var currentPositionData,channelData,graduationSchoolData,highestEducationData,residenceData,labelData = "";
var resumeEditorPermission = "";

//列表中学历转换
var qualifications;
function qualificationsRenderer(e) {
  for (var i = 0, l = qualifications.length; i < l; i++) {
    var g = qualifications[i];
    if (g.typeId == e.value)
      return g.typeName;
  }
  return "";
}

//列表中性别转换 0:未反馈,1:安排面试,2:转岗,3:淘汰
var recommanders = [{ id: '0', text: '未反馈' },{ id: '1', text: '安排面试' }, { id: '2', text: '转岗'},{ id: '3', text: '淘汰'}];        
function onRecommandRenderer(e) {
  for (var i = 0, l = recommanders.length; i < l; i++) {
      var g = recommanders[i];
      if (g.id == e.value) return g.text;
  }
  return "";
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



var candidateId;
function search() {
 /* //var key = mini.get("key").getValue();
  datagrid.load({
    //searchKey : key,
    state : $("#state").val()
  });*/
  var data = getData();
  loadData(data);
}

//封装简历的搜索参数
function getData(){
    var lowerExperience = $("#lowerYear").val();
    if($.trim(lowerExperience) !=""){
          if(isNumber(lowerExperience)==false){
              alert("您输入的工作年限不是数字");
              return;
          }
    }
    var upperExperience = $("#upperYear").val();
    if($.trim(upperExperience) !=""){
        if(isNumber(upperExperience)==false){
            alert("您输入的工作年限不是数字");
            return;
        }
    }
    var lowerAge = $("#lowerAge").val();
    if($.trim(lowerAge) !=""){
        if(isNumber(lowerAge)==false){
            alert("您输入的年龄非法");
             return;
        }
    }
    
    var upperAge = $("#upperAge").val();
    if($.trim(upperAge) !=""){
        if(isNumber(upperAge)==false){
            alert("您输入的年龄非法");
             return;
        }
    }
    var channel = mini.get("recruitSource").getValue();
    if(channel =="请选择"){
        channel = "";
    }
    var candidateData={
             name : $("#name").val(),
             labels : $("#labelids").val(),
             resumeOrigin : $("#resumeOrigin").val(),
             positionId : $('#positionId').val(),
             deptId : mini.get("orgCode").getValue(),
             channel : channel,
             startTime:mini.get("#startTime").getFormValue(),
             endTime:mini.get("#endTime").getFormValue(),
             highestEducation : $("#highestEducation option:selected").attr("value"),
             sex : $("#sex option:selected").attr("value"),
             lowerAge : $("#lowerAge").val(),
             upperAge : $("#upperAge").val(),
             lowerYear : $("#lowerYear").val(),
             upperYear : $("#upperYear").val(),
             company :$("#companyName").val(),
             label :$("#resumeTag").val(),
             school : $("#school1").val(),
             professional: $("#professional1").val(),
             currentryWorkplace : $("#currentryWorkplace1").val(),
             curPosition : $("#curPosition").val(),
             company : $("#company").val(),
             points : $("#points").val(),
             positionStatus :  $("#positionStatus option:selected").attr("value"),
             lockStatus : $("#lockStatus option:selected").attr("value"),
             interviewerName :mini.get('interviewerName').getValue(),
    }
    return candidateData;
}

//根据条件加载简历数据
function loadData(data){
    sucData = data;
    var grid = mini.get("datagrid1");
    /*var positionManage =grid.getSelecteds();*/
    //console.log(data);
    grid.load({
        name:data.name,
        labels:data.labels,
        resumeOrigin:data.resumeOrigin,
        positionId:data.positionId,
        deptId:data.deptId,
        channel:data.channel,
        startTime:data.startTime,
        endTime:data.endTime,
        highestEducation:data.highestEducation,
        sex:data.sex,
        lowerAge : data.lowerAge,
        upperAge : data.upperAge,
        lowerYear : data.lowerYear,
        upperYear : data.upperYear,
        company :data.company,
        label :data.label,
        school : data.school,
        professional: data.professional,
        currentryWorkplace : data.currentryWorkplace,
        curPosition : data.curPosition,
        company : data.company,
        points : data.points,
        positionStatus : data.positionStatus,
        lockStatus : data.lockStatus,
        interviewerName : data.interviewerName,
        state : $("#state").val(),
    });
}

function clear(){
 $("#name").val('');
  mini.get('labels').setValue('');
  mini.get('labels').setText('');
  $("#resumeOrigin").val('');
  mini.get('positionId').setValue('');
  mini.get('positionId').setText('');
  mini.get("orgCode").setValue('');
  mini.get("orgCode").setText('');
  $("#channel").val('');
  mini.get("#startTime").setFormValue('');
  mini.get("#endTime").setFormValue('');
  $("#highestEducation").val('');
  $("#sex").val('');
  $("#lowerAge").val('');
  $("#upperAge").val('');
  $("#lowerYear").val('');
  $("#upperYear").val('');
  $("#companyName").val('');
  $("#resumeTag").val('');
  $("#school1").val('');
  $("#professional1").val('');
  $("#currentryWorkplace1").val('');
  $("#curPosition").val('');
  $("#company").val('');
  $("#points").val('');
  $("#positionStatus").val("");
  $("#lockStatus").val("");
}


$(function() {
  // = education
  $.ajax({
    url : basePath + "/datadictGroupTypeController/getDictsByCode/education",
    type : "post",
    async : false,
    dataType : "json",
    success : function(data) {
      qualifications = data.data;
      var htmlStr = '<option value="">--请选择--</option>';
      for (var i = 0, l = qualifications.length; i < l; i++) {
        var g = qualifications[i];
         htmlStr +='<option value="'+g.typeId+'">'+g.typeName+'</option>';
      }
      $("#highestEducation").html(htmlStr);
    }
  });
  $("#cancelAttention").hide();
  var datagrid = mini.get("datagrid1");
  mini.parse();
  datagrid.load();
  
  TagPage.init({isUpdate : false, beforeClose : setTag});
});

function isNumber(str){
  if(!$.isNumeric(str )){
      return false;
  } else{
      return true;
  }
}

// 为数据添加超链接
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 超链接任务
  if (field == "feedbackStatus") {
    e.cellHtml = '<a id="' + row.id + '" class="showCellTooltip color-blue">' + value + '</a>';
  }
  if (field == "name") {
    e.cellHtml = '<a id="name_'
        + row.id
        + '" href="'
        + basePath
        + "/candidateController/getCandidateResume/"
        + row.candidateId
        + "/"
        + row.id
        + '" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >'
        + value + '</a>';
  }
}

$(".showCellTooltip").live("mouseenter", function() {
  $("#comments").html('');
  $("#interviewerName").html('');
  $("#status").html("");
  $("#userName").html('');
  $("#createTime").html('');
  $("#jobName").html('');
  $("#feedbackTime").html('');
  var lt = $(this).offset();
  var l = lt.left, t = lt.top;
  $.ajax({
    url : basePath + "/candidateRecommendController/getCandidateRecommend",
    type : "post",
    data : {
      id : $(this).attr('id')
    },
    dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    success : function(data) {
      $("#comments").html(data.comments);
      $("#interviewerName").html(data.interviewerName);

      // 0:未反馈,1:安排面试,2:转岗,3:淘汰
      if (data.status == 0) {
        $("#status").html("未反馈");
        $("#jobName_tr").hide();
      }
      if (data.status == 1) {
        $("#status").html("安排面试");
        $("#jobName_tr").hide();
      }
      if (data.status == 2) {
        $("#status").html("转岗");
        $("#jobName").html(data.jobName);
        $("#jobName_tr").show();
      }
      if (data.status == 3) {
        $("#status").html("淘汰");
        $("#jobName_tr").hide();
      }
      $("#userName").html(data.userName);
      $("#createTime").html(data.createTime);
      $("#feedbackTime").html(data.feedbackTime);
      $(".position-candidate-operate").show();
      $(".position-candidate-operate").css({
        top : t + 15,
        left : l + 25
      });
    }
  });

}).live("mouseleave", function() {
  $(".position-candidate-operate").hide()
})

function isDraftInterview(candidateId,positionId){
  var flag = false ;
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

function bookInterview() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
    if(rows[0].interviewStatus=='20'){
      mini.alert("该候选人已被淘汰，不能安排面试！");
    }else if(rows[0].interviewStatus=='30'){
      mini.alert("该候选人已录入流程中，不能安排面试！");
    }else if(rows[0].interviewStatus=='40'){
      mini.alert("该候选人已录入职，不能安排面试！");
    }else{
      if (rows[0].lockUserAccount == null
          || (rows[0].lockUserAccount != null && rows[0].lockUserAccount == curName)) {
        var id = rows[0].candidateId;
        var positionId = rows[0].positionid;
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

                window.open(basePath + "/interviewBookController/toInterviewBookManage?isBook=2");

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
        
      } else {
        mini.alert("未锁定或者锁定人是当前用户才能操作！");
      }
    
    }
  
  } else {
    alert("请先选中候选人！");
  }
}

function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  if (state == 1) {
    $("#attention").show();
    $("#cancelAttention").hide();
    $("#").show();
    $("#recover").hide();
  }

  if (state == 2) {
    $("#attention").hide();
    $("#cancelAttention").show();
    $("#outbookInterview").show();
    $("#recover").hide();
  }
  if (state == 3) {
    $("#attention").show();
    $("#cancelAttention").hide();
    $("#outbookInterview").show();
    $("#recover").hide();
  }
  if (state == 4) {
    $("#attention").show();
    $("#cancelAttention").hide();
    $("#outbookInterview").show();
    $("#recover").hide();
  }
  if (state == 5) {
    $("#attention").show();
    $("#cancelAttention").hide();
    $("#outbookInterview").show();
    $("#recover").hide();
  }
  if (state == 6) {
    $("#attention").show();
    $("#cancelAttention").hide();
    $("#outbookInterview").hide();
    $("#recover").show();
  }
  $("#state").val(state);
  search();
}

function outbookInterview() {

  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  var flag = true;

  if (rows.length > 0) {
    var ids = "";
    var positionIds = "";
    for (var i = 0; i < rows.length && flag; i++) {
      ids += rows[i].candidateId;
      positionIds += rows[i].positionid;
      if (i != rows.length) {
        ids += ",";
        positionIds += ",";

      }
      if ((rows[i].lockUserAccount != null && rows[i].lockUserAccount != curName)||
          (rows[i].interviewStatus=='20'||rows[i].interviewStatus=='40')) {

        flag = false;
      }
    }
    if (flag) {
    /*  mini.prompt("请输入原因：", "请输入", function(action, value) {
        if (action == "ok") {
          if (value.length) {
            outAjaxInterviewBook(ids, positionIds, value);
          } else {
            mini.alert("请填写原因!");
          }
        }
      }, true);*/
      
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
    } else {
      mini.alert("其中一条数据是已被他人锁定、淘汰、已入职状态，不能操作");
    }

  } else {
    mini.alert("请先选中候选人！");
  }

}

function outAjaxInterviewBook(ids, positionIds, reason) {
  $.ajax({
    url : basePath + "/interviewBookController/outInterviewBook?ids=" + ids + "&positionIds="
        + positionIds + "&reason=" + reason,
    type : "post",
    success : function(data) {
      var dataJson = eval('(' + data + ')');
      mini.alert(dataJson.msg);
      var grid = mini.get("datagrid1");
      grid.reload();
    }
  });

}

function recover(){
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();

  if (rows.length > 0) {
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
      ids += rows[i].id;
      if (i != rows.length) {
        ids += ",";
      }
    }
    $.ajax({
      url : basePath + "/candidateController/recover",
      type : "post",
      data : {
        ids : ids
      },
      dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        mini.alert(data.msg);
        grid.reload();
      }
    });
    

  } else {
    mini.alert("请先选中候选人！");
  }


}

function unlocked() {

  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
      if (i == 0) {
        ids += "'" + rows[i].candidateId + "'";
      } else {
        ids += ",'" + rows[i].candidateId + "'";
      }
      if (rows[i].lockUserAccount == null || rows[i].lockUserAccount != curName) {
        mini.alert("当前数据没被锁定或者已被其他人锁定!");
        return;
      }
    }
    $.ajax({
      url : basePath + "/candidateController/unlockCandidate",
      type : "post",
      data : {
        ids : ids
      },
      dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        mini.alert(data.msg);
        grid.reload();
      }
    });

  } else {
    alert("请先选中候选人！");
  }

}

function changePositon() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
    var id = rows[0].candidateId;
    candidateId = id;
    if (rows[0].lockUserAccount == null
        || (rows[0].lockUserAccount != null && rows[0].lockUserAccount == curName)) {
      OpenDialog(basePath + "/demand/chooseDemandList?candidateId=" + candidateId
          + "&oldPositionId=" + rows[0].positionid, "选择岗位", null, 650, 380, chooseDemand);
    } else {
      mini.alert("未锁定或者锁定人是当前用户才能操作！");
    }

  } else {
    mini.alert("请选择一条数据");
  }
}

function chooseDemand(action) {
  if (action != "close"&&action != "cancel") {
    mini.alert(action);
  }
  var datagrid = mini.get("datagrid1");
  datagrid.reload();
}

function recommend() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length == 1) {
    var id = rows[0].candidateId;
    candidateId = id;

    if (rows[0].lockUserAccount == null
        || (rows[0].lockUserAccount != null && rows[0].lockUserAccount == curName)) {
      $.ajax({
        url : basePath + "/candidateRecommendController/validateCandidateRecommend",
        type : "post",
        data : {
          candidatePostId : rows[0].id
        },
        dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
        success : function(data) {
          if (data.status == 200) {
            OpenDialog(basePath + "/candidateRecommendController/addRecommend?candidateId="
                + candidateId + "&candidatePostId=" + rows[0].id, "推荐候选人", null, 600, 500,
                chooseDemand);
          } else {
            mini.alert(data.msg);
          }
        }
      });

    } else {
      mini.alert("未锁定或者锁定人是当前用户才能操作！");
    }

  } else {
    mini.alert("请选择一条数据");
  }

}

function attention() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids = "";
    var positionIds = "";
    for (var i = 0; i < rows.length; i++) {
      ids += rows[i].candidateId;
      positionIds += rows[i].positionid;
      if (i != rows.length - 1) {
        ids += ",";
        positionIds += ",";
      }
    }
    $.ajax({
      url : basePath + "/attentionController/addAttention",
      type : "post",
      data : {
        ids : ids,
        positionIds : positionIds
      },
      dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        mini.alert(data.msg);
        grid.reload();
      }
    });

  } else {
    alert("请先选中候选人！");
  }
}

function cancelAttention() {

  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
      ids += rows[i].id;
      if (i != rows.length - 1) {
        ids += ",";
      }
    }
    $.ajax({
      url : basePath + "/attentionController/cancelAttention",
      type : "post",
      data : {
        ids : ids
      },
      dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        mini.alert(data.msg);
        grid.reload();
      }
    });

  } else {
    alert("请先选中候选人！");
  }

}

// 录用申请
function employ() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    $.ajax({
      url : basePath + "/employ/isBlackList",
      type : "post",
      data : {
        candidateId : rows[0].candidateId,
      },
      dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
      success : function(e) {
        if (e.success) {
          // 没有列入过黑名单
          if (e.msg == "1") {
            mini.confirm("候选人" + rows[0].name + "曾被列入黑名单", "确定录用?", function(action) {
              if (action == "ok") {
                $.ajax({
                  url : basePath + "/employ/saveEmploy",
                  type : "post",
                  data : {
                    candidateId : rows[0].candidateId,
                    candidateName : rows[0].name,
                    employPostId : rows[0].positionid
                  },
                  dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
                  success : function(e) {
                    if (e.success) {
                      alert("录入申请成功！");
                      window.open(basePath + "/employ/modify/" + e.attributes.id);
                    } else {
                      mini.alert(e.msg);
                    }
                  }
                });
              } else {
                // alert("不删除!");
              }
            });
          } else {
            $.ajax({
              url : basePath + "/employ/saveEmploy",
              type : "post",
              data : {
                candidateId : rows[0].candidateId,
                candidateName : rows[0].name,
                employPostId : rows[0].positionid
              },
              dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
              success : function(e) {
                if (e.success) {
                  alert("录入申请成功！");
                  window.open(basePath + "/employ/modify/" + e.attributes.id);
                } else {
                  mini.alert(e.msg);
                }
              }
            });
          }

        } else {
          mini.alert(e.msg);
        }

      }
    });

  } else {
    mini.alert("请选择一条数据");
  }
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

mini.parse();
function onButtonEdit(e) {
  btnEdit = this;
  OpenDialog(basePath + "/category/chooseLabelList", "选择标签", null, 650, 380,chooseLabels);
}
//回调函数
function chooseLabels(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    //$("#interviewers"+index).val(data.id);
    btnEdit.setText(data.text);
  }
}

function onPositionButtonEdit(e) {
  btnEdit = this;
  OpenDialog(basePath + "/demand/choosePositions", "选择职位", null, 650, 380,choosePosition);
}



//回调函数
function choosePosition(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetPositionData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    btnEdit.setText(data.text);
  }
}


//打开win窗口
function openThisWin(id,win){
    saveCategoryNum(id);
    showAtPos(win,"#"+id);
}

function saveCategoryNum(name){
    switch (name) {
    case "professional":
        dataCategory.count = $(".choose-professional-data li").length;
        break;
    case "post":
        dataCategory.count = $(".choose-post-data li").length;
        break;
    case "school":
       dataCategory.count = $(".choose-school-data li").length;;
        break;
    default:
        break;
    }
}

//弹出数据类别选项
function openData(name){
    $(".choose-"+name+"-panel2").show();
    $(".choose-"+name+"-panel").show();
    $("."+name+"-category-pdata").show();
    var o = $(".choose-"+name+"-tip").offset();
    var l = o.left;
    var t = o.top;
    $("."+name+"-category-pdata").css({
        top: t+25,
        left: l
    })
}

function cancelEvent(){
  clearTimeout(timeId);
}

function closeDataPanel(s){
  timeId = setTimeout("hidePanel('"+s+"')",20);
}

//专业，学校以及意向岗位等点击类别弹出子类
$(".professional-category-pdata a").click(function(){
    var datavalue = $(this).attr("datavalue");
    dataCategory.show('professional',pro ,datavalue);

})

$(".school-category-pdata a").click(function(){
        var datavalue = $(this).attr("datavalue");
        dataCategory.show('school',school,datavalue);
    })

//提交数据
function submitCategoryData(category){
    var name = "";
    var value = "";
    var arrayLi = $(".choose-"+category+"-data li");
    for(var i = 0; i < arrayLi.length; i++){
        name += arrayLi[i].title+",";
        value +=arrayLi[i].value+",";
    }
    if(arrayLi.length > 0) {
        name = name.substring(0,name.length - 1);
    }
    else {
        name = "选择/修改";
    }
    $("#"+category).val(name);
    $("#"+category+"1").val(name);
    $("#"+category).next().show();
    positionSimilarName = name;
    positionSimilarId = value;
    hideWindow("#"+category+"-category-win");
    /*$("#positionSimilar").trigger("validate");*/
    $("."+category+"-category").css("border-bottom","0px");
    saveCategoryNum(category);
}

//隐藏win
function hideCaegoryWindow(category,id){
    $("."+category+"-category").css("border-bottom","0px");
    hideWindow(id)
}

//隐藏数据类的panel
function hidePanel(s){
    $("."+s+"-category-pdata").hide();
    $(".choose-"+s+"-panel2").hide();
    $(".choose-"+s+"-panel").hide();
}

$(".remove").click(function(){
  $(this).next().val("");
  $(this). prev().val("选择/修改");
  $(this).hide();
})

//选择城市
function chooseArea(separateId) {
    area.Show(separateId);
    showAtPos('popInner','#'+separateId);
    var win = mini.get('popInner');
    win.setTitle("请选择城市");
}

//关闭地区弹出框
function closeWin(separateId){
    $(".ac_results").remove();
    $("#areaSearch").removeClass("input-in");
    $("#areaSearch")[0].value = $("#areaSearch")[0].defaultValue;
    hideWindow("#popInner");
    $("#"+separateId).trigger("validate");
}

//显示设置弹出框的显示与隐藏
$("#showSetLabel").click(function(){
    $(".showPosition-choose").show();
}).mouseout(function(){
    timeId = setTimeout("$('.showPosition-choose').hide()",20);
})

$(".showPosition-choose").mouseout(function(){
    timeId = setTimeout("$('.showPosition-choose').hide()",20);
}).mouseover(function(){
    clearTimeout(timeId);
})
    
    //点击checkbox设置显示的内容
    $(".resume-check").click(function(){
     
        var column = $(this).val(); 
        var id = $(this).attr("id");
        
        var isChecked = $(this).attr("checked");
        if(isChecked == "checked"){
            $.cookie(id,"1",{ expires: 3650 });
            dataShow(column);
        }else{
            $.cookie(id,"0",{ expires: 3650 });
            dataHide(column);
        }
    })

//显示设置
function dataShow(column){
    var grid = mini.get("datagrid1");
    grid.showColumn(column);
}
//dataGrid隐藏设置
function dataHide(column){
     var grid = mini.get("datagrid1");
     grid.hideColumn(column);
}

//初始化页面的选中与未选中状态
function loadShowSetData(e){
    var grid = mini.get("datagrid1");
    var checkNum = $(".resume-check");
    //隐藏id列
 /*   grid.hideColumn("id");
    grid.hideColumn("positionId");
    grid.hideColumn("labelIdColumn");*/
    for(var i=0;i<checkNum.length;i++){
        var id = checkNum[i].getAttribute('id');
        var cookKey = $.cookie(id);
        if(typeof(cookKey) == "undefined"){
            $.cookie(id,"1",{ expires: 3650 });
            $("#"+id).attr("checked", "checked"); 
        }else if(cookKey=="1"){
            var column = $("#"+id).val();
            $("#"+id).attr("checked","checked");
            grid.showColumn( column ); 
        }else{
            $("#"+id).attr("checked", false); 
            var column = $("#"+id).val();
            grid.hideColumn(column);
        }
    }
    $(".position-table").show();
}

//选择岗位
function choseJob() {
  // 模拟选中岗位
  // 获取选中值（岗位ID,岗位名称,部门ID,部门名称）
  // 模拟操作
  OpenDialog("/recruit/jobController/toSelectPage", "选择岗位", '', '680', '460', setJobData);
}

//选择岗位 回调函数
function setJobData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    mini.get("applyPostName").setValue(data.cJobname);
    $("#positionId").val(data.cJobcode);
  }
}

function onLinkmanButtonEdit(e) {
  btnEdit = this;
  OpenDialog(basePath + "/baseUserController/chooseBaseUserList", "选择面试联系人", null, 650, 380,chooseLinkman);
}



//回调函数
function chooseLinkman(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetLinkmanData();
    data = mini.clone(data);
   
    btnEdit.setValue(data.id);
    btnEdit.setText(data.text);
  }
}


function setTag(){
  var ids = "";
  var name = "";
  var data = TagPage.getSelectTags();
  for(var i = 0 ; i < data.length;i++){
   
    if(i !=data.length-1){
      ids += data[i].id + ",";
      name += data[i].name + ",";
    }else{
      ids += data[i].id;
      name += data[i].name; 
    }
  }
  $("#labelids").val(ids);
  mini.get("labelName").setValue(name);
  
};
function addTag() {
    
    TagPage.queryTagData();
    showAtPos('tagSelectWin', '#labelName');
};
