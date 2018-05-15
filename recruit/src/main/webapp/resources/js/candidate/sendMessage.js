var editor;
KindEditor.ready(function(K) {
  editor = K.create('textarea[name="context"]', {
    allowFileManager : false
  });
  editor.sync();
});

function onUpload() {
  uploadAttachments("attachment");
}

function uploadAttachments(name) {
  $.ajaxFileUpload({
    url : jsWebRoot + "/attachmentController/uploadFiles?type=" + "sendMessage" + "&relateId=0",
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

// 删除附件
function delAttach(attId) {
  mini.confirm("确认要删除该附件吗？", "删除", function(e) {
    if (e == "ok") {
      $("#del_div_" + attId).remove();
      $.ajax({
        type : "GET",
        async : false,
        url : jsWebRoot + "/attachmentController/remove/" + attId,
        dataType : "text",
        success : function(data) {
          data = eval("(" + data + ")");
          if (data.success) {
            // 减少附件计数
            mini.alert("删除成功", "提示");
          } else {
            mini.alert(data.msg, "提示");
          }
        }
      })
    }
  })
}

// 下载附件
function downloadAttach(attachId) {
  // window.open(jsWebRoot +
  // "/attachmentController/downloadCommonAttachment?type=" + "emailTemplate"
  // + "&attachId=" + attachId);
  window.location.href = jsWebRoot + "/attachmentController/downloadCommonAttachment/" + attachId;
}

function saveTemplate() {
  if($("#interviewer").val()==""||$("#interviewer").val()==undefined){
    mini.alert("收件人不能为空");
    return ;
  }
  if($("#bzjl").prop('checked') == false && $("#jlyw").prop('checked') == false){
    mini.alert("相关材料至少选择一种方式");
    return ;
  }
  if($("#bzjl").prop('checked') == true ){
    $("#isBzjl").val(1);
  }
  
  if($("#jlyw").prop('checked') == true ){
    $("#isJlyw").val(1);
  }
  
  
  
  var attchmentIds = '';
  $(".fileStyle").each(function(){
    attchmentIds += $(this).attr('id').substring(4,$(this).attr('id').length)+ ",";
  });
  $("#attchmentIds").val(attchmentIds);
  $("#emailContent").val(editor.html());

      $.ajax({
      url : jsWebRoot + '/candidateController/sendMessageSubmit',
      type : 'POST', //GET
      async : true, //或false,是否异步
      data : $('#templateId').serialize(),
      dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
      success : function(data) {
        alert(data.msg);
        CloseWindow("close");
      }
   })
}

function onCancel(e) {
  CloseWindow("close");
}

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
    $("#interviewer").val(data.id);
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