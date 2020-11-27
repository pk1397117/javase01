package thread.thread01;

public class Thread02 implements Runnable{

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread());
	}

	public static void main(String[] args) {
		
		Thread02 t = new Thread02();
		Thread one = new Thread(t);
		Thread two = new Thread(t);
		one.start();
		two.start();
	}
	
}
