package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chuan.myfinanceweb.bean.DataOf100ppi;

public class DailyDataOf100ppi {
	public static void main(String[] args) {
		getData("20200903");
	}

	public static List<DataOf100ppi> getData(String strDate) {
		
		List<DataOf100ppi> list = new ArrayList<DataOf100ppi>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date realDate = null;
		try {
			realDate = sdf.parse(strDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(realDate);
		
		String url = "http://www.100ppi.com/sf/day-"+strDate+".html";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		Element table = doc.getElementById("fdata");
		Elements trs = table.select("tr");
		
		for (Element tr : trs) {
			Elements tds = tr.select("td");
			DataOf100ppi data = new DataOf100ppi();
				if (tds.size()==12) {
					String productname = tds.get(0).text().toLowerCase();
					if(productname.equals("菜籽油oi")) {
						productname="菜油";
					}
					if(productname.equals("甲醇ma")) {
						productname="甲醇";
					}
					if(productname.equals("动力煤zc")) {
						productname="动力煤";
					}
					String productid = null;
					productid = GetGoodsIdAndName.shefId.getProperty(productname);
					if(productid==null) {
						productid = GetGoodsIdAndName.czceId.getProperty(productname);
					}if(productid==null) {
						productid = GetGoodsIdAndName.dceId.getProperty(productname);
					}
					data.setProductid(productid);
					data.setProductname(productname);
					BigDecimal currentPrice = new BigDecimal(tds.get(1).text());
					if (productname.equals("玻璃")) {
						currentPrice = currentPrice.multiply(new BigDecimal(80));
					}
					if (productname.equals("鸡蛋")) {
						currentPrice = currentPrice.multiply(new BigDecimal(500));
					}
					data.setCurrentprice(currentPrice);
					data.setDelivermonth1(tds.get(2).text());
					data.setSettlementprice1(new BigDecimal(tds.get(3).text()));
					data.setJc1(new BigDecimal(tds.get(5).text()));
					data.setPercent1(parsePercent(tds.get(6).text()));
					data.setDelivermonth2(tds.get(7).text());
					data.setSettlementprice2(new BigDecimal(tds.get(8).text()));
					data.setJc2(new BigDecimal(tds.get(10).text()));
					data.setPercent2(parsePercent(tds.get(11).text()));
					data.setDate(realDate);
					//System.out.println(data);
					list.add(data);
				}
				
			
		}
		
		return list;
		
		
		
	}
	public static BigDecimal parsePercent(String strPercent) {
		DecimalFormat fomat = new DecimalFormat("00.00%");
		Number number = null;
		try {
			number = fomat.parse(strPercent);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new BigDecimal(number.toString());
	}
}
