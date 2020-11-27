package thread.thread05;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicDemo01 {

    public static AtomicLong nextNumber = new AtomicLong();

    public static void main(String[] args) {

        Long id = nextNumber.incrementAndGet();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber.incrementAndGet());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber.incrementAndGet());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber.compareAndSet(3,8));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber.updateAndGet(value -> {
                    return value + 3;
                }));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(nextNumber.accumulateAndGet(12,Math::max));//原值为第一个参数，给定值x为第二个参数
            }
        }).start();
    }
}
