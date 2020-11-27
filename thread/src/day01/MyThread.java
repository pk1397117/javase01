package day01;

/**
 * 线程类
 */
public class MyThread extends Thread {

    public MyThread(){

    }

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //第一种方式
            //this.getId() 获取线程Id
            //this.getName() 获取线程名称
            //System.out.println("线程id"+this.getId()+"线程名称"+this.getName()+"子线程............" + i);

            //第二种方式 Thread.currentThread() 获取当前线程
            System.out.println("线程Id:" + Thread.currentThread().getId() + "线程名称:" + Thread.currentThread().getName() + "子线程............" + i);

        }
    }
}
