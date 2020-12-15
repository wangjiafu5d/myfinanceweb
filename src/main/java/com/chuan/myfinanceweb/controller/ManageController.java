package com.chuan.myfinanceweb.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuan.myfinanceweb.bean.Msg;
import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.service.CookieService;
import com.chuan.myfinanceweb.service.DailyDataService;
import com.chuan.myfinanceweb.service.HoldingsService;
import com.chuan.myfinanceweb.service.LoginService;



@Controller
public class ManageController {
	
	@Autowired
	DailyDataService dailyDataService;
	
	@Autowired
	HoldingsService holdingservice;
	
	@RequestMapping("/manage")
	
	public String login() {
		return "manage";
	}
	@RequestMapping("/echart")
	
	public String echart() {
		return "echart";
	}
	
	@RequestMapping(value="/manage",method = RequestMethod.POST)
	@ResponseBody
	public Msg insert(@RequestParam(value="start_date") String startDate,@RequestParam(value="end_date")String endDate,@RequestParam(value="website")String website) throws ParseException {
		System.out.println(startDate+endDate+website);
		ExecutorService executor = Executors.newSingleThreadExecutor();
	    executor.submit(()->{dailyDataService.deleteDailyData(startDate, endDate, website);});
	    executor.submit(()->{holdingservice.deleteHoldings(startDate, endDate, website);});
	    executor.submit(()->{dailyDataService.insertDailyData(startDate, endDate, website);});
	    executor.submit(()->{holdingservice.insertHoldings(startDate, endDate, website);});
	    executor.shutdown();
		
		
		
		
		Msg msg = new Msg();
		msg.setMsg("insert");
		return msg;
	}
	@RequestMapping(value="/manage",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@RequestParam(value="start_date") String startDate,@RequestParam(value="end_date")String endDate,@RequestParam(value="website")String website) throws ParseException {
		System.out.println(startDate+endDate+website);
		ExecutorService executor = Executors.newSingleThreadExecutor();
	    executor.submit(()->{dailyDataService.deleteDailyData(startDate, endDate, website);});
	    executor.submit(()->{holdingservice.deleteHoldings(startDate, endDate, website);});
	  
	    executor.shutdown();
		Msg msg = new Msg();
		msg.setMsg("delete");
		return msg;
	}
	@RequestMapping(value="/manage",method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(@RequestParam(value="start_date") String startDate,@RequestParam(value="end_date")String endDate,@RequestParam(value="website")String website) throws ParseException {
		System.out.println(startDate+endDate+website);
		ExecutorService executor = Executors.newSingleThreadExecutor();
	    executor.submit(()->{dailyDataService.deleteDailyData(startDate, endDate, website);});
	    executor.submit(()->{holdingservice.deleteHoldings(startDate, endDate, website);});
	    executor.submit(()->{dailyDataService.insertDailyData(startDate, endDate, website);});
	    executor.submit(()->{holdingservice.insertHoldings(startDate, endDate, website);});
	    executor.shutdown();
		Msg msg = new Msg();
		msg.setMsg("update");
		return msg;
	}
}
