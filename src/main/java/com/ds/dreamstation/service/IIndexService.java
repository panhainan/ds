package com.ds.dreamstation.service;

import java.util.List;

import com.ds.dreamstation.dto.IndexInfo;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.po.IndexPic;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO 
 */
public interface IIndexService {
	int add(IndexPic indexPic);
	void edit(IndexPic indexPic);
	void remove(int id);
	IndexPic find(int id);
	List<IndexInfo> list();
	List<NewsInfo> listLastNews(int size);
}
