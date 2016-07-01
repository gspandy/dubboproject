package com.itgo.wx.controller.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mxsm.itgo.spring.interceptor.PageInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itgo.wx.controller.user.check.LoginControllerBeforeAndAfter;
import com.itgo.wx.web.response.JSONResponse;

/**
 * 登录控制器
 * @author itgo
 *
 */

@Controller
@RequestMapping("/user")
public class LoginController extends LoginControllerBeforeAndAfter{

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String register(){
		
		
		return null;
	}
	
	/**
	 * 登录
	 * @param params
	 * @return
	 */
	@RequestMapping(path={"/login"}, method=RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
	public JSONResponse login(@RequestParam Map<String, String> params, HttpSession session){
		
		
		
		
		
		
		//login success
		session.setAttribute(PageInterceptor.LOGIN_FLAG_ST, true);
		
		return new JSONResponse();
	}
	
	
}
