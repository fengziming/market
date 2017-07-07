package com.duolanjian.java.market.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.duolanjian.java.market.bean.User;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class JedisUtilTest {
	
	@Autowired
	JedisUtil jedisUtil;

	@Test
	public void test() throws InterruptedException {
		try{
		jedisUtil.set("abc", "123", 5);
		System.out.println(jedisUtil.get("market_login_user_id_9244a423-ce0b-4648-b12e-12c0195bbe18"));

		System.out.println(JSON.parseObject(jedisUtil.get("market_login_user_id_9244a423-ce0b-4648-b12e-12c0195bbe18"), User.class));
		Thread.sleep(2000);
		System.out.println(jedisUtil.get("abc"));
		Thread.sleep(4000);
		System.out.println("value: " + jedisUtil.get("abc"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}