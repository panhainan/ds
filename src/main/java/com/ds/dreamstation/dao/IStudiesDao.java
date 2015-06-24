package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.Studies;

/**
 * @author phn
 * @date 2015-6-12
 * @email 1016593477@qq.com
 * @TODO
 */
public interface IStudiesDao {

	long insert(Studies studies);

	void delete(long id);

	Studies select(long id);
	
	List<Studies> selectByMemberId(int memberId);

	/**
	 * @TODO 
	 * @return
	 */
	int count();

	/**
	 * @TODO 
	 * @param currentPageOffset
	 * @param size
	 * @return
	 */
	List<Studies> paging(int currentPageOffset, int size);

}
