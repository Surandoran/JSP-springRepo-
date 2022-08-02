import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.BoardDTO;
import com.korea.mapper.TestMapper;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBatisSpring {

	@Autowired
	private TestMapper testMapper;
	
	
	@Test
	public void test() {
		String time =  testMapper.getTime();
		log.info("time : "+ time);
		 log.info("TESTMAPPER : " + testMapper);
	}
	
	@Test
	public void test2() {
		String time = testMapper.getTime2();
//		log.info("time2 : " + time);
	}
	
	@Test
	public void test3() {
		List<BoardDTO> list  = testMapper.SelectAll();
		//		list.forEach(dto->log.info(dto));
		
		
	}


}
