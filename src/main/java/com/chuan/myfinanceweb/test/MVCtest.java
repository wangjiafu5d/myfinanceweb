package com.chuan.myfinanceweb.test;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.chuan.myfinanceweb.bean.Holds;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCtest {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void reqTest() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("date", "2019-01-08");
		params.add("goods", "hc");
		params.add("comp", "永安期货");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/holds").params(params)).andReturn();
		MockHttpServletRequest request = result.getRequest();
		List<Holds> list = new ArrayList<Holds>();
		System.out.println(request);
//		list =  (List<Holds>) request.getAttribute("list");
//		System.out.println(list==null);
//		System.out.println(list.size());
//		for (Holds holds : list) {
//			System.out.println(holds.getAgreement()+"___"+holds.getValue()+"___"+holds.getType());
//		}
//		System.out.println(java.net.URLEncoder.encode("永安期货","utf-8"));
//		System.out.println(java.net.URLDecoder.decode("%E6%82%A8%E5%A5%BD","utf-8"));
	}
}
