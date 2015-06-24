package com.ds.dreamstation.dto;

/**
 * @author phn
 * @date 2015-6-18
 * @email 1016593477@qq.com
 * @TODO
 */
public class MemberSearchForm {
	private String memberName;
	private int gradeNumber;
	private int categoryNumber;

	public MemberSearchForm() {
		super();
	}

	/**
	 * @param memberName
	 * @param gradeNumber
	 * @param categoryNumber
	 */
	public MemberSearchForm(String memberName, int gradeNumber,
			int categoryNumber) {
		super();
		this.memberName = memberName;
		this.gradeNumber = gradeNumber;
		this.categoryNumber = categoryNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Override
	public String toString() {
		return "MemberSearchInfo [memberName=" + memberName + ", gradeNumber="
				+ gradeNumber + ", categoryNumber=" + categoryNumber + "]";
	}

	/**
	 * @TODO 判断类别
	 * @param categoryNumber
	 */
	public StringBuffer judgeCategory(int categoryNumber) {
		// 程序员，美工，导师
		StringBuffer sbCategory;
		switch (categoryNumber) {
		case 1:
			sbCategory = new StringBuffer("程序员");
			break;
		case 2:
			sbCategory = new StringBuffer("设计师");
			break;
		case 3:
			sbCategory = new StringBuffer("导师");
			break;
		default:
			sbCategory = new StringBuffer("程序员");
			break;
		}
		return sbCategory;
	}

	/**
	 * @TODO 判断年级
	 * @param gradeNumber
	 */
	public StringBuffer judgeGrade(int gradeNumber) {
		StringBuffer sbGrade;
		switch (gradeNumber) {
		case 0:
			sbGrade = new StringBuffer("其他");
			break;
		case 1:
			sbGrade = new StringBuffer("大一");
			break;
		case 2:
			sbGrade = new StringBuffer("大二");
			break;
		case 3:
			sbGrade = new StringBuffer("大三");
			break;
		case 4:
			sbGrade = new StringBuffer("大四");
			break;
		case 5:
			sbGrade = new StringBuffer("毕业");
			break;
		case 6:
			sbGrade = new StringBuffer("老师");
			break;
		default:
			sbGrade = new StringBuffer("其他");
			break;
		}
		return sbGrade;
	}

}
