package com.chuan.myfinanceweb.utils;

public class EscapeUtil {
	public static String escape(String src) {
		String result = src.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll(" ",
				"&nbsp;");
		return result;
	}
}
