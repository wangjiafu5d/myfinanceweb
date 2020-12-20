package com.chuan.myfinanceweb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuan.myfinanceweb.bean.Holdings;
import com.chuan.myfinanceweb.service.HoldingsService;

@Controller
public class AnalyseController {

	@Autowired
	HoldingsService holdingsService;

	@RequestMapping("/echart")
	public String echart() {
		return "echart";
	}

	@RequestMapping("/analyse")
	@ResponseBody
	public List<Object> analyse(@RequestParam(value = "start_date") String startDate,
			@RequestParam(value = "end_date") String endDate, @RequestParam(value = "productid") String productid,
			@RequestParam(value = "delivermonth") String delivermonth) {
		List<Holdings> holdingsList = holdingsService.selectHoldingsByDate(startDate, endDate, productid, delivermonth);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dateList = new ArrayList<String>();
		List<Integer> cjList = new ArrayList<Integer>();
		List<Integer> buyList = new ArrayList<Integer>();
		List<Integer> sellList = new ArrayList<Integer>();
		
		for (Holdings holdings : holdingsList) {
			dateList.add(sdf.format(holdings.getDate()));
			cjList.add(holdings.getCj());
			buyList.add(holdings.getBuy());
			sellList.add(holdings.getSell());
		}
		
		List<Object> response = new ArrayList<Object>();
		response.add(dateList);
		response.add(cjList);
		response.add(buyList);
		response.add(sellList);
		return response;
	}
}
