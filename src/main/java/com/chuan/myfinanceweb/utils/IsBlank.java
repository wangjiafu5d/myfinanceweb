package com.chuan.myfinanceweb.utils;

public class IsBlank {
	public static String stringIsBlank(String s) {
		if (s.isBlank()) {			
			return  new String("0");
		}else {
			return s;
		}
	}
}
