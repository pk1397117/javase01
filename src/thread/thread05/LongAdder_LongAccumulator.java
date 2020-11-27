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
            //join�������߳�֪���������߳�ִ�����
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //����˯��ʱ��ȴ������߳�ִ�����
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //�����߳����֮��������ܺ͵�ֵ
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
                //�������̵߳ȴ��߳�ִ�����
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long all = accumulator.get();
        System.out.println(all);
    }
}
