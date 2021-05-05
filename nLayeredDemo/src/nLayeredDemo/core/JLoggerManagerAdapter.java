 package nLayeredDemo.core;

import nLayeredDemo.jLogger.jLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String message) {
		jLoggerManager jLogger =  new jLoggerManager();
		jLogger.Log(message);
		
	}

}
