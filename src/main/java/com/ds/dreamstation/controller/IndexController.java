package com.ds.dreamstation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ds.dreamstation.dto.IndexInfo;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.po.IndexPic;
import com.ds.dreamstation.service.IIndexService;
import com.ds.dreamstation.util.FileUpload;
import com.ds.dreamstation.util.ImgFileType;

/**
 * @author phn
 * @date 2015-6-1
 * @email 1016593477@qq.com
 * @TODO
 */
@Controller("indexController")
@RequestMapping("index")
public class IndexController {
	@Resource
	private IIndexService indexService;

	@RequestMapping(value = "")
	public String index(HttpServletRequest req) {
		List<IndexInfo> listIndexInfo = null;
		listIndexInfo = this.indexService.list();
		List<NewsInfo> ListNewsInfo = this.indexService.listLastNews(8);
		req.setAttribute("listIndexInfo", listIndexInfo);
		req.setAttribute("newsInfos", ListNewsInfo);
		return "show/index";
	}

	@RequestMapping(value = "/manage/go-add")
	public String goAdd() {
	  
		return "manage/indexAdd";
	}

	@RequestMapping(value = "/manage/add", method = RequestMethod.POST)
	public String addLocal(IndexInfo indexInfo,HttpServletRequest request,@RequestParam("fileUpload") MultipartFile fileUpload){
		//调用工具类FileUpload的静态方法来进行图书上传
		StringBuffer picSite = FileUpload.upload(request, fileUpload,"index",false);
		if(null==picSite){
			return "manage/indexAddOrUpdateError";
		}
		IndexPic indexPic = new IndexPic(picSite.toString(), indexInfo.getName(), indexInfo.getIntroduction(), indexInfo.getPriority());
		int id = this.indexService.add(indexPic);
		return "redirect:/index/manage/look?id="+id;
	}

	
	
	@RequestMapping(value = "/manage/list")
	public String list(HttpServletRequest req) {
		 List<IndexInfo> listIndexInfo = this.indexService.list();
		 req.setAttribute("listIndexInfo",listIndexInfo);
		return "/manage/indexList";
	}
	@RequestMapping(value="/manage/look")
	public String mLook(int id,HttpServletRequest req){
		IndexPic indexPic = this.indexService.find(id);
		IndexInfo indexInfo = new IndexInfo(indexPic);
		req.setAttribute("indexInfo", indexInfo);
		return "manage/indexLook";
	}
	
	@RequestMapping(value="/manage/go-edit")
	public String edit(int id,HttpServletRequest req){
		IndexPic indexPic = this.indexService.find(id);
		IndexInfo indexInfo = new IndexInfo(indexPic);
		req.setAttribute("indexInfo", indexInfo);
		return "manage/indexEdit";
	}
	@RequestMapping(value="/manage/edit")
	public String editLocal(IndexInfo indexInfo,HttpServletRequest req,@RequestParam("fileUpload") MultipartFile fileUpload){
		//调用工具类FileUpload的静态方法来进行图书上传
		StringBuffer picSite = FileUpload.upload(req, fileUpload,"index",true);
		if(null==picSite){
			return "manage/indexAddOrUpdateError";
		}
		if("keepOld".equals(picSite.toString())){
			picSite.setLength(0);
			picSite.append(indexInfo.getWebSite());
		}
		IndexPic indexPic = new IndexPic(picSite.toString(), indexInfo.getName(), indexInfo.getIntroduction(), indexInfo.getPriority());
		indexPic.setiPId(indexInfo.getId());
		this.indexService.edit(indexPic);
		return "redirect:/index/manage/look?id="+indexInfo.getId();
	}
	@RequestMapping(value="/manage/remove")
	public String remove(int id){
		this.indexService.remove(id);
		return "redirect:/index/manage/list";
	}
}
