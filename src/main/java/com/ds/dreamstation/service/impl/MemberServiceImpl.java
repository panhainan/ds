package com.ds.dreamstation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.dreamstation.dao.IAuthorityDao;
import com.ds.dreamstation.dao.IMemberDao;
import com.ds.dreamstation.dto.MemberInfo;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.Authority;
import com.ds.dreamstation.po.Member;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.service.IMemberService;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO
 */
@Transactional
@Service("memberService")
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDao memberDao;

	@Resource
	private IAuthorityDao authorityDao;

	@Override
	public boolean register(Member member) {
		if (memberDao.select(member.getmLoginEmail()) == null) {
			Authority authority = new Authority();
			authorityDao.insert(authority);
			member.setmUserAuthority(authority);
			memberDao.insert(member);
			return true;
		} else {
			System.out.println("用户已存在");
			return false;
		}
	}

	@Override
	public Member login(String loginEmail, String loginPass) {
		Member member = this.memberDao.select(loginEmail);
		if (member != null) {
			if (loginPass.equals(member.getmLoginPass())) {
				if (member.getmUserAuthority().isaAllowLogin()) {
					return member;
				} else {
					System.out.println("没权限");
					return null;
				}
			}
			else {
				System.out.println("用户名或者密码错误");
				return null;
			}
		} else {
			System.out.println("用户名或者密码错误");
			return null;
		}
	}

	@Override
	public void edit(Member member) {
		this.authorityDao.update(member.getmUserAuthority());
		this.memberDao.update(member);
	}

	@Override
	public void editPicture(int id, String pictureSite) {
		this.memberDao.update(id, pictureSite);
	}

	@Override
	public String editPass(int id, String oldPass, String newPass) {
		Member member = this.memberDao.select(id);
		if (oldPass.equals(member.getmLoginPass())) {
			member.setmLoginPass(newPass);
			this.memberDao.update(member);
			return "修改成功！请注销使用新密码登录！";
		} else {
			return "原密码输入错误！请重新输入！";
		}
	}

	@Override
	public boolean losePass(int loginEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(String email) {
		return this.memberDao.select(email);
	}

	@Override
	public Member find(int memberId) {
		return this.memberDao.select(memberId);
	}

	@Override
	public Map<String, Object> paging(int current, int size,
			boolean isNotSuperAdmin) {
		int allRecords = this.memberDao.count(isNotSuperAdmin);
		Pages pageBean = new Pages(size, allRecords, current);

		List<Member> listMember = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listMember = this.memberDao.paging(currentPageOffset, size,
					isNotSuperAdmin);
			List<MemberInfo> listMemberInfo = new ArrayList<MemberInfo>();
			for (Member member : listMember) {
				listMemberInfo.add(new MemberInfo(member));
			}
			pagedMap.put("listMemberInfo", listMemberInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		} else {
			System.out.println("当前页不符合标准！");
			return null;
		}
	}

	@Override
	public Map<String, Object> paging(int current, int size,
			boolean isNotAdmin, boolean isNotSuperAdmin) {
		int allRecords = this.memberDao.count(isNotSuperAdmin, isNotAdmin);
		Pages pageBean = new Pages(size, allRecords, current);

		List<Member> listMember = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listMember = this.memberDao.paging(currentPageOffset, size,
					isNotSuperAdmin, isNotAdmin);
			List<MemberInfo> listMemberInfo = new ArrayList<MemberInfo>();
			for (Member member : listMember) {
				listMemberInfo.add(new MemberInfo(member));
			}
			pagedMap.put("listMemberInfo", listMemberInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		} else {
			System.out.println("当前页不符合标准！");
			return null;
		}
	}


	@Override
	public Map<String, Object> paging(int current, int size, int category) {
		int allRecords = this.memberDao.count(category);
		Pages pageBean = new Pages(size, allRecords, current);
		List<Member> listMember = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listMember = this.memberDao.paging(currentPageOffset, size,
					category);
			List<MemberInfo> listMemberInfo = new ArrayList<MemberInfo>();
			for (Member member : listMember) {
				listMemberInfo.add(new MemberInfo(member));
			}
			pagedMap.put("listMemberInfo", listMemberInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		} else {
			System.out.println("当前页不符合标准！");
			return null;
		}
	}

	@Override
	public void remove(int id, int authorityId) {
		this.memberDao.delete(id);
//		this.authorityDao.delete(authorityId);
	}

}
