package com.ds.dreamstation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IIndexDao;
import com.ds.dreamstation.po.IndexPic;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */
@Repository("indexDao")
public class IndexDaoImpl extends DaoSupport implements IIndexDao{

	@Override
	public int insert(IndexPic indexPic) {
		Session session = this.getSession();
		session.save(indexPic);
		return indexPic.getiPId();
	}

	@Override
	public void update(IndexPic indexPic) {
		Session session = this.getSession();
		session.update(indexPic);
	}
	@Override
	public void delete(int id) {
		IndexPic indexPic = new IndexPic();
		indexPic.setiPId(id);
		Session session = this.getSession();
		session.delete(indexPic);
	}

	@Override
	public IndexPic select(int id) {
		Session session = this.getSession();
		IndexPic indexPic = (IndexPic)session.get(IndexPic.class, id);
		return indexPic;
	}

	@Override
	public List<IndexPic> select() {
		Session session = this.getSession();
		String hql  = "from IndexPic ip  order by ip.iPPriority";
		Query q = session.createQuery(hql);
		List<IndexPic> list = (ArrayList<IndexPic>)q.list();
		return list;
	}

}
