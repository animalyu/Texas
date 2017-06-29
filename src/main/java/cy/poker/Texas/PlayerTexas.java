package main.java.cy.poker.Texas;

import main.java.cy.poker.chip.Chip;
import main.java.cy.poker.chip.Chips;
import main.java.cy.poker.player.Player;

/**
 * Created by anima on 2017/3/27.
 */
public class PlayerTexas extends Player {
    private int playerID;
    protected Chips ownChips;

    public PlayerTexas(String name, int ID) {
        super(name);
        playerID = ID;
    }
    /*
    Check this player is defeat or not.
     */
    public Boolean isDefeat(Chips pot) {
        if (pot.isEmpty() && ownChips.isEmpty())
            return true;
        else
            return false;
    }

    /*
    Give this player chips.
     */
    public final void addChips(Chips newChips) {
        ownChips = newChips;
    }
    /*
    Bet with chips.
    Return the total chips amount left of this player.
     */
    public final int bet(Chips pot, int chipValue, int chipQuantity) throws Exception {
        pot.addChip(new Chip(chipValue, chipQuantity));
        ownChips.removeChip(chipValue, chipQuantity);
        return ownChips.getTotalAmount();
    }

    public final int getID() {
        return playerID;
    }

    public final void rotate() {
        playerID++;
    }

    public final void playerRotateFinalOne() {
        playerID = 0;
    }
}
