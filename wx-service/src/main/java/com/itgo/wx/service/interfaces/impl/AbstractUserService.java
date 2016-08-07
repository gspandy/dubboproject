package com.itgo.wx.service.interfaces.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itgo.mxsm.mrgsys.MrgSystemAuthentication;
import com.itgo.wx.controller.check.RegisterBeforeAndAfter;
import com.itgo.wx.service.interfaces.UserService;
import com.itgo.wx.web.resultcode.LoginCode;
import com.itgo.wx.web.resultcode.RegisterCode;

public abstract class AbstractUserService<T, K> extends RegisterBeforeAndAfter<T, K> implements UserService{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource
	protected MrgSystemAuthentication mrgSystemAuthentication;
	
	@Override
	public RegisterCode registerService(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LoginCode loginService(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
