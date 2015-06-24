package com.ds.dreamstation.service;

import java.util.List;
import java.util.Map;

import com.ds.dreamstation.dto.StudiesInfo;
import com.ds.dreamstation.po.Studies;

/**
 * @author phn
 * @date 2015-6-14
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IStudiesService {
	long add(Studies studies);

	void remove(long id);

	Studies find(long id);

	/**
	 * @TODO 
	 * @param memberId
	 */
	List<StudiesInfo> list(int memberId);

	/**
	 * @TODO 
	 * @param current
	 * @param size
	 * @return
	 */
	Map<String, Object> paging(int current, int size);
}
