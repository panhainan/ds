package com.ds.dreamstation.dao;

import java.util.List;

import com.ds.dreamstation.po.Project;

/**
 * @author phn
 * @date 2015-5-19
 * @email 1016593477@qq.com
 * @TODO 
 */

public interface IProjectDao {
	/**
	 * @TODO 添加project并返回刚刚添加的project的id
	 * @param project
	 * @return projectID
	 */
	int insert(Project project);

	/**
	 * @TODO 通过id查找project
	 * @param id
	 * @return Project
	 */
	Project select(int id);

	/**
	 * @TODO 更新project
	 * @param project
	 * @return 暂时定为：projectID
	 */
	int update(Project project);

	/**
	 * @TODO 通过projectID来修改projectStatus，即他的状态，这个用于审核
	 * @param id
	 * @param status
	 * @return 受影响的行数，成功为1
	 */
	int update(int id, byte status);

	/**
	 * @TODO 通过projectID删除Project
	 * @param id
	 * @return 受影响的行数，成功为1
	 */
	int delete(int id);

	/**
	 * @TODO 根据project的status计算所有符合status条件的记录总数，注意这里设置一个status数字用来获取所有的记录数
	 * @param status
	 * @return 记录总数
	 */
	int count(byte status);

	/**
	 * @TODO 根据project的status获取所有符合status、currentPageOffset、size条件的记录，注意这里设置一个status数字用来获取所有的记录
	 * @param currentPageOffset
	 * @param size
	 * @param status 
	 * @return 符合条件的记录
	 */
	List<Project> paging(int currentPageOffset, int size, byte status);
}
