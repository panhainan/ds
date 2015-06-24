package com.ds.dreamstation.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-hibernate.xml" })
public class TestIndexPicDao {
	@Resource
	private IIndexDao indexPicDao;
	
	/**
	 * Test method for {@link com.ds.dreamstation.dao.impl.IndexPicDaoImpl#delete(int)}.
	 */
	@Test
	public void testDelete() {
		indexPicDao.delete(1);
	}

}
