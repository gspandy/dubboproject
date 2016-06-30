package org.mxsm.itgo.interceptor.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于实现上下文连接 用于在过滤器中实现注入Request与Response
 * @author mxsm
 *
 */

public interface IWebContext {

	/**
	 * 设置请求的上下文
	 * @param request
	 * @param response
	 * @param indexURL
	 */
	public void setWebContext(HttpServletRequest request, HttpServletResponse response, String indexURL);
	
	/**
	 * 是否登录
	 * @return 已经登录返回true 否则返回false
	 */
	public boolean isLogined();
}
