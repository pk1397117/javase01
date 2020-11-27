package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo02 {
	
	private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
	
	public static void main(String[] args) {
		//设置日志级别
		//myLogger.setLevel(Level.FINE);
		
		//所有的日志级别都有记录方法
		myLogger.severe("123");
		myLogger.warning("456");
		myLogger.info("789");
		myLogger.config("abc");
		myLogger.fine("def");
		myLogger.finer("ghi");
		myLogger.finest("jkl");
		
		//还可以使用log方法指定级别
		//myLogger.log(Level.SEVERE, "456");
		
		
	}

}
