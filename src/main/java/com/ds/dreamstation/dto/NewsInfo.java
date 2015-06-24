package com.ds.dreamstation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ds.dreamstation.po.News;

/**
 * @author phn
 * @date 2015-5-23
 * @email 1016593477@qq.com
 * @TODO
 */
public class NewsInfo {
	private int id;
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻概要
	 */
	private String summary;

	/**
	 * 新闻内容
	 */
	private String content;
	/**
	 * 新闻发布时间
	 */
	private String publishTime;
	/**
	 * 新闻发布日期
	 */
	private String publishDate;

	/**
	 * 新闻审核状态：0待审核，1审核通过，2审核失败
	 */
	private String status;
	/**
	 * 新闻作者：即某个成员
	 */
	private String author;
	/**
	 * 用于首页展示是否显示new，最新
	 */
	private boolean theLast;

	public NewsInfo() {
		super();
	}

	/**
	 * @TODO 用于首页展示
	 * @param id
	 * @param title
	 */
	public NewsInfo(int id, String title, Date publishTime) {
		super();
		this.id = id;
		this.title = title;
		this.setTheLast(publishTime);
	}

	/**
	 * @param id
	 * @param title
	 * @param content
	 * @param publishtime
	 * @param status
	 * @param author
	 */
	public NewsInfo(int id, String title, String summary, String content,
			Date publishTime, byte status, String author) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		// 将时间修改为string类型
		this.setPublishTime(publishTime);
		this.setPublishDate(publishTime);
		// 将状态修改为string类型
		this.setStatus(status);
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		if (publishTime == null) {
			this.publishTime = "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			this.publishTime = sdf.format(publishTime);
		}

	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishTime) {
		if (publishTime == null) {
			this.publishDate = "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("M.dd");
			this.publishDate = sdf.format(publishTime);
		}
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

	public boolean isTheLast() {
		return theLast;
	}

	public void setTheLast(Date publishTime) {
		if (((new Date().getTime()) - publishTime.getTime()) > (1000 * 60 * 60 * 24 * 3)) {
			this.theLast = false;
		} else {
			this.theLast = true;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "NewsInfo [id=" + id + ", title=" + title + ", summary="
				+ summary + ", content=" + content + ", publishTime="
				+ publishTime + ", status=" + status + ", author=" + author
				+ "]";
	}

}
