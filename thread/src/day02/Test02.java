package day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

/**
 * 你和你女朋友公用一张银行卡，你向卡中存钱，你女朋友从卡中取钱
 */
public class Test02 {

    public static void main(String[] args) {
        BankCard bankCard = new BankCard();

        Runnable r1 = () -> {
            while (true) {
                bankCard.saveMoney(Math.random() * 100);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = () -> {
            while (true) {
                bankCard.withdrawMoney(Math.random() * 100);
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
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2))
            {
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "" +y + "" +k);

    }


}
