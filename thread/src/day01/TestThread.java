package day01;

public class TestThread {
    public static void main(String[] args) {
        //1创建线程对象
        MyThread myThread1 = new MyThread("我的子线程1");
        //修改线程吗名称
        //myThread1.setName("我的子线程1");
        //2启动线程,不能调用run方法
        myThread1.start();

        MyThread myThread2 = new MyThread("我的子线程2");
        //myThread2.setName("我的子线程2");
        myThread2.start();

        for (int i = 0;i<50;i++){
            System.out.println("主线程============"+i);
        }
    }
}
