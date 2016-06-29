package com.itgo.wx.web.response;

import java.io.Serializable;

public abstract class AbstractResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9065521665646957053L;
	protected Object obj;

	protected String resultCode;
	
	protected String resultMessage;
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
