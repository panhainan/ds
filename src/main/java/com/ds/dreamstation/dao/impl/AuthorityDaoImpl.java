package com.ds.dreamstation.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IAuthorityDao;
import com.ds.dreamstation.po.Authority;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO
 */
@Repository("authorityDao")
public class AuthorityDaoImpl extends DaoSupport implements IAuthorityDao {

	@Override
	public int insert(Authority authority) {
		Session session = this.getSession();
		session.save(authority);
		return authority.getaId();
	}

	@Override
	public int update(Authority authority) {
		Session session = this.getSession();
		session.update(authority);
		return authority.getaId();
	}

	@Override
	public Authority select(int id) {
		Session session = this.getSession();
		Authority authority = (Authority) session.get(Authority.class, id);
		return authority;
	}

	@Override
	public int delete(int id) {
		String hql = "delete Authority a where a.aId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setLong(0, id);
		int result = q.executeUpdate();
		return result;
	}

}
