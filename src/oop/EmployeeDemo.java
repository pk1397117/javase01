package oop;

public class EmployeeDemo {
	
	
	public static void main(String[] args) {
		var e1 = new Employee("����");
		var e2 = new Employee("����");

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1.getNextId());
		e1.setNextId(20);
		System.out.println(e2.getNextId());
		System.setOut(System.out);
		Employee.doSomething();
		e1.doSomething();
		Employee e3 = new Manager("����");
		System.out.println(e3.getName());
		System.out.println(e3 instanceof Manager);
		System.out.println(e3 instanceof Employee);
		
	}

}
