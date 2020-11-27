package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo01 {

	public static void main(String[] args) {
		//取消该语句后所有日志
		//Logger.getGlobal().setLevel(Level.OFF);
		
		//全局记录器
		Logger.getGlobal().info("File->Open menu item selected");
		doSome
		();
		
	}
	static void doSome() {
		//全局记录器
		Logger.getGlobal().info("File->Open menu item selected");
	}
}
