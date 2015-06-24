package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.News;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO
 */
public interface INewsDao {
	/**
	 * @TODO 添加news并返回刚刚添加的news的id
	 * @param news
	 * @return newsID
	 */
	int insert(News news);

	/**
	 * @TODO 通过id查找News
	 * @param id
	 * @return News
	 */
	News select(int id);

	/**
	 * @TODO 更新news
	 * @param news
	 * @return 暂时定为：newsID
	 */
	int update(News news);

	/**
	 * @TODO 通过newsID来修改newsStatus，即他的状态，这个用于审核
	 * @param id
	 * @param status
	 * @return 受影响的行数，成功为1
	 */
	int update(int id, byte status);

	/**
	 * @TODO 通过newsID删除News
	 * @param id
	 * @return 受影响的行数，成功为1
	 */
	int delete(int id);

	/**
	 * @TODO 根据news的status计算所有符合status条件的记录总数，注意这里设置一个status数字用来获取所有的记录数
	 * @param status
	 * @return 记录总数
	 */
	int count(byte status);

	/**
	 * @TODO 根据news的status获取所有符合status、currentPageOffset、size条件的记录，
	 *       注意这里设置一个status数字用来获取所有的记录
	 * @param currentPageOffset
	 * @param size
	 * @param status
	 * @return 符合条件的记录
	 */
	List<News> paging(int currentPageOffset, int size, byte status);

	/**
	 * @TODO 获取最近size条新闻
	 * @param size
	 * @return
	 */
	List<News> listLast(int size);

}
