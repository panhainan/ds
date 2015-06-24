package com.ds.dreamstation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OnlineInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 最后执行，通常用于释放资源，处理异常。我们可以根据ex是否为空，
		//来进行相关的异常处理。因为我们在平时处理异常时，都是从底层向上抛出异常，
		//最后到了spring框架从而到了这个方法中。
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 该方法在action执行后，生成视图前执行。在这里，我们有机会修改视图层数据。
		System.out.println("OnlineInterceptor:postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO 该方法在action执行前执行，可以实现对数据的预处理，比如：编码、安全控制等。
		//如果方法返回true，则继续执行action。
		System.out.println("OnlineInterceptor:preHandle");
		HttpSession session = request.getSession();
		if(session.getAttribute("memberSession")!=null){
			System.out.println("ok");
			return true;
		}
		//重定向到登录页面  
	    response.sendRedirect(request.getContextPath()+"/manage/off-line");
		return false;
	}
	

}
