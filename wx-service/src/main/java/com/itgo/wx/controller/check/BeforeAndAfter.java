package com.itgo.wx.controller.check;

public interface BeforeAndAfter<T,K>{

	 T before(Object obj);
	
	 K after(Object obj);
	
}
