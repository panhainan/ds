package com.ds.dreamstation.dao;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.po.News;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-hibernate.xml" })
public class TestNewsDao extends TestCase {

	/*
	 * 注意在测试dao层的时候会有session不存在的异常存在，这时候需要修改spring-hibernate.XML中的文件中的
	 * <aop:config> 
	 * <aop:pointcut id="transactionPointcut" expression="execution(* com.ds.dreamstation.dao..*Impl.*(..))" />
	 * <aop:advisor pointcut-ref="transactionPointcut" advice-ref="transactionAdvice" /> 
	 * </aop:config>
	 * 将com.ds.dreamstation.service..*Impl.*(..)中的service改为dao
	 */

	@Resource
	private INewsDao newsDao;

	// @Test
	public void testInsert() {
		News news = new News();
		int r = (int) Math.random() * 10;
		System.out.println("r:" + r);
		news.setnAuthor(r + "潘海南");
		news.setnContent(r + "梦之站2015届成员离开学校了");
		news.setnTitle(r + "希望2015届都有一个好的未来");
		news.setnPublishTime(new Date());
		news.setnStatus((byte) 0);
		newsDao.insert(news);
	}

	// @Test
	public void testSelect() {
		System.out.println(newsDao.select(2));
	}

	// @Test
	public void testUpdateNews() {
		News news = newsDao.select(2);
		int r = (int) Math.random() * 10;
		System.out.println("r:" + r);
		news.setnAuthor("潘海南" + r);
		newsDao.update(news);
	}

	//@Test
	public void testUpdateIntByte() {
		System.out.println("受影响的行数：" + newsDao.update(2, (byte) 2));
	}
//	@Test
	public void testDelete() {
		System.out.println("受影响的行数：" + newsDao.delete(2));
	}
	

}
