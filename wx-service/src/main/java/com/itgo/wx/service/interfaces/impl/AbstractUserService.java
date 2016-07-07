package com.itgo.wx.service.interfaces.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itgo.mxsm.mrgsys.MrgSystemAuthentication;
import com.itgo.wx.controller.check.RegisterBeforeAndAfter;
import com.itgo.wx.service.interfaces.UserService;

public abstract class AbstractUserService<T, K> extends RegisterBeforeAndAfter<T, K> implements UserService{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource
	protected MrgSystemAuthentication mrgSystemAuthentication;
	
}
