package com.ds.dreamstation.dto;

import com.ds.dreamstation.po.Member;

/**
 * @author phn
 * @date 2015-5-25
 * @email 1016593477@qq.com
 * @TODO
 */
public class MemberInfo {
	private int id;
	/**
	 * 成员姓名
	 */
	private String name;
	/**
	 * 成员qq
	 */
	private String qq;
	/**
	 * 成员电话
	 */
	private String phone;
	/**
	 * 成员年级：大一，大二，大三，大四，毕业，老师
	 */
	private String grade;
	private byte gradeNumber;
	/**
	 * 成员头像
	 */
	private String picture;
	/**
	 * 成员类别：程序员，美工，导师,管理员
	 */
	private String category;
	private byte categoryNumber;
	/**
	 * 成员简介
	 */
	private String introduction;
	/**
	 * 成员详细介绍
	 */
	private String details;
	/**
	 * 成员邮箱：用于登录已经收发通知
	 */
	private String loginEmail;
	
	/**
	 * 成员登录密码，主要用于获取注册时使用
	 */
	private String loginPass;
	/**
	 * 成员权限
	 */
	private AuthorityInfo userAuthority;

	public MemberInfo() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param qq
	 * @param phone
	 * @param grade
	 * @param picture
	 * @param category
	 * @param introduction
	 * @param details
	 * @param loginEmail
	 * @param loginPass
	 * @param passLostCode
	 * @param userAuthority
	 */
	public MemberInfo(Member member) {
		super();
		this.id = member.getmId();
		this.name = member.getmName();
		this.qq = member.getmQq();
		this.phone = member.getmPhone();
		this.setGrade(member.getmGrade());
		this.gradeNumber = member.getmGrade();
		this.picture = member.getmPicture();
		this.setCategory(member.getmCategory());
		this.categoryNumber = member.getmCategory();
		this.introduction = member.getmIntroduction();
		this.details = member.getmDetails();
		this.loginEmail = member.getmLoginEmail();
		//这里不需要将成员密码拿出
		this.userAuthority = new AuthorityInfo(member.getmUserAuthority());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(byte grade) {
		// 其他，大一，大二，大三，大四，毕业，老师
		StringBuffer sb;
		switch (grade) {
		case 0:
			sb = new StringBuffer("其他");
			break;
		case 1:
			sb = new StringBuffer("大一");
			break;
		case 2:
			sb = new StringBuffer("大二");
			break;
		case 3:
			sb = new StringBuffer("大三");
			break;
		case 4:
			sb = new StringBuffer("大四");
			break;
		case 5:
			sb = new StringBuffer("毕业");
			break;
		case 6:
			sb = new StringBuffer("老师");
			break;
		default:
			sb = new StringBuffer("其他");
			break;
		}
		this.grade = sb.toString();
	}

	public byte getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(byte gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(byte category) {
		// 程序员，美工，导师
		StringBuffer sb;
		switch (category) {
		case 1:
			sb = new StringBuffer("程序员");
			break;
		case 2:
			sb = new StringBuffer("设计师");
			break;
		case 3:
			sb = new StringBuffer("导师");
			break;
		case 4:
			sb = new StringBuffer("管理员");
			break;
		default:
			sb = new StringBuffer("管理员");
			break;
		}
		this.category = sb.toString();
	}

	public byte getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(byte categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public AuthorityInfo getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(AuthorityInfo userAuthority) {
		this.userAuthority = userAuthority;
	}

	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", name=" + name + ", qq=" + qq
				+ ", phone=" + phone + ", grade=" + grade + ", gradeNumber="
				+ gradeNumber + ", picture=" + picture + ", category="
				+ category + ", categoryNumber=" + categoryNumber
				+ ", introduction=" + introduction + ", details=" + details
				+ ", loginEmail=" + loginEmail + ", loginPass=" + loginPass
				+ ", userAuthority=" + userAuthority + "]";
	}

}
