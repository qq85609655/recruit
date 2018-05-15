<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%> 
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/candidate/candidatePersonalResume.css"/>
   
    <title>中文简历</title>
  </head>
  <body>
    <div class="resume-item op-record" style="text-align: center;">
      <div style="padding: 20px;"><h3 style="font-weight:normal;color:#00a0e9;">面试记录</h3></div>
            <div >
              <ul class="ul-records">
                <c:set var="recordCount" value="0"></c:set>
                <c:forEach items="${interviewBookVoList}" var="o" varStatus="status">
                    <c:set var="recordCount" value="${recordCount+1}"></c:set>
                    <li class="bottom-dashed">
                      <div class="operate-infor">
                        <div>面试地点：<span>${o.interviewAddress}</span></div>
                        <div>面试时间：<span>${o.interviewTimes}</span></div>
                        <div>面试官：<span>${o.interviewers}</span></div>
                        <div>面试状态：<span>${o.interviewStatus}</span></div>
                        <div>反馈信息：<span>${o.feedback.content}</span></div>
                        <%-- <div>反馈时间：<span class="operate-time"><fmt:formatDate value="${o.feedback.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></span></div> --%>
                      </div>
                    </li>
                </c:forEach>
              </ul>
              <c:if test="${recordCount==0}">
                <div class="void-tip"><span>暂时无操作记录</span></div>
              </c:if>
            </div>
           <div style="padding: 20px;"><h3 style="font-weight:normal;color:#00a0e9;">录用记录</h3></div>
                   <div >
              <ul class="ul-records">
                <c:set var="employCount" value="0"></c:set>
                <c:forEach items="${employList}" var="item" varStatus="status">
                    <c:set var="employCount" value="${employCount+1}"></c:set>
                    <li class="bottom-dashed">
                      <div class="operate-infor">
                        <div>岗位：<span>${item.employPostName}</span></div>
                          <div>部门:<span>${item.employOrgName}</span></div>
                        <div>入职时间：<span class="operate-time"><fmt:formatDate value="${item.entryDate}" pattern="yyyy-MM-dd hh:mm:ss"/></span></div>
                        <div>发offer时间：<span class="operate-time"><fmt:formatDate value="${item.offerDate}" pattern="yyyy-MM-dd hh:mm:ss"/></span></div>
                        <div>流程状态：<span>
<c:if test="${item.flowState ==1}">未提交</c:if>
<c:if test="${item.flowState ==2}">审核中</c:if>
<c:if test="${item.flowState ==3}">废弃</c:if>
<c:if test="${item.flowState ==4}">审核通过</c:if>
                        </span></div>
                      </div>
                    </li>
                </c:forEach>
              </ul>
              <c:if test="${employCount==0}">
                <div class="void-tip"><span>暂时无操作记录</span></div>
              </c:if>
            </div>
          </div>
  </body>
</html>