package com.ds.dreamstation.dto;

import com.ds.dreamstation.po.IndexPic;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */
public class IndexInfo {
	/**
	 * 图片存在数据库中的编号
	 */
	private int id;
	/**
	 * 图片地址，全地址
	 */
	private String webSite;
	/**
	 * 图片名称
	 */
	private String name;
	/**
	 * 图片简介
	 */
	private String introduction;
	/**
	 * 图片展示优先级
	 */
	private int priority;
	
	
	public IndexInfo() {
		super();
	}
	public IndexInfo(IndexPic indexPic) {
		super();
		this.id = indexPic.getiPId();
		this.webSite = indexPic.getiPWebSite();
		this.name = indexPic.getiPName();
		this.introduction = indexPic.getiPIntroduction();
		this.priority = indexPic.getiPPriority();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "IndexInfo [id=" + id + ", webSite=" + webSite + ", name="
				+ name + ", introduction=" + introduction + ", priority="
				+ priority + "]";
	}
	
	
}
