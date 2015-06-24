package com.ds.dreamstation;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.dto.MailType;
import com.ds.dreamstation.service.IMailService;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-hibernate.xml" })
public class Tests{
	@Resource
	private IMailService mailService;
	
	public static void main(String[] args) {
		try {
			new File("d:\\test").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testMail(){
		MailType mailType = new MailType();
		mailType.setUrl("panhainan.com");
		mailType.setEmail("1016593477@qq.com");
		mailType.setUsername("潘琼");
		mailType.setType(MailType.REMOVE_MEMBER_MAIL);
		this.mailService.sendSingleMail(mailType);
	}

}
