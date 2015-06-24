package com.ds.dreamstation.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.po.News;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-hibernate.xml" })
public class TestNewsService {

	@Resource
	private INewsService newsService;

	// @Test
	public void testAdd() {
		int r = (int) Math.random() * 10;
		System.out.println("r:" + r);
		News news = new News();
		news.setnAuthor(r + "潘海南");
		news.setnContent(r + "内容");
		news.setnPublishTime(new Date());
		news.setnStatus((byte) 0);
		news.setnTitle(r + "标题");
		System.out.println("test add\n" + newsService.add(news));
	}

	// @Test
	public void testFind() {
		System.out.println("test find\n" + newsService.find(1));
	}

	// @Test
	public void testEdit() {
		NewsInfo newsInfo = newsService.find(3);
		if (newsInfo == null) {
			System.out.println("此id的news不存在");
		} else {
			int r = (int) Math.random() * 10;
			System.out.println("r:" + r);
			// 这里还要写上其他的信息
			News news = new News();
			news.setnId(newsInfo.getId());
			news.setnAuthor("潘海南" + r);
			newsService.edit(news);
		}
	}

	// @Test
	public void testAuditing() {
		newsService.auditing(3, (byte) 2);
	}

	// @Test
	public void testRemove() {
		newsService.remove(3);
	}

	// @Test
	public void testPaging() {
		Map<String, Object> map = newsService.paging(1, 6, (byte) 1);
		System.out.println(map);
	}
}
