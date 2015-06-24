package com.ds.dreamstation.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ds.dreamstation.dao.IMessageDao;
import com.ds.dreamstation.po.Message;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */
@Repository("messageDao")
public class MessageDaoImpl extends DaoSupport implements IMessageDao {

	@Override
	public long insert(Message message) {
		Session session = this.getSession();
		session.save(message);
		return message.getmId();

	}

	@Override
	public Message select(long id) {
		Session session = this.getSession();
		Message message = (Message) session.get(Message.class, id);
		return message;
	}

	@Override
	public long update(Message message) {
		Session session = this.getSession();
		session.update(message);
		return message.getmId();
	}

	@Override
	public int delete(long id) {
		String hql = "delete Message m where m.mId = ?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setLong(0, id);
		int result = q.executeUpdate();
		return result;
	}
	@Override
	public int count(byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"select count(*) from Message m ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where m.mStatus = ?");
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
	public List<Message> paging(int currentPageOffset, int size, byte status) {
		StringBuffer hqlBuffer = new StringBuffer(
				"from Message m ");
		boolean flag = (status != 3);
		if (flag) {
			hqlBuffer.append("where m.mStatus = ?");
		}
		hqlBuffer.append("order by m.mId desc");
		Session session = this.getSession();
		Query q = session.createQuery(hqlBuffer.toString());
		if (flag) {
			q.setByte(0, status);
		}
		return (List<Message>)q.list();
	}

}
