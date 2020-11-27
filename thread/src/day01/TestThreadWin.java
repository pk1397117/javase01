package day01;

public class TestThreadWin {
    public static void main(String[] args) {
        //创建四个窗口
        TicketWin w1 = new TicketWin("窗口1");
        TicketWin w2 = new TicketWin("窗口2");
        TicketWin w3 = new TicketWin("窗口3");
        TicketWin w4 = new TicketWin("窗口4");
        //启动四个窗口
        w1.start();
        w2.start();
        w3.start();
        w4.start();

    }
}
