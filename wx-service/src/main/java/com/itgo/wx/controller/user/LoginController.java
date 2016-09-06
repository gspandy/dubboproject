package com.itgo.wx.controller.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mxsm.itgo.spring.interceptor.PageInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itgo.wx.controller.check.LoginControllerBeforeAndAfter;
import com.itgo.wx.service.interfaces.impl.UserLoginService;
import com.itgo.wx.web.response.JSONResponse;
import com.itgo.wx.web.resultcode.BaseCode;
import com.itgo.wx.web.resultcode.LoginCode;

/**
 * 登录控制器
 * @author itgo
 *
 */

@Controller
@RequestMapping("/user")
public class LoginController extends UserLoginService<JSONResponse>{

	private HttpSession session;
	
	/**
	 * 登录
	 * @param params
	 * @return
	 */
	@RequestMapping(path={"/login.do"}, method=RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
	public JSONResponse userLogin(@RequestBody Map<String, String> params, HttpSession session){
		if(logger.isDebugEnabled()){
			logger.debug("发送的参数========"+params);
		}
		this.session = session;
		LoginCode code = loginService(params);
		return after(code);
	}
	
	@Override
	public JSONResponse after(Object obj) {
		// TODO Auto-generated method stub
		JSONResponse response = new JSONResponse();
		
		if(!(obj instanceof LoginCode)){
			if(logger.isErrorEnabled()){
				logger.error("参数类型"+obj.getClass().getName()+", 应该为"+LoginCode.class.getName());
			}
			throw new IllegalArgumentException("参数错误");
		}
		if(session == null){
			response.setResultCode(LoginCode.LOGIN_FAIL.code());
			response.setResultMessage(LoginCode.LOGIN_FAIL.message());
			return response;
		}
		LoginCode result = (LoginCode)obj;
		response.setResultCode(result.code());
		response.setResultMessage(result.message());
		return response;
	}
}
