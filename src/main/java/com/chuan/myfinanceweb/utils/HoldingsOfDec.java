package com.chuan.myfinanceweb.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chuan.myfinanceweb.bean.Holdings;

public class HoldingsOfDec {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		getData("2020-07-01");
		System.out.println(System.currentTimeMillis() - start);
	}

	public static List<Holdings> getData(String strDate) {
		List<Holdings> list = new ArrayList<Holdings>();
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

		data.put("memberDealPosiQuotes.variety", "a");
		data.put("memberDealPosiQuotes.trade_type", "0");
		data.put("year", cal.get(Calendar.YEAR) + "");
		data.put("month", cal.get(Calendar.MONTH) + "");
		data.put("day", cal.get(Calendar.DATE) + "");
		data.put("contract.contract_id", "all");
		data.put("contract.variety_id", "a");
		Document doc = null;

		try {
			doc = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/memberDealPosiQuotes.html").data(data)
					.post();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(doc);
//		Element dataArea = doc.getElementsByClass("dataArea").first();
		Elements productNames = doc.getElementsByClass("keyWord_100");
//		System.out.println(productNames.get(0).text());
		Vector<List<String>> vector1 = new Vector<List<String>>();
		CountDownLatch latch = new CountDownLatch(productNames.size());
		List<String> delivermonthList = new ArrayList<String>();
		ExecutorService exec = Executors.newFixedThreadPool(15);
		for (int i = 0; i < productNames.size(); i++) {
//			System.out.println(GetGoodsIdAndName.dceId.getProperty(productNames.get(i).text()));
			String productId = GetGoodsIdAndName.dceId.getProperty(productNames.get(i).text());
			exec.execute(() -> {
				vector1.add(getDelivermonth(productId, cal));
				latch.countDown();
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println(vector1.size());

		for (List<String> tempList : vector1) {
			delivermonthList.addAll(tempList);
		}
//		System.out.println(delivermonthList.size());
		Vector<List<Holdings>> vector2 = new Vector<List<Holdings>>();
		CountDownLatch latch2 = new CountDownLatch(delivermonthList.size());
		for (String delivermonth : delivermonthList) {
			String id = delivermonth.substring(0, delivermonth.length() - 4);
			String month = delivermonth.substring(delivermonth.length() - 4, delivermonth.length());

			Date finalDate = realDate;
			exec.execute(() -> {
				vector2.add(parseTable(getTable(id, delivermonth, cal), id, month, finalDate));
				latch2.countDown();
			});
		}
		try {
			latch2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("vector2:"+vector2.size());

		exec.shutdown();

		for (List<Holdings> list2 : vector2) {
			list.addAll(list2);
		}
//		System.out.println(list.size());
		return list;
	}

	public static List<Holdings> parseTable(Element dataArea, String productid, String delivermonth, Date date) {

		Elements trs = Jsoup.parse(dataArea.toString().replace(",", "")).select("tr");
		List<Holdings> list = new ArrayList<Holdings>();
		for (Element tr : trs) {

			Elements tds = tr.select("td");
			if (tds.size() == 12) {
				Integer rank = Integer.valueOf("999");

				String volumcomp = "total";

				Integer cj = Integer.valueOf(tds.get(2).text());

				Integer cjchg = Integer.valueOf(tds.get(3).text());

				String bcomp = "total";

				Integer buy = Integer.valueOf(tds.get(6).text());

				Integer buychg = Integer.valueOf(tds.get(7).text());

				String scomp = "total";

				Integer sell = Integer.valueOf(tds.get(10).text());

				Integer sellchg = Integer.valueOf(tds.get(11).text());
				String strRank = tds.get(0).text();

				if (!strRank.equals("总计")) {
					rank = Integer.valueOf(strRank);
					volumcomp = tds.get(1).text();
					bcomp = tds.get(5).text();
					scomp = tds.get(9).text();
				}
				Holdings holdings = new Holdings(null, productid, delivermonth, rank, volumcomp, cj, cjchg, bcomp, buy,
						buychg, scomp, sell, sellchg, date);
				list.add(holdings);
			}
		}
//		System.out.println(list.get(0).getProductid()+list.get(0).getBcomp()+list.get(0).getBuy());
		return list;
	}

	public static List<String> getDelivermonth(String productId, Calendar cal) {
		Map<String, String> data = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		data.put("memberDealPosiQuotes.variety", productId);
		data.put("memberDealPosiQuotes.trade_type", "0");
		data.put("year", cal.get(Calendar.YEAR) + "");
		data.put("month", cal.get(Calendar.MONTH) + "");
		data.put("day", cal.get(Calendar.DATE) + "");
		data.put("contract.contract_id", "all");
		data.put("contract.variety_id", productId);
		Document doc2 = null;
		try {
			doc2 = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/memberDealPosiQuotes.html").data(data)
					.post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements delivermonths = doc2.getElementsByClass("keyWord_65");
		for (Element delivermonth : delivermonths) {
//			System.out.println(delivermonth.text());
			list.add(delivermonth.text());
		}
		return list;
	}

	public static Element getTable(String id, String delivermonth, Calendar cal) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("memberDealPosiQuotes.variety", id);
		data.put("memberDealPosiQuotes.trade_type", "0");
		data.put("year", cal.get(Calendar.YEAR) + "");
		data.put("month", cal.get(Calendar.MONTH) + "");
		data.put("day", cal.get(Calendar.DATE) + "");
		data.put("contract.contract_id", delivermonth);
		data.put("contract.variety_id", id);
		Document doc = null;

		try {
			doc = Jsoup.connect("http://www.dce.com.cn/publicweb/quotesdata/memberDealPosiQuotes.html").data(data)
					.post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element dataArea = doc.getElementsByClass("dataArea").first();
//		System.out.println(dataArea);
		return dataArea;
	}
}
