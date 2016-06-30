package com.itgo.wx.controller.user;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(path={"/login"}/*, method=RequestMethod.POST, consumes={"application/json"}*/,produces="application/json")
	public JSONResponse login(@RequestParam Map<String, String> params){
		
		System.out.println(params);
		
		return new JSONResponse();
	}
	
	
}
