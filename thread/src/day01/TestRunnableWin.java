package day01;

public class TestRunnableWin {
    public static void main(String[] args) {
        //1����MyRunnable���󣬱�ʾ�߳�Ҫִ�еĹ���
        //MyRunnable runnable = new MyRunnable();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    System.out.println(Thread.currentThread().getName()+"���˵�"+i+"��Ʊ");
                }
            }
        };
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



    }
}
