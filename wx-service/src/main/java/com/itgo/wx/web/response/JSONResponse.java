package com.itgo.wx.web.response;

import java.util.List;
import java.util.Map;

public class JSONResponse extends AbstractResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9153740420382889408L;

	protected Map<String, ? extends Object> map;
	
	protected List<? extends Object> list;

	
	public Map<String, ? extends Object> getMap() {
		return map;
	}

	public void setMap(Map<String, ? extends Object> map) {
		this.map = map;
	}

	public List<? extends Object> getList() {
		return list;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}
	
	
	
}
