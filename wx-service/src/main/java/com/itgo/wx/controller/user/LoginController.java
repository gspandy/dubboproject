package com.itgo.wx.controller.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mxsm.itgo.spring.interceptor.PageInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itgo.wx.controller.user.check.LoginControllerBeforeAndAfter;
import com.itgo.wx.web.response.JSONResponse;
import com.itgo.wx.web.resultcode.BaseCode;

/**
 * 登录控制器
 * @author itgo
 *
 */

@Controller
@RequestMapping("/user")
public class LoginController extends LoginControllerBeforeAndAfter{

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(path="/register", method=RequestMethod.POST, consumes={"application/json"}, produces={"application/json"})
	public JSONResponse userRegister(@RequestParam Map<String, String> params){
		String result = null;
		JSONResponse response = new JSONResponse();
		
		//result = register(params);
		
		if(result == null){
			response.setResultCode(BaseCode.FAIL.getCode());
			response.setResultMessage(BaseCode.FAIL.getMessage());
		}else{
			
		}
		
		
		return response;
	}
	
	/**
	 * 登录
	 * @param params
	 * @return
	 */
	@RequestMapping(path={"/login"}, method=RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
	public JSONResponse userLogin(@RequestParam Map<String, String> params, HttpSession session){
		
		
		
		
		
		
		//login success
		session.setAttribute(PageInterceptor.LOGIN_FLAG_ST, true);
		
		return new JSONResponse();
	}
	
	
}
