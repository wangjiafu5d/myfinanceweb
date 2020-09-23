package com.chuan.myfinanceweb.bean;

import java.util.Map;

public class Msg {
     public Integer code;
     public String msg;
     public Map<String,Object> extend;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Msg(Integer code, String msg, Map<String, Object> extend) {
		super();
		this.code = code;
		this.msg = msg;
		this.extend = extend;
	}
}
