package thread.thread04;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

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

	//lock对象
	private Object lock = new Object();
	/**
	 * Constructs the bank
	 * @param n the number of accounts
	 * @param initialBalance initial balance with each account
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		//将初始化余额赋值给账户数组的每一个元素
		Arrays.fill(accounts, initialBalance);

	}
	
	/**
	 * Transfer(转移)  money from one account to another
	 * @param from the account to transfer from
	 * @param to the account to transfer to
	 * @param amount(金额) the amount to transfer 
	 */
	public void transfer(int from, int to, double amount) throws InterruptedException {
		System.out.print(Thread.currentThread());
		synchronized (lock){
			while (accounts[from] < amount) lock.wait();

			accounts[from] -= amount;
			accounts[to] += amount;

			lock.notifyAll();
		}
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	}
	
	/**
	 * Get the sum of all account balance
	 * @return the total balance
	 */
	public synchronized double getTotalBalance() {
		double sum = 0;
		for(double a : accounts){
			sum += a;
		}
		return sum;
	}
	
	/**
	 * Gets the number of accounts in the bank
	 * @return the number of accounts;
	 */
	public int size() {
		return accounts.length;
	}
	
}
