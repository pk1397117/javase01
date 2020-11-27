package thread.thread01;

public class Thread04 {

    public static void main(String[] args) {

        Runnable r = () -> {
            System.out.println("当前线程head："+Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Thread.currentThread().isInterrupted()){
                System.out.println("线程中断");
            }
            System.out.println("当前线程tail："+Thread.currentThread());
        };
        Thread t1 = new Thread(r){{setName("线程1");setPriority(4);}};//Priority(优先级,默认会继承构造该对象的线程的优先级，构造该对象的主线程默认优先级为5)
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());

    }
}
