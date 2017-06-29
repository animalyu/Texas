package main.java.cy.poker.chip;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anima on 2017/3/26.
 */
public class Chips {
    private List<Chip> chips = new ArrayList<Chip>();
    private int totalAmount = 0;

    /*
    Add a Chip object to the chips.
     */
    public final int addChip(Chip newChip) {
        chips.add(newChip);
        totalAmount += newChip.getAmount();
        return totalAmount;
    }

    /*
    Search & remove the chosen Chip in @chips.
    Return the total amount of @chips.
     */
    public final int removeChip(int chipValue, int chipQuantity) throws Exception {
        for(int i = 0; i < chips.size(); i++) {
            if(chips.get(i).getValue() == chipValue) {
                chips.get(i).remove(chipQuantity);
                totalAmount -= chipQuantity*chipValue;
                return totalAmount;
            }
        }
        throw new Exception("Could not find Chip with value of " + chipValue + ".");
    }

    /*
    Return the total amount of @chips.
     */
    public final int getTotalAmount() {
        return totalAmount;
    }

    /*
    If the chips are empty, return true.
    Else, return false.
     */
    public final Boolean isEmpty() {
        if(totalAmount == 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        for(int i = 0; i < chips.size(); i++) {
            System.out.println("Chip value: " + chips.get(i).getValue() + ", Chip quantity: " + chips.get(i).getQuantity());
        }
        return "The total amount: " + totalAmount;
    }
}
