package com.chuan.myfinanceweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.chuan.myfinanceweb.bean.Msg;
import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.service.CookieService;
import com.chuan.myfinanceweb.service.RegisterService;
import com.chuan.myfinanceweb.utils.EscapeUtil;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;

	@Autowired
	CookieService cookieService;

	@RequestMapping("/registerToServer")
	@ResponseBody
	public Msg register(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
			@RequestParam(value = "phoneNum") String phoneNum, HttpServletRequest request,
			HttpServletResponse response) {
		Msg msg = new Msg();
		msg.setMsg("success");
		Map<String, Object> map = new HashMap<String, Object>();
		String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|191|199|(147))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(phoneNum);
		if(!m.matches()) {
			msg.setCode(204);
			map.put("response", "手机号码不符合规范");
			msg.setExtend(map);
			return msg;
		}
		List<User> list = registerService.getUserName(userName);
		HttpSession session = request.getSession(true);
		if (list != null && list.size() == 1) {
			msg.setCode(204);
			map.put("response", "User name is already exist");
			msg.setExtend(map);
			return msg;
		} else {
			userName = EscapeUtil.escape(userName);
			password = EscapeUtil.escape(password);
			email = EscapeUtil.escape(email);			
			registerService.saveUser(userName, password, email, phoneNum);
			session.setAttribute("userName", userName);
			cookieService.makeAndSaveCookie(response, request, userName, password);
			msg.setCode(200);
			map.put("response", "Register Success");
			msg.setExtend(map);
			return msg;
		}
	}

	@RequestMapping("/register")
	public String getIndex() {
		return "register";
	}
}
