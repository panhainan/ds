package com.ds.dreamstation.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IStudiesDao;
import com.ds.dreamstation.po.Studies;

/**
 * @author phn
 * @date 2015-6-13
 * @email 1016593477@qq.com
 * @TODO
 */
@Repository("studiesDao")
public class StudiesDaoImpl extends DaoSupport implements IStudiesDao {
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public long insert(Studies studies) {
		Session session = this.getSession();
		session.save(studies);
		return studies.getsId();
	}

	@Override
	public void delete(long id) {
		String hql = "delete Studies s where s.sId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setLong(0, id);
		q.executeUpdate();
	}

	@Override
	public Studies select(long id) {
		Session session = this.getSession();
		Studies studies = null;
		studies = (Studies) session.get(Studies.class, id);
		return studies;
	}

	@Override
	public List<Studies> selectByMemberId(int memberId) {
		Session session = this.getSession();
		Query q = session
				.createQuery("from Studies s where s.sMember.mId=? order by s.sId desc");
		q.setParameter(0, memberId);
		List<Studies> list = null;
		list = q.list();
		return list;
	}

	@Override
	public int count() {
		Session session = this.getSession();
		Query q = session.createQuery("select count(*) from Studies s");
		long count = (Long) q.list().get(0);
		return (int) count;
	}

	@Override
	public List<Studies> paging(int currentPageOffset, int size) {
		Session session = this.getSession();
		Query q = session.createQuery("from Studies s order by s.sId desc");
		q.setMaxResults(size);
		q.setFirstResult(currentPageOffset);
		List<Studies> list = null;
		list = q.list();
		return list;
	}

}
