package com.ds.dreamstation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.dreamstation.dao.IIndexDao;
import com.ds.dreamstation.dao.INewsDao;
import com.ds.dreamstation.dto.IndexInfo;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.po.IndexPic;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.service.IIndexService;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO
 */
@Transactional
@Service("indexService")
public class IndexServiceImpl implements IIndexService {

	@Resource
	private IIndexDao indexDao;
	
	@Resource
	private INewsDao newsDao;

	@Override
	public int add(IndexPic indexPic) {
		return this.indexDao.insert(indexPic);
	}

	@Override
	public void edit(IndexPic indexPic) {
		this.indexDao.update(indexPic);
	}

	@Override
	public void remove(int id) {
		this.indexDao.delete(id);
	}

	@Override
	public IndexPic find(int id) {
		return this.indexDao.select(id);
	}

	@Override
	public List<IndexInfo> list() {
		List<IndexPic> listIndexPic = this.indexDao.select();
		List<IndexInfo> listIndexInfo = new ArrayList<IndexInfo>();
		for(IndexPic indexPic:listIndexPic){
			listIndexInfo.add(new IndexInfo(indexPic));
		}
		return listIndexInfo;
	}

	@Override
	public List<NewsInfo> listLastNews(int size) {
		List<News> listNews =  this.newsDao.listLast(size);
		List<NewsInfo> newsInfos = new ArrayList<NewsInfo>();
		for(int i = 0 ;i < listNews.size();i++){
			newsInfos.add(new NewsInfo(listNews.get(i).getnId(),listNews.get(i).getnTitle(),listNews.get(i).getnPublishTime()));
		}
		return newsInfos;
	}

}
