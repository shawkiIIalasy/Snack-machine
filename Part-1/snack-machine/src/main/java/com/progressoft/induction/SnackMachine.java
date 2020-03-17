package com.progressoft.induction;
import java.math.BigDecimal;

public class SnackMachine {
    public static final double DEFAULT_QUANTITY = 10;
    private Money money;
    private Money moneyTransaction;
    private Snack chips;
    private Snack chocolates;
    private Snack chewingGums;

    public SnackMachine() {
        money = new Money(Money.ZERO);
        moneyTransaction = new Money(Money.ZERO);
        this.chewingGums = new Snack(SnackType.CHEWING_GUM, DEFAULT_QUANTITY);
        this.chips = new Snack(SnackType.CHIPS, DEFAULT_QUANTITY);
        this.chocolates = new Snack(SnackType.CHOCOLATE, DEFAULT_QUANTITY);
    }

    public Money moneyInside() {
        return this.money;
    }

    public Money moneyInTransaction() {
        return this.moneyTransaction;
    }

    public void insertMoney(Money money) {
        if (moneyTransaction.checkUnit(money) && moneyTransaction.checkCapacity(money)) {
            moneyTransaction.add(money);
        } else {
            throw new IllegalArgumentException(); // throwing the exception
        }

    }

    public void insertMoney(double money) {
        if (moneyTransaction.checkUnit(money) && money > 0) {
            moneyTransaction.add(new Money(money));
        } else {
            throw new IllegalArgumentException(); // throwing the exception
        }
    }

    public Snack chewingGums() {
        return chewingGums;
    }

    public Snack chips() {
        return chips;
    }

    public Snack chocolates() {
        return chocolates;
    }

    public Money buySnack(SnackType snackType) {
        if (moneyTransaction.isLessThan(Money.ZERO)) {
            throw new IllegalStateException();
        }
        switch (snackType) {
            case CHIPS:
                if (!moneyTransaction.isLessThan(Money.DINAR)) {
                    moneyTransaction.subtract(Money.DINAR);
                    money.add(Money.DINAR);
                    chips.decrease();
                } else {
                    throw new IllegalArgumentException();
                }
                break;
            case CHOCOLATE:
                if (!moneyTransaction.isLessThan(new Money(BigDecimal.valueOf(2.0)))) {
                    moneyTransaction.subtract(new Money(BigDecimal.valueOf(2.0)));
                    money.add(new Money(BigDecimal.valueOf(2.0)));
                    chocolates.decrease();
                } else {
                    throw new IllegalArgumentException();
                }
                break;
            case CHEWING_GUM:
                if (!moneyTransaction.isLessThan(Money.HALF_DINAR)) {
                    moneyTransaction.subtract(Money.HALF_DINAR);
                    money.add(new Money(Money.HALF_DINAR));
                    chewingGums.decrease();
                } else {
                    throw new IllegalArgumentException();
                }
                break;
             default:
                throw new IllegalArgumentException();
         }
        return moneyTransaction;
    }

}
