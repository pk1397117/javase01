package thread.thread06;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Demo03 {

    public static final Random r = new Random();

    public static final ThreadLocal<Random> localRandom = ThreadLocal.withInitial(() -> new Random());

    public static void main(String[] args) {
        //Random
        int i = r.nextInt(10);
        System.out.println("Random: "+i);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Random r = localRandom.get();
                System.out.println("ThreadLocal: "+r.nextInt(3));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = ThreadLocalRandom.current().nextInt(5);
                System.out.println("ThreadLocalRandom: "+i);
            }
        }).start();

    }
}
