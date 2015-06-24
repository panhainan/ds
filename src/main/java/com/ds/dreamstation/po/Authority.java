package com.ds.dreamstation.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.dreamstation.dto.AuthorityForm;

/**
 * @author phn
 * @date 2015-5-14
 * @email 1016593477@qq.com
 * @TODO 成员权限Bean，负责与数据库交互
 */
@Entity
@Table(name = "t_authority")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 9)
	private int aId;
	/**
	 * 是否能够发布新闻
	 */
	@Column(name = "publishnews", length = 1)
	private boolean aPublishNews;
	/**
	 * 能否管理新闻
	 */
	@Column(name = "managenews", length = 1)
	private boolean aManageNews;
	/**
	 * 能否回复留言
	 */
	@Column(name = "replymessage", length = 1)
	private boolean aReplyMessage;
	/**
	 * 能否管理留言
	 */
	@Column(name = "managemessage", length = 1)
	private boolean aManageMessage;
	/**
	 * 能否发布项目
	 */
	@Column(name = "publishProject", length = 1)
	private boolean aPublishProject;
	/**
	 * 能否管理项目
	 */
	@Column(name = "manageproject", length = 1)
	private boolean aManageProject;
	/**
	 * 能够登录
	 */
	@Column(name = "allowlogin", length = 1)
	private boolean aAllowLogin;
	/**
	 * 能否管理成员，能否管理首页
	 */
	@Column(name = "managemember", length = 1)
	private boolean aManageMember;

	/**
	 * 能否管理管理员
	 */
	@Column(name = "manageadmin", length = 1)
	private boolean aManageAdmin;

	public Authority() {
		super();
		this.aPublishNews = false;
		this.aManageNews = false;
		this.aReplyMessage = false;
		this.aManageMessage = false;
		this.aPublishProject = false;
		this.aManageProject = false;
		this.aAllowLogin = false;
		this.aManageMember = false;
		this.aManageAdmin = false;
	}
	public Authority(AuthorityForm authorityForm) {
		super();
		this.aPublishNews = authorityForm.isPublishNews();
		this.aManageNews = authorityForm.isManageNews();
		this.aReplyMessage = authorityForm.isReplyMessage();
		this.aManageMessage = authorityForm.isManageMessage();
		this.aPublishProject = authorityForm.isPublishProject();
		this.aManageProject = authorityForm.isManageProject();
		this.aAllowLogin = authorityForm.isAllowLogin();
		this.aManageMember = authorityForm.isManageMember();
		this.aManageAdmin = authorityForm.isManageAdmin();
	}

	/**
	 * @param aPublishNews
	 * @param aManageNews
	 * @param aReplyMessage
	 * @param aManagemessage
	 * @param aPublishProject
	 * @param aManageProject
	 * @param aAllowLogin
	 * @param aManageMember
	 */
	public Authority(boolean aPublishNews, boolean aManageNews,
			boolean aReplyMessage, boolean aManageMessage,
			boolean aPublishProject, boolean aManageProject,
			boolean aAllowLogin, boolean aManageMember,boolean aManageAdmin) {
		super();
		this.aPublishNews = aPublishNews;
		this.aManageNews = aManageNews;
		this.aReplyMessage = aReplyMessage;
		this.aManageMessage = aManageMessage;
		this.aPublishProject = aPublishProject;
		this.aManageProject = aManageProject;
		this.aAllowLogin = aAllowLogin;
		this.aManageMember = aManageMember;
		this.aManageAdmin = aManageAdmin;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public boolean isaPublishNews() {
		return aPublishNews;
	}

	public void setaPublishNews(boolean aPublishNews) {
		this.aPublishNews = aPublishNews;
	}

	public boolean isaManageNews() {
		return aManageNews;
	}

	public void setaManageNews(boolean aManageNews) {
		this.aManageNews = aManageNews;
	}

	public boolean isaReplyMessage() {
		return aReplyMessage;
	}

	public void setaReplyMessage(boolean aReplyMessage) {
		this.aReplyMessage = aReplyMessage;
	}

	public boolean isaManageMessage() {
		return aManageMessage;
	}

	public void setaManageMessage(boolean aManageMessage) {
		this.aManageMessage = aManageMessage;
	}

	public boolean isaPublishProject() {
		return aPublishProject;
	}

	public void setaPublishProject(boolean aPublishProject) {
		this.aPublishProject = aPublishProject;
	}

	public boolean isaManageProject() {
		return aManageProject;
	}

	public void setaManageProject(boolean aManageProject) {
		this.aManageProject = aManageProject;
	}

	public boolean isaAllowLogin() {
		return aAllowLogin;
	}

	public void setaAllowLogin(boolean aAllowLogin) {
		this.aAllowLogin = aAllowLogin;
	}

	public boolean isaManageMember() {
		return aManageMember;
	}

	public void setaManageMember(boolean aManageMember) {
		this.aManageMember = aManageMember;
	}

	public boolean isaManageAdmin() {
		return aManageAdmin;
	}

	public void setaManageAdmin(boolean aManageAdmin) {
		this.aManageAdmin = aManageAdmin;
	}

	@Override
	public String toString() {
		return "Authority [aId=" + aId + ", aPublishNews=" + aPublishNews
				+ ", aManageNews=" + aManageNews + ", aReplyMessage="
				+ aReplyMessage + ", aManageMessage=" + aManageMessage
				+ ", aPublishProject=" + aPublishProject + ", aManageProject="
				+ aManageProject + ", aAllowLogin=" + aAllowLogin
				+ ", aManageMember=" + aManageMember + ", aManageAdmin="
				+ aManageAdmin + "]";
	}

}
