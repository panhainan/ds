package com.ds.dreamstation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author phn
 * @date 2015-5-24
 * @email 1016593477@qq.com
 * @TODO
 */
public class ProjectInfo {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 项目简介
	 */
	private String summary;
	/**
	 * 项目详细情况
	 */
	private String details;
	/**
	 * 项目访问地址
	 */
	private String website;
	/**
	 * 项目展示图片
	 */
	private String picture;
	/**
	 * 项目负责人（成员）
	 */
	private String author;
	/**
	 * 项目小组人员
	 */
	private String groupMember;
	/**
	 * 项目审核状态：待审核，正在审核，审核通过
	 */
	private String status;
	/**
	 * 项目发布时间
	 */
	private String publishTime;

	public ProjectInfo() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param summary
	 * @param details
	 * @param website
	 * @param picture
	 * @param author
	 * @param groupMember
	 * @param status
	 * @param publishTime
	 */
	public ProjectInfo(int id, String name, String summary, String details,
			String website, String picture, String author, String groupMember,
			byte status, Date publishTime) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.details = details;
		this.website = website;
		this.picture = picture;
		this.author = author;
		this.groupMember = groupMember;
		this.setStatus(status);
		this.setPublishTime(publishTime);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGroupMember() {
		return groupMember;
	}

	public void setGroupMember(String groupMember) {
		this.groupMember = groupMember;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		// 0待审核，1审核通过，2审核失败
		switch (status) {
		case 0:
			this.status = "待审核";
			break;
		case 1:
			this.status = "审核通过";
			break;
		case 2:
			this.status = "审核失败";
			break;
		default:
			this.status = "待审核";
			break;
		}
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		if(publishTime==null){
			this.publishTime = "";
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			this.publishTime = sdf.format(publishTime);
		}
	}

	@Override
	public String toString() {
		return "ProjectInfo [id=" + id + ", name=" + name + ", summary="
				+ summary + ", details=" + details + ", website=" + website
				+ ", picture=" + picture + ", author=" + author
				+ ", groupMember=" + groupMember + ", status=" + status
				+ ", publishTime=" + publishTime + "]";
	}

}
