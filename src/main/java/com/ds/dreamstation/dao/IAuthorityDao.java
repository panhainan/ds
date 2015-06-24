package com.ds.dreamstation.dao;

import com.ds.dreamstation.po.Authority;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IAuthorityDao {
	/**
	 * @TODO 成员注册之后会生成对应的一个权限记录 
	 * @param authority
	 * @return authorityID
	 */
	int insert(Authority authority);
	/**
	 * @TODO 更新成员的权限信息 
	 * @param authority
	 * @return 暂定：authorityID
	 */
	int update(Authority authority);
	/**
	 * @TODO 查看成员的权限情况
	 * @param id
	 * @return 权限情况authority
	 */
	Authority select(int id);
	/**
	 * @TODO 删除成员后一并删除对应的权限信息 
	 * @param id
	 * @return 受影响的行数
	 */
	int delete(int id);
	
}
