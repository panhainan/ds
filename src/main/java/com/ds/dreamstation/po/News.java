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
 * @TODO 新闻动态实体Bean
 */
@Entity
@Table(name = "t_news")
public class News {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nId;
	/**
	 * 新闻标题
	 */
	@Column(name = "title", length = 40)
	private String nTitle;

	/**
	 * 新闻概要
	 */
	@Column(name = "summary")
	private String nSummary;
	/**
	 * 新闻内容
	 */
	@Column(name = "content")
	@Type(type="text")
	private String nContent;
	/**
	 * 新闻发布时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publishtime")
	private Date nPublishTime;
	/**
	 * 新闻审核状态：0待审核，1审核通过，2审核失败
	 */
	@Column(name = "status", length = 1)
	private byte nStatus;
	/**
	 * 新闻作者：即某个成员
	 */
	@Column(name = "author", length = 30)
	private String nAuthor;

	public News() {
		super();
	}

	/**
	 * @param nId
	 * @param nTitle
	 * @param nSumary
	 * @param nContent
	 * @param nPublishTime
	 * @param nStatus
	 * @param nAuthor
	 */
	public News(int nId, String nTitle, String nSummary, String nContent,
			Date nPublishTime, byte nStatus, String nAuthor) {
		super();
		this.nId = nId;
		this.nTitle = nTitle;
		this.nSummary = nSummary;
		this.nContent = nContent;
		this.nPublishTime = nPublishTime;
		this.nStatus = nStatus;
		this.nAuthor = nAuthor;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnSummary() {
		return nSummary;
	}

	public void setnSummary(String nSummary) {
		this.nSummary = nSummary;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnPublishTime() {
		return nPublishTime;
	}

	public void setnPublishTime(Date nPublishTime) {
		this.nPublishTime = nPublishTime;
	}

	public byte getnStatus() {
		return nStatus;
	}

	public void setnStatus(byte nStatus) {
		this.nStatus = nStatus;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	@Override
	public String toString() {
		return "News [nId=" + nId + ", nTitle=" + nTitle + ", nSumary="
				+ nSummary + ", nContent=" + nContent + ", nPublishTime="
				+ nPublishTime + ", nStatus=" + nStatus + ", nAuthor="
				+ nAuthor + "]\n";
	}

}
