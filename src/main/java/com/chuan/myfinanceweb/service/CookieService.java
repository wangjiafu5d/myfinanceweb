package com.chuan.myfinanceweb.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.utils.UserCookieUtils;

@Service
public class CookieService {

	@Autowired
	LoginService loginService;

	

	public void makeAndSaveCookie(HttpServletResponse response, HttpServletRequest request, String userName,
			String password) {
		String ipString = request.getRemoteAddr();
		String md5Str = UserCookieUtils.getMd5(userName, ipString, password);
		Cookie name = new Cookie("userName", userName);
		name.setHttpOnly(true);
		Cookie pswd = new Cookie("userCookie", md5Str);
		name.setHttpOnly(true);
		name.setMaxAge(432000);
		pswd.setMaxAge(432000);
		response.addCookie(name);
		response.addCookie(pswd);
	}

	public void checkCookie(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Cookie[] cookies = request.getCookies();
		String userName = "";
		String userCookie = "";
		String ipString = request.getRemoteAddr();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					userName = cookie.getValue();
//					System.out.println(userName);
				}
				if (cookie.getName().equals("userCookie")) {
					userCookie = cookie.getValue();
				}
			}
			List<User> list = loginService.getUserByName(userName);
			if (list != null && list.size() == 1) {
				User user = list.get(0);
				String md5Code = DigestUtils
						.md5DigestAsHex((userName + "myfinanceweb" + ipString + user.getPassword()).getBytes());
//				System.out.println(md5Code);
				if (md5Code.equals(userCookie)) {
					session.setAttribute("userName", userName);
				}
			}
		}
	}
}
