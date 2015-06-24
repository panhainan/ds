package com.ds.dreamstation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ds.dreamstation.dto.MemberSession;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.service.INewsService;

/**
 * @author phn
 * @date 2015-5-21
 * @email 1016593477@qq.com
 * @TODO 
 */

@RequestMapping(value="news/")
@Controller
public class NewsController {
	@Resource
	private INewsService newsService;
	
	@RequestMapping(value="manage/go-add")
	public String goAdd(){
		return "manage/newsAdd";
	}
	@RequestMapping(value="manage/add",method=RequestMethod.POST)
	public String add(NewsInfo newsInfo,HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession)session.getAttribute("memberSession");
		News news = new News();
		news.setnTitle(newsInfo.getTitle());
		news.setnSummary(newsInfo.getSummary());
		news.setnContent(newsInfo.getContent());
		news.setnPublishTime(new Date());
		news.setnStatus((byte)0);
		news.setnAuthor(memberSession.getName());
		int id = this.newsService.add(news);
		return "redirect:/news/manage/look?id="+id;
	}
	@RequestMapping(value="manage/look")
	public String mLook(int id,HttpServletRequest req){
		NewsInfo newsInfo = this.newsService.find(id);
		req.setAttribute("newsInfo", newsInfo);
		return "manage/newsLook";
	}
	@RequestMapping(value="look")
	public String sLook(int id , HttpServletRequest req){
		NewsInfo newsInfo = this.newsService.find(id);
		req.setAttribute("newsInfo", newsInfo);
		return "show/news";
	}
	
	@RequestMapping(value="manage/list")
	public String list(@RequestParam(required=false,defaultValue="1")int current,@RequestParam(required=false,defaultValue="3")byte status,HttpServletRequest req){
		Map<String, Object> map = this.newsService.paging(current, 10, status);
//		req.setAttribute("newsListMap", map);
//		System.out.println(map);
		req.setAttribute("listNewsInfo", (ArrayList<NewsInfo>)map.get("listNewsInfo"));
		req.setAttribute("pageBean", (Pages)map.get("pageBean"));
		req.setAttribute("status",status);
		return "manage/newsList";
	}
	@RequestMapping(value="list")
	public String list(@RequestParam(required=false,defaultValue="1")int current,HttpServletRequest req){
		Map<String, Object> map = this.newsService.paging(current, 10, (byte)1);
		req.setAttribute("listNewsInfo", (ArrayList<NewsInfo>)map.get("listNewsInfo"));
		req.setAttribute("pageBean", (Pages)map.get("pageBean"));
		return "show/newsList";
	}
	
	@RequestMapping(value="manage/go-edit")
	public String goEdit(int id,HttpServletRequest req){
		NewsInfo newsInfo = this.newsService.find(id);
		req.setAttribute("newsInfo", newsInfo);
		return "manage/newsEdit";
	}
	@RequestMapping(value="manage/edit",method=RequestMethod.POST)
	public String edit(NewsInfo newsInfo){
		News news = new News();
		news.setnId(newsInfo.getId());
		news.setnAuthor(newsInfo.getAuthor());
		news.setnSummary(newsInfo.getSummary());
		news.setnContent(newsInfo.getContent());
		news.setnTitle(newsInfo.getTitle());
		news.setnPublishTime(new Date());
		//修改之后审核状态设为待审核
		news.setnStatus((byte)0);
		this.newsService.edit(news);
		return "redirect:/news/manage/look?id="+newsInfo.getId();
	}
	@RequestMapping(value="manage/remove")
	public String remove(int id){
		this.newsService.remove(id);
		return "redirect:/news/manage/list";
	}
	@RequestMapping(value="manage/removes")
	public String removes(int[] ids){
//		System.out.println(ids);
		for(int id : ids){
			this.newsService.remove(id);
		}
		return "redirect:/news/manage/list";
	}
	@RequestMapping(value="manage/auditing")
	public String auditing(int id,byte status){
		this.newsService.auditing(id, status);
		return "redirect:/news/manage/list";
	}
}
