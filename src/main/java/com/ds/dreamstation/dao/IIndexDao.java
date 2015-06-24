package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.IndexPic;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IIndexDao {
	int insert(IndexPic indexPic);
	void update(IndexPic indexPic);
	void delete(int id);
	IndexPic select(int id);
	List<IndexPic> select();
}
