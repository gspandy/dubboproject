package com.itgo.wx.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mxsm.itgo.spring.interceptor.PageInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.container.page.Page;
import com.itgo.wx.controller.check.LoginControllerBeforeAndAfter;
import com.itgo.wx.service.interfaces.impl.UserRegisterService;
import com.itgo.wx.web.response.JSONResponse;
import com.itgo.wx.web.resultcode.BaseCode;
import com.itgo.wx.web.resultcode.RegisterCode;

/**
 * 登录控制器
 * @author itgo
 *
 */

@Controller
@RequestMapping("/user")
public class RegisterController extends UserRegisterService<JSONResponse>{

	//protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(path="/register.do", method=RequestMethod.POST, consumes={"application/json"},  produces={"application/json"})
	public JSONResponse userRegister(@RequestBody Map<String, String> params, HttpServletRequest request){
		params.put("mgr_id", "1");
		RegisterCode code = registerService(params);
		JSONResponse response = after(code);
		
		HttpSession session = request.getSession();
		if(RegisterCode.REGISTER_SUCCESS.code().equals(response.getResultCode())){
			session.setAttribute(PageInterceptor.LOGIN_FLAG_ST, PageInterceptor.LOGIN_SUCCESS);
			String callbackURL = request.getScheme()+"://"+request.getServerName()+":"+
                    request.getServerPort()+request.getContextPath()+"/"+
                    "html/home.html";
			response.setObj(callbackURL);
		}
		
		return response;
	}
	
	@Override
	public JSONResponse after(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof RegisterCode)){
			if(logger.isErrorEnabled()){
				logger.error("参数不是"+obj.getClass().getName());
			}
			throw new IllegalArgumentException("参数错误");
		}
		
		RegisterCode code = (RegisterCode)obj;
		JSONResponse response = new JSONResponse();
		response.setResultCode(code.code());
		response.setResultMessage(code.message());
		
		return response;
	}
	
	
}
