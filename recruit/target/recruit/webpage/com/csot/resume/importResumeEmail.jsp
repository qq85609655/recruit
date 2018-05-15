<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<html>
<head>
	<title>本地上传</title>
	<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
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
					class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">人才库</a><em
					class="path-icon">&gt;&gt;</em><span class="path-leaf">人才数据导入</span>
			</div>
			<div class="co-right-main co-right-center">
				<div class="con-title">本地上传</div>
				<div class="main">
				  <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                   <button class="posi-import-btn blue" id="position-import-button1"><span>本地上传</span></button>
                   <button class="posi-import-btn blue tab-up" id="position-import-button2" ><span>邮件导入</span></button>
                </td>
              </tr>
            </table>
				  <div class="position-import-div2">
				    <div class="tipBar" id="emailImport">
						<div class="msgBox">
							<a class="icon_close_a fr" title="关闭" href="javascript:void(0)" id="closeBull">关闭</a>
							<p class="email-import-help">
	               				 从邮箱中导入人才数据时：<br />
	                			1.自动忽略邮箱中不是有效简历的邮件（如垃圾邮件，广告等）<br />
	                			2.邮箱中包含同一个求职者重复投递的简历时，系统导入时只保留一份<br />
            				</p>
						</div>
						<form id="form1">    
						  <table class="table-pop ml10">
        					<tbody>
            			      <tr>
                				<td class="c999left" width="120">
                    				<span>邮箱帐号：</span>
                				</td>
                				<td>
                    			  <input type="text" name="userName" id="txtUserName" maxlength="100" class="w250" value="${userName}" />
                    			  <span class="gray">例如：wanke@hirede.com</span>
                				</td>
            				  </tr>
            				  <tr>
                				<td class="c999left">
                   					 <span>密码：</span>
                				</td>
                				<td>
                    			  <input type="password" class="w250" name="password" maxlength="20" value="${password}" />
                				</td>
            				  </tr>
            				  <tr>
                				<td class="c999left">
                   					 <span>接收邮件服务器：</span>
                				</td>
                				<td>
                    				<input type="text" name="server" maxlength="50" class="w250" value="${server}" />
                    				<span class="gray">例如：pop.example.com</span>
                				</td>
                				<td class="tips" id="tips">
                    			<span class="tips-icon"></span>
                    			<div class="tips-info">
                        		<div class="r_prompt_t">
                        		</div>
                        		<!-- <div class="r_prompt_c">
                            		如果您使用的邮箱是公司自己架设的，请咨询贵司的IT部门。对于995端口的话，就需要勾选我们页面上的安全套阶层协议，才能进行邮件导入简历。
	                            	<br />
	                            	<a href="#" id="SetMailServer" class="c0066cc">查看常用接收邮件服务器和端口设置</a>
                        		</div> -->
                        		<div class="r_prompt_b">
                        		</div>
                   			  </div>
                			</td>
            			  </tr>
            			  <tr>
                			<td class="c999left">
                    		<span>接收邮件服务器端口：</span>
                			</td>
                			<td >
                    			<input type="text" name="port" maxlength="4" class="w100" value="110" style="width:110px;"/>
                			</td>
            			  </tr>
            			  <tr>
                			<td class="c999left" width="130">
                    			<span>启用安全套接层协议：</span>
                			</td>
                			<td align="left">
                    			<input type="checkbox" name="useSSL" value="true" class="useSSL" />&nbsp;<span style="color: #666666;">如提交失败请尝试启用该选项，有些邮箱需选择此项（如：Hotmail）</span>
                			</td>
            			  </tr>
            			  <tr>
                			<td>
                    			&nbsp;
                			</td>
                			<td>
                    		  <p style="padding: 10px 0;">
                    		     <c:if test="${not empty u_file_uploadMail }">
                             	  <input type="button" id="submitBtn" class="submit_btn" value="开始导入" onclick="uploadMail()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             	  </c:if> <c:if test="${not empty u_resume_importResumeEmailRecord }">
                             	   <a class="c0066cc f12" style="color:#0066CC;font-size: 13px;" href="../resume/importResumeEmailRecord">查看邮件导入记录</a>
                			        </c:if>
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
<script type="text/javascript" src="${webRoot}/resources/js/importResumeEmail.js"></script>
</html>