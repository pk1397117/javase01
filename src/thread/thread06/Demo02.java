package thread.thread06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02 {

    //线程局部变量
    public static final ThreadLocal<SimpleDateFormat> localFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //localFormat.get();返回属于当前线程的SimpleDateFormat实例
                SimpleDateFormat dateFormat = localFormat.get();
                String date1 = dateFormat.format(new Date());
                String date2 = dateFormat.format(new Date());
                System.out.println(date1);
                System.out.println(date2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //为这个线程设置一个新的值
                localFormat.set(new SimpleDateFormat("yyyy-MM-dd"));
                //get(),第一次调用初始化对象，再次调用引用同一个对象
                SimpleDateFormat dateFormat = localFormat.get();
                SimpleDateFormat dateFormat1 = localFormat.get();
                System.out.println(dateFormat==dateFormat1);//true
                String date1 = dateFormat.format(new Date());
                String date2 = dateFormat.format(new Date());
                System.out.println(date1);
                System.out.println(date2);
            }
        }).start();
    }
}
