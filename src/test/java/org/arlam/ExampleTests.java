package org.arlam;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

public class ExampleTests {

	@Test
	public void testLog() {
		TestAppender appender = new TestAppender();
		Logger logger = Logger.getRootLogger();
		logger.addAppender(appender);
		Example example = new Example();
		example.run();
		logger.removeAppender(appender);
		List<LoggingEvent> log = appender.getLog();
		LoggingEvent firstLogEntry = log.get(0);
		assertEquals(((String) firstLogEntry.getMessage()), "Log message");
	}
}
