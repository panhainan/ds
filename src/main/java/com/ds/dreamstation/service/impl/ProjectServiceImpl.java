package com.ds.dreamstation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.dreamstation.dao.IProjectDao;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.dto.ProjectInfo;
import com.ds.dreamstation.po.Project;
import com.ds.dreamstation.service.IProjectService;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO
 */
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	@Resource
	private IProjectDao projectDao;

	public int add(Project project) {
		int id = projectDao.insert(project);
		return id;
	}

	public ProjectInfo find(int id) {
		Project project = projectDao.select(id);
		ProjectInfo projectInfo = new ProjectInfo(project.getpId(),
				project.getpName(), project.getpSummary(),
				project.getpDetails(), project.getpWebSite(),
				project.getpPicture(), project.getpAuthor(),
				project.getpGroupMember(), project.getpStatus(),
				project.getpPublishTime());
		return projectInfo;
	}

	@Override
	public Project edit(Project project) {
		int id = projectDao.update(project);
		return projectDao.select(id);
	}

	@Override
	public Project auditing(int id, byte status) {
		int result = projectDao.update(id, status);
		if (result == 0) {
			System.out.println("更新失败");
		} else {
			System.out.println("更新成功");
		}
		return projectDao.select(id);
	}

	@Override
	public void remove(int id) {
		int result = projectDao.delete(id);
		if (result == 0) {
			System.out.println("删除失败");
		} else {
			System.out.println("删除成功");
		}
	}

	@Override
	public Map<String, Object> paging(int current, int size, byte status) {
		int allRecords = this.projectDao.count(status);
		Pages pageBean = new Pages(size, allRecords, current);

		List<Project> listProject = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listProject = this.projectDao.paging(currentPageOffset, size,
					status);
			List<ProjectInfo> listProjectInfo = new ArrayList<ProjectInfo>();
			for (Project project : listProject) {
				listProjectInfo.add(new ProjectInfo(project.getpId(), project
						.getpName(), project.getpSummary(), project
						.getpDetails(), project.getpWebSite(), project
						.getpPicture(), project.getpAuthor(), project
						.getpGroupMember(), project.getpStatus(), project
						.getpPublishTime()));
			}
			pagedMap.put("listProjectInfo", listProjectInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		} else {
			System.out.println("当前页不符合标准！");
			return null;
		}
	}
}
