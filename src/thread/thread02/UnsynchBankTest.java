package thread.thread02;



public class UnsynchBankTest {

	//账户数量
	public static final int	NACCOUNT = 100;
	//初始化余额
	public static final double INITIAL_BALANCE = 1000;
	//最高金额
	public static final double MAX_AMOUNT = 1000;
	//延迟
	public static final	int DELAY = 10;
	
	public static void main(String[] args) {
		
		Bank bank = new Bank(NACCOUNT,INITIAL_BALANCE);
		for(int i = 0; i < NACCOUNT; i++) {
			int fromAccount = i;
			Runnable r = () -> {
				try {
					while(true) {
						int toAccount = (int) (bank.size() * Math.random());
						double amount = MAX_AMOUNT * Math.random();
						bank.transfer(fromAccount, toAccount, amount);
						Thread.sleep((int) (DELAY * Math.random()));
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			};
			var t = new Thread(r);
			t.start();
		}

	}
}
