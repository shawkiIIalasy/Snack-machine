package com.progressoft.induction;
public class Snack {
    SnackType snackType;
    private double quantity = 0;

    public Snack(SnackType snackType, double quantity) {
        this.snackType = snackType;
        this.quantity = quantity;
    }

    public double quantity() {
        return this.quantity;
    }

    public void decrease() {
        if (this.quantity <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.quantity--;
        }
    }

}
