package com.progressoft.induction;

import java.math.BigDecimal;

public class SnackMachine {
    public static final double DEFAULT_QUANTITY=10;
    private Money money;
    private Money moneyTransaction;
    private Snack chips;
    private Snack chocolates;
    private Snack chewingGums;

    public SnackMachine() {
        money = new Money(Money.ZERO);
        moneyTransaction = new Money(Money.ZERO);
        this.chewingGums=new Snack(SnackType.CHEWING_GUM,DEFAULT_QUANTITY);
        this.chips=new Snack(SnackType.CHIPS,DEFAULT_QUANTITY);
        this.chocolates=new Snack(SnackType.CHOCOLATE,DEFAULT_QUANTITY);
    }

    public BigDecimal moneyInside() {
        return money.get();
    }

    public Money moneyInTransaction() {
        return new Money(moneyTransaction.get());
    }

    public void insertMoney(Money money) {
        if (money != null) {
            moneyTransaction.add(money);
        } else {
            throw new IllegalArgumentException(); // rethrowing the exception
        }

    }
    public void insertMoney(double money)  {
        try {
            moneyTransaction.add(new Money(money));
        } catch (IllegalArgumentException e){
            throw e; // rethrowing the exception
        }
    }
    public Snack chewingGums()
    {
        return chewingGums;
    }
    public Snack chips()
    {
        return chips;
    }
    public Snack chocolates()
    {
        return chips;
    }
    public Money buySnack(SnackType snackType)
    {
        BigDecimal moneyT=moneyTransaction.get();
        if(moneyT.compareTo(BigDecimal.valueOf(0))==-1)
        {
            throw new IllegalStateException();
        }
        switch (snackType)
        {
            case CHIPS:
                if(moneyT.compareTo(BigDecimal.valueOf(1.0))>=0)
                {
                    moneyTransaction.subtract(new Money(BigDecimal.valueOf(1.0)));
                    money.add(new Money(BigDecimal.valueOf(1.0)));
                    chips.decrease();
                }else{
                    throw new IllegalArgumentException();
                }
                break;
            case CHOCOLATE:
                if(moneyT.compareTo(BigDecimal.valueOf(2.0))>=0)
                {
                    moneyTransaction.subtract(new Money(BigDecimal.valueOf(2.0)));
                    money.add(new Money(BigDecimal.valueOf(2.0)));
                    chips.decrease();
                }else{
                    throw new IllegalArgumentException();
                }
                break;
            case CHEWING_GUM:
                if(moneyT.compareTo(BigDecimal.valueOf(0.5))>=0)
                {
                    moneyTransaction.subtract(new Money(BigDecimal.valueOf(0.5)));
                    money.add(new Money(BigDecimal.valueOf(0.5)));
                    chips.decrease();
                }else{
                    throw new IllegalArgumentException();
                }
                break;
        }
        return moneyTransaction;
    }

}
