package com.chuan.myfinanceweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.DailyData;
import com.chuan.myfinanceweb.dao.DailyDataMapper;
import com.chuan.myfinanceweb.utils.DailyDataOfCzce;
import com.chuan.myfinanceweb.utils.DailyDataOfDce;
import com.chuan.myfinanceweb.utils.DailyDataOfShef;
@Service
public class DailyDataService {
@Autowired
DailyDataMapper dailyDataMapper;
public int insertDailyData(String strDate) {
	List<DailyData> list = new ArrayList<DailyData>();
	Vector<List<DailyData>> vector = new Vector<List<DailyData>>();
	CountDownLatch latch = new CountDownLatch(3);
	ExecutorService exec = Executors.newFixedThreadPool(10);
	exec.execute(()->{vector.add(DailyDataOfDce.getData(strDate));latch.countDown();});
	exec.execute(()->{vector.add(DailyDataOfCzce.getData(strDate));latch.countDown();});
	exec.execute(()->{vector.add(DailyDataOfShef.getData(strDate));latch.countDown();});
	
	
	try {
		latch.await();
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	
	for (List<DailyData> list2 : vector) {
		list.addAll(list2);
	}
	System.out.println("list.size: "+ list.size());
	int i = 0;
	if (list!=null&&list.size()>0) {
		for (DailyData dailyData : list) {
			i = i + dailyDataMapper.insertSelective(dailyData);
		}
	}
	
	exec.shutdown();
	return i;
}
}
