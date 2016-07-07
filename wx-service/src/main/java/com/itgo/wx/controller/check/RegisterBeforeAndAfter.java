package com.itgo.wx.controller.check;

public abstract class RegisterBeforeAndAfter<T, K> implements BeforeAndAfter<T, K> {

	/**
	 * default is do no thing return null,implments on subclass
	 */
	@Override
	public K after(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * default is do no thing return null,implments on subclass
	 */
	@Override
	public T before(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
