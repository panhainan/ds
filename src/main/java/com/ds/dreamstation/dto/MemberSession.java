package com.ds.dreamstation.dto;

import com.ds.dreamstation.po.Authority;


/**
 * @author phn
 * @date 2015-5-26
 * @email 1016593477@qq.com
 * @TODO
 */
public class MemberSession {
	private int id;
	private String email;
	private String name;
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
	 * 能否管理成员
	 */
	private boolean manageMember;

	/**
	 * 能否管理管理员
	 */
	private boolean manageAdmin;

	public MemberSession() {
		super();
	}

	/**
	 * @param email
	 * @param name
	 * @param publishNews
	 * @param manageNews
	 * @param replyMessage
	 * @param managemessage
	 * @param publishProject
	 * @param manageProject
	 * @param manageMember
	 * @param manageAdmin
	 */
	public MemberSession(int id,String email, String name, Authority authority) {
		super();
		this.id =id;
		this.email = email;
		this.name = name;
		System.out.println(authority);
		this.publishNews = authority.isaPublishNews();
		this.manageNews = authority.isaManageNews();
		this.replyMessage = authority.isaReplyMessage();
		this.manageMessage = authority.isaManageMessage();
		this.publishProject = authority.isaPublishProject();
		this.manageProject = authority.isaManageProject();
		this.manageMember = authority.isaManageMember();
		this.manageAdmin = authority.isaManageAdmin();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "MemberSession [id=" + id + ", email=" + email + ", name="
				+ name + ", publishNews=" + publishNews + ", manageNews="
				+ manageNews + ", replyMessage=" + replyMessage
				+ ", manageMessage=" + manageMessage + ", publishProject="
				+ publishProject + ", manageProject=" + manageProject
				+ ", manageMember=" + manageMember + ", manageAdmin="
				+ manageAdmin + "]";
	}

}
