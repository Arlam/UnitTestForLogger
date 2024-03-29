package org.arlam;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

class TestAppender extends AppenderSkeleton {
	private final List<LoggingEvent> log = new ArrayList<LoggingEvent>();

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(final LoggingEvent loggingEvent) {
		log.add(loggingEvent);
	}

	@Override
	public void close() {
		// Not Implemented
	}

	public List<LoggingEvent> getLog() {
		return new ArrayList<LoggingEvent>(log);
	}
}