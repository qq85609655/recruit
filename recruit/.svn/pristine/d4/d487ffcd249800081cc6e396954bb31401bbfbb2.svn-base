var editor;
KindEditor.ready(function(K) {
  editor = K.create('textarea[name="context"]', {
    allowFileManager : false
  });
  editor.sync();
});

var relateId = ""; // 附件关联的模板id
var id = ""; // 模板id
var aid = ""; // 所有附件id
var deleteId = deleteId + ",";// 删除的附件id

function onUpload() {
  uploadAttachments("attachment");
}

function uploadAttachments(name) {
  //选中的模板id
  id = btnEdit.getValue();
  $.ajaxFileUpload({
    url : jsWebRoot + "/attachmentController/uploadFilesForStu?type=" + "emailTemplate" + "&id="
        + id,
    secureuri : false,
    fileElementId : name,
    dataType : "json",
    data : null,
    success : function(data, status) {
      // 得到附件ID
      var aid = data.attributes.attachId;
      relateId = data.attributes.relateId;
      var htmlStr = '';
      if (aid == null || aid == "") {
        mini.alert("请选择需上传的附件!");
      } else {
        var attachName = data.attributes.attachName;
        htmlStr += '<div id="div_' + aid + '" class="fileStyle">' + '<input id="' + aid
            + '" type="button" onclick="delAttach(\'' + aid + '\')" value="删除" />' + '&nbsp;&nbsp;'
            + '<a href="javascript:downloadAttach(' + aid + ')"><span>' + attachName
            + '</span></a></div>';
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

function delAttach(id) {

  $('#div_' + id).remove(); 
  if (deleteId == "undefined,"){
    deleteId = id + ",";
  }else{
    deleteId += id + ",";
  }    
}

// 下载附件
function downloadAttach(attachId) {

  window.location.href = jsWebRoot + "/attachmentController/downloadCommonAttachment/" + attachId;
}

function onEmailTemplateButtonEdit(e) {
  btnEdit = this;
  OpenDialog(jsWebRoot + "/campusStudentController/sendByTemplate", "选择邮件模板 ", null, 750, 440,
      chooseEmailModel);
}

// 回调函数
function chooseEmailModel(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetTemplateData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    btnEdit.setText(data.text);
    editor.html(data.context);
    subjectText.setValue(data.subject);
    subjectText.setText(data.subject);
    $("#modelId").val(data.id);

    getAttachmentListToView(data.id);

  }
}
// 根据id获取邮件带有的模板
function getAttachmentListToView(id) {

  $.ajax({
    type : "post",
    dataType : "json",
    data : {
      id : id
    },
    url : jsWebRoot + "/attachmentController/getAttachmentList",
    success : function(data) {
      var status = data.status;
      if (status == 200) {
        var htmlStr = '';
        var list = data.attachments;
        if (list) {
          for (var i = 0; i < list.length; i++) {
            if (list[i].type == 'emailTemplate') {
              htmlStr += '<div id="div_' + list[i].id + '" class="fileStyle">' + '<input id="'
                  + list[i].id + '" type="button" onclick="delAttach(\'' + list[i].id
                  + '\')" value="删除" />' + '&nbsp;&nbsp;' + '<a href="javascript:downloadAttach('
                  + list[i].id + ')"><span>' + list[i].showName + '</span></a></div>';

            }
          }
          $("#span1").html(htmlStr);
        }

      } else {
        mini.alert("网络异常！");
      }
    },
    error : function() {
      mini.alert("网络异常！");
    }
  });

}

function saveTemplate() {
  var id = btnEdit.getValue();
  var data = form1.getData(true);// / 获取表单多个控件的数据
  /**
   * 表单序列化后的数据传参注意：Ajax参数不需要设置contentType
   */
  data.context = editor.html();
  form1.validate();
  if (form1.isValid() == false)
    return;
  mini.get("button1").setEnabled(false);
  mini.get("upLoadButton").setEnabled(false);
  var messageId = mini.loading("邮件发送中,请稍后...");
  if (id == null || id == "") {
    $.ajax({

      url : jsWebRoot + "/campusStudentController/sendEmailToStuByDef?type=" + type + "&ids=" + ids
          + "&relateId=" + relateId + "&deleteId=" + deleteId,
      type : "post",
      data : data,
      dataType : "json",
      success : function(data) {    
        mini.hideMessageBox(messageId);
        mini.alert(data.msg); 
          //CloseWindow("close");
      }
    });
  } else {
    $.ajax({

      url : jsWebRoot + "/campusStudentController/sendEmailToStuBytemplate?type=" + type + "&ids="
          + ids + "&relateId=" + id + "&attachId=" + relateId + "&deleteId=" + deleteId,
      type : "post",
      data : data ,
      dataType : "json",
      success : function(data) {
        mini.hideMessageBox(messageId);
        mini.alert(data.msg);
          //CloseWindow("close");
          
      }
    });
  }
}

function onCancel(e) {
  CloseWindow("close");
}

function SetData(e){
  
   mini.get("siteId").setValue(e.siteId);
   mini.get("postId").setValue(e.postId);
   mini.get("stuName").setValue(e.stuName);
   mini.get("school").setValue(e.school);
   mini.get("org").setValue(e.org);
   mini.get("center").setValue(e.center);
   mini.get("yearth").setValue(e.yearth);
   mini.get("showType").setValue(e.showType);
   mini.get("radioValue1").setValue(e.radioValue1);
   mini.get("radioValue2").setValue(e.radioValue2);
   mini.get("radioValue3").setValue(e.radioValue3);
   mini.get("radioValue4").setValue(e.radioValue4);
   mini.get("radioValue5").setValue(e.radioValue5);
   mini.get("radioValue6").setValue(e.radioValue6);
   mini.get("radioValue7").setValue(e.radioValue7);
   mini.get("radioValue8").setValue(e.radioValue8);
   
   
}