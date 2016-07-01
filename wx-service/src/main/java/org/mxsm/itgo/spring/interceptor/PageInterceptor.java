package org.mxsm.itgo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 页面访问拦截器
 * @author mxsm
 *
 */

public class PageInterceptor extends HandlerInterceptorAdapter{

	public final static String LOGIN_FLAG_ST = "loginflag";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		HttpSession session = request.getSession();
		if(session == null){
			response.sendRedirect(basePath);
			return false;
		}
		
		if(((Boolean)session.getAttribute(LOGIN_FLAG_ST)) == null){
			response.sendRedirect(basePath);
			return false;
		}
		
		boolean loginFlag = ((Boolean)session.getAttribute(LOGIN_FLAG_ST));
		
		if(!loginFlag){
			response.sendRedirect(basePath);
			return false;
		}
		
		return true;
	}
}
