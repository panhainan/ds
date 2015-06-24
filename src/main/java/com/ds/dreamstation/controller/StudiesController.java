package com.ds.dreamstation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.ds.dreamstation.dto.StudiesInfo;
import com.ds.dreamstation.po.Studies;
import com.ds.dreamstation.service.IMemberService;
import com.ds.dreamstation.service.IStudiesService;

/**
 * @author phn
 * @date 2015-6-14
 * @email 1016593477@qq.com
 * @TODO
 */
@Controller("studiesController")
@RequestMapping(value = "studies")
public class StudiesController {
	@Resource
	private IStudiesService studiesService;
	@Resource
	private IMemberService memberService;

	@RequestMapping(value = "/manage/go-add")
	public String goAdd() {
		return "manage/studiesAdd";
	}

	@RequestMapping(value = "/manage/add", method = RequestMethod.POST)
	public String add(StudiesInfo studiesInfo, HttpServletRequest req) {
		Studies studies = new Studies();
		studies.setsPeriodTheme(studiesInfo.getPeriodTheme());
		studies.setsPeriodTime(studiesInfo.getPeriodTime());
		studies.setsPeriodContent(studiesInfo.getPeriodContent());
		studies.setsPublishTime(new Date());
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		studies.setsMember(this.memberService.find(memberSession.getId()));
		long id = this.studiesService.add(studies);
		return "redirect:/studies/manage/look?id=" + id;
	}

	@RequestMapping(value = "/manage/look")
	public String look(long id, HttpServletRequest req) {
		Studies studies = this.studiesService.find(id);
		StudiesInfo studiesInfo = new StudiesInfo(studies);
		req.setAttribute("studiesInfo", studiesInfo);
		return "manage/studiesLook";
	}

	@RequestMapping(value = "/manage/remove")
	public String remove(long id, HttpServletRequest req) {
		this.studiesService.remove(id);
		return "redirect:/studies/manage/list";
	}

	@RequestMapping(value = "/manage/list-self")
	public String listSelf(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		List<StudiesInfo> listStudiesInfo = this.studiesService
				.list(memberSession.getId());
		req.setAttribute("listStudiesInfo", listStudiesInfo);
		return "manage/studiesListSelf";
	}
	@RequestMapping(value = "/manage/list-member")
	public String listMember(int id,HttpServletRequest req) {
		List<StudiesInfo> listStudiesInfo = this.studiesService
				.list(id);
		req.setAttribute("listStudiesInfo", listStudiesInfo);
		req.setAttribute("id", id);
		return "manage/studiesListMember";
	}
	@RequestMapping(value = "/manage/list")
	public String list(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		Map<String, Object> map = this.studiesService.paging(current, 12);
		req.setAttribute("listStudiesInfo",
				(ArrayList<NewsInfo>) map.get("listStudiesInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "manage/studiesList";
	}
}
