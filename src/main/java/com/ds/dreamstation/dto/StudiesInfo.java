package com.ds.dreamstation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ds.dreamstation.po.Studies;


/**
 * @author phn
 * @date 2015-6-12
 * @email 1016593477@qq.com
 * @TODO
 */
public class StudiesInfo {

	private long id;
	/**
	 * 发布时间
	 */
	private String publishTime;
	/**
	 * 阶段主题
	 */
	private String periodTheme;
	/**
	 * 阶段时间段
	 */
	private String periodTime;
	/**
	 * 阶段内容
	 */
	private String periodContent;
	/**
	 * 外键，发布者id
	 */
	private int memberId;
	/**
	 * 发布者姓名
	 */
	private String memberName;

	public StudiesInfo() {
		super();
	}

	/**
	 * @param id
	 * @param publishTime
	 * @param periodTheme
	 * @param periodTime
	 * @param periodContent
	 * @param memberId
	 * @param memberName
	 */
	public StudiesInfo(Studies studies) {
		super();
		this.id = studies.getsId();
		this.setPublishTime(studies.getsPublishTime());
		this.periodTheme = studies.getsPeriodTheme();
		this.periodTime = studies.getsPeriodTime();
		this.periodContent = studies.getsPeriodContent();
		this.memberId = studies.getsMember().getmId();
		this.memberName = studies.getsMember().getmName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.publishTime = sdf.format(publishTime);
	}

	public String getPeriodTheme() {
		return periodTheme;
	}

	public void setPeriodTheme(String periodTheme) {
		this.periodTheme = periodTheme;
	}

	public String getPeriodTime() {
		return periodTime;
	}

	public void setPeriodTime(String periodTime) {
		this.periodTime = periodTime;
	}

	public String getPeriodContent() {
		return periodContent;
	}

	public void setPeriodContent(String periodContent) {
		this.periodContent = periodContent;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "StudiesInfo [id=" + id + ", publishTime=" + publishTime
				+ ", periodTheme=" + periodTheme + ", periodTime=" + periodTime
				+ ", periodContent=" + periodContent + ", memberId=" + memberId
				+ ", memberName=" + memberName + "]";
	}

}
