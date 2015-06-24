package com.ds.dreamstation.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * @author phn
 * @date 2015-5-16
 * @email 1016593477@qq.com
 * @TODO 
 */
public class DaoSupport {
	@Resource
	protected SessionFactory sessionFactory;


	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
