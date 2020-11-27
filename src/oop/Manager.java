package oop;

public class Manager extends Employee{
	
	private double bonus;
	
	

	public Manager() {
		super();
	}
	public Manager(String name) {
		super(name);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	

}
