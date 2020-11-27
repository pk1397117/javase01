package thread.thread01;

public class Thread04 {

    public static void main(String[] args) {

        Runnable r = () -> {
            System.out.println("��ǰ�߳�head��"+Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Thread.currentThread().isInterrupted()){
                System.out.println("�߳��ж�");
            }
            System.out.println("��ǰ�߳�tail��"+Thread.currentThread());
        };
        Thread t1 = new Thread(r){{setName("�߳�1");setPriority(4);}};//Priority(���ȼ�,Ĭ�ϻ�̳й���ö�����̵߳����ȼ�������ö�������߳�Ĭ�����ȼ�Ϊ5)
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());

    }
}
