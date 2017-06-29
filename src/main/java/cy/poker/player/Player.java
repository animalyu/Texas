package main.java.cy.poker.player;

import main.java.cy.poker.chip.Chip;
import main.java.cy.poker.chip.Chips;
import main.java.cy.poker.deck.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anima on 2017/3/27.
 */
public class Player {
    protected List<Card> cards = new ArrayList<Card>();
    protected String playerName;

    /*
    Construct with @Chips.
     */
    public Player(String name) {
        playerName = name;
    }

    /*
    Check if this player lost the game.
     */
    public Boolean isDefeat() { return false; }

    /*
    Give this player card.
     */
    public void giveCard(Card newCard) {
        cards.add(newCard);
    }

    /*
    Return the cards information of this player
     */
    public List<Card> getCards() {
        return cards;
    }

    /*
    Return the name of the player.
     */
    public String getName() {
        return playerName;
    }
}
