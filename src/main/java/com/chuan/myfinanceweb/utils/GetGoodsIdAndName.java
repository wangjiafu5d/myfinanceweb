package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public final class GetGoodsIdAndName {
	public static final GetGoodsIdAndName Instance = new GetGoodsIdAndName();
	public static Properties shefId;
	public static Properties dceId;
	public static Properties czceId;
	
	private static Properties getIdAndName(String path) {

		InputStreamReader in = null;
		try {
			in = new  InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(path), "UTF-8");
		} catch (UnsupportedEncodingException e1) {			
			e1.printStackTrace();
		}
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	private GetGoodsIdAndName() {
		if (shefId==null) {
			shefId = getIdAndName("shef.properties");
		}
		if (dceId==null) {
			dceId = getIdAndName("dce.properties");
		}
		if (czceId==null) {
			czceId = getIdAndName("czce.properties");
		}		
	}
	public static void main(String[] args) {
		for (String key : czceId.stringPropertyNames()) {
//		    System.out.println(key + "=" + shefId.getProperty(key));
		    System.out.print("{ \r\n value: '"+key+"', \r\n label: '"+ czceId.getProperty(key)+"'\r\n" + 
		    		"},");
		}
	}
}
