package day01;

public class TestRunnableWin {
    public static void main(String[] args) {
        //1创建MyRunnable对象，表示线程要执行的功能
        //MyRunnable runnable = new MyRunnable();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    System.out.println(Thread.currentThread().getName()+"卖了第"+i+"张票");
                }
            }
        };
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



    }
}
