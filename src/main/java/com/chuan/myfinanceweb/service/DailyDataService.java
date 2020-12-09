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

import com.chuan.myfinanceweb.bean.DailyData;
import com.chuan.myfinanceweb.bean.DataOf100ppi;
import com.chuan.myfinanceweb.bean.DataOf100ppiExample;
import com.chuan.myfinanceweb.bean.DataOf100ppiExample.Criteria;
import com.chuan.myfinanceweb.dao.DailyDataMapper;
import com.chuan.myfinanceweb.dao.DataOf100ppiMapper;
import com.chuan.myfinanceweb.utils.DailyDataOf100ppi;
import com.chuan.myfinanceweb.utils.DailyDataOfCzce;
import com.chuan.myfinanceweb.utils.DailyDataOfDce;
import com.chuan.myfinanceweb.utils.DailyDataOfShef;
import com.chuan.myfinanceweb.utils.DayOffSet;
import com.chuan.myfinanceweb.utils.IsTradeDay;

@Service
public class DailyDataService {
	@Autowired
	DailyDataMapper dailyDataMapper;
	@Autowired
	DataOf100ppiMapper dataOf100ppiMapper;

	public  int insertOneData(String updateDate, String website) {
		List<DailyData> list = new ArrayList<DailyData>();
		Vector<List<DailyData>> vector = new Vector<List<DailyData>>();
		int times = 1;
		if(website.equals("全部")) {
			times = 4;
		}
		CountDownLatch latch = new CountDownLatch(times);
		ExecutorService exec = Executors.newFixedThreadPool(10);
		
			if (website.equals("全部") || website.equals("上交所")) {
				exec.execute(() -> {
					vector.add(DailyDataOfShef.getData(updateDate));
					latch.countDown();
				});
			}
			if (website.equals("全部") || website.equals("大商所")) {
				exec.execute(() -> {
					vector.add(DailyDataOfDce.getData(updateDate));
					latch.countDown();
				});
			}
			if (website.equals("全部") || website.equals("郑商所")) {
				exec.execute(() -> {
					vector.add(DailyDataOfCzce.getData(updateDate));
					latch.countDown();
				});
			}
			if (website.equals("全部") || website.equals("生意社")) {
				
				exec.execute(() -> {
					insertDataOf100ppi(updateDate);
					latch.countDown();
				});
			}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (List<DailyData> list2 : vector) {
			list.addAll(list2);
		}
		System.out.println("list.size: " + list.size());
		int i = 0;
		if (list != null && list.size() > 0) {
			for (DailyData dailyData : list) {
				i = i + dailyDataMapper.insertSelective(dailyData);
			}
		}

		exec.shutdown();
		return i;
	}

	public void insertDailyData(String startDate, String endDate, String website) {	
		
		
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

	public  void insertDataOf100ppi(String updateDate) {
		System.out.println(updateDate);
		List<DataOf100ppi> list = DailyDataOf100ppi.getData(updateDate);
		for (DataOf100ppi dataOf100ppi : list) {
			dataOf100ppiMapper.insertSelective(dataOf100ppi);
		}
	}
	public void deleteDailyData(String startDate, String endDate, String website) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DataOf100ppiExample example = new DataOf100ppiExample();
		Criteria criteria = example.createCriteria();
		try {
			criteria.andDateBetween(sdf.parse(startDate), sdf.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dataOf100ppiMapper.deleteByExample(example);
	}
}
