package day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * �����Ů���ѹ���һ�����п��������д�Ǯ����Ů���Ѵӿ���ȡǮ
 */
public class Test02 {

    public static void main(String[] args) {
        BankCard bankCard = new BankCard();

        Runnable r1 = () -> {
            while (true) {
                bankCard.saveMoney(Math.random()*100);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = () -> {
            while (true) {
                bankCard.withdrawMoney(Math.random()*100);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread save = new Thread(r1);
        Thread withdraw = new Thread(r2);
        save.start();
        withdraw.start();


    }

}
