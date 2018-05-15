<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>淘汰</title>
<style>
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
        <input id="positionIds" type="hidden" name="positionIds" value="${positionIds }" />
  <%-- <div id="form1" class="main">
     
      <table class="form-table">
       
        <tr>
          <td>邮件提醒面试官：</td>
          <td>
             <input id="isSend" type="hidden" name="isSend" value="" />
          <input id="send" type="checkbox" name="isSendCheckbox" value="1">
          </td>
        </tr>
        
        
        <tr>
          <td class="form-label"><span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;淘汰原因：</td>
          <td>
           <input type="text" name="reason" id="reason" class="jobEdit-text radius1" style="width:150px;"></input></td>
        </tr>
        <tr></tr>
        <tr>
          <td><a id="button1" class="mini-button" onclick="save()">淘汰</a></td>
          <td> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a class="mini-button"
            style="width: 100px;" onclick="onCancel()">取消</a></td>
        </tr>
      </table>
    </form>
  </div> --%>
  <div>
  <table>
      <tr>
        <td width="100px"> <font color="red">*</font>淘汰原因：</td>
        <td><textarea name="reason" id="reason" rows="6" cols="30"></textarea></td>
      </tr>
      <tr>
        <td width="150px">邮件提醒面试官：</td>
        <td><input id="isSend" type="hidden" name="isSend" value="" /> <input id="send"
          type="checkbox" name="isSendCheckbox" value="1"></td>
      </tr>
      <tr>
        <td width="160px"><a id="button1" style="width: 100px;" class="mini-button" onclick="save()">淘汰</a></td>
        <td width="160px"><a class="mini-button" style="width: 100px;" onclick="onCancel()">取消</a></td>
      </tr>

    </table>
      
           
   <br/>
  
  
  </div>
</body>
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
      url : basePath + "/interviewBookController/outInterviewBook",
      data :{
        ids:$("#ids").val(),
        positionIds : $("#positionIds").val(),
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