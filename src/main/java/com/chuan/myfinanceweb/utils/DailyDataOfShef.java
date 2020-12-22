package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.chuan.myfinanceweb.bean.DailyData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DailyDataOfShef {
	public static void main(String[] args) {
		getData("2020-01-02");
	}
	public static List<DailyData> getData(String strDate) {
		List<DailyData> list = new ArrayList<DailyData>();
		String url = "http://www.shfe.com.cn/data/dailydata/kx/kx" + strDate.replaceAll("-", "") + ".dat";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(30000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(doc.body().html());
		Gson g = new Gson();
		JsonObject jobj =  g.fromJson(doc.body().html(), JsonObject.class);
//		System.out.println(jobj);
		JsonArray jarr = jobj.getAsJsonArray("o_curinstrument");
//		System.out.println(jarr);
//		System.out.println(jobj.getAsJsonPrimitive("o_weekday"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date  realDate = null;
		try {
			 realDate = sdf.parse(strDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		for(JsonElement ele : jarr) {
			JsonObject data = ele.getAsJsonObject();
			DailyData dailyData = new DailyData();
			
//			System.out.println(dailyData.getProductname());
			String delivermonth = data.getAsJsonPrimitive("DELIVERYMONTH").getAsString();
			String productid = data.getAsJsonPrimitive("PRODUCTID").getAsString();
			dailyData.setDelivermonth(delivermonth);
			if (delivermonth.equals("小计")||productid.equals("总计")||productid.trim().equals("sc_tas")) {
				continue ;
			} 
			//System.out.println(data);
			dailyData.setProductid(data.getAsJsonPrimitive("PRODUCTID").getAsString().substring(0,2));
			dailyData.setProductname(data.getAsJsonPrimitive("PRODUCTNAME").getAsString());
			dailyData.setPresettlementprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("PRESETTLEMENTPRICE").getAsString())));
			dailyData.setOpenprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("OPENPRICE").getAsString())));
			dailyData.setHighestprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("HIGHESTPRICE").getAsString())));
			dailyData.setLowestprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("LOWESTPRICE").getAsString())));
			dailyData.setCloseprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CLOSEPRICE").getAsString())));
			dailyData.setSettlementprice(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("SETTLEMENTPRICE").getAsString())));
			dailyData.setZd1Chg(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("ZD1_CHG").getAsString())));
			if(data.getAsJsonPrimitive("ZD2_CHG").toString().equals("\"\"")) {
				continue ;
			}
			dailyData.setZd2Chg(new BigDecimal(IsBlank.stringIsBlank(data.getAsJsonPrimitive("ZD2_CHG").toString())));
			dailyData.setVolume(Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("VOLUME").getAsString())));
			dailyData.setOpeninterest(Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("OPENINTEREST").getAsString())));
			dailyData.setOpeninterestchg(Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("OPENINTERESTCHG").getAsString())));
			
			dailyData.setDate(realDate);
			
			list.add(dailyData);
			map.put(dailyData.getProductid(), dailyData.getProductname());
		};
//		System.out.println(list.size());
//		for(String key : map.keySet()) {
//			System.out.println(map.get(key)+"="+key);
//		}
		return list;
	}
}
