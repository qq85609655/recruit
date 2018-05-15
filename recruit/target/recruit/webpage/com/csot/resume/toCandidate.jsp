<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" /> 
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/toCandidate.css"/>   
<script type="text/javascript" src="${webRoot}/resources/js/resume/toCandidate.js"></script>
    <!-- 简历加入候选人 -->
    <div id="resume-add-candidate-win" class="mini-window" style="width:400px; height:auto; display:none;" title="添加到候选人列表" showFooter="true">
	  	<div class="resume-add-candidate-div1" >
	      <table class="resume-add-candidate-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td class="label">候选人姓名：</td>
	          	<td id="candidateName"></td>
	          </tr>
	          <tr>
	          	<td class="label">关联职位：</td>
              <td><div class="position_name"><span id="positionName"></span><span class="font-icon icon-down-dir select"></span></div></td>
	          </tr>
	          <tr>
	            <td class="label">招聘渠道：</td>
              <td>
               <input type="radio" checked="checked" value="0" name="isChannel" />
               	默认渠道
               	<span class="tip">(默认为简历的原始渠道,如超过9个月渠道则设置为企业人才库)</span>
            	</td>
	          </tr>
	          <tr>
	          	<td></td>
	          	<td id="otherChannel">
               <input type="radio" value="1" name="isChannel">其他渠道&nbsp;
							 <select id="resumeChannel" name="resumeChannel">    
    						 <option value="">选择招聘渠道</option>
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
	  <div property="footer" class="win-footer">
	    <input type="button" class="win-footer-btn" value="确定" id="confirmCandidate" />
	    <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('resume-add-candidate-win')" />
	  </div>
	</div>
