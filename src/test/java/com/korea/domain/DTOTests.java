package com.korea.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.korea.domain.*;

public class DTOTests {
	
	@Test
	public void test() {
		
		TestDTO dto = TestDTO.builder()
				.age("55")
				.name("test")
				.addr("test")
				.build();
		System.out.println(dto);
		
	}

}
