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
    url : jsWebRoot + "/attachmentController/uploadFiles?type=" + "emailTemplate" + "&relateId="
        + relateId,
    secureuri : false,
    fileElementId : name,
    dataType : "json",
    data : null,
    success : function(data, status) {
      // 得到附件ID
      var aid = data.attributes.attachId;
      if (aid == null || aid == "") {
        mini.alert("请选择需上传的附件!");
      } else {
        var attachName = data.attributes.attachName;
        // 添加可删除附件的链接
        $("#fileArea").append(
            "<div class='fileStyle' id='del_div_" + aid
                + "'><input type='button' value='删除' onclick='delAttach(\"" + aid
                + "\")'>&nbsp;&nbsp;<span>" + attachName + "</span></div>")
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
  
  window.location.href = jsWebRoot + "/attachmentController/downloadCommonAttachment/" + attachId;
}

// 回调函数
function chooseEmailModel(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetTemplateData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    btnEdit.setText(data.text);
    
    $("#modelId").val(data.id);
    editor.html(data.context);
  }
}

function saveTemplate() {
  $("input[name='docKeyWord']").each(function() {
    if ($(this).attr('checked') == false) {
      alert($(this).val());
    }
  });

  mini.get("button1").setEnabled(false)

  var data = form1.getData(true);// / 获取表单多个控件的数据
  /**
   * 表单序列化后的数据传参注意：Ajax参数不需要设置contentType
   */
  data.context = editor.html();
  form1.validate();
  if (form1.isValid() == false)
    return;
  if ($("#myFile").val() == "") {
    alert("上传文件不能为空！");
    $("#myFile").focus();
    return;
  } else {
    $.ajax({
      url : jsWebRoot + "/campusStudentController/sendEmailToStuByDef?type=" + type,
      type : "post",
      data : data,
      dataType : "json",
      success : function(data) {
        if (data.success == true) {
          alert(data.msg);
          CloseWindow("close", form1);
        } else {
          mini.alert("发送邮件失败！" + data.msg);
        }
      }
    });
  }
}

function onCancel(e) {
  CloseWindow();
}