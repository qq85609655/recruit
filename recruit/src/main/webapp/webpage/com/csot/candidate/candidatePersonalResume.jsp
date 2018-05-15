<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/candidate/candidatePersonalResume.css"/>
      <script>
    function setIframeHeight() {
      var height = Math.max($("#resumeSource")[0].contentWindow.document.body.scrollHeight,$("#resumeSource")[0].contentWindow.document.documentElement.scrollHeight);
      $("#resumeSource").css("height", height);
      
    }
  </script>
    <title>${resumeVo.name}的简历</title>
  </head>
  <body>
    <div class="head top body-co">
      <span id="account" class="none">${resumeVo.name}</span>
    </div>
    <div class="basic-infor body-co">
      <div class="basic-infor-left">
        <div class="resume-img">
          <span class="font-icon icon-user-1 default-img"></span>
        </div>
        <div class="basic-infor-co">
          <div class="tr-h">
            <span class="resume-name" id="resumeName">${resumeVo.name}</span>(<span id="resumeGender">${resumeVo.sex}</span> <span id="resumeAge">${resumeVo.age}</span>岁 <span id="resumeEdu">${resumeVo.highestEducation}</span>)&nbsp;&nbsp;&nbsp;应聘岗位：<span id="jobName">${resumeVo.jobName }</span>
          </div>
          <div class="tr">
            <span id="">${resumeVo.workExperience}年工作经验</span><span class="split">|</span><span>${resumeVo.address}</span><span class="split">|</span><span>${resumeVo.phone}</span><span class="split">|</span><span>${resumeVo.email}</span>
          </div>
          <div class="tr">
            <span class="basic-infor-lable">目前就职</span><span class="basic-infor-lable-co">${resumeVo.currentCompany}</span><span class="basic-infor-lable-co">${resumeVo.currentPosition}</span>
          </div>
          <div class="tr">
            <span class="basic-infor-lable">教育背景</span><span class="basic-infor-lable-co" id="edu">${resumeVo.highestEducation}</span><span class="basic-infor-lable-co" id="eduSchool">${resumeVo.school}</span><span class="basic-infor-lable-co" id="eduMajor">${resumeVo.major}</span>
          </div>
          <div class="tr tags-tr">
            <a id="tagAdd" class="icon-tags-text"><span class="font-icon icon-tags"></span><span>添加标签</span></a>
          </div>
        </div>
      </div>
      <div class="basic-infor-right">
        <div class="tr">
          <span class="basic-infor-lable">简历来源 :</span><span>${resumeVo.resumeorigin}</span>
        </div>
        <div class="tr">
          <span class="basic-infor-lable">招聘渠道 :</span><span>${resumeVo.channel}</span>
        </div>
        <div class="tr">
          <span class="basic-infor-lable">更新日期 :</span><span id="updateDate">${resumeVo.updateDate}</span>
        </div>
        <div class="tr">
          <span class="basic-infor-lable">入库时间 :</span><span>${resumeVo.storageDate}</span>
        </div>
      </div>
    </div>
    
    <div style="width: 100%;height: 30px;margin-left: 80px;"> 
      <ul>
            <c:forEach items="${list}" var="item" varStatus="status">
              <c:if test="${status.index==0}">
               <li id="${item.id}" name="${item.jobName }_${item.positionId}" class="resumelist currentCol">最新</li>
            </c:if>
            <c:if test="${status.index!=0}">
               <li id="${item.id}" name="${item.jobName }_${item.positionId}" class="resumelist">第${status.index + 1}份</li>
            </c:if>
           </c:forEach>
          </ul>
    </div>
    <div class="resume-co">
        <div class="resume-tool body-co">
          <ul>
           <li class="li-ul font-b current" id="resume">简历原文</li>
  					<li class="li-ul font-b" id="zh_resume">中文简历</li>
  					<li class="li-ul font-b" id="estimate">面试评估</li>
  					<li class="li-ul font-b" id="dynamic">@TA</li>
  					<li class="li-ul font-b" id="opRecord">面试、录用记录</li>
  					<li class="li-ul font-b" id="offer">聘用函</li>
  					<li class="li-more font-b" id="more">更多<span class="font-icon icon-down-dir"></span>
  						<div class="li-more-co radius">
  							<a class="more-li">在线测评</a>
  							<a class="more-li">背景调查</a>
  						</div>
  					</li>
          </ul>
        </div>
    </div>
    
    <input id="lockUserAccount" type="hidden" name="lockUserAccount" value="${resumeVo.lockUserAccount }" />
    <input id="flag" type="hidden" name="flag" value="resume" />
    
    <input id="interviewStatus" type="hidden" name="interviewStatus" value="${interviewStatus}" />
     <input id="candidateId" type="hidden" name="candidateId" value="${resumeVo.candidateId }" />
     <input id="positionId" type="hidden" name="positionId" value="${resumeVo.positionId }" />
     <input id="candidatePostId" type="hidden" name="candidatePostId" value="${resumeVo.candidatePostId }" />
    <div class="resume-source" style="width:72%;float: left;">
  	   <iframe id="resumeSource" src="" name="resumeSource" onload="setIframeHeight();" allowtransparency="true" scrolling="no" frameborder="0" width="95%"></iframe>
  	</div>
    <div class="resume-source" style="width:25%;float: right;">
          <div class="resu">
          <h3 style="font-weight:normal;color:#00a0e9;">您可以：</h3>
          <div class="table-operate">
                <input type="button" class="button radius btn" id="employ" value="推荐" onclick="recommend()" />
               <input type="button" class="button radius btn" id="bookInterview" value="安排面试" onclick="bookInterview()" />
               <input type="button" class="button radius btn" id="outbookInterview" value="淘汰" onclick="outbookInterview()" />
                <input type="button" class="button radius btn" id="changePositon" value="转向" onclick="changePositon()" />
                <input type="button" class="button radius btn" id="attention" value="关注" onclick="attention()" />
                <input type="button" class="button radius btn" id="export" value="导出标准简历" onclick="downStandradResume()" />
                <input type="button" class="button radius btn" id="export" value="导出简历原文" onclick="downResume()" />
            </div>
            </div>
            <div class="resu">
             <h3 style="font-weight:normal;color:#00a0e9;">操作记录</h3>
              <ul class="ul-comments">
                <c:forEach items="${ohList}" var="item" varStatus="status">
                          <li> 
                            <div class="comment-infor">
                              <div><a class="comment-name font-b">${item.operatorUser}</a></div>
                              <pre class="comment-content">${item.operatorContent}</pre>
                              <div class="comment-content-infor"><fmt:formatDate value='${item.operatorTime}' pattern='yyyy-MM-dd hh:mm:ss'/></div>
                            </div>
                          </li>
                    </c:forEach>
              </ul>
              </div>
           <div class="resu">
             <h3 style="font-weight:normal;color:#00a0e9;">招聘进度：
             <c:if test="${cp.interviewStatus ==0}">
                                                      候选人状态                                                   
             </c:if>
             <c:if test="${cp.interviewStatus ==10}">
                                                      安排面试                                                      
             </c:if>
              <c:if test="${cp.interviewStatus ==20}">
                                                     淘汰                                                 
             </c:if>
              <c:if test="${cp.interviewStatus ==30}">
                                                    录入流程中                                              
             </c:if>
             <c:if test="${cp.interviewStatus ==40}">
                                                   已经入职                                             
             </c:if>
             </h3>
            
              </div>
    </div>
    <jsp:include page="./tagSelect.jsp"/>
  </body>
  <script type="text/javascript">
var curName = '<shiro:principal type="java.lang.String"/>';
</script>
  <script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/candidate/candidatePersonalResume.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
</html>