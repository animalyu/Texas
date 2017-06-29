package main.java.cy.poker.Texas;

import main.java.cy.poker.Texas.DeckTexas;
import main.java.cy.poker.deck.Card;

import java.util.Random;

/**
 * Created by anima on 2017/4/3.
 */
public class SubDeckTexas extends DeckTexas {
    public SubDeckTexas(Card[] subCards) {
        cardNumber -= subCards.length;
        Card[] newDeck = new Card[cardNumber];

        Boolean isSame = false;
        int count = 0;
        for (int i = 0; i < 52; i++) {
            isSame = false;
            for (int j = 0; j < subCards.length; j++) {
                if (cards[i].isSame(subCards[j])) {
                    isSame = true;
                    break;
                }
            }
            if (!isSame)
                newDeck[count++] = cards[i];
        }
        cards = newDeck.clone();
    }
}
