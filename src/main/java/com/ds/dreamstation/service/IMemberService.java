package com.ds.dreamstation.service;

import java.util.Map;

import com.ds.dreamstation.po.Member;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IMemberService {

	/**
	 * @TODO 成员注册 
	 * @param member
	 * @return 是否注册成功
	 */
	boolean register(Member member);
	/**
	 * @TODO 成员登录 
	 * @param loginEmail
	 * @param loginPass
	 * @return member
	 */
	Member login(String loginEmail,String loginPass);
	/**
	 * @TODO 成员修改个人基本信息
	 * @param member
	 */
	void edit(Member member);
	/**
	 * @TODO 修改头像 
	 * @param id
	 * @param pictureSite
	 * @return  
	 */
	void editPicture(int id,String pictureSite);
	/**
	 * @TODO 修改密码
	 * @param id
	 * @param oldPass
	 * @param newPass 
	 * @return message
	 */
	String editPass(int id, String oldPass, String newPass);
	/**
	 * @TODO 忘记密码 
	 * @param loginEmail
	 * @return 是否成功
	 */
	boolean losePass(int loginEmail);
	/**
	 * @TODO 
	 * @param email
	 * @return Member
	 */
	Member find(String email);
	
	/**
	 * @TODO 
	 * @param memberId
	 * @return
	 */
	Member find(int memberId);
	/**
	 * @TODO 
	 * @param current
	 * @param size
	 * @param isNotSuperAdmin
	 * @return
	 */
	Map<String, Object> paging(int current, int size, boolean isNotSuperAdmin);
	/**
	 * @TODO 
	 * @param current
	 * @param size
	 * @param isNotAdmin
	 * @param isNotSuperAdmin
	 * @return
	 */
	Map<String, Object> paging(int current, int size, boolean isNotAdmin, boolean isNotSuperAdmin);
	/**
	 * @TODO 前台用于根据类别分页展示成员信息
	 * @param current
	 * @param size
	 * @param category
	 * @return
	 */
	Map<String, Object> paging(int current, int size, int category);
	/**
	 * @TODO 
	 * @param id
	 * @param authorityId 
	 */
	void remove(int id, int authorityId);
	
	
	
	
	
	
}
