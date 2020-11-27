package jiekou;

public class LambdaDemo {
	
	public static void main(String[] args) {

		new TestInterface() {
			@Override
			public void printer(String msg) {
				System.out.println(msg);
			}
		
		}.printer("你好吗");
		
		TestInterface test = (String s) -> {System.out.println(s);};
		test.printer("我不好");
		
		LambdaDemo demo = new LambdaDemo();
		demo.doSome("我很好", test);
		demo.doSome("太好了", val -> System.out.println(val));
		new ClassTest() {

			@Override
			void print(String msg) {
				System.out.println(msg);
				
			}
			
		}.print("吃了吗");
		
		
	}

	static abstract class ClassTest{
		abstract void print(String msg);
		
	}
	
	//作差
	public interface TestInterface{
		void printer(String msg);
	}
	
	void doSome(String msg,TestInterface print) {
		print.printer(msg);
	}
}
