package day02;

/**
 * ʵ���ĸ����ڹ���100��Ʊ
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Ticket();
        //2�����̶߳���
        Thread thread1 = new Thread(runnable,"����1");
        Thread thread2 = new Thread(runnable,"����2");
        Thread thread3 = new Thread(runnable,"����3");
        Thread thread4 = new Thread(runnable,"����4");
        //�����߳�
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
