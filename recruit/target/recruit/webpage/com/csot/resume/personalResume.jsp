<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%> 
<html>
  <head>
  	<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/resume/personalResume.css"/>
  	<title>${resume.name}的简历</title>
  </head>
  <script>
  	function setIframeHeight() {
  		var height = Math.max($("#resumeSource")[0].contentWindow.document.body.scrollHeight,$("#resumeSource")[0].contentWindow.document.documentElement.scrollHeight);
  		$("#resumeSource").css("height", height);
  	}
  </script>
  <body>
  	<div class="page-loading"><span class="font-icon icon-spin6 animate-spin"></span></div>
  	<div class="head top body-co">
  		<div class="top-co">
  			<span class="resume-name" id="resume-name">${resume.name}</span>
  			<div class="head-item return">
  				<a><span class="font-icon icon-back"></span><span class="return-text">返回首页</span></a>
  			</div>
  			<div class="head-arrow"></div>
  		</div>
  		<span id="account" class="none">${user.account}</span>
  	</div>
  	
  	<div class="basic-infor body-co">
  		<div class="basic-infor-left">
  			<div class="resume-img">
  				<span class="font-icon icon-user-1 default-img"></span>
  			</div>
  			<div class="basic-infor-co">
  				<div class="tr-h">
  					<span class="resume-name" id="resumeName">${resume.name}</span>(<span id="resumeGender">${resume.sex}</span> <span id="resumeAge">${resume.age}</span>岁 <span id="resumeEdu">${resume.highestEducation}</span>)&nbsp;&nbsp;&nbsp;应聘岗位：${jobName }
  				</div>
  				<div class="tr">
  					<span id="">${resume.workExperience}年工作经验</span><span class="split">|</span><span>${resume.address}</span><span class="split">|</span><span>${resume.phone}</span><span class="split">|</span><span>${resume.email}</span>
  				</div>
  				<div class="tr">
  					<span class="basic-infor-lable">目前就职</span><span class="basic-infor-lable-co">${resume.currentCompany}</span><span class="basic-infor-lable-co">${resume.currentPosition}</span>
  				</div>
  				<div class="tr">
  					<span class="basic-infor-lable">教育背景</span><span class="basic-infor-lable-co" id="edu">本科</span><span class="basic-infor-lable-co" id="eduSchool">清华大学</span><span class="basic-infor-lable-co" id="eduMajor">材料科学与工程</span>
  				</div>
  				<div class="tr tags-tr">
  					<a id="tagAdd" class="icon-tags-text"><span class="font-icon icon-tags"></span><span>添加标签</span></a>
  				</div>
  			</div>
  		</div>
  		<div class="basic-infor-right">
  			<div class="tr">
  				<span class="basic-infor-lable">简历来源 :</span><span>${resume.resumeorigin}</span>
  			</div>
  			<div class="tr">
  				<span class="basic-infor-lable">招聘渠道 :</span><span>${resume.channel}</span>
  			</div>
  			<div class="tr">
  				<span class="basic-infor-lable">更新日期 :</span><span id="updateDate"><fmt:formatDate value="${resume.updateDate}" pattern="yyyy-MM-dd" /></span>
  			</div>
  			<div class="tr">
  				<span class="basic-infor-lable">入库时间 :</span><span><fmt:formatDate value="${resume.storageDate}" pattern="yyyy-MM-dd" /></span>
  			</div>
  		</div>
  	</div>
  	
  	<div class="resume-co">
  			<div class="resume-tool body-co">
  				<ul>
  					<li class="li-ul font-b current">简历原文</li>
  					<li class="li-ul font-b">中文简历</li>
  					<li class="li-ul font-b">面试评估</li>
  					<li class="li-ul font-b" id="dynamic">@TA</li>
  					<li class="li-ul font-b" id="opRecord">操作记录</li>
  					<li class="li-ul font-b">聘用函</li>
  					<li class="li-more font-b">更多<span class="font-icon icon-down-dir"></span>
  						<div class="li-more-co radius">
  							<a class="more-li">在线测评</a>
  							<a class="more-li">背景调查</a>
  						</div>
  					</li>
  				</ul>
  			</div>
  			<div class="resume">
  				<div class="resume-attach">
  					<div class="left">
  						<span class="attach-bar">简历附件 : </span>
  						<div class="attach-list">
  							<a><span class="font-icon icon-doc-text font-b"></span><span class="font-b">简历原文</span>(<span>${resume.resumeSize}</span>)</a>
  							<a id="attachUpload" class="resume-op"><span class="font-icon icon-upload-1 font-b" title="上传附件"></span></a>
  						</div>
  					</div>
  					<div class="right">
  						<a id="resumeOpenNewWin" class="resume-op" target="_blank" href="${resume.resumeDir}"><span id="" class="font-icon icon-popup font-b" title="新窗口中打开"></span></a>
  						<a id="resumeDownload" class="resume-op" href="${webRoot}/resume/downloadResume?resumePath=${resume.resumeDir}&resumeName=${resume.name}"><span class="font-icon icon-download-1 font-b" title="下载"></span></a>
  						<a id="resumePrint" class="resume-op" target="_blank" href="${webRoot}/resources/html/resumePrint.html?resumePath=${resume.resumeDir}"><span id="" class="font-icon icon-print-1 font-b" title="打印"></span></a>
  					</div>
  				</div>
  				<div class="resume-item resume-original current">
  					<!-- <div><span>应聘职位 : </span><span class="infor-text font-b">PM高级工程师 (深圳)</span></div>
  					<div><span>投递时间 : </span><span class="infor-text font-b">2015-08-17</span></div>
  					<div><span>简历匹配度 : </span><span class="infor-text"></span>
  						<div class="progressing">
  							<div class="current statu03"><span class="progress-text t-right">60%</span></div>
  						</div>
  					</div> -->
  					<div class="resume-source">
  						<iframe id="resumeSource" src="${resume.resumeDir}" name="resumeSource" onload="setIframeHeight();" allowtransparency="true" scrolling="no" frameborder="0"></iframe>
  					</div>
  				</div>
  				<div class="resume-item resume-zh">
  					<div class="co">
  						<div class="co-item zh-basic-infor b-solid">
  							<div class="co-title">基本信息</div>
  							<div class="co-co">
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">姓名：</span><span id="" title="" class="value">${resume.name}&nbsp;</span>
  									</div>
  									<div class="co-td">
  										<span class="label">性别：</span><span id="" title="" class="value">${resume.sex}&nbsp;</span>
  									</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">出生日期：</span><span id="resumeBirthday" class="value"><fmt:formatDate value="${resume.birthday}" pattern="yyyy-MM-dd" />&nbsp;</span>
  									</div>
  									<div class="co-td">
  										<span class="label">当前所在地：</span><span id="currentLocation" title="" class="value">${resume.residence}&nbsp;</span>
  									</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">工作年限：</span><span id="" title="" class="value">${resume.workExperience}年&nbsp;</span>
  									</div>
  									<div class="co-td">
  										<span class="label">婚姻状况：</span><span id="" title="" class="value">${resume.maritalStatus}&nbsp;</span>
  									</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">手机号码：</span><span id="" title="" class="value">${resume.phone}&nbsp;</span>
  									</div>
  									<div class="co-td">
  										<span class="label">Email：</span><span id="" title="" class="value">${resume.email}&nbsp;</span>
  									</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">联系地址：</span><span id="" title="${resume.address}" class="value">${resume.address}&nbsp;</span>
  									</div>
  								</div>
  							</div>
  						</div>
  						<div class="co-item zh-job-intension b-solid">
  						  <div class="co-title">求职意向</div>
								<div class="co-co">
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">期望月薪：</span><span id="" title="" class="value">${resume.salaryExpect}&nbsp;</span>
  									</div>
  										<div class="co-td">
  											<c:if test="${resume.reportTime!=null}">
  												<span class="label">可到岗时间：</span><span id="" title="" class="value">${resume.reportTime}&nbsp;</span>
  											</c:if>
  										</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">意向地区：</span><span id="" title="" class="value">${resume.workplaceExpect}&nbsp;</span>
  									</div>
  									<div class="co-td">
  										<c:if test="${resume.reportTime!=null}">
  											<span class="label">提供住房：</span><span id="" title="" class="value">${resume.provideHouse}&nbsp;</span>
  										</c:if>
  									</div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">意向行业：</span><span id="" title="" class="value">${resume.industryExpect}&nbsp;</span>
  									</div>
  									<div class="co-td"></div>
  								</div>
  								<div class="co-tr">
  									<div class="co-td">
  										<span class="label">意向岗位：</span><span id="" title="" class="value">${resume.postExpect}&nbsp;</span>
  									</div>
  								</div>
  							</div>
  						</div>
  						<div class="co-item zh-work-experience b-solid">
  						  <div class="co-title">工作经历</div>
  							<div class="co-co">
  								<c:forEach items="${resume.workExperienceList}" var="w" varStatus="status">
                  	<c:choose>  
                    	<c:when test="${status.last}">
                    		<div class="co-co-item">
                    	</c:when>
                    	<c:otherwise>  
                      	<div class="co-co-item b-dashed">
                    	</c:otherwise>
                  	</c:choose>
                  		<div class="corp-job"><span>${w.companyName}</span>--<span>${w.positionName}</span></div>
  										<div class="corp-job-co">
  											<div class="co-tr">
  												<div class="co-td">
  													<span class="label">开始日期：</span><span class="value"><fmt:formatDate value="${w.jobStartDate}" pattern="yyyy年MM月"/></span>
  												</div>
  											</div>
  											<div class="co-tr">
  												<div class="co-td">
  													<span class="label">结束日期：</span><span class="value"><fmt:formatDate value="${w.jobEndDate}" pattern="yyyy年MM月"/></span>
  												</div>
  											</div>
  											<div class="co-tr">
  												<div class="co-td">
  													<span class="label">工作职责：</span><span class="value">(${w.workLength})</span>&nbsp;<span class="currency">${w.currency}</span><span class="value"><c:if test="${w.salary!=0}">${w.salary}</c:if></span>
  												</div>
  											</div>
  											<div class="job-duties font-black">${w.jobDuty}</div>
  										</div>
  									</div>
                	</c:forEach>
  							</div>
  						</div>
  						<div class="co-item zh-work-experience b-solid">
  						  <div class="co-title">教育经历</div>
  							<div class="co-co">
  								<c:forEach items="${resume.eduExperienceList}" var="e" varStatus="status">
  									<div class="co-tr">
  										<span class=""><fmt:formatDate value="${e.eduStartDate}" pattern="yyyy年MM月"/></span>-<span class=""><fmt:formatDate value="${e.eduEndDate}" pattern="yyyy年MM月"/></span>&nbsp;&nbsp;<span>${e.schoolName}</span>，<span>${e.major}</span>，<span>${e.education}</span>
  									</div>
  								</c:forEach>
  							</div>
  						</div>
  						<c:if test="${resume.trainInfor!=null}">
  							<div class="co-item zh-trainInfor b-solid">
  						  	<div class="co-title">培训信息</div>
  								<div class="co-co">${resume.trainInfor}</div>
  							</div>
  						</c:if>
  						<c:if test="${resume.languageInfor!=null}">
  							<div class="co-item zh-languageInfor b-solid">
  						  	<div class="co-title">语言信息</div>
  								<div class="co-co">${resume.languageInfor}</div>
  							</div>
  						</c:if>
  						<c:if test="${resume.certificateInfor!=null}">
  							<div class="co-item zh-certificateInfor b-solid">
  						  	<div class="co-title">证书信息</div>
  								<div class="co-co">${resume.certificateInfor}</div>
  							</div>
  						</c:if>
  						<c:if test="${resume.awardInfor!=null}">
  							<div class="co-item zh-awardInfor b-solid">
  						  	<div class="co-title">获奖信息</div>
  								<div class="co-co">${resume.awardInfor}</div>
  							</div>
  						</c:if>
  						<c:if test="${resume.skillText!=null}">
  							<div class="co-item zh-skillInfor b-solid">
  						  	<div class="co-title">其它技能信息</div>
  								<div class="co-co">${resume.skillText}</div>
  							</div>
  						</c:if>
  						<c:if test="${resume.hobbyInfor!=null}">
  							<div class="co-item zh-hobbyInfor b-solid">
  						  	<div class="co-title">获奖信息</div>
  								<div class="co-co">${resume.hobbyInfor}</div>
  							</div>
  						</c:if>
  					</div>
  				</div>
  				<div class="resume-item interview-evaluate">
  					<div class="co">
  						<div class="void-tip">暂时没有相关数据</div>
  					</div>
  				</div>
  				<div class="resume-item at-ta">
  					<div class="co" style="ovewflow:hidden">
  						<div class="co-tr">@/评论<div class="text-tip">还可以输入<span class="text-num">200</span>字</div></div>
  						<div class="comment-div">
  							<pre><span></span><br/></pre>
  							<textarea id="commentInput" class="comment-input" placeholder="注:此处@功能暂时没有"></textarea>
  						</div>
  						<div class="co-tr" style="height:auto;" >
  						<span class="co-label">添加附件 : </span>
  						<div id="plugOperate">
  							<div id="addPlugs"></div>
  							<a class="a-btn font-b radius" id="fileList">+从资料库选择</a>
  							<a class="a-btn  font-b radius">+上传</a>
  							<div class="view-range" >
  								<span id="viewRange">公开</span>
  								<span class="font-icon icon-down-dir"></span>
  								<div class="li-more-co radius">
  									<div class="more-a"><span class="font-icon icon-globe"></span><span class="text">公开</span><div class="more-a-tip"><i></i>公开 : 所有招聘专员和当前流程的面试官可以查看</div></div>
  									<div class="more-a"><span class="font-icon icon-lock-1"></span><span class="text">私密</span><div class="more-a-tip"><i></i>私密 : 仅该职位的招聘专员、被@的对象可以查看</div></div>
  								</div>
  							</div>
  							<span class="view-range-tip"><span id="view-range-tip-0">所有招聘专员、当前流程的面试官、</span><span id="view-range-tip-1" class="none">当前职位的招聘专员、</span>被@对象可以看到</span>
  						</div>
  						<div class="fileData" >
  							 
  					  </div>
  						</div>
  						<div class="clear"></div>
  						<div class="button-send" >
  							<input type="button" id="commentConfirm" class="button radius btn btn-send" value="确定"></input>
  						</div>
  						<div class="comment-list">
  							<div class="title co-tr">最新动态</div>
  							<ul class="ul-comments">
  								<c:set var="commentCount" value="0"></c:set>
  								<c:forEach items="${resume.opRecords}" var="o" varStatus="statu">
  									<c:if test="${o.operatetype=='2'}">
  										<c:set var="commentCount" value="${commentCount+1}"></c:set>
  										<li>
  											<div class="head-img"><span class="font-icon icon-user-1"></span></div>
  											<div class="comment-infor">
  												<div><a class="comment-name font-b">${o.account}</a></div>
  												<pre class="comment-content">${o.logcontent}</pre>
  												<div class="comment-content-infor"><span title="<fmt:formatDate value='${o.operatetime}' pattern='yyyy-MM-dd hh:mm:ss'/>">${o.time}</span><span class="comment-split">|</span><span>${resume.applyPosition.positionName}</span><span class="comment-split">|</span><span class="font-icon font-b ${o.privacylevel == 0 ? 'icon-lock-2' : 'icon-public'}"></span></div>
  											</div>
  										</li>
  									</c:if>
  								</c:forEach>
  								<c:if test="${commentCount==0}">
  									<div class="void-tip"><span>暂时无评论</span></div>
  								</c:if>
  							</ul>
  						</div>
  					</div>
  				</div>
  				<div class="resume-item op-record">
  					<div class="co">
  						<ul class="ul-records">
  							<c:set var="recordCount" value="0"></c:set>
  							<c:forEach items="${resume.opRecords}" var="o" varStatus="status">
  								<c:if test="${o.operatetype == '1'}">
  									<c:set var="recordCount" value="${recordCount+1}"></c:set>
  									<li class="bottom-dashed">
  										<div class="head-img"><span class="font-icon icon-user-1"></span></div>
  										<div class="operate-infor">
  											<div><a class="user-name font-b">${o.account}</a><span class="operate-time"><fmt:formatDate value="${o.operatetime}" pattern="yyyy-MM-dd hh:mm:ss"/></span></div>
  											<div><span>${o.logcontent}</span> @ <a class="font-b" title="${resume.applyPosition.positionName}">${resume.applyPosition.positionName}</a></div>
  										</div>
  									</li>
  								</c:if>
  							</c:forEach>
  						</ul>
  						<c:if test="${recordCount==0}">
  						  <div class="void-tip"><span>暂时无操作记录</span></div>
  						</c:if>
  					</div>
  				</div>
  				<div class="resume-item hire-letter">
  					<div class="co">
  						<div class="void-tip">暂时没有相关数据</div>
  					</div>
  				</div>
  			</div>
  			<ul class="resume-right">
  				<li class="resume-right-item more-function">
  					<div class="title"><span class="font-icon icon-monitor font-b"></span>您可以<div class="split"></div></div>
  					<div class="co">
  						<c:if test="${resume.resumeStatus==0}">
  							<div class="operate-bar">
  								<a class="operate-bar-item" id="toCandidate">加为候选人</a>
  							</div>
  						</c:if>
  						<c:if test="${resume.resumeStatus==1}">
  							<div class="operate-bar">
  								<a class="operate-bar-item" id="toRecomend">推荐</a>
  								<a class="operate-bar-item" id="toInterview">进入面试</a>
  								<a class="operate-bar-item" id="toObsolete">淘汰</a>
  								<a class="operate-bar-item" id="toSwerve">转向</a>
  							</div>
  						</c:if>
  						<div class="operate">
  							<a class="operate-edit font-b a-ul" href="/recruit/resume/editResume/${resume.id}">编辑简历</a>
  							<c:if test="${not empty u_resume_sendMessage }">
  							  <a class="operate-sms font-b a-ul" id="sendMessage" onclick="openSendMessage('resume-send-message-win','#sendMessage')">发送短信</a>
  							</c:if>
  							<a class="operate-more font-b">更多<span class="font-icon expand icon-angle-double-down"></span></a>
  						</div>
  						<div class="operate-more-list">
  							<div class="operate">
  								<a class="operate-watch font-b a-ul">跟盯</a>
  								<c:if test="${not empty u_resume_transmitResume }">
  								<a class="operate-transmit font-b a-ul" >转发</a>
  								</c:if>
  							</div>
  							<div class="operate">
  							  <c:if test="${not empty u_resume_downloadResume }">
	  								<a id="operateExport" class="operate-export font-b a-ul" href="${webRoot}/resume/downloadResume?resumePath=${resume.resumeDir}&resumeName=${resume.name}">导出</a>
	  								<a id="operatePrint" class="operate-print font-b a-ul" target="_blank">打印</a>
  								</c:if>
  							</div>
  						</div>
  					</div>
  				</li>
  				<li class="resume-right-item dynamic" id="dynamicRight">
  					<div class="title"><span class="font-icon icon-at font-b"></span>Ta动态<div class="split"></div></div>
  					<div class="co">
  						<ul class="ul-comments">
  							<c:choose>
  								<c:when test="${commentCount>0}">
  									<c:set var="num" value="0"></c:set>
  									<c:forEach items="${resume.opRecords}" var="o" varStatus="status">
  										<c:if test="${o.operatetype=='2'}">
  											<c:set var="num" value="${num+1}"></c:set>
  											<c:if test="${num<4}">
  												<li> 
  													<div class="head-img"><span class="font-icon icon-user-1"></span></div>
  													<div class="comment-infor">
  														<div><a class="comment-name font-b">${o.account}</a></div>
  														<pre class="comment-content">${o.logcontent}</pre>
  														<div class="comment-content-infor"><span title="<fmt:formatDate value='${o.operatetime}' pattern='yyyy-MM-dd hh:mm:ss'/>">${o.time}</span><span class="comment-split">|</span><span>${resume.applyPosition.positionName}</span><span class="comment-split">|</span><span class="font-icon font-b ${o.privacylevel==0?'icon-lock-1':'icon-public'}"></span></div>
  													</div>
  												</li>
                  			</c:if>
  										</c:if>
  									</c:forEach>
  								</c:when>
  								<c:otherwise>
  									<div class="void-tip"><span>暂时无评论</span></div>
  								</c:otherwise>
  							</c:choose>
  						</ul>
  					</div>
  					<c:if test="${commentCount>3}">
  						<div class="review-more"><a class="view-more-a">查看更多...</a></div>
  					</c:if>
  				</li>
  				<li class="resume-right-item operate-record" id="opRecordRight">
  					<div class="title"><span class="font-icon icon-docs font-b"></span>操作记录<div class="split"></div></div>
  					<div class="co">
  						<ul class="ul-records">
  							<c:choose>
  								<c:when test="${recordCount>0}">
  									<c:set var="num" value="0"></c:set>
  									<c:forEach items="${resume.opRecords}" var="o" varStatus="status">
  										<c:if test="${o.operatetype=='1'}">
  											<c:set var="num" value="${num+1}"></c:set>
  											<c:if test="${num<4}">
  												<li class="bottom-dashed">
  													<div class="head-img"><span class="font-icon icon-user-1"></span></div>
  													<div class="operate-infor">
  														<div><a class="user-name font-b">${o.account}</a><span class="operate-time"><fmt:formatDate value="${o.operatetime}" pattern="yyyy-MM-dd hh:mm:ss"/></span></div>
  														<div><span>${o.logcontent}</span> @ <a class="font-b" title="${resume.applyPosition.positionName}">${resume.applyPosition.positionName}</a></div>
  													</div>
  												</li>
                  			</c:if>
  										</c:if>
  									</c:forEach>
  								</c:when>
  								<c:otherwise>
  									<div class="void-tip"><span>暂时无操作记录</span></div>
  								</c:otherwise>
  							</c:choose>
  						</ul>
  				</div>
  				<c:if test="${recordCount>3}">
  					<div class="review-more"><a class="view-more-a">查看更多...</a></div>
  				</c:if>
  			</li>
  			<li class="resume-right-item recruit-progress">
  				<div class="title"><span class="font-icon icon-progress-0 font-b"></span>招聘进度<div class="split"></div></div>
  				<div class="co">
  					<span>职位 : </span><a class="font-b">${resume.applyPosition.positionName}</a><span class="font-icon icon-down-dir"></span>
  					<div class="progressing" id="recruitProgress">
  						<c:if test="${resume.resumeStatus==0}"> <!-- 人才库  -->
  							<div class="current statu00"><span class="progress-text t-bottom"></span></div>
  						</c:if>
  						<c:if test="${resume.resumeStatus==1}"> <!-- 候选人 -->
  							<div class="current statu01"><span class="progress-text t-bottom"></span></div>
  						</c:if>
  					</div>
  				</div>
  			</li>
  		</ul>
  	</div>
  	
		<!-- 文件上传 -->
  	<div id="fileSelectWin" class="mini-window" style="width: 500px; display: none;" title="文件上传 " showFooter="true">
	    <div class="pop-main">
	     	<div class="file-list"></div>
	     	<div class="select-tr">
	     		<input type="file" name="selectFileR" class="none" id="selectFileR"></input>
	     		<input type="button" class="select-file" id="selectFile" value="+添加附件"></input>
	     		<span id="uploadTip" class="upload-tip">
	     			成功上传(<span id="sucSize"></span>/<span id="totalSize"></span>)
	     		</span>
	     	</div>
	     	<div id="uploadFailedTip" class="upload-failed-tip"></div>
	      <div property="footer" class="win-footer">
	      	<input type="button" class="win-footer-btn" value="上传" id="selectFileConfirm">
	        <input type="button" class="win-footer-btn" value="取消" id="selectFileCancle" onclick="hideWindow('#fileSelectWin',setAttach)">
	      </div>
	    </div>
    </div>
  	<jsp:include page="./toCandidate.jsp"/>
  	<jsp:include page="./tagSelect.jsp"/>
  	<jsp:include page="../publicPage/sendResume.jsp"/>
  	<jsp:include page="../publicPage/sendMessage.jsp"/>
  	<jsp:include page="/webpage/footer.jsp"/>
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/personalResume.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
</html>