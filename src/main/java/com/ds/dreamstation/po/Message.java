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
@Table(name="t_message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",length=18)
	private long mId;
	/**
	 * 评论人昵称
	 */
	@Column(name="commentname",length=20)
	private String mCommentName;
	/**
	 * 评论人邮箱
	 */
	@Column(name="commentemail",length=30)
	private String mCommentEmail;
	/**
	 * 评论内容
	 */
	@Column(name="commentcontent")
	@Type(type="text")
	private String mCommentContent;
	/**
	 * 评论时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="commenttime")
	private Date mCommentTime;
	/**
	 * 留言审核状态：待审核，审核通过，审核失败
	 */
	@Column(name="status",length=1)
	private int mStatus;
	/**
	 * 回复者（成员）姓名
	 */
	@Column(name="replyname",length=20)
	private String mReplyName;
	/**
	 * 回复时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="replytime")
	private Date mReplyTime;
	/**
	 * 回复内容
	 */
	@Column(name="replycontent")
	@Type(type="text")
	private String mReplyContent;
	
	public Message() {
		super();
	}

	/**
	 * @param mId
	 * @param mCommentName
	 * @param mCommentEmail
	 * @param mCommentContent
	 * @param mCommentTime
	 * @param mStatus
	 * @param mReplyName
	 * @param mReplyTime
	 * @param mReplyContent
	 */
	public Message(long mId, String mCommentName, String mCommentEmail,
			String mCommentContent, Date mCommentTime, int mStatus,
			String mReplyName, Date mReplyTime, String mReplyContent) {
		super();
		this.mId = mId;
		this.mCommentName = mCommentName;
		this.mCommentEmail = mCommentEmail;
		this.mCommentContent = mCommentContent;
		this.mCommentTime = mCommentTime;
		this.mStatus = mStatus;
		this.mReplyName = mReplyName;
		this.mReplyTime = mReplyTime;
		this.mReplyContent = mReplyContent;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public String getmCommentName() {
		return mCommentName;
	}

	public void setmCommentName(String mCommentName) {
		this.mCommentName = mCommentName;
	}

	public String getmCommentEmail() {
		return mCommentEmail;
	}

	public void setmCommentEmail(String mCommentEmail) {
		this.mCommentEmail = mCommentEmail;
	}

	public String getmCommentContent() {
		return mCommentContent;
	}

	public void setmCommentContent(String mCommentContent) {
		this.mCommentContent = mCommentContent;
	}

	public Date getmCommentTime() {
		return mCommentTime;
	}

	public void setmCommentTime(Date mCommentTime) {
		this.mCommentTime = mCommentTime;
	}

	public int getmStatus() {
		return mStatus;
	}

	public void setmStatus(int mStatus) {
		this.mStatus = mStatus;
	}

	public String getmReplyName() {
		return mReplyName;
	}

	public void setmReplyName(String mReplyName) {
		this.mReplyName = mReplyName;
	}

	public Date getmReplyTime() {
		return mReplyTime;
	}

	public void setmReplyTime(Date mReplyTime) {
		this.mReplyTime = mReplyTime;
	}

	public String getmReplyContent() {
		return mReplyContent;
	}

	public void setmReplyContent(String mReplyContent) {
		this.mReplyContent = mReplyContent;
	}

	@Override
	public String toString() {
		return "Message [mId=" + mId + ", mCommentName=" + mCommentName
				+ ", mCommentEmail=" + mCommentEmail + ", mCommentContent="
				+ mCommentContent + ", mCommentTime=" + mCommentTime
				+ ", mStatus=" + mStatus + ", mReplyName=" + mReplyName
				+ ", mReplyTime=" + mReplyTime + ", mReplyContent="
				+ mReplyContent + "]";
	}

}
