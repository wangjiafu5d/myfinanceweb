package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.chuan.myfinanceweb.bean.Holdings;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class HoldingsOfShef {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();		
		getData("2020-12-01");
		System.out.println(System.currentTimeMillis()-start);
	}
	public static List<Holdings> getData(String strDate) {
		List<Holdings> list = new ArrayList<Holdings>();
		String url = "http://www.shfe.com.cn/data/dailydata/kx/pm" + strDate.replace("-", "") + ".dat";
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
		JsonArray jarr = jobj.getAsJsonArray("o_cursor");
//		System.out.println(jarr);
//		System.out.println(jobj.getAsJsonPrimitive("o_weekday"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date  realDate = null;
		try {
			 realDate = sdf.parse(strDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		for(JsonElement ele : jarr) {
			JsonObject data = ele.getAsJsonObject();
			Holdings holdings = null;
			
		    //System.out.println(data);
			Integer rank = Integer.valueOf(data.getAsJsonPrimitive("RANK").getAsString());
			if(rank>0){
				String instrumentid = data.getAsJsonPrimitive("INSTRUMENTID").getAsString();
				String productid = instrumentid.substring(0,2);
				String delivermonth = instrumentid.substring(2,6);
				String volumcomp = data.getAsJsonPrimitive("PARTICIPANTABBR1").getAsString();
				Integer cj = Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ1").getAsString()));
				Integer cjchg = Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ1_CHG").getAsString()));
				String bcomp = data.getAsJsonPrimitive("PARTICIPANTABBR2").getAsString();
				Integer buy = Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ2").getAsString()));
				Integer buychg = Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ2_CHG").getAsString()));
				String scomp = data.getAsJsonPrimitive("PARTICIPANTABBR3").getAsString();
				Integer sell = Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ3").getAsString()));
				Integer sellchg =Integer.valueOf(IsBlank.stringIsBlank(data.getAsJsonPrimitive("CJ3_CHG").getAsString()));
				if (rank.compareTo(Integer.valueOf(999))==0) {
					volumcomp = "total";
					bcomp = "total";
					scomp = "total";
				}
				holdings = new Holdings(null, productid, delivermonth, rank, volumcomp, cj, cjchg, bcomp, buy, buychg, scomp, sell, sellchg, realDate);
//				System.out.println(rank+""+productid+" "+delivermonth);
				
				list.add(holdings);
			}
			
			
			
			
		};
		System.out.println(list.size());
		
		return list;
	}
}
