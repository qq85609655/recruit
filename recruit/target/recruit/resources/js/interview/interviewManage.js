$(function() {
	mini.parse();
	var grid = mini.get("datagrid1");
	search();
});

function search() {
	var startDate = mini.get("startDate").getFormValue();
	var endDate = mini.get("endDate").getFormValue();
	var searchKey = $("#searchKey").val();
	var isAdmin = $("#isAdmin").val();
	var grid = mini.get("datagrid1");
	grid.load({startDate:startDate, 
	    endDate:endDate,
	    searchKey:searchKey,
	    isAdmin:isAdmin});
}

function editInfo() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
      var row=rows[0];
      var id = row.personCode;
      window.open(basePath + "/interviewController/editInfo?personCode=" + id);
   
  }else{
    alert("请先选中简历！");
  }
}

function exportData() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    if(rows.length==1){
      var row=rows[0];
      var id = row.personCode;
      var cnname=row.cnname;
      window.location = basePath + "/interviewController/exportResumeExcel?resumeId=" + id+"&name="+ encodeURI(encodeURI(cnname));
    }else{
      var ids="";
      for(var i=0;i<rows.length;i++){
        ids+=rows[i].personCode;
        if(i!=rows.length-1){
          ids+=",";
        }
      }
//      window.location = basePath + "/interviewController/exportBatchResumeExcel?resumeIds=" + ids;
      var messageId = mini.loading(" 正在努力下载中！<br>请稍候");
      $.ajax({
        url: basePath + "/interviewController/exportResumePrint",
        type: 'post',
        data: {'resumeIds':ids },
        dataType: "json",
        success: function (e) {
          mini.hideMessageBox(messageId);
        window.location.href = basePath+ "/attachmentController/download/zipFile?path=" +e.msg;
        },
        error : function(jqXHR, textStatus, errorThrown) {
          mini.hideMessageBox(messageId);
          var exceptionMessage = "";
          var responseJson = StringToJson(jqXHR.responseText);
          if (responseJson.exception) {
            exceptionMessage = responseJson.exception;
          } else {
            exceptionMessage = jqXHR.responseText;
          }
          exceptionMessage = exceptionMessage.length > 60 ? exceptionMessage.substr(0,60) : exceptionMessage;
          mini.alert(exceptionMessage);
        }
      });
    }
  }else{
    alert("请先选中简历！");
  }
}

function printResume() {
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if (rows.length > 0) {
    var ids="";
    for(var i=0;i<rows.length;i++){
      ids+=rows[i].personCode;
      if(i!=rows.length-1){
        ids+=",";
      }
    }
    $.ajax({
      url : basePath + "/interviewController/printResume?personCodes=" + ids,
      type : "post",
      success : function(data) {
        if (data.success == true) {
          mini.showTips({
            content: "打印成功!",            
            timeout: 3000
          });
        } else {
          mini.showTips({
            content: "打印失败!" + ajaxobj.msg,            
            timeout: 3000
          });
        }
      }
    });
  }else{
    alert("请先选中简历！");
  }
}

function onKeyEnter(e) {
    search();
}

function onDateRenderer(e) {
  var value = e.value;
  if (value) return new Date(value).format("yyyy-MM-dd");
  return "";
}