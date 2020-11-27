package thread.thread02;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a bank with a number of bank accounts
 * @author Administrator
 *
 */
public class Bank {

	private final double[] accounts;
	//重入锁
	private Lock bankLock;

	//条件对象(充足的资金)
	private Condition sufficientFounds;
	/**
	 * Constructs the bank
	 * @param n the number of accounts
	 * @param initialBalance initial balance with each account
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		//将初始化余额赋值给账户数组的每一个元素
		Arrays.fill(accounts, initialBalance);
		//初始化锁对象
		bankLock = new ReentrantLock();
		//返回该锁相关联的一个条件对象(充足的资金s)
		sufficientFounds = bankLock.newCondition();
	}
	
	/**
	 * Transfer(转移)  money from one account to another
	 * @param from the account to transfer from
	 * @param to the account to transfer to
	 * @param amount(金额) the amount to transfer 
	 */
	public void transfer(int from, int to, double amount) {
		//确保任何时刻只有一个线程能够进入临界区
		bankLock.lock();

		//临界区
		try {
			if (accounts[from] < amount) sufficientFounds.await();
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

			sufficientFounds.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//无论是否发生异常都会释放锁(不能使用try-with-resources语句)
			bankLock.unlock();
		}
	}
	
	/**
	 * Get the sum of all account balance
	 * @return the total balance
	 */
	public double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for(double a : accounts){
				sum += a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}
	
	/**
	 * Gets the number of accounts in the bank
	 * @return the number of accounts;
	 */
	public int size() {
		return accounts.length;
	}
	
}
