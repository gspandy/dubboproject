package org.mxsm.itgo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 页面访问拦截器
 * @author mxsm
 *
 */

public class PageInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		System.out.println(1111);
		
		
		return true;
	}
}
