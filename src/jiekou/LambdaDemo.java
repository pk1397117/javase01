package jiekou;

public class LambdaDemo {
	
	public static void main(String[] args) {

		new TestInterface() {
			@Override
			public void printer(String msg) {
				System.out.println(msg);
			}
		
		}.printer("�����");
		
		TestInterface test = (String s) -> {System.out.println(s);};
		test.printer("�Ҳ���");
		
		LambdaDemo demo = new LambdaDemo();
		demo.doSome("�Һܺ�", test);
		demo.doSome("̫����", val -> System.out.println(val));
		new ClassTest() {

			@Override
			void print(String msg) {
				System.out.println(msg);
				
			}
			
		}.print("������");
		
		
	}

	static abstract class ClassTest{
		abstract void print(String msg);
		
	}
	
	//����
	public interface TestInterface{
		void printer(String msg);
	}
	
	void doSome(String msg,TestInterface print) {
		print.printer(msg);
	}
}
