package day01;

/**
 * 买票窗口类(线程类)
 */
public class TicketWin extends Thread {
    private int tickets = 100;//票

    public TicketWin(){

    }
    public TicketWin(String name){
        super(name);
    }

    @Override
    public void run() {
        //卖票功能
        while (true) {
            if (tickets <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "卖了第" + (101-tickets) + "张票");
            tickets--;
        }

    }
}
