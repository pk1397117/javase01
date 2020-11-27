package thread.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread03 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread());
		return Thread.currentThread().getName();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Thread03 t = new Thread03();
		FutureTask<String> ft1 = new FutureTask<>(t);
		FutureTask<String> ft2 = new FutureTask<>(t);
		Thread one = new Thread(ft1);
		Thread two = new Thread(ft2);
		
		one.start();
		two.start();
		System.out.println(ft1.get());
		System.out.println(ft2.get());
	}

}
