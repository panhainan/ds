package com.ds.dreamstation.service;


import java.util.Map;

import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.po.News;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO 
 */

public interface INewsService {
	/**
	 * @TODO 添加news
	 * @param news
	 * @return id
	 */
	int add(News news);

	/**
	 * @TODO 通过id查找news
	 * @param id
	 * @return NewsInfo
	 */
	NewsInfo find(int id);
	
	/**
	 * @TODO 编辑news
	 * @param news
	 * @return void
	 */
	void edit(News news);

	/**
	 * @TODO 审核：通过newsID来修改newsStatus
	 * @param id
	 * @param status
	 * @return void
	 */
	void auditing(int id, byte status);

	/**
	 * @TODO 通过newsID删除News
	 * @param id
	 */
	void remove(int id);

	/**
	 * @TODO 分页查询news数据
	 * @param current当前页
	 * @param size每页记录数
	 * @param status查询的news的条件
	 * @return Map
	 */
	Map<String , Object> paging(int current,int size,byte status);
}
