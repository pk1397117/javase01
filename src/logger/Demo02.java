package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo02 {
	
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
		
		
	}

}
