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
	//������
	private Lock bankLock;

	//��������(������ʽ�)
	private Condition sufficientFounds;
	/**
	 * Constructs the bank
	 * @param n the number of accounts
	 * @param initialBalance initial balance with each account
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		//����ʼ����ֵ���˻������ÿһ��Ԫ��
		Arrays.fill(accounts, initialBalance);
	}
	
	/**
	 * Transfer(ת��)  money from one account to another
	 * @param from the account to transfer from
	 * @param to the account to transfer to
	 * @param amount(���) the amount to transfer 
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
