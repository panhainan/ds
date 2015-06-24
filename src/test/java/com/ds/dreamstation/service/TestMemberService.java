package com.ds.dreamstation.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.ds.dreamstation.po.Member;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO
 */
public class TestMemberService{
	@Resource
	private IMemberService memberService;

	// @Test
	public void testRegister() {
		Member member = new Member();
		member.setmLoginEmail("panhainan@yeah.net");
		member.setmLoginPass("123456");
		assertTrue(memberService.register(member));
	}

	@Test
	public void testPaging() {
		memberService.paging(1, 10, false);
	}

	// @Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	// @Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	// @Test
	public void testEditPicture() {
		fail("Not yet implemented");
	}

	// @Test
	public void testEditPass() {
		fail("Not yet implemented");
	}

	// @Test
	public void testLosePass() {
		fail("Not yet implemented");
	}

}
