package com.ds.dreamstation.service;


import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.po.Message;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:conf/spring.xml","classpath:conf/spring-hibernate.xml"})
public class TestMessageService {
	
	@Resource
	private IMessageService messageService;
//	@Test
	public void testAdd() {
		int r = (int) Math.random() * 10;
		System.out.println("r:" + r);
		Message message = new Message();
		message.setmCommentName(r+"路人甲");
		message.setmCommentContent(r+"内容");
		message.setmCommentTime(new Date());
		message.setmCommentEmail("phn@163.com");
		message.setmStatus((byte)0);
		System.out.println("test add\n"+messageService.add(message));
	}
//	@Test
	public void testFind() {
		System.out.println("test find\n"+messageService.find(1));
	}
//	@Test
	public void testReply() {
		Message message = messageService.find(1);
		if(message==null){
			System.out.println("此id的message不存在");
		}else{
			message.setmReplyName("潘海南");
			message.setmReplyTime(new Date());
			message.setmReplyContent("不错哦");
			boolean result = messageService.reply(message);
			System.out.println(result);
		}
	}
//	@Test
	public void  testRemove() {
		messageService.remove(2);
	}
//	@Test
	public void testPaging(){
		Map<String, Object> map = messageService.paging(1, 6, (byte)0);
		System.out.println(map);
	}
}
