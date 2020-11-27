package thread.thread03;

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
	}
	
	/**
	 * Transfer(转移)  money from one account to another
	 * @param from the account to transfer from
	 * @param to the account to transfer to
	 * @param amount(金额) the amount to transfer 
	 */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while(accounts[from] < amount) wait();

		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

		notifyAll();
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
