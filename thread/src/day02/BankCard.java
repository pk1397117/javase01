package day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * ���п�
 */
public class BankCard {
    private static BigDecimal money = new BigDecimal("1000.00");//���

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    public void saveMoney(double amount){
        BigDecimal save = new BigDecimal(new DecimalFormat("0.00").format(amount));
        money = money.add(save);
        System.out.println("����:"+save+"���:"+money);
    }
    public void withdrawMoney(double amount){
        BigDecimal withdraw = new BigDecimal(new DecimalFormat("0.00").format(amount));
        money = money.subtract(withdraw);
        System.out.println("ȡ��:"+withdraw+"���:"+money);
    }
}
