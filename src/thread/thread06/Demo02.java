package thread.thread06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02 {

    //�ֲ߳̾�����
    public static final ThreadLocal<SimpleDateFormat> localFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //localFormat.get();�������ڵ�ǰ�̵߳�SimpleDateFormatʵ��
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
                //Ϊ����߳�����һ���µ�ֵ
                localFormat.set(new SimpleDateFormat("yyyy-MM-dd"));
                //get(),��һ�ε��ó�ʼ�������ٴε�������ͬһ������
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
