package com.chuan.myfinanceweb.utils;

import org.springframework.util.DigestUtils;

public class UserCookieUtils {
	
	public static String getMd5(String userName,String ipString,String password) {
		return DigestUtils.md5DigestAsHex((userName+"myfinanceweb"+ipString+password).getBytes());
	}
}
