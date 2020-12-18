package com.chuan.myfinanceweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.service.CookieService;
import com.chuan.myfinanceweb.service.LoginService;



@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	CookieService cookieService;

	@RequestMapping("/loginContr")
	@ResponseBody
	public String login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "rememberMe") String rememberMe,
			HttpServletRequest request,HttpServletResponse response) {
		List<User> list = loginService.getUser(userName, password);		
		HttpSession session = request.getSession(true);
		if (list != null && list.size() == 1) {
			session.setAttribute("userName", userName);
			if (rememberMe.equals("yes")) {				
				cookieService.makeAndSaveCookie(response, request, userName ,password);
			}
			if(userName.equals("myfinanceweb")) {
				return "manage";
			}else {				
				return "index";
			}
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
