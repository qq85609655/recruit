mini.parse();
function onButtonEdit(e) {
  btnEdit = this;
  OpenDialog(basePath + "/baseUserController/chooseBaseUserList", "选择面试官", null, 650, 380,chooseInterviews);
}
//回调函数
function chooseInterviews(action,e){
  if (action == "ok") {
    var iframe = e.getIFrameEl();

    var data = iframe.contentWindow.GetLinkmanData();
    data = mini.clone(data);
    btnEdit.setValue(data.id);
    $("#interviewer").val(data.id);
    btnEdit.setText(data.text);
  }
}

function subMit() {
  if($("#isEmailCheckbox").prop('checked') == true ){
    $("#isEmail").val(1);
  }else{
    $("#isEmail").val(0);
  }
  var flag = validationForm();
  if(flag){
      $.ajax({
      url : jsWebRoot + '/candidateRecommendController/candidateRecommendVoSave',
      type : 'POST', //GET
      async : true, //或false,是否异步
      data : $('#editform').serialize(),
      dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
      success: function(data) { 
        CloseWindow(data.msg);
      }, 
      error: function() { 
        CloseWindow("网络异常！");
      }
      })  
  }
}
function validationForm(){
  if($("#interviewer").val().length <= 0){
    mini.alert("面试官不能为空！");
    $("#linkman").focus();
    return false;
  }
  if($("input[type='radio']:checked").val()== undefined){
    mini.alert("请选择一份简历！");
    return false;
  }
  if($("#comments").val().length<= 0){
    mini.alert("评论不能为空！");
    return false;
  }
    
    return true ;
    
}





  
  



