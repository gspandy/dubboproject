package com.itgo.wx.controller.check;

public interface BeforeAndAfter<T,K> {

	public T before(Object obj);
	
	public K after(Object obj);
	
}
