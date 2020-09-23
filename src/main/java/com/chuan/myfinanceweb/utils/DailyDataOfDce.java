package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chuan.myfinanceweb.bean.DailyData;

public class DailyDataOfDce {
	public static void main(String[] args) {
		getData("20200903");
	}

	public static List<DailyData> getData(String strDate) {
		List<DailyData> list = new ArrayList<DailyData>();
		Map<String, String> data = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
		Element dataArea = doc.getElementsByClass("dataArea").first();
		Elements trs = dataArea.select("tr");
		for (Element tr : trs) {
			DailyData dailyData = new DailyData();
			Elements tds = tr.select("td");
			for (int i = 0; i < tds.size(); i++) {
				if (tds.get(i).html().equals("-")) {
					tds.get(i).html("0");
				}
			}
			if (tds.size()>0&&GetGoodsIdAndName.dceId.get(tds.get(0).html().replaceAll("&nbsp;", ""))!=null) {
				String productname = tds.get(0).html().replaceAll("&nbsp;", "");
				String productid = GetGoodsIdAndName.dceId.getProperty(productname);
				dailyData.setProductid(productid);
				dailyData.setProductname(productname);
				dailyData.setDelivermonth(tds.get(1).html());
				dailyData.setOpenprice(new BigDecimal(tds.get(2).html()));
				dailyData.setHighestprice(new BigDecimal(tds.get(3).html()));
				dailyData.setLowestprice(new BigDecimal(tds.get(4).html()));
				dailyData.setCloseprice(new BigDecimal(tds.get(5).html()));
				dailyData.setPresettlementprice(new BigDecimal(tds.get(6).html()));
				dailyData.setSettlementprice(new BigDecimal(tds.get(7).html()));
				dailyData.setZd1Chg(new BigDecimal(tds.get(8).html()));
				dailyData.setZd2Chg(new BigDecimal(tds.get(9).html()));
				dailyData.setVolume(Integer.valueOf(tds.get(10).html()));
				dailyData.setOpeninterest(Integer.valueOf(tds.get(11).html()));
				dailyData.setOpeninterestchg(Integer.valueOf(tds.get(12).html()));
				dailyData.setDate(realDate);
				list.add(dailyData);
				System.out.println(dailyData);
			}else {
				continue ;
			}
			
		}
//		System.out.println(trs.size());
//		System.out.println(trs.first());
		return list;
	}
}
