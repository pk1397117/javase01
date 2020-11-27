package day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 银行卡
 */
public class BankCard {
    private static BigDecimal money = new BigDecimal("1000.00");//余额

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    public void saveMoney(double amount){
        BigDecimal save = new BigDecimal(new DecimalFormat("0.00").format(amount));
        money = money.add(save);
        System.out.println("存入:"+save+"余额:"+money);
    }
    public void withdrawMoney(double amount){
        BigDecimal withdraw = new BigDecimal(new DecimalFormat("0.00").format(amount));
        money = money.subtract(withdraw);
        System.out.println("取出:"+withdraw+"余额:"+money);
    }
}
