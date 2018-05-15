<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<!-- 发送短信-->
<html>
  <body>
    <div id="resume-send-message-win" class="mini-window" style="width: 550px;height: auto; display: none;" title="发送短信" showFooter="true">
	  	<div class="resume-transmit-div1" >
	      <table class="resume-send-message-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td width="20%" class="c999left">手机号：</td>
              <td>
                <textarea class="txtSendMeet" id="mobilePhone" name="mobilePhone" style="width:400px;height:80px;"></textarea>
              </td>
	          </tr>
	          <tr>
              <td></td>
              <td>
                <span class="c999">（多个号码以分号“;”隔开）</span>
              </td>
            </tr>
	          <tr>
              <td class="c999left">短信模板：</td>
              <td>
                <select name="sendResumeTemp" id="smsTemplate">
                	<option value="">请选择模版</option>
                    <c:forEach var="page" items="${sendResumeTempList}" varStatus="index">
                    	<c:if test="${page.type == 4}">
                    		<option value="${page.context}">${page.title}</option>
                    	</c:if>
                    </c:forEach>
                </select>
                <a id="btnLoadSmsTemplate" onclick="loadSmsTemplate()">加载</a>
                <c:if test="${ not empty u_template_templateManage }">
                  <a id="btnViewSmsTempate" target="_blank" href="/recruit/template/templateManage">查看</a>
                </c:if>
               </td>
              </tr>
	          	<tr>
                <td class="c999left">内容：</td>
                <td>
                  <textarea class="txtSendMeet" id="smsContent" name="smsContent" style="width:400px;height:80px;"></textarea>
                </td>
              </tr>
	          	<tr>
                <td></td>
                <td>
                  <input type="hidden" value="194" id="hidTotalCharCount">
                  <input type="hidden" value="6" id="hidEmployerNameCharCount">
                  <input type="hidden" value="70" id="hidCharsForSingleMessage">
                  <input type="hidden" value="67" id="hidCharsForMultipleMessage">
                  <span class="c999">不超过194个字）</span>
                  <span class="red" id="smsCountTip">将分成<span id="needSmsCount">1</span>条短信发送</span>
                  <!-- <span class="messageTagPop"></span>
                    <div style=" position:absolute; margin:0px 0px 0px 185px;margin:20px 0px 0px -44px\9;" class="release_prompt">
                        <div class="r_prompt_t"></div>
                        <div class="r_prompt_c">
                      		  短信字符数计数及条数计算规则：<br>
													1.字母、数字、汉字都计1个字符。<br>
													2.在每条短信末，雇得易会自动加入公司中文简称作为签名，格式是【华星光电】，短信字符数计数时会加上签名长度。<br>
													3.当短信（含签名）字符数不多于70时，计1条；大于70时，短消息进入长短信模式，此时，短信条数=字符长度除67（不足1条计1条）。<br>
													4. 上述规则由运营商制定，雇得易会随运营商规则调整而调整。
                        </div>
                        <div class="r_prompt_b"></div>
                     </div> -->
                </td>
              </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="sendMessage('resume-send-message-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('resume-send-message-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
  </body>
   <script type="text/javascript" src="${webRoot}/resources/js/templateManage/sendMessage.js"></script>
</html>