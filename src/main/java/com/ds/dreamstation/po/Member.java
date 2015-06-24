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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

/**
 * @author phn
 * @date 2015-5-14
 * @email 1016593477@qq.com
 * @TODO 成员Bean，负责与数据库进行交互
 */
@Entity
@Table(name = "t_member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 9)
	private int mId;
	/**
	 * 成员姓名
	 */
	@Column(name = "name", length = 20)
	private String mName;
	/**
	 * 成员qq
	 */
	@Column(name = "qq", length = 16)
	private String mQq;
	/**
	 * 成员电话
	 */
	@Column(name = "phone", length = 16)
	private String mPhone;
	/**
	 * 成员年级：大一，大二，大三，大四，毕业，老师
	 */
	@Column(name = "grade", length = 1)
	private byte mGrade;
	/**
	 * 成员头像
	 */
	@Column(name = "picture", length = 80)
	private String mPicture;
	/**
	 * 成员类别：1程序员，2美工，3导师,4管理员
	 */
	@Column(name = "category", length = 1)
	private byte mCategory;
	/**
	 * 成员简介
	 */
	@Column(name = "introduction", length = 200)
	private String mIntroduction;
	/**
	 * 成员详细介绍
	 */
	@Column(name = "details")
	@Type(type="text")
	private String mDetails;
	/**
	 * 成员邮箱：用于登录已经收发通知
	 */
	@Column(name = "loginemail", length = 30)
	private String mLoginEmail;
	/**
	 * 成员登录密码
	 */
	@Column(name = "loginpass", length = 20)
	private String mLoginPass;
	/**
	 * 成员忘记密码获得的激活码
	 */
	@Column(name = "passlostcode", length = 32)
	private String mPassLostCode;
	/**
	 * 成员忘记密码获得激活码的时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "passlosttime")
	private Date mPassLostTime;
	/**
	 * 成员忘记密码获得的激活码是否有效
	 */
	@Column(name = "passloststatus", length = 1)
	private boolean mPassLostStatus;

	/**
	 * 成员权限
	 */
	@OneToOne
	@Cascade(CascadeType.DELETE)
	@JoinColumn(name="userauthority",referencedColumnName="id")
	private Authority mUserAuthority;

	public Member() {
		super();
	}

	/**
	 * @param mId
	 * @param mName
	 * @param mQq
	 * @param mPhone
	 * @param mGrade
	 * @param mPicture
	 * @param mCategory
	 * @param mIntroduction
	 * @param mDetails
	 * @param mLoginEmail
	 * @param mLoginPass
	 * @param mPassLostCode
	 * @param mPassLostTime
	 * @param mPassLostStatus
	 * @param mUserAuthority
	 */
	public Member(int mId, String mName, String mQq, String mPhone,
			byte mGrade, String mPicture, byte mCategory, String mIntroduction,
			String mDetails, String mLoginEmail, String mLoginPass,
			String mPassLostCode, Date mPassLostTime, boolean mPassLostStatus,
			Authority mUserAuthority) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mQq = mQq;
		this.mPhone = mPhone;
		this.mGrade = mGrade;
		this.mPicture = mPicture;
		this.mCategory = mCategory;
		this.mIntroduction = mIntroduction;
		this.mDetails = mDetails;
		this.mLoginEmail = mLoginEmail;
		this.mLoginPass = mLoginPass;
		this.mPassLostCode = mPassLostCode;
		this.mPassLostTime = mPassLostTime;
		this.mPassLostStatus = mPassLostStatus;
		this.mUserAuthority = mUserAuthority;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmQq() {
		return mQq;
	}

	public void setmQq(String mQq) {
		this.mQq = mQq;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public byte getmGrade() {
		return mGrade;
	}

	public void setmGrade(byte mGrade) {
		this.mGrade = mGrade;
	}

	public String getmPicture() {
		return mPicture;
	}

	public void setmPicture(String mPicture) {
		this.mPicture = mPicture;
	}

	public byte getmCategory() {
		return mCategory;
	}

	public void setmCategory(byte mCategory) {
		this.mCategory = mCategory;
	}

	public String getmIntroduction() {
		return mIntroduction;
	}

	public void setmIntroduction(String mIntroduction) {
		this.mIntroduction = mIntroduction;
	}

	public String getmDetails() {
		return mDetails;
	}

	public void setmDetails(String mDetails) {
		this.mDetails = mDetails;
	}

	public String getmLoginEmail() {
		return mLoginEmail;
	}

	public void setmLoginEmail(String mLoginEmail) {
		this.mLoginEmail = mLoginEmail;
	}

	public String getmLoginPass() {
		return mLoginPass;
	}

	public void setmLoginPass(String mLoginPass) {
		this.mLoginPass = mLoginPass;
	}

	public String getmPassLostCode() {
		return mPassLostCode;
	}

	public void setmPassLostCode(String mPassLostCode) {
		this.mPassLostCode = mPassLostCode;
	}

	public Date getmPassLostTime() {
		return mPassLostTime;
	}

	public void setmPassLostTime(Date mPassLostTime) {
		this.mPassLostTime = mPassLostTime;
	}

	public boolean ismPassLostStatus() {
		return mPassLostStatus;
	}

	public void setmPassLostStatus(boolean mPassLostStatus) {
		this.mPassLostStatus = mPassLostStatus;
	}

	public Authority getmUserAuthority() {
		return mUserAuthority;
	}

	public void setmUserAuthority(Authority mUserAuthority) {
		this.mUserAuthority = mUserAuthority;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mName=" + mName + ", mQq=" + mQq
				+ ", mPhone=" + mPhone + ", mGrade=" + mGrade + ", mPicture="
				+ mPicture + ", mCategory=" + mCategory + ", mIntroduction="
				+ mIntroduction + ", mDetails=" + mDetails + ", mLoginEmail="
				+ mLoginEmail + ", mLoginPass=" + mLoginPass
				+ ", mPassLostCode=" + mPassLostCode + ", mPassLostTime="
				+ mPassLostTime + ", mPassLostStatus=" + mPassLostStatus
				+ ", mUserAuthority=" + mUserAuthority + "]";
	}


}
