package com.progressoft.induction;

import java.math.BigDecimal;

public class Money {
    public static Money ZERO = new Money(BigDecimal.valueOf(0));
    public static Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static Money HALF_DINAR = new Money(BigDecimal.valueOf(0.5));
    public static Money DINAR = new Money(BigDecimal.valueOf(1.0));
    public BigDecimal pocket;

    public Money(double money) {
        this.pocket = BigDecimal.valueOf(money);
    }

    public Money(BigDecimal money) {
        this.pocket = money;
    }

    public Money(Money money) {
        this.pocket = money.get();
    }

    public Money add(Money money) {

        this.pocket.add(money.get());
        return new Money(this.pocket);
    }

    public Money subtract(Money money) {
        this.pocket.subtract(money.get());
        return new Money(this.pocket);
    }

    public BigDecimal get() {
        return this.pocket;
    }

    public boolean isLessThan(Money money) {
        if (this.pocket.compareTo(money.get()) == -1) {
            return true;
        } else {
            return false;
        }
    }
}
