package com.ds.dreamstation.service;


import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.dto.ProjectInfo;
import com.ds.dreamstation.po.Project;

/**
 * @author phn
 * @date 2015-5-15
 * @email 1016593477@qq.com
 * @TODO 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:conf/spring.xml","classpath:conf/spring-hibernate.xml"})
public class TestProjectService {
	
	@Resource
	private IProjectService projectService;
//	@Test
	public void testAdd() {
		int r = (int) Math.random() * 10;
		System.out.println("r:" + r);
		Project project = new Project();
		project.setpAuthor(r+"潘海南");
		project.setpDetails(r+"详细情况");
		project.setpPublishTime(new Date());
		project.setpStatus((byte)0);
		project.setpGroupMember("无");
		project.setpPicture("http://7xionv.com1.z0.glb.clouddn.com/phn/dsjava/index.jpg");
		project.setpName(r+"名称");
		project.setpWebSite("panhainan.com");
		System.out.println("test add\n"+projectService.add(project));
	}
//	@Test
	public void testFind() {
		System.out.println("test find\n"+projectService.find(1));
	}
//	@Test
	public void testEdit() {
		ProjectInfo projectInfo = projectService.find(1);
		if(projectInfo==null){
			System.out.println("此id的project不存在");
		}else{
			int r = (int) Math.random() * 10;
			System.out.println("r:" + r);
			Project project = new Project();
			project.setpName(projectInfo.getName());
			project.setpGroupMember(projectInfo.getGroupMember());
			project.setpPicture(projectInfo.getPicture());
			project.setpWebSite(projectInfo.getWebsite());
			project.setpDetails(projectInfo.getDetails());
			project.setpPublishTime(new Date());
			project.setpStatus((byte)0);
			project.setpAuthor("潘海南" + r);
			Project resultProject = projectService.edit(project);
			System.out.println(resultProject);
		}
	}
//	@Test
	public void testAuditing(){
		System.out.println( projectService.auditing(1,  (byte) 2));
	}
//	@Test
	public void  testRemove() {
		projectService.remove(2);
	}
//	@Test
	public void testPaging(){
		Map<String, Object> map = projectService.paging(1, 6, (byte)3);
		System.out.println(map);
	}
}
