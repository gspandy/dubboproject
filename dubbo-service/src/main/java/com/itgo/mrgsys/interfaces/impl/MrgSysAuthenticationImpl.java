package com.itgo.mrgsys.interfaces.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itgo.mxsm.mybatis.mysql.dao.UserDao;

public class MrgSysAuthenticationImpl extends AbstractMrgSysAuthentication {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource
	private UserDao userDao;
	
	@Override
	public boolean auth(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Map<?, ?>)){
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)obj;
		
		
		return false;
	}

	@Override
	public boolean auth(String name, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean auth(Map<String, String> params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String register(Map<String, String> params) {
		// TODO Auto-generated method stub
		int result = userDao.addUser(params);
		
		
		
		return "aaaaaa";
	}

	@Override
	public boolean authByXML(String xml) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authByJSON(String xml) {
		// TODO Auto-generated method stub
		return false;
	}

}
