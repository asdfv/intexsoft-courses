package by.intexsoft.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloWorld1 {

	public static void main(String[] args) {
		
		Logger LOGGER = LoggerFactory.getLogger(HelloWorld1.class);
	    LOGGER.debug("Hello world.");
	    
	    // print internal state
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	}
}
