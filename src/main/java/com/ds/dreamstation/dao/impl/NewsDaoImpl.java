/**
 * 
 */
package com.ds.dreamstation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.INewsDao;
import com.ds.dreamstation.po.News;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
@Repository("newsDao")
public class NewsDaoImpl extends DaoSupport implements INewsDao {

	@Override
	public int insert(News news) {
		Session session = this.getSession();
		session.save(news);
		return news.getnId();
	}

	@Override
	public News select(int id) {
		Session session = this.getSession();
		News news = (News) session.get(News.class, id);
		return news;
	}

	@Override
	public int update(News news) {
		Session session = this.getSession();
		session.update(news);
		return news.getnId();
	}

	@Override
	public int update(int id, byte status) {
		String hql = "update News n set n.nStatus = ? where n.nId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setByte(0, status);
		q.setInteger(1, id);
		int result = q.executeUpdate();
		return result;
	}

	@Override
	public int delete(int id) {
		String hql = "delete News n where n.nId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		int result = q.executeUpdate();
		return result;
	}

	@Override
	public int count(byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from News n ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where n.nStatus = ?");
		}
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		if (flag) {
			q.setByte(0, status);
		}
		long count = (Long) q.list().get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> paging(int currentPageOffset, int size, byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from News n ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where n.nStatus = ?");
		}
		hqlBuffer.append("order by n.nId desc");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		q.setMaxResults(size);
		q.setFirstResult(currentPageOffset);
		if (flag) {
			q.setByte(0, status);
		}
		return (List<News>)q.list();
	}
	@Override
	public List<News> listLast(int size) {
		Session session = this.getSession();
		List<News> listNews = new ArrayList<News>();
		listNews = (ArrayList<News>)session.createQuery("from News n where n.nStatus=1 order by n.nId desc").setMaxResults(size).list();
		return listNews;
	}

}
