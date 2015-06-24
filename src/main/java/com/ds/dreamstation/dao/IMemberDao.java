package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.Member;

/**
 * @author phn
 * @date 2015-5-16
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IMemberDao {
	/**
	 * @TODO 添加member并返回刚刚添加的member的id
	 * @param member
	 * @return memberID
	 */
	int insert(Member member);
	/**
	 * @TODO 通过id查找Member
	 * @param id
	 * @return Member
	 */
	Member select(int id);
	/**
	 * @TODO 通过loginEmail查找Member 
	 * @param loginEmail
	 * @return Member
	 */
	Member select(String loginEmail);
	/**
	 * @TODO 更新member
	 * @param member
	 * @return 暂时定为：memberID
	 */
	int update(Member member);
	/**
	 * @TODO 通过memberID删除Member
	 * @param id
	 */
	void delete(int id);
	/**
	 * @TODO 
	 * @param isNotSuperAdmin
	 * @return
	 */
	int count(boolean isNotSuperAdmin);
	/**
	 * @TODO 
	 * @param currentPageOffset
	 * @param size
	 * @param isNotSuperAdmin
	 * @return
	 */
	List<Member> paging(int currentPageOffset, int size, boolean isNotSuperAdmin);
	/**
	 * @TODO 
	 * @param isNotSuperAdmin
	 * @param isNotAdmin
	 * @return
	 */
	int count(boolean isNotSuperAdmin, boolean isNotAdmin);
	/**
	 * @TODO 
	 * @param currentPageOffset
	 * @param size
	 * @param isNotSuperAdmin
	 * @param isNotAdmin
	 * @return
	 */
	List<Member> paging(int currentPageOffset, int size,
			boolean isNotSuperAdmin, boolean isNotAdmin);
	/**
	 * @TODO 
	 * @param category
	 * @return
	 */
	int count(int category);
	/**
	 * @TODO 
	 * @param currentPageOffset
	 * @param size
	 * @param category
	 * @return
	 */
	List<Member> paging(int currentPageOffset, int size, int category);
	/**
	 * @TODO 
	 * @param id
	 * @param pictureSite
	 */
	void update(int id, String pictureSite);
}
