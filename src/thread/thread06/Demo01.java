package thread.thread06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        String date = Demo01.dateFormat.format(new Date());
        System.out.println(date);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = dateFormat.format(new Date());
                System.out.println(date);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = dateFormat.format(new Date());
                System.out.println(date);
            }
        }).start();
    }
}

