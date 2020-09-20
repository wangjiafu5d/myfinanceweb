package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetDec {
	public static void main(String[] args) {
		try {
	        Map<String, String> header = new HashMap<String, String>();	       
	        header.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
	        header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	        header.put("Accept-Language", "zh-cn,zh;q=0.5");
	        header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
	        header.put("Connection", "keep-alive");
//			Response resp = Jsoup.connect("http://www.czce.com.cn/").headers(header).execute();
//			Map<String,String> cookies =  resp.cookies();
//			 System.out.println(cookies);
//			 for(String key:cookies.keySet()) {
//				 System.out.println(key+"="+cookies.get(key)+";");
//			 }
	        Map data = new HashMap<String, String>();
	        data.put("memberDealPosiQuotes.variety", "c");
	        data.put("memberDealPosiQuotes.trade_type", "0");
	        data.put("year", "2020");
	        data.put("month", "8");
	        data.put("day", "09");
	        data.put("contract.contract_id", "c2101");
	        data.put("contract.variety_id", "c");
	        data.put("contract", "");
			Document doc = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/memberDealPosiQuotes.html")
					.data(data).post();
//			System.out.println(doc);
			Element ele1 = doc.getElementsByClass("selBox").first();
			System.out.println(ele1);
			for (Element ele2:doc.select(".keyWord_100")) {
				String str = ele2.select("input").first().attr("onclick");
				System.out.println(ele2.text()+"="+str.substring(str.indexOf("\'")+1, str.lastIndexOf("\'")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
