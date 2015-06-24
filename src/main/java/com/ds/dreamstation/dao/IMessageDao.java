package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.Message;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IMessageDao {
	/**
	 * @TODO 添加message并返回刚刚添加的message的id
	 * @param message
	 * @return messageID
	 */
	long insert(Message message);

	/**
	 * @TODO 通过id查找Message
	 * @param id
	 * @return Message
	 */
	Message select(long id);

	/**
	 * @TODO 更新message
	 * @param message
	 * @return 暂时定为：messageID
	 */
	long update(Message message);

	/**
	 * @TODO 通过messageID删除Message
	 * @param id
	 * @return 受影响的行数，成功为1
	 */
	int delete(long id);

	/**
	 * @TODO 根据message的status计算所有符合status条件的记录总数，注意这里设置一个status数字用来获取所有的记录数
	 * @param status
	 * @return 记录总数
	 */
	int count(byte status);

	/**
	 * @TODO 根据message的status获取所有符合status、currentPageOffset、size条件的记录，注意这里设置一个status数字用来获取所有的记录
	 * @param currentPageOffset
	 * @param size
	 * @param status 
	 * @return 符合条件的记录
	 */
	List<Message> paging(int currentPageOffset, int size, byte status);

}
