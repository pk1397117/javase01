package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo03 {
	
	private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
	
	public static void main(String[] args) {
		//������־����
		//myLogger.setLevel(Level.FINE);
		
		
		
		//���е���־�����м�¼����
		myLogger.severe("123");
		myLogger.warning("456");
		myLogger.info("789");
		myLogger.config("abc");
		myLogger.fine("def");
		myLogger.finer("ghi"); 
		myLogger.finest("jkl");
		
		//������ʹ��log����ָ������
		//myLogger.log(Level.SEVERE, "456");
		
		read("123","789");
		doSome();
	}
	
	static int read(String file, String pattern) {
		myLogger.entering("logger.Demo03", "read", new Object[] {file,pattern});
		myLogger.exiting("logger.Demo03", "read", 3);
		return 3;
	}
	
	static void doSome () {
		myLogger.finest("7788");
		myLogger.logp(Level.FINEST, "logger.Demo03", "doSome", "doSome01");
	}
}