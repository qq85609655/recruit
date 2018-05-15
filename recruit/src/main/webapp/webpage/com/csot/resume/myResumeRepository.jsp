<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<html>
  <head>
	  <title>简历库</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/resume/resumeRepository.css"/>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.css"/>
  </head>
  <body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-left">
        <jsp:include page="/webpage/left-bar.jsp"></jsp:include>
      </div>
      <div class="co-right">
        <div class="position-path co-right-center">
    	  	<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易播职</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">企业人才库</span>
    		</div>
    		<div class="co-right-main co-right-center">
	      	<div class="con-title">我的简历库</div>
	      	<input type = "hidden" name="resumeEditorPermission" id = "resumeEditorPermission" value="${u_resume_editResume }">
	      	<div class="main">
	        	<form id="resume-searchPositionManage">
			  			<div class="resume-search-box blue radius">
			    			<table class="resume-table">
				  				<tbody>
				    				<tr>
					  					<td width="80"><span class="search-item">关键词：</span></td>
					  					<td width="300"><input type="text" name="keyWord" id="keyword" class="jobKey input-l radius1" >&nbsp;<input type="checkbox" checked="checked" id="keyWordsSign"><span class="search-item">包含全部</span></td>
					  					<td width="80"><span class="search-item"style="width: 85px;">姓名：</span></td>
					  					<td><input type="text" name="name" id="name" class="jobKey input-l radius1"></td>
										</tr>
										<tr>
					 			 			<td><span class="search-item">当前职位：</span></td>
					  					<td><input type="text" id="currentPosition" class="jobKey input-l radius1" ></td>
					  					<td><span class="search-item"style="width: 85px;">公司名称：</span></td>
					  					<td><input type="text" id="companyName" name="companyName" class="jobKey input-l radius1"></td>
										</tr>
										<tr>
					  					<td><span class="search-item">学历：</span></td>
					  					<td><select class="resume-education" id="highestEducation" name="highestEducation"><option selected="selected" value="">不限</option><option value="014-001">高中及以下</option><option value="014-002">大专</option><option value="014-003">本科</option><option value="014-004">硕士</option><option value="014-005">MBA</option><option value="014-006">博士</option></select>&nbsp;<input type="checkbox"  id="educationSign"><span class="search-item">及以上</span></td>
					  					<td><span class="search-item resume-label"style="width: 85px;" >简历标签：</span></td>
					  					<td>
					    					<span id="resumeTagsSpan">
                        	<span class="baza-resumeTag-iconBox">
                          	<input type="text" value="" id="resumeTag" name="resumeTag"  class="jobKey input-l radius1 ">
                          	<span title="简历标签" class="baza-resumeTag-icon">&nbsp;</span>
                        	</span>
                      	</span>
					    					<input type="checkbox" id="labelSign">
					    					<span class="search-item">包含全部</span>
					  					</td>
										</tr>
				  				</tbody>
								</table>
								<table class="more-search">
				  				<tbody>
				   	 				<tr>
					  					<td width="80"><span class="search-item">专业：</span></td>
					  					<td width="300">
					    					<input type="button" class="choose_btn radius1 input-l resume-professional" onclick="openThisWin('professional','professional-category-win')" id="professional" name="professional" value="选择/修改"><span class="remove" >清除</span>
					    					<input type="hidden" id="professional1" ></td>
					  					<td width="80"><span class="search-item">工作年限：</span></td>
					  					<td><input type="text" class="resume-workYear" id="lowerWorkYear" name="lowerWorkYear">-<input type="text" class="resume-workYear" id="upperWorkYear" name="upperWorkYear"></td>
										</tr>
										<tr>
					  					<td><span class="search-item">招聘渠道：</span></td>
					  					<td>
					    					<select class="resume-select" id="channel" name="channel">
                        	<option value="" selected>请选择</option>
                       	  <option value="7">官网</option>
		                    	<option value="1100">　PC官网</option>
		                    	<option value="1101">　移动官网</option>
                        	<option value="3">员工推荐</option>
                        	<option value="1">招聘网站</option>
		                    	<option value="1002">　智联招聘</option>
		                    	<option value="1003">　中华英才网</option>
		                    	<option value="1018">　猎聘网</option>
		                    	<option value="1001">　前程无忧</option>
		                    	<option value="1004">　中国人才热线</option>
                        	<option value="2">猎头招聘</option>
		                    	<option value="11310">　will</option>
		                    	<option value="11312">　万宝瑞华</option>
		                    	<option value="11313">　万宝盛华</option>
		                    	<option value="11314">　达美</option>
		                    	<option value="11315">　万玛</option>
		                    	<option value="11316">　泰宇</option>
		                    	<option value="11317">　精英源</option>
		                    	<option value="11318">　天时利合</option>
		                    	<option value="11319">　鸿儒猎头</option>
		                    	<option value="11320">　人和猎头</option>
		                    	<option value="11321">　科锐国际</option>
		                    	<option value="11322">　任仕达</option>
		                    	<option value="11323">　michaelpage</option>
		                    	<option value="11324">　智联招聘-RPO</option>
		                    	<option value="11325">　尚仕杰-RPO</option>
		                    	<option value="11326">　大街-RPO</option>
		                    	<option value="11327">　猎聘网-RPO</option>
		                   	 	<option value="11328">　人才热线-RPO</option>
                        	<option value="6">媒体广告</option>
				                	<option value="4">现场招聘</option>
				                	<option value="5">校园招聘</option>
				                	<option value="8">企业人才库</option>
				                	<option value="9">其它</option>
	                     	  <option value="11170">　导入测试</option>
	                      	<option value="11251">　通讯录CC</option>
	                      	<option value="11252">　离职返聘</option>
	                      	<option value="11253">　自荐</option>
	                      	<option value="11254">　集团内调动</option>
	                      	<option value="11255">　应聘申请表推荐</option>
					    					</select>
					  					</td>
					  					<td><span class="search-item">邮箱：</span></td>
					  					<td><input type="text" class="jobKey input-l radius1" id="email" name="email"></td>
										</tr>
										<tr>
					  					<td><span class="search-item">当前行业：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l currently-industry"  id="currentlyIndustry" name="currentlyIndustry" value="选择/修改">&nbsp;<span class="remove" >清除</span>
					    					<input type="hidden" id="currentlyIndustry1" />
					  					</td>
					  					<td><span class="search-item">当前所在地：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l" value="选择/修改" id="currentryWorkplace" name="currentryWorkplace">&nbsp;<span class="remove" >清除</span>
					    					<input type="hidden" id="currentryWorkplace1" />
					  					</td>
										</tr>
										<tr>
					  					<td><span class="search-item">毕业学校：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l graduation-school" onclick="openThisWin('school','school-category-win')" id="school" name="school" value="选择/修改" >&nbsp;<span class="remove" >清除</span>
					     					<input type="hidden" id="school1" />
					    				</td>
					  					<td><span class="search-item">年龄：</span></td>
					  					<td><input type="text" class="resume-workYear" id="lowerAge" name="lowerAge">-<input type="text" class="resume-workYear" id="upperAge" name="upperAge"></td>
										</tr>
										<tr>
					  					<td><span class="search-item">意向岗位：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l intention-post" onclick="openThisWin('post','post-category-win')" id="post" name="postExpect" value="选择/修改" >&nbsp;<span class="remove" >清除</span>
					    					<input type="hidden" id="post1" />
					  					</td>
					  					<td><span class="search-item">性别：</span></td>
					  					<td>
					    					<select class="resume-select" id="sex" name="sex">
					      					<option selected="selected" value="" >--请选择--</option>
					      					<option value="001-000">男</option>
					      					<option value="001-001">女</option>
					    					</select>
					  					</td>
										</tr>
										<tr>
					  					<td><span class="search-item" >意向行业：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l" id="intentionIndustry" name="intentionIndustry" value="选择/修改">&nbsp;<span class="remove" >清除</span>
					    					<input type="hidden" id="intentionIndustry1" />
					  					</td>
					  					<td><span class="search-item">更新日期：</span></td>
					  					<td><input type="text" class="resume-updateDate radius1 mini-datepicker" style="width: 110px" id="lowerUpdateDate" name="lowerUpdateDate"><span>至</span><input  type="text" class="resume-updateDate radius1 mini-datepicker" style="width: 110px" id="upperUpdateDate" name="upperUpdateDate"></td>
										</tr>
										<tr>
					  					<td><span class="search-item">意向工作地：</span></td>
					  					<td>
					    					<input type="button" class="choose_btn radius1 input-l" value="选择城市" id="intentionWorkplace" name="intentionWorkplace">&nbsp;<span class="remove" >清除</span>
					    					<input type="hidden" id="intentionWorkplace1" />
					  					</td>
					  					<td><span class="search-item">期望薪资：</span></td>
					  					<td>
					    					<select class="resume-select" id="expectedSalary" name="expectedSalary">
                        	<option value="" selected="selected">-请选择-</option>
                       	 	<option value="007-000">面议</option>
                        	<option value="007-001">1500以下</option>
                        	<option value="007-002">1500-2499</option>
                        	<option value="007-003">2500-3999</option>
                        	<option value="007-004">4000-5999</option>
                        	<option value="007-005">6000-7999</option>
                        	<option value="007-006">8000-9999</option>
                        	<option value="007-007">10000-14999</option>
                        	<option value="007-008">15000-19999</option>
                        	<option value="007-009">20000-29999</option>
                        	<option value="007-010">30000-50000</option>
                        	<option value="007-011">50000以上</option>
					    					</select>
					  					</td>
										</tr>
			      			</tbody>
								</table>
								<div class="search-box-last">
									<input id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11" value="搜索" name="btnSearchOK" onclick="searchResume()"/> 
									<input class="search_btn radius1 btn" type="button" tabindex="12" value="重置" onclick="resetResume()"/> 
			    				<span class="more-expand"><span class="font-icon more-expand-icon icon-angle-double-down"></span></span>
			  				</div>
			  			</div>
						</form>  
			
						<div class="resume-total"><span>共有</span><span id="totalCount"></span><span>简历</span></div>
			
						<!--简历的datagrid  -->
						<div class="position-table blue radius">
			  			<div class="table-operate">
			    			<div class="input-output">
			    			<c:if test="${not empty u_resume_addResume }">
			      			<a href="/recruit/resume/addResume" target="addResume-window" id="addResumeTitle"  class="button radius btn" style="padding-top: 2px;padding-bottom:2px;">录入</a>
			      	  </c:if>
			      	  <c:if test="${not empty u_file_uploadMail}">
			      	    <a href="/recruit/resume/importResumeLocal" target="export-window" id="export"  class="button radius btn" style="padding-top: 2px;padding-bottom:2px;">导入</a>
			      	  </c:if>
			      			<!-- <input type="button" class="button radius btn" value="导入" id="export"></input> --> 
			    			</div>
			    			<span>|</span>
			    			<div class="otherOperate">
			    			  <c:if test="${not empty u_resume_personalResume }">
			      			  <input type="button" class="button radius btn" id="setSecurity" value="查看" id="editor"></input> 
			      			</c:if>
			      			<c:if test="${not empty u_resume_transmitResume }">
			      			  <input type="button" class="button radius btn" value="发送" id="transmitResume" onclick="validateCheck('#validateChecked','resume-transmit-win','#transmitResume')"></input> 
			      			</c:if>
			      			<c:if test="${not empty u_position_addLabels }">
			      			  <input type="button" class="button radius btn" value="标签" id="label"></input>
			      			</c:if> 
			      			<c:if test="${not empty u_resume_addToCandidate }">
			      			  <input type="button" class="button radius btn" value="加入候选人" id="addToCandidate"></input> 
			     				</c:if>
			     				<a id="sltMoreOperate">更多<b class="more_down">&nbsp;&nbsp;&nbsp;&nbsp;</b></a>
			     				<div class="moreOperate">
			       				<ul>
			       				  <c:if test="${not empty u_resume_sendMessage }">
			         				  <li id="sendMessage" onclick="validateCheck('#validateChecked','resume-send-message-win','#sendMessage')"><a>发送短信</a></li>
			         				</c:if>
			         				<c:if test="${not empty u_send_email }">
			         			  	<li id="sendMail" onclick="validateCheck('#validateChecked','resume-send-mail-win','#sendMail')"><a>发送邮件</a></li>
			         				</c:if>
			         				<c:if test="${not empty u_resume_repositoryExport }">
			         				  <li><a onclick="repositoryExport()">导出</a></li>
			         				</c:if>
			         				<c:if test="${not empty u_resume_deleteResumeById }">
			         				  <li><a id="deleteResume" onclick="validateCheck('#validateChecked','resume-del-win','#deleteResume')">删除</a></li>
			       				  </c:if>
			       				</ul>
			     				</div>
			    			</div>
			    			<span>|</span>
			    			<div class="orderAndShow">
                	<input type="button" id="showSetLabel" value="显示设置" class="button radius btn">
                	<!-- 显示设置的jsp页面 -->
			      			<div class="showPosition-choose">
										<table class="showPosition-choose-tab">
					  					<tr>
					    					<td width="30px"><input type="checkbox" value="" checked="checked" disabled="disabled"></td>
					    					<td width="120px"><span>姓名</span></td>
					    					<td width="30px"><input type="checkbox" class="resume-check" id="selectionStatusSet" value="selectionStatusColumn" ></td>
					    					<td width="190px"><span>甄选状态</span></td>
					  					</tr>
					  					<tr>
					    					<td><input type="checkbox" class="resume-check" id="positionSet" value="positionColumn"></td>
					    					<td><span>关联职位</span></td>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="ageSet" value="ageColumn"></td>
					    					<td><span>年龄</span></td>
					  					</tr>
					  					<tr>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="currentPositionSet" value="currentPositionColumn"></td>
					    					<td><span>职位或岗位</span></td>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="labelSet" value="labelColumn"></td>
					    					<td><span>标签</span></td>
					  					</tr>
					  					<tr>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="companySet" value="companyColumn"></td>
					    					<td><span>就职公司</span></td>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="residenceSet" value="residenceColumn"></td>
					    					<td><span>当前所在</span></td>
					  					</tr>
					  					<tr>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="educationSet" value="educationColumn"></td>
					    					<td><span>学历</span></td>
					    					<td><input type="checkbox" class="resume-check" id="graduationSchoolSet" value="graduationSchoolColumn"></td>
					    					<td><span>毕业学校</span></td>
					  					</tr>
					  					<tr>
					  						<td><input type="checkbox" checked="checked" class="resume-check" id="experienceSet" value="experienceColumn"></td>
					    					<td><span>工作经验</span></td>
					    					<td><input type="checkbox" class="resume-check" id="resumeOriginSet" value="resumeOriginColumn"></td>
					    					<td><span>简历来源</span></td>
					  					</tr>
					  					<tr>
					     					<td><input type="checkbox"  class="resume-check" id="salaryExpectSet" value="salaryExpectColumn"></td>
					    					<td><span>期望薪资</span></td>
					    					<td><input type="checkbox" checked="checked" class="resume-check" id="channelSet" value="channelColumn"></td>
					    					<td><span>招聘渠道</span></td>
					  					</tr>
					  					<tr>
					    					<td><input type="checkbox" class="resume-check" id="updateDateSet" value="updateDateColumn"></td>
					    					<td><span>更新日期</span></td>
					    					<td><input type="checkbox" class="resume-check" id="operateSet" checked="checked" value="operateColumn"></td>
					    					<td><span>操作</span></td>
					  					</tr> 
										</table>
			      			</div>
			    			</div>
			  			</div>
			  			<div class="phone_no" id="validateChecked" style="display:none;">
               	<div id="phone-info_tanchu" class="phone-info_tanchu">
                 	<div class="tanchujiantou"></div>
                	<div class="tanchu_nr">请选择简历</div>                        
               	</div>
            	</div>
			  			<div id="datagrid2" class="mini-datagrid" url="/recruit/resume/queryResumeDataList" 
				 				idField="id" sizeList="[1,5,10,50,100]"  allowResize="false" ondrawcell="ondrawcell" onload="successLoad"
				  			onbeforeload="loadShowSetData" multiSelect="true" style="height:350px;">
		        		<div property="columns">
				  				<div type="indexcolumn"></div>
		          		<div type="checkcolumn"></div>
		          		<div field="id" name="id" width="0" hideable="false">Id</div>
			      			<div name="nameColumn" field="name" width="70" showColumnsMenu="true">姓名</div>    
				  				<div name="selectionStatusColumn" field="selectionStatus" width="60" >甄选状态</div>  
				  				<div field="positionId" name="positionId" width="0"  hideable="false">positionId</div>                          
				  				<div name="positionColumn" field="position" width="100" >应聘职位</div>
				  				<div name="ageColumn" field="age" width="32" allowSort="true" align="center">年龄</div>  
				  				<div name="currentPositionColumn" field="currentPosition" width="100" ><div id="headerPositionName"  class="header">职位或岗位<div class="imageStyle"></div></div></div>                              
				  				<div name="labelIdColumn" field="labelId" width="0" allowSort="true">标签Id</div>  
				  				<div name="labelColumn" field="label" width="70" ><div id="headerLabel" class="header">标签<div class="imageStyle"></div></div></div>
				  				<div name="companyColumn" field="company" width="200" >就职公司</div>      
				  				<div name="residenceColumn" field="residence" width="100" ><div id="headerResidence" class="header">当前所在地<div class="imageStyle"></div></div></div>
				  				<div name="educationColumn" field="highestEducation" width="50"><div id="headerHighestEducation" class="header">学历<div class="imageStyle"></div></div></div> 
				  				<div name="graduationSchoolColumn" field="graduationSchool" width="120" ><div id="headerGraduationSchool"  class="header">毕业学校<div class="imageStyle"></div></div></div> 
				  				<div name="experienceColumn" field="experience" width="60" allowSort="true" align="center">工作经验</div>  
				  				<div name="resumeOriginColumn" field="resumeOrigin" width="70" >简历来源</div>
				  				<div name="salaryExpectColumn" field="salaryExpect" width="70" >期望薪资</div>
									<!-- <div field="positionDescription" width="100" allowSort="true">匹配设置</div> -->  
				  				<div name="channelColumn" field="channel" width="100" ><div id="headerChannel" class="header"> 招聘渠道<div class="imageStyle"></div></div></div>  
				  				<div name="updateDateColumn" field="updateDate" width="100" allowSort="true"  dateFormat="yyyy-MM-dd" >更新日期</div>
				  				<div name="operateColumn" field="operate"  width="50" >操作</div>
								</div>
		      		</div> 
		    		</div> 
   				
		    		<!--职位或岗位下拉列表框  -->
		    		<div id="selectDrop" style="display:none;">
		      		<ul></ul>
		    		</div>

	      	</div>
	    	</div>
      </div>
    </div>

    <!-- 选择专业类别 -->
	  <div id="professional-category-win" class="mini-window" style="width: 608px; display: none;" title="选择专业类别" showFooter="true">
		  <div class="professional-category-middle category-middle">
			  <div class="professional-category-middle-inner middle-inner">
			    <span><b>&nbsp;&nbsp;已选择专业</b>&nbsp;&nbsp;
			    <span class="professional-gray gray">最多选5个</span>&nbsp;&nbsp;
			    <span class="professional-category-prompt category-prompt"></span>
			  </div>
			  <div class="choose-professional-data category-data"></div>
			</div>
			<div class="choose-professional-category choose-category">
			  <div class="choose-professional-tip choose-tip"><span  onclick="openData('professional')" style="color:blue">请选择专业</span></div>
			  <!-- <div class="choose-professional-text"><input type="text" class="choose-professional-input"><input type="button" class="choose-professional-button" value="录入"></div> -->
			  <div class="choose-professional-panel choose-panel"><span><b>&nbsp;&nbsp;请选择专业</b></span></div>
			</div>
			<div class="professional-category"><span style="font-size: 12px;color:red; "></span></div>
			<div >
			  <div class="professional-category-data category-data"></div>
			</div>
			<div property="footer" class="win-footer">
			  <input type="button" class="win-footer-btn" value="确定" onclick="submitCategoryData('professional')"></input>
			  <input type="button" class="win-footer-btn" value="取消" onclick="hideCaegoryWindow('professional','professional-category-win')"></input>
			</div>
		</div>
		<!-- 主要专业的类别 -->
		<div class="professional-category-pdata category-data" onmouseover="cancelEvent();" onmouseout="closeDataPanel('professional');" style="display: none;">
		  <ul>
		    <li><a datavalue="1"> 管理科学与工程类</a></li>
		    <li><a datavalue="2"> 工商管理类</a></li>
		    <li><a datavalue="3"> 公共管理类</a></li>
		    <li><a datavalue="4"> 图书档案学类</a></li>
		    <li><a datavalue="5"> 电子信息类</a></li>
		    <li><a datavalue="6"> 机械类</a></li>
		    <li><a datavalue="7"> 仪器仪表类</a></li>
		    <li><a datavalue="8"> 能源动力类</a></li>
		    <li><a datavalue="9"> 材料类</a></li>
		    <li><a datavalue="10"> 轻工纺织食品类</a></li>
		    <li><a datavalue="11"> 土建类</a></li>
		    <li><a datavalue="12"> 力学类</a></li>
		    <li><a datavalue="13"> 环境科学与安全类</a></li>
		    <li><a datavalue="14"> 制药工程类</a></li>
		    <li><a datavalue="15"> 交通运输类</a></li>
		    <li><a datavalue="16"> 航空航天类</a></li>
		    <li><a datavalue="17"> 船舶与海洋工程类</a></li>
		    <li><a datavalue="18"> 水利类</a></li>
		    <li><a datavalue="19"> 测绘类</a></li>
		    <li><a datavalue="20"> 公安技术类</a></li>
		    <li><a datavalue="21"> 武器类</a></li>
		    <li><a datavalue="22"> 数学类</a></li>
		    <li><a datavalue="23"> 物理学类</a></li>
		    <li><a datavalue="24"> 化学类</a></li>
		    <li><a datavalue="25"> 生物类</a></li>
		    <li><a datavalue="26"> 天文地质地理类</a></li>
		    <li><a datavalue="27"> 经济学类</a></li>
		    <li><a datavalue="28"> 语言文学类</a></li>
		    <li><a datavalue="29"> 艺术类</a></li>
		    <li><a datavalue="30"> 法学类</a></li>
		    <li><a datavalue="31"> 哲学类</a></li>
		    <li><a datavalue="32"> 教育学类</a></li>
		    <li><a datavalue="33"> 医学类</a></li>
		    <li><a datavalue="34"> 农业类</a></li>
		    <li><a datavalue="35"> 历史学类</a></li>
		    <li><a datavalue="36"> 军事类</a></li>
		  </ul>
		  <div class="choose-professional-panel2 choose-panel2"></div>
		</div> 
    
    <!-- 选择学校 -->
	  <div id="school-category-win" class="mini-window" style="width: 608px; display: none;" title="选择专业类别" showFooter="true">
		  <div class="school-category-middle category-middle">
			  <div class="school-category-middle-inner middle-inner">
			    <span><b>&nbsp;&nbsp;已选择专业</b></span>&nbsp;&nbsp;
			    <span class="school-gray gray">最多选5个</span>&nbsp;&nbsp;
			    <span class="school-category-prompt category-prompt"></span>
			  </div>
			  <div class="choose-school-data category-data"></div>
			</div>
			<div class="choose-school-category choose-category">
			  <div class="choose-school-tip choose-tip"><span onclick="openData('school')" style="color:blue">请选择学校</span></div>
			  <!-- <div class="choose-professional-text"><input type="text" class="choose-professional-input"><input type="button" class="choose-professional-button" value="录入"></div> -->
			  <div class="choose-school-panel choose-panel" ><span><b>&nbsp;&nbsp;请选择学校</b></span></div>
			</div>
			<div class="school-category"><span style="font-size: 12px;color:red; "></span></div>
			<div >
			  <div class="school-category-data category-data"></div>
			</div>
			<div property="footer" class="win-footer">
			  <input type="button" class="win-footer-btn" value="确定" onclick="submitCategoryData('school')"></input>
			  <input type="button" class="win-footer-btn" value="取消" onclick="hideCaegoryWindow('school','school-category-win')"></input>
			</div>
		</div>
    <div class="school-category-pdata category-data"  onmouseover="cancelEvent();" onmouseout="closeDataPanel('school');">
			<div style="border-bottom: 1px dashed #DDDDDD;height: 30px;" >
			  <span>按分组：</span>
			</div>
			<div>
			  <ul>
			    <li><a class="byGroup" datavalue="1">211工程大学</a></li>
			    <li><a class="byGroup" datavalue="2">985工程大学</a></li>
			  </ul>
			</div>
			<div style="border-bottom: 1px dashed #DDDDDD;height: 30px;">按省份：</div>
			<div>
			  <ul>
		      <li><a datavalue="3">湖南</a></li>
		      <li><a datavalue="4">湖北</a></li>
		      <li><a datavalue="5">安徽</a></li>
		      <li><a datavalue="6">北京</a></li>
		      <li><a datavalue="7">重庆</a></li>
		      <li><a datavalue="8">福建</a></li>
		      <li><a datavalue="9">甘肃</a></li>
		      <li><a datavalue="10">广东</a></li>
		      <li><a datavalue="11">广西</a></li>
		      <li><a datavalue="12">贵州</a></li>
		      <li><a datavalue="13">海南</a></li>
		      <li><a datavalue="14">河北</a></li>
		      <li><a datavalue="15">黑龙江</a></li>
		      <li><a datavalue="16">河南</a></li>
		      <li><a datavalue="17">内蒙古</a></li>
		      <li><a datavalue="18">江苏</a></li>
		      <li><a datavalue="19">江西</a></li>
		      <li><a datavalue="20">吉林</a></li>
		      <li><a datavalue="21">辽宁</a></li>
		      <li><a datavalue="22">宁夏</a></li>
		      <li><a datavalue="23">青海</a></li>
		      <li><a datavalue="24">陕西</a></li>
		      <li><a datavalue="25">山东</a></li>
		      <li><a datavalue="26">上海</a></li>
		      <li><a datavalue="27">山西</a></li>
		      <li><a datavalue="28">四川</a></li>
		      <li><a datavalue="29">天津</a></li>
		      <li><a datavalue="30">西藏</a></li>
		      <li><a datavalue="31">新疆</a></li>
		      <li><a datavalue="32">云南</a></li>
		      <li><a datavalue="33">浙江</a></li>
		      <li><a datavalue="34">香港</a></li>
		      <li><a datavalue="35">澳门</a></li>
		      <li><a datavalue="36">台湾</a></li>
		    </ul>
			</div>
		  <div class="choose-school-panel2 choose-panel2"></div>
		</div> 
		    
    <!-- 选择当前行业和意向行业-->
		<div id="industry-category-win" class="mini-window" style="width: 480px; display:none;" title="选择职位类别" showFooter="true">
		  <div class="industry-middle">
			  <div class="industry-middle-inner">
			    <span><b>&nbsp;&nbsp;已选择行业</b>&nbsp;&nbsp;</span><span class="gray">最多选5个</span>&nbsp;&nbsp;<span class="industry-prompt"></span>
			  </div>
			  <div class="industry-data"></div>
			</div>
			<div class="industry-category">
			  <input type="text" class="input-in" id="searchIndustry" value="快速查找行业"  autocomplete="off">
			</div>
			<div>
			 	<div class="industry-category-data"><ul></ul></div>
			</div>
			<div property="footer" class="win-footer">
			  <input type="button" class="win-footer-btn submitIndustryData" value="确定" ></input>
			  <input type="button" class="win-footer-btn cancelIndustryData" value="取消" ></input>
			</div>
		</div>
		
		<!-- 行业的子页面弹框 -->
		<div class="industry-child-data">
			<div class="child-title"></div>
			<div class="child-content"></div>
		</div>
    
    <!-- 选择职位类别 -->
		<div id="post-category-win" class="mini-window" style="width: 608px; display: none; " title="意向岗位" showFooter="true">
		  <div class="post-category-middle category-middle">
			  <div class="post-category-middle-inner middle-inner">
			    <b>&nbsp;&nbsp;已选择意向岗位</b>&nbsp;&nbsp;
			    <span class="post-gray gray">最多选五个意向岗位</span>&nbsp;&nbsp;
			    <span class="post-category-prompt category-prompt"></span>
			  </div>
			  <div class="choose-post-data category-data"></div>
			</div>
			<div class="choose-post-category choose-category">
			  <div class="choose-post-tip choose-tip"><span onclick="openData('post')" style="color:blue">请选择意向岗位</span></div>
			  <!-- <div class="choose-professional-text"><input type="text" class="choose-professional-input"><input type="button" class="choose-professional-button" value="录入"></div> -->
			  <div class="choose-post-panel choose-panel"><span><b>&nbsp;&nbsp;请选择意向岗位</b></span></div>
			</div>
			<div class="post-category"><span style="font-size: 12px;color:red; "></span></div>
			<div >
			  <div class="post-category-data category-data"></div>
			</div>
			<div property="footer" class="win-footer">
			  <input type="button" class="win-footer-btn" value="确定" onclick="submitCategoryData('post')"></input>
			  <input type="button" class="win-footer-btn" value="取消" onclick="hideCaegoryWindow('post','post-category-win')"></input>
			</div>
		</div>
    <div class="post-category-pdata category-data"  onmouseover="cancelEvent()"  onmouseout="closeDataPanel('post')" >
		  <ul>
		    <li><a datavalue="1"> 计算机硬件</a></li>
		    <li><a datavalue="2"> 计算机软件</a></li>
		    <li><a datavalue="3"> 互联网/电子商务/网游</a></li>
		    <li><a datavalue="4"> IT-管理</a></li>
		    <li><a datavalue="5"> IT-品管、技术支持及其它</a></li>
		    <li><a datavalue="6"> 电信/手机/通信技术开发及应用</a></li>
		    <li><a datavalue="7"> 电子/电器/半导体/仪器仪表</a></li>
		    <li><a datavalue="8"> 销售管理</a></li>
		    <li><a datavalue="9"> 销售业务/销售人员</a></li>
		    <li><a datavalue="10"> 商务销售/销售行政/商务</a></li>
		    <li><a datavalue="11"> 客服及技术支持</a></li>
		    <li><a datavalue="12"> 财务/审计/税务</a></li>
		    <li><a datavalue="13"> 证券/金融/投资</a></li>
		    <li><a datavalue="14"> 银行</a></li>
		    <li><a datavalue="15"> 保险</a></li>
		    <li><a datavalue="16"> 生产/制造/营运</a></li>
		    <li><a datavalue="17"> 质量/品质/安全管理</a></li>
		    <li><a datavalue="18"> 工程/机械/能源/矿产/地质勘查</a></li>
		    <li><a datavalue="19"> 汽车/摩托车制造</a></li>
		    <li><a datavalue="20"> 技工</a></li>
		    <li><a datavalue="21"> 服装/纺织/皮革/食品饮料</a></li>
		    <li><a datavalue="22"> 采购</a></li>
		    <li><a datavalue="23"> 贸易/进出口</a></li>
		    <li><a datavalue="24"> 物流/仓储</a></li>
		    <li><a datavalue="25"> 生物/制药/医疗器械</a></li>
		    <li><a datavalue="26"> 化工</a></li>
		    <li><a datavalue="27"> 医院/医疗/护理</a></li>
		    <li><a datavalue="28"> 广告/市场/媒体/艺术</a></li>
		    <li><a datavalue="29"> 公关/媒介/会展</a></li>
		    <li><a datavalue="30"> 市场/营销</a></li>
		    <li><a datavalue="31"> 影视/媒体</a></li>
		    <li><a datavalue="32"> 写作/出版/传媒/报刊</a></li>
		    <li><a datavalue="33"> 建筑</a></li>
		    <li><a datavalue="34"> 房地产/房地产开发/中介</a></li>
		    <li><a datavalue="35"> 物业管理</a></li>
		    <li><a datavalue="36"> 人力资源</a></li>
		    <li><a datavalue="37"> 人事行政/经营管理/高级管理</a></li>
		    <li><a datavalue="38"> 行政/后勤/文秘</a></li>
		    <li><a datavalue="39"> 咨询/顾问</a></li>
		    <li><a datavalue="40"> 律师/法务/合规</a></li>
		    <li><a datavalue="41"> 教师/培训/科研/政府/教育</a></li>
		    <li><a datavalue="42"> 餐饮/娱乐</a></li>
		    <li><a datavalue="43"> 酒店/旅游</a></li>
		    <li><a datavalue="44"> 美容/美发/健身/保健/体育</a></li>
		    <li><a datavalue="45"> 百货/连锁/零售服务</a></li>
		    <li><a datavalue="46"> 交通运输服务</a></li>
		    <li><a datavalue="47"> 保安/家政/其他服务</a></li>
		    <li><a datavalue="48"> 翻译/翻译（口译与笔译）</a></li>
		    <li><a datavalue="49"> 环保/环境科学</a></li>
		    <li><a datavalue="50"> 其他</a></li>
		    <li><a datavalue="51"> 艺术/设计/美术/创意</a></li>
		    <li><a datavalue="52"> 包装/印刷</a></li>
		  </ul>
	    <div class="choose-post-panel2 choose-panel2"></div>
    </div> 
    
    <!--区域   -->
		<div id="popInner"  class="mini-window" style="width: 700px; display: none;" title="请选择区域 " showFooter="true">
	    <div class="pop-main">
	      <div class="main-city">
	        <h4 class="title">
	         	主要城市
	          <input type="text" id="areaSearch" class="search-input radius" value="市.区(拼音首字母/中文/英文)"></input>
	          <input id="hidQuickAreaId" type="hidden" value="">
	        </h4>
	        <div id="mainCities">
	          <ul class="MainCityList"></ul>
	        </div>
	      </div>
	      <div class="pop-status city-list" id="cityList">
	      	<h4 class="title">全国各省</h4>
	        <div id="allProv" class="allProv"></div>
	      </div>
	      <div property="footer" class="win-footer">
	        <input type="button" class="win-footer-btn" value="取消" onclick="closeWin()"></input>
	     	</div>
	    </div>
    </div>
    <div id="sublist"></div>
		<div id="countyList"></div>

    <!-- 标签  -->
    <div id="resume-choose-win" class="mini-window" style="width: 520px; display: none;" title="选择标签" showFooter="true">
	    <div class="resume-choose-label">
	    	<div id="choosedLabel">
	        <span id="choosedTitle"><b>已选标签：</b></span>
	        <span id="choosedTags"></span>
	      </div>
	      <div id="resume-hotTags">
	        <h3 class="tagTitle">常用标签</h3>
	        <div id="inner-hotTags"></div>
	      </div>
	    </div>
	    <div class="allHotTags">
	      <div class="label-category">
	        <span class="category-title">岗位职能</span> 
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">人力资源类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">战略规划类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">C办类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">行政类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">销售类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">财务类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">法务类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">IT类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">制造类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">研发类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">供应链类</span>
	      </div>
	      <div class="label-category">
	        <span class="category-title">甄选记录</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">储备类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">筛选通过</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">HR类</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">专业淘汰</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">拒绝offer</span>
	      </div>
	      <div class="label-category">
	        <span class="category-title">淘汰原因</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">知识</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">经验</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">动力匹配型</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">背景调查</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">能力</span>
	      </div>
	      <div class="label-category">
	        <span class="category-title">目标公司</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">京东方</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">熊猫</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">三星</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">LG</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">友达</span>
	      </div>
	      <div class="label-category">
	         <span class="category-title">语言技能</span>
	         <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">英语</span>
	         <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">日语</span>
	         <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">俄语</span>
	         <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">韩语</span>
	         <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">法语</span>
	       </div>
	      <div class="label-category">
	      	<span class="category-title">HR建议</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">黑名单</span>
	        <span class="resume-hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">建议跟踪</span>
	      </div>
	    </div>
	    <div property="footer" class="win-footer">
		  	<input type="button" class="win-footer-btn" id ="confirmLabel"value="确定" onclick="confirmLabel('resume-choose-win')"></input>
		    <input type="button" class="win-footer-btn" value="取消" onclick="closeWindow('resume-choose-win')"></input>
		  </div>
	  </div>
    
    <!-- 简历加入候选人 -->
    <div id="resume-add-candidate-win" class="mini-window" style="width: 460px;height: auto; display: none;" title="添加到候选人列表" showFooter="true">
	  	<div class="resume-add-candidate-div1" >
	      <table class="resume-add-candidate-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td width="20%" class="c999">候选人姓名：</td>
	          	<td width="" id="candidateName"></td>
	          </tr>
	          <tr>
	          	<td  class="c999">关联职位：</td>
              <td>
                <select id="relatePositionName" style="width:150px;">
                  
                </select>
              </td>
	          </tr>
	          <tr>
	            <td class="c999"><span class="red">*</span>招聘渠道：</td>
              <td>
               <input type="radio" checked="checked" value="0" name="isChannel">默认渠道<span class="c999">(默认为简历的原始渠道，如超过 9 个月渠道则设置为企业人才库)</span>
            	</td>
	          </tr>
	          <tr>
	          	<td class="c999"></td>
	          	<td id="otherChannel">
               <input type="radio" value="1" name="isChannel">其他渠道&nbsp;
							 <select id="resumeChannel" name="resumeChannel" style="width: 212px;display: inline">    
    						 <option value="" selected>请选择</option>
                 <option value="7">官网</option>
                 <option value="1100">&#12288;PC官网</option>
                 <option value="1101">&#12288;移动官网</option>
                 <option value="1104">&#12288;微信</option>
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
	      </tbody>
	    </table>
	  </div>
	  <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	    <input type="button" value="确定" onclick="addToCandidate('resume-add-candidate-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    <input type="button" value="取消" onclick="hideWindow('resume-add-candidate-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	  </div>
	</div>
	
		<!-- 发送简历 -->
		<jsp:include page="../publicPage/sendResume.jsp"/>
		
		<!-- 发送邮件 -->
    <div id="resume-send-mail-win" class="mini-window" style="display: none;width: 500px;height: auto; " title="发送邮件  " showFooter="true">
	  	<div class="resume-send-mail-div1" >
	  	  <span class="c999">邮箱地址： </span>
	      <textarea style="width: 460px; height: 80px;" id="txtResumeEmails"></textarea>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="sendMail('resume-send-mail-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('resume-send-mail-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
		</div>
		
		<!-- 发送短信 -->
		<jsp:include page="../publicPage/sendMessage.jsp"/>
		
		<!-- 删除简历 -->
		<div id="resume-del-win" class="mini-window" style="width: 200px;height: 150; display: none;" title="删除简历" showFooter="true">
  		<div class="delResume" style="background-color: white;text-align: center; padding-top: 30px;padding-bottom: 20px;font-size: 13px;">
     		<p> 真的要删除简历吗?</p>
    	</div>
    	<div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
      	<input type="button" value="确定" onclick="deleteResume('resume-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
      	<input type="button" value="取消" onclick="hideWindow('resume-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
    	</div>
		</div>
    
    <jsp:include page="./tagSelect.jsp"/>
    <jsp:include page="/webpage/footer.jsp"/>
  </body>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/professionalCategory.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/resume/tagSelect.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/resume/resumeRepository.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/industryAutoComplete.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/industryAuto.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/schoolData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/category.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
</html>