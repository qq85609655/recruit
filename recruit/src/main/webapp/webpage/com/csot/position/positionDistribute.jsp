<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>职位分发-${position.positionName}</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/position/positionDistribute.css"/>
	  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
		<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  </head>
  <body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-left">
        <jsp:include page="/webpage/left-bar.jsp"></jsp:include>
      </div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易播职</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">职位分发</span>
    	  </div>
    	  <div class="co-right-main co-right-center">
			  	<div class="con-title">职位分发 - <span class="con-title-tip distribute-position-name" id="${position.recruitPositionId}">${position.positionName}</span></div>
			  	<div class="main">
			      <div class="position-distribute-main blue radius">
                <table class="position-distribute-tab1">
                  <tr>
                    <td>
                      <button class="posi-distribute-btn tab-up blue" id="position-distribute-button1"><span>招聘网站</span></button>
                      <button class="posi-distribute-btn blue" id="position-distribute-button2" ><span>58同城</span></button>
                    </td>
                  </tr>
                </table>
                <div class="posi-distribute-div tab-up">
                	<c:forEach items="${recruitSites}" var="r" varStatus="status">
                		<div class="distribute-surface ${r.siteName}-surface border-b-dotted">
                			<div class="distribute-inner-upper">
                				<input type="checkbox" name="${r.siteName}" id="${r.siteName}" value="${r.url}" class="site-expand"/>
                			</div>
                			<div class="distribute-inner-bottom">
                      	<img src="${webRoot}/resources/images/${r.siteName}.jpg"/> 
                    	</div>
                    	<div id="${r.siteName}-hidden-form" class="recruit-site-hidden-form">
                    		<div class="distribute-form-left">
                    			<form class="distribute-form" id="${r.siteName}-form">
                    				<table class="distribute-form-tab">
                            	<c:forEach items="${r.rsItem}" var="ri" varStatus="istatus">
                            		<c:if test="${istatus.last and !empty r.captchaName}">
                            			<tr>
                            				<td width="120"><font color="red">*</font><span>验证码:</span></td>
                            				<td><input type="text" id="${r.siteName}CaptchaInput" class="radius" data-rule="required"></input><img class="captcha-img" id="${r.siteName}Captcha" alt="" title="看不清,换一个" captchaName="${r.captchaName}" src="${webRoot}/resources/captcha/${r.siteName}/${r.captchaName}" onclick="refreshCaptcha('${r.url}','${r.siteName}Captcha')"></img></td>
                            			</tr>
                            		</c:if>
                            		<tr>
                            			<c:choose>
                            				<c:when test="${ri.required}">
                            					<td width="120"><font color="red">*</font><span>${ri.displayName}:</span></td>
                            					<td>
                            						<input type="${ri.inputType}" name="${r.siteName}-${ri.name}" id="${r.siteName}-${ri.name}" class="radius field-${ri.type}" data-rule="required"></input>
                            					</td>
                            				</c:when>
                            				<c:otherwise>
                            					<td width="120"><font>&nbsp;</font><span>${ri.displayName}:</span></td>
                            					<td>
                            						<input type="${ri.inputType}" name="${r.siteName}-${ri.name}" id="${r.siteName}-${ri.name}" class="radius field-${ri.type}"></input>
                            					</td>
                            				</c:otherwise>
                            			</c:choose>
                            		</tr>
                            	</c:forEach>
                            	<tr>
                              	<td></td>
                              	<td><input type="submit" name="${r.siteName}-submit" id="${r.siteName}-submit" class="btn radius" value="提交"></input></td>
                            	</tr>
                    				</table>
                    			</form>
                    		</div>
                    		<c:if test="${!empty r.tips}">
                    			<div class="distribute-form-right">
                        		<div class="tips">提示:${r.tips}</div>
                      		</div>
                    		</c:if>
                    	</div>
                    </div>
                	</c:forEach>
                </div>
			        	<div class="posi-distribute-div">
			        		<div class="posi-distribute-div-co">
			          		<a href="http://openapi.58.com/oauth2/authorize?client_id=29699029779200&redirect_uri=http%3A%2F%2Fpt.hirede.com%2FOAuth%2FOAuth2GrantCallback%3FplatformId%3D58%26returnUrl%3D%252FJobHipost%252FOAuthCallback%253FplatformId%253D58%2526jobIdString%253D142591%2526postSite%253Dwuba&response_type=code&state=733c78ebdd9a406e8aa8db864ceccfd2"><img alt="" src="${webRoot}/resources/images/58.jpg"></a>
			        		</div>
			        	</div>
			      </div>
			    </div>
	      </div>
		  </div>
	  </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
	<script type="text/javascript" src="${webRoot}/resources/js/position/positionDistribute.js"></script>
</html>