package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo01 {

	public static void main(String[] args) {
		//ȡ��������������־
		//Logger.getGlobal().setLevel(Level.OFF);
		
		//ȫ�ּ�¼��
		Logger.getGlobal().info("File->Open menu item selected");
		doSome
		();
		
	}
	static void doSome() {
		//ȫ�ּ�¼��
		Logger.getGlobal().info("File->Open menu item selected");
	}
}
