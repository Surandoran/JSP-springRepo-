package com.korea.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DTOTests {

	@Autowired
	private TestDTO testdto;
	
	@Test
	public void test() {	
		
		//TestDTO dto = new TestDTO("全辨悼","44","措备");
		//dto.setAddr("匡魂");
		
		TestDTO dto = TestDTO.builder()
				.age("55")
				.name("全辨悼")
				.addr("林家林家")
				.build();
		System.out.println(dto);
		 
	}
	
	@Test
	public void test2() {
		testdto.setName("全辨悼");
		log.info("testDTO : " + testdto);
		
	}

}
