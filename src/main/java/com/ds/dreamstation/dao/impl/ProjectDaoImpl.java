package com.ds.dreamstation.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IProjectDao;
import com.ds.dreamstation.po.Project;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
@Repository("projectDao")
public class ProjectDaoImpl extends DaoSupport implements IProjectDao {

	@Override
	public int insert(Project project) {
		Session session = this.getSession();
		session.save(project);
		return project.getpId();
	}

	@Override
	public Project select(int id) {
		Session session = this.getSession();
		Project project = (Project) session.get(Project.class, id);
		return project;
	}

	@Override
	public int update(Project project) {
		Session session = this.getSession();
		session.update(project);
		return project.getpId();
	}

	@Override
	public int update(int id, byte status) {
		String hql = "update Project p set p.pStatus = ? where p.pId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setByte(0, status);
		q.setInteger(1, id);
		int result = q.executeUpdate();
		return result;
	}

	@Override
	public int delete(int id) {
		String hql = "delete Project p where p.pId  = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		int result = q.executeUpdate();
		return result;
	}

	@Override
	public int count(byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from Project p ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where p.pStatus = ?");
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
	public List<Project> paging(int currentPageOffset, int size, byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from Project p ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where p.pStatus = ?");
		}
		hqlBuffer.append("order by p.pId desc");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		if (flag) {
			q.setByte(0, status);
		}
		return (List<Project>)q.list();
	}

}
