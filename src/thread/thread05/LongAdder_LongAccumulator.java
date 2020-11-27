package thread.thread05;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdder_LongAccumulator {

    public static void main(String[] args) {

        LongAdder adder = new LongAdder();
        for (int n = 0; n<5; n++){
            Runnable r = () -> {
                adder.increment();
            };
            Thread t = new Thread(r);
            t.start();
            //join阻塞主线程知道所有子线程执行完毕
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //增加睡眠时间等待所有线程执行完毕
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //所有线程完成之后才能求总和的值
        long total = adder.sum();
        System.out.println(total);

        System.out.println("---------------------------------");

        LongAccumulator accumulator = new LongAccumulator(Long::sum,1);

        for (int n=0; n<5; n++){
            Runnable r = () -> {
                accumulator.accumulate(1);
            };
            Thread t = new Thread(r);
            t.start();
            try {
                //阻塞主线程等待线程执行完毕
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long all = accumulator.get();
        System.out.println(all);
    }
}
