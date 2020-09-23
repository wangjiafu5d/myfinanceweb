package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetHtml {
	

public static void main(String[] args) throws Exception {
//	Map<String, String> headers = new HashMap<String, String>();
//	headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//	headers.put("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//       Document document = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/dayQuotesCh.html")
////    		   .headers(headers)
//    		   .data("dayQuotes.variety", "all")
//    		   .data("dayQuotes.trade_type", "0")
//    		   .data("year", "2020")
//    		   .data("month", "8")
//    		   .data("day", "10")    		  
//    		   .post();
//       File file = new File("D:\\doc.html");
//       FileWriter writer = new FileWriter(file);
//       writer.write(document.toString());
//       writer.flush();
//       writer.close();
//       System.out.println(document);
       	
//	Connection.Response res = Jsoup.connect("http://www.czce.com.cn/")
//									.method(Method.GET)
//									.execute();
//	Map<String, String> cookies = res.cookies();
//	System.out.println(cookies);
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");      //firefoxPath为火狐浏览器的启动程序的路径，例如:C:\Program Files\Mozilla Firefox\firefox.exe
	
	System.setProperty("webdriver.gecko.driver", "D:\\code\\geckodriver.exe");  //firefoxdriverPath是Firefox驱动的路径，例如:D:\firefox_driver\geckodriver.exe
//	FirefoxOptions options = new FirefoxOptions().addArguments("--headless");
	WebDriver webDriver = new FirefoxDriver();
//	FirefoxDriverService service = new FirefoxDriverService.Builder().usingDriverExecutable(new File("D:\\code\\geckodriver.exe")).usingAnyFreePort().build();
			
	try {
	    
	    webDriver.get("http://www.czce.com.cn/");
	    Document doc = Jsoup.parse(webDriver.getPageSource());
	    System.out.println(doc);
	    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200902/FutureDataHolding.htm");
	    System.out.println(Jsoup.parse(webDriver.getPageSource()));
//	    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200911/FutureDataDaily.htm");
//	    System.out.println(Jsoup.parse(webDriver.getPageSource()));
	    JavascriptExecutor  jsexe = (JavascriptExecutor ) webDriver;
	    jsexe.executeScript("window.open('http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200902/FutureDataHolding.htm')");
	    System.out.println(webDriver.getWindowHandles());
//	    System.out.println(Jsoup.parse(webDriver.switchTo().window("4294967297").getPageSource()));
	} finally {
		webDriver.quit();
		
//		ThreadGroup currentGroup = 
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
	      int noThreads = currentGroup.activeCount();
	      Thread[] lstThreads = new Thread[noThreads];
	      currentGroup.enumerate(lstThreads);
	      for (int i = 0; i < noThreads; i++) {
	      System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
//	      lstThreads[noThreads-1].sleep(1000);
	      lstThreads[noThreads-1].interrupt();
	      }
//		Thread.currentThread().interrupt();
	}
	System.out.println(webDriver.toString());
//	System.exit(0);
    
}
 public static void getData() {
//	 System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");      //firefoxPath为火狐浏览器的启动程序的路径，例如:C:\Program Files\Mozilla Firefox\firefox.exe
//		
//		System.setProperty("webdriver.gecko.driver", "D:\\code\\geckodriver.exe");  //firefoxdriverPath是Firefox驱动的路径，例如:D:\firefox_driver\geckodriver.exe
		InputStream in = GetHtml.class.getClassLoader().getResourceAsStream("selenium.properties");
		
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(props.getProperty("Path"));
		System.setProperties(props);
		//		FirefoxOptions options = new FirefoxOptions().addArguments("--headless");
		WebDriver webDriver = new FirefoxDriver();
//		FirefoxDriverService service = new FirefoxDriverService.Builder().usingDriverExecutable(new File("D:\\code\\geckodriver.exe")).usingAnyFreePort().build();
			
		try {
		    
		    webDriver.get("http://www.czce.com.cn/");
		    Document doc = Jsoup.parse(webDriver.getPageSource());
		    System.out.println(doc);
		    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200903/FutureDataDaily.htm");
		    System.out.println(Jsoup.parse(webDriver.getPageSource()));
//		    webDriver.get("http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200911/FutureDataDaily.htm");
//		    System.out.println(Jsoup.parse(webDriver.getPageSource()));
		    JavascriptExecutor  jsexe = (JavascriptExecutor ) webDriver;
		    jsexe.executeScript("window.open('http://www.czce.com.cn/cn/DFSStaticFiles/Future/2020/20200911/FutureDataDaily.htm')");
		    System.out.println(webDriver.getWindowHandles());
//		    System.out.println(Jsoup.parse(webDriver.switchTo().window("4294967297").getPageSource()));
		} finally {
			webDriver.quit();
			
//			
//			Thread.currentThread().interrupt();
//			System.exit(0);
			
		}
		
 }
}
