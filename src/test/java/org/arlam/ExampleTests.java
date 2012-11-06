package org.arlam;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

public class ExampleTests {

	@Test
	public void testLog() {
		TestAppender appender = new TestAppender();
		Logger logger = Logger.getRootLogger();
		logger.addAppender(appender);
		Level backLevel = logger.getLevel();
		logger.setLevel(Level.ALL);
		
		Example example = new Example();
		example.run();
		
		logger.setLevel(backLevel);
		logger.removeAppender(appender);
		List<LoggingEvent> log = appender.getLog();
		LoggingEvent firstLogEntry = log.get(0);
		assertEquals((firstLogEntry.getMessage()), "Log message"); //$NON-NLS-1$
	}
}
