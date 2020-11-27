package thread.thread07;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Demo01 {

    private static final int length = 26;

    private static final BlockingQueue<Character> strings = new ArrayBlockingQueue<>(length);

    public static void main(String[] args) throws Exception {

//        Class<ArrayBlockingQueue> clazz = ArrayBlockingQueue.class;
//        Field capacity = clazz.getDeclaredField("items");
//        capacity.setAccessible(true);
//        Object[] objects = (Object[]) capacity.get(strings);
//        int length = objects.length;
//        System.out.println("length: "+length);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<length; i++){
                    try {
                        strings.put((char)(i+65));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t1.join();

        System.out.println(strings);
        System.out.println(strings.peek());
    }
}
