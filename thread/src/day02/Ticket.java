package day02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ʊ��(������Դ)
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
            System.out.println(Thread.currentThread().getName() + "���˵�" + tickets.incrementAndGet() + "��Ʊ");
        }
    }
}
