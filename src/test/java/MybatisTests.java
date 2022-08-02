import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.mapper.TestMapper;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MybatisTests {

	
	@Autowired
	private SqlSessionFactory ssf;
	

	@Test
	public void test() {
		SqlSession dbs = ssf.openSession();
		Connection conn = dbs.getConnection();
		log.info("Conn's obj : " + conn);
	}
	

}






