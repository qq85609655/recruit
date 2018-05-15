$(document).ready(function() {
  $("#recruiterNumber").blur(function(){
    getUserName();
  });
});

function getUserName(){
  var account = $("#recruiterNumber").val();
  if(account == ""){
    return;
  }
  $.ajax({
    type : "post",
    async : false,
    dataType : "json",
    data : {"account" : $("#recruiterNumber").val()
    },
    url : basePath + "/interviewController/getUserName",
    success : function(data){
        if(data.success){
          $("#recruiterName").val(data.msg);
        }else{
          alert(data.msg);
        }
    },
    error: function() {
        $(".page-loading").hide();
        alert("输入工号有误!");
    }
});
}

//下一步
$("#toEdit").click(function() {
  var recruiterNumber = $("#recruiterNumber").val();
  var recruiterName = $("#recruiterName").val();
  var studentId = $("#studentId").val();
  if(recruiterNumber == '' || recruiterName == ''){
    alert("请正确填写招聘人员工号！");
    return;
  }
  window.location.href = basePath + "/interviewController/addInfo" +
  		"?recruiterNumber="+recruiterNumber+"&recruiterName="+encodeURI(encodeURI(recruiterName))
  		+"&studentId=" + studentId;
});
