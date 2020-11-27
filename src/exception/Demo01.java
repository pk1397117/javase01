package exception;

import java.io.IOException;

public class Demo01 {
	
	public static void main(String[] args) throws FileFormatException {
		
		//doSome("游泳");
		var e = new FileFormatException("123");
		
		throw e;
		 
		
		
	}
	
	static class FileFormatException extends IOException{
		
		FileFormatException(){
			
		}
		FileFormatException(String gripe){
			super(gripe);
		}
	}
	
	static void doSome(String s) {
		if(s.equals("游泳")) {
			throw new ArithmeticException("不会游泳");
		}
		System.out.println(s);
	}
	
}
