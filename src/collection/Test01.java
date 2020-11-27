package collection;

public class Test01 {
	
	public static void main(String[] args) {
		Test01 t = new Test01();
		System.out.println(t.getName());
	}

	private String name;
	private int age;
	
	
	{
		setName("123");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
