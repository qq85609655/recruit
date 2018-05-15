<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>模板管理</title>
</head>
<body onload="removeLoad();">
	<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
		<div class="co-left">
			<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
		</div>
		<div class="co-right">
			<div class="position-path co-right-center">
				<span class="path-title">您的位置 :</span><a
					class="path-item a-decoration"
					href="${webRoot}/loginController/main">我的首页</a><em
					class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">系统管理</a><em
					class="path-icon">&gt;&gt;</em><span class="path-leaf">模板管理</span>
			</div>
			<div class="co-right-main co-right-center">
				<div class="con-title">模板管理</div>
				<div class="main">
				  <div class="position-import-main radius">
						<div class="msgBox">
							<p class="email-template-help">提示：模板类别,点击类别显示类别下的邮件模板 <br /></p>
						</div>
				    <div class="tipBar" id="emailTemplate">
							<div class="f14 mt10">
            		<a id="emailTemplateLink" class="" href="javascript:void(0)" style="font-size: 125%;" onclick="emailTemplateLink('#emailTemplateBox')"><strong>·邮件模板管理</strong></a>
        			</div>
        			<div id="emailTemplateBox" style="display:none;">
        		    <div class="f14 mt10">
            			<a id="interviewEmailTemplateLink" class="" href="javascript:void(0)" style="font-size: 120%;" onclick="interviewEmailTemplateLink('#interviewEmailTemplateBox')">·候选人面试邮件模板</a>
            			  <span class="cgray f12">（给候选人发面试邮件通知时的邮件附加信息）</span>
        				</div>
        				<div id="interviewEmailTemplateBox" style="display:none;">
        				  <table class="tGlobal mt10" >
        				    <thead>
        				      <tr class="bg">
        				        <th width="400">模板名称</th>
        				        <th>操作</th>
        				      </tr>
        				    </thead>
        				    <tbody>
        				      <c:forEach var="page" items="${templateList}">
        				      	<c:if test="${page.type eq '1'}">
        				      	  <tr class="">
        				            <td>${page.title}</td>
        				            <td>
        				              <c:if test="${not empty u_template_saveTemplate }">
        				              <a href="javascript:void(0)" class="uc03c" onclick="updateTemplate('1','${page.id}')">编辑</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_deleteTemplate}">
        				              &nbsp;&nbsp;|<a href="javascript:void(0)" class="uc03c btnDelete" data-id="${page.id}">删除</a>
        				              </c:if>
        				            </td>
        				          </tr>
        				      	</c:if>
        				      </c:forEach>
        				      <tr class="">
        				        <td colspan="2">
        				         <c:if test="${not empty u_template_saveTemplate }">
        				          <a id="addPlainTextTemplateClick" href="javascript:void(0)" class="uc03c" onclick="addPlainTextTemplateClick('#addPlainTextTemplate','#form1')">添加模板</a>
        				         </c:if>
        				        </td>
        				      </tr>
        				    </tbody>
        				  </table>
        				</div>
        				<div id="addPlainTextTemplate" style="display:none;">
        				  <form id="form1" enctype="multipart/form-data">    
						  	  <table class="table-pop ml10">
        						<tbody>
            			      	  <tr class="c666">
                				    <td class="c999left">
                    				  <span class="c111">*模板标题：</span>
                					</td>
                				    <td>
                				      <input type="hidden" name="templateType" id="templateType" maxlength="100" class="w250" value="1" />
                				      <input type="hidden" name="templateId" id="templateId" maxlength="100" class="w250" value="" />
                    			  	  <input type="text" name="templateTitle" id="templateTitle" maxlength="100" class="w250" value="" />
                					</td>
            				      </tr>
            				  	  <tr>
                					<td class="c999left">
                   					 <span class="c111">*模板内容：</span>
                					</td>
                					<td>
                    			  	  <textarea rows="10" cols="80" id="templateContext" name="templateContext"></textarea>
                					</td>
            				  	  </tr>
            				  	  <tr>
				                    <td valign="top" class="c999left">
				                        <label>附件：</label>
				                    </td>
				                    <td>
				                        <p style="font-size:14px;">(最多上传5个附件，单个大小不超过2MB)</p>
				                        <input type="button" id="addAttach" class="attch666" value="+"></input>
				                        <input type="file" style="display:none;" name="resumeFile1" id="resumeFile" onChange="getFileInfor()">
				                    </td>
				                    <td>
				                      <a href="javascript:void(0)"></a>
				                    </td>
				                  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    		  		  <p style="padding: 10px 0;">
                          	  			<input type="submit" class="submit_btn" value="保存" onclick="saveTemplateFile('#form1')"/>&nbsp;&nbsp;
                          	  			<input type="button" class="submit_btn" value="返回" onclick="returnTemplateManage()"/>
                          	  		  </p>
                					</td>
            			  		  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    				  <span class="red"></span>
                					</td>
            			  		  </tr>
        						</tbody>
    				  		  </table>
    						<span id="message" class="red"></span>
					      </form>
        				</div>
        				<!-- 发送简历通知邮件 -->
        				<div class="f14 mt10">
            				<a class="" href="javascript:void(0)" style="font-size: 120%;" onclick="interviewEmailTemplateLink('#templateType_2')">·发送简历通知邮件</a>
            				<span class="cgray f12">（发送简历通知邮件）</span>
        				</div>
        				<div id="templateType_2" style="display:none;">
        				  <table class="tGlobal mt10" >
        				    <thead>
        				      <tr class="bg">
        				        <th width="400">模板名称</th>
        				        <th>操作</th>
        				      </tr>
        				    </thead>
        				    <tbody>
        				      <c:forEach var="page" items="${templateList}">
        				      	<c:if test="${page.type eq '2'}">
        				      	  <tr class="">
        				            <td>${page.title}</td>
        				            <td>
        				              <c:if test="${not empty u_template_saveTemplate }">
        				                <a href="javascript:void(0)" class="uc03c" onclick="updateTemplate('2','${page.id}')">编辑</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_previewTemplateById }">
        				                <a href="javascript:void(0)" class="uc03c" onclick="previewTemplate('${page.id}')">预览</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_deleteTemplate}">
        				                &nbsp;&nbsp;|<a href="javascript:void(0)" class="uc03c btnDelete" data-id="${page.id}">删除</a>
        				              </c:if>
        				            </td>
        				          </tr>
        				      	</c:if>
        				      </c:forEach>
        				      <tr class="">
        				        <td colspan="2">
        				        <c:if test="${not empty u_template_saveTemplate }">
        				          <a id="addPlainTextTemplateClick2" href="javascript:void(0)" class="uc03c" onclick="addPlainTextTemplateClick('#addPlainTextTemplate2','#form2')">添加模板</a>
        				         </c:if>
        				        </td>
        				      </tr>
        				    </tbody>
        				  </table>
        				</div>
        				<div id="addPlainTextTemplate2" style="display:none;">
        				  <form id="form2" action="/recruit/template/previewTemplate" method="POST" target="_blank">    
						  	  <table class="table-pop ml10">
        						<tbody>
        						  <tr class="c666">
                    				<td class="c999left">
                        			  <label for="TemplateType">
                            		  <span class="red">*</span>模板类型：</label>
                    				</td>
                    				<td>
                        			  <input type="hidden" value="2" name="TemplateTypeId" id="TemplateTypeId">
                        			  <select name="TemplateTypeId" id="TemplateTypeId" disabled="True"><option value="">请选择模板类型</option><option value="1">候选人面试通知邮件</option><option value="2">聘用函邮件</option><option value="3">应聘表填写邀请模板</option><option value="4">候选人推荐模板</option><option value="5">电话面试通知面试官邮件</option><option value="6">现场面试通知面试官邮件</option><option value="7">现场面试内部会议安排通知邮件</option><option value="8" selected="selected">发送简历通知邮件</option><option value="9">淘汰感谢邮件通知</option><option value="10">电话面试通知候选人邮件</option></select>
                    				</td>
                				  </tr>
            			      	  <tr class="c666">
                				    <td class="c999left">
                    				  <span>*模板名称：</span>
                					</td>
                				    <td>
                    			  	  <input type="text" name="templateTitle" id="templateTitle2" maxlength="100" class="w250" value="发送简历通知邮件模版" />
                					</td>
            				      </tr>
            				      <tr class="c666">
                    				<td class="c999left">
                        			<label class="c111" for="Subject">
                            		<span class="red">*</span>邮件主题：</label>
                    				</td>
                    				<td>
                        			  <input type="text" value="发送简历通知[华星光电]" id="Subject2" name="Subject2" maxlength="100">
                    				</td>
                				  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    				  <span class="red"></span>
                					</td>
            			  		  </tr>
        						</tbody>
    				  		  </table>
    				  		  <ul id="tab_tit">
            					<li class="tab_active"><a>邮件正文</a></li>
        					  </ul>
        					  <table class="tblBox mt10" style="display: table;">
            				    <tbody>
                				  <tr>
                    			    <td colspan="3">
                        			  <label for="selMailParameters">
                           			        邮件参数：</label>&nbsp;&nbsp;&nbsp;
                        			  <select id="selMailParameters">
		                        		<option value="">请选择参数</option>
		                        		<option value="\${UserName}">发送人姓名</option>
		                        		<option value="\${sendReason}">附言</option>
		                        		<option value="\${ContactName}">联系人</option>
		                        		<option value="\${ContactPhone}">联系电话</option>
                        				<option value="\${CompanyName}">公司名称</option>
                        				<option value="\${sendDate}">发送日期</option>
                        			  </select>
                        			  <input type="button" id="btnAddParameter" class="btn2" onclick="btnAddParameter1('#selMailParameters')" value="添加">
                      			    </td>
                    			    <td>
                    			    </td>
                				  </tr>
                				  <tr>
                    			    <td>
                    			    	<textarea id="content_1"  name="templateContext" ></textarea>
                    			    </td>
                				</tr>
                				<tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    		  		  <p style="padding: 10px 0;">
                          	  			<input type="button" class="submit_btn" value="保存" onclick="saveTemplate('2')"/>&nbsp;&nbsp;
                          	  			<input type="submit" class="submit_btn" value="预览"/>
                          	  			<input type="button" class="submit_btn" value="返回" onclick="returnTemplateManage()"/>
                          	  		  </p>
                					</td>
            			  		  </tr>
            				  </tbody>
        					</table>
    						<span id="message" class="red"></span>
					      </form>
        				</div>
        				<!-- 淘汰感谢邮件通知 -->
        				<div class="f14 mt10">
            				<a class="" href="javascript:void(0)" style="font-size: 120%;" onclick="interviewEmailTemplateLink('#templateType_3')">·淘汰感谢邮件通知</a>
            				<span class="cgray f12">（淘汰感谢邮件）</span>
        				</div>
        				<div id="templateType_3" style="display:none;">
        				  <table class="tGlobal mt10" >
        				    <thead>
        				      <tr class="bg">
        				        <th width="400">模板名称</th>
        				        <th>操作</th>
        				      </tr>
        				    </thead>
        				    <tbody>
        				      <c:forEach var="page" items="${templateList}">
        				      	<c:if test="${page.type eq '3'}">
        				      	  <tr class="">
        				            <td>${page.title}</td>
        				            <td>
        				              <c:if test="${not empty u_template_saveTemplate }">
        				                <a href="javascript:void(0)" class="uc03c" onclick="updateTemplate('3','${page.id}')">编辑</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_previewTemplateById }">
        				                <a href="javascript:void(0)" class="uc03c" onclick="previewTemplate('${page.id}')">预览</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_deleteTemplate}">
        				                &nbsp;&nbsp;|<a href="javascript:void(0)" class="uc03c btnDelete" data-id="${page.id}">删除</a>
        				              </c:if>
        				            </td>
        				          </tr>
        				      	</c:if>
        				      </c:forEach>
        				      <tr class="">
        				        <td colspan="2">
        				          <a id="addPlainTextTemplateClick2" href="javascript:void(0)" class="uc03c" onclick="addPlainTextTemplateClick('#addPlainTextTemplate3','#form3')">添加模板</a>
        				        </td>
        				      </tr>
        				    </tbody>
        				  </table>
        				</div>
        				<div id="addPlainTextTemplate3" style="display:none;">
        				  <form id="form3" action="/recruit/template/previewTemplate" method="POST" target="_blank">    
						  	  <table class="table-pop ml10">
        						<tbody>
        						  <tr class="c666">
                    				<td class="c999left">
                        			  <label for="TemplateType">
                            		  <span class="red">*</span>模板类型：</label>
                    				</td>
                    				<td>
                        			  <input type="hidden" value="3" name="TemplateTypeId" id="TemplateTypeId2">
                        			  <select name="TemplateTypeId" id="TemplateTypeId2" disabled="True"><option value="">请选择模板类型</option><option value="1">候选人面试通知邮件</option><option value="2">聘用函邮件</option><option value="3">应聘表填写邀请模板</option><option value="4">候选人推荐模板</option><option value="5">电话面试通知面试官邮件</option><option value="6">现场面试通知面试官邮件</option><option value="7">现场面试内部会议安排通知邮件</option><option value="8">发送简历通知邮件</option><option value="9" selected="selected">淘汰感谢邮件通知</option><option value="10">电话面试通知候选人邮件</option></select>
                    				</td>
                				  </tr>
            			      	  <tr class="c666">
                				    <td class="c999left">
                    				  <span>*模板名称：</span>
                					</td>
                				    <td>
                    			  	  <input type="text" name="templateTitle" id="templateTitle3" maxlength="100" class="w250" value="淘汰感谢邮件模版" />
                					</td>
            				      </tr>
            				      <tr class="c666">
                    				<td class="c999left">
                        			<label class="c111" for="Subject">
                            		<span class="red">*</span>邮件主题：</label>
                    				</td>
                    				<td>
                        			  <input type="text" value="淘汰感谢邮件通知[华星光电]" id="Subject3" name="Subject2" maxlength="100">
                    				</td>
                				  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    				  <span class="red"></span>
                					</td>
            			  		  </tr>
        						</tbody>
    				  		  </table>
    				  		  <ul id="tab_tit">
            					<li class="tab_active"><a>邮件正文</a></li>
        					  </ul>
        					  <table class="tblBox mt10" style="display: table;">
            				    <tbody>
                				  <tr>
                    			    <td colspan="3">
                        			  <label for="selMailParameters2">
                           			        邮件参数：</label>&nbsp;&nbsp;&nbsp;
                        			  <select id="selMailParameters2">
		                        		<option value="">请选择参数</option>
		                        		<option value="\${UserName}">发送人姓名</option>
		                        		<option value="\${sendReason}">附言</option>
		                        		<option value="\${ContactName}">联系人</option>
		                        		<option value="\${ContactPhone}">联系电话</option>
                        				<option value="\${CompanyName}">公司名称</option>
                        				<option value="\${sendDate}">发送日期</option>
                        			  </select>
                        			  <input type="button" id="btnAddParameter2" class="btn2" onclick="btnAddParameter1('#selMailParameters2')" value="添加">
                      			    </td>
                    			    <td>
                    			    </td>
                				  </tr>
                				  <tr>
                    			    <td>
                    			    	<textarea id="content_2"  name="templateContext" ></textarea>
                    			    </td>
                				</tr>
                				<tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    		  		  <p style="padding: 10px 0;">
                          	  			<input type="button" class="submit_btn" value="保存" onclick="saveTemplate('3')"/>&nbsp;&nbsp;
                          	  			<input type="submit" class="submit_btn" value="预览"/>
                          	  			<input type="button" class="submit_btn" value="返回" onclick="returnTemplateManage()"/>
                          	  		  </p>
                					</td>
            			  		  </tr>
            				  </tbody>
        					</table>
    						<span id="message" class="red"></span>
					      </form>
        				</div>
        				</div>
        				<div class="f14 mt10">
            				<a id="msgTemplateLink" class="" href="javascript:void(0)" style="font-size: 125%;" onclick="msgTemplateLink('#msgTemplateBox')"><strong>·短信模板管理</strong></a>
        				</div>
        				<div id="msgTemplateBox" style="display:none;">
        				  <table class="tGlobal mt10" >
        				    <thead>
        				      <tr class="bg">
        				        <th width="400">模板名称</th>
        				        <th width="400">模板内容</th>
        				        <th>操作</th>
        				      </tr>
        				    </thead>
        				    <tbody>
        				      <c:forEach var="page" items="${templateList}">
        				      	<c:if test="${page.type eq '4'}">
        				      	  <tr class="">
        				            <td>${page.title}</td>
        				            <td>${page.context}</td>
        				            <td>
        				              <c:if test="${not empty u_template_saveTemplate }">
        				                <a href="javascript:void(0)" class="uc03c" onclick="updateTemplate('4','${page.id}')">编辑</a>
        				              </c:if>
        				              <c:if test="${not empty u_template_deleteTemplate}">
        				                &nbsp;&nbsp;|<a href="javascript:void(0)" class="uc03c btnDelete" data-id="${page.id}">删除</a>
        				              </c:if>
        				            </td>
        				          </tr>
        				      	</c:if>
        				      </c:forEach>
        				      <tr class="">
        				        <td colspan="2">
        				          <c:if test="${not empty u_template_saveTemplate }">
        				            <a id="addMsgTemplateClick" href="javascript:void(0)" class="uc03c" onclick="addPlainTextTemplateClick('#addMsgTextTemplate','#form1')">添加模板</a>
        				          </c:if>
        				        </td>
        				      </tr>
        				    </tbody>
        				  </table>
        				</div>
        				<div id="addMsgTextTemplate" style="display:none;">
        				  <form id="form4">    
						  	  <table class="table-pop ml10">
        						<tbody>
            			      	  <tr class="c666">
                				    <td class="c999left">
                    				  <span class="c111">*模板标题：</span>
                					</td>
                				    <td>
                				      <input type="hidden" name="templateType" id="msgTemplateType" maxlength="100" class="w250" value="4" />
                				      <input type="hidden" name="templateId" id="msgTemplateId1" maxlength="100" class="w250" value="" />
                    			  	  <input type="text" name="templateTitle" id="msgTemplateTitle1" maxlength="100" class="w250" value="" style="width:492px;" />
                					</td>
            				      </tr>
            				  	  <tr>
                					<td class="c999left">
                   					 <span class="c111">*模板内容：</span>
                					</td>
                					<td>
                    			  	  <textarea rows="10" cols="80" id="msgTemplateContext" name="templateContext"></textarea>
                					</td>
            				  	  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    		  		  <p style="padding: 10px 0;">
                          	  			<input type="submit" class="submit_btn" value="保存" onclick="saveMsgTemplate()"/>&nbsp;&nbsp;
                          	  			<input type="button" class="submit_btn" value="返回" onclick="returnTemplateManage()"/>
                          	  		  </p>
                					</td>
            			  		  </tr>
            			  		  <tr>
                					<td>
                    				&nbsp;
                					</td>
                					<td>
                    				  <span class="red"></span>
                					</td>
            			  		  </tr>
        						</tbody>
    				  		  </table>
    						<span id="message" class="red"></span>
					      </form>
        				</div>
					</div>
			  </div>
		  </div>
		</div>
	  </div>
	</div>
	<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
<script type="text/javascript"  charset="utf-8"  src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/templateManage/mailTemplateManage.js"></script>
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/mailTemplateManage.css" />
</html>