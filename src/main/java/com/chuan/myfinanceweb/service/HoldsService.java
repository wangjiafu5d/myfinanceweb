package com.chuan.myfinanceweb.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.Holds;
import com.chuan.myfinanceweb.bean.HoldsExample;
import com.chuan.myfinanceweb.bean.HoldsExample.Criteria;
import com.chuan.myfinanceweb.dao.HoldsMapper;

@Service
public class HoldsService {
	@Autowired
	HoldsMapper holdsMapper;
	
	public List<Holds> getByDateGoodsAndComp(Date date,String goods,String comp){
		HoldsExample holdsExample = new HoldsExample();
		Criteria criteria = holdsExample.createCriteria();
		criteria.andDateEqualTo(date);		
		criteria.andGoodsEqualTo(goods);
		criteria.andCompnameEqualTo(comp);
		holdsExample.setOrderByClause("agreement asc");
		return holdsMapper.selectByExample(holdsExample);
	}
}
