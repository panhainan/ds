package com.ds.dreamstation.service;


import java.util.Map;

import com.ds.dreamstation.dto.ProjectInfo;
import com.ds.dreamstation.po.Project;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO 
 */

public interface IProjectService {
	/**
	 * @TODO 添加project
	 * @param project
	 * @return id
	 */
	int add(Project project);

	/**
	 * @TODO 通过id查找project
	 * @param id
	 * @return projectInfo
	 */
	ProjectInfo find(int id);
	
	/**
	 * @TODO 编辑project
	 * @param project
	 * @return project
	 */
	Project edit(Project project);

	/**
	 * @TODO 审核：通过projectID来修改projectStatus
	 * @param id
	 * @param status
	 * @return project
	 */
	Project auditing(int id, byte status);

	/**
	 * @TODO 通过projectID删除project
	 * @param id
	 */
	void remove(int id);

	/**
	 * @TODO 分页查询project数据
	 * @param current当前页
	 * @param size每页记录数
	 * @param status查询的project的条件
	 * @return Map
	 */
	Map<String , Object> paging(int current,int size,byte status);
}
