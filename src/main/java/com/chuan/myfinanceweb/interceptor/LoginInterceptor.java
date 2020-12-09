package com.chuan.myfinanceweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
//		String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
//		if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能			
//		System.out.println(000);
		
		if(session!=null&&session.getAttribute("userName")!=null&&session.getAttribute("userName").toString().equals("myfinanceweb")) {
//			// 登录成功不拦截
			return true;
		}else {
			// 拦截后进入登录页面
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
}
