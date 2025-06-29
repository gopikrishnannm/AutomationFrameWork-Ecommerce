package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	//private static Logger logger; each class is not getting its own logger instalnce

	private LoggerUtility() {
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}
}
