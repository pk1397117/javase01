package day01;

/**
 * �߳���
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
            //��һ�ַ�ʽ
            //this.getId() ��ȡ�߳�Id
            //this.getName() ��ȡ�߳�����
            //System.out.println("�߳�id"+this.getId()+"�߳�����"+this.getName()+"���߳�............" + i);

            //�ڶ��ַ�ʽ Thread.currentThread() ��ȡ��ǰ�߳�
            System.out.println("�߳�Id:" + Thread.currentThread().getId() + "�߳�����:" + Thread.currentThread().getName() + "���߳�............" + i);

        }
    }
}
