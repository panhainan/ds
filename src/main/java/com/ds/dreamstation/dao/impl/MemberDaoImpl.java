package com.ds.dreamstation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IMemberDao;
import com.ds.dreamstation.po.Member;

/**
 * @author phn
 * @date 2015-5-16
 * @email 1016593477@qq.com
 * @TODO
 */
@Repository("memberDao")
public class MemberDaoImpl extends DaoSupport implements IMemberDao {

	@Override
	public int insert(Member member) {
		Session session = this.getSession();
		session.save(member);
		return member.getmId();
	}

	@Override
	public Member select(int id) {
		Session session = this.getSession();
		Member member = (Member) session.get(Member.class, id);
		return member;
	}

	@Override
	public Member select(String loginEmail) {
		String hql = "from Member m where m.mLoginEmail = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setString(0, loginEmail);
		if (q.list().size() > 0) {
			return (Member) q.list().get(0);
		}
		return null;
	}

	@Override
	public int update(Member member) {
		Session session = this.getSession();
		session.update(member);
		return member.getmId();
	}

	@Override
	public void delete(int id) {
		Member member = new Member();
		member.setmId(id);
		Session session = this.getSession();
		session.delete(member);
	}

	public int count(boolean isNotSuperAdmin) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from Member m where m.mUserAuthority.aManageAdmin = ?");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setBoolean(0,  isNotSuperAdmin);
		long count = (Long) q.list().get(0);
		return (int) count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> paging(int currentPageOffset, int size,
			boolean isNotSuperAdmin) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from Member m where m.mUserAuthority.aManageAdmin = ?");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setBoolean(0,  isNotSuperAdmin);
		q.setMaxResults(size);
		q.setFirstResult(currentPageOffset);
		return (List<Member>)q.list();
	}

	@Override
	public int count(boolean isNotSuperAdmin, boolean isNotAdmin) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from Member m where m.mUserAuthority.aManageAdmin = ?  and m.mUserAuthority.aManageMember = ?");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setBoolean(0,  isNotSuperAdmin);
		q.setBoolean(1,  isNotAdmin);
		long count = (Long) q.list().get(0);
		return (int) count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> paging(int currentPageOffset, int size,
			boolean isNotSuperAdmin, boolean isNotAdmin) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from Member m where m.mUserAuthority.aManageAdmin = ? and m.mUserAuthority.aManageMember = ?");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setBoolean(0,  isNotSuperAdmin);
		q.setBoolean(1,  isNotAdmin);
		q.setMaxResults(size);
		q.setFirstResult(currentPageOffset);
		return (List<Member>)q.list();
	}


	@Override
	public int count(int category) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from Member m where m.mCategory = ? and m.mUserAuthority.aAllowLogin = 1");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setInteger(0,  category);
		long count = (Long) q.list().get(0);
		return (int) count;
	}

	@Override
	public List<Member> paging(int currentPageOffset, int size, int category) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from Member m where m.mCategory = ? and m.mUserAuthority.aAllowLogin = 1");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setInteger(0,  category);
		q.setMaxResults(size);
		q.setFirstResult(currentPageOffset);
		return (List<Member>)q.list();
	}

	@Override
	public void update(int id, String pictureSite) {
		Session session = this.getSession();
		Query q = session.createQuery("update from Member m set m.mPicture= :memPicSite where m.mId= :memId");
		q.setParameter("memPicSite", pictureSite);
		q.setParameter("memId", id);
		q.executeUpdate();
	}

}
