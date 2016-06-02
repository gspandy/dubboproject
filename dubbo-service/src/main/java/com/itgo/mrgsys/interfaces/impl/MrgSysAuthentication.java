package com.itgo.mrgsys.interfaces.impl;

import java.util.Map;

import com.itgo.mxsm.mrgsys.MrgSystemAuthentication;

public class MrgSysAuthentication implements MrgSystemAuthentication {

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

}
