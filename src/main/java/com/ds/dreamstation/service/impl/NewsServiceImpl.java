package com.ds.dreamstation.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.dreamstation.dao.INewsDao;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.service.INewsService;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO
 */
@Transactional
@Service("newsService")
public class NewsServiceImpl implements INewsService {
	@Resource
	private INewsDao newsDao;

	public int add(News news) {
		int id = this.newsDao.insert(news);
		System.out.println("service impl add");
		return id;
	}

	public NewsInfo find(int id) {
		News news = this.newsDao.select(id);
		NewsInfo newsInfo = new NewsInfo(news.getnId(),news.getnTitle(),news.getnSummary(),news.getnContent(),news.getnPublishTime(),news.getnStatus(),news.getnAuthor());
		return newsInfo;
	}

	@Override
	public void edit(News news) {
		this.newsDao.update(news);
	}

	@Override
	public void auditing(int id, byte status) {
		int result = this.newsDao.update(id, status);
		if(result == 0){
			System.out.println("更新失败");
		}else{
			System.out.println("更新成功");
		}
	}

	@Override
	public void remove(int id) {
		int result = this.newsDao.delete(id);
		if(result == 0){
			System.out.println("删除失败");
		}else{
			System.out.println("删除成功");
		}
	}

	@Override
	public Map<String, Object> paging(int current, int size,byte status) {
		int allRecords = this.newsDao.count(status);
		Pages pageBean = new Pages( size,allRecords, current);
		
		List<News> listNews = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listNews = this.newsDao
					.paging(currentPageOffset,size,status);
			List<NewsInfo> listNewsInfo = new ArrayList<NewsInfo>(); 
			for(News news :  listNews){
				listNewsInfo.add(new NewsInfo(news.getnId(),news.getnTitle(),news.getnSummary(),news.getnContent(),news.getnPublishTime(),news.getnStatus(),news.getnAuthor()));
			}
			pagedMap.put("listNewsInfo", listNewsInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		}else{
			System.out.println("当前页不符合标准！");
			return null;
		}
	}
}
