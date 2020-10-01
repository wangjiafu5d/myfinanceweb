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

public class DailyDataOfCzce {
public static void main(String[] args) {
	getData("20200903");
}
public static List<DailyData> getData(String strDate) {
	List<DailyData> list = new ArrayList<DailyData>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
	    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/"+year+"/"+strDate+"/FutureDataDaily.htm");
	    
	    Element table = Jsoup.parse(webDriver.getPageSource()).select("tbody").first();
	    Elements trs = table.select("tr");
	    
	    for (Element tr : trs) {
	    	DailyData dailyData = new DailyData();
	    	
	    	Elements tds = tr.select("td");
	    	for (Element td : tds) {
				td.html(td.html().replace(",", ""));
			}
	    	if(tds.get(0).html().length()>3&&tds.get(0).html().length()<7) {
	    		String productId = tds.get(0).html().substring(0, 2).toLowerCase();
	    		String productName = GetGoodsIdAndName.czceId.getProperty(productId);
	    		String delivermonth = "2"+tds.get(0).html().substring(2, 5);
	    		dailyData.setProductid(productId);
	    		dailyData.setProductname(productName);
	    		dailyData.setDelivermonth(delivermonth);
	    		dailyData.setPresettlementprice(new BigDecimal(tds.get(1).html()));
	    		dailyData.setOpenprice(new BigDecimal(tds.get(2).html()));
	    		dailyData.setHighestprice(new BigDecimal(tds.get(3).html()));
	    		dailyData.setLowestprice(new BigDecimal(tds.get(4).html()));
	    		dailyData.setCloseprice(new BigDecimal(tds.get(5).html()));
	    		dailyData.setSettlementprice(new BigDecimal(tds.get(6).html()));
	    		dailyData.setZd1Chg(new BigDecimal(tds.get(7).html()));
	    		dailyData.setZd2Chg(new BigDecimal(tds.get(8).html()));
	    		dailyData.setVolume(Integer.valueOf(tds.get(9).html()));
	    		dailyData.setOpeninterest(Integer.valueOf(tds.get(10).html()));;
	    		dailyData.setOpeninterestchg(Integer.valueOf(tds.get(11).html()));
	    		dailyData.setDate(realDate);
	    		
//	    		System.out.println(dailyData);
		    	list.add(dailyData);
	    	}
		}
	    
    
	} finally {
		webDriver.quit();
		
	}
	
	
	
	return list;
}
}
