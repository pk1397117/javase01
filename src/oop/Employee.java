package oop;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{
	
	private int id;
	private static int nextId = 10;
	private String name;
	
	
	
	
	public Employee() {
		
	}
	public Employee(String name) {
		this.setId();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = nextId;
		nextId++;
	}
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Employee.nextId = nextId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void doSomething(){
		System.out.println("这是一个静态方法");
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public String getDescription() {
		
		return "这是一个员工类";
	}
	
	
	
	

}
