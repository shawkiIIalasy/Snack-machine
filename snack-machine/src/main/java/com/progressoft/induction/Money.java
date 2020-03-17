package com.progressoft.induction;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Money {
    public static Money ZERO = new Money(BigDecimal.valueOf(0));
    public static Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static Money HALF_DINAR = new Money(BigDecimal.valueOf(0.5));
    public static Money DINAR = new Money(BigDecimal.valueOf(1.0));
    private static HashMap<BigDecimal, Money> units = new HashMap<BigDecimal, Money>() {
        {
            put(BigDecimal.valueOf(0), Money.ZERO);
            put(BigDecimal.valueOf(0.25), Money.QUARTER_DINAR);
            put(BigDecimal.valueOf(1.0), Money.DINAR);
            put(BigDecimal.valueOf(0.5), Money.HALF_DINAR);
            put(BigDecimal.valueOf(5.0), new Money(BigDecimal.valueOf(5.0)));
            put(BigDecimal.valueOf(10.0), new Money(BigDecimal.valueOf(10.0)));
        }
    };
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
        this.pocket = this.pocket.add(money.get());
        return new Money(this.pocket);
    }

    public Money subtract(Money money) {
        this.pocket = this.pocket.subtract(money.get());
        return new Money(this.pocket);
    }

    public BigDecimal get() {
        return this.pocket;
    }

    public boolean isLessThan(Money money) {
        return this.pocket.compareTo(money.get()) < 0;
    }

    public boolean checkUnit(Money money) {
        return (units.containsKey(money.get()));
    }

    public boolean checkUnit(double money) {
        return (units.containsKey(BigDecimal.valueOf(money)));
    }
}
