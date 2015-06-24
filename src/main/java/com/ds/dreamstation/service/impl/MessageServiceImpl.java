package com.ds.dreamstation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.dreamstation.dao.IMessageDao;
import com.ds.dreamstation.dto.MessageInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.Message;
import com.ds.dreamstation.service.IMessageService;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
@Transactional
@Service("messageService")
public class MessageServiceImpl implements IMessageService {

	@Resource
	private IMessageDao messageDao;

	public boolean add(Message message) {
		long id = messageDao.insert(message);
		if(id>0){
			System.out.println("cheng gong");
			return true;
		}
		else {
			System.out.println("shi bai");
			return false;
		}
	}

	public Message find(long id) {
		return messageDao.select(id);
	}

	@Override
	public boolean reply(Message message) {
		long id = messageDao.update(message);
		if(id>0){
			return true;
		}else{
			return false;
		}
		
	}


	@Override
	public void remove(long id) {
		int result = this.messageDao.delete(id);
		System.out.println("result:"+result);
		if(result == 0){
			System.out.println("删除失败");
		}else{
			System.out.println("删除成功");
		}
	}

	@Override
	public Map<String, Object> paging(int current, int size,byte status) {
		int allRecords = this.messageDao.count(status);
		Pages pageBean = new Pages( size,allRecords, current);
		
		List<Message> listMessage = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listMessage = this.messageDao
					.paging(currentPageOffset,size,status);
			List<MessageInfo> listMessageInfo = new ArrayList<MessageInfo>();
			for(Message message:listMessage){
				listMessageInfo.add(new MessageInfo(message));
			}
			pagedMap.put("listMessageInfo", listMessageInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		}else{
			System.out.println("当前页不符合标准！");
			return null;
		}
	}
}
