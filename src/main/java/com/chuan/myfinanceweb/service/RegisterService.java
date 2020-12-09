package com.chuan.myfinanceweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.User;
import com.chuan.myfinanceweb.bean.UserExample;
import com.chuan.myfinanceweb.bean.UserExample.Criteria;
import com.chuan.myfinanceweb.dao.UserMapper;

@Service
public class RegisterService {
	@Autowired
	UserMapper userMapper;
	
	public List<User> getUserName(String userName){
		UserExample dannerExample = new UserExample();
		Criteria criteria = dannerExample.createCriteria();
		criteria.andNameEqualTo(userName);		
		return userMapper.selectByExample(dannerExample);
	}
	
	public Integer saveUser(String userName,String password,String email,String phoneNum){
		User user = new User(null, userName, password, email, phoneNum);		
		return userMapper.insertSelective(user);
	}
	
}
