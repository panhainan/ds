package com.ds.dreamstation.service;


import java.util.Map;

import com.ds.dreamstation.po.Message;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO 
 */

public interface IMessageService {
	/**
	 * @TODO 添加message
	 * @param message
	 * @return message
	 */
	boolean add(Message message);

	/**
	 * @TODO 通过id查找message
	 * @param id
	 * @return message
	 */
	Message find(long id);
	
	/**
	 * @TODO 回复message
	 * @param message
	 * @return true or false
	 */
	boolean reply(Message message);


	/**
	 * @TODO 通过messageID删除Message
	 * @param id
	 */
	void remove(long id);

	/**
	 * @TODO 分页查询message数据
	 * @param current当前页
	 * @param size每页记录数
	 * @param status查询的message的条件
	 * @return Map
	 */
	Map<String , Object> paging(int current,int size,byte status);
}
