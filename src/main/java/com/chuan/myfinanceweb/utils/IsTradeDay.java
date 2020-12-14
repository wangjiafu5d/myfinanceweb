package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class IsTradeDay {
	public static boolean checkDate(String strDate) {
		Map<String, String> data = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date realDate = null;
		try {
			realDate = sdf.parse(strDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(realDate);
		
		
		data.put("dayQuotes.variety", "all");
		data.put("dayQuotes.trade_type", "0");
		data.put("year", cal.get(Calendar.YEAR)+"");
		data.put("month", cal.get(Calendar.MONTH)+"");
		data.put("day", cal.get(Calendar.DATE)+"");
		Document doc = null;
		
		try {
			doc = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/dayQuotesCh.html").data(data).post();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Element dataArea = doc.getElementsByClass("tradeResult02").first();
//		System.out.println(dataArea.select("span").get(0).html());
		return doc.html().contains("交易日");
	}
}
