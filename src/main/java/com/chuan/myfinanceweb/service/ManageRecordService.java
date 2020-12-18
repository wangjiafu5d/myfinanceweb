package com.chuan.myfinanceweb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myfinanceweb.bean.ManageRcord;
import com.chuan.myfinanceweb.bean.ManageRcordExample;
import com.chuan.myfinanceweb.bean.ManageRcordExample.Criteria;
import com.chuan.myfinanceweb.dao.ManageRcordMapper;

@Service
public class ManageRecordService {
	
	@Autowired
	ManageRcordMapper manageRcordMapper;
	
	public void updateRecordTime(Date holdingsData) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		ManageRcord record = new ManageRcord(null, holdingsData, sdf.format(date));
		ManageRcordExample example = new ManageRcordExample();
		Criteria criteria = example.createCriteria();
		criteria.andDateEqualTo(holdingsData);
		List<ManageRcord> list = manageRcordMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			manageRcordMapper.updateByExampleSelective(record, example);
		}else {
			manageRcordMapper.insertSelective(record);
		}
		
	}
	public void deleteRecord(String value1,String value2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		Date date1 = null;
		try {
			date1 = sdf.parse(value1);
			date2 = sdf.parse(value2);
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
		
		ManageRcordExample example = new ManageRcordExample();
		Criteria criteria = example.createCriteria();
		criteria.andDateBetween(date1, date2);
		manageRcordMapper.deleteByExample(example);
	}
	public List<ManageRcord> selectRecord() {
		ManageRcordExample example = new ManageRcordExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		example.setOrderByClause("date asc");
		List<ManageRcord> list = manageRcordMapper.selectByExample(example);
		return list;
	}
}
