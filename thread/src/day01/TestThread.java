package day01;

public class TestThread {
    public static void main(String[] args) {
        //1�����̶߳���
        MyThread myThread1 = new MyThread("�ҵ����߳�1");
        //�޸��߳�������
        //myThread1.setName("�ҵ����߳�1");
        //2�����߳�,���ܵ���run����
        myThread1.start();

        MyThread myThread2 = new MyThread("�ҵ����߳�2");
        //myThread2.setName("�ҵ����߳�2");
        myThread2.start();

        for (int i = 0;i<50;i++){
            System.out.println("���߳�============"+i);
        }
    }
}
