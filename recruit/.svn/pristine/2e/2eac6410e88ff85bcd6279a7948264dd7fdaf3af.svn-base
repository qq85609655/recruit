//列表中学历转换
var qualifications; 
function qualificationsRenderer(e) {
  for (var i = 0, l = qualifications.length; i < l; i++) {
      var g = qualifications[i];
      if (g.typeId == e.value) return g.typeName;
  }
  return "";
}

var candidateId;
function search() {
    var key = mini.get("key").getValue();
    datagrid.load({
      searchKey : key,
      state:$("#state").val()
    });
  }

$(function() {
  // = education
  $.ajax({
    url : basePath + "/datadictGroupTypeController/getDictsByCode/education",
    type : "post",
    async: false,
    dataType: "json",
    success : function(data) {
      qualifications = data.data ;
    }
  });
  $("#cancelAttention").hide();
  //初始化标签 
  TagPage.init({});
});

//为数据添加超链接
function ondrawcell(e) {
    var row = e.row,
        column = e.column,
        field = e.field,
        value = e.value;
    if(field =="name"){
      e.cellHtml = '<a id="name_' + row.id + '" href="' + basePath + "/candidateController/getResumeList/" + row.candidateId + '" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + value + '</a>';
    }
}

$(".showCellTooltip").live("mouseenter",function() {
  $(".position-operate-rtable").html('');
  var lt = $(this).offset();
  var l=lt.left,
      t=lt.top;
  $.ajax({
    url : basePath + "/candidateController/getCandidatePostStatus",
    type : "post",
    data : {
      id : $(this).attr('id')
    },
    dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
    success : function(data) {
     
      if(data.cpList!= null && data.cpList.length > 0){
        var append = null ;
        for(var i = 0; i < data.cpList.length; i++) {
        
          append += '<tr><td style="font-size:10px;">应聘岗位：' + data.cpList[i].jobName +'/面试状态:';
          //面试状态,针对当前职位;00:默认,10:安排面试,20:淘汰,30:录入流程中,40:已经入职
          if(data.cpList[i].interviewStatus==0){
            append +="候选人状态";
          }
          if(data.cpList[i].interviewStatus==10){
            append +="安排面试";
          }
          if(data.cpList[i].interviewStatus==20){
            append +="淘汰";
          }
          if(data.cpList[i].interviewStatus==30){
            append +="录入流程中";
          }
          if(data.cpList[i].interviewStatus==40){
            append +="已经入职";
          }
          append +="</td></tr>";
      }
       $(".position-operate-rtable").html(append); 
      }else{
        $(".position-operate-rtable").html("<tr><td>暂无记录</td></tr>"); 
      }
      $(".position-candidate-operate").show();
      $(".position-candidate-operate").css({
          top:t-60,
          left:l+160
      });
    }
  });
  
 
}).live("mouseleave",function() {
  $(".position-candidate-operate").hide()
})


  function addTag() {
    var grid = mini.get("datagrid1");
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      var row = rows[0];
      var candidateId = row.candidateId;
      TagPage.setCandidateId(candidateId);
      getBasicInfor();
      showAtPos('tagSelectWin', '#addTag');
    } else {
      ShowWarnTip("请选择一条记录");
      return false;
    }

  };

  // 形成基本信息
  function getBasicInfor() {
    var grid = mini.get("datagrid1");
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      var row = rows[0];
      var candidateId = row.candidateId;
      $.ajax({
        url : basePath + "/candidateController/queryLabelList/" + candidateId,
        dataType : "json",
        typ : "post",
        success : function(data) {
          $("#tagSelected .tag-a").remove();
          var d = data.labelList;
          if(d != null){
            for (var i = 0; i < d.length; i++) {
              str = '<a class="tag-a radius" pid="' + d[i].categoryId + '" id="tag-' + d[i].id
                  + '"><span class="tag-a-add"></span>' + d[i].name + '</a>'
              $("#tagSelected").append(str);
              $(".tag-li #tag-" + d[i].id).remove();
            }
          }
        },
        error : function() {
          console.log("获取标签异常!");
        }
      });
    } else {
      ShowWarnTip("请选择一条记录");
      return false;
    }

  }
  
  function addCandidatePost(){
    var grid = mini.get("datagrid1");
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      var ids = "";
      for (var i = 0; i < rows.length; i++) {
        ids += rows[i].candidateId;
        if (i != rows.length) {
          ids += ",";
        }
      }
      if (rows[0].lockUserAccount == null
          || (rows[0].lockUserAccount != null && rows[0].lockUserAccount == curName)) {
        OpenDialog(basePath + "/demand/choosePositionList?candidateId=" + ids, "选择岗位", null, 650, 380, chooseDemand);
      } else {
        mini.alert("未锁定或者锁定人是当前用户才能操作！");
      }

    } else {
      mini.alert("请至少选择一条数据");
    }
}
  
  function chooseDemand(action) {
    if (action != "close") {
      mini.alert(action);
    }
    datagrid.reload();
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