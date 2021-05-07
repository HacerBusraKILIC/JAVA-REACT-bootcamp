package eCommerceSim.core;

import eCommerceSim.jLogger.jLoggerManager;

public class jLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String message) {
		jLoggerManager jLogger =  new jLoggerManager();
		jLogger.Log(message);		
	}

}
