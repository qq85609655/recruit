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



function chooseDemand(action){
  if(action!="close"){
    mini.alert(action);
  }
}

