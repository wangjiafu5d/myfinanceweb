package com.chuan.myfinanceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuan.myfinanceweb.bean.Msg;
import com.chuan.myfinanceweb.service.DailyDataService;

@Controller
public class DailyDataController {
@Autowired
DailyDataService service;

@RequestMapping("/insert")
@ResponseBody
public Msg insertDailyData(@RequestParam(value="date") String strDate) {
	Msg msg = new Msg();
	msg.msg = "failed";
	int i = service.insertDailyData(strDate);
	if (i>0) {
		msg.msg = "success";
	}
	return msg;
}
}
