package com.itgo.wx.controller.user.check;

import java.util.Map;

import javax.annotation.Resource;

import com.itgo.mxsm.mrgsys.MrgSystemAuthentication;

public abstract class LoginControllerBeforeAndAfter implements BeforeAndAfter, MrgSystemAuthentication{

	@Resource
	protected MrgSystemAuthentication mrgSystemAuthentication;
	
	@Override
	public boolean auth(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mrgSystemAuthentication.auth(params);
	}
	
	@Override
	public boolean auth(Object obj) {
		// TODO Auto-generated method stub
		return mrgSystemAuthentication.auth(obj);
	}
	
	@Override
	public boolean auth(String name, String pwd) {
		// TODO Auto-generated method stub
		return mrgSystemAuthentication.auth(name, pwd);
	}
	
	@Override
	public boolean authByJSON(String xml) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean authByXML(String xml) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String register(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mrgSystemAuthentication.register(params);
	}
	
	
	

}
