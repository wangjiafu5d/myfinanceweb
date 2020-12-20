package com.chuan.myfinanceweb.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.Holdings;
import com.chuan.myfinanceweb.bean.HoldingsExample;
import com.chuan.myfinanceweb.bean.HoldingsExample.Criteria;
import com.chuan.myfinanceweb.bean.ManageRcord;
import com.chuan.myfinanceweb.bean.ManageRcordExample;
import com.chuan.myfinanceweb.dao.HoldingsMapper;
import com.chuan.myfinanceweb.dao.ManageRcordMapper;
import com.chuan.myfinanceweb.utils.DayOffSet;
import com.chuan.myfinanceweb.utils.HoldingsOfCzce;
import com.chuan.myfinanceweb.utils.HoldingsOfDec;
import com.chuan.myfinanceweb.utils.HoldingsOfShef;
import com.chuan.myfinanceweb.utils.IsTradeDay;

@Service
public class HoldingsService {
	@Autowired
	HoldingsMapper holdingsMapper;
	
	
	public List<Holdings> getByDateGoodsAndComp(Date date,String goods,String comp){
		HoldingsExample holdsExample = new HoldingsExample();
		Criteria criteria = holdsExample.createCriteria();
		criteria.andDateEqualTo(date);		
		criteria.andProductidEqualTo(goods);
		criteria.andVolumcompEqualTo(comp);
		holdsExample.setOrderByClause("agreement asc");
		return holdingsMapper.selectByExample(holdsExample);
	}
	public void insertHoldings(String startDate, String endDate, String website) {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = sdf.parse(startDate);
			eDate = sdf.parse(endDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(sDate);
		
		int days = DayOffSet.js(sDate, eDate)+1;
		CountDownLatch latch = new CountDownLatch(days);
		for (int i = 0; i < days; i++) 
		 {
			

			String updateDate = sdf.format(cal.getTime());
			if (IsTradeDay.checkDate(updateDate)) {
				System.out.println(updateDate);
				exec.execute(() -> {
					insertOneData(updateDate, website);
					latch.countDown();
				});
			}else {
				exec.execute(() -> {					
					latch.countDown();
				});
			}

			cal.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println(cal.getTime());
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdown();
		
	}
	public  int insertOneData(String updateDate, String website) {
		List<Holdings> list = new ArrayList<Holdings>();
		Vector<List<Holdings>> vector = new Vector<List<Holdings>>();
		int times = 1;
		if(website.equals("全部")) {
			times = 3;
		}
		CountDownLatch latch = new CountDownLatch(times);
		ExecutorService exec = Executors.newFixedThreadPool(10);
		
			if (website.equals("全部") || website.equals("上交所")) {
				exec.execute(() -> {
					vector.add(HoldingsOfShef.getData(updateDate));
					System.out.println("上交所");
					latch.countDown();
				});
			}
			if (website.equals("全部") || website.equals("大商所")) {
				exec.execute(() -> {
					vector.add(HoldingsOfDec.getData(updateDate));
					latch.countDown();
				});
			}
			if (website.equals("全部") || website.equals("郑商所")) {
				exec.execute(() -> {
					vector.add(HoldingsOfCzce.getData(updateDate));
					latch.countDown();
				});
			}			
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (List<Holdings> list2 : vector) {
			list.addAll(list2);
		}
		System.out.println("list.size: " + list.size());
		int i = 0;
		if (list != null && list.size() > 0) {
			
			for (Holdings holdings : list) {
//				System.out.println(holdings);
//				System.out.println(list.size());
//				Holdings temp = new Holdings(null, "cu", "2013", null, null, null, null, null, null, null, null, null, null, new Date());
//				holdingsMapper.insertSelective(temp);
//				System.out.println("insert_temp_end");
				i = i + holdingsMapper.insertSelective(holdings);
			}
		}

		exec.shutdown();
		return i;
	}
	public void deleteHoldings(String startDate, String endDate, String website) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HoldingsExample example = new HoldingsExample();
		Criteria criteria = example.createCriteria();
		try {
			criteria.andDateBetween(sdf.parse(startDate), sdf.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		holdingsMapper.deleteByExample(example);
		
	}
	public List<Holdings> selectHoldingsByDate(String date,String productid,String delivermonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Holdings> list = new ArrayList<Holdings>();
		HoldingsExample example = new HoldingsExample();
		Criteria criteria = example.createCriteria();
		try {
			criteria.andDateEqualTo(sdf.parse(date));
			criteria.andProductidEqualTo(productid);
			criteria.andDelivermonthEqualTo(delivermonth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		example.setOrderByClause("_rank asc");
		list = holdingsMapper.selectByExample(example);
		return list;
	}
	public List<Holdings> selectHoldingsByDate(String date,String productid){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Holdings> list = new ArrayList<Holdings>();
		HoldingsExample example = new HoldingsExample();
		Criteria criteria = example.createCriteria();
		try {
			criteria.andDateEqualTo(sdf.parse(date));
			criteria.andProductidEqualTo(productid);		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		example.setOrderByClause("_rank asc");
		list = holdingsMapper.selectByExample(example);
		return list;
	}
	public List<Holdings> selectHoldingsByDate(String strDate,String endDate,String productid,String delivermonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Holdings> list = new ArrayList<Holdings>();
		HoldingsExample example = new HoldingsExample();
		Criteria criteria = example.createCriteria();
		try {
			criteria.andDateBetween(sdf.parse(strDate), sdf.parse(endDate));
			criteria.andDelivermonthEqualTo(delivermonth);
			criteria.andProductidEqualTo(productid);
			criteria.andRankEqualTo(999);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		example.setOrderByClause("date asc");
		list = holdingsMapper.selectByExample(example);
		return list;
	}
	
}
