package day01;

/**
 * ��Ʊ������(�߳���)
 */
public class TicketWin extends Thread {
    private int tickets = 100;//Ʊ

    public TicketWin(){

    }
    public TicketWin(String name){
        super(name);
    }

    @Override
    public void run() {
        //��Ʊ����
        while (true) {
            if (tickets <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "���˵�" + (101-tickets) + "��Ʊ");
            tickets--;
        }

    }
}
