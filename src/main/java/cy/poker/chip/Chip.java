package main.java.cy.poker.chip;

/**
 * Created by anima on 2017/3/26.
 */
public class Chip {
    private final int value;
    private int quantity;

    /*
    Constructor for value & quantity.
     */
    public Chip(int chipValue, int chipQuantity) {
        value = chipValue;
        quantity = chipQuantity;
    }

    /*
    Return the value of this chip.
     */
    public final int getValue() {
        return value;
    }

    /*
    Return the amount of this type of chips.
     */
    public final int getAmount() {
        return value*quantity;
    }

    /*
    Return the quantity of chips.
     */
    public final int getQuantity() {
        return quantity;
    }

    /*
    Remove @number of chips.
     */
    public final void remove(int number) throws Exception {
        if (number <= quantity)
            quantity -= number;
        else
            throw new Exception("You don't have such number of chips.");
    }
}
