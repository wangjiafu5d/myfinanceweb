package com.chuan.myfinanceweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.bean.UserExample;
import com.chuan.myfinanceweb.bean.UserExample.Criteria;
import com.chuan.myfinanceweb.dao.UserMapper;

@Service
public class LoginService {
	@Autowired
	UserMapper userMapper;
	
	public List<User> getUser(String userName,String password){
		UserExample dannerExample = new UserExample();
		Criteria criteria = dannerExample.createCriteria();
		criteria.andNameEqualTo(userName);
		criteria.andPasswordEqualTo(password);
		dannerExample.setOrderByClause("id asc");
		return userMapper.selectByExample(dannerExample);
	}
	public List<User> getUserByName(String userName){
		UserExample dannerExample = new UserExample();
		Criteria criteria = dannerExample.createCriteria();
		criteria.andNameEqualTo(userName);
		dannerExample.setOrderByClause("id asc");
		return userMapper.selectByExample(dannerExample);
	}
}
