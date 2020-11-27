package exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Demo02 {

	public static void main(String[] args) {
		
		//日志打印异常信息
		//LogException();
			
		int x = 11;
		assert x==10;
		System.out.println(x);
	}
	
	static void LogException() {
		Logger logger = Logger.getAnonymousLogger();
		FileInputStream in = null;
		try {
			in = new FileInputStream("c://123");
			System.out.println(1/0);
		} catch (Exception e) {
			logger.log(Level.WARNING, "01异常", e);
		}finally {
			try {
				in.close();//in为null，空指针异常
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(456);
		
	}
	
	
}
