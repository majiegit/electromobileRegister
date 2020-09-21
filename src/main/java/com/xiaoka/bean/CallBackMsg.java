package com.xiaoka.bean;

import java.io.Serializable;

public class CallBackMsg implements Serializable {

	private String msg;
	private String data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CallBackMsg [msg=" + msg + ", data=" + data + "]";
	}

}
