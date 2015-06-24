package com.ds.dreamstation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ds.dreamstation.po.Message;


/**
 * @author phn
 * @date 2015-5-28
 * @email 1016593477@qq.com
 * @TODO 
 */
public class MessageInfo {
	private long id;
	/**
	 * 评论人昵称
	 */
	private String commentName;
	/**
	 * 评论人邮箱
	 */
	private String commentEmail;
	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 评论时间
	 */
	private String commentTime;
	/**
	 * 留言审核状态：待审核，审核通过，审核失败
	 */
	private String status;
	private int statusNumber;
	/**
	 * 回复者（成员）姓名
	 */
	private String replyName;
	/**
	 * 回复时间
	 */
	private String replyTime;
	/**
	 * 回复内容
	 */
	private String replyContent;
	
	
	
	public MessageInfo() {
		super();
	}
	
	
	public MessageInfo(Message message) {
		super();
		this.id = message.getmId();
		this.commentName = message.getmCommentName();
		this.commentEmail = message.getmCommentEmail();
		this.commentContent = message.getmCommentContent();
		this.setCommentTime(message.getmCommentTime());
		this.setStatus(message.getmStatus());
		this.statusNumber = message.getmStatus();
		this.replyName = message.getmReplyName();
		this.setReplyTime(message.getmReplyTime());
		this.replyContent = message.getmReplyContent();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public String getCommentEmail() {
		return commentEmail;
	}
	public void setCommentEmail(String commentEmail) {
		this.commentEmail = commentEmail;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		if(commentTime==null){
			this.commentTime = "";
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			this.commentTime = sdf.format(commentTime);
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(int status) {
		StringBuffer sb = new StringBuffer();
		switch (status) {
		case 0:
			sb = new StringBuffer("待审核");
			break;
		case 1:
			sb = new StringBuffer("审核通过");
			break;
		case 2:
			sb = new StringBuffer("审核失败");
			break;
		default:
			sb = new StringBuffer("待审核");
			break;
		}
		this.status = sb.toString();
	}
	
	public int getStatusNumber() {
		return statusNumber;
	}


	public void setStatusNumber(int statusNumber) {
		this.statusNumber = statusNumber;
	}


	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		if(replyTime==null){
			this.replyTime ="";
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			this.replyTime = sdf.format(replyTime);
		}
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	@Override
	public String toString() {
		return "MessageInfo [id=" + id + ", commentName=" + commentName
				+ ", commentEmail=" + commentEmail + ", commentContent="
				+ commentContent + ", commentTime=" + commentTime + ", status="
				+ status + ", statusNumber=" + statusNumber + ", replyName="
				+ replyName + ", replyTime=" + replyTime + ", replyContent="
				+ replyContent + "]";
	}
	
}
