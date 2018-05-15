<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>取消面试</title>
<style type="text/css">
 html, body
    {
        font-size:12px;
        padding:0;
        margin:0;
        border:0;
        height:100%;
        overflow:hidden;
        text-align:center;
    }
    
    div{
    padding-top: 20px;
    text-align: center;
    }
    table tr{
    display:block; /*将tr设置为块体元素*/
    margin:15px 0;  /*设置tr间距为2px*/
    }
    table tr td{
    }
</style>
</head>
<body>
  <input id="ids" type="hidden" name="ids" value="${ids }" />
  
  <div>
  <table>
      <tr>
        <td width="100px"> <font color="red">*</font>取消原因：</td>
        <td><textarea name="reason" id="reason" rows="6" cols="30"></textarea></td>
      </tr>
      <tr>
        <td width="150px">邮件提醒面试官：</td>
        <td><input id="isSend" type="hidden" name="isSend" value="" /> <input id="send"
          type="checkbox" name="isSendCheckbox" value="1"></td>
      </tr>
      <tr>
        <td width="160px"><a id="button1" style="width: 100px;" class="mini-button" onclick="save()">取消面试</a></td>
        <td width="160px"><a class="mini-button" style="width: 100px;" onclick="onCancel()">关闭窗口</a></td>
      </tr>

    </table>
      
           
   <br/>
  
  
  </div>

  <script type="text/javascript">
  function save() {
    if($("#send").prop('checked') == true ){
      $("#isSend").val(1);
    }
    if($.trim($("#reason").val()).length <= 0){
      alert("淘汰原因不能为空！");
      return;
    }
   $.ajax({
      url : basePath + "/interviewBookController/cancelInterviewBook",
      data :{
        ids:$("#ids").val(),
        reason : $("#reason").val(),
        isSend : $("#isSend").val()
      },
      type : "post",
      dataType : 'json',
      success : function(data) {
        alert(data.msg);
        CloseWindow("close");
      }
    }); 
  }
  
  function onCancel(e) {
    CloseWindow("close");
  }
    </script>
</body>
</html>