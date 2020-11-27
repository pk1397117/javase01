package day02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 票类(共享资源)
 */
public class Ticket implements Runnable {

    private static AtomicInteger tickets = new AtomicInteger(0);

    public static AtomicInteger getTickets(){
        return tickets;
    }
    @Override
    public void run() {
        while (true) {
            if (tickets.get() >= 100) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "卖了第" + tickets.incrementAndGet() + "张票");
        }
    }
}
