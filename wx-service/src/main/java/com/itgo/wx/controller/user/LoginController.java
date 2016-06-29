package com.itgo.wx.controller.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itgo.wx.controller.user.check.LoginControllerBeforeAndAfter;

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
	
}
