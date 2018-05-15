var editor;
var index = 0;

KindEditor.ready(function(K) {
  editor = K.create('textarea[name="content"]', {
    allowFileManager : false
  });
  editor.sync();
  editor.html($("#emailContent").val());
});


$(function(){
 
  
  $("input[name='interviewType']").change(function(){
    $("#waitAddress").val('');
    $("#interviewAddress").val('');
    $("input[name='interviewType']").each(function(){
      if($(this).attr('checked')=='checked' && $(this).val()=='1'){
        $("#waitAddressTr").show();
        $("#interviewAddressTr").show();
      }
      if($(this).attr('checked')=='checked' && $(this).val()=='2'){
        $("#waitAddressTr").hide();
        $("#interviewAddressTr").hide();
      }
      
    });
    
  });
  
  $("#isEmailCheckbox").change(function(){
    if($("#isEmailCheckbox").prop('checked') == true){
      $("#email_model_tr").show();
      $("#emailContent_tr").show();
      $("#uploadFileTr").show();
      $("#attchmentList").show();
      $("#isLinkTr").show();
    }else{
      $("#email_model_tr").hide();
      $("#emailContent_tr").hide();
      $("#uploadFileTr").hide();
      $("#attchmentList").hide();
      $("#isLinkTr").hide();
    }
  })
  
   $("#secondENoticeCheckbox").change(function(){
    if($("#secondENoticeCheckbox").prop('checked') == true){
      $("#secondETimeStr").show();
    }else{
      $("#secondETimeStr").hide();
    }
  })
  
   $("#secondRNoticeCheckbox").change(function(){
    if($("#secondRNoticeCheckbox").prop('checked') == true){
      $("#secondRTimeStr").show();
    }else{
      $("#secondRTimeStr").hide();
    }
  })
  
 
  $("#isLinkCheckbox").change(function(){
    
    if($("#isLinkCheckbox").prop('checked') == true){
      if(mini.get('addEmailModel').getValue().length > 0){
        editor.html(editor.html()+"</br>请点击以下链接录入相关信息</br><a>http://www.baidu.com</a>");
      }else{
        mini.alert("请先选择邮件模板！");
      }
    }
  })

});

mini.parse();
function onButtonEdit(e) {
  btnEdit = this;
  OpenDialog(basePath + "/baseUserController/chooseBaseUserList", "选择面试官", null, 650, 380,chooseInterviews);
}
//回调函数
function chooseInterviews(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    //$("#interviewers"+index).val(data.id);
    btnEdit.setText(data.text);
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
    $("#linkman").val(data.id);
    btnEdit.setText(data.text);
  }
}

function onEmailModelButtonEdit(e) {
  
  btnEdit = this;
  OpenDialog(basePath + "/templateController/chooseTemplate", "选择邮件模板", null, 650, 380,chooseEmailModel);
}



//回调函数
function chooseEmailModel(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetTemplateData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    btnEdit.setText(data.text);
    //data.emailContent = editor.html(data.context);
    $("#modelId").val(data.id);
    editor.html(data.context);
    getAttachmentListToView(data.id);
  }
}

function getAttachmentListToView(id){
  
  $.ajax({ 
    type: "post", 
    dataType: "json", 
    data:{
        id:id
    },
    url: basePath + "/attachmentController/getAttachmentList", 
    success: function(data) { 
        var status = data.status;
        if (status==200) {
          var htmlStr = '';
          var list = data.attachments ;
          if(list){
            for(var i = 0 ; i < list.length ; i++){
              if(list[i].type == 'emailTemplate'){
                htmlStr += '<div id="div_'+list[i].id+'" class="fileStyle">' 
                        + '<input id="'+list[i].id+'" type="button" onclick="delAttach(\''+list[i].id+'\')" value="删除" />'
                        + '&nbsp;&nbsp;'
                        + '<a href="javascript:downloadAttach('+list[i].id+')"><span>'+list[i].showName+'</span></a></div>';
                       
              }
            }
            $("#span1").html(htmlStr);
            
          }
          
        }else {
          mini.alert("网络异常！");
        }
    }, 
    error: function() { 
      mini.alert("网络异常！");
    }
});
  
  
}

function delAttach(id){
  $('#div_'+id).remove();
}

function onUpload() {
  
  uploadAttachments("attachment");
}

function uploadAttachments(name) {
  $.ajaxFileUpload({
    url : jsWebRoot + "/attachmentController/uploadFiles?type=" + "interviewBook" + "&relateId=0",
    secureuri : false,
    fileElementId : name,
    dataType : "json",
    data : null,
    success : function(data, status) {
      // 得到附件ID
      var aid = data.attributes.attachId;
      var htmlStr = '';
      if (aid == null || aid == "") {
        mini.alert("请选择需上传的附件!");
      } else {
        var attachName = data.attributes.attachName;
         htmlStr += '<div id="div_'+aid+'" class="fileStyle">' 
        + '<input id="'+aid+'" type="button" onclick="delAttach(\''+aid+'\')" value="删除" />'
        + '&nbsp;&nbsp;'
        + '<a href="javascript:downloadAttach('+aid+')"><span>'+attachName+'</span></a></div>';
        // 添加可删除附件的链接
        $("#span2").append(htmlStr);
        mini.alert(data.msg, "提示");
      }
    },
    error : function(data, status, e) {
      mini.alert(data.msg, "提示");
    }
  });
}

function subMit(type) {
  //初始化数据
  var interviewBTime = '';
  var interviewETime = '';
  var interviewers = '';
  var interviewDateStr = '';
  var interviewAddress = '';
  for(var i = 0 ; i <= index ; i++){
    if(i == index){
      interviewBTime += $("#start_hours"+i).val() + ":" + $("#start_mins"+i).val();
      interviewETime += $("#end_hours"+i).val() + ":" + $("#end_mins"+i).val();
      interviewers += mini.get('addInterviewers'+i).getValue();
      interviewDateStr += mini.get('interviewDateStr'+i).getFormValue();
      interviewAddress += $("#interviewAddress"+i).val();
      
    }else{
      interviewBTime += $("#start_hours"+i).val() + ":" + $("#start_mins"+i).val() + "_";
      interviewETime += $("#end_hours"+i).val() + ":" + $("#end_mins"+i).val() + "_";
      interviewers += mini.get('addInterviewers'+i).getValue() + "_";
      interviewDateStr += mini.get('interviewDateStr'+i).getFormValue() + "_";
      interviewAddress += $("#interviewAddress"+i).val() + "_";
    }
    
  };
 
  $("#interviewBTime").val(interviewBTime);
  $("#interviewETime").val(interviewETime);
  $("#interviewers").val(interviewers);
  $("#interviewDateStr").val(interviewDateStr);
  $("#interviewAddress").val(interviewAddress);
  var attchmentIds = '';
  $(".fileStyle").each(function(){
    attchmentIds += $(this).attr('id').substring(4,$(this).attr('id').length)+ ",";
  });
  $("#attchmentIds").val(attchmentIds);
  $("#emailContent").val(editor.html());
  $("#isEmail").prop('checked')
  
  if($("#isMessageCheckbox").prop('checked') == true ){
    $("#isMessage").val(1);
  }else{
    $("#isMessage").val(0);
  }
  
  if($("#isEmailCheckbox").prop('checked') == true ){
    $("#isEmail").val(1);
  }else{
    $("#isEmail").val(0);
  }
  
  if($("#secondENoticeCheckbox").prop('checked') == true ){
    $("#secondENotice").val(1);
  }else{
    $("#secondENotice").val(0);
  }
  
  if($("#secondRNoticeCheckbox").prop('checked') == true ){
    $("#secondRNotice").val(1);
  }else{
    $("#secondRNotice").val(0);
  }
  if($("#isLinkCheckbox").prop('checked') == true ){
    $("#isLink").val(1);
  }else{
    $("#isLink").val(0);
  }
  var flag = false ;
  if(type == 'save'){
    $("#saveType").val('save');
    flag = validationForm();
    if(flag){
      $.ajax({
      url : jsWebRoot + '/interviewBookController/InterviewBookVoSave',
      type : 'POST', //GET
      async : true, //或false,是否异步
      data : $('#editform').serialize(),
      dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        alert(data.msg);
        if(data.status == 200){
          window.opener=null;window.open('','_self');window.close();
        }
       
      }
  })};
  }else{
    $("#saveType").val('draft');
      $.ajax({
        url : jsWebRoot + '/interviewBookController/InterviewBookVoDraftSave',
        type : 'POST', //GET
        async : true, //或false,是否异步
        data : $('#editform').serialize(),
        dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
        success : function(data) {
          mini.alert(data.msg);
         $("#id").val(data.id);
         
        }
    });
  }
  
  //var flag = true;

  
  
 
}

function validationForm(){
  for(var i = 0 ; i <= index ; i++){
    if( mini.get('addInterviewers'+i).getValue().length <= 0){
      mini.alert("面试官不能为空！");
      $("#interviewers"+i).focus();
      return false;
    }
    if(mini.get('interviewDateStr'+i).getFormValue().length <= 0){
      mini.alert("面试时间不能为空！");
      return false;
    }
    if($("#interviewAddress"+i).val().length <= 0){
      mini.alert("面试地点不能为空！");
      $("#interviewAddress"+i).focus();
      return false;
    }
  }
  if($("#linkman").val().length <= 0){
    mini.alert("联系人不能为空！");
    $("#linkman").focus();
    return false;
  }
  var regphone = /^(13[0-9]|15[0-9]|18[0-9]|16[0-9])\d{8}$/;  
  if(mini.get("tel").getValue().length <= 0 || !regphone.test(mini.get("tel").getValue())){
    mini.alert("联系电话不能为空或格式不正确！");
    $("#tel").focus();
    return false;
  }
  
  if($("input[name='interviewType']").val()=='1'){
    if($("#waitAddress").val().length <= 0){
      mini.alert("面试等待地点不能为空！");
      $("#waitAddress").focus();
      return false;
    }
    
  }
  
    if($("#isEmail").val()==0 && $("#isMessage").val()== 0){
      mini.alert("至少有一种方式通知候选人！");
      return false;
    }
    if($("#isEmail").val()==1 && $("#modelId").val().length <= 0){
      mini.alert("邮件模板不能为空！");
      $("#modelId").focus();
      return false;
    }
    if($("#secondENotice").val()==1 && mini.get("secondETimeStr").getValue().length <= 0){
      mini.alert("再次提醒候选人时间不能为空！");
      $("#secondETimeStr").focus();
    }
    if($("#secondRNotice").val()==1 && mini.get("secondRTimeStr").getValue().length <= 0){
      mini.alert("再次提醒面试官时间不能为空！");
      $("#secondETimeStr").focus();
    }
    return true ;
    
  }

function addMuniInterviewBook(){
   index += 1 ;
    var templateStr = '<tr class="jobEdit-tr" id="interviewBook_tr_'+index+'">'
                     + '<td>'
                     + '<font class="marker-color">*</font>'
                     + '<font class="font-title">面试官：</font>'
                     + '</td>'
                     + '<td>'
                     + '<input id="addInterviewers'+index+'" class="mini-buttonedit" onbuttonclick="onButtonEdit"/>'
                     + '</td>'
                     + '</tr>'
                     + '<tr class="jobEdit-tr" id="interviewBookTime_tr_'+index+'">'
                     + ' <td><font class="marker-color">*</font> <font class="font-title">面试时间：</font></td>'
                     + ' <td>'
                     + '<input type="text" name="interviewDateStr0" id="interviewDateStr'+index+'" format="yyyy-MM-dd" class="jobEdit-text mini-datepicker"></input>'
                     + ' <select id="start_hours'+index+'">'
                     + '<option value="08">08</option>'
                     + '<option value="08">09</option>'
                     + '<option value="08">10</option>'
                     + '<option value="08">11</option>'
                     + '<option value="08">12</option>'
                     + '<option value="08">13</option>'
                     + '<option value="08">14</option>'
                     + '<option value="08">15</option>'
                     + '<option value="08">16</option>'
                     + '<option value="08">17</option>'
                     + '<option value="08">18</option>'
                     + '<option value="08">19</option>'
                     + '</select>'
                     + '时'
                     + '<select id="start_mins'+index+'">'
                     + '<option value="00">00</option>'
                     + '<option value="30">30</option>'
                     + '</select>'
                     + '分至'
                     + ' <select id="end_hours'+index+'">'
                     + '<option value="08">08</option>'
                     + '<option value="08">09</option>'
                     + '<option value="08">10</option>'
                     + '<option value="08">11</option>'
                     + '<option value="08">12</option>'
                     + '<option value="08">13</option>'
                     + '<option value="08">14</option>'
                     + '<option value="08">15</option>'
                     + '<option value="08">16</option>'
                     + '<option value="08">17</option>'
                     + '<option value="08">18</option>'
                     + '<option value="08">19</option>'
                     + '</select>'
                     + '时'
                     + '<select id="end_mins'+index+'">'
                     + '<option value="00">00</option>'
                     + '<option value="30">30</option>'
                     + '</select>'
                     + '分'
                     + '</td>'
                     + '</tr>'
                     + '<tr class="jobEdit-tr" id="interviewAddress_tr_'+index+'">'
                     + '<td>'
                     + '<font class="marker-color">*</font>'
                     + '<font class="font-title">面试地点：</font></td>'
                     + '<td>'
                     + '<input type="text" name="interviewAddress0" id="interviewAddress'+index+'" class="jobEdit-text radius1"></input>'
                     + '</td>'
                     + '</tr>';
    $('#interviewAddressTr').after(templateStr);
    mini.parse();
};

function removeMuniInterviewBook(){
  if(index){
    $("#interviewBook_tr_"+index).remove();
    $("#interviewBookTime_tr_"+index).remove();
    $("#interviewAddress_tr_"+index).remove();
    index  = index - 1 ;
  }
};

function draftSave(type){
  if(!index){
    subMit(type);
  }else{
    mini.alert("草稿保存不能多轮面试！");
  }
  
}

  
  



