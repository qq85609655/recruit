<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>本地上传</title>
	<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
</head>
<body onload="removeLoad();">
	<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
			<div class="position-path co-right-center">
				<span class="path-title">您的位置 :</span><a
					class="path-item a-decoration"
					href="${webRoot}/loginController/main">我的首页</a><em
					class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">人才库</a><em
					class="path-icon">&gt;&gt;</em><span class="path-leaf">人才数据导入</span>
			</div>
			<div class="co-right-main co-right-center">
				<div class="con-title">数据导入</div>
				<div class="main">
					<div class="position-import-main blue radius">
						<table class="position-import-tab1">
							<tr>
								<td>
									<button class="posi-import-btn blue tab-up" id="position-import-button1"><span>本地上传</span></button>
									<button class="posi-import-btn blue " id="position-import-button2"><span>邮件导入</span></button>
								</td>
							</tr>
						</table>
							<div class="position-import-div1">
								<div class="tipBar" id="helpBull">
									<div class="msgBox">
										<a class="icon_close_a fr" title="关闭" href="javascript:void(0)" id="closeBull">关闭</a>
										<p class="email-import-help">
											1.您只需要将保存在本地的简历上传，系统会自动帮您生成标准的简历。<br/>
											2.批量上传需要安装flash播放器，如果您的电脑没有安装flash播放器，请点击<a href="http://get.adobe.com/cn/flashplayer/" target="_blank" style="color: red;">这里</a>下载安装。<br/>
											3.单份上传模式文件大小限制为500k；批量上传模式下可上传20个文件，单文件不超过4M，总大小不超过20M。
										</p>
									</div>
									<div class="msgBox none">
										<a class="icon_close_a fr" title="关闭" href="javascript:void(0)" id="closeExcelMsg">关闭</a>
										<p class="email-import-help">
											通过标准EXCEL模板逐条导入候选人数据。<br/> 
											1.请参照标准模板整理候选人资料，excel每行为一名候选人，一次最多导入200人。<br/>
											2.导入后，系统实时反馈导入结果，您可以下载导入失败的列表重新整理，再次导入
										</p>
									</div>
								</div>
								<div id="upload-tab" class="upload-tab">
									<span class="hover"> 
										<input type="radio" name="uploadMode" id="single" value="1" checked="checked" />
										<label for="single"><b>单份上传</b></label>
									</span> 
									<span> 
										<input type="radio" name="uploadMode" id="package" value="2" /> 
										<label for="package"><b>批量上传</b></label>
									</span> 
									<span> 
										<input type="radio" name="uploadMode" id="excelImport" value="3" />
										<label for="excelImport"><b>EXCEL上传</b></label>
									</span>
								</div>
								<div class="uploadMode" id="singleMode">
									<form enctype="multipart/form-data" id="importFromLocal" method="post">
										<input type="hidden" name="profileId" value="" /> 
										<input type="hidden" name="channel" id="hidChannel" />
										<table class="upload">
											<tbody>
												<tr>
													<td width="80">
														<span class="red">&nbsp;</span> 
														<span>关联职位：</span> 
													</td>
													<td>
														<select id="selJob" name="jobId">
															<option value="">请选择职位</option>
															<c:forEach items="${positionlist}" var="position" varStatus="istatus" >
																<option value="${position.recruitPositionId}">${position.positionName}--${position.workPlace}(${position.positionCode})</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr>
													<td>
														<span class="red">*</span> 
														<span>招聘渠道：</span> 
													</td>
													<td>
														<select name='recruitChannel' id='recruitChannel'>
															<option value=""></option>
															<option value="7">官网</option>
															<option value="1100">&#12288;PC官网</option>
															<option value="1101">&#12288;移动官网</option>
															<option value="3">员工推荐</option>
															<option value="1">招聘网站</option>
															<option value="1002">&#12288;智联招聘</option>
															<option value="1003">&#12288;中华英才网</option>
															<option value="1018">&#12288;猎聘网</option>
															<option value="1001">&#12288;前程无忧</option>
															<option value="1004">&#12288;中国人才热线</option>
															<option value="2">猎头招聘</option>
															<option value="11310">&#12288;will</option>
															<option value="11312">&#12288;万宝瑞华</option>
															<option value="11313">&#12288;万宝盛华</option>
															<option value="11314">&#12288;达美</option>
															<option value="11315">&#12288;万玛</option>
															<option value="11316">&#12288;泰宇</option>
															<option value="11317">&#12288;精英源</option>
															<option value="11318">&#12288;天时利合</option>
															<option value="11319">&#12288;鸿儒猎头</option>
															<option value="11320">&#12288;人和猎头</option>
															<option value="11321">&#12288;科锐国际</option>
															<option value="11322">&#12288;任仕达</option>
															<option value="11323">&#12288;michaelpage</option>
															<option value="11324">&#12288;智联招聘-RPO</option>
															<option value="11325">&#12288;尚仕杰-RPO</option>
															<option value="11326">&#12288;大街-RPO</option>
															<option value="11327">&#12288;猎聘网-RPO</option>
															<option value="11328">&#12288;人才热线-RPO</option>
															<option value="6">媒体广告</option>
															<option value="4">现场招聘</option>
															<option value="5">校园招聘</option>
															<option value="8">企业人才库</option>
															<option value="9">其它</option>
															<option value="11170">&#12288;导入测试</option>
															<option value="11251">&#12288;通讯录CC</option>
															<option value="11252">&#12288;离职返聘</option>
															<option value="11253">&#12288;自荐</option>
															<option value="11254">&#12288;集团内调动</option>
															<option value="11255">&#12288;应聘申请表推荐</option>
														</select>
													</td>
												</tr>
												<tr>
													<td>
														<span class="red">&nbsp;</span> <span>简历来源：</span> 
													</td>
													<td>
														<input type="text" name="resumeSource" id="resumeSource" class="radius" />
													</td>
												</tr>
												<tr class="trInternalRecommend none">
													<td>
														<span class="red">*&nbsp;</span> <span>员工姓名：</span> 
													</td>
													<td>
														<input type="text" name="userName" class="radius" id="txtUserName"/>
													</td>
												</tr>
												<tr class="trInternalRecommend none">
													<td>
														<span class="red">*&nbsp;</span> <span>公司邮箱： </span> 
													</td>
													<td>
														<input type="text" name="email" class="radius" id="txtUserEmail"/>
													</td>
												</tr>
												<tr class="none">
													<td></td>
													<td><input type="hidden" name="importType" id="importLocal" value="1"></td>
												</tr>
												<tr>
													<td>
														<span class="red">&nbsp;</span> <span>选择简历： </span> 
													</td>
													<td>
														<input type="radio" name="resumeFormat" id="resumefile" value="1" checked /> 
														<label for="resumefile">上传</label>&nbsp;&nbsp;
														<input type="radio" name="resumeFormat" id="resumeCopyTxt" value="2" /> 
														<label for="resumeCopyTxt">粘贴</label>&nbsp;&nbsp;
													</td>
												</tr>
												<tr class="trResumefile">
													<td></td>
													<td>
														<span style="position: relative;">
															<input type="text" id="textFile" class="radius" /> 
															<input type="button" id="btnFile" class="cancel_btn_pop" onclick="$('#file').click();" value="浏览" /> 
															<input name="resumeFile1" id="file" type="file" class="none" onchange="setFileVal()" />
														</span>&nbsp;&nbsp; 
														<span class="red" id="errorFile"></span>
													</td>
												</tr>
												<tr class="trResumeCopyTxt none">
													<td></td>
													<td>
														<span> 
															<textarea name="resumetext" id="resumetext" style="width: 600px; height: 200px; overflow: auto;" class="c999" placeholder="简历以文本形式粘贴在这里，限20000字以内"></textarea>
														</span> 
														<span class="c999">已输入
															<span id="textCount" style="font-family: Constantia, Georgia; font-size: 18px;">0</span>&nbsp;字
														</span>
													</td>
												</tr>
												<tr>
													<td></td>
													<td>
														<span> 
														<c:if test="${not empty u_file_upload }">
															<input type="button" id="submitBtn" class="submit_btn" value="开始上传" onclick="upload('#importFromLocal')" />
														</c:if>
														</span> 
														<span id="message" class="red"></span>
													</td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
								<div class="uploadMode none" id="packageMode">
									<div>
       					    <input type="button" class="localUploadResume" value="添加简历"/>
       					    <input type="file" class="none" name="resumeFile1" id="resumeFile" onChange="getFileInfor()">
       					    <div class="r_prompt_c">
	               		  <p>请上传"txt"、"word"、"htm"、"pdf"、"zip"、"rar"、"mht"格式。<br/>单个文件大小不要超过4M。一次最多可以上传20个文件。</p>
                		</div>
       					  </div>
									<div id="tblList">
										<span class="tips">
											你已添加了<span id="addResumeTotal">0</span>个文件
											<span class="c999">（还可以添加<span id="surplus">20</span>个）</span>
										</span>
										<span id="spanButtonPlaceHolder2"></span>
										<table class="tGlobal" id="tblUploadList">
											<thead>
												<tr id="uploadTh">
													<th>&nbsp;文件</th>
													<th>大小</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<tr style="border-bottom: none;">
													<td style="border-bottom: none;"><span>共有<span id="fileCount">0</span>个文件</span> | <a
														id="btnClearUploadedResume"><span>清空列表</span></a>
													</td>
													<td style="border-bottom: none;">总计：<span id="fileSize">0</span><span>B</span></td>
													<td style="border-bottom: none;"></td>
												</tr>
											</tbody>
										</table>
									</div>
									<form enctype="multipart/form-data" id="importFromLocalMulti" method="post">
										<table class="tblQuery">
											<tbody>
												<tr>
													<td class="c999left">
														<span class="red">&nbsp;</span> <span>关联职位：</span>
													</td>
													<td>
														<select name="jobId" id="selJobIdMultiple">
															<option value="">请选择职位</option>
															<c:forEach items="${positionlist}" var="position" varStatus="istatus" >
																<option value="${position.recruitPositionId}">${position.positionName}--${position.workPlace}(${position.positionCode})</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr>
													<td width="80" class="c999left">
														<span class="red">*&nbsp;</span><span>招聘渠道：</span>
													</td>
													<td>
														<select name='recruitChannel' id='recruitChannelMultiple'>
															<option value=""></option>
															<option value="7">官网</option>
															<option value="1100">&#12288;PC官网</option>
															<option value="1101">&#12288;移动官网</option>
															<option value="3">员工推荐</option>
															<option value="1">招聘网站</option>
															<option value="1002">&#12288;智联招聘</option>
															<option value="1003">&#12288;中华英才网</option>
															<option value="1018">&#12288;猎聘网</option>
															<option value="1001">&#12288;前程无忧</option>
															<option value="1004">&#12288;中国人才热线</option>
															<option value="2">猎头招聘</option>
															<option value="11310">&#12288;will</option>
															<option value="11312">&#12288;万宝瑞华</option>
															<option value="11313">&#12288;万宝盛华</option>
															<option value="11314">&#12288;达美</option>
															<option value="11315">&#12288;万玛</option>
															<option value="11316">&#12288;泰宇</option>
															<option value="11317">&#12288;精英源</option>
															<option value="11318">&#12288;天时利合</option>
															<option value="11319">&#12288;鸿儒猎头</option>
															<option value="11320">&#12288;人和猎头</option>
															<option value="11321">&#12288;科锐国际</option>
															<option value="11322">&#12288;任仕达</option>
															<option value="11323">&#12288;michaelpage</option>
															<option value="11324">&#12288;智联招聘-RPO</option>
															<option value="11325">&#12288;尚仕杰-RPO</option>
															<option value="11326">&#12288;大街-RPO</option>
															<option value="11327">&#12288;猎聘网-RPO</option>
															<option value="11328">&#12288;人才热线-RPO</option>
															<option value="6">媒体广告</option>
															<option value="4">现场招聘</option>
															<option value="5">校园招聘</option>
															<option value="8">企业人才库</option>
															<option value="9">其它</option>
															<option value="11170">&#12288;导入测试</option>
															<option value="11251">&#12288;通讯录CC</option>
															<option value="11252">&#12288;离职返聘</option>
															<option value="11253">&#12288;自荐</option>
															<option value="11254">&#12288;集团内调动</option>
															<option value="11255">&#12288;应聘申请表推荐</option>
														</select>
													</td>
												</tr>
												<tr>
													<td class="c999left">
														<span class="red">&nbsp;</span> <span>简历来源：</span>
													</td>
													<td>
														<input type="text" name="resumeSource" id="txtResumeSourceMultiple" maxlength="50" class="radius"/>
													</td>
												</tr>
												<tr>
													<td class="c999left">
														<span>&nbsp;</span> <span>重复简历：</span>
													</td>
													<td>
														<span> 
															<input type="radio" value="1" name="forceReplace" id="autoCover" checked="checked" />
															<label for="autoCover">自动覆盖</label>&nbsp;&nbsp;
														</span> 
														<span> 
															<input type="radio" value="0" name="forceReplace" id="noImport" />
															<label for="noImport">不导入</label>&nbsp;&nbsp;
														</span>
													</td>
												</tr>
												<tr class="trInternalRecommendMultiple none">
													<td class="c999left">
														<span class="red">*&nbsp;</span><span>员工姓名：</span>
													</td>
													<td>
														<input type="hidden" name="importType" id="importMulti" value="2">
														<input type="text" name="userName" id="txtUserNameMultiple" maxlength="50" class="radius" />
													</td>
												</tr>
												<tr class="trInternalRecommendMultiple none">
													<td class="c999left">
														<span class="red">*&nbsp;</span><span>公司邮箱：</span>
													</td>
													<td>
														<input type="text" name="email" id="txtUserEmailMultiple" maxlength="50" class="radius" />
													</td>
												</tr>
												<tr>
													<td>
													</td>
													<td>
														<c:if test="${not empty u_file_upload }">
															<input type="button" id="btnConfirmImportResume" value="导入简历" onclick="upload('#importFromLocalMulti')"/>
														</c:if> 
														<input type="hidden" value="文件大小不能超过4M" id="hidOverFileSizeMsg" />
														<c:if test="${not empty u_resume_importMultipleResumeRecord }">
															<a href="../resume/importMultipleResumeRecord" id="viewUploadHistory">查看批量上传记录</a>
														</c:if>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="resumeOperate">
										</div>
									</form>
								</div>
								<div class="uploadMode none" id="excelMode">
									<div>
										<form enctype="multipart/form-data" id="importFromLocalExcel" method="post">
											<input type="hidden" name="profileId" value=""/> 
											<input type="hidden" name="channel" id="hidChannel"/>
											<table class="upload">
												<tbody>
													<tr>
														<td>
															<span class="red">*&nbsp;</span> <span>选择EXCEL文件：</span>
														</td>
														<td>
															<span style="position: relative;"> 
																<input id="uploadfile" name="resumeFile" type="file" value="浏览" size="220" width="200" style="width: 200px;"/>
															</span>
														</td>
													</tr>
													<tr>
														<td>
															<span class="red">&nbsp;&nbsp;</span> <span>关联职位：</span>
														</td>
														<td>
															<select id="selJob2" name="jobId">
																<option value="">请选择职位</option>
																<c:forEach items="${positionlist}" var="position" varStatus="istatus" >
																	<option value="${position.recruitPositionId}">${position.positionName}--${position.workPlace}(${position.positionCode})</option>
																</c:forEach>
															</select>
														</td>
													</tr>
													<tr>
														<td>
															<span class="red">&nbsp;&nbsp;</span> <span>简历来源：</span>
														</td>
														<td>
															<input type="hidden" name="importType" id="importExcel" value="3"/> 
															<input type="text" name="resumeSource" id="txtResumeSource" maxlength="50" />
														</td>
													</tr>
													<tr>
														<td>
															<span class="red">&nbsp;&nbsp;</span> <span>重复简历：</span>
														</td>
														<td>
															<span> 
																<input type="radio" value="1" name="forceReplace" id="autoCover" checked="checked" />
																<label for="autoCover">自动覆盖</label>&nbsp;&nbsp;
															</span> 
															<span> 
																<input type="radio" value="0" name="forceReplace" id="noImport" />
																<label for="noImport">不导入</label>&nbsp;&nbsp;
															</span>
														</td>
													</tr>
													<tr>
														<td></td>
														<td>
															<c:if test="${not empty u_file_upload }">
																<span> 
																	<input type="button" id="submitBtn" class="btn7" value="导入&下一步" onclick="upload('#importFromLocalExcel')" />
																</span>
															</c:if> 
															<span id="message" class="red"></span>
														</td>
													</tr>
												</tbody>
											</table>
										</form>
										<div class="phone_no none" id="validateFormat">
											<div class="phone-info_tanchu">
												<div class="tanchujiantou"></div>
												<div class="tanchu_nr tanchu_nr">请上传xls或者xlsx格式的excel文件!</div>
											</div>
										</div>
									</div>
									<p>导入帮助：</p>
									<p>1.导入文件格式要求：xls格式文件，请使用Excel等软件创建，格式按以下模板。</p>
									<p>
									  <c:if test="${not empty u_resume_exportResumeTemplate }">
										<a href="/recruit/resume/exportResumeTemplate">候选人模版.xls</a>
										</c:if>
									</p>
									<p>2.各类内容及格式要求：</p>
									<p>（1）姓名不能为空,长度不能超过50;</p>
									<p>（2）必须填写正确的所在省/市，否则为空;如果所在城市不为空，则所在省也必须填写;</p>
									<p>（3）联系电话和手机必须填写一个;</p>
									<p>（4）邮箱不能为空,且必须为正确的邮箱格式;</p>
									<p>（5）工作经验、期望薪资、当前月薪，如果填写必须为整数,其中期望薪资可填写“面议”;</p>
									<p>（6）教育经历：最高学历、毕业学校、专业，三者同时填写或者同时为空;</p>
									<p>（7）最高学历可选择：高中及以下、大专、本科、硕士、MBA、博士;</p>
									<p>（8）简历语言不能为空；且只能输入“中文”或“英文”</p>
									<p>（9）如果简历语言为英文，则性别、所在省份、所在城市、民族、期望薪资、最高学历只需按格式填写中文即可，系统会根据你所选择的简历语言去翻译</p>
									<p>（10）所有候选人必须填写招聘渠道才能导入成功。如果招聘渠道为员工推荐的，还必须填写推荐人姓名，推荐人邮箱。</p>
								</div>
								<div class="phone_no none" id="validateLocal">
									<div class="phone-info_tanchu tanchu_1">
										<div class="tanchujiantou"></div>
										<div class="tanchu_nr tanchu_nr_long"></div>
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
<script type="text/javascript" src="${webRoot}/resources/js/importResumeLocal.js"></script>

</html>