package thread.thread01;

public class Thread01 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}

	public static void main(String[] args) {
		Thread01 one = new Thread01();
		Thread01 two = new Thread01();
		one.start();
		two.start();
	}
}
