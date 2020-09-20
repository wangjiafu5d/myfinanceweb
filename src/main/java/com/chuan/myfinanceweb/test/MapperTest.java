package com.chuan.myfinanceweb.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chuan.myfinanceweb.bean.Dailydatasum;
import com.chuan.myfinanceweb.bean.DailydatasumExample;
import com.chuan.myfinanceweb.bean.Holds;
import com.chuan.myfinanceweb.bean.HoldsExample;
import com.chuan.myfinanceweb.bean.HoldsExample.Criteria;
import com.chuan.myfinanceweb.dao.DailydatasumMapper;
import com.chuan.myfinanceweb.dao.HoldsMapper;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DailydatasumMapper dailydatasum;
	
	@Autowired
	HoldsMapper holdsMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 * @throws ParseException 
	 */
	@Test
	public void testCRUD() throws ParseException{
	 	//1、创建SpringIOC容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2、从容器中获取mapper
//		Dailydatasum bean =(Dailydatasum) ioc.getBean("dds") ;
//		System.out.println(bean);
		System.out.println(dailydatasum);
			dailydatasum.countByExample(new DailydatasumExample());
		//1、插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
		
		//2、生成员工数据，测试员工插入
	//	employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@atguigu.com", 1));
		
		//3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。
		
//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@atguigu.com", 1));
//		}
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0;i<1000;i++){
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null,uid, "M", uid+"@atguigu.com", 1));
//		}
//		System.out.println("批量完成");
			HoldsExample holdsExample = new HoldsExample();
			Criteria criteria = holdsExample.createCriteria();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");			
//			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			Date date = new Date(simpleDateFormat.parse("2019-01-09").getTime());
			Long longTime = 1546963200000L;
			Date date2 = new Date(longTime);
			criteria.andDateEqualTo(date);
			criteria.andGoodsEqualTo("hc");
			criteria.andCompnameEqualTo("永安期货");
			holdsExample.setOrderByClause("agreement asc");
			List<Holds> list = new ArrayList<Holds>();
			list = holdsMapper.selectByExample(holdsExample);
//			list = holdsMapper.selectAll("hc","2019-01-09","永安期货");
			System.out.println(date.getTime());
			for (Holds holds : list) {
				System.out.println(holds.getAgreement()+"___"+holds.getValue()+"___"+holds.getType());
				System.out.println("date: " + simpleDateFormat.format(holds.getDate()) +"___"+holds.getDate().getTime());
			}
			System.out.println("++++" + list.size());
			System.out.println(new java.util.Date());
			System.out.println(new java.util.Date().getTime());
	}

}
