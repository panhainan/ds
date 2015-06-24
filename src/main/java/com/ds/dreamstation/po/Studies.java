package com.ds.dreamstation.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author phn
 * @date 2015-6-12
 * @email 1016593477@qq.com
 * @TODO
 */
@Entity
@Table(name = "t_studies")
public class Studies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 18)
	private long sId;
	/**
	 * 发布时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publishTime")
	private Date sPublishTime;
	/**
	 * 阶段主题
	 */
	@Column(name = "periodtheme", length = 40)
	private String sPeriodTheme;
	/**
	 * 阶段时间段
	 */
	@Column(name = "periodtime", length = 40)
	private String sPeriodTime;
	/**
	 * 阶段内容
	 */
	@Column(name = "periodcontent", length = 500)
	private String sPeriodContent;
	/**
	 * 外键，发布者
	 */
	@OneToOne
	@JoinColumn(name = "member", referencedColumnName = "id")
	private Member sMember;

	/**
	 * 
	 */
	public Studies() {
		super();
	}

	/**
	 * @param sId
	 * @param sPublishTime
	 * @param sPeriodTheme
	 * @param sPeriodTime
	 * @param sPeriodContent
	 * @param smember
	 */
	public Studies(long sId, Date sPublishTime, String sPeriodTheme,
			String sPeriodTime, String sPeriodContent, Member sMember) {
		super();
		this.sId = sId;
		this.sPublishTime = sPublishTime;
		this.sPeriodTheme = sPeriodTheme;
		this.sPeriodTime = sPeriodTime;
		this.sPeriodContent = sPeriodContent;
		this.sMember = sMember;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public Date getsPublishTime() {
		return sPublishTime;
	}

	public void setsPublishTime(Date sPublishTime) {
		this.sPublishTime = sPublishTime;
	}

	public String getsPeriodTheme() {
		return sPeriodTheme;
	}

	public void setsPeriodTheme(String sPeriodTheme) {
		this.sPeriodTheme = sPeriodTheme;
	}

	public String getsPeriodTime() {
		return sPeriodTime;
	}

	public void setsPeriodTime(String sPeriodTime) {
		this.sPeriodTime = sPeriodTime;
	}

	public String getsPeriodContent() {
		return sPeriodContent;
	}

	public void setsPeriodContent(String sPeriodContent) {
		this.sPeriodContent = sPeriodContent;
	}


	public Member getsMember() {
		return sMember;
	}

	public void setsMember(Member sMember) {
		this.sMember = sMember;
	}

	@Override
	public String toString() {
		return "Studies [sId=" + sId + ", sPublishTime=" + sPublishTime
				+ ", sPeriodTheme=" + sPeriodTheme + ", sPeriodTime="
				+ sPeriodTime + ", sPeriodContent=" + sPeriodContent
				+ ", sMember=" + sMember + "]";
	}

}
