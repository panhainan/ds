package com.ds.dreamstation.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO
 */
@Entity
@Table(name = "t_project")
public class Project {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	/**
	 * 项目名称
	 */
	@Column(name = "name", length = 30)
	private String pName;
	/**
	 * 项目简介
	 */
	@Column(name = "summary")
	private String pSummary;
	/**
	 * 项目详细情况
	 */
	@Column(name = "details")
	@Type(type="text")
	private String pDetails;
	/**
	 * 项目访问地址
	 */
	@Column(name = "website", length = 80)
	private String pWebSite;
	/**
	 * 项目展示图片
	 */
	@Column(name = "picture", length =100)
	private String pPicture;
	/**
	 * 项目负责人（成员）
	 */
	@Column(name = "author", length = 20)
	private String pAuthor;
	/**
	 * 项目小组人员
	 */
	@Column(name = "groupmember", length = 40)
	private String pGroupMember;
	/**
	 * 项目审核状态：待审核，正在审核，审核通过
	 */
	@Column(name = "status", length = 1)
	private byte pStatus;
	/**
	 * 项目发布时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publishtime")
	private Date pPublishTime;

	public Project() {
		super();
	}


	/**
	 * @param pId
	 * @param pName
	 * @param pSummary
	 * @param pDetails
	 * @param pWebSite
	 * @param pPicture
	 * @param pAuthor
	 * @param pGroupMember
	 * @param pStatus
	 * @param pPublishTime
	 */
	public Project(int pId, String pName, String pSummary, String pDetails,
			String pWebSite, String pPicture, String pAuthor,
			String pGroupMember, byte pStatus, Date pPublishTime) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pSummary = pSummary;
		this.pDetails = pDetails;
		this.pWebSite = pWebSite;
		this.pPicture = pPicture;
		this.pAuthor = pAuthor;
		this.pGroupMember = pGroupMember;
		this.pStatus = pStatus;
		this.pPublishTime = pPublishTime;
	}


	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSummary() {
		return pSummary;
	}


	public void setpSummary(String pSummary) {
		this.pSummary = pSummary;
	}


	public String getpDetails() {
		return pDetails;
	}

	public void setpDetails(String pDetails) {
		this.pDetails = pDetails;
	}

	public String getpWebSite() {
		return pWebSite;
	}

	public void setpWebSite(String pWebSite) {
		this.pWebSite = pWebSite;
	}

	public String getpPicture() {
		return pPicture;
	}

	public void setpPicture(String pPicture) {
		this.pPicture = pPicture;
	}

	public String getpAuthor() {
		return pAuthor;
	}

	public void setpAuthor(String pAuthor) {
		this.pAuthor = pAuthor;
	}

	public String getpGroupMember() {
		return pGroupMember;
	}

	public void setpGroupMember(String pGroupMember) {
		this.pGroupMember = pGroupMember;
	}

	public byte getpStatus() {
		return pStatus;
	}

	public void setpStatus(byte pStatus) {
		this.pStatus = pStatus;
	}

	public Date getpPublishTime() {
		return pPublishTime;
	}

	public void setpPublishTime(Date pPublishTime) {
		this.pPublishTime = pPublishTime;
	}

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", pName=" + pName + ", pSummary="
				+ pSummary + ", pDetails=" + pDetails + ", pWebSite="
				+ pWebSite + ", pPicture=" + pPicture + ", pAuthor=" + pAuthor
				+ ", pGroupMember=" + pGroupMember + ", pStatus=" + pStatus
				+ ", pPublishTime=" + pPublishTime + "]";
	}

}