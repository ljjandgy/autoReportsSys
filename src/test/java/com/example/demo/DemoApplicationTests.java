package com.example.demo;

import com.example.domain.User;
import com.example.domain.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		userRepository.deleteAll();
		userRepository.save(new User("嘻嘻","这只是个备注"));
		User user = userRepository.findByName("嘻嘻");
		System.out.println(user.getRemark());

	}
	@Before
	public void before(){
		System.out.print("开始进行MongoDB测试");
	}
	@After
	public void after(){
		System.out.print("结束测试！");
	}


}
