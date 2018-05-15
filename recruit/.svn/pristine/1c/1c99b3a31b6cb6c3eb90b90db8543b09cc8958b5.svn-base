  mini.parse();
  var form = new mini.Form("mainForm");
  
  
  function saveData() {
    var id = mini.get("id").getValue();
	var password = mini.get("password1").getValue();
	var newPassword = mini.get("password").getValue();
    form.validate();
    if (form.isValid() == false) {
      return;
    }
    $.ajax({
        url : "/recruit/baseUserController/savePassword",
        type : 'post',
        async : false,
        data : {"id":id,"password":password,"newPassword":newPassword},
        dataType : "json",
        cache : false,
        success : function(data) {
          if (data.success) {
            CloseWindow(data);
            $("#mainForm")[0].reset();
          } else {
            mini.alert(data.msg);
          }
        },
        error : function(jqXHR, textStatus, errorThrown) {
          mini.alert(jqXHR.responseText);
          CloseWindow();
        }
      });
    
  }
  
  function onOk(){
	  saveData();
  } 
  function onCancel() {
    $("#mainForm")[0].reset();
  }

  function CloseWindow(action) {
    if (window.CloseOwnerWindow) {
      return window.CloseOwnerWindow(action);
    } else {
      alert(action.msg);
      window.close();
    }
  }

  function doublePasswordValidation(e) {
    if (e.isValid) {
      var password1 = mini.get("password");
      var password2 = mini.get("password2");
      console.log(password1.getValue());
      console.log(password2.getValue());
      if (password1.getValue() != password2.getValue()) {
        e.errorText = "两次密码输入必须相同";
        e.isValid = false;
      }
    }
    validErrorText(e);
  }

  // 作为统一的错误文本直接显示方法，需要有对应ID的_error Label标签配合
  function validErrorText(e) {
    var id = e.sender.name + "_error";
    var el = document.getElementById(id);
    if (el) {
      el.innerHTML = e.errorText;
    }
  }
  

  