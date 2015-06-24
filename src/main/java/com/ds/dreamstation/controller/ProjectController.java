package com.ds.dreamstation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.dto.ProjectInfo;
import com.ds.dreamstation.po.Project;
import com.ds.dreamstation.service.IProjectService;
import com.ds.dreamstation.util.FileUpload;

/**
 * @author phn
 * @date 2015-5-24
 * @email 1016593477@qq.com
 * @TODO
 */
@RequestMapping(value = "project/")
@Controller
public class ProjectController {
	@Resource
	private IProjectService projectService;

	@RequestMapping(value = "manage/go-add")
	public String goAdd() {
		return "manage/projectAdd";
	}

	@RequestMapping(value = "manage/add", method = RequestMethod.POST)
	public String add(ProjectInfo projectInfo, HttpServletRequest request,
			@RequestParam("fileUpload") MultipartFile fileUpload) {
		System.out.println(projectInfo);
		Project project = new Project();
		project.setpName(projectInfo.getName());
		project.setpGroupMember(projectInfo.getGroupMember());
		project.setpWebSite(projectInfo.getWebsite());
		project.setpSummary(projectInfo.getSummary());
		project.setpDetails(projectInfo.getDetails());
		project.setpPublishTime(new Date());
		project.setpStatus((byte) 0);
		project.setpAuthor(projectInfo.getAuthor());
		// 调用工具类FileUpload的静态方法来进行图书上传
		StringBuffer picSite = FileUpload.upload(request, fileUpload,
				"project", false);
		project.setpPicture(picSite.toString());
		int id = this.projectService.add(project);
		return "redirect:/project/manage/look?id=" + id;
	}

	@RequestMapping(value = "manage/look")
	public String mLook(int id, HttpServletRequest req) {
		ProjectInfo projectInfo = this.projectService.find(id);
		req.setAttribute("projectInfo", projectInfo);
		return "manage/projectLook";
	}

	@RequestMapping(value = "look")
	public String sLook(int id, HttpServletRequest req) {
		ProjectInfo projectInfo = this.projectService.find(id);
		req.setAttribute("projectInfo", projectInfo);
		return "show/project";
	}

	@RequestMapping(value = "manage/list")
	public String list(
			@RequestParam(required = false, defaultValue = "1") int current,
			@RequestParam(required = false, defaultValue = "3") byte status,
			HttpServletRequest req) {
		Map<String, Object> map = this.projectService.paging(current, 10,
				status);
		req.setAttribute("listProjectInfo",
				(ArrayList<ProjectInfo>) map.get("listProjectInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		req.setAttribute("status", status);
		return "manage/projectList";
	}

	@RequestMapping(value = "list")
	public String list(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		Map<String, Object> map = this.projectService.paging(current, 10,
				(byte) 1);
		req.setAttribute("listProjectInfo",
				(ArrayList<ProjectInfo>) map.get("listProjectInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "show/projectList";
	}

	@RequestMapping(value = "manage/go-edit")
	public String goEdit(int id, HttpServletRequest req) {
		ProjectInfo projectInfo = this.projectService.find(id);
		req.setAttribute("projectInfo", projectInfo);
		return "manage/projectEdit";
	}

	@RequestMapping(value = "manage/edit", method = RequestMethod.POST)
	public String edit(ProjectInfo projectInfo, HttpServletRequest request,
			@RequestParam("fileUpload") MultipartFile fileUpload) {
		Project project = new Project();
		project.setpId(projectInfo.getId());
		project.setpAuthor(projectInfo.getAuthor());
		project.setpName(projectInfo.getName());
		project.setpGroupMember(projectInfo.getGroupMember());
		project.setpWebSite(projectInfo.getWebsite());
		project.setpSummary(projectInfo.getSummary());
		project.setpDetails(projectInfo.getDetails());
		project.setpPublishTime(new Date());
		// 调用工具类FileUpload的静态方法来进行图书上传
		StringBuffer picSite = FileUpload.upload(request, fileUpload,
				"project", true);
		if (null == picSite) {
			return "manage/projectAddOrUpdateError";
		}
		if ("keepOld".equals(picSite.toString())) {
			System.out.println(picSite);
			picSite.setLength(0);
			System.out.println(picSite);
			picSite.append(projectInfo.getPicture());
		}
		project.setpPicture(picSite.toString());
		// 修改之后审核状态设为待审核
		project.setpStatus((byte) 0);
		this.projectService.edit(project);
		return "redirect:/project/manage/look?id=" + projectInfo.getId();
	}

	@RequestMapping(value = "manage/remove")
	public String remove(int id) {
		this.projectService.remove(id);
		return "redirect:/project/manage/list";
	}

	@RequestMapping(value = "manage/removes")
	public String removes(int[] ids) {
		// System.out.println(ids);
		for (int id : ids) {
			this.projectService.remove(id);
		}
		return "redirect:/manage/project/list";
	}

	@RequestMapping(value = "manage/auditing")
	public String auditing(int id, byte status) {
		this.projectService.auditing(id, status);
		return "redirect:/project/manage/list";
	}
}
