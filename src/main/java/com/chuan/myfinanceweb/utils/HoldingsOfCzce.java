package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.chuan.myfinanceweb.bean.DailyData;
import com.chuan.myfinanceweb.bean.Holdings;

public class HoldingsOfCzce {

public static void main(String[] args) {
	long start = System.currentTimeMillis();
	getData("2020-12-01");
	System.out.println(System.currentTimeMillis() - start);
}
public static List<Holdings> getData(String strDate) {
	List<Holdings> list = new ArrayList<Holdings>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date realDate = null;
	try {
		realDate = sdf.parse(strDate);
	} catch (ParseException e1) {
		e1.printStackTrace();
	}
	InputStreamReader in = null;
	try {
		in = new  InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("selenium.properties"), "UTF-8");
	} catch (UnsupportedEncodingException e1) {			
		e1.printStackTrace();
	}	
	
	Properties props = new Properties();
	try {
		props.load(in);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	System.setProperty("webdriver.firefox.bin", props.getProperty("webdriver.firefox.bin"));     
	
	System.setProperty("webdriver.gecko.driver", props.getProperty("webdriver.gecko.driver"));  
//	System.out.println(props.getProperty("webdriver.firefox.bin"));
	
	FirefoxOptions options = new FirefoxOptions().addArguments("--headless");
	WebDriver webDriver = new FirefoxDriver(options);
		
	try {
	    String year = strDate.substring(0, 4);
	    webDriver.get("http://www.czce.com.cn/");
	    webDriver.getPageSource();
//	    System.out.println(doc);
	    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/"+year+"/"+strDate.replace("-", "")+"/FutureDataHolding.htm");
	    
	    Element table = Jsoup.parse(webDriver.getPageSource()).select("tbody").first();
	    Elements trs = table.select("tr");
	    String productid = "";
	    String delivermonth = "";
	    for (Element tr : trs) {
	    	
	    	Elements tds = tr.select("td");
	    	for (Element td : tds) {
				td.html(td.html().replace(",", ""));
			}
	    	if(tds.size()==1) {
	    		String str = tds.get(0).text();
	    		if (str.contains("合约")) {
					productid = str.substring(3,5);
					delivermonth = "2" + str.substring(5,8);
//	    			System.out.println(productid+": "+ delivermonth);
				}
	    	}
	    	if (!productid.equals("")&&tds.size()==10&&!tds.get(0).text().equals("名次")) {
	    		for (int i = 0; i < tds.size(); i++) {
	    			if (tds.get(i).html().equals("-")) {
	    				tds.get(i).html("0");
	    			}
	    		}
	    		Integer rank = Integer.valueOf("999");

				String volumcomp = "total";

				Integer cj = Integer.valueOf(tds.get(2).text());

				Integer cjchg = Integer.valueOf(tds.get(3).text());

				String bcomp = "total";

				Integer buy = Integer.valueOf(tds.get(5).text());

				Integer buychg = Integer.valueOf(tds.get(6).text());

				String scomp = "total";

				Integer sell = Integer.valueOf(tds.get(8).text());

				Integer sellchg = Integer.valueOf(tds.get(9).text());
				String strRank = tds.get(0).text();

				if (!strRank.equals("合计")) {
					rank = Integer.valueOf(strRank);
					volumcomp = tds.get(1).text();
					bcomp = tds.get(4).text();
					scomp = tds.get(7).text();
				}
				Holdings holdings = new Holdings(null, productid, delivermonth, rank, volumcomp, cj, cjchg, bcomp, buy, buychg, scomp, sell, sellchg, realDate);
				list.add(holdings);
	    	}
		}
	    
    
	} finally {
		webDriver.quit();
		
	}
	
	
	System.out.println(list.size());
	return list;
}
}
