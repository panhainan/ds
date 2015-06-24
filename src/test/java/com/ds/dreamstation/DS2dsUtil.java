package com.ds.dreamstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dreamstation.po.Message;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.po.Project;
import com.ds.dreamstation.service.IMessageService;
import com.ds.dreamstation.service.INewsService;
import com.ds.dreamstation.service.IProjectService;
import com.ds.dreamstation.util.DS2dsDBUtil;

/**
 * @author phn
 * @date 2015-6-22
 * @email 1016593477@qq.com
 * @TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-hibernate.xml" })
public class DS2dsUtil {
	@Resource
	private INewsService newsService;
	@Resource
	private IProjectService projectService;
	@Resource
	private IMessageService messageService;
	
//	@Test
	public void testImportNews() {
		String sql = "select title,content,date,author from news";
		Connection conn = DS2dsDBUtil.getConnection();
		PreparedStatement prst;
		ResultSet rs;
		try {
			prst = conn.prepareStatement(sql);
			rs = prst.executeQuery();
			List<News> listNews = new ArrayList<News>();
			while (rs.next()) {
				News news = new News();
				news.setnTitle(rs.getString("title"));
				news.setnAuthor(rs.getString("author"));
				news.setnContent(rs.getString("content"));
				news.setnPublishTime(rs.getTimestamp("date"));
				news.setnStatus((byte)1);
				news.setnSummary(rs.getString("content").substring(0, 220));
				listNews.add(news);
			}
			System.out.println(listNews);
			for (News news : listNews) {
				this.newsService.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

//	@Test
	public void testImportProject(){
		String sql = "select title,developers,link,picsite,technology from project";
		Connection conn = DS2dsDBUtil.getConnection();
		PreparedStatement prst;
		ResultSet rs;
		try {
			prst = conn.prepareStatement(sql);
			rs = prst.executeQuery();
			List<Project> listProject = new ArrayList<Project>();
			while (rs.next()) {
				Project project = new Project();
				project.setpName(rs.getString("title"));
				project.setpAuthor(rs.getString("developers"));
				project.setpDetails(rs.getString("technology"));
				project.setpPicture(rs.getString("picsite"));
				project.setpWebSite(rs.getString("link"));
				project.setpStatus((byte)1);
				
				listProject.add(project);
			}
			System.out.println(listProject);
			for (Project project : listProject) {
				this.projectService.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testImportMessage(){
		String sql = "select nickname,comment,reply,commentTime,replyTime from message";
		Connection conn = DS2dsDBUtil.getConnection();
		PreparedStatement prst;
		ResultSet rs;
		try {
			prst = conn.prepareStatement(sql);
			rs = prst.executeQuery();
			List<Message> listMessage = new ArrayList<Message>();
			while (rs.next()) {
				Message message = new Message();
				message.setmCommentName(rs.getString("nickname"));
				message.setmCommentContent(rs.getString("comment"));
				message.setmCommentTime(rs.getTimestamp("commentTime"));
				message.setmReplyName("梦之站管理员");
				message.setmReplyContent(rs.getString("reply"));
				message.setmReplyTime(rs.getTimestamp("replyTime"));
				message.setmStatus((byte)1);
				
				listMessage.add(message);
			}
			System.out.println(listMessage);
			for (Message message: listMessage) {
				this.messageService.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
