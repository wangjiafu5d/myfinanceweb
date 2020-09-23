package com.chuan.myfinanceweb.controller;
import java.sql.Date;
import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuan.myfinanceweb.bean.Holds;
import com.chuan.myfinanceweb.service.HoldsService;
@Controller
public class HoldsController {
	@Autowired
	HoldsService holdsService;
	@RequestMapping("/holds")
	@ResponseBody
	public List<Holds> getHolds(@RequestParam(value="date") String strDate,@RequestParam(value="goods")String goods,@RequestParam(value="comp")String comp,Model model) throws ParseException {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = simpleDateFormat.parse(strDate);	
		Date date = Date.valueOf(strDate);
		List<Holds> list = holdsService.getByDateGoodsAndComp(date, goods, comp);		
		model.addAttribute("list", list);
		return list;
	}
	@RequestMapping(value="/holds",params="s")
	@ResponseBody
	public List<Holds> getHolds(@RequestParam(value="date") String strDate,@RequestParam(value="goods")String goods,@RequestParam(value="comp")String comp,@RequestParam(value="s")String s) throws ParseException {

		Date date = Date.valueOf(strDate);
		List<Holds> list = holdsService.getByDateGoodsAndComp(date, goods, comp);		
		return list;
	}
	@RequestMapping("/getholds")
	public String getH() {		
		return "getholds";
	}
	@RequestMapping("/getIndex")
	public String getIndex() {
		return "index";
	}
	@RequestMapping("/getHtml")
	public String getHtml() {
		com.chuan.myfinanceweb.utils.GetHtml.getData();
		return "index";
	}
}
