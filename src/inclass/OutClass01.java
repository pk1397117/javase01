package inclass;

public class OutClass01 {
	
	private static int age;

	class Inclass01{
		private int age;
		
		public int getAge() {
			return OutClass01.age;//可以访问外部类私有字段
		}
	}
	
	interface Inclass02{
		int age = 10;
		int getAge(int age);
	}
	
	abstract class Inclass03{
		private int age;
		
		public abstract int getAge();
	}
	
	void doSome() {
		
		new Inclass01() {
			String name;
		}.getAge();
		
		new Inclass02() {

			@Override
			public int getAge(int age) {
				// TODO Auto-generated method stub
				return age;
				
			}
			
		}.getAge(this.age);
		
		new Inclass03(){
 
			@Override
			public int getAge() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}.getAge();
	}
}
