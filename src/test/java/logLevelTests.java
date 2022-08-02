

import static org.junit.Assert.fail;

import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class logLevelTests {

	@Test
	public void test() {
		log.trace("TraceTest");
		log.debug("DebugTest");
		log.info("Info Test");
		log.warn("warn Test");
	}

}
