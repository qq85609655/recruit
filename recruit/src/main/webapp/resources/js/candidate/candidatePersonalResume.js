$(function() {
    mini.parse();
    
    getBasicInfor();
    // 标签选择器初始化
    TagPage.init({
      resumeId : candidateId
    });
});

// resume tool 切换面板
$(".resume-tool li.li-ul").click(function() {
    if(!$(this).hasClass("current")) {
      $(this).addClass("current");
      $(this).siblings().removeClass("current");
    }
    $("#flag").val($(this).attr('id'));
    addIframe($(this).attr('id'));
  
});

//切换简历
$(".resumelist").click(function() {
    if(!$(this).hasClass("currentCol")) {
      $(this).addClass("currentCol");
      $(this).siblings().removeClass("currentCol");
    }
    //$("#jobName").html($(this).attr('name').split("_")[0]);
    //$("#positionId").val($(this).attr('name').split("_")[1]);
    addIframe($("#flag").val());
});

//添加标签
$("#tagAdd").click(function() {
    
    
    getBasicLabel();
    showAtPos('tagSelectWin','#tagAdd');
});

//形成基本信息 
function getBasicInfor() {

    $.ajax({
        url : basePath + "/candidateController/queryLabelList/" + $("#candidateId").val(),
        dataType: "json",
        typ: "post",
        success: function(data){
          
            var append = "";
            for(var i = 0; i < data.labelList.length; i++) {
                append += "<a class='resume-label' id='label-" + data.labelList[i].id + "' pid='category-" + data.labelList[i].categoryId + "'><span class='font-icon icon-tag'></span><span class='label-dele font-icon icon-cancel-1'></span><span>" + data.labelList[i].name + "</span></a>";
            }
            $("#tagAdd").before(append);
        },
        error: function() {
            console.log("获取标签异常!");
        }
    });
}

function getBasicLabel(){
  $.ajax({
    url : basePath + "/candidateController/queryLabelList/" + $("#candidateId").val(),
    dataType : "json",
    typ : "post",
    success : function(data) {
      $("#tagSelected .tag-a").remove();
      var d = data.labelList;
      for (var i = 0; i < d.length; i++) {
        str = '<a class="tag-a radius" pid="' + d[i].categoryId + '" id="tag-' + d[i].id
            + '"><span class="tag-a-add"></span>' + d[i].name + '</a>'
        $("#tagSelected").append(str);
        $(".tag-li #tag-" + d[i].id).remove();
      }
    },
    error : function() {
      console.log("获取标签异常!");
    }
  });
}
//删除标签
$(document).delegate(".label-dele","click",function() {
    var id = $(this).parent().attr("id");
    var labelId = id.substring("label-".length,id.length);
    
 /*   var temp = $("#tagAdd")[0].data.split(",");
    temp.removeV(labelId);
    $("#tagAdd")[0].data = temp.join(",");
    deleTag(getResumeId(),$("#tagAdd")[0].data,$(this).parent()[0].data);*/
    $(this).parent().remove();
    var ids = "";
    $(".resume-label").each(function(){
      ids += $(this).attr("id").substring("label-".length,id.length)+",";
    });
   $.ajax({
      url: basePath + "/resume/updateCandidateTags",
      dataType: "json",
      typ: "post",
      data:{
        resumeId:getResumeId,
        labels:ids,
        deletes:"",
        adds:""
      },
      success: function(msg) {
          if(!msg.success) {
              alert("删除标签 " + tag.name + " 失败!");
          }
      },
      error: function() {
          alert("删除标签 " + tag.name + " 异常!");
      }
  });
    
}); 

//获取简历id
function getResumeId() {
    return $("#candidateId").val();
}

/*//标签选择器关闭前把页面中职位的标签更新
function beforeTagPageClose() {
    var append = null;
    var labels = TagPage.getSelectTags();
    $(".tags-tr .resume-label").remove();
    for(var i = 0; i < labels.length; i++) {
        append = $("<a class='resume-label' id='label-" + labels[i].id + "' pid='category-" + labels[i].categoryId + "'><span class='font-icon icon-tag'></span><span class='label-dele font-icon icon-cancel-1'></span><span>" + labels[i].name + "</span></a>");
        $(append)[0].data = labels[i];
        $("#tagAdd").before(append);
    }
    $("#tagAdd")[0].data = TagPage.getSelect();
}*/

//删除标签
function deleTag(resumeId,ids) {
    $.ajax({
        url: basePath + "/resume/deleTag?resumeId=" + resumeId + "&resumeTags=" + resumeTags + "&tagId=" + tag.id,
        dataType: "json",
        typ: "post",
        success: function(msg) {
            if(!msg.success) {
                alert("删除标签 " + tag.name + " 失败!");
            }
        },
        error: function() {
            alert("删除标签 " + tag.name + " 异常!");
        }
    });
}

function addIframe(flag){
  if(flag=='zh_resume'){
    var id = '';
    $(".resumelist").each(function(){
      if($(this).hasClass('currentCol')){
        id += $(this).attr('id');
      }
    });
    $("#resumeSource").attr('src',basePath+"/candidateController/"+flag+"/"+id);
  }
  if(flag=='estimate'){
    $("#resumeSource").attr('src',basePath+"/candidateController/"+flag+"/"+$('#candidateId').val()+"/"+$('#positionId').val());
  }
  
  if(flag=='opRecord'){
    $("#resumeSource").attr('src',basePath+"/candidateController/"+flag+"/"+$('#candidateId').val()+"/"+$('#positionId').val());
  }

};

function recommend(){
      
      if($("#lockUserAccount").val() == ''||($("#lockUserAccount").val() != null&&$("#lockUserAccount").val()==curName)){
        $.ajax({
          url : basePath + "/candidateRecommendController/validateCandidateRecommend",
          type : "post",
          data : {
            candidatePostId:$("#candidatePostId").val()
          },
          dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
          success : function(data) {
             if(data.status == 200){
               OpenDialog(basePath + "/candidateRecommendController/addRecommend?candidateId="+$("#candidateId").val()+"&candidatePostId="+$("#candidatePostId").val(), "推荐候选人", null, 600, 500,chooseDemand);
             }else{
               mini.alert(data.msg);
             }
          }
        });
       
      }else{
        mini.alert("未锁定或者锁定人是当前用户才能操作！");
      }
}

function chooseDemand(action){
  if(action!="close"){
    mini.alert(action);
  }
}

function bookInterview() {
  if($("#interviewStatus").val()=='20'){
    mini.alert("该候选人已被淘汰，不能安排面试！");
  }else if($("#interviewStatus").val()=='30'){
    mini.alert("该候选人已录入流程中，不能安排面试！");
  }else if($("#interviewStatus").val()=='40'){
    mini.alert("该候选人已录入职，不能安排面试！");
  }else if($("#lockUserAccount").val() == ''||($("#lockUserAccount").val() != null&&$("#lockUserAccount").val()==curName)){
    var id = $("#candidateId").val();
    var positionId = $("#positionId").val();
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
    
  
     
    }else{
      mini.alert("未锁定或者锁定人是当前用户才能操作！");
    }
}

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

function outbookInterview(){

  var flag = true ;
  if($("#lockUserAccount").val()!=''&&$("#lockUserAccount").val()!= curName){
    flag = false ;
  }
  if(flag){
    var ids = $("#candidateId").val();
    var positionIds = $("#positionId").val();
    mini.open({
      url: basePath + "/candidateController/outCandidate/"+ids+"/"+positionIds,
      title: "淘汰", width: 400, height: 250,
      onload: function () {
        /*  var iframe = this.getIFrameEl();
          var data = { action: "new"};
          iframe.contentWindow.SetData(data);*/
      },
  });
  }else{
    mini.alert("未锁定或者锁定人是当前用户才能操作！");
  }

}

function chooseDemand(action) {
  if (action != "close"&&action != "cancel") {
    mini.alert(action);
  }
}

function outAjaxInterviewBook(ids,positionIds,reason){
  $.ajax({
    url : basePath + "/interviewBookController/outInterviewBook?ids=" + ids +"&positionIds=" + positionIds + "&reason=" + reason,
    type : "post",
    success : function(data) {
     var dataJson = eval('(' + data + ')');
        mini.alert(dataJson.msg);
    }
  });
}

function changePositon(){
    
      if($("#lockUserAccount").val() == ''||($("#lockUserAccount").val() != null&&$("#lockUserAccount").val()==curName)){
        OpenDialog(basePath + "/demand/chooseDemandList?candidateId="+$("#candidateId").val()+"&oldPositionId="+$("#positionId").val(), "选择岗位", null, 650, 380,chooseDemand);
      }else{
        mini.alert("未锁定或者锁定人是当前用户才能操作！");
      }
   
  
}

function attention(){
  $.ajax({
    url : basePath + "/attentionController/addAttention",
    type : "post",
    data : {
      ids:$("#candidateId").val(),
      positionIds:$("#positionId").val()
    },
    dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
    success : function(data) {
        mini.alert(data.msg);
        datagrid.reload();
    }
  });
}

function downStandradResume(){
  window.location.href = basePath + "/candidateController/exportStandardResume/"+$(".currentCol").attr("id");
}

function downResume(){
  window.location.href = basePath + "/candidateController/downLoadResume/"+$("#candidateId").val();
}
