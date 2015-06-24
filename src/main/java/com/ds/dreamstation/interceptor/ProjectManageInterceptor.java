package com.ds.dreamstation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ds.dreamstation.dto.MemberSession;

/**
 * @author phn
 * @date 2015-6-3
 * @email 1016593477@qq.com
 * @TODO 
 */
public class ProjectManageInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("ProjectManageInterceptor:perHandle");
		HttpSession session = request.getSession();
		MemberSession memberSession  = (MemberSession)session.getAttribute("memberSession");
		if(memberSession.isManageProject())
		{
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/manage/not-have-authority");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("ProjectManageInterceptor:postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

}
