package day01;

public class TestThreadWin {
    public static void main(String[] args) {
        //�����ĸ�����
        TicketWin w1 = new TicketWin("����1");
        TicketWin w2 = new TicketWin("����2");
        TicketWin w3 = new TicketWin("����3");
        TicketWin w4 = new TicketWin("����4");
        //�����ĸ�����
        w1.start();
        w2.start();
        w3.start();
        w4.start();

    }
}
