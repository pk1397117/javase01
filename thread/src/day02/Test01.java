package day02;

/**
 * 实现四个窗口共卖100张票
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Ticket();
        //2创建线程对象
        Thread thread1 = new Thread(runnable,"窗口1");
        Thread thread2 = new Thread(runnable,"窗口2");
        Thread thread3 = new Thread(runnable,"窗口3");
        Thread thread4 = new Thread(runnable,"窗口4");
        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(Ticket.getTickets());
    }
}
