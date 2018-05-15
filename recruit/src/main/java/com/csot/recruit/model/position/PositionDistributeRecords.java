package com.csot.recruit.model.position;

import java.util.Date;

/***
 * 职位分发模型类
 * @author zengrong
 *
 */
public class PositionDistributeRecords {

	//职位编号
	private String recruitPositionId;
	//职位名称
	private String positionName;
	//职位编码
	private String positionCode;
	//内部编码
	private String departmentCode;
	//地区
	private String workPlace;
	//发布者
	private String publisher;
	//分发站点
	private String publishSite;
	//分发结果网站
	private String publishUrl;
	//分发日期
	private Date distributeDate;
	//发布日期
	private Date releaseDate;
	//截止日期
	private Date expireDate;
	//分发结果
	private String publishResult;
	//错误信息
	private String errorMessage;
	//聘用部门
	private String department;
	//以下字段为查询发布日期、截止日期专用字段
	//分发开始日期
	private String startDistributeDate;
	//分发结束日期
	private String endDistributeDate;
	//截止开始日期
	private String startExpireDate;
	//截止结束日期
	private String endExpireDate;
	public String getRecruitPositionId() {
		return recruitPositionId;
	}
	public void setRecruitPositionId(String recruitPositionId) {
		this.recruitPositionId = recruitPositionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishSite() {
		return publishSite;
	}
	public void setPublishSite(String publishSite) {
		this.publishSite = publishSite;
	}
	public String getPublishUrl() {
		return publishUrl;
	}
	public void setPublishUrl(String publishUrl) {
		this.publishUrl = publishUrl;
	}
	public Date getDistributeDate() {
		return distributeDate;
	}
	public void setDistributeDate(Date distributeDate) {
		this.distributeDate = distributeDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getPublishResult() {
		return publishResult;
	}
	public void setPublishResult(String publishResult) {
		this.publishResult = publishResult;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStartDistributeDate() {
		return startDistributeDate;
	}
	public void setStartDistributeDate(String startDistributeDate) {
		this.startDistributeDate = startDistributeDate;
	}
	public String getEndDistributeDate() {
		return endDistributeDate;
	}
	public void setEndDistributeDate(String endDistributeDate) {
		this.endDistributeDate = endDistributeDate;
	}
	public String getStartExpireDate() {
		return startExpireDate;
	}
	public void setStartExpireDate(String startExpireDate) {
		this.startExpireDate = startExpireDate;
	}
	public String getEndExpireDate() {
		return endExpireDate;
	}
	public void setEndExpireDate(String endExpireDate) {
		this.endExpireDate = endExpireDate;
	}
	
}
