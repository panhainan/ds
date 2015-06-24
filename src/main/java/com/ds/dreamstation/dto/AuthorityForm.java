package com.ds.dreamstation.dto;

import com.ds.dreamstation.po.Authority;

/**
 * @author phn
 * @date 2015-5-27
 * @email 1016593477@qq.com
 * @TODO
 */
public class AuthorityForm {
	/**
	 * 成员id
	 */
	private int memberId;
	
	/**
	 * 是否能够发布新闻
	 */
	private boolean publishNews;
	/**
	 * 能否管理新闻
	 */
	private boolean manageNews;
	/**
	 * 能否回复留言
	 */
	private boolean replyMessage;
	/**
	 * 能否管理留言
	 */
	private boolean manageMessage;
	/**
	 * 能否发布项目
	 */
	private boolean publishProject;
	/**
	 * 能否管理项目
	 */
	private boolean manageProject;
	/**
	 * 能够登录
	 */
	private boolean allowLogin;
	/**
	 * 能否管理成员
	 */
	private boolean manageMember;

	/**
	 * 能否管理管理员
	 */
	private boolean manageAdmin;

	public AuthorityForm() {
		super();
	}

	public AuthorityForm(int memberId,Authority authority) {
		super();
		this.memberId=memberId;
		this.allowLogin = authority.isaAllowLogin();
		this.manageAdmin = authority.isaManageAdmin();
		this.manageMember = authority.isaManageMember();
		this.manageMessage = authority.isaManageMessage();
		this.manageNews = authority.isaManageNews();
		this.manageProject = authority.isaManageProject();
		this.publishNews = authority.isaPublishNews();
		this.publishProject = authority.isaPublishProject();
		this.replyMessage = authority.isaReplyMessage();

	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean isPublishNews() {
		return publishNews;
	}

	public void setPublishNews(boolean publishNews) {
		this.publishNews = publishNews;
	}

	public boolean isManageNews() {
		return manageNews;
	}

	public void setManageNews(boolean manageNews) {
		this.manageNews = manageNews;
	}

	public boolean isReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(boolean replyMessage) {
		this.replyMessage = replyMessage;
	}


	public boolean isManageMessage() {
		return manageMessage;
	}

	public void setManageMessage(boolean manageMessage) {
		this.manageMessage = manageMessage;
	}

	public boolean isPublishProject() {
		return publishProject;
	}

	public void setPublishProject(boolean publishProject) {
		this.publishProject = publishProject;
	}

	public boolean isManageProject() {
		return manageProject;
	}

	public void setManageProject(boolean manageProject) {
		this.manageProject = manageProject;
	}

	public boolean isAllowLogin() {
		return allowLogin;
	}

	public void setAllowLogin(boolean allowLogin) {
		this.allowLogin = allowLogin;
	}

	public boolean isManageMember() {
		return manageMember;
	}

	public void setManageMember(boolean manageMember) {
		this.manageMember = manageMember;
	}

	public boolean isManageAdmin() {
		return manageAdmin;
	}

	public void setManageAdmin(boolean manageAdmin) {
		this.manageAdmin = manageAdmin;
	}

	@Override
	public String toString() {
		return "AuthorityForm [memberId=" + memberId + ", publishNews="
				+ publishNews + ", manageNews=" + manageNews
				+ ", replyMessage=" + replyMessage + ", manageMessage="
				+ manageMessage + ", publishProject=" + publishProject
				+ ", manageProject=" + manageProject + ", allowLogin="
				+ allowLogin + ", manageMember=" + manageMember
				+ ", manageAdmin=" + manageAdmin + "]";
	}

}
