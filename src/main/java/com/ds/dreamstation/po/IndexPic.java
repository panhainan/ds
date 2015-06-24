package com.ds.dreamstation.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */
@Entity
@Table(name="t_indexpic")
public class IndexPic {
	/**
	 * 图片存在数据库中的编号
	 */
	@Id
	@Column(name="id",length=2)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iPId;
	/**
	 * 图片地址，全地址
	 */
	@Column(name="ipwebsite",length=120)
	private String iPWebSite;
	/**
	 * 图片名称
	 */
	@Column(name="ipname",length=30)
	private String iPName;
	/**
	 * 图片简介
	 */
	@Column(name="ipintroduction",length=50)
	private String iPIntroduction;
	/**
	 * 图片展示优先级
	 */
	@Column(name="ippriority",length=1)
	private int iPPriority;
	
	public IndexPic() {
		super();
	}
	/**
	 * @param id
	 * @param iPWebSite
	 * @param iPName
	 * @param iPIntroduction
	 * @param iPPriority
	 */
	public IndexPic( String iPWebSite, String iPName,
			String iPIntroduction, int iPPriority) {
		super();
		this.iPWebSite = iPWebSite;
		this.iPName = iPName;
		this.iPIntroduction = iPIntroduction;
		this.iPPriority = iPPriority;
	}
	public int getiPId() {
		return iPId;
	}
	public void setiPId(int iPId) {
		this.iPId = iPId;
	}
	public String getiPWebSite() {
		return iPWebSite;
	}
	public void setiPWebSite(String iPWebSite) {
		this.iPWebSite = iPWebSite;
	}
	public String getiPName() {
		return iPName;
	}
	public void setiPName(String iPName) {
		this.iPName = iPName;
	}
	public String getiPIntroduction() {
		return iPIntroduction;
	}
	public void setiPIntroduction(String iPIntroduction) {
		this.iPIntroduction = iPIntroduction;
	}
	public int getiPPriority() {
		return iPPriority;
	}
	public void setiPPriority(int iPPriority) {
		this.iPPriority = iPPriority;
	}
	@Override
	public String toString() {
		return "IndexPic [iPId=" + iPId + ", iPWebSite=" + iPWebSite
				+ ", iPName=" + iPName + ", iPIntroduction=" + iPIntroduction
				+ ", iPPriority=" + iPPriority + "]";
	}
	
}
